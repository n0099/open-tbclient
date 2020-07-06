package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes12.dex */
public class at {
    private final Executor mExecutor;
    private boolean mXI = false;
    private final Deque<Runnable> mXJ = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void G(Runnable runnable) {
        if (this.mXI) {
            this.mXJ.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void dGQ() {
        this.mXI = true;
    }

    public synchronized void dGR() {
        this.mXI = false;
        dGS();
    }

    private void dGS() {
        while (!this.mXJ.isEmpty()) {
            this.mExecutor.execute(this.mXJ.pop());
        }
        this.mXJ.clear();
    }

    public synchronized void H(Runnable runnable) {
        this.mXJ.remove(runnable);
    }
}
