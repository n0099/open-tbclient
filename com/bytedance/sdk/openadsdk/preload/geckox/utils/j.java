package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes5.dex */
public class j implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f30959a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f30960b = com.bytedance.sdk.openadsdk.l.e.a();

    public static j a() {
        if (f30959a == null) {
            synchronized (j.class) {
                if (f30959a == null) {
                    f30959a = new j();
                }
            }
        }
        return f30959a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f30960b.execute(runnable);
    }
}
