package com.kwad.sdk.api.loader;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public final class k {
    public static final ExecutorService Sr = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    public static final Handler Ss = new Handler(Looper.getMainLooper());

    public static Future<?> b(Runnable runnable) {
        return Sr.submit(runnable);
    }
}
