package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class ar {
    private boolean kdQ = false;
    private final Deque<Runnable> kdR = new ArrayDeque();
    private final Executor mExecutor;

    public ar(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void u(Runnable runnable) {
        if (this.kdQ) {
            this.kdR.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void remove(Runnable runnable) {
        this.kdR.remove(runnable);
    }
}
