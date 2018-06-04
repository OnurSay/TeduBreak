import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

@SuppressWarnings("serial")
public class Replay extends JPanel implements ActionListener, KeyListener {

	Timer times = new Timer(1, this);

	public static int x = 15;
	public static int y = 5;
	public int movx = 0;
	public int movy = 0;
	public int police1X;
	public int police1Y;
	public int police2X = 0;
	public int police2Y = 0;
	public static boolean check = false;
	public static boolean check2 = false;
	public static boolean check3 = false;
	public static boolean check4 = false;
	public static boolean check5 = false;
	public static boolean check6 = false;
	public boolean prisonKey = false;
	public static boolean winCheck = false;
	public static boolean removeComplated = false;
	public static int z = 10;
	private int lastY = 0;
	private int last1Y = 0;
	private int last2Y = 0;
	public int policeSpeed = 1;
	public int policeSpeed2 = 1;
	public int policeSpeed3 = 1;
	public Image polis1on = new ImageIcon("images/polices.png").getImage();
	public Image polis1arka = new ImageIcon("images/polArka.png").getImage();
	public Image prisoner = new ImageIcon("images/Prisoner.png").getImage();
	public Image polis2on = new ImageIcon("images/karaPolis.png").getImage();
	public Image polis2arka = new ImageIcon("images/karArka.png").getImage();
	public Image polis3sol = new ImageIcon("images/pol3Sol.png").getImage();
	public Image polis3sag = new ImageIcon("images/pol3Sag.png").getImage();
	public Image dog = new ImageIcon("images/dogSleep.gif").getImage();
	public Image door = new ImageIcon("images/door.png").getImage();
	public Image polis4on = new ImageIcon("images/polis4on.png").getImage();
	public Image polis4arka = new ImageIcon("images/polis4arka.png").getImage();
	public Image hearth = new ImageIcon("images/hearth.png").getImage();
	public Image hearth2 = new ImageIcon("images/hearth.png").getImage();
	public Image hearth3 = new ImageIcon("images/hearth.png").getImage();
	public Image empty = new ImageIcon("images/empty.png").getImage();
	public Image empty2 = new ImageIcon("images/empty2.png").getImage();
	public Image empty3 = new ImageIcon("images/empty3.png").getImage();
	public Image winDoor = new ImageIcon("images/win.gif").getImage();
	public Image Loose = new ImageIcon("images/end.gif").getImage();
	public Image a = new ImageIcon().getImage();
	public Image a2 = new ImageIcon().getImage();
	public Image a3 = new ImageIcon().getImage();

	// public Image prisoner = new ImageIcon("images/Prisoner.png").getImage();

	public ArrayList<Enemy> EnemyList = new ArrayList<>();
	Boolean init = true;

	public Replay() {
		setBackground(Color.gray);

		times.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
	}

	public int getXx() {
		return x;
	}

	public int getYy() {
		return y;
	}

