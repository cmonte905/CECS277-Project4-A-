import java.util.ArrayList;
	
public class Heap<T> {
	private ArrayList<T> heap;

	public Heap() {
		heap = new ArrayList<T>();
	}

	public int getSize() {
		return heap.size();
	}

	public boolean isEmpty() {
		return heap.isEmpty();
	}

	public int getPLoc(int i) {
		return (i - 1) / 2;
	}

	public int getLCLoc(int i) {
		return 2 * i + 1;
	}

	public int getRCLoc(int i) {
		return 2 * i + 2;
	}

	public T getNodeAt(int i) {
		
		if (heap.get(i) == null) {
			System.out.println("Item does not exist.");
			return null;
		} else {
			return heap.get(i);
		}
	}

	public void addNode(T t) {
		heap.add(null);
		int index = heap.size() - 1;
		while (index > 0 && getNodeAt(getPLoc(index)).compareTo() > t.compareTo()) {
			heap.set(index, getNodeAt(getPLoc(index)));
			index = getPLoc(index);
		}
		heap.set(index, n); 
	}

	public T removeMin() {
		Node min = heap.get(0);
		int index = heap.size() - 1;
		Node last = heap.remove(index);
		if (index > 0) {
			heap.set(0, last);
			Node root = heap.get(0);
			int end = heap.size() - 1;
			index = 0;
			boolean done = false;
			while (!done) {
				if (getLCLoc(index) <= end) {// left exists
					Node child = getNodeAt(getLCLoc(index));
					int childLoc = getLCLoc(index);
					if (getRCLoc(index) <= end) {// rt exists
						if (getNodeAt(getRCLoc(index)).getData() < child
								.getData()) {
							child = getNodeAt(getRCLoc(index));
							childLoc = getRCLoc(index);
						}
					}
					if (child.getData() < root.getData()) {
						heap.set(index, child);
						index = childLoc;
					} else {
						done = true;
					}
				} else {// no children
					done = true;
				}
			}
			heap.set(index, root);
		}
		return min;
	}

	public void printHeap() {
		for (int i = 0; i < heap.size(); i++) {
			System.out.print(heap.get(i).getData() + " ");
		}
		System.out.println();
	}
	public class Node {
		private int data;

		public Node(int d) {
			data = d;
		}

		public int getData() {
			return data;
		}

		public void setData(int d) {
			data = d;
		}
	}

}




