import java.util.ArrayList;
import java.util.List;

/*
 * A data structure for holding N objects in a list, discarding the first ones when it fills up.
 * Elements should allow serialization to/from Strings.
 */
public class  RotateQueue<E> {
	public List<E> Elements;
	public int Capacity;
    private static double FREE_SIZE = 0.05;

	// Constructor, creates a RotateQueue of Strings from a comma delimited String.
	public RotateQueue(int capacity, String serialized) {
		Elements = new ArrayList<E>(capacity);
		Capacity = capacity;
		if (serialized.trim().length() != 0) {
			String[] values = serialized.split(",", capacity);
			for (String v : values) {
				if (v.trim().length() != 0) {
                    @SuppressWarnings("unchecked")
                    E item = (E)v;
					this.addElement(item);
                }
            }
		}
	}

    // Constructor, creates a RotateQueue from an ArrayList<E>
    public RotateQueue(int capacity, ArrayList<E> items) {
        Elements = new ArrayList<E>(capacity);
        Capacity = capacity;
        for (E item : items) {
            this.addElement(item);
        }
    }

	// Add a new element to the queue, clean-up old elements if needed
	public synchronized void addElement(E value) {
		if (Capacity == Elements.size()) {
            int deleteUntil = (int)Math.ceil(Capacity * FREE_SIZE);
            Elements = Elements.subList(deleteUntil, Capacity);
		}
		if (!this.searchElement(value)) {
			Elements.add(value);
		}
	}

    // Remove a list of elements from the queue
    public synchronized void removeAll(ArrayList<E> elements) {
        Elements.removeAll(elements);
    }

	// Search an element by value
	public synchronized boolean searchElement(E value) {
		return Elements.contains(value);
	}

	@Override
	public synchronized String toString() {
		StringBuilder sb = new StringBuilder();
		for (E element : Elements)
			sb.append(element.toString()).append(",");
		return sb.toString();
	}
}
