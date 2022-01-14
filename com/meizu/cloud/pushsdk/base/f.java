package com.meizu.cloud.pushsdk.base;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class f extends i<Executor> implements Executor {

    /* renamed from: c  reason: collision with root package name */
    public static f f58658c;

    public f(Executor executor) {
        super(executor);
    }

    public static f a() {
        if (f58658c == null) {
            synchronized (f.class) {
                if (f58658c == null) {
                    f58658c = new f(new ThreadPoolExecutor(0, 5, 30L, TimeUnit.SECONDS, new LinkedBlockingDeque(100), new RejectedExecutionHandler() { // from class: com.meizu.cloud.pushsdk.base.f.1
                        @Override // java.util.concurrent.RejectedExecutionHandler
                        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                            new Thread(runnable).start();
                        }
                    }));
                }
            }
        }
        return f58658c;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c().execute(runnable);
    }
}
