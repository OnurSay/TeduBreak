import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Main {
	static JFrame frame = new JFrame();
	public static void main() {
		// TODO Auto-generated method stub
		

		KeyDirection keydir = new KeyDirection();
		Walls wall = new Walls();
		Coordinate cor = new Coordinate(0, 0);
		Collision col = new Collision();
		
		// MainMenu menu = new MainMenu(600,600);

		// JButton button=new JButton("start");
		// button.setBounds(130,100,40, 40);

		frame.getContentPane().setBackground(Color.GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(600, 600);
		frame.setTitle("TeduBreak");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		// menu.setVisible(true);

		// frame.add(wall);
		frame.add(keydir);
		frame.setVisible(true);
//		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		// frame.add(police);
		// frame.add(button);
		if(KeyDirection.winCheck == true){
			
			frame.setVisible(false);
		}

	}
	
	public static void close(){
		frame.setVisible(false);
	}
}

