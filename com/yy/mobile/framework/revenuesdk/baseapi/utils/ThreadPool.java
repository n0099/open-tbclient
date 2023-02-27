package com.yy.mobile.framework.revenuesdk.baseapi.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class ThreadPool {
    public static volatile ThreadPool instance;
    public ScheduleExecutor mainThreadIO;
    public ThreadPoolExecutor netIO;
    public ScheduledExecutorService scheduledIO;

    /* loaded from: classes8.dex */
    public interface ScheduleExecutor extends Executor {
        void postDelay(Runnable runnable, long j);

        void removeCallback(Runnable runnable);
    }

    /* loaded from: classes8.dex */
    public static class DefaultThreadFactory implements ThreadFactory {
        public final String namePrefix;
        public final AtomicInteger threadNumber = new AtomicInteger(1);

        public DefaultThreadFactory(String str) {
            this.namePrefix = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.namePrefix + "-thread-" + this.threadNumber.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    /* loaded from: classes8.dex */
    public static class MainThreadExecutor implements ScheduleExecutor {
        public Handler handler;

        public MainThreadExecutor() {
            this.handler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.handler.post(runnable);
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool.ScheduleExecutor
        public void removeCallback(Runnable runnable) {
            this.handler.removeCallbacks(runnable);
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool.ScheduleExecutor
        public void postDelay(Runnable runnable, long j) {
            this.handler.postDelayed(runnable, j);
        }
    }

    public ThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new DefaultThreadFactory("YYPay"), new ThreadPoolExecutor.DiscardOldestPolicy());
        this.netIO = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.scheduledIO = Executors.newScheduledThreadPool(1);
        this.mainThreadIO = new MainThreadExecutor();
    }

    public static ThreadPool getDefault() {
        if (instance == null) {
            synchronized (ThreadPool.class) {
                if (instance == null) {
                    instance = new ThreadPool();
                }
            }
        }
        return instance;
    }

    public ScheduleExecutor mainThreadIO() {
        return this.mainThreadIO;
    }

    public ExecutorService networkIO() {
        return this.netIO;
    }

    public ScheduledExecutorService scheduledIO() {
        return this.scheduledIO;
    }
}
