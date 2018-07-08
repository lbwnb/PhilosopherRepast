package WaiterSolution;

import java.util.Random;

public class Philosopher extends Thread {

	// 哲学家ID
	private int id;

	// 是否在用餐，true表示用餐，false表示思考
	private boolean status;

	// 叉子数组，资源队列
	private ForkArray forkArray;

	public Philosopher(int id, ForkArray forkArray) {
		this.id = id;
		this.forkArray = forkArray;
	}

	public synchronized void eating() {
		if (!status) {
			if (forkArray.getFork(id).isAvailable()) {
				if (forkArray.getTheLeftFork(id).isAvailable()) {
					// 该哲学家左右两边的叉子都可用，开始用餐，锁定叉子状态
					forkArray.getFork(id).setAvailable(false);
					forkArray.getTheLeftFork(id).setAvailable(false);
					System.out.println(this + "在吃饭!");
					// 模拟用餐过程，占有一定时间的资源
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				} else {
					// 左边叉子不可用，等待资源
					System.out.println(this + "在等待" + forkArray.getFork(id));
					try {
						wait(new Random().nextInt(10));
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			} else {
				// 右边叉子不可用，等待资源
				System.out.println(this + "在等待" + forkArray.getTheLeftFork(id));
				try {
					wait(new Random().nextInt(10));
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		status = true;

	}

	public synchronized void thinking() {
		if (status) {
			// 该哲学家处于思考状态，释放两边叉子资源
			forkArray.getFork(id).setAvailable(true);
			forkArray.getTheLeftFork(id).setAvailable(true);
			System.out.println(this + "在思考!");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		status = false;
	}
	public void run() {
		for(int i = 0;i<100;i++) {
			eating();
			thinking();
		}
	}
	public String toString() {
		return "哲学家" + id;
	}
}
