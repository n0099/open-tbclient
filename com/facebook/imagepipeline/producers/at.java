package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class at {
    private final Executor mExecutor;
    private boolean pNe = false;
    private final Deque<Runnable> pNf = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void z(Runnable runnable) {
        if (this.pNe) {
            this.pNf.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void A(Runnable runnable) {
        this.pNf.remove(runnable);
    }
}
