package com.bytedance.sdk.openadsdk.preload.geckox;

import android.text.TextUtils;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
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
    private final List<String> f5050a = new ArrayList();
    private com.bytedance.sdk.openadsdk.preload.geckox.e.b b = new com.bytedance.sdk.openadsdk.preload.geckox.e.b();
    private Queue<String> c = new LinkedBlockingQueue();
    private b d;
    private File e;

    private a(b bVar) {
        this.d = bVar;
        this.e = bVar.m();
        this.e.mkdirs();
        c.a(this, this.d);
    }

    public static a a(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("config == null");
        }
        List<String> e = bVar.e();
        if (e == null || e.isEmpty()) {
            throw new IllegalArgumentException("access key empty");
        }
        g.a(bVar.a());
        return new a(bVar);
    }

    public void a(Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        a(DefaultSharedPrefsWrapper.SP_FILE_DEFAULT, null, map, null);
    }

    public void a(final String str, final Map<String, Map<String, Object>> map, final Map<String, List<CheckRequestBodyModel.TargetChannel>> map2, final com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("groupType == null");
        }
        if (!a()) {
            throw new IllegalArgumentException("deployments keys not in local keys");
        }
        if (!b(map2)) {
            throw new IllegalArgumentException("target keys not in deployments keys");
        }
        this.d.g().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.preload.geckox.a.a.b bVar;
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start check update...", str);
                if (a.this.d.b() != null) {
                    com.bytedance.sdk.openadsdk.preload.geckox.a.a.b a2 = a.this.d.b().a();
                    a2.a(a.this.d.b(), a.this.d.m(), a.this.d.e());
                    bVar = a2;
                } else {
                    bVar = null;
                }
                try {
                    try {
                        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "update finished", com.bytedance.sdk.openadsdk.preload.geckox.j.a.a(aVar, a.this.e, a.this.d, a.this.b, map, map2, str).a((com.bytedance.sdk.openadsdk.preload.b.b<Object>) str));
                        if (aVar != null) {
                            aVar.a();
                        }
                        if (bVar != null) {
                            bVar.a();
                        }
                        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                    } catch (Exception e) {
                        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "Gecko update failed:", e);
                        if (aVar != null) {
                            aVar.a();
                        }
                        if (bVar != null) {
                            bVar.a();
                        }
                        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                    }
                    a.this.b();
                } catch (Throwable th) {
                    if (aVar != null) {
                        aVar.a();
                    }
                    if (bVar != null) {
                        bVar.a();
                    }
                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                    throw th;
                }
            }
        });
    }

    private boolean b(Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        List<String> e = this.d.e();
        for (Map.Entry<String, List<CheckRequestBodyModel.TargetChannel>> entry : map.entrySet()) {
            boolean z = false;
            for (String str : e) {
                z = TextUtils.equals(str, entry.getKey()) ? true : z;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    private boolean a() {
        List<String> d = this.d.d();
        List<String> e = this.d.e();
        if (d == null || d.isEmpty() || e == null || e.isEmpty()) {
            return false;
        }
        for (String str : e) {
            boolean z = false;
            for (String str2 : d) {
                z = TextUtils.equals(str, str2) ? true : z;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public void a(Class<? extends d<?, ?>> cls, com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
        this.b.a(cls, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.d.e());
        a(com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(new com.bytedance.sdk.openadsdk.preload.geckox.k.a.a(arrayList)), 100);
    }

    private void a(String str, int i) {
        if (this.d.o() != null && this.d.o().a()) {
            this.d.o().a(str, i);
        } else if (this.c.size() < 10) {
            this.c.add(str);
        }
    }
}
