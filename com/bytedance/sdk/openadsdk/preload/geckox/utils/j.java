package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class j implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private static volatile j f7529a;

    /* renamed from: b  reason: collision with root package name */
    private ThreadPoolExecutor f7530b = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.utils.j.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("gecko-piecemeal-thread");
            return thread;
        }
    });

    private j() {
        this.f7530b.allowCoreThreadTimeOut(true);
    }

    public static j a() {
        if (f7529a == null) {
            synchronized (j.class) {
                if (f7529a == null) {
                    f7529a = new j();
                }
            }
        }
        return f7529a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f7530b.execute(runnable);
    }
}
