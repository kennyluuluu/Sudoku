import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener{
	JButton solveButton;
	JPanel sudokuBoard;
	int[][] board;
	
	GUI(int[][] b) {
		board = b;
		
		JLabel titleText = new JLabel("Sudoku Solver");
		titleText.setFont(new Font("Serif", Font.BOLD, 40));
		titleText.setSize(400,80);
		
		solveButton = new JButton("solve");
		solveButton.setBounds(0,600, 80,20);
		solveButton.addActionListener(this);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(600,700);
		this.getContentPane().setBackground(Color.pink);
		this.add(titleText);
		this.add(solveButton);
		
		updateBoard();
		this.add(sudokuBoard);
		this.setVisible(true);
	}
	
	private void updateBoard() {
		sudokuBoard = new JPanel();
		sudokuBoard.setBackground(Color.black);
		sudokuBoard.setBounds(100, 100, 400, 400);
		sudokuBoard.setLayout(new GridLayout(3,3,4,4));
		
		for(int ii = 0; ii < 3; ii++) {
			for(int jj = 0; jj < 3; jj++) {
				JPanel square = new JPanel();
				square.setBackground(Color.black);
				square.setLayout(new GridLayout(3,3,1,1));
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						String v = String.valueOf(board[ii*3 + i][jj*3 + j]);
						if(v.equals("0"))
							v = "";
						JLabel label = new JLabel(v);
						label.setBackground(Color.white);
						label.setOpaque(true);
						square.add(label);
					}
				}
				sudokuBoard.add(square);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == solveButton) {
			Sudoku.solve(board);
			this.remove(sudokuBoard);
			updateBoard();
			this.add(sudokuBoard);
			this.revalidate();
			this.repaint();
		}
		
	}
}
