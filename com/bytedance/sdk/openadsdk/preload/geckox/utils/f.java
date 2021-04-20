package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes5.dex */
public class f implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f30030a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f30031b = com.bytedance.sdk.openadsdk.l.e.a();

    public static f a() {
        if (f30030a == null) {
            synchronized (f.class) {
                if (f30030a == null) {
                    f30030a = new f();
                }
            }
        }
        return f30030a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f30031b.execute(runnable);
    }
}
