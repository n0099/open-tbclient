package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public final class d {
    public static c.d aQu;
    public static volatile Executor aQv;
    public static ExecutorService aQw = Executors.newSingleThreadExecutor();

    public static Executor getExecutor() {
        if (aQv == null) {
            synchronized (d.class) {
                if (aQv == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    aQv = threadPoolExecutor;
                }
            }
        }
        return aQv;
    }

    public static void a(c.d dVar) {
        aQu = dVar;
    }

    public static void setExecutor(Executor executor) {
        if (executor != null) {
            aQv = executor;
        }
    }
}
