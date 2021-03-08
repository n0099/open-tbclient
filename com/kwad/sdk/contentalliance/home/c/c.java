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
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.contentalliance.home.a.a {
    private SceneImpl c;
    private AdTemplate d;
    private String e;
    private i<g, AdResultData> f;
    private boolean g = false;

    public c(SceneImpl sceneImpl) {
        this.c = sceneImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<AdTemplate> list) {
        long k = d.k(this.d.photoInfo);
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            AdTemplate next = it.next();
            if (k == d.k(next.photoInfo)) {
                if (this.f5755a.contains(this.d)) {
                    it.remove();
                } else {
                    list.set(list.indexOf(next), this.d);
                }
            }
            next.mIsLeftSlipStatus = 1;
        }
        this.f5755a.addAll(list);
        if (this.f5755a.contains(this.d)) {
            return;
        }
        if (this.f5755a.size() <= 3) {
            this.f5755a.add(this.d);
        } else {
            this.f5755a.add(2, this.d);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(final boolean z, boolean z2, int i) {
        if (this.g) {
            return;
        }
        this.g = true;
        if (!e()) {
            this.b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.a(f.g.k, f.g.l);
                    c.this.g = false;
                }
            });
            return;
        }
        a(z, z2, i, 0);
        final p.a aVar = new p.a();
        aVar.e = this.e;
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.c);
        fVar.b = this.c.getPageScene();
        aVar.f6176a = fVar;
        aVar.c = d.o(this.d.photoInfo);
        aVar.b = new com.kwad.sdk.core.g.a.c();
        this.f = new i<g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(c.this.c);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public g b() {
                return new p(aVar);
            }
        };
        this.f.a(new j<g, AdResultData>() { // from class: com.kwad.sdk.contentalliance.home.c.c.3
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull g gVar, final int i2, final String str) {
                if ((f.f6187a.k != i2 && (!c.this.f5755a.isEmpty() || f.c.k != i2)) || c.this.f5755a.contains(c.this.d)) {
                    c.this.b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.c.c.3.3
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.a(i2, str);
                            c.this.g = false;
                        }
                    });
                    return;
                }
                c.this.f5755a.add(c.this.d);
                c.this.b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.c.c.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.a(z, 0);
                        c.this.g = false;
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull g gVar, @NonNull final AdResultData adResultData) {
                c.this.b.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.c.c.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z) {
                            c.this.f5755a.clear();
                        }
                        if (c.this.f5755a.isEmpty()) {
                            m.e();
                        }
                        c.this.e = adResultData.pcursor;
                        c.this.a(adResultData.adTemplateList);
                        c.this.a(z, 0);
                        c.this.g = false;
                    }
                });
            }
        });
    }

    public void b(AdTemplate adTemplate) {
        this.d = adTemplate;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        super.d();
        this.g = false;
        if (this.f != null) {
            this.f.e();
        }
    }

    public boolean e() {
        return !"0".equals(this.e);
    }
}
