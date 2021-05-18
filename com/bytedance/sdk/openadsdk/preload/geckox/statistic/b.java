package com.bytedance.sdk.openadsdk.preload.geckox.statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<Long, b> f30171a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a> f30172b = new HashMap();

    public static b a(long j) {
        b bVar;
        synchronized (f30171a) {
            bVar = f30171a.get(Long.valueOf(j));
            if (bVar == null) {
                bVar = new b();
                f30171a.put(Long.valueOf(j), bVar);
            }
        }
        return bVar;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a(String str) {
        com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a aVar;
        synchronized (this.f30172b) {
            aVar = this.f30172b.get(str);
            if (aVar == null) {
                aVar = new com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a();
                this.f30172b.put(str, aVar);
            }
        }
        return aVar;
    }

    public List<com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a> a() {
        ArrayList arrayList;
        synchronized (this.f30172b) {
            arrayList = new ArrayList(this.f30172b.values());
        }
        return arrayList;
    }
}
