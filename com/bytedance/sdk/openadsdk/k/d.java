package com.bytedance.sdk.openadsdk.k;

import java.util.List;
/* loaded from: classes6.dex */
class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f4876a;

    public static d b() {
        if (f4876a == null) {
            synchronized (d.class) {
                if (f4876a == null) {
                    f4876a = new d();
                }
            }
        }
        return f4876a;
    }

    private d() {
    }

    @Override // com.bytedance.sdk.openadsdk.k.a
    public void a(String str, List<String> list, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.k.a
    public void a(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.k.a
    public void a() {
    }
}
