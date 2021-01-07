package com.bytedance.sdk.openadsdk.preload.geckox.e;

import com.bytedance.sdk.openadsdk.preload.a.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<? extends d<?, ?>>, com.bytedance.sdk.openadsdk.preload.a.b.b> f7777a = new HashMap();

    public void a(Class<? extends d<?, ?>> cls, com.bytedance.sdk.openadsdk.preload.a.b.a aVar) {
        synchronized (this.f7777a) {
            com.bytedance.sdk.openadsdk.preload.a.b.b bVar = this.f7777a.get(cls);
            if (bVar == null) {
                bVar = new com.bytedance.sdk.openadsdk.preload.a.b.b(new com.bytedance.sdk.openadsdk.preload.a.b.a[0]);
                this.f7777a.put(cls, bVar);
            }
            bVar.a(aVar);
        }
    }

    public com.bytedance.sdk.openadsdk.preload.a.b.a a(Class<? extends d<?, ?>> cls) {
        com.bytedance.sdk.openadsdk.preload.a.b.b bVar;
        synchronized (this.f7777a) {
            bVar = this.f7777a.get(cls);
        }
        return bVar;
    }
}
