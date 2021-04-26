package com.bytedance.sdk.openadsdk.m;

import java.util.List;
/* loaded from: classes5.dex */
public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f30390a;

    public static d b() {
        if (f30390a == null) {
            synchronized (d.class) {
                if (f30390a == null) {
                    f30390a = new d();
                }
            }
        }
        return f30390a;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public void a(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public void a(String str, List<String> list, boolean z) {
    }
}
