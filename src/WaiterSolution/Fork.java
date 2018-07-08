package WaiterSolution;

public class Fork {
 //表示叉子使否可用
	private volatile boolean isAvailable = true;
 //叉子ID
	private int id;
	
	public Fork(int id) {
		this.id = id;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "叉子" + id;
	}
	
	
}
