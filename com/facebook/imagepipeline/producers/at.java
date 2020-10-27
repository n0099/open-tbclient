package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes18.dex */
public class at {
    private final Executor mExecutor;
    private boolean oQy = false;
    private final Deque<Runnable> oQz = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void E(Runnable runnable) {
        if (this.oQy) {
            this.oQz.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void enT() {
        this.oQy = true;
    }

    public synchronized void enU() {
        this.oQy = false;
        enV();
    }

    private void enV() {
        while (!this.oQz.isEmpty()) {
            this.mExecutor.execute(this.oQz.pop());
        }
        this.oQz.clear();
    }

    public synchronized void F(Runnable runnable) {
        this.oQz.remove(runnable);
    }
}
