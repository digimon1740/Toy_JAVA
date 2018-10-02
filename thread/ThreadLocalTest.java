package thread;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadLocalTest {

    static class Task implements Runnable {

        private ContextBean contextBean;

        public Task(ContextBean contextBean) {
            this.contextBean = contextBean;
        }

        @Override
        public void run() {
            ThreadContext.local.set(this.contextBean);
            System.out.println(ThreadContext.local.get());
        }
    }

    public static void main(String[] args) {
        ThreadContext.local.set(new ContextBean());
        ThreadContext.local.get().setName("Tony");
        ThreadContext.local.get().setAge(10);

        ContextBean contextBean = ThreadContext.local.get();
        System.out.println(contextBean);

        // 정상작동
//        Thread th = new Thread(() -> {
//            ThreadContext.local.set(contextBean);
//            System.out.println(ThreadContext.local.get());
//        });
//        th.start();

        // 정상작동
        Thread th = new Thread(new Task(contextBean));
        th.start();

        Queue<Thread> threadQueue = new LinkedList<>();
        threadQueue.add(th);

        while (!threadQueue.isEmpty()) {
            Thread thread = threadQueue.poll();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
