package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes12.dex */
public class at {
    private boolean mAn = false;
    private final Deque<Runnable> mAo = new ArrayDeque();
    private final Executor mExecutor;

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void G(Runnable runnable) {
        if (this.mAn) {
            this.mAo.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void dBW() {
        this.mAn = true;
    }

    public synchronized void dBX() {
        this.mAn = false;
        dBY();
    }

    private void dBY() {
        while (!this.mAo.isEmpty()) {
            this.mExecutor.execute(this.mAo.pop());
        }
        this.mAo.clear();
    }

    public synchronized void H(Runnable runnable) {
        this.mAo.remove(runnable);
    }
}
