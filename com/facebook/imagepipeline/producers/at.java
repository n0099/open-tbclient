package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class at {
    private final Executor mExecutor;
    private boolean pFQ = false;
    private final Deque<Runnable> pFR = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void B(Runnable runnable) {
        if (this.pFQ) {
            this.pFR.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void C(Runnable runnable) {
        this.pFR.remove(runnable);
    }
}
