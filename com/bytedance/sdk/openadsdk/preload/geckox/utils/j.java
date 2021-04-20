package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes5.dex */
public class j implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f30034a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f30035b = com.bytedance.sdk.openadsdk.l.e.a();

    public static j a() {
        if (f30034a == null) {
            synchronized (j.class) {
                if (f30034a == null) {
                    f30034a = new j();
                }
            }
        }
        return f30034a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f30035b.execute(runnable);
    }
}
