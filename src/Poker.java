import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 一副 扑克牌
 */
public class Poker {
	// 定义集合,存储扑克
	private static List<Brand> poker = new ArrayList<Brand>();
	//区分玩家，即线程
	private int player = (int)(Math.random() * 3 + 1);
	//取牌索引
	private int index = 0;

	private static Brand[][] playingCard =new Brand[5][13];

	private static String[] labelAry = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	//统计阀值
	public int threshold = 0;
	//是否停止摸牌
	public boolean isexit = false;

	public Poker(int threshold) {
		this.threshold = threshold;
	}



	public static void createPlayingCard() {
		//四种花色
		for (int i = 0; i < playingCard.length - 1; i++) {
			for (int j = 0; j < playingCard[i].length; j++) {
				switch (i) {
					case 0:
						poker.add(new Brand(Type.RED,Integer.valueOf(j+1),labelAry[j]));
						break;
					case 1:
						poker.add(new Brand(Type.BLACK,Integer.valueOf(j+1),labelAry[j]));
						break;
					case 2:
						poker.add(new Brand(Type.PLUM,Integer.valueOf(j+1),labelAry[j]));
						break;
					case 3:
						poker.add(new Brand(Type.SQUARE,Integer.valueOf(j+1),labelAry[j]));
						break;
					default:
						break;
				}
			}
		}
		//大小王
		poker.add(new Brand(Type.GHOST, 20, "red"));
		poker.add(new Brand(Type.GHOST, 20, "black"));
		System.out.println(poker);
	}

	// 洗牌
	public static void shuffle() {
		Collections.shuffle(poker);
		System.out.println(poker);
	}

	public static List<Brand> getPoker() {
		return poker;
	}

	public static void setPoker(List<Brand> poker) {
		Poker.poker = poker;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public boolean isIsexit() {
		return isexit;
	}

	public void setIsexit(boolean isexit) {
		this.isexit = isexit;
	}
}
