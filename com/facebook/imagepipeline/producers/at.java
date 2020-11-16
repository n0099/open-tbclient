package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes15.dex */
public class at {
    private final Executor mExecutor;
    private boolean pbw = false;
    private final Deque<Runnable> pbx = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void E(Runnable runnable) {
        if (this.pbw) {
            this.pbx.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void erH() {
        this.pbw = true;
    }

    public synchronized void erI() {
        this.pbw = false;
        erJ();
    }

    private void erJ() {
        while (!this.pbx.isEmpty()) {
            this.mExecutor.execute(this.pbx.pop());
        }
        this.pbx.clear();
    }

    public synchronized void F(Runnable runnable) {
        this.pbx.remove(runnable);
    }
}
