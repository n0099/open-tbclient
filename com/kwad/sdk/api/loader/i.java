package com.kwad.sdk.api.loader;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class i {
    public static final ExecutorService a = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    public static final Handler b = new Handler(Looper.getMainLooper());

    public static Future<?> a(Runnable runnable) {
        return a.submit(runnable);
    }
}
