package com.meizu.cloud.pushsdk.common.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class f {
    private static ExecutorService a;

    private static synchronized Executor a() {
        ExecutorService executorService;
        synchronized (f.class) {
            if (a == null) {
                a = new ThreadPoolExecutor(0, 5, 180L, TimeUnit.SECONDS, new ArrayBlockingQueue(100, true));
            }
            executorService = a;
        }
        return executorService;
    }

    public static void a(a aVar) {
        a();
        try {
            a.execute(aVar);
        } catch (RejectedExecutionException e) {
            new Thread(aVar).start();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class a implements Runnable {
        public abstract void a();

        @Override // java.lang.Runnable
        public final void run() {
            a();
        }
    }
}
