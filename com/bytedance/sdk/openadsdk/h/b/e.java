package com.bytedance.sdk.openadsdk.h.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f7483a;

    public static e c() {
        if (f7483a == null) {
            synchronized (e.class) {
                if (f7483a == null) {
                    f7483a = new e();
                }
            }
        }
        return f7483a;
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
