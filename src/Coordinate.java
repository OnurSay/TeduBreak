public class Coordinate {
	private int x;
	private int y;

	public Coordinate(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return this.x;
	}

	public void setX(int newX) {
		this.x = newX;
		
	}

	public int getY() {
		return y;
	}

	public void setY(int newY) {
		this.y = newY;
	}

	// public void move(int x, int y) {
	// this.x += x;
	// this.y += y;
	// }

	public void moveTo(Coordinate destination, int speed) {

//		 System.out.println("Moving to " + destination + " from " + this.x +" "+ this.y + " with speed " + speed);
//		System.out.println(this.x);
		if (this.x < destination.x) {
			this.x += speed;
		} else if(this.x > destination.x) {
			this.x -= speed;
		} else if (this.x == destination.x){
			this.x = destination.x;
		}
//
		if (this.y < destination.y) {
			this.y += speed;
		} else if (this.y > destination.y){
			this.y -= speed;

		}else if (this.y == destination.y){
			this.y = destination.y;
		}
		
	}

	public double getDistance(Coordinate o) {

		return Math.sqrt((Math.pow((o.x - this.x), 2) + Math.pow((o.y - this.y), 2)));

	}

	public Boolean equals(Coordinate o) {
		// o < this = -1
		// o == this = 0
		// o > this = 1

		return this.x == o.x & this.y == o.y;

	}

	public Coordinate get() {
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x + " " + y;
	}
}