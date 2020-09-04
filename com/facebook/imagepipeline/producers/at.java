package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes8.dex */
public class at {
    private final Executor mExecutor;
    private boolean nzS = false;
    private final Deque<Runnable> nzT = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void C(Runnable runnable) {
        if (this.nzS) {
            this.nzT.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void dWl() {
        this.nzS = true;
    }

    public synchronized void dWm() {
        this.nzS = false;
        dWn();
    }

    private void dWn() {
        while (!this.nzT.isEmpty()) {
            this.mExecutor.execute(this.nzT.pop());
        }
        this.nzT.clear();
    }

    public synchronized void D(Runnable runnable) {
        this.nzT.remove(runnable);
    }
}
