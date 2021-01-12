package com.bytedance.sdk.openadsdk.l;

import java.util.List;
/* loaded from: classes4.dex */
class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f7337a;

    public static d b() {
        if (f7337a == null) {
            synchronized (d.class) {
                if (f7337a == null) {
                    f7337a = new d();
                }
            }
        }
        return f7337a;
    }

    private d() {
    }

    @Override // com.bytedance.sdk.openadsdk.l.a
    public void a(String str, List<String> list, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.l.a
    public void a(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.l.a
    public void a() {
    }
}
