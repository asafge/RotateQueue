import java.util.ArrayList;
import java.util.List;

/*
 * A data structure for holding N objects in a list, discarding the first ones when it fills up.
 * Elements should allow serialization to/from Strings.
 */
public class  RotateQueue<E> {
	public List<E> Elements;
	public int Capacity;

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
					this.AddElement(item);
                }
            }
		}
	}

    // Constructor, creates a RotateQueue from an ArrayList<E>
    public RotateQueue(int capacity, ArrayList<E> items) {
        Elements = new ArrayList<E>(capacity);
        Capacity = capacity;
        for (E item : items) {
            this.AddElement(item);
        }
    }

	// Add a new element to the queue, clean-up old elements if needed
	public synchronized void AddElement(E value) {
		if (Capacity == Elements.size()) {
			int deleteFrom = (int)Math.ceil(Capacity * 0.05);
			Elements = Elements.subList(deleteFrom, Capacity);
		}
		if (!this.SearchElement(value)) {
			Elements.add(value);
		}
	}

	// Search an element by value
	public synchronized boolean SearchElement(E value) {
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
