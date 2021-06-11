package com.bytedance.sdk.openadsdk.preload.a;

import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public final class o extends l {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.h<String, l> f30021a = new com.bytedance.sdk.openadsdk.preload.a.b.h<>();

    public void a(String str, l lVar) {
        com.bytedance.sdk.openadsdk.preload.a.b.h<String, l> hVar = this.f30021a;
        if (lVar == null) {
            lVar = n.f30020a;
        }
        hVar.put(str, lVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f30021a.equals(this.f30021a));
    }

    public int hashCode() {
        return this.f30021a.hashCode();
    }

    public Set<Map.Entry<String, l>> n() {
        return this.f30021a.entrySet();
    }
}
