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
		/*
		 * while(index > 0 && getNodeAt(getPLoc(index)).getData()>n.getData()){
			heap.set(index, getNodeAt(getPLoc(index)));
			index = getPLoc(index);
}
		 */
		while (index > 0 && (getNodeAt(getPLoc(index)).getData() > t.getData())) {
			heap.set(index, getNodeAt(getPLoc(index)));
			index = getPLoc(index);
		}
		heap.set(index, t); 
	}

	public T removeMin() {
		T min = heap.get(0);
		int index = heap.size() - 1;
		T last = heap.remove(index);
		if (index > 0) {
			heap.set(0, last);
			T root = heap.get(0);
			int end = heap.size() - 1;
			index = 0;
			boolean done = false;
			while (!done) {
				if (getLCLoc(index) <= end) {// left exists
					T child = getNodeAt(getLCLoc(index));
					int childLoc = getLCLoc(index);
					if (getRCLoc(index) <= end) {// rt exists
						if (getNodeAt(getRCLoc(index)).getData() < child.getData()) {
							child = getNodeAt(getRCLoc(index));
							childLoc = getRCLoc(index);
						}
					}
					if (child.getData() < root.getData()) {
						 m,heap.set(index, child);
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
	
	public class Node <T> {
		private T data;

		public Node(T t) {
			data = t;
		}

		public T getData() {
			return data;
		}

		public void setData(T t) {
			data = t;
		}
	}

}




