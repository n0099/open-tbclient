package com.win.opensdk.bridge.async;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class AsyncTaskExecutor {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadPoolExecutor f40180a = new ThreadPoolExecutor(3, 3, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new AsyncTaskThreadFactory());

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void runOnAsyncThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f40180a.execute(runnable);
    }

    public static void runOnMainThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public static void shutDown() {
        ThreadPoolExecutor threadPoolExecutor = f40180a;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown() || f40180a.isTerminating()) {
            return;
        }
        f40180a.shutdown();
    }
}
