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
    public final ProfileVideoDetailParam f32889c;

    /* renamed from: d  reason: collision with root package name */
    public SceneImpl f32890d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f32891e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f32892f;

    /* renamed from: g  reason: collision with root package name */
    public String f32893g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> f32894h;

    public g(SceneImpl sceneImpl, ProfileVideoDetailParam profileVideoDetailParam) {
        this.f32890d = sceneImpl;
        this.f32889c = profileVideoDetailParam;
    }

    public static /* synthetic */ int a(g gVar) {
        int i = gVar.f32892f;
        gVar.f32892f = i + 1;
        return i;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(final boolean z, boolean z2, int i) {
        if (this.f32891e) {
            return;
        }
        this.f32891e = true;
        a(z, z2, i, 0);
        if (com.kwad.sdk.contentalliance.home.c.a()) {
            this.f32852b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        g.this.f32851a.clear();
                    }
                    g.this.f32851a.addAll(com.kwad.sdk.contentalliance.home.c.b());
                    if (!g.this.f32851a.isEmpty()) {
                        g gVar = g.this;
                        List<AdTemplate> list = gVar.f32851a;
                        gVar.f32893g = list.get(list.size() - 1).mPcursor;
                    }
                    com.kwad.sdk.contentalliance.home.c.c();
                    g.this.a(z, 0);
                    g.this.f32891e = false;
                }
            });
        } else if (!e()) {
            this.f32852b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.g.2
                @Override // java.lang.Runnable
                public void run() {
                    g gVar = g.this;
                    com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f34164g;
                    gVar.a(fVar.k, fVar.l);
                    g.this.f32891e = false;
                }
            });
        } else {
            final p.a aVar = new p.a();
            aVar.f34125e = this.f32893g;
            com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f32890d);
            fVar.f33941b = this.f32890d.getPageScene();
            aVar.f34121a = fVar;
            ProfileVideoDetailParam profileVideoDetailParam = this.f32889c;
            aVar.f34123c = profileVideoDetailParam.mAuthorId;
            aVar.f34124d = profileVideoDetailParam.mTabId;
            com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
            cVar.f33929d = this.f32892f;
            aVar.f34122b = cVar;
            com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> iVar = new com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.g.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public AdResultData b(String str) {
                    JSONObject jSONObject = new JSONObject(str);
                    AdResultData adResultData = new AdResultData(aVar.f34121a.f33940a);
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
            this.f32894h = iVar;
            iVar.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.network.g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.g.4
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, final int i2, final String str) {
                    g.this.f32852b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.g.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.a(i2, str);
                            g.this.f32891e = false;
                        }
                    });
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull final AdResultData adResultData) {
                    g.this.f32852b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.g.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            if (z) {
                                g.this.f32851a.clear();
                            }
                            if (g.this.f32851a.isEmpty()) {
                                m.e();
                            }
                            ArrayList arrayList = new ArrayList();
                            for (AdTemplate adTemplate : adResultData.adTemplateList) {
                                if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
                                    arrayList.add(adTemplate);
                                }
                            }
                            g.this.f32851a.addAll(arrayList);
                            g.this.f32893g = adResultData.pcursor;
                            AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                            g.this.a(z, 0);
                            g.this.f32891e = false;
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
        com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> iVar = this.f32894h;
        if (iVar != null) {
            iVar.e();
        }
        this.f32891e = false;
    }

    public boolean e() {
        return !"0".equals(this.f32893g);
    }
}
