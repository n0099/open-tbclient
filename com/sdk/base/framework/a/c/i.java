package com.sdk.base.framework.a.c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class i implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadFactory f39258a = new j();

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<Runnable> f39259b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadPoolExecutor f39260c;

    public i() {
        this(5);
    }

    public i(int i2) {
        this.f39259b = new l();
        this.f39260c = new ThreadPoolExecutor(5, 256, 1L, TimeUnit.SECONDS, this.f39259b, f39258a);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f39260c.execute(runnable);
    }
}
