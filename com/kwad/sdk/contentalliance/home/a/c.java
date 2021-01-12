package com.kwad.sdk.contentalliance.home.a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.g.h;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends a {
    private SceneImpl c;
    private int d;
    private int e;
    private String g;
    private int j;
    private com.kwad.sdk.core.network.i<com.kwad.sdk.core.g.h, AdResultData> k;
    private boolean f = false;
    private boolean h = true;
    private Handler i = new Handler(Looper.getMainLooper());

    public c(SceneImpl sceneImpl) {
        this.c = sceneImpl;
    }

    private boolean a(SceneImpl sceneImpl) {
        List<AdTemplate> a2;
        long posId = sceneImpl.getPosId();
        com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "preload usePreloadContentData posId=" + posId);
        com.kwad.sdk.contentalliance.home.a a3 = com.kwad.sdk.contentalliance.home.a.a();
        if (a3.c(posId) || (a2 = a3.a(posId)) == null || a2.isEmpty()) {
            return false;
        }
        for (AdTemplate adTemplate : a2) {
            if (adTemplate.mAdScene != null) {
                adTemplate.mAdScene.entryScene = sceneImpl.entryScene;
                adTemplate.mAdScene.setUrlPackage(sceneImpl.getUrlPackage());
            }
        }
        com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "usePreloadContentData cache item list size=" + a2.size());
        this.f8622a.addAll(a2);
        a3.b(posId);
        a(false, this.d);
        return true;
    }

    static /* synthetic */ int b(c cVar) {
        int i = cVar.d;
        cVar.d = i + 1;
        return i;
    }

    static /* synthetic */ int c(c cVar) {
        int i = cVar.j;
        cVar.j = i + 1;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0005, code lost:
        r0 = android.net.Uri.parse(r3).getQueryParameter("push");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str) {
        String str2 = "";
        if (str != null && str2 != null) {
            try {
                str2 = URLEncoder.encode(str2, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        this.g = str2;
    }

    public void a(boolean z) {
        this.e = z ? 1 : 0;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(final boolean z, boolean z2, int i) {
        boolean z3;
        int i2;
        final int i3;
        if (this.f) {
            return;
        }
        this.f = true;
        com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "loadData isRefresh=" + z);
        a(z, z2, i, this.d);
        if (!this.h) {
            this.g = null;
        }
        if (com.kwad.sdk.contentalliance.home.c.a()) {
            this.i.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        c.this.f8622a.clear();
                        c.this.d = 0;
                    }
                    if (c.this.f8622a.isEmpty()) {
                        m.e();
                    }
                    c.this.f8622a.addAll(com.kwad.sdk.contentalliance.home.c.b());
                    com.kwad.sdk.contentalliance.home.c.c();
                    c.this.a(z, c.this.d);
                    c.b(c.this);
                    c.this.f = false;
                }
            });
            return;
        }
        if (!TextUtils.isEmpty(this.g) || z || z2 || !this.f8622a.isEmpty()) {
            z3 = false;
        } else {
            z3 = a(this.c);
            if (z3) {
                m.e();
            }
        }
        final h.a aVar = new h.a();
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.c);
        fVar.f9166b = this.c.getPageScene();
        fVar.c = 100L;
        aVar.f9261a.add(fVar);
        switch (i) {
            case 0:
                i2 = 3;
                i3 = 0;
                break;
            case 1:
                com.kwad.sdk.core.report.e.b(this.c, 1);
                i2 = 1;
                i3 = 1;
                break;
            case 2:
                com.kwad.sdk.core.report.e.b(this.c, 2);
                i2 = 1;
                i3 = 2;
                break;
            case 3:
                com.kwad.sdk.core.report.e.b(this.c, 3);
                i2 = 1;
                i3 = 3;
                break;
            case 4:
                i2 = 2;
                i3 = 0;
                break;
            default:
                i2 = 0;
                i3 = 0;
                break;
        }
        com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
        cVar.c = i2;
        cVar.f9160b = this.e;
        cVar.d = this.j;
        aVar.f9262b = cVar;
        aVar.c = this.g;
        if (z3) {
            aVar.d = new com.kwad.sdk.core.g.a.j(this.f8622a);
        }
        this.k = new com.kwad.sdk.core.network.i<com.kwad.sdk.core.g.h, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public com.kwad.sdk.core.g.h b() {
                return new com.kwad.sdk.core.g.h(aVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                ArrayList arrayList = new ArrayList();
                for (com.kwad.sdk.core.g.a.f fVar2 : aVar.f9261a) {
                    arrayList.add(fVar2.f9165a);
                }
                AdResultData adResultData = new AdResultData(arrayList);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }
        };
        this.k.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.g.h, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.g.h hVar, final int i4, final String str) {
                c.this.i.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.c.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "onError msg:" + str);
                        c.this.a(i4, str);
                        c.this.f = false;
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.g.h hVar, @NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        adTemplate.mPhotoResponseType = i3;
                        arrayList.add(adTemplate);
                    }
                }
                c.this.i.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.c.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.h = false;
                        if (z) {
                            c.this.d = 0;
                            c.this.f8622a.clear();
                        }
                        if (c.this.f8622a.isEmpty()) {
                            m.e();
                        }
                        c.this.f8622a.addAll(arrayList);
                        c.this.a(z, c.this.d);
                        com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "onContentAllianceLoad mTemplateList:" + c.this.f8622a.size());
                        c.this.f = false;
                        c.b(c.this);
                        c.c(c.this);
                    }
                });
            }
        });
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        super.d();
        if (this.k != null) {
            this.k.e();
        }
        this.f = false;
    }
}
