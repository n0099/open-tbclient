package com.yy.mobile.perf.taskexecutor;
/* loaded from: classes2.dex */
public interface ITaskExecutor {
    void execute(Runnable runnable, long j);

    void execute(Runnable runnable, long j, int i2);

    void execute(Runnable runnable, Runnable runnable2, long j);

    void execute(Runnable runnable, Runnable runnable2, long j, int i2);

    void removeTask(Runnable runnable);
}
