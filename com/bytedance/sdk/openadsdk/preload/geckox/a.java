package com.bytedance.sdk.openadsdk.preload.geckox;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.preload.b.d;
import com.bytedance.sdk.openadsdk.preload.geckox.model.CheckRequestBodyModel;
import com.bytedance.sdk.openadsdk.preload.geckox.statistic.c;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f30179a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.geckox.e.b f30180b = new com.bytedance.sdk.openadsdk.preload.geckox.e.b();

    /* renamed from: c  reason: collision with root package name */
    public Queue<String> f30181c = new LinkedBlockingQueue();

    /* renamed from: d  reason: collision with root package name */
    public b f30182d;

    /* renamed from: e  reason: collision with root package name */
    public File f30183e;

    public a(b bVar) {
        this.f30182d = bVar;
        File m = bVar.m();
        this.f30183e = m;
        m.mkdirs();
        c.a(this, this.f30182d);
    }

    public static a a(b bVar) {
        if (bVar != null) {
            List<String> e2 = bVar.e();
            if (e2 != null && !e2.isEmpty()) {
                g.a(bVar.a());
                return new a(bVar);
            }
            throw new IllegalArgumentException("access key empty");
        }
        throw new IllegalArgumentException("config == null");
    }

    private boolean b(Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        if (map != null && !map.isEmpty()) {
            List<String> e2 = this.f30182d.e();
            for (Map.Entry<String, List<CheckRequestBodyModel.TargetChannel>> entry : map.entrySet()) {
                boolean z = false;
                for (String str : e2) {
                    if (TextUtils.equals(str, entry.getKey())) {
                        z = true;
                    }
                }
                if (!z) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f30182d.e());
        a(com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(new com.bytedance.sdk.openadsdk.preload.geckox.k.a.a(arrayList)), 100);
    }

    public void a(Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        a("default", null, map, null);
    }

    public void a(final String str, final Map<String, Map<String, Object>> map, final Map<String, List<CheckRequestBodyModel.TargetChannel>> map2, final com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            if (a()) {
                if (b(map2)) {
                    this.f30182d.g().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.openadsdk.preload.geckox.a.a.b bVar;
                            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start check update...", str);
                            if (a.this.f30182d.b() != null) {
                                bVar = a.this.f30182d.b().a();
                                bVar.a(a.this.f30182d.b(), a.this.f30182d.m(), a.this.f30182d.e());
                            } else {
                                bVar = null;
                            }
                            try {
                                try {
                                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "update finished", com.bytedance.sdk.openadsdk.preload.geckox.j.a.a(aVar, a.this.f30183e, a.this.f30182d, a.this.f30180b, map, map2, str).a((com.bytedance.sdk.openadsdk.preload.b.b<Object>) str));
                                    com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar2 = aVar;
                                    if (aVar2 != null) {
                                        aVar2.a();
                                    }
                                    if (bVar != null) {
                                        bVar.a();
                                    }
                                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                                } catch (Exception e2) {
                                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "Gecko update failed:", e2);
                                    com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar3 = aVar;
                                    if (aVar3 != null) {
                                        aVar3.a();
                                    }
                                    if (bVar != null) {
                                        bVar.a();
                                    }
                                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                                }
                                a.this.b();
                            } catch (Throwable th) {
                                com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar4 = aVar;
                                if (aVar4 != null) {
                                    aVar4.a();
                                }
                                if (bVar != null) {
                                    bVar.a();
                                }
                                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                                throw th;
                            }
                        }
                    });
                    return;
                }
                throw new IllegalArgumentException("target keys not in deployments keys");
            }
            throw new IllegalArgumentException("deployments keys not in local keys");
        }
        throw new IllegalArgumentException("groupType == null");
    }

    private boolean a() {
        List<String> d2 = this.f30182d.d();
        List<String> e2 = this.f30182d.e();
        if (d2 == null || d2.isEmpty() || e2 == null || e2.isEmpty()) {
            return false;
        }
        for (String str : e2) {
            boolean z = false;
            for (String str2 : d2) {
                if (TextUtils.equals(str, str2)) {
                    z = true;
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public void a(Class<? extends d<?, ?>> cls, com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
        this.f30180b.a(cls, aVar);
    }

    private void a(String str, int i) {
        if (this.f30182d.o() != null && this.f30182d.o().a()) {
            this.f30182d.o().a(str, i);
        } else if (this.f30181c.size() < 10) {
            this.f30181c.add(str);
        }
    }
}
