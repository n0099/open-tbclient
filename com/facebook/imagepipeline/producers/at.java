package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes8.dex */
public class at {
    private final Executor mExecutor;
    private boolean nzA = false;
    private final Deque<Runnable> nzB = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void C(Runnable runnable) {
        if (this.nzA) {
            this.nzB.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void dWc() {
        this.nzA = true;
    }

    public synchronized void dWd() {
        this.nzA = false;
        dWe();
    }

    private void dWe() {
        while (!this.nzB.isEmpty()) {
            this.mExecutor.execute(this.nzB.pop());
        }
        this.nzB.clear();
    }

    public synchronized void D(Runnable runnable) {
        this.nzB.remove(runnable);
    }
}
