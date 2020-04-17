package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes12.dex */
public class at {
    private final Executor mExecutor;
    private boolean mgs = false;
    private final Deque<Runnable> mgt = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void E(Runnable runnable) {
        if (this.mgs) {
            this.mgt.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void duH() {
        this.mgs = true;
    }

    public synchronized void duI() {
        this.mgs = false;
        duJ();
    }

    private void duJ() {
        while (!this.mgt.isEmpty()) {
            this.mExecutor.execute(this.mgt.pop());
        }
        this.mgt.clear();
    }

    public synchronized void F(Runnable runnable) {
        this.mgt.remove(runnable);
    }
}
