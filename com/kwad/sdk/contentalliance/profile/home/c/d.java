package com.kwad.sdk.contentalliance.profile.home.c;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.profile.home.b.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f33591b;

    /* renamed from: c  reason: collision with root package name */
    public long f33592c;

    /* renamed from: d  reason: collision with root package name */
    public String f33593d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f33594e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33595f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f33596g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.profile.home.c.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f33592c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f33594e, System.currentTimeMillis() - d.this.f33592c);
                d.this.f33592c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f33591b) {
                com.kwad.sdk.core.report.e.c(d.this.f33594e);
            } else {
                d.this.f33591b = true;
                com.kwad.sdk.core.report.e.b(d.this.f33594e);
            }
            d.this.f33592c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33563a.f33568e;
        this.f33595f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f33596g);
        com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33563a;
        this.f33594e = bVar.f33565b;
        this.f33593d = String.valueOf(bVar.f33564a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f33595f;
        if (aVar != null) {
            aVar.b(this.f33596g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f33593d);
    }
}
