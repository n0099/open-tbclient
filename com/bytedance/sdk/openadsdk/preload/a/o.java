package com.bytedance.sdk.openadsdk.preload.a;

import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public final class o extends l {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.h<String, l> f30103a = new com.bytedance.sdk.openadsdk.preload.a.b.h<>();

    public void a(String str, l lVar) {
        com.bytedance.sdk.openadsdk.preload.a.b.h<String, l> hVar = this.f30103a;
        if (lVar == null) {
            lVar = n.f30102a;
        }
        hVar.put(str, lVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f30103a.equals(this.f30103a));
    }

    public int hashCode() {
        return this.f30103a.hashCode();
    }

    public Set<Map.Entry<String, l>> n() {
        return this.f30103a.entrySet();
    }
}
