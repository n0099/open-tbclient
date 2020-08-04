package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public class at {
    private final Executor mExecutor;
    private boolean nfL = false;
    private final Deque<Runnable> nfM = new ArrayDeque();

    public at(Executor executor) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
    }

    public synchronized void F(Runnable runnable) {
        if (this.nfL) {
            this.nfM.add(runnable);
        } else {
            this.mExecutor.execute(runnable);
        }
    }

    public synchronized void dKd() {
        this.nfL = true;
    }

    public synchronized void dKe() {
        this.nfL = false;
        dKf();
    }

    private void dKf() {
        while (!this.nfM.isEmpty()) {
            this.mExecutor.execute(this.nfM.pop());
        }
        this.nfM.clear();
    }

    public synchronized void G(Runnable runnable) {
        this.nfM.remove(runnable);
    }
}
