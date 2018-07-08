package WaiterSolution;

//�������飬ģ������Դ
public class ForkArray {
	private Fork[] forkArray;

	// ������̬����

	public ForkArray(int size) {
		forkArray = new Fork[size];
		for (int i = 0; i < forkArray.length; i++) {
			forkArray[i] = new Fork(i);

		}
	}

	// ��ȡ����һֻ����
	public Fork getFork(int id) {
		return forkArray[id];
	}

	// ��ȡ��һֱ�������Ĳ���
	public Fork getTheLeftFork(int id) {
		if (id == 0) {
return forkArray[forkArray.length -1];
		}else {
			return forkArray[id -1];
		}
	}
	
}
