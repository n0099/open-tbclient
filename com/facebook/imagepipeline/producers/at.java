package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes12.dex */
public class at {
    private boolean lWQ = false;
    private final Deque<Runnable> lWR = new ArrayDeque();
    private final Executor mExecutor;

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void z(Runnable runnable) {
        if (this.lWQ) {
            this.lWR.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void dsl() {
        this.lWQ = true;
    }

    public synchronized void dsm() {
        this.lWQ = false;
        dsn();
    }

    private void dsn() {
        while (!this.lWR.isEmpty()) {
            this.mExecutor.execute(this.lWR.pop());
        }
        this.lWR.clear();
    }

    public synchronized void A(Runnable runnable) {
        this.lWR.remove(runnable);
    }
}
