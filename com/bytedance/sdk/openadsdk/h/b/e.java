package com.bytedance.sdk.openadsdk.h.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f7484a;

    public static e c() {
        if (f7484a == null) {
            synchronized (e.class) {
                if (f7484a == null) {
                    f7484a = new e();
                }
            }
        }
        return f7484a;
    }

    private e() {
    }

    @Override // com.bytedance.sdk.openadsdk.h.b.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.h.b.a
    public void a(com.bytedance.sdk.openadsdk.h.a.b bVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.h.b.a
    public void a(com.bytedance.sdk.openadsdk.h.a.b bVar, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.h.b.a
    public void b() {
    }
}
