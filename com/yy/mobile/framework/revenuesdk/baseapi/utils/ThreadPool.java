package com.yy.mobile.framework.revenuesdk.baseapi.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
public class ThreadPool {
    public static volatile ThreadPool instance;
    public ExecutorService diskIO;
    public ScheduleExecutor mainThreadIO;
    public ScheduledExecutorService netIO;

    /* loaded from: classes7.dex */
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
        public void postDelay(Runnable runnable, long j) {
            this.handler.postDelayed(runnable, j);
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool.ScheduleExecutor
        public void removeCallback(Runnable runnable) {
            this.handler.removeCallbacks(runnable);
        }
    }

    /* loaded from: classes7.dex */
    public interface ScheduleExecutor extends Executor {
        void postDelay(Runnable runnable, long j);

        void removeCallback(Runnable runnable);
    }

    public ThreadPool() {
        this(Executors.newSingleThreadExecutor(), Executors.newScheduledThreadPool(5), new MainThreadExecutor());
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

    public ExecutorService diskIO() {
        return this.diskIO;
    }

    public ScheduleExecutor mainThreadIO() {
        return this.mainThreadIO;
    }

    public ScheduledExecutorService networkIO() {
        return this.netIO;
    }

    public ThreadPool(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, ScheduleExecutor scheduleExecutor) {
        this.diskIO = executorService;
        this.netIO = scheduledExecutorService;
        this.mainThreadIO = scheduleExecutor;
    }
}
