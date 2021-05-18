package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class f implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f30200a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f30201b = com.bytedance.sdk.openadsdk.l.e.a();

    public static f a() {
        if (f30200a == null) {
            synchronized (f.class) {
                if (f30200a == null) {
                    f30200a = new f();
                }
            }
        }
        return f30200a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f30201b.execute(runnable);
    }
}
