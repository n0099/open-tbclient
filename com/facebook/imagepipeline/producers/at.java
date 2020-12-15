package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes15.dex */
public class at {
    private final Executor mExecutor;
    private boolean pqq = false;
    private final Deque<Runnable> pqr = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void E(Runnable runnable) {
        if (this.pqq) {
            this.pqr.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void F(Runnable runnable) {
        this.pqr.remove(runnable);
    }
}
