package at.fhj.swd.konfmana;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StringQueue implements Queue {
	
	private List<String> elements = new ArrayList<String>();
	private int maxSize = 0;
	
	public StringQueue() {
		this(1);
	}
	
	public StringQueue(int maxSize) {
		if (maxSize <= 0 ) throw new IllegalArgumentException("Passed parameter must be > 0");
		this.maxSize = maxSize;
	}
	
	@Override
	public boolean offer(String obj) {
		if(elements.size()< maxSize){
			elements.add(obj);
			return true;
		}
		else return false;
		
	}

	@Override
	public String poll() {
		String element = peek();
		if(elements.size() > 0){
			elements.remove(0);
		}
		return element;
	}

	@Override
	public String remove() {
		String element = poll();
		if(element == null) {
			throw new NoSuchElementException("there's no element any more");
		}
		return element;
	}

	@Override
	public String peek() {
		String element = null;
		if(elements.size() > 0) {
			element = elements.get(0);
		}
		return element;
	}

	@Override
	public String element() {
		String element = peek();
		if(element == null) {
			throw new NoSuchElementException("there's no element any more");
		}
		return element;
	}

}
