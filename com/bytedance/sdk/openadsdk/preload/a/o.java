package com.bytedance.sdk.openadsdk.preload.a;

import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public final class o extends l {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.h<String, l> f29823a = new com.bytedance.sdk.openadsdk.preload.a.b.h<>();

    public void a(String str, l lVar) {
        com.bytedance.sdk.openadsdk.preload.a.b.h<String, l> hVar = this.f29823a;
        if (lVar == null) {
            lVar = n.f29822a;
        }
        hVar.put(str, lVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f29823a.equals(this.f29823a));
    }

    public int hashCode() {
        return this.f29823a.hashCode();
    }

    public Set<Map.Entry<String, l>> n() {
        return this.f29823a.entrySet();
    }
}