	public boolean getPrisonKey() {
		return prisonKey;
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D grap = (Graphics2D) g;
		Graphics2D grap2 = (Graphics2D) g;
		Graphics2D g2 = (Graphics2D) g;
		Graphics2D grap3 = (Graphics2D) g;

		Graphics2D grap4 = (Graphics2D) g;
		Graphics2D grap5 = (Graphics2D) g;
		grap.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		grap2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Image Map = new ImageIcon("images/back.png").getImage();
		grap2.drawImage(Map, 0, 0, 595, 600, null);

		grap.drawImage(prisoner, x, y, null);
		grap.drawImage(dog, 410, 533, null);

		// grap.fillOval(x, y, 20, 20);
		// grap.setColor(Color.green);
		// grap.fillRect(535, 10, 30, 30);
		// grap.setColor(Color.black);
		// grap.fillRect(50, 0, 50, 500);
		// grap.fillRect(175, 100, 50, 500);
		// grap2.fillRect(500,5000, 10, 10);
		// grap.fillRect(300, 0, 50, 240);
		// grap.setColor(Color.red);
//		grap.drawLine(100, 0, 100, 800);
//		grap.drawLine(0, 350, 1000, 350);
		// Police1(grap.create());
		// Police2(grap.create());
		// Police3(grap.create());
		Enemy polis1 = new Enemy(102, 0, polis1on, polis1arka);
		Enemy polis2 = new Enemy(270, 320, polis2arka, polis2on);
		Enemy polis3 = new Enemy(583, 70, polis3sol, polis3sag);
		Enemy polis4 = new Enemy(350, 0, polis4on, polis4arka);
		Enemy Win = new Enemy(546, 498, door, door);
		if (init) {

			polis1.setPatrol(new Coordinate(102, 0), new Coordinate(102, 540));
			polis2.setPatrol(new Coordinate(270, 320), new Coordinate(270, 0));
			polis4.setPatrol(new Coordinate(350, 540), new Coordinate(350, 0));
			polis3.setPatrol(new Coordinate(583, 70), new Coordinate(443, 70));
			Win.setPatrol(new Coordinate(546, 498), new Coordinate(546, 498));
			EnemyList.add(polis1);
			EnemyList.add(polis2);
			EnemyList.add(polis3);
			EnemyList.add(polis4);
			EnemyList.add(Win);
			init = false;

		} else {

			for (Enemy enemy : EnemyList) {
				enemy.patrol(10);
				if (Enemy.life <= 3) {
					// System.out.println(Enemy.life);
					grap5.drawImage(a, 500, 0, this);
					grap4.drawImage(a2, 530, 0, this);
					grap3.drawImage(a3, 560, 0, this);

				}

				if (enemy.direction)
					grap.drawImage(enemy.enemyon, enemy.Position.getX(), enemy.Position.getY(), this);
				else if (!enemy.direction)
					grap.drawImage(enemy.enemyarka, enemy.Position.getX(), enemy.Position.getY(), this);
				enemy.detectPlayer(new Coordinate(this.x, this.y), 30, grap);
				
				
				Win.detectDoor(new Coordinate(this.x, this.y), 60, grap);
				
				if(winCheck == true){
					EnemyList.remove(polis1);
					EnemyList.remove(polis2);
					EnemyList.remove(polis3);
					EnemyList.remove(polis4);
					EnemyList.remove(Win);
					removeComplated = true;
				}
			}

		}
		if (Enemy.life <= 0) {
			grap5.drawImage(Loose, 0, 0, null);
			if (x > 100 && x < 250) {
				EnemyList.remove(polis2);
				EnemyList.remove(polis3);
				EnemyList.remove(polis4);
				EnemyList.remove(Win);
			} else if (x > 250 && x < 300) {
				EnemyList.remove(polis1);
				EnemyList.remove(polis3);
				EnemyList.remove(polis4);
				EnemyList.remove(Win);
			} else if (x > 300 && x < 550) {
				EnemyList.remove(polis2);
				EnemyList.remove(polis1);
				EnemyList.remove(polis3);
				EnemyList.remove(Win);
			} else if (x > 550) {
				EnemyList.remove(polis2);
				EnemyList.remove(polis1);
				EnemyList.remove(polis4);
				EnemyList.remove(Win);
			}
			
		}
		print();
	}

	public void print() {
		a = hearth;
		a2 = hearth2;
		a3 = hearth3;
		if (Enemy.life == 2) {
			a = empty;
			a2 = hearth2;
			a3 = hearth3;
		}
		if (Enemy.life == 1) {
			a = empty;
			a2 = empty;
			a3 = hearth;

		}
		if (Enemy.life <= 0) {
			a = empty;
			a2 = empty;
			a3 = empty;

		}

	}

	// public void Police1(Graphics g){
	//
	// }
	//

	// public void Police1(Graphics g) {
	//
	// int h = getHeight();
	//
	// int policeW = 20;
	// int policeH = 20;
	//
	// int y = lastY + policeSpeed;
	//
	// int OvalAx = h / 2 - 185;
	// int OvalBx = h / 2 + 10 - 190;
	// int OvalAy = y + policeH;
	// int OvalBy = y + 10 + policeH;
	// g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	// RenderingHints.VALUE_ANTIALIAS_ON);
	//
	// // g2.setColor(Color.yellow);
	// // g2.fillOval(OvalAx, OvalAy, policeW * 2, policeH * 2);
	// // g2.setColor(Color.blue);
	// // g2.fillOval(OvalBx, OvalBy, policeW, policeH);
	//
	// if (y > 500) {
	// policeSpeed = -1;
	// }
	// if (y < -20) {
	// policeSpeed = 1;
	//
	// }
	// if (policeSpeed == -1) {
	// g2.drawImage(polis1arka, OvalBx, OvalBy, this);
	// } else {
	// g2.drawImage(polis1on, OvalBx, OvalBy, this);
	// }
	//
	// lastY = y;
	// setX(OvalBx);
	// police1Y = OvalBy;
	// System.out.println(police1X + " POLISPOLIS " + police1Y);
	// // PrisonerWins();
	// System.out.println(OvalBx + "," + y);
	// Coordinate cor = new Coordinate(0, 0);
	// System.out.println(this.x + "," + this.y);
	// // if (this.x != 15 && this.y != 5) {
	// cor.setX(this.x);
	// cor.setY(this.y);
	// // System.out.println(this.x+","+this.y);
	// // }
	// new Collision();
	//
	// }

