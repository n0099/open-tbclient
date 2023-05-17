package com.yy.hiidostatis.inner.util;

import com.yy.hiidostatis.api.ExecutorProvider;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.mobile.perf.taskexecutor.IQueueTaskExecutor;
import com.yy.mobile.perf.taskexecutor.IYYTaskExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class ThreadPool {
    public static final String HIIDO_FIXED_THREAD_NAME = "hiido_fixed_thread";
    public static final String HIIDO_SCHEDULED_THREAD_NAME = "hiido_scheduled_thread";
    public static final String HIIDO_SINGLE_THREAD_NAME = "hiido_single_thread";
    public static ThreadPool pool;
    public ExecutorService executorService;
    public ScheduledExecutorService scheduledExecutorService;
    public ExecutorService singleExecutorService;
    public IQueueTaskExecutor singleTaskExecutor;
    public ScheduledExecutorService spareExecutor;
    public IYYTaskExecutor taskExecutor;
    public SharedThreadTimer timer = new SharedThreadTimer();

    public ThreadPool() {
        if (ExecutorProvider.getIyyTaskExecutor() == null) {
            this.executorService = Executors.newFixedThreadPool(5, new ThreadFactory() { // from class: com.yy.hiidostatis.inner.util.ThreadPool.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName(ThreadPool.HIIDO_FIXED_THREAD_NAME);
                    return thread;
                }
            });
            this.singleExecutorService = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.yy.hiidostatis.inner.util.ThreadPool.2
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName(ThreadPool.HIIDO_SINGLE_THREAD_NAME);
                    return thread;
                }
            });
            this.scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactory() { // from class: com.yy.hiidostatis.inner.util.ThreadPool.3
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName(ThreadPool.HIIDO_SCHEDULED_THREAD_NAME);
                    thread.setPriority(1);
                    return thread;
                }
            });
            return;
        }
        IYYTaskExecutor iyyTaskExecutor = ExecutorProvider.getIyyTaskExecutor();
        this.taskExecutor = iyyTaskExecutor;
        IQueueTaskExecutor createAQueueExcuter = iyyTaskExecutor.createAQueueExcuter();
        this.singleTaskExecutor = createAQueueExcuter;
        if (createAQueueExcuter == null) {
            this.singleExecutorService = Executors.newSingleThreadExecutor();
        }
    }

    public static ThreadPool getPool() {
        if (pool == null) {
            synchronized (ThreadPool.class) {
                if (pool == null) {
                    pool = new ThreadPool();
                }
            }
        }
        return pool;
    }

    private ScheduledExecutorService getSpareExecutor() {
        ScheduledExecutorService scheduledExecutorService = this.spareExecutor;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService;
        }
        synchronized (this) {
            if (this.spareExecutor != null) {
                return this.spareExecutor;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.spareExecutor = newScheduledThreadPool;
            return newScheduledThreadPool;
        }
    }

    public SharedThreadTimer getTimer() {
        return this.timer;
    }

    public void shutdown() {
        ExecutorService executorService = this.executorService;
        if (executorService != null) {
            executorService.shutdown();
        }
        ExecutorService executorService2 = this.singleExecutorService;
        if (executorService2 != null) {
            executorService2.shutdown();
        }
        ScheduledExecutorService scheduledExecutorService = this.scheduledExecutorService;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
        ScheduledExecutorService scheduledExecutorService2 = this.spareExecutor;
        if (scheduledExecutorService2 != null) {
            scheduledExecutorService2.shutdown();
            this.spareExecutor = null;
        }
    }

    public void shutdownNow() {
        ExecutorService executorService = this.executorService;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        ExecutorService executorService2 = this.singleExecutorService;
        if (executorService2 != null) {
            executorService2.shutdownNow();
        }
        ScheduledExecutorService scheduledExecutorService = this.scheduledExecutorService;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        ScheduledExecutorService scheduledExecutorService2 = this.spareExecutor;
        if (scheduledExecutorService2 != null) {
            scheduledExecutorService2.shutdownNow();
            this.spareExecutor = null;
        }
    }

    public void execute(Runnable runnable) {
        IYYTaskExecutor iYYTaskExecutor = this.taskExecutor;
        if (iYYTaskExecutor != null) {
            try {
                iYYTaskExecutor.execute(runnable, 0L);
                return;
            } catch (Throwable unused) {
                getSpareExecutor().execute(runnable);
                return;
            }
        }
        this.executorService.execute(runnable);
    }

    public void executeQueue(Runnable runnable) {
        IQueueTaskExecutor iQueueTaskExecutor = this.singleTaskExecutor;
        if (iQueueTaskExecutor != null) {
            try {
                iQueueTaskExecutor.execute(runnable, 0L);
                return;
            } catch (Throwable unused) {
                getSpareExecutor().execute(runnable);
                return;
            }
        }
        this.singleExecutorService.execute(runnable);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        execute(futureTask);
        return futureTask;
    }

    public <T> Future<T> submitQueue(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        executeQueue(futureTask);
        return futureTask;
    }

    public void execute(Runnable runnable, long j) {
        try {
            if (this.taskExecutor != null) {
                this.taskExecutor.execute(runnable, j);
            } else {
                this.scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th) {
            L.debug(this, th.getMessage(), new Object[0]);
        }
    }
}
