package com.kwad.sdk.contentalliance.profile.home.c;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.profile.home.b.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f33493b;

    /* renamed from: c  reason: collision with root package name */
    public long f33494c;

    /* renamed from: d  reason: collision with root package name */
    public String f33495d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33496e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33497f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33498g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.profile.home.c.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f33494c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f33496e, System.currentTimeMillis() - d.this.f33494c);
                d.this.f33494c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f33493b) {
                com.kwad.sdk.core.report.e.c(d.this.f33496e);
            } else {
                d.this.f33493b = true;
                com.kwad.sdk.core.report.e.b(d.this.f33496e);
            }
            d.this.f33494c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33465a.f33470e;
        this.f33497f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f33498g);
        com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33465a;
        this.f33496e = bVar.f33467b;
        this.f33495d = String.valueOf(bVar.f33466a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f33497f;
        if (aVar != null) {
            aVar.b(this.f33498g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33495d);
    }
}
