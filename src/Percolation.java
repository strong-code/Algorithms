/*
 * Monte Carlo percolation
 * 
 * 0 = open
 * 1 = blocked
 * 2 = full
 * 
 */
import java.util.Random;

public class Percolation {
	int matrix[][];
	int gridsize;
	
	//Initialize a matrix size n with all sites open
	public Percolation(int n) {
		gridsize = n;
		final int ROWS = n;
		final int COLS = n;
		matrix = new int[ROWS][COLS];
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				matrix[i][j] = 0;
			}
		}
	}

	public void open(int i, int j) {
		this.matrix[i][j] = 0;
	}
	
	public boolean isOpen(int i, int j) {
		if (this.matrix[i][j] == 0)
			return true;
		else return false;
	}
	
	public boolean isFull(int i, int j) {
		if (this.matrix[i][j] == 2)
			return true;
		else return false;		
	}
	
	public boolean percolates() {
		//TODO 
		return false;
	}
	
	//helper function to open a randomly selected (closed) node
	public void randOpen() {
		Random rand = new Random();
		int i = rand.nextInt(gridsize);
		int j = rand.nextInt(gridsize);
		if (!isOpen(i, j))
			open(i, j);
		else randOpen(); //recursively call until we open a new node
	}

	public static void main(String[] args) {
		Percolation p = new Percolation(20);
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (p.matrix[i][j] != 0) {
					System.out.println("There is a block at [" + i + "][" + j + "]");
					break;
				}
			}
		}
	}
}