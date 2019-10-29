package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class ar {
    private boolean kmM = false;
    private final Deque<Runnable> kmN = new ArrayDeque();
    private final Executor mExecutor;

    public ar(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void s(Runnable runnable) {
        if (this.kmM) {
            this.kmN.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void t(Runnable runnable) {
        this.kmN.remove(runnable);
    }
}
