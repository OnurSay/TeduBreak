import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.ImageIcon;
import javax.swing.text.Position;

@SuppressWarnings("serial")
public class Enemy extends KeyDirection {
	public Coordinate Position;
	public Coordinate PatrolStart;
	public Coordinate PatrolEnd;
	public Boolean direction; // true going, false coming
	public Boolean LooseChecker = false;
	Image enemy;
	public static int life = 3;
	public Shape Sight;
	public Image enemyarka;
	public Image enemyon;
	

	public Enemy(int i, int j, Image on, Image arka) {
		this.Position = new Coordinate(i, j);
		this.PatrolStart = new Coordinate(i, j);

		this.PatrolEnd = new Coordinate(0, 0);

		this.enemyon = on;
		this.enemyarka = arka;

	}

	public void setPatrol(Coordinate start, Coordinate end) {
		this.PatrolStart = start;
		this.PatrolEnd = end;
		this.direction = true;
	}

	public void patrol(int speed) {

		this.Position.moveTo(PatrolEnd, speed);

		if (this.Position.equals(this.PatrolEnd)) {

			Coordinate temp = PatrolStart;
			PatrolStart = PatrolEnd;
			PatrolEnd = temp;

			this.direction = !this.direction;

		}
		

	}

	public void paintComponent(Graphics g) {

		Graphics2D grap = (Graphics2D) g;
		grap.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	}

	public void detectPlayer(Coordinate playerCoordinate, int sight, Graphics2D grap) {
		Graphics2D grap2 = (Graphics2D) grap;
		if (this.Position.getDistance(playerCoordinate) < sight) {
			
			check = false;
			check2 = false;
			check3 = false;
			check4 = false;
			check5 = false;
			check6 = false;
			
			KeyDirection.x = 15;
			KeyDirection.y = 5;

			if (life == 1) {

				playerCoordinate = this.Position;
				this.Position.setX(5);
				this.Position.setY(15);

				PatrolStart = (new Coordinate(5, 15));
				PatrolEnd = (new Coordinate(5, 15));
				patrol(0);
				z = 0;

			}
			
			life--;

		}

	}

	public void detectDoor(Coordinate playerCoordinate, int sight, Graphics2D grap) {

		if (this.Position.getDistance(playerCoordinate) < sight) {
			winCheck = true;
			Main.close();		
			Main2.main();
			KeyDirection.x = 15;
			KeyDirection.y = 5;
			
			sight = 0;

			

		}

	}
}