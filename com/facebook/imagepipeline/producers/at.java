package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes10.dex */
public class at {
    private boolean lWc = false;
    private final Deque<Runnable> lWd = new ArrayDeque();
    private final Executor mExecutor;

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void z(Runnable runnable) {
        if (this.lWc) {
            this.lWd.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void dqV() {
        this.lWc = true;
    }

    public synchronized void dqW() {
        this.lWc = false;
        dqX();
    }

    private void dqX() {
        while (!this.lWd.isEmpty()) {
            this.mExecutor.execute(this.lWd.pop());
        }
        this.lWd.clear();
    }

    public synchronized void A(Runnable runnable) {
        this.lWd.remove(runnable);
    }
}
