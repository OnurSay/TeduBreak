import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

@SuppressWarnings("serial")
public class Walls extends JPanel {

	private int wall;
	KeyDirection position;
	private int[][] maze = new int[500][500];

	public Walls() {

		this.position = new KeyDirection();

	}

	public void paint(Graphics g) {

		Graphics2D grap = (Graphics2D) g;
		Image img = Toolkit.getDefaultToolkit().createImage("clear.jpg");
		grap.drawImage(img, 0, 0, null);

		g.fillRect(50, 0, 30, 300);
		g.fillRect(125, 150, 30, 400);

	}

	public boolean Maze() {

		for (int i = 51; i <= 80; i++) {

			for (int j = 1; j <= 300; j++) {

				maze[i][j] = wall;
				if (maze[i][j] == maze[this.position.x][this.position.y]) {
					this.position.prisonKey = true;
				} else
					this.position.prisonKey = false;
			}
		}
		for (int m = 126; m <= 155; m++) {

			for (int n = 151; n <= 300; n++) {

				maze[m][n] = wall;
				if (maze[m][n] == maze[this.position.x][this.position.y]) {
					this.position.prisonKey = true;
				} else
					this.position.prisonKey = false;
			}
		}

		return this.position.prisonKey;

	}

	public boolean wallBoolean(boolean empty) {
		empty = !this.position.prisonKey;

		if (this.position.prisonKey = false) {

			return this.position.prisonKey;
		} else
			return empty;
	}

}