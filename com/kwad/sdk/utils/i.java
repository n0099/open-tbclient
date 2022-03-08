package com.kwad.sdk.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class i {
    public static volatile Executor a = com.kwad.sdk.core.i.b.n();

    /* renamed from: b  reason: collision with root package name */
    public static volatile ScheduledExecutorService f56511b;

    public static void a(Runnable runnable) {
        a.execute(runnable);
    }

    public static void a(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (f56511b == null) {
            f56511b = com.kwad.sdk.core.i.b.o();
        }
        f56511b.schedule(runnable, j2, timeUnit);
    }
}
