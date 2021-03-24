package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public class ThreadHandoffProducerQueue {
    public final Executor mExecutor;
    public boolean mQueueing = false;
    public final Deque<Runnable> mRunnableList = new ArrayDeque();

    public ThreadHandoffProducerQueue(Executor executor) {
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
    }

    private void execInQueue() {
        while (!this.mRunnableList.isEmpty()) {
            this.mExecutor.execute(this.mRunnableList.pop());
        }
        this.mRunnableList.clear();
    }

    public synchronized void addToQueueOrExecute(Runnable runnable) {
        if (this.mQueueing) {
            this.mRunnableList.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized boolean isQueueing() {
        return this.mQueueing;
    }

    public synchronized void remove(Runnable runnable) {
        this.mRunnableList.remove(runnable);
    }

    public synchronized void startQueueing() {
        this.mQueueing = true;
    }

    public synchronized void stopQueuing() {
        this.mQueueing = false;
        execInQueue();
    }
}
