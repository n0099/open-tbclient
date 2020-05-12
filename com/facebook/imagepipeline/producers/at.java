package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes12.dex */
public class at {
    private final Executor mExecutor;
    private boolean mgw = false;
    private final Deque<Runnable> mgx = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void E(Runnable runnable) {
        if (this.mgw) {
            this.mgx.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void duF() {
        this.mgw = true;
    }

    public synchronized void duG() {
        this.mgw = false;
        duH();
    }

    private void duH() {
        while (!this.mgx.isEmpty()) {
            this.mExecutor.execute(this.mgx.pop());
        }
        this.mgx.clear();
    }

    public synchronized void F(Runnable runnable) {
        this.mgx.remove(runnable);
    }
}
