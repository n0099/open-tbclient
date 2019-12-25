package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes9.dex */
public class at {
    private boolean lSo = false;
    private final Deque<Runnable> lSp = new ArrayDeque();
    private final Executor mExecutor;

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void z(Runnable runnable) {
        if (this.lSo) {
            this.lSp.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void A(Runnable runnable) {
        this.lSp.remove(runnable);
    }
}
