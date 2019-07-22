package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class ar {
    private boolean kkX = false;
    private final Deque<Runnable> kkY = new ArrayDeque();
    private final Executor mExecutor;

    public ar(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void v(Runnable runnable) {
        if (this.kkX) {
            this.kkY.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void remove(Runnable runnable) {
        this.kkY.remove(runnable);
    }
}
