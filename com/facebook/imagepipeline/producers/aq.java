package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class aq {
    private boolean ivJ = false;
    private final Deque<Runnable> ivK = new ArrayDeque();
    private final Executor mExecutor;

    public aq(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void n(Runnable runnable) {
        if (this.ivJ) {
            this.ivK.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void remove(Runnable runnable) {
        this.ivK.remove(runnable);
    }
}
