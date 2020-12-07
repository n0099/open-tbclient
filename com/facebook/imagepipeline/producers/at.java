package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes15.dex */
public class at {
    private final Executor mExecutor;
    private boolean pqo = false;
    private final Deque<Runnable> pqp = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void E(Runnable runnable) {
        if (this.pqo) {
            this.pqp.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void F(Runnable runnable) {
        this.pqp.remove(runnable);
    }
}
