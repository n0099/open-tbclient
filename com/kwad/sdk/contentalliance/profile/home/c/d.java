package com.kwad.sdk.contentalliance.profile.home.c;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.profile.home.b.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f33279b;

    /* renamed from: c  reason: collision with root package name */
    public long f33280c;

    /* renamed from: d  reason: collision with root package name */
    public String f33281d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33282e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33283f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33284g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.profile.home.c.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f33280c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f33282e, System.currentTimeMillis() - d.this.f33280c);
                d.this.f33280c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f33279b) {
                com.kwad.sdk.core.report.e.c(d.this.f33282e);
            } else {
                d.this.f33279b = true;
                com.kwad.sdk.core.report.e.b(d.this.f33282e);
            }
            d.this.f33280c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33252a.f33257e;
        this.f33283f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f33284g);
        com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33252a;
        this.f33282e = bVar.f33254b;
        this.f33281d = String.valueOf(bVar.f33253a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f33283f;
        if (aVar != null) {
            aVar.b(this.f33284g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33281d);
    }
}
