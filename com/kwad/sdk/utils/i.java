package com.kwad.sdk.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class i {
    public static volatile Executor a = com.kwad.sdk.core.i.b.n();
    public static volatile ScheduledExecutorService b;

    public static void a(Runnable runnable) {
        a.execute(runnable);
    }

    public static void a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (b == null) {
            b = com.kwad.sdk.core.i.b.o();
        }
        b.schedule(runnable, j, timeUnit);
    }
}
