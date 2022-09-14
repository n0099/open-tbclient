package com.kwad.sdk.utils.kwai;

import com.kwad.sdk.utils.kwai.c;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class d {
    public static c.d aqi;
    public static volatile Executor aqj;
    public static ExecutorService aqk = Executors.newSingleThreadExecutor();

    public static void a(c.d dVar) {
        aqi = dVar;
    }

    public static Executor getExecutor() {
        if (aqj == null) {
            synchronized (d.class) {
                if (aqj == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    aqj = threadPoolExecutor;
                }
            }
        }
        return aqj;
    }

    public static void setExecutor(Executor executor) {
        if (executor != null) {
            aqj = executor;
        }
    }
}
