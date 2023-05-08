package application;
//t make me can to select the datatype in the cursor    string>>int>>etc
public class CursorArray<T extends Comparable<T>> {
	Node<T>[] cursorArray;// = new Node[11];

	public CursorArray(int capacity) {
		cursorArray = new Node[capacity];
		initialization();
	}

	private int initialization() {// bigO(n)
		for (int i = 0; i < cursorArray.length - 1; i++)// to make an empty stack
			cursorArray[i] = new Node<>(null, i + 1);
		cursorArray[cursorArray.length - 1] = new Node<>(null, 0);
		return 0;
	}

	private int malloc() {//consant c
		int p = cursorArray[0].next;
		cursorArray[0].next = cursorArray[p].next;
		return p;
	}

	private void free(int p) {
		cursorArray[p] = new Node(null, cursorArray[0].next);
		cursorArray[0].next = p;
	}

	private boolean isNull(int l) {
		return cursorArray[l] == null;
	}

	public boolean isEmpty(int l) {
		return cursorArray[l].next == 0;
	}

	private boolean isLast(int p) {
		return cursorArray[p].next == 0;
	}

	public int createList() {//constant
		int l = malloc();
		if (l == 0)//makean empty list and a header L
			System.out.println("Error: Out of space!!!");
		else
			cursorArray[l] = new Node("-", 0);
		return l;
	}

	public boolean insertAtHead(T data, int l) {
		if (isNull(l)) // list not created
			return false;
		int p = malloc();//PUSH METHOD
		if (p != 0) {
			cursorArray[p] = new Node(data, cursorArray[l].next);
			cursorArray[l].next = p;
		} else {
//			System.out.println("Error: Out of space!!!");
			return false;
		}
		return true;
	}

	
	public Object deleteFirst(int l) {
		if (!isNull(l) && !isEmpty(l)) {//pop method 
			int p = cursorArray[l].next;
			cursorArray[l].next = cursorArray[cursorArray[l].next].next;
			Node temp = cursorArray[p];
			return temp.data;
		}
		return null;
	}

	public Object getFirst(int l) {//peek method    last (((head))
		if (!isNull(l) && !isEmpty(l))
			return cursorArray[cursorArray[l].next].data;
		return null;
	}

}