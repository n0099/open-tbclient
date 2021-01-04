package com.bytedance.sdk.openadsdk.preload.geckox.statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Long, b> f7806a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a> f7807b = new HashMap();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(long j) {
        b bVar;
        synchronized (f7806a) {
            bVar = f7806a.get(Long.valueOf(j));
            if (bVar == null) {
                bVar = new b();
                f7806a.put(Long.valueOf(j), bVar);
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a(String str) {
        com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a aVar;
        synchronized (this.f7807b) {
            aVar = this.f7807b.get(str);
            if (aVar == null) {
                aVar = new com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a();
                this.f7807b.put(str, aVar);
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a> a() {
        ArrayList arrayList;
        synchronized (this.f7807b) {
            arrayList = new ArrayList(this.f7807b.values());
        }
        return arrayList;
    }
}
