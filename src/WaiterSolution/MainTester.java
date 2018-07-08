package WaiterSolution;

public class MainTester {
 public static void main(String[] args) {
	ForkArray forkArray = new ForkArray(5);
	for(int i=0;i<5;i++) {
		new Thread(new Philosopher(i, forkArray)).start();
	}
}
}
