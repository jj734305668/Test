package thread.executorsthreadpoolexecutors.exammple2;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(6,10,5,TimeUnit.SECONDS,new SynchronousQueue<>());
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,6,5,TimeUnit.SECONDS,new SynchronousQueue<>());


        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(3,6,5,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        testThread(executor);


        System.out.println("---结束");
        executor.shutdown();
    }

    static void testThread(ThreadPoolExecutor executor) throws InterruptedException {
        System.out.println("---核心线程数" + executor.getCorePoolSize());
        System.out.println("---线程池数" + executor.getPoolSize());
        System.out.println("---队列任务处" + executor.getQueue().size());
        runnableEx(executor);
        System.out.println("---先开三个线程");
        System.out.println("---核心线程数" + executor.getCorePoolSize());
        System.out.println("---线程池数" + executor.getPoolSize());
        System.out.println("---队列任务处" + executor.getQueue().size());
        runnableEx(executor);
        System.out.println("---再开三个线程");
        System.out.println("---核心线程数" + executor.getCorePoolSize());
        System.out.println("---线程池数" + executor.getPoolSize());
        System.out.println("---队列任务处" + executor.getQueue().size());
        Thread.sleep(8000);
        System.out.println("----8秒之后----");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());
    }

    static void runnableEx(ThreadPoolExecutor executor){
        for (int i = 0; i < 3; i++){
            executor.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "---run");
            });
        }
    }
}
