package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class g {
    public static volatile Executor aMT;
    public static volatile ScheduledExecutorService aMU;

    public static void execute(Runnable runnable) {
        if (aMT == null) {
            synchronized (g.class) {
                if (aMT == null) {
                    aMT = GlobalThreadPools.EB();
                }
            }
        }
        aMT.execute(runnable);
    }

    public static void schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (aMU == null) {
            synchronized (g.class) {
                if (aMU == null) {
                    aMU = GlobalThreadPools.EC();
                }
            }
        }
        aMU.schedule(runnable, j, timeUnit);
    }
}
