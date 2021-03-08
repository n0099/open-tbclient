package com.kwad.sdk.contentalliance.home.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.related.RelatedVideoDetailParam;
import com.kwad.sdk.core.g.l;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends a {
    private SceneImpl c;
    private RelatedVideoDetailParam d;
    private int f;
    private com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> h;
    private boolean e = false;
    private boolean g = true;

    public h(SceneImpl sceneImpl, RelatedVideoDetailParam relatedVideoDetailParam) {
        this.c = sceneImpl;
        this.d = relatedVideoDetailParam;
    }

    static /* synthetic */ int b(h hVar) {
        int i = hVar.f;
        hVar.f = i + 1;
        return i;
    }

    private boolean e() {
        return this.g;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(final boolean z, boolean z2, int i) {
        if (this.e) {
            return;
        }
        this.e = true;
        a(z, z2, i, 0);
        if (com.kwad.sdk.contentalliance.home.c.a()) {
            this.b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.h.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        h.this.f5755a.clear();
                    }
                    if (h.this.f5755a.isEmpty()) {
                        m.e();
                    }
                    h.this.f5755a.addAll(com.kwad.sdk.contentalliance.home.c.b());
                    com.kwad.sdk.contentalliance.home.c.c();
                    h.this.a(z, 0);
                    h.this.e = false;
                }
            });
        } else if (!e()) {
            this.b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.h.2
                @Override // java.lang.Runnable
                public void run() {
                    h.this.a(com.kwad.sdk.core.network.f.g.k, com.kwad.sdk.core.network.f.g.l);
                    h.this.e = false;
                }
            });
        } else {
            final l.a aVar = new l.a();
            com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.c);
            fVar.b = this.c.getPageScene();
            aVar.f6164a = fVar;
            com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
            cVar.d = this.f;
            aVar.b = cVar;
            aVar.c = this.d.mSourcePhotoId;
            this.h = new com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.h.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public AdResultData b(String str) {
                    JSONObject jSONObject = new JSONObject(str);
                    AdResultData adResultData = new AdResultData(h.this.c);
                    adResultData.parseJson(jSONObject);
                    return adResultData;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public com.kwad.sdk.core.network.g b() {
                    return new l(aVar);
                }
            };
            this.h.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.network.g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.h.4
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, final int i2, final String str) {
                    h.this.b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.h.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (com.kwad.sdk.core.network.f.g.k == i2) {
                                h.this.g = false;
                            }
                            h.this.a(i2, str);
                            h.this.e = false;
                        }
                    });
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull final AdResultData adResultData) {
                    h.this.b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z) {
                                h.this.f5755a.clear();
                            }
                            if (h.this.f5755a.isEmpty()) {
                                m.e();
                            }
                            ArrayList arrayList = new ArrayList();
                            for (AdTemplate adTemplate : adResultData.adTemplateList) {
                                if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
                                    arrayList.add(adTemplate);
                                }
                            }
                            h.this.f5755a.addAll(arrayList);
                            h.this.a(z, 0);
                            h.this.e = false;
                            h.b(h.this);
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
}
