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
    public SceneImpl f33338c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f33339d;

    /* renamed from: e  reason: collision with root package name */
    public String f33340e;

    /* renamed from: f  reason: collision with root package name */
    public i<g, AdResultData> f33341f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33342g = false;

    public c(SceneImpl sceneImpl) {
        this.f33338c = sceneImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<AdTemplate> list) {
        long k = d.k(this.f33339d.photoInfo);
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            AdTemplate next = it.next();
            if (k == d.k(next.photoInfo)) {
                if (this.f33143a.contains(this.f33339d)) {
                    it.remove();
                } else {
                    list.set(list.indexOf(next), this.f33339d);
                }
            }
            next.mIsLeftSlipStatus = 1;
        }
        this.f33143a.addAll(list);
        if (this.f33143a.contains(this.f33339d)) {
            return;
        }
        if (this.f33143a.size() <= 3) {
            this.f33143a.add(this.f33339d);
        } else {
            this.f33143a.add(2, this.f33339d);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(final boolean z, boolean z2, int i2) {
        if (this.f33342g) {
            return;
        }
        this.f33342g = true;
        if (!e()) {
            this.f33144b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c cVar = c.this;
                    f fVar = f.f34503g;
                    cVar.a(fVar.k, fVar.l);
                    c.this.f33342g = false;
                }
            });
            return;
        }
        a(z, z2, i2, 0);
        final p.a aVar = new p.a();
        aVar.f34463e = this.f33340e;
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f33338c);
        fVar.f34278b = this.f33338c.getPageScene();
        aVar.f34459a = fVar;
        aVar.f34461c = d.o(this.f33339d.photoInfo);
        aVar.f34460b = new com.kwad.sdk.core.g.a.c();
        i<g, AdResultData> iVar = new i<g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(c.this.f33338c);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public g b() {
                return new p(aVar);
            }
        };
        this.f33341f = iVar;
        iVar.a(new j<g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.c.c.3
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull g gVar, final int i3, final String str) {
                if ((f.f34497a.k != i3 && (!c.this.f33143a.isEmpty() || f.f34499c.k != i3)) || c.this.f33143a.contains(c.this.f33339d)) {
                    c.this.f33144b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.c.c.3.3
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.a(i3, str);
                            c.this.f33342g = false;
                        }
                    });
                    return;
                }
                c.this.f33143a.add(c.this.f33339d);
                c.this.f33144b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.c.c.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        c.this.a(z, 0);
                        c.this.f33342g = false;
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull g gVar, @NonNull final AdResultData adResultData) {
                c.this.f33144b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.c.c.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        if (z) {
                            c.this.f33143a.clear();
                        }
                        if (c.this.f33143a.isEmpty()) {
                            m.e();
                        }
                        c.this.f33340e = adResultData.pcursor;
                        c.this.a(adResultData.adTemplateList);
                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                        c.this.a(z, 0);
                        c.this.f33342g = false;
                    }
                });
            }
        });
    }

    public void b(AdTemplate adTemplate) {
        this.f33339d = adTemplate;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        super.d();
        this.f33342g = false;
        i<g, AdResultData> iVar = this.f33341f;
        if (iVar != null) {
            iVar.e();
        }
    }

    public boolean e() {
        return !"0".equals(this.f33340e);
    }
}
