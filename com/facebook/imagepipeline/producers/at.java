package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes12.dex */
public class at {
    private boolean mBy = false;
    private final Deque<Runnable> mBz = new ArrayDeque();
    private final Executor mExecutor;

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void G(Runnable runnable) {
        if (this.mBy) {
            this.mBz.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void dCk() {
        this.mBy = true;
    }

    public synchronized void dCl() {
        this.mBy = false;
        dCm();
    }

    private void dCm() {
        while (!this.mBz.isEmpty()) {
            this.mExecutor.execute(this.mBz.pop());
        }
        this.mBz.clear();
    }

    public synchronized void H(Runnable runnable) {
        this.mBz.remove(runnable);
    }
}
