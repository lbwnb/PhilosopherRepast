package WaiterSolution;

//叉子数组，模拟多个资源
public class ForkArray {
	private Fork[] forkArray;

	// 创建动态数组

	public ForkArray(int size) {
		forkArray = new Fork[size];
		for (int i = 0; i < forkArray.length; i++) {
			forkArray[i] = new Fork(i);

		}
	}

	// 获取其中一只叉子
	public Fork getFork(int id) {
		return forkArray[id];
	}

	// 获取上一直叉子左侧的叉子
	public Fork getTheLeftFork(int id) {
		if (id == 0) {
return forkArray[forkArray.length -1];
		}else {
			return forkArray[id -1];
		}
	}
	
}
