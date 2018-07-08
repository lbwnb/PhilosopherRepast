package WaiterSolution;

import java.util.Random;

public class Philosopher extends Thread {

	// ��ѧ��ID
	private int id;

	// �Ƿ����òͣ�true��ʾ�òͣ�false��ʾ˼��
	private boolean status;

	// �������飬��Դ����
	private ForkArray forkArray;

	public Philosopher(int id, ForkArray forkArray) {
		this.id = id;
		this.forkArray = forkArray;
	}

	public synchronized void eating() {
		if (!status) {
			if (forkArray.getFork(id).isAvailable()) {
				if (forkArray.getTheLeftFork(id).isAvailable()) {
					// ����ѧ���������ߵĲ��Ӷ����ã���ʼ�òͣ���������״̬
					forkArray.getFork(id).setAvailable(false);
					forkArray.getTheLeftFork(id).setAvailable(false);
					System.out.println(this + "�ڳԷ�!");
					// ģ���ò͹��̣�ռ��һ��ʱ�����Դ
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				} else {
					// ��߲��Ӳ����ã��ȴ���Դ
					System.out.println(this + "�ڵȴ�" + forkArray.getFork(id));
					try {
						wait(new Random().nextInt(10));
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			} else {
				// �ұ߲��Ӳ����ã��ȴ���Դ
				System.out.println(this + "�ڵȴ�" + forkArray.getTheLeftFork(id));
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
			// ����ѧ�Ҵ���˼��״̬���ͷ����߲�����Դ
			forkArray.getFork(id).setAvailable(true);
			forkArray.getTheLeftFork(id).setAvailable(true);
			System.out.println(this + "��˼��!");
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
		return "��ѧ��" + id;
	}
}
