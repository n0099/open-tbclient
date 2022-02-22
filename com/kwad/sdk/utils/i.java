package com.kwad.sdk.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class i {
    public static volatile Executor a = com.kwad.sdk.core.i.b.n();

    /* renamed from: b  reason: collision with root package name */
    public static volatile ScheduledExecutorService f58161b;

    public static void a(Runnable runnable) {
        a.execute(runnable);
    }

    public static void a(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (f58161b == null) {
            f58161b = com.kwad.sdk.core.i.b.o();
        }
        f58161b.schedule(runnable, j2, timeUnit);
    }
}
