package com.yy.mobile.perf.taskexecutor;
/* loaded from: classes7.dex */
public interface ITaskExecutor {
    void execute(Runnable runnable, long j);

    void execute(Runnable runnable, long j, int i);

    void execute(Runnable runnable, Runnable runnable2, long j);

    void execute(Runnable runnable, Runnable runnable2, long j, int i);

    void removeTask(Runnable runnable);
}
