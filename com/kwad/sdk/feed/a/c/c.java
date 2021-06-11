package com.kwad.sdk.feed.a.c;

import com.kwad.sdk.core.report.e;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.feed.a.b.a {

    /* renamed from: c  reason: collision with root package name */
    public boolean f35536c;

    /* renamed from: d  reason: collision with root package name */
    public long f35537d;

    /* renamed from: e  reason: collision with root package name */
    public String f35538e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f35539f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35540g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f35541h = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.feed.a.c.c.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (c.this.f35537d > 0) {
                e.a(c.this.f35539f, System.currentTimeMillis() - c.this.f35537d);
                c.this.f35537d = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (c.this.f35536c) {
                e.c(c.this.f35539f);
            } else {
                c.this.f35536c = true;
                e.b(c.this.f35539f);
            }
            c.this.f35537d = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.feed.a.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.feed.a.b.a) this).f35516a.f35518b;
        this.f35540g = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f35541h);
        com.kwad.sdk.feed.a.b.b bVar = ((com.kwad.sdk.feed.a.b.a) this).f35516a;
        this.f35539f = bVar.f35517a;
        this.f35538e = String.valueOf(bVar.f36606e.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f35540g;
        if (aVar != null) {
            aVar.b(this.f35541h);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f35538e);
    }
}
