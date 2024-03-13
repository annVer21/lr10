import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int numberPhilosophers = 5;
        Semaphore[] forks=new Semaphore[numberPhilosophers];
        for(int i=0;i<numberPhilosophers;i++){
            forks[i] = new Semaphore(1);
        }
        for(int i=0;i<numberPhilosophers;i++){
            Semaphore leftFork = forks[i];
            Semaphore rightFork = forks[(i+1)%numberPhilosophers];
            Philosopher philosopher=new Philosopher(i, leftFork, rightFork);
            new Thread(philosopher).start();
        }
    }
}