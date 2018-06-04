import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main2 {
	
	static 	JFrame frame2 = new JFrame();
		public static void main() {
			// TODO Auto-generated method stub
			

			KeyDirection keydir = new KeyDirection();
			Walls wall = new Walls();
			Coordinate cor = new Coordinate(0, 0);
			Collision col = new Collision();
			Replay replay = new Replay();
			// MainMenu menu = new MainMenu(600,600);

			// JButton button=new JButton("start");
			// button.setBounds(130,100,40, 40);

			frame2.getContentPane().setBackground(Color.GRAY);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.setResizable(false);
			frame2.setSize(600, 600);
			frame2.setTitle("TeduBreak");
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			frame2.setLocation(dim.width / 2 - frame2.getSize().width / 2, dim.height / 2 - frame2.getSize().height / 2);

			// menu.setVisible(true);

			// frame.add(wall);
			frame2.add(replay);
			frame2.setVisible(true);

			// frame.add(police);
			// frame.add(button);
			
		}
		
		public static void close(){
			System.out.println("geldim");
			frame2.setVisible(false);
		}
	}

