package com.yy.mobile.perf.taskexecutor;
/* loaded from: classes8.dex */
public interface ITaskExecutor {
    void execute(Runnable runnable, long j2);

    void execute(Runnable runnable, long j2, int i2);

    void execute(Runnable runnable, Runnable runnable2, long j2);

    void execute(Runnable runnable, Runnable runnable2, long j2, int i2);

    void removeTask(Runnable runnable);
}
