package com.kwad.sdk.core.threads.a;

import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes10.dex */
public final class a extends ScheduledThreadPoolExecutor implements c {
    public static volatile boolean azR;
    public final ConcurrentHashMap<Runnable, Long> azS;
    public long azT;
    public int azU;

    public a(int i, ThreadFactory threadFactory) {
        super(1, threadFactory);
        this.azS = new ConcurrentHashMap<>();
        this.azT = 0L;
        this.azU = 0;
    }

    @Override // com.kwad.sdk.core.threads.a.c
    public final long EN() {
        return this.azT;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (azR && this.azS.containsKey(runnable) && this.azS.get(runnable) != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.azS.get(runnable).longValue();
            if (elapsedRealtime >= 0 && elapsedRealtime < 1800000) {
                long j = this.azT;
                int i = this.azU;
                this.azT = ((j * i) + elapsedRealtime) / (i + 1);
                this.azU = i + 1;
            }
            this.azS.remove(runnable);
        }
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (azR) {
            this.azS.put(runnable, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        super.execute(runnable);
    }
}
