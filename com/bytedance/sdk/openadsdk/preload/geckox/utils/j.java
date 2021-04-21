package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes5.dex */
public class j implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f30042a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f30043b = com.bytedance.sdk.openadsdk.l.e.a();

    public static j a() {
        if (f30042a == null) {
            synchronized (j.class) {
                if (f30042a == null) {
                    f30042a = new j();
                }
            }
        }
        return f30042a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f30043b.execute(runnable);
    }
}
