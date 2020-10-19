package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes18.dex */
public class at {
    private final Executor mExecutor;
    private boolean nZg = false;
    private final Deque<Runnable> nZh = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void C(Runnable runnable) {
        if (this.nZg) {
            this.nZh.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void edU() {
        this.nZg = true;
    }

    public synchronized void edV() {
        this.nZg = false;
        edW();
    }

    private void edW() {
        while (!this.nZh.isEmpty()) {
            this.mExecutor.execute(this.nZh.pop());
        }
        this.nZh.clear();
    }

    public synchronized void D(Runnable runnable) {
        this.nZh.remove(runnable);
    }
}
