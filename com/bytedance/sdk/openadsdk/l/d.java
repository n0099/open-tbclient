package com.bytedance.sdk.openadsdk.l;

import java.util.List;
/* loaded from: classes4.dex */
class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f7636a;

    public static d b() {
        if (f7636a == null) {
            synchronized (d.class) {
                if (f7636a == null) {
                    f7636a = new d();
                }
            }
        }
        return f7636a;
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
