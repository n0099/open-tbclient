package com.meizu.cloud.pushsdk.base;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class f extends i<Executor> implements Executor {

    /* renamed from: c  reason: collision with root package name */
    public static f f37521c;

    public f(Executor executor) {
        super(executor);
    }

    public static f a() {
        if (f37521c == null) {
            synchronized (f.class) {
                if (f37521c == null) {
                    f37521c = new f(new ThreadPoolExecutor(0, 5, 30L, TimeUnit.SECONDS, new LinkedBlockingDeque(100), new RejectedExecutionHandler() { // from class: com.meizu.cloud.pushsdk.base.f.1
                        @Override // java.util.concurrent.RejectedExecutionHandler
                        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                            new Thread(runnable).start();
                        }
                    }));
                }
            }
        }
        return f37521c;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c().execute(runnable);
    }
}
