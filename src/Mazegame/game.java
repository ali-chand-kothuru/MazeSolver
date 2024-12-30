package Mazegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class game extends JFrame {

	private int[][] maze = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1 },
			{ 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	public List<Offset> path = new ArrayList<>();

	public game() {
		// JPanel panel = new JPanel();
		// panel.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
		// setContentPane(panel);
		setTitle("Maze Solver");
		setSize(640, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Depth.searchpath(maze, 1, 1, path);
	}

	@Override
	public void paint(Graphics g) {
		g.translate(50, 50);

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				Color color;
				switch (maze[i][j]) {
				case 1:
					color = Color.BLACK;
					break;
				case 9:
					color = Color.RED;
					break;
				default:
					color = Color.WHITE;
					break;
				}
				g.setColor(color);
				g.fillRect(20 * j, 20 * i, 20, 20);
				g.setColor(Color.RED);
				g.drawRect(20 * j, 20 * i, 20, 20);
			}
		}

//    	for(int i=0;i<path.size();i+=2) {
//    		g.setColor(Color.green);
//			g.fillRect(30*path.get(i), 30* path.get(i+1), 30, 30);
//    	}
		for (int i = 0; i < path.size(); i++) {
			g.setColor(Color.green);
			g.fillRect((int) (20 * path.get(i).x), (int) (20 * path.get(i).y), 20, 20);
		}

	}

	public static void main(String[] args) {
		game a = new game();
		a.setVisible(true);
	}

}
