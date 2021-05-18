package com.bytedance.sdk.openadsdk.preload.geckox.utils;
/* loaded from: classes6.dex */
public class c {
    public static void a(Throwable th) {
        if (!e.a()) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "throwIfDebug:", th);
        } else {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.b("gecko-debug-tag", "throwIfDebug:", th);
            throw new RuntimeException(th);
        }
    }
}
