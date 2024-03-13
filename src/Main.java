import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numberPhilosophers = 5;
        Semaphore[] forks=new Semaphore[numberPhilosophers];
        Philosopher[] philosophers=new Philosopher[numberPhilosophers];
        Thread[] threads=new Thread[numberPhilosophers];
        for(int i=0;i<numberPhilosophers;i++){
            forks[i] = new Semaphore(1);
        }
        for(int i=0;i<numberPhilosophers;i++){
            Semaphore leftFork = forks[i];
            Semaphore rightFork = forks[(i+1)%numberPhilosophers];
            philosophers[i]=new Philosopher(i, leftFork, rightFork);
            threads[i]=new Thread(philosophers[i]);
            threads[i].start();
        }
        for(int i=0;i<numberPhilosophers;i++){
            threads[i].join();

        }
        for(int i=0;i<numberPhilosophers;i++){
            System.out.println("Философ " + i + " поел " + philosophers[i].getCount() + " раз/раза");
        }
    }
}