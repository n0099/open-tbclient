package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes12.dex */
public class at {
    private final Executor mExecutor;
    private boolean mXF = false;
    private final Deque<Runnable> mXG = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void G(Runnable runnable) {
        if (this.mXF) {
            this.mXG.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void dGM() {
        this.mXF = true;
    }

    public synchronized void dGN() {
        this.mXF = false;
        dGO();
    }

    private void dGO() {
        while (!this.mXG.isEmpty()) {
            this.mExecutor.execute(this.mXG.pop());
        }
        this.mXG.clear();
    }

    public synchronized void H(Runnable runnable) {
        this.mXG.remove(runnable);
    }
}
