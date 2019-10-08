import java.util.ArrayList;

/**
 * 玩家
 */
public class Player implements Runnable{
	private ArrayList<Brand> data = new ArrayList<Brand>();

	private Poker poker;
	private String name;
	private int playernum;
	private int cardNumCount = 0;
	
	public Player(Poker poker, String name,int playernum) {
		this.poker = poker;
		this.name = name;
		this.playernum = playernum;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (poker) {
				//胜负已分或者越界则停止发牌
				if (poker.isexit || poker.getIndex() > 50) {
					System.out.println(this.name + ":" + this.data);
					break;
				}

				if (poker.getPlayer() == this.playernum) {
					//获取到该摸第几张牌
					int index = poker.getIndex();
					//摸牌
					Brand thisbrand = Poker.getPoker().get(index);
					//计算当前手牌总值
					cardNumCount += thisbrand.getNum();
					System.out.println(this.name + "摸了一张" + thisbrand + "，当前总值：" + cardNumCount);

					//放入手牌，可以省略
					data.add(Poker.getPoker().get(index));

					//判断手牌总值是否已经满足设定阀值
					if (cardNumCount >= poker.getThreshold()){
						poker.setIsexit(true);
						System.out.println(this.name +"首个达到阀值，当前手牌总值为："+cardNumCount);
					}

					//告诉第二个线程进行摸牌
					poker.setPlayer(this.playernum == 3 ? 1 : this.playernum+1);
					poker.setIndex(index + 1);
				}
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
