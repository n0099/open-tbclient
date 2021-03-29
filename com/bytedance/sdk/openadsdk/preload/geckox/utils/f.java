package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class f implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f30345a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f30346b = com.bytedance.sdk.openadsdk.l.e.a();

    public static f a() {
        if (f30345a == null) {
            synchronized (f.class) {
                if (f30345a == null) {
                    f30345a = new f();
                }
            }
        }
        return f30345a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f30346b.execute(runnable);
    }
}
