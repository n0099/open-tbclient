package com.sdk.base.framework.a.c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes16.dex */
public final class i implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadFactory f4466a = new j();
    private final BlockingQueue<Runnable> b;
    private final ThreadPoolExecutor c;

    public i() {
        this(5);
    }

    private i(int i) {
        this.b = new l();
        this.c = new ThreadPoolExecutor(5, 256, 1L, TimeUnit.SECONDS, this.b, f4466a);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.c.execute(runnable);
    }
}
