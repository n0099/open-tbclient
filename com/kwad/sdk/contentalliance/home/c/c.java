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
    public SceneImpl f32750c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f32751d;

    /* renamed from: e  reason: collision with root package name */
    public String f32752e;

    /* renamed from: f  reason: collision with root package name */
    public i<g, AdResultData> f32753f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f32754g = false;

    public c(SceneImpl sceneImpl) {
        this.f32750c = sceneImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<AdTemplate> list) {
        long k = d.k(this.f32751d.photoInfo);
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            AdTemplate next = it.next();
            if (k == d.k(next.photoInfo)) {
                if (this.f32562a.contains(this.f32751d)) {
                    it.remove();
                } else {
                    list.set(list.indexOf(next), this.f32751d);
                }
            }
            next.mIsLeftSlipStatus = 1;
        }
        this.f32562a.addAll(list);
        if (this.f32562a.contains(this.f32751d)) {
            return;
        }
        if (this.f32562a.size() <= 3) {
            this.f32562a.add(this.f32751d);
        } else {
            this.f32562a.add(2, this.f32751d);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(final boolean z, boolean z2, int i) {
        if (this.f32754g) {
            return;
        }
        this.f32754g = true;
        if (!e()) {
            this.f32563b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c cVar = c.this;
                    f fVar = f.f33875g;
                    cVar.a(fVar.k, fVar.l);
                    c.this.f32754g = false;
                }
            });
            return;
        }
        a(z, z2, i, 0);
        final p.a aVar = new p.a();
        aVar.f33836e = this.f32752e;
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f32750c);
        fVar.f33652b = this.f32750c.getPageScene();
        aVar.f33832a = fVar;
        aVar.f33834c = d.o(this.f32751d.photoInfo);
        aVar.f33833b = new com.kwad.sdk.core.g.a.c();
        i<g, AdResultData> iVar = new i<g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(c.this.f32750c);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public g b() {
                return new p(aVar);
            }
        };
        this.f32753f = iVar;
        iVar.a(new j<g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.c.c.3
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull g gVar, final int i2, final String str) {
                if ((f.f33869a.k != i2 && (!c.this.f32562a.isEmpty() || f.f33871c.k != i2)) || c.this.f32562a.contains(c.this.f32751d)) {
                    c.this.f32563b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.c.c.3.3
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.a(i2, str);
                            c.this.f32754g = false;
                        }
                    });
                    return;
                }
                c.this.f32562a.add(c.this.f32751d);
                c.this.f32563b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.c.c.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        c.this.a(z, 0);
                        c.this.f32754g = false;
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull g gVar, @NonNull final AdResultData adResultData) {
                c.this.f32563b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.c.c.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        if (z) {
                            c.this.f32562a.clear();
                        }
                        if (c.this.f32562a.isEmpty()) {
                            m.e();
                        }
                        c.this.f32752e = adResultData.pcursor;
                        c.this.a(adResultData.adTemplateList);
                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                        c.this.a(z, 0);
                        c.this.f32754g = false;
                    }
                });
            }
        });
    }

    public void b(AdTemplate adTemplate) {
        this.f32751d = adTemplate;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        super.d();
        this.f32754g = false;
        i<g, AdResultData> iVar = this.f32753f;
        if (iVar != null) {
            iVar.e();
        }
    }

    public boolean e() {
        return !"0".equals(this.f32752e);
    }
}
