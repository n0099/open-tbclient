package com.bytedance.sdk.openadsdk.preload.geckox.e;

import com.bytedance.sdk.openadsdk.preload.b.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<? extends d<?, ?>>, com.bytedance.sdk.openadsdk.preload.b.b.b> f29959a = new HashMap();

    public void a(Class<? extends d<?, ?>> cls, com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
        synchronized (this.f29959a) {
            com.bytedance.sdk.openadsdk.preload.b.b.b bVar = this.f29959a.get(cls);
            if (bVar == null) {
                bVar = new com.bytedance.sdk.openadsdk.preload.b.b.b(new com.bytedance.sdk.openadsdk.preload.b.b.a[0]);
                this.f29959a.put(cls, bVar);
            }
            bVar.a(aVar);
        }
    }

    public com.bytedance.sdk.openadsdk.preload.b.b.a a(Class<? extends d<?, ?>> cls) {
        com.bytedance.sdk.openadsdk.preload.b.b.b bVar;
        synchronized (this.f29959a) {
            bVar = this.f29959a.get(cls);
        }
        return bVar;
    }
}
