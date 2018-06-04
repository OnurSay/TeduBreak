
@SuppressWarnings("serial")
public class Collision extends KeyDirection {
	KeyDirection keydir = new KeyDirection();
	Coordinate cor = new Coordinate(0, 0);
	public boolean b;

	public void checkCollision() {
		System.out.println(police1X + " POLISPOLIS " + police1Y);

		if ((cor.getX() > keydir.police1X && cor.getX() + 100 < keydir.police1X)
				&& (cor.getY() > keydir.police1Y && cor.getY() < keydir.police1Y)) {
			System.out.println("b true oldu");
			b = true;

		}
		collisionMaker();

	}

	private void collisionMaker() {
		// TODO Auto-generated method stub
		if (b = true) {
			System.out.println("collision oldu");
			keydir.x = 15;
			keydir.y = 5;
		}
	}
}
