package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes25.dex */
public class at {
    private final Executor mExecutor;
    private boolean nJP = false;
    private final Deque<Runnable> nJQ = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void C(Runnable runnable) {
        if (this.nJP) {
            this.nJQ.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void eaj() {
        this.nJP = true;
    }

    public synchronized void eak() {
        this.nJP = false;
        eal();
    }

    private void eal() {
        while (!this.nJQ.isEmpty()) {
            this.mExecutor.execute(this.nJQ.pop());
        }
        this.nJQ.clear();
    }

    public synchronized void D(Runnable runnable) {
        this.nJQ.remove(runnable);
    }
}
