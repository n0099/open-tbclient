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
/* loaded from: classes6.dex */
public class h extends a {

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f32907c;

    /* renamed from: d  reason: collision with root package name */
    public RelatedVideoDetailParam f32908d;

    /* renamed from: f  reason: collision with root package name */
    public int f32910f;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> f32912h;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32909e = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f32911g = true;

    public h(SceneImpl sceneImpl, RelatedVideoDetailParam relatedVideoDetailParam) {
        this.f32907c = sceneImpl;
        this.f32908d = relatedVideoDetailParam;
    }

    public static /* synthetic */ int b(h hVar) {
        int i = hVar.f32910f;
        hVar.f32910f = i + 1;
        return i;
    }

    private boolean e() {
        return this.f32911g;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(final boolean z, boolean z2, int i) {
        if (this.f32909e) {
            return;
        }
        this.f32909e = true;
        a(z, z2, i, 0);
        if (com.kwad.sdk.contentalliance.home.c.a()) {
            this.f32852b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.h.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        h.this.f32851a.clear();
                    }
                    if (h.this.f32851a.isEmpty()) {
                        m.e();
                    }
                    h.this.f32851a.addAll(com.kwad.sdk.contentalliance.home.c.b());
                    com.kwad.sdk.contentalliance.home.c.c();
                    h.this.a(z, 0);
                    h.this.f32909e = false;
                }
            });
        } else if (!e()) {
            this.f32852b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.h.2
                @Override // java.lang.Runnable
                public void run() {
                    h hVar = h.this;
                    com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f34164g;
                    hVar.a(fVar.k, fVar.l);
                    h.this.f32909e = false;
                }
            });
        } else {
            final l.a aVar = new l.a();
            com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f32907c);
            fVar.f33941b = this.f32907c.getPageScene();
            aVar.f34099a = fVar;
            com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
            cVar.f33929d = this.f32910f;
            aVar.f34100b = cVar;
            aVar.f34101c = this.f32908d.mSourcePhotoId;
            com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> iVar = new com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.h.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public AdResultData b(String str) {
                    JSONObject jSONObject = new JSONObject(str);
                    AdResultData adResultData = new AdResultData(h.this.f32907c);
                    adResultData.parseJson(jSONObject);
                    return adResultData;
                }

                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public com.kwad.sdk.core.network.g b() {
                    return new l(aVar);
                }
            };
            this.f32912h = iVar;
            iVar.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.network.g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.a.h.4
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, final int i2, final String str) {
                    h.this.f32852b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.h.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (com.kwad.sdk.core.network.f.f34164g.k == i2) {
                                h.this.f32911g = false;
                            }
                            h.this.a(i2, str);
                            h.this.f32909e = false;
                        }
                    });
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull final AdResultData adResultData) {
                    h.this.f32852b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.a.h.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            if (z) {
                                h.this.f32851a.clear();
                            }
                            if (h.this.f32851a.isEmpty()) {
                                m.e();
                            }
                            ArrayList arrayList = new ArrayList();
                            for (AdTemplate adTemplate : adResultData.adTemplateList) {
                                if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
                                    arrayList.add(adTemplate);
                                }
                            }
                            h.this.f32851a.addAll(arrayList);
                            AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                            h.this.a(z, 0);
                            h.this.f32909e = false;
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
        com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> iVar = this.f32912h;
        if (iVar != null) {
            iVar.e();
        }
        this.f32909e = false;
    }
}
