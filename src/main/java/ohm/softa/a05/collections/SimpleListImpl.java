package ohm.softa.a05.collections;

import java.util.Iterator;

/**
 * Default implementation of the SimpleList interface
 *
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl<T> implements SimpleList<T> {

	private ListElement<T> head;
	private int size;

	/**
	 * Default constructor
	 */
	public SimpleListImpl() {
		head = null;
	}

	/**
	 * Add an object to the end of the list
	 *
	 * @param item item to add
	 */
	@Override
	public void add(T item) {
		/* special case empty list */
		if (head == null) {
			head = new ListElement<>(item);
		} else {
			/* any other list length */
			ListElement<T> current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(new ListElement<>(item));
		}
		size++;
	}

	/**
	 * @return size of the list
	 */
	@Override
	public int size() {
		return size;
	}

	@Override
	public void remove(T item) {
		if (head != null) {
			if (head.equals(item)) {
				head = null;
			} else {
				ListElement<T> current = head;
				while (current.getNext() != null) {
					if (current.getNext().equals(item)) {
						current.next = current.getNext().getNext();
					}

					current = current.getNext();
				}
			}

			size--;
		}
	}

	/**
	 * Create a new iterator
	 */
	@Override
	public Iterator<T> iterator() {
		return new SimpleIterator();
	}

	/**
	 * Helper class which implements the Iterator<TE> interface
	 * Has to be non static because otherwise it could not access the head of the list
	 */
	private class SimpleIterator implements Iterator<T> {

		private ListElement<T> current = head;

		/**
		 * @inheritDoc
		 */
		@Override
		public boolean hasNext() {
			return current != null;
		}

		/**
		 * @inheritDoc
		 */
		@Override
		public T next() {
			T tmp = current.getItem();
			current = current.getNext();
			return tmp;
		}
	}

	/**
	 * Helper class for the linked list
	 * can be static because the ListElement does not need to access the SimpleList instance
	 */
	private static class ListElement<T> {
		private T item;
		private ListElement<T> next;

		ListElement(T item) {
			this.item = item;
			this.next = null;
		}

		/**
		 * @return get object in the element
		 */
		public T getItem() {
			return item;
		}

		/**
		 * @return successor of the ListElement - may be NULL
		 */
		public ListElement<T> getNext() {
			return next;
		}

		/**
		 * Sets the successor of the ListElement
		 *
		 * @param next ListElement
		 */
		public void setNext(ListElement<T> next) {
			this.next = next;
		}
	}

}
