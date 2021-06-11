package com.kwad.sdk.contentalliance.home.a;

import android.net.Uri;
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
/* loaded from: classes6.dex */
public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f33146c;

    /* renamed from: d  reason: collision with root package name */
    public int f33147d;

    /* renamed from: e  reason: collision with root package name */
    public int f33148e;

    /* renamed from: g  reason: collision with root package name */
    public String f33150g;
    public int j;
    public com.kwad.sdk.core.network.i<com.kwad.sdk.core.g.h, AdResultData> k;

    /* renamed from: f  reason: collision with root package name */
    public boolean f33149f = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33151h = true;

    /* renamed from: i  reason: collision with root package name */
    public Handler f33152i = new Handler(Looper.getMainLooper());

    public c(SceneImpl sceneImpl) {
        this.f33146c = sceneImpl;
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
            SceneImpl sceneImpl2 = adTemplate.mAdScene;
            if (sceneImpl2 != null) {
                sceneImpl2.entryScene = sceneImpl.entryScene;
                sceneImpl2.setUrlPackage(sceneImpl.getUrlPackage());
            }
        }
        com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "usePreloadContentData cache item list size=" + a2.size());
        this.f33143a.addAll(a2);
        a3.b(posId);
        a(false, this.f33147d);
        return true;
    }

    public static /* synthetic */ int b(c cVar) {
        int i2 = cVar.f33147d;
        cVar.f33147d = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c(c cVar) {
        int i2 = cVar.j;
        cVar.j = i2 + 1;
        return i2;
    }

    public void a(String str) {
        String str2;
        if (str != null) {
            str2 = Uri.parse(str).getQueryParameter("push");
            if (str2 != null) {
                try {
                    str2 = URLEncoder.encode(str2, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            str2 = "";
        }
        this.f33150g = str2;
    }

    public void a(boolean z) {
        this.f33148e = z ? 1 : 0;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(final boolean z, boolean z2, int i2) {
        boolean z3;
        if (this.f33149f) {
            return;
        }
        int i3 = 1;
        this.f33149f = true;
        com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "loadData isRefresh=" + z);
        a(z, z2, i2, this.f33147d);
        if (!this.f33151h) {
            this.f33150g = null;
        }
        if (com.kwad.sdk.contentalliance.home.c.a()) {
            this.f33152i.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        c.this.f33143a.clear();
                        c.this.f33147d = 0;
                    }
                    if (c.this.f33143a.isEmpty()) {
                        m.e();
                    }
                    c.this.f33143a.addAll(com.kwad.sdk.contentalliance.home.c.b());
                    com.kwad.sdk.contentalliance.home.c.c();
                    c cVar = c.this;
                    cVar.a(z, cVar.f33147d);
                    c.b(c.this);
                    c.this.f33149f = false;
                }
            });
            return;
        }
        final int i4 = 0;
        if (!TextUtils.isEmpty(this.f33150g) || z || z2 || !this.f33143a.isEmpty()) {
            z3 = false;
        } else {
            z3 = a(this.f33146c);
            if (z3) {
                m.e();
            }
        }
        final h.a aVar = new h.a();
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f33146c);
        fVar.f34278b = this.f33146c.getPageScene();
        fVar.f34279c = 100L;
        aVar.f34412a.add(fVar);
        if (i2 == 0) {
            i3 = 3;
        } else if (i2 == 1) {
            com.kwad.sdk.core.report.e.b(this.f33146c, 1);
            i4 = 1;
        } else if (i2 == 2) {
            com.kwad.sdk.core.report.e.b(this.f33146c, 2);
            i4 = 2;
        } else if (i2 != 3) {
            i3 = i2 != 4 ? 0 : 2;
        } else {
            com.kwad.sdk.core.report.e.b(this.f33146c, 3);
            i4 = 3;
        }
        com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
        cVar.f34264c = i3;
        cVar.f34263b = this.f33148e;
        cVar.f34265d = this.j;
        aVar.f34413b = cVar;
        aVar.f34414c = this.f33150g;
        if (z3) {
            aVar.f34415d = new com.kwad.sdk.core.g.a.j(this.f33143a);
        }
        com.kwad.sdk.core.network.i<com.kwad.sdk.core.g.h, AdResultData> iVar = new com.kwad.sdk.core.network.i<com.kwad.sdk.core.g.h, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public com.kwad.sdk.core.g.h b() {
                return new com.kwad.sdk.core.g.h(aVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                ArrayList arrayList = new ArrayList();
                for (com.kwad.sdk.core.g.a.f fVar2 : aVar.f34412a) {
                    arrayList.add(fVar2.f34277a);
                }
                AdResultData adResultData = new AdResultData(arrayList);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }
        };
        this.k = iVar;
        iVar.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.g.h, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.g.h hVar, final int i5, final String str) {
                c.this.f33152i.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.c.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "onError msg:" + str);
                        c.this.a(i5, str);
                        c.this.f33149f = false;
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.g.h hVar, @NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        adTemplate.mPhotoResponseType = i4;
                        arrayList.add(adTemplate);
                    }
                }
                c.this.f33152i.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.c.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.f33151h = false;
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        if (z) {
                            c.this.f33147d = 0;
                            c.this.f33143a.clear();
                        }
                        if (c.this.f33143a.isEmpty()) {
                            m.e();
                        }
                        c.this.f33143a.addAll(arrayList);
                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                        c cVar2 = c.this;
                        cVar2.a(z, cVar2.f33147d);
                        com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "onContentAllianceLoad mTemplateList:" + c.this.f33143a.size());
                        c.this.f33149f = false;
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
        com.kwad.sdk.core.network.i<com.kwad.sdk.core.g.h, AdResultData> iVar = this.k;
        if (iVar != null) {
            iVar.e();
        }
        this.f33149f = false;
    }
}
