package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public class at {
    private final Executor mExecutor;
    private boolean pHw = false;
    private final Deque<Runnable> pHx = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void B(Runnable runnable) {
        if (this.pHw) {
            this.pHx.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void C(Runnable runnable) {
        this.pHx.remove(runnable);
    }
}
