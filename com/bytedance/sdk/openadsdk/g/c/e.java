package com.bytedance.sdk.openadsdk.g.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f4780a;

    public static e c() {
        if (f4780a == null) {
            synchronized (e.class) {
                if (f4780a == null) {
                    f4780a = new e();
                }
            }
        }
        return f4780a;
    }

    private e() {
    }

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void a(com.bytedance.sdk.openadsdk.g.a.a aVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void a(com.bytedance.sdk.openadsdk.g.a.a aVar, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.g.c.a
    public void b() {
    }
}
