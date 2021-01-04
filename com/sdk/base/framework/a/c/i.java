package com.sdk.base.framework.a.c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes15.dex */
public final class i implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadFactory f13084a = new j();

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<Runnable> f13085b;
    private final ThreadPoolExecutor c;

    public i() {
        this(5);
    }

    private i(int i) {
        this.f13085b = new l();
        this.c = new ThreadPoolExecutor(5, 256, 1L, TimeUnit.SECONDS, this.f13085b, f13084a);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.c.execute(runnable);
    }
}
