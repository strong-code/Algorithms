/*
 * A Quick Union algorithm using weighted trees and path compression for a running time 
 * of N + M lg N
 */
public class QuickUnion {

	private int[] id;
	private int[] size;

	public QuickUnion(int n) {
		id = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			size[i] = 1; //initialize size array to 1, every element is its own root
			id[i] = i;
		}
	}
	
	private int root(int i) {
		while (i != id[i]) {
			id[i] = id[id[i]];//Use path compression to flatten the tree
			i = id[i];
		}
		return i;
	}
	
	private boolean connected(int x, int y) {
		return root(x) == root(y);
	}
	
	public void union(int x, int y) {
		int a = root(x);
		int b = root(y);
		
		//This forces weighted unions, so smaller trees are added to the larger one
		if (size[a] < size[b]) {
			id[a] = b;
			size[b] += size[a];
		} else {
			id[b] = a;
			size[a] += size[b];
		}
	}
	
	public static void main(String[] args) {
		QuickUnion qu = new QuickUnion(10);
		System.out.println("Performing unions");
		qu.union(2, 5);
		qu.union(1, 0);
		qu.union(3, 7);
		qu.union(7, 5);
		System.out.println("------------------");
		for (int i = 0; i < qu.id.length; i++) {
			System.out.println("Index is " + i + " and root is " + qu.id[i]);
		}
	}
}