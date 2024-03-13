import java.util.Random;
import java.util.concurrent.Semaphore;
public class Philosopher implements Runnable{
    private int id;
    private Semaphore leftFork;
    private Semaphore rightFork;
    private Random random = new Random();
    private int count=0;
    public Philosopher (int id, Semaphore leftFork, Semaphore rightFork){
        this.id=id;
        this.leftFork=leftFork;
        this.rightFork=rightFork;
    }
    public int getCount(){
        return count;
    }

    @Override
    public void run() {
        try {
                for(;count<random.nextInt(10) + 1;) {
                    leftFork.acquire();
                    rightFork.acquire();
                    System.out.println("Философ " + id + " Взял вилки");
                    Thread.sleep(random.nextInt(1000));
                    count++;
                    System.out.println("Философ " + id + " Сыт");
                    System.out.println("Философ " + id + " Вернул вилки");
                    leftFork.release();
                    rightFork.release();
                    Thread.sleep(random.nextInt(1000));
                }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
