package com.yy.mobile.perf.taskexecutor;
/* loaded from: classes6.dex */
public interface IYYTaskExecutor extends ITaskExecutor {
    IQueueTaskExecutor createAQueueExcuter();

    boolean isMainThread();

    void postIdleRunnableToMainThread(Runnable runnable);

    void postToMainThread(Runnable runnable, long j);

    void removeRunnableFromMainThread(Runnable runnable);
}
