package com.kwad.sdk.contentalliance.profile.home.c;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.profile.home.b.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f32895b;

    /* renamed from: c  reason: collision with root package name */
    public long f32896c;

    /* renamed from: d  reason: collision with root package name */
    public String f32897d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f32898e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32899f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f32900g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.profile.home.c.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f32896c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f32898e, System.currentTimeMillis() - d.this.f32896c);
                d.this.f32896c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f32895b) {
                com.kwad.sdk.core.report.e.c(d.this.f32898e);
            } else {
                d.this.f32895b = true;
                com.kwad.sdk.core.report.e.b(d.this.f32898e);
            }
            d.this.f32896c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f32868a.f32873e;
        this.f32899f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f32900g);
        com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f32868a;
        this.f32898e = bVar.f32870b;
        this.f32897d = String.valueOf(bVar.f32869a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f32899f;
        if (aVar != null) {
            aVar.b(this.f32900g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f32897d);
    }
}
