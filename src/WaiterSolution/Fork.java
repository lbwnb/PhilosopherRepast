package WaiterSolution;

public class Fork {
 //��ʾ����ʹ�����
	private volatile boolean isAvailable = true;
 //����ID
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
		return "����" + id;
	}
	
	
}
