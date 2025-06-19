public class ThreeThread implements Runnable {
    // Maximum number to print
    private static final int MAX = 10;
    // Shared number to be printed by threads
    
    private static int number = 1;
    // Thread ID to identify each thread
    private final int threadId;
    // Lock object for synchronization
    private static final Object lock = new Object();

    // Constructor to initialize thread ID
    public ThreeThread(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        // Loop until the maximum number is reached
        while (number <= MAX) {
            synchronized (lock) {
                // Check if the current thread should print the number
                if (number % 3 == threadId - 1) {
                    System.out.println("Thread " + threadId + ": " + number);
                    number++;
                    // Notify all waiting threads
                    lock.notifyAll();
                } else {
                    try {
                        // Wait if it's not this thread's turn
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create and start three threads
        Thread t1 = new Thread(new ThreeThread(1));
        Thread t2 = new Thread(new ThreeThread(2));
        Thread t3 = new Thread(new ThreeThread(3));

        t1.start();
        t2.start();
        t3.start();
    }
}
