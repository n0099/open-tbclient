package com.bytedance.sdk.openadsdk.preload.a;

import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public final class o extends l {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.h<String, l> f30138a = new com.bytedance.sdk.openadsdk.preload.a.b.h<>();

    public void a(String str, l lVar) {
        com.bytedance.sdk.openadsdk.preload.a.b.h<String, l> hVar = this.f30138a;
        if (lVar == null) {
            lVar = n.f30137a;
        }
        hVar.put(str, lVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f30138a.equals(this.f30138a));
    }

    public int hashCode() {
        return this.f30138a.hashCode();
    }

    public Set<Map.Entry<String, l>> n() {
        return this.f30138a.entrySet();
    }
}
