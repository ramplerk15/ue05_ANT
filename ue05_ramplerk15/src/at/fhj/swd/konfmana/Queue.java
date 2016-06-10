package at.fhj.swd.konfmana;

public interface Queue {
	
	public boolean offer(String obj);

	public String poll();
	
	public String remove();
	
	public String peek();
	
	public String element();
	
}