	// public void Police2(Graphics g) {
	// Graphics2D g2 = (Graphics2D) g;
	//
	// int h2 = getHeight();
	//
	// int policeW = 20;
	// int policeH = 20;
	//
	// int yas = last1Y + policeSpeed2;
	//
	// int OvalAx = h2 / 2 - 15;
	// int OvalBx2 = h2 / 2 + 10 - 25;
	// int OvalAy = yas + policeH;
	// int OvalBy2 = 360 - (yas + 10 + policeH);
	// g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	// RenderingHints.VALUE_ANTIALIAS_ON);
	//
	// if (yas > 330) {
	// policeSpeed2 = -1;
	// }
	// if (yas < 0) {
	// policeSpeed2 = 1;
	// }
	// if (policeSpeed2 == -1) {
	// g2.drawImage(polis2on, OvalBx2, OvalBy2, this);
	// } else {
	// g2.drawImage(polis2arka, OvalBx2, OvalBy2, this);
	// }
	//
	// police2X = OvalBx2;
	// police2Y = OvalBy2;
	//
	// last1Y = yas;
	//
	// }
	//
	// public void Police3(Graphics g) {
	// Graphics2D g2 = (Graphics2D) g;
	//
	// int h2 = getHeight();
	//
	// int policeW = 20;
	// int policeH = 20;
	//
	// int yas3 = last2Y + policeSpeed2;
	//
	// int OvalAx = h2 / 2 - 15;
	// int OvalBx3 = (yas3 + 10 + policeH) + 405;
	// int OvalAy = yas3 + policeH;
	// int OvalBy3 = h2 / 2 + 10 - 220;
	// g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	// RenderingHints.VALUE_ANTIALIAS_ON);
	//
	// if (10 - yas3 > -10) {
	// policeSpeed3 = -1;
	// }
	// if (50 - yas3 < -200) {
	// policeSpeed3 = 1;
	// }
	// if (policeSpeed3 == -1) {
	// g2.drawImage(polis3sag, OvalBx3, OvalBy3, this);
	// } else {
	// g2.drawImage(polis3sol, OvalBx3, OvalBy3, this);
	// }
	//
	// police2X = OvalBx3;
	// police2Y = OvalBy3;
	//
	// last2Y = yas3;
	//
	// }

	// public void Police3(Graphics g) {
	// Graphics2D g2 = (Graphics2D) g;
	//
	// int h = getHeight();
	//
	// int policeW = 20;
	// int policeH = 20;
	//
	// int ysa = lastY + policeSpeed;
	//
	// int OvalAx = ysa + policeH;
	// int OvalBx = ysa + 10 + policeH;
	// int OvalAy = h / 2 - 10;
	// int OvalBy = h / 2 + 10 - 25;
	// g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	// RenderingHints.VALUE_ANTIALIAS_ON);
	// g2.setColor(Color.yellow);
	// g2.fillOval(OvalAx, OvalAy, policeW * 2, policeH * 2);
	// g2.setColor(Color.blue);
	// g2.fillOval(OvalBx, OvalBy, policeW, policeH);
	// if (ysa > 500) {
	// policeSpeed = -1;
	// }
	// if (y+100 < -20) {
	// policeSpeed = 1;
	//
	//
	// }
	//
	// lastY = y;
	//
	// }

