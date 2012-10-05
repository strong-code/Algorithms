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
	int percTree[][];
	
	//Initialize a matrix size n with all sites open
	public Percolation(int n) {
		gridsize = n;
		final int ROWS = n;
		final int COLS = n;
		matrix = new int[ROWS][COLS];
		percTree = new int[ROWS][COLS];
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				matrix[i][j] = 1;
				percTree[i][j] = i;
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
	
	//This checks the right-most neighbor of the current node
	//Adds node to tree and checks next rightmost neighbor again
	private void checkRight(int i, int k) {
		try {
			if (this.matrix[i][k+1] == 0) {
				this.percTree[i][k+1] = this.percTree[i][k];
				checkRight(i, k+1);
			}
		} catch (IndexOutOfBoundsException e) {return;}
			
	}
	
	//Check the bottom-most neighbor of the current node
	//Adds this node to the tree and checks bottom-most again
	private void checkBelow(int i, int k) {
		try {
			if (this.matrix[i+gridsize][k] == 0) {
				this.percTree[i+gridsize][k] = this.percTree[i][k];
				checkBelow(i+gridsize, k);
			}
		} catch (IndexOutOfBoundsException e) {return;}
	}
	
	public boolean percolates() {
		for (int i = 0; i < gridsize; i++) { //run along each row
			for (int k = 0; k < gridsize; k++) {
				if (this.matrix[i][k] == 0) {
					checkRight(i, k);
					checkBelow(i, k);
				}
			}
		} return false;
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
	
	public void printGrid() {
		for (int i = 0; i < gridsize; i++) {
			for (int k = 0; k < gridsize; k++) {
				System.out.print(this.matrix[i][k] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Percolation p = new Percolation(10);
		for (int i = 0; i < 58; i++) {
			p.randOpen();
		}
		p.printGrid();
		if (p.percolates()) {
			p.printGrid();
		}
	}
}