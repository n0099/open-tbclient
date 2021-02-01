package com.bytedance.sdk.openadsdk.l;

import java.util.List;
/* loaded from: classes6.dex */
class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f7339a;

    public static d b() {
        if (f7339a == null) {
            synchronized (d.class) {
                if (f7339a == null) {
                    f7339a = new d();
                }
            }
        }
        return f7339a;
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
