package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class f implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f7821a;

    /* renamed from: b  reason: collision with root package name */
    private ThreadPoolExecutor f7822b = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.utils.f.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("gecko-io-thread");
            thread.setPriority(3);
            return thread;
        }
    });

    private f() {
        this.f7822b.allowCoreThreadTimeOut(true);
    }

    public static f a() {
        if (f7821a == null) {
            synchronized (f.class) {
                if (f7821a == null) {
                    f7821a = new f();
                }
            }
        }
        return f7821a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f7822b.execute(runnable);
    }
}
