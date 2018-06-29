package thread.executorsthreadpoolexecutors.exammple2;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class TestDay2 {
    /**
     * SynchronousQueue   根本不保存线程任务
     * LinkedBlockingDeque
     *
     *
     *
     *
     *
     * @param args
     * @throws InterruptedException
     */

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(3,6,5,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,6,5,TimeUnit.SECONDS,new SynchronousQueue<>());
        testExecutor(executor1);
        executor.shutdown();
    }

    static void testExecutor(ThreadPoolExecutor executor) throws InterruptedException {
        printPoolData(executor);
        System.out.println("--先开三个线程");
        startThread(executor);
        printPoolData(executor);
        System.out.println("--再开三个线程");
        startThread(executor);
        printPoolData(executor);
        Thread.sleep(8000);
        printPoolData(executor);
    }

    static void printPoolData(ThreadPoolExecutor executor){
        System.out.println("--可放置核心线程的数量" + executor.getCorePoolSize());
        System.out.println("--线程池中实际的线程数量--核心线程+非核心线程数量" + executor.getPoolSize());
        System.out.println("--队列中等待执行的数量" + executor.getQueue().size());
    }

    static void startThread(ThreadPoolExecutor executor){
        for (int i = 0; i < 3; i++){
            executor.execute(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "-----");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
