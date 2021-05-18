package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class j implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f30204a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f30205b = com.bytedance.sdk.openadsdk.l.e.a();

    public static j a() {
        if (f30204a == null) {
            synchronized (j.class) {
                if (f30204a == null) {
                    f30204a = new j();
                }
            }
        }
        return f30204a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f30205b.execute(runnable);
    }
}
