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
    public SceneImpl f32949c;

    /* renamed from: d  reason: collision with root package name */
    public int f32950d;

    /* renamed from: e  reason: collision with root package name */
    public int f32951e;

    /* renamed from: g  reason: collision with root package name */
    public String f32953g;
    public int j;
    public com.kwad.sdk.core.network.i<com.kwad.sdk.core.g.h, AdResultData> k;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32952f = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32954h = true;
    public Handler i = new Handler(Looper.getMainLooper());

    public c(SceneImpl sceneImpl) {
        this.f32949c = sceneImpl;
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
        this.f32946a.addAll(a2);
        a3.b(posId);
        a(false, this.f32950d);
        return true;
    }

    public static /* synthetic */ int b(c cVar) {
        int i = cVar.f32950d;
        cVar.f32950d = i + 1;
        return i;
    }

    public static /* synthetic */ int c(c cVar) {
        int i = cVar.j;
        cVar.j = i + 1;
        return i;
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
        this.f32953g = str2;
    }

    public void a(boolean z) {
        this.f32951e = z ? 1 : 0;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(final boolean z, boolean z2, int i) {
        boolean z3;
        if (this.f32952f) {
            return;
        }
        int i2 = 1;
        this.f32952f = true;
        com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "loadData isRefresh=" + z);
        a(z, z2, i, this.f32950d);
        if (!this.f32954h) {
            this.f32953g = null;
        }
        if (com.kwad.sdk.contentalliance.home.c.a()) {
            this.i.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        c.this.f32946a.clear();
                        c.this.f32950d = 0;
                    }
                    if (c.this.f32946a.isEmpty()) {
                        m.e();
                    }
                    c.this.f32946a.addAll(com.kwad.sdk.contentalliance.home.c.b());
                    com.kwad.sdk.contentalliance.home.c.c();
                    c cVar = c.this;
                    cVar.a(z, cVar.f32950d);
                    c.b(c.this);
                    c.this.f32952f = false;
                }
            });
            return;
        }
        final int i3 = 0;
        if (!TextUtils.isEmpty(this.f32953g) || z || z2 || !this.f32946a.isEmpty()) {
            z3 = false;
        } else {
            z3 = a(this.f32949c);
            if (z3) {
                m.e();
            }
        }
        final h.a aVar = new h.a();
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f32949c);
        fVar.f34036b = this.f32949c.getPageScene();
        fVar.f34037c = 100L;
        aVar.f34169a.add(fVar);
        if (i == 0) {
            i2 = 3;
        } else if (i == 1) {
            com.kwad.sdk.core.report.e.b(this.f32949c, 1);
            i3 = 1;
        } else if (i == 2) {
            com.kwad.sdk.core.report.e.b(this.f32949c, 2);
            i3 = 2;
        } else if (i != 3) {
            i2 = i != 4 ? 0 : 2;
        } else {
            com.kwad.sdk.core.report.e.b(this.f32949c, 3);
            i3 = 3;
        }
        com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
        cVar.f34023c = i2;
        cVar.f34022b = this.f32951e;
        cVar.f34024d = this.j;
        aVar.f34170b = cVar;
        aVar.f34171c = this.f32953g;
        if (z3) {
            aVar.f34172d = new com.kwad.sdk.core.g.a.j(this.f32946a);
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
                for (com.kwad.sdk.core.g.a.f fVar2 : aVar.f34169a) {
                    arrayList.add(fVar2.f34035a);
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
            public void a(@NonNull com.kwad.sdk.core.g.h hVar, final int i4, final String str) {
                c.this.i.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.c.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "onError msg:" + str);
                        c.this.a(i4, str);
                        c.this.f32952f = false;
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
                        c.this.f32954h = false;
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        if (z) {
                            c.this.f32950d = 0;
                            c.this.f32946a.clear();
                        }
                        if (c.this.f32946a.isEmpty()) {
                            m.e();
                        }
                        c.this.f32946a.addAll(arrayList);
                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                        c cVar2 = c.this;
                        cVar2.a(z, cVar2.f32950d);
                        com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "onContentAllianceLoad mTemplateList:" + c.this.f32946a.size());
                        c.this.f32952f = false;
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
        this.f32952f = false;
    }
}
