package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes12.dex */
public class at {
    private boolean lWO = false;
    private final Deque<Runnable> lWP = new ArrayDeque();
    private final Executor mExecutor;

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void z(Runnable runnable) {
        if (this.lWO) {
            this.lWP.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void dsj() {
        this.lWO = true;
    }

    public synchronized void dsk() {
        this.lWO = false;
        dsl();
    }

    private void dsl() {
        while (!this.lWP.isEmpty()) {
            this.mExecutor.execute(this.lWP.pop());
        }
        this.lWP.clear();
    }

    public synchronized void A(Runnable runnable) {
        this.lWP.remove(runnable);
    }
}
