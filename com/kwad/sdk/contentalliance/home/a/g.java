package com.kwad.sdk.contentalliance.home.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.profile.tabvideo.detail.ProfileVideoDetailParam;
import com.kwad.sdk.core.g.p;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g extends a {

    /* renamed from: c  reason: collision with root package name */
    public final ProfileVideoDetailParam f33182c;

    /* renamed from: d  reason: collision with root package name */
    public SceneImpl f33183d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f33184e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f33185f;

    /* renamed from: g  reason: collision with root package name */
    public String f33186g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> f33187h;

    public g(SceneImpl sceneImpl, ProfileVideoDetailParam profileVideoDetailParam) {
        this.f33183d = sceneImpl;
        this.f33182c = profileVideoDetailParam;
    }

    public static /* synthetic */ int a(g gVar) {
        int i2 = gVar.f33185f;
        gVar.f33185f = i2 + 1;
        return i2;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(final boolean z, boolean z2, int i2) {
        if (this.f33184e) {
            return;
        }
        this.f33184e = true;
        a(z, z2, i2, 0);
        if (com.kwad.sdk.contentalliance.home.c.a()) {
            this.f33144b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        g.this.f33143a.clear();
                    }
                    g.this.f33143a.addAll(com.kwad.sdk.contentalliance.home.c.b());
                    if (!g.this.f33143a.isEmpty()) {
                        g gVar = g.this;
                        List<AdTemplate> list = gVar.f33143a;
                        gVar.f33186g = list.get(list.size() - 1).mPcursor;
                    }
                    com.kwad.sdk.contentalliance.home.c.c();
                    g.this.a(z, 0);
                    g.this.f33184e = false;
                }
            });
        } else if (!e()) {
            this.f33144b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.g.2
                @Override // java.lang.Runnable
                public void run() {
                    g gVar = g.this;
                    com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f34503g;
                    gVar.a(fVar.k, fVar.l);
                    g.this.f33184e = false;
                }
            });
        } else {
            final p.a aVar = new p.a();
            aVar.f34463e = this.f33186g;
            com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f33183d);
            fVar.f34278b = this.f33183d.getPageScene();
            aVar.f34459a = fVar;
            ProfileVideoDetailParam profileVideoDetailParam = this.f33182c;
            aVar.f34461c = profileVideoDetailParam.mAuthorId;
            aVar.f34462d = profileVideoDetailParam.mTabId;
            com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
            cVar.f34265d = this.f33185f;
            aVar.f34460b = cVar;
            com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> iVar = new com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.g.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public AdResultData b(String str) {
                    JSONObject jSONObject = new JSONObject(str);
                    AdResultData adResultData = new AdResultData(aVar.f34459a.f34277a);
                    adResultData.parseJson(jSONObject);
                    return adResultData;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: c */
                public p b() {
                    return new p(aVar);
                }
            };
            this.f33187h = iVar;
            iVar.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.network.g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.g.4
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, final int i3, final String str) {
                    g.this.f33144b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.g.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.a(i3, str);
                            g.this.f33184e = false;
                        }
                    });
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull final AdResultData adResultData) {
                    g.this.f33144b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.g.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            if (z) {
                                g.this.f33143a.clear();
                            }
                            if (g.this.f33143a.isEmpty()) {
                                m.e();
                            }
                            ArrayList arrayList = new ArrayList();
                            for (AdTemplate adTemplate : adResultData.adTemplateList) {
                                if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
                                    arrayList.add(adTemplate);
                                }
                            }
                            g.this.f33143a.addAll(arrayList);
                            g.this.f33186g = adResultData.pcursor;
                            AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                            g.this.a(z, 0);
                            g.this.f33184e = false;
                            g.a(g.this);
                        }
                    });
                }
            });
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        super.d();
        com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> iVar = this.f33187h;
        if (iVar != null) {
            iVar.e();
        }
        this.f33184e = false;
    }

    public boolean e() {
        return !"0".equals(this.f33186g);
    }
}
