package org.chromium.base.task;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class SequencedTaskRunnerImpl extends TaskRunnerImpl implements SequencedTaskRunner {
    public AtomicInteger mPendingTasks;
    public volatile boolean mReadyToCreateNativeTaskRunner;

    public SequencedTaskRunnerImpl(TaskTraits taskTraits) {
        super(taskTraits, "SequencedTaskRunnerImpl", 1);
        this.mPendingTasks = new AtomicInteger();
    }

    @Override // org.chromium.base.task.TaskRunnerImpl
    public void initNativeTaskRunner() {
        this.mReadyToCreateNativeTaskRunner = true;
        if (this.mPendingTasks.getAndIncrement() == 0) {
            super.initNativeTaskRunner();
        }
    }

    @Override // org.chromium.base.task.TaskRunnerImpl
    public void runPreNativeTask() {
        super.runPreNativeTask();
        if (this.mPendingTasks.decrementAndGet() > 0) {
            if (!this.mReadyToCreateNativeTaskRunner) {
                super.schedulePreNativeTask();
            } else {
                super.initNativeTaskRunner();
            }
        }
    }

    @Override // org.chromium.base.task.TaskRunnerImpl
    public void schedulePreNativeTask() {
        if (this.mPendingTasks.getAndIncrement() == 0) {
            super.schedulePreNativeTask();
        }
    }
}
