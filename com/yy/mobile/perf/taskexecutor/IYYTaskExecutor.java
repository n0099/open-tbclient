package com.yy.mobile.perf.taskexecutor;
/* loaded from: classes10.dex */
public interface IYYTaskExecutor extends ITaskExecutor {
    IQueueTaskExecutor createAQueueExcuter();

    boolean isMainThread();

    void postIdleRunnableToMainThread(Runnable runnable);

    void postToMainThread(Runnable runnable, long j2);

    void removeRunnableFromMainThread(Runnable runnable);
}
