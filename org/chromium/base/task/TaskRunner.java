package org.chromium.base.task;
/* loaded from: classes2.dex */
public interface TaskRunner {
    void postDelayedTask(Runnable runnable, long j);

    void postTask(Runnable runnable);
}
