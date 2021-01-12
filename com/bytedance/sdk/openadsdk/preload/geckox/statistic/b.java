package com.bytedance.sdk.openadsdk.preload.geckox.statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Long, b> f7507a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a> f7508b = new HashMap();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(long j) {
        b bVar;
        synchronized (f7507a) {
            bVar = f7507a.get(Long.valueOf(j));
            if (bVar == null) {
                bVar = new b();
                f7507a.put(Long.valueOf(j), bVar);
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a(String str) {
        com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a aVar;
        synchronized (this.f7508b) {
            aVar = this.f7508b.get(str);
            if (aVar == null) {
                aVar = new com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a();
                this.f7508b.put(str, aVar);
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a> a() {
        ArrayList arrayList;
        synchronized (this.f7508b) {
            arrayList = new ArrayList(this.f7508b.values());
        }
        return arrayList;
    }
}
