package com.sdk.base.framework.a.c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class i implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadFactory f38729a = new j();

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<Runnable> f38730b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadPoolExecutor f38731c;

    public i() {
        this(5);
    }

    public i(int i) {
        this.f38730b = new l();
        this.f38731c = new ThreadPoolExecutor(5, 256, 1L, TimeUnit.SECONDS, this.f38730b, f38729a);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f38731c.execute(runnable);
    }
}
