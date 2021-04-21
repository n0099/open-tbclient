package com.kwad.sdk.contentalliance.home.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.g.p;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.contentalliance.home.a.a {

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f33134c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f33135d;

    /* renamed from: e  reason: collision with root package name */
    public String f33136e;

    /* renamed from: f  reason: collision with root package name */
    public i<g, AdResultData> f33137f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33138g = false;

    public c(SceneImpl sceneImpl) {
        this.f33134c = sceneImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<AdTemplate> list) {
        long k = d.k(this.f33135d.photoInfo);
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            AdTemplate next = it.next();
            if (k == d.k(next.photoInfo)) {
                if (this.f32946a.contains(this.f33135d)) {
                    it.remove();
                } else {
                    list.set(list.indexOf(next), this.f33135d);
                }
            }
            next.mIsLeftSlipStatus = 1;
        }
        this.f32946a.addAll(list);
        if (this.f32946a.contains(this.f33135d)) {
            return;
        }
        if (this.f32946a.size() <= 3) {
            this.f32946a.add(this.f33135d);
        } else {
            this.f32946a.add(2, this.f33135d);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(final boolean z, boolean z2, int i) {
        if (this.f33138g) {
            return;
        }
        this.f33138g = true;
        if (!e()) {
            this.f32947b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c cVar = c.this;
                    f fVar = f.f34259g;
                    cVar.a(fVar.k, fVar.l);
                    c.this.f33138g = false;
                }
            });
            return;
        }
        a(z, z2, i, 0);
        final p.a aVar = new p.a();
        aVar.f34220e = this.f33136e;
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f33134c);
        fVar.f34036b = this.f33134c.getPageScene();
        aVar.f34216a = fVar;
        aVar.f34218c = d.o(this.f33135d.photoInfo);
        aVar.f34217b = new com.kwad.sdk.core.g.a.c();
        i<g, AdResultData> iVar = new i<g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(c.this.f33134c);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public g b() {
                return new p(aVar);
            }
        };
        this.f33137f = iVar;
        iVar.a(new j<g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.c.c.3
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull g gVar, final int i2, final String str) {
                if ((f.f34253a.k != i2 && (!c.this.f32946a.isEmpty() || f.f34255c.k != i2)) || c.this.f32946a.contains(c.this.f33135d)) {
                    c.this.f32947b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.c.c.3.3
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.a(i2, str);
                            c.this.f33138g = false;
                        }
                    });
                    return;
                }
                c.this.f32946a.add(c.this.f33135d);
                c.this.f32947b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.c.c.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        c.this.a(z, 0);
                        c.this.f33138g = false;
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull g gVar, @NonNull final AdResultData adResultData) {
                c.this.f32947b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.c.c.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        if (z) {
                            c.this.f32946a.clear();
                        }
                        if (c.this.f32946a.isEmpty()) {
                            m.e();
                        }
                        c.this.f33136e = adResultData.pcursor;
                        c.this.a(adResultData.adTemplateList);
                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                        c.this.a(z, 0);
                        c.this.f33138g = false;
                    }
                });
            }
        });
    }

    public void b(AdTemplate adTemplate) {
        this.f33135d = adTemplate;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        super.d();
        this.f33138g = false;
        i<g, AdResultData> iVar = this.f33137f;
        if (iVar != null) {
            iVar.e();
        }
    }

    public boolean e() {
        return !"0".equals(this.f33136e);
    }
}
