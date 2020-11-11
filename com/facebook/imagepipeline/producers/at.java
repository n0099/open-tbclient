package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes18.dex */
public class at {
    private final Executor mExecutor;
    private boolean oZR = false;
    private final Deque<Runnable> oZS = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void E(Runnable runnable) {
        if (this.oZR) {
            this.oZS.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void erJ() {
        this.oZR = true;
    }

    public synchronized void erK() {
        this.oZR = false;
        erL();
    }

    private void erL() {
        while (!this.oZS.isEmpty()) {
            this.mExecutor.execute(this.oZS.pop());
        }
        this.oZS.clear();
    }

    public synchronized void F(Runnable runnable) {
        this.oZS.remove(runnable);
    }
}
