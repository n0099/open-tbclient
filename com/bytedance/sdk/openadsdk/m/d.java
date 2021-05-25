package com.bytedance.sdk.openadsdk.m;

import java.util.List;
/* loaded from: classes6.dex */
public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f29564a;

    public static d b() {
        if (f29564a == null) {
            synchronized (d.class) {
                if (f29564a == null) {
                    f29564a = new d();
                }
            }
        }
        return f29564a;
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
