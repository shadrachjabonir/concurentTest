import java.math.BigDecimal;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;
import static java.lang.management.ManagementFactory.getThreadMXBean;

/**
 * Created by shadr on 26/06/2016.
 */
public class Main {

    private volatile boolean expired;
    private final int EPSYLON = 20;

    public static void main(String args[]) throws InterruptedException {
        int nCpu = Runtime.getRuntime().availableProcessors();
        System.out.println("cpu : " + nCpu);
        double uCpu = 1;
        System.out.println("utilize cpu ratio : " + uCpu);
        long  cpuTime = System.nanoTime();
        System.out.println("current time nano : " +cpuTime);
        Thread.sleep(400);
        cpuTime = System.nanoTime() - cpuTime;
        System.out.println("delta time nano : " +cpuTime);

        long waitTime = (400 * 1000000) - cpuTime;
        System.out.println("wait time nano : " +waitTime);

        Double nThreads = nCpu * uCpu * (1+ waitTime/cpuTime);
        System.out.println("cpu * utilize cpu ratio * (1 + waitTime/ delta time nano) : ");
        System.out.println(nThreads);
    }

}
