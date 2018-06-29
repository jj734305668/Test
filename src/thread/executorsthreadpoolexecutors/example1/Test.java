package thread.executorsthreadpoolexecutors.example1;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args){
//        testSimpleThreadPool();
        testThreadPoolExecutor();
        System.out.println("THE END");
    }

    /**
     * testThreadPoolExecutor
     */
    static void testThreadPoolExecutor(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                4,
                10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                (r, executor) -> System.out.println(r + "is rejected"));

        Thread thread = new Thread(() -> {
            String.format("[%d,%d],active:%d,completed:%d,task:%d,isShutDown,%s,isTerminated:%s",
                    threadPoolExecutor.getPoolSize(),
                    threadPoolExecutor.getCorePoolSize(),
                    threadPoolExecutor.getActiveCount(),
                    threadPoolExecutor.getCompletedTaskCount(),
                    threadPoolExecutor.getTaskCount(),
                    threadPoolExecutor.isShutdown(),
                    threadPoolExecutor.isTerminated());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        thread.start();


        for (int i = 0; i < 10; i++){
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                System.out.println("Start---thread" + finalI);
            });
        }

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadPoolExecutor.shutdown();
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }


    /**
     * simpleThreadPool
     */
    static void testSimpleThreadPool(){
        ExecutorService executors = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++){
            int finalI = i;
            executors.execute(() -> {
                System.out.println("thread-start" + finalI);
                try {
                    System.out.println("sleep................");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread-end" + finalI);
            });
        }
        executors.shutdown();

    }

}