	public void actionPerformed(ActionEvent input) {
		if (x > 560) {
			movx = 0;
			x = 560;
		}
		if (y < 0) {
			movy = 0;
			y = 0;
		}
		if (y > 535) {
			movy = 0;
			y = 535;
		}
		if (x < 0) {
			movx = 0;
			x = 0;
		}

		x = x + movx;
		y = y + movy;
		repaint();

		wallOnesOneSide();
		if (x > 50) {
			check = true;
		}
		if (check == true) {
			wallOnesTwoSide();
			if (x < 50) {
				check = false;
			}
		}

		wallTwosOneSide();
		if (x > 175) {
			check2 = true;
		}
		if (check2 == true) {
			wallTwosTwoSide();
			if (x < 175) {
				check2 = false;
			}
		}
		wallThirdsUpOneSide();
		if (x > 325) {
			check3 = true;
		}
		if (check3 == true) {
			wallThirdsUpTwoSide();
			if (x < 325) {
				check3 = false;
			}
		}
		wallThirdsDownOneSide();
		if (x > 325) {
			check4 = true;
		}
		if (check4 == true) {
			wallThirdsDownTwoSide();
			if (x < 325) {
				check4 = false;
			}
		}
		wallFourthsOneSide();
		if (x > 410) {
			check5 = true;

		}
		if (check5 == true) {
			wallFourthsTwoSide();
			if (x < 410) {
				check5 = false;

			}
		}
		wallFifthsOneSide();
		if (x > 500) {
			check6 = true;

		}
		if (check6 == true) {
			wallFifthsTwoSide();
			if (x < 500) {
				check6 = false;
			}
		}
		doorCantGo();

	}

	// // the keys (up is negative down is positive)
	// public void up() {
	// movy = -10;
	// movx = 0;
	// }
	//
	// public void down() {
	// movy = 10;
	// movx = 0;
	// }
	//
	// public void left() {
	// movx = -10;
	// movy = 0;
	// }
	//
	// public void right() {
	// movx = 10;
	// movy = 0;
	// }

	public void keyPressed(KeyEvent input) {
		int code = input.getKeyCode();

		if (code == KeyEvent.VK_UP) {
			y = y - z;
		}
		if (code == KeyEvent.VK_DOWN) {
			y = y + z;
		}
		if (code == KeyEvent.VK_RIGHT) {
			x = x + z;
		}
		if (code == KeyEvent.VK_LEFT) {
			x = x - z;
		}

	}

	// public void keyTyped(KeyEvent key) {
	//
	// }

	// public void keyReleased(KeyEvent key) {
	// int keys = key.getKeyCode();
	//
	// if (keys == KeyEvent.VK_RIGHT) {
	// prisonKey = false;
	// } else if (keys == KeyEvent.VK_LEFT) {
	// prisonKey = false;
	// } else if (keys == KeyEvent.VK_UP) {
	// prisonKey = false;
	// } else if (keys == KeyEvent.VK_DOWN) {
	// prisonKey = false;
	// }
	//
	// movx = 0;
	// movy = 0;
	// }

	private void wallOnesOneSide() {

		if (x >= 25 && x <= 80 && y < 480) {
			x = 25;
		}

	}

	private void wallOnesTwoSide() {

		if (x <= 100 && y < 480) {
			x = 100;

		}

	}

	private void wallTwosOneSide() {

		if (x >= 150 && x <= 225 && y > 72) {
			x = 150;
		}

	}

	private void wallTwosTwoSide() {

		if (x <= 225 && y > 72) {
			x = 225;

		}

	}

	private void wallThirdsUpOneSide() {

		if (x >= 270 && x <= 330 && y < 230) {
			x = 270;
		}

	}

	private void wallThirdsUpTwoSide() {

		if (x <= 350 && y < 230) {
			x = 350;

		}

	}

	private void wallThirdsDownOneSide() {

		if (x >= 270 && x <= 330 && y > 300) {
			x = 270;
		}

	}

	private void wallThirdsDownTwoSide() {

		if (x <= 350 && y > 320 && y <= 600) {
			x = 350;

		}

	}

	private void wallFourthsOneSide() {

		if (x >= 365 && x <= 430 && y < 490) {
			x = 365;
		}

	}

	private void wallFourthsTwoSide() {

		if (x <= 440 && y < 490) {
			x = 440;

		}

	}

	private void wallFifthsOneSide() {

		if (x >= 465 && x <= 530 && y > 85) {
			x = 465;
		}

	}

	private void wallFifthsTwoSide() {

		if (x <= 540 && y > 85) {
			x = 540;

		}

	}

	private void doorCantGo() {

		if (x >= 225 && x <= 280 && y >= 330) {
			y = 330;
		}
	}

	private void prisonerStart() {
		x = 0;
		y = 0;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	// public void dataChange(int newx, int newy){
	// x = newx;
	// y = newy;
	// System.out.println(x + "" + y);
	// }
	// public int getX() {
	// return x;
	// }
	//
	// //
	// public void setX(int x) {
	// this.x = x;
	// }
	//
	// public int getY() {
	// return y;
	// }
	//
	// public void setY(int y) {
	// this.y = y;
	// }

}