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
    public final ProfileVideoDetailParam f32984c;

    /* renamed from: d  reason: collision with root package name */
    public SceneImpl f32985d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f32986e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f32987f;

    /* renamed from: g  reason: collision with root package name */
    public String f32988g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> f32989h;

    public g(SceneImpl sceneImpl, ProfileVideoDetailParam profileVideoDetailParam) {
        this.f32985d = sceneImpl;
        this.f32984c = profileVideoDetailParam;
    }

    public static /* synthetic */ int a(g gVar) {
        int i = gVar.f32987f;
        gVar.f32987f = i + 1;
        return i;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(final boolean z, boolean z2, int i) {
        if (this.f32986e) {
            return;
        }
        this.f32986e = true;
        a(z, z2, i, 0);
        if (com.kwad.sdk.contentalliance.home.c.a()) {
            this.f32947b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        g.this.f32946a.clear();
                    }
                    g.this.f32946a.addAll(com.kwad.sdk.contentalliance.home.c.b());
                    if (!g.this.f32946a.isEmpty()) {
                        g gVar = g.this;
                        List<AdTemplate> list = gVar.f32946a;
                        gVar.f32988g = list.get(list.size() - 1).mPcursor;
                    }
                    com.kwad.sdk.contentalliance.home.c.c();
                    g.this.a(z, 0);
                    g.this.f32986e = false;
                }
            });
        } else if (!e()) {
            this.f32947b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.g.2
                @Override // java.lang.Runnable
                public void run() {
                    g gVar = g.this;
                    com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f34259g;
                    gVar.a(fVar.k, fVar.l);
                    g.this.f32986e = false;
                }
            });
        } else {
            final p.a aVar = new p.a();
            aVar.f34220e = this.f32988g;
            com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f32985d);
            fVar.f34036b = this.f32985d.getPageScene();
            aVar.f34216a = fVar;
            ProfileVideoDetailParam profileVideoDetailParam = this.f32984c;
            aVar.f34218c = profileVideoDetailParam.mAuthorId;
            aVar.f34219d = profileVideoDetailParam.mTabId;
            com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
            cVar.f34024d = this.f32987f;
            aVar.f34217b = cVar;
            com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> iVar = new com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.g.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public AdResultData b(String str) {
                    JSONObject jSONObject = new JSONObject(str);
                    AdResultData adResultData = new AdResultData(aVar.f34216a.f34035a);
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
            this.f32989h = iVar;
            iVar.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.network.g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.g.4
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, final int i2, final String str) {
                    g.this.f32947b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.g.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.a(i2, str);
                            g.this.f32986e = false;
                        }
                    });
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull final AdResultData adResultData) {
                    g.this.f32947b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.g.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            if (z) {
                                g.this.f32946a.clear();
                            }
                            if (g.this.f32946a.isEmpty()) {
                                m.e();
                            }
                            ArrayList arrayList = new ArrayList();
                            for (AdTemplate adTemplate : adResultData.adTemplateList) {
                                if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
                                    arrayList.add(adTemplate);
                                }
                            }
                            g.this.f32946a.addAll(arrayList);
                            g.this.f32988g = adResultData.pcursor;
                            AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                            g.this.a(z, 0);
                            g.this.f32986e = false;
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
        com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> iVar = this.f32989h;
        if (iVar != null) {
            iVar.e();
        }
        this.f32986e = false;
    }

    public boolean e() {
        return !"0".equals(this.f32988g);
    }
}
