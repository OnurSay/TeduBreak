import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainMenu extends JFrame implements ActionListener {

	int width, height;
	public boolean gameOn = false;
	public static boolean DoZero = false;
	boolean firstOpen = true;
	public ImageIcon polis = new ImageIcon("images/polices.png");
	public ImageIcon exitLogo = new ImageIcon("images/exit.png");
	public ImageIcon audioLogo = new ImageIcon("images/audio.png");
	public ImageIcon replaylogo = new ImageIcon("images/replay.png");
	 JFrame za = new JFrame();
	KeyDirection keydir = new KeyDirection();

	JButton play = new JButton(polis);
	JButton audio = new JButton(audioLogo);
	JButton exit = new JButton(exitLogo);
	JButton replay = new JButton(replaylogo);
	JButton mainMenu = new JButton("main menu");

	CardLayout layout = new CardLayout();

	JPanel panel = new JPanel();
	JPanel game = new JPanel();
	static JPanel menu = new JPanel();
	JPanel main = new JPanel();

	public static void main(String[] args) {
		MainMenu menu = new MainMenu();

		// frame.setLocation(dim.width /2 - frame.getSize().width / 2,
		// (dim.height / 2 - frame.getSize().height / 2));

		// menu.setVisible(true);

	}

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == exit) {
			System.exit(0);
		} else if (event.getSource() == play) {
			System.out.println(firstOpen);
			if(firstOpen == true){
			// menu.setVisible(false);
			// MenuCloser();
			Main.main();
			gameOn = true;
			firstOpen = false;
			// layout.show(panel, "main");
			}
		} else if (event.getSource() == audio) {
			
			audio.addActionListener(new AL());
		} else if(event.getSource() == replay){
			Main.close();
			Main2.close();
			
			
			if (gameOn == true) {
			
			
			Main2.main();
			
			
			}
			
		} else if (event.getSource() == mainMenu) {
			layout.show(panel, "Menu");
		}

	}

	public MainMenu() {

		panel.setLayout(layout);
		addButtons();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(600, 100);
		setResizable(false);
		setLocation((dim.width / 2 - za.getSize().width / 2) - 300,
				(dim.height / 2 - za.getSize().height / 2) - 400);
		setVisible(true);
		setTitle("Main Menu");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		requestFocus();

	}

	private void addButtons() {

		play.addActionListener(this);
		audio.addActionListener(this);
		exit.addActionListener(this);
		replay.addActionListener(this);
		mainMenu.addActionListener(this);
		menu.add(play);
		menu.add(replay);
		menu.add(audio);

		menu.add(exit);

		game.add(mainMenu);
		game.add(main);
		menu.setBackground(Color.GRAY);
		panel.add(menu, "Menu");
		panel.add(game, "Game");
		panel.add(main, "main");
		add(panel);

		layout.show(panel, "Menu");
		// layout.show(panel, "main");

	}

	public static class AL implements ActionListener {
		public final void actionPerformed(ActionEvent e) {
			
			try {
				music();
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void music() throws LineUnavailableException, IOException {

		Clip clip = AudioSystem.getClip();
		AudioInputStream inputStream = null;
		try {
			inputStream = AudioSystem.getAudioInputStream(new File("images/prisonsong.wav"));
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clip.open(inputStream);
		clip.start();

	}


	// public static void MenuCloser() {
	// if (ego == 1) {
	// menu.setSize(0, 0);
	// menu.setVisible(false);
	// System.out.println("Çalýþýyorum");
	// } else if (ego == 0) {
	//
	// menu.setVisible(true);
	// System.out.println("Çalýþmýyorum");
	// }
	// }
}
