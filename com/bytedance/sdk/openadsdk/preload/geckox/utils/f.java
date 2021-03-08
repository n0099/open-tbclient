package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class f implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f5105a;
    private ExecutorService b = com.bytedance.sdk.openadsdk.j.e.a();

    private f() {
    }

    public static f a() {
        if (f5105a == null) {
            synchronized (f.class) {
                if (f5105a == null) {
                    f5105a = new f();
                }
            }
        }
        return f5105a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.b.execute(runnable);
    }
}
