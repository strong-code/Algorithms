
public class QuickUnion {

	private int[] id;

	public QuickUnion(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}
	
	private int root(int i) {
		while (i != id[i]) {
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
		id[a] = b;
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
	
	
