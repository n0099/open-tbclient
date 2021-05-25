package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class f implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f30129a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f30130b = com.bytedance.sdk.openadsdk.l.e.a();

    public static f a() {
        if (f30129a == null) {
            synchronized (f.class) {
                if (f30129a == null) {
                    f30129a = new f();
                }
            }
        }
        return f30129a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f30130b.execute(runnable);
    }
}
