package com.yy.gslbsdk.thread;

import com.yy.gslbsdk.thread.ThreadInfo;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.HashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class ThreadPoolMgr {
    public static final String TAG = "ThreadPoolMgr";
    public static ThreadPoolMgr mThreadPoolMgr;
    public ITaskExecutor mExecutorSvc;
    public boolean mReleaseAble;
    public HashMap<String, String> mThreadName = new HashMap<>();

    /* loaded from: classes7.dex */
    public static class CustomThreadPoolExecutor implements ITaskExecutor {
        public ThreadPoolExecutor mExcutorSvc;

        public CustomThreadPoolExecutor(int i2, int i3) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i3, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory());
            this.mExcutorSvc = threadPoolExecutor;
            threadPoolExecutor.prestartAllCoreThreads();
        }

        @Override // com.yy.gslbsdk.thread.ThreadPoolMgr.ITaskExecutor
        public boolean addTask(Runnable runnable) {
            try {
                this.mExcutorSvc.execute(runnable);
                return true;
            } catch (RejectedExecutionException e2) {
                LogTools.printWarning(ThreadPoolMgr.TAG, e2);
                return false;
            }
        }

        @Override // com.yy.gslbsdk.thread.ThreadPoolMgr.ITaskExecutor
        public int getActiveCount() {
            return this.mExcutorSvc.getActiveCount();
        }

        @Override // com.yy.gslbsdk.thread.ThreadPoolMgr.ITaskExecutor
        public int getPoolSize() {
            return this.mExcutorSvc.getPoolSize();
        }

        @Override // com.yy.gslbsdk.thread.ThreadPoolMgr.ITaskExecutor
        public boolean isShutdown() {
            return this.mExcutorSvc.isShutdown();
        }

        @Override // com.yy.gslbsdk.thread.ThreadPoolMgr.ITaskExecutor
        public boolean isTerminated() {
            return this.mExcutorSvc.isTerminated();
        }

        @Override // com.yy.gslbsdk.thread.ThreadPoolMgr.ITaskExecutor
        public void shutdownNow(long j) {
            try {
                this.mExcutorSvc.shutdownNow();
                this.mExcutorSvc.awaitTermination(j, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                LogTools.printWarning(ThreadPoolMgr.TAG, e2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class DefaultThreadFactory implements ThreadFactory {
        public final AtomicInteger threadNumber = new AtomicInteger(1);
        public final ThreadGroup group = Thread.currentThread().getThreadGroup();
        public final String namePrefix = "dnspool-thread-";

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.group;
            Thread thread = new Thread(threadGroup, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    /* loaded from: classes7.dex */
    public interface ITaskExecutor {
        boolean addTask(Runnable runnable);

        int getActiveCount();

        int getPoolSize();

        boolean isShutdown();

        boolean isTerminated();

        void shutdownNow(long j);
    }

    public static ThreadPoolMgr getInstance() {
        if (mThreadPoolMgr == null) {
            mThreadPoolMgr = new ThreadPoolMgr();
        }
        return mThreadPoolMgr;
    }

    public synchronized int addTask(ThreadInfo threadInfo) {
        if (threadInfo == null) {
            return 5;
        }
        threadInfo.setThreadEndOper(new ThreadInfo.ThreadEndOper() { // from class: com.yy.gslbsdk.thread.ThreadPoolMgr.1
            @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadEndOper
            public void handleOper(String str) {
                ThreadPoolMgr.this.mThreadName.remove(str);
            }
        });
        if (this.mThreadName.containsKey(threadInfo.getThreadName())) {
            return 0;
        }
        try {
            if (this.mExecutorSvc.addTask(threadInfo)) {
                this.mThreadName.put(threadInfo.getThreadName(), null);
                return 0;
            }
        } catch (Exception e2) {
            LogTools.printError(TAG, "ThreadPoolMgr.addTask() exception:" + e2.getMessage());
        }
        return 8;
    }

    public void create(ITaskExecutor iTaskExecutor) {
        if (iTaskExecutor == null) {
            create(GlobalTools.THREAD_POOL_MIN, GlobalTools.THREAD_POOL_MAX);
            LogTools.printDebug(TAG, "initThreadPool..." + GlobalTools.THREAD_POOL_MIN + "/" + GlobalTools.THREAD_POOL_MAX);
            return;
        }
        this.mReleaseAble = false;
        this.mExecutorSvc = iTaskExecutor;
    }

    public String dump() {
        if (this.mExecutorSvc.isShutdown() || this.mExecutorSvc.isTerminated()) {
            return "thread pool is shutdown";
        }
        return " poolSize=" + getPoolSize() + " activeCount=" + getActiveCount();
    }

    public int getActiveCount() {
        return this.mExecutorSvc.getActiveCount();
    }

    public int getPoolSize() {
        return this.mExecutorSvc.getPoolSize();
    }

    public boolean isRunning() {
        return !this.mExecutorSvc.isShutdown();
    }

    public void stop(long j) {
        if (this.mReleaseAble) {
            this.mExecutorSvc.shutdownNow(j);
        }
    }

    public void create(int i2, int i3) {
        this.mReleaseAble = true;
        this.mExecutorSvc = new CustomThreadPoolExecutor(i2, i3);
    }
}
