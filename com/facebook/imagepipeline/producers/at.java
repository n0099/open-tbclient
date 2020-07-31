package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public class at {
    private final Executor mExecutor;
    private boolean nfJ = false;
    private final Deque<Runnable> nfK = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void F(Runnable runnable) {
        if (this.nfJ) {
            this.nfK.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void dKc() {
        this.nfJ = true;
    }

    public synchronized void dKd() {
        this.nfJ = false;
        dKe();
    }

    private void dKe() {
        while (!this.nfK.isEmpty()) {
            this.mExecutor.execute(this.nfK.pop());
        }
        this.nfK.clear();
    }

    public synchronized void G(Runnable runnable) {
        this.nfK.remove(runnable);
    }
}
