package com.bytedance.sdk.openadsdk.preload.a;

import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public final class o extends l {

    /* renamed from: a  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.preload.a.b.h<String, l> f5035a = new com.bytedance.sdk.openadsdk.preload.a.b.h<>();

    public void a(String str, l lVar) {
        com.bytedance.sdk.openadsdk.preload.a.b.h<String, l> hVar = this.f5035a;
        if (lVar == null) {
            lVar = n.f5034a;
        }
        hVar.put(str, lVar);
    }

    public Set<Map.Entry<String, l>> n() {
        return this.f5035a.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f5035a.equals(this.f5035a));
    }

    public int hashCode() {
        return this.f5035a.hashCode();
    }
}
