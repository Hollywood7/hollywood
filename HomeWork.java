package dopses;

import java.util.Stack;

public class HomeWork<E> {
	int maxCount;

	public HomeWork(int maxCount) {
		this.maxCount = maxCount;
	}

	private Stack<E> stack = new Stack<E>();

	public synchronized void push(E o) {
		while (stack.size() == maxCount) {
			try {
				System.out.println(Thread.currentThread().getName()	+ " думает пока место в стеке занято ");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		stack.add(o);
		notifyAll();
		System.out.println("Added object: " + o);
	}

	public synchronized E pull() {
		while (stack.isEmpty()) {
			try {
				System.out.println(Thread.currentThread().getName()	+ " добавление значений");
				notifyAll();
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		E t = stack.pop();
		return t;
	}
}