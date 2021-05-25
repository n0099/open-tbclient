package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class j implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f30133a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f30134b = com.bytedance.sdk.openadsdk.l.e.a();

    public static j a() {
        if (f30133a == null) {
            synchronized (j.class) {
                if (f30133a == null) {
                    f30133a = new j();
                }
            }
        }
        return f30133a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f30134b.execute(runnable);
    }
}
