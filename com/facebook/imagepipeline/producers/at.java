package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class at {
    private final Executor mExecutor;
    private boolean pNE = false;
    private final Deque<Runnable> pNF = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void z(Runnable runnable) {
        if (this.pNE) {
            this.pNF.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void A(Runnable runnable) {
        this.pNF.remove(runnable);
    }
}
