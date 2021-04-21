package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes5.dex */
public class f implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f30038a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f30039b = com.bytedance.sdk.openadsdk.l.e.a();

    public static f a() {
        if (f30038a == null) {
            synchronized (f.class) {
                if (f30038a == null) {
                    f30038a = new f();
                }
            }
        }
        return f30038a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f30039b.execute(runnable);
    }
}
