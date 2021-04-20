package com.kwad.sdk.contentalliance.profile.home.c;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.profile.home.b.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f33184b;

    /* renamed from: c  reason: collision with root package name */
    public long f33185c;

    /* renamed from: d  reason: collision with root package name */
    public String f33186d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33187e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33188f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33189g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.profile.home.c.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f33185c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f33187e, System.currentTimeMillis() - d.this.f33185c);
                d.this.f33185c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f33184b) {
                com.kwad.sdk.core.report.e.c(d.this.f33187e);
            } else {
                d.this.f33184b = true;
                com.kwad.sdk.core.report.e.b(d.this.f33187e);
            }
            d.this.f33185c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33157a.f33162e;
        this.f33188f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f33189g);
        com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33157a;
        this.f33187e = bVar.f33159b;
        this.f33186d = String.valueOf(bVar.f33158a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f33188f;
        if (aVar != null) {
            aVar.b(this.f33189g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33186d);
    }
}
