package com.bytedance.sdk.openadsdk.preload.geckox.e;

import com.bytedance.sdk.openadsdk.preload.b.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<? extends d<?, ?>>, com.bytedance.sdk.openadsdk.preload.b.b.b> f30273a = new HashMap();

    public void a(Class<? extends d<?, ?>> cls, com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
        synchronized (this.f30273a) {
            com.bytedance.sdk.openadsdk.preload.b.b.b bVar = this.f30273a.get(cls);
            if (bVar == null) {
                bVar = new com.bytedance.sdk.openadsdk.preload.b.b.b(new com.bytedance.sdk.openadsdk.preload.b.b.a[0]);
                this.f30273a.put(cls, bVar);
            }
            bVar.a(aVar);
        }
    }

    public com.bytedance.sdk.openadsdk.preload.b.b.a a(Class<? extends d<?, ?>> cls) {
        com.bytedance.sdk.openadsdk.preload.b.b.b bVar;
        synchronized (this.f30273a) {
            bVar = this.f30273a.get(cls);
        }
        return bVar;
    }
}
