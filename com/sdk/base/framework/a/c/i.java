package com.sdk.base.framework.a.c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class i implements Executor {
    private static final ThreadFactory a = new j();
    private final BlockingQueue<Runnable> b;
    private final ThreadPoolExecutor c;

    public i() {
        this(5);
    }

    private i(int i) {
        this.b = new l();
        this.c = new ThreadPoolExecutor(5, 256, 1L, TimeUnit.SECONDS, this.b, a);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.c.execute(runnable);
    }
}
