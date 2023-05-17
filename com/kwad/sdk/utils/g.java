package com.kwad.sdk.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public final class g {
    public static volatile Executor amY = com.kwad.sdk.core.threads.b.vq();
    public static volatile ScheduledExecutorService amZ;

    public static void execute(Runnable runnable) {
        amY.execute(runnable);
    }

    public static void runOnDefaultExecutor(Runnable runnable) {
        amY.execute(runnable);
    }

    public static void schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (amZ == null) {
            amZ = com.kwad.sdk.core.threads.b.vr();
        }
        amZ.schedule(runnable, j, timeUnit);
    }
}
