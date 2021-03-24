package com.bytedance.sdk.openadsdk.preload.a;

import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public final class o extends l {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.h<String, l> f30137a = new com.bytedance.sdk.openadsdk.preload.a.b.h<>();

    public void a(String str, l lVar) {
        com.bytedance.sdk.openadsdk.preload.a.b.h<String, l> hVar = this.f30137a;
        if (lVar == null) {
            lVar = n.f30136a;
        }
        hVar.put(str, lVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f30137a.equals(this.f30137a));
    }

    public int hashCode() {
        return this.f30137a.hashCode();
    }

    public Set<Map.Entry<String, l>> n() {
        return this.f30137a.entrySet();
    }
}
