package com.bytedance.sdk.openadsdk.m;

import java.util.List;
/* loaded from: classes5.dex */
public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f29485a;

    public static d b() {
        if (f29485a == null) {
            synchronized (d.class) {
                if (f29485a == null) {
                    f29485a = new d();
                }
            }
        }
        return f29485a;
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
