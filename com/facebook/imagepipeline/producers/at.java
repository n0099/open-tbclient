package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class at {
    private final Executor mExecutor;
    private boolean pPJ = false;
    private final Deque<Runnable> pPK = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void y(Runnable runnable) {
        if (this.pPJ) {
            this.pPK.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void z(Runnable runnable) {
        this.pPK.remove(runnable);
    }
}
