package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes10.dex */
public class at {
    private boolean lWh = false;
    private final Deque<Runnable> lWi = new ArrayDeque();
    private final Executor mExecutor;

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void z(Runnable runnable) {
        if (this.lWh) {
            this.lWi.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void dqX() {
        this.lWh = true;
    }

    public synchronized void dqY() {
        this.lWh = false;
        dqZ();
    }

    private void dqZ() {
        while (!this.lWi.isEmpty()) {
            this.mExecutor.execute(this.lWi.pop());
        }
        this.lWi.clear();
    }

    public synchronized void A(Runnable runnable) {
        this.lWi.remove(runnable);
    }
}
