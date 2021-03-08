package com.kwad.sdk.contentalliance.home.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.profile.tabvideo.detail.ProfileVideoDetailParam;
import com.kwad.sdk.core.g.p;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends a {
    private final ProfileVideoDetailParam c;
    private SceneImpl d;
    private volatile boolean e = false;
    private int f;
    private String g;
    private com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> h;

    public g(SceneImpl sceneImpl, ProfileVideoDetailParam profileVideoDetailParam) {
        this.d = sceneImpl;
        this.c = profileVideoDetailParam;
    }

    static /* synthetic */ int a(g gVar) {
        int i = gVar.f;
        gVar.f = i + 1;
        return i;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(final boolean z, boolean z2, int i) {
        if (this.e) {
            return;
        }
        this.e = true;
        a(z, z2, i, 0);
        if (com.kwad.sdk.contentalliance.home.c.a()) {
            this.b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        g.this.f5755a.clear();
                    }
                    g.this.f5755a.addAll(com.kwad.sdk.contentalliance.home.c.b());
                    if (!g.this.f5755a.isEmpty()) {
                        g.this.g = g.this.f5755a.get(g.this.f5755a.size() - 1).mPcursor;
                    }
                    com.kwad.sdk.contentalliance.home.c.c();
                    g.this.a(z, 0);
                    g.this.e = false;
                }
            });
        } else if (!e()) {
            this.b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.g.2
                @Override // java.lang.Runnable
                public void run() {
                    g.this.a(com.kwad.sdk.core.network.f.g.k, com.kwad.sdk.core.network.f.g.l);
                    g.this.e = false;
                }
            });
        } else {
            final p.a aVar = new p.a();
            aVar.e = this.g;
            com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.d);
            fVar.b = this.d.getPageScene();
            aVar.f6176a = fVar;
            aVar.c = this.c.mAuthorId;
            aVar.d = this.c.mTabId;
            com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
            cVar.d = this.f;
            aVar.b = cVar;
            this.h = new com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.g.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public AdResultData b(String str) {
                    JSONObject jSONObject = new JSONObject(str);
                    AdResultData adResultData = new AdResultData(aVar.f6176a.f6100a);
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
            this.h.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.network.g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.g.4
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, final int i2, final String str) {
                    g.this.b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.g.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.a(i2, str);
                            g.this.e = false;
                        }
                    });
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull final AdResultData adResultData) {
                    g.this.b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.g.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z) {
                                g.this.f5755a.clear();
                            }
                            if (g.this.f5755a.isEmpty()) {
                                m.e();
                            }
                            ArrayList arrayList = new ArrayList();
                            for (AdTemplate adTemplate : adResultData.adTemplateList) {
                                if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
                                    arrayList.add(adTemplate);
                                }
                            }
                            g.this.f5755a.addAll(arrayList);
                            g.this.g = adResultData.pcursor;
                            g.this.a(z, 0);
                            g.this.e = false;
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
        if (this.h != null) {
            this.h.e();
        }
        this.e = false;
    }

    public boolean e() {
        return !"0".equals(this.g);
    }
}
