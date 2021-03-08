package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class j implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private static volatile j f5108a;
    private ExecutorService b = com.bytedance.sdk.openadsdk.j.e.a();

    private j() {
    }

    public static j a() {
        if (f5108a == null) {
            synchronized (j.class) {
                if (f5108a == null) {
                    f5108a = new j();
                }
            }
        }
        return f5108a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.b.execute(runnable);
    }
}
