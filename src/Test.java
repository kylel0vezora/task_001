public class Test {
	public static void main(String[] args) throws InterruptedException {
		Poker poker = new Poker(50);
		
		Poker.createPlayingCard(); //制作牌
		Poker.shuffle(); //洗牌
		
		Player p1 = new Player(poker, "jack",1);
		Player p2 = new Player(poker, "tom",2);
		Player p3 = new Player(poker, "jerry",3);
		
		Thread pp1 = new Thread(p1);
		Thread pp2 = new Thread(p2);
		Thread pp3 = new Thread(p3);
		
		pp1.start();
		pp2.start();
		pp3.start();
	}
}
