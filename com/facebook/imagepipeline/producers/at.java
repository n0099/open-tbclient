package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes12.dex */
public class at {
    private boolean lXb = false;
    private final Deque<Runnable> lXc = new ArrayDeque();
    private final Executor mExecutor;

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void z(Runnable runnable) {
        if (this.lXb) {
            this.lXc.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void dsm() {
        this.lXb = true;
    }

    public synchronized void dsn() {
        this.lXb = false;
        dso();
    }

    private void dso() {
        while (!this.lXc.isEmpty()) {
            this.mExecutor.execute(this.lXc.pop());
        }
        this.lXc.clear();
    }

    public synchronized void A(Runnable runnable) {
        this.lXc.remove(runnable);
    }
}
