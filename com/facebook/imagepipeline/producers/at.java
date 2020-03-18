package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes12.dex */
public class at {
    private boolean lYH = false;
    private final Deque<Runnable> lYI = new ArrayDeque();
    private final Executor mExecutor;

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void z(Runnable runnable) {
        if (this.lYH) {
            this.lYI.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void dsJ() {
        this.lYH = true;
    }

    public synchronized void dsK() {
        this.lYH = false;
        dsL();
    }

    private void dsL() {
        while (!this.lYI.isEmpty()) {
            this.mExecutor.execute(this.lYI.pop());
        }
        this.lYI.clear();
    }

    public synchronized void A(Runnable runnable) {
        this.lYI.remove(runnable);
    }
}
