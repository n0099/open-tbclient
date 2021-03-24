package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class j implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f30348a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f30349b = com.bytedance.sdk.openadsdk.l.e.a();

    public static j a() {
        if (f30348a == null) {
            synchronized (j.class) {
                if (f30348a == null) {
                    f30348a = new j();
                }
            }
        }
        return f30348a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f30349b.execute(runnable);
    }
}
