package com.bytedance.sdk.openadsdk.preload.geckox.statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Long, b> f7807a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a> f7808b = new HashMap();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(long j) {
        b bVar;
        synchronized (f7807a) {
            bVar = f7807a.get(Long.valueOf(j));
            if (bVar == null) {
                bVar = new b();
                f7807a.put(Long.valueOf(j), bVar);
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a(String str) {
        com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a aVar;
        synchronized (this.f7808b) {
            aVar = this.f7808b.get(str);
            if (aVar == null) {
                aVar = new com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a();
                this.f7808b.put(str, aVar);
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a> a() {
        ArrayList arrayList;
        synchronized (this.f7808b) {
            arrayList = new ArrayList(this.f7808b.values());
        }
        return arrayList;
    }
}
