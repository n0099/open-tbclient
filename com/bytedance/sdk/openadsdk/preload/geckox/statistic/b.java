package com.bytedance.sdk.openadsdk.preload.geckox.statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<Long, b> f30203a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a> f30204b = new HashMap();

    public static b a(long j) {
        b bVar;
        synchronized (f30203a) {
            bVar = f30203a.get(Long.valueOf(j));
            if (bVar == null) {
                bVar = new b();
                f30203a.put(Long.valueOf(j), bVar);
            }
        }
        return bVar;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a(String str) {
        com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a aVar;
        synchronized (this.f30204b) {
            aVar = this.f30204b.get(str);
            if (aVar == null) {
                aVar = new com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a();
                this.f30204b.put(str, aVar);
            }
        }
        return aVar;
    }

    public List<com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a> a() {
        ArrayList arrayList;
        synchronized (this.f30204b) {
            arrayList = new ArrayList(this.f30204b.values());
        }
        return arrayList;
    }
}
