package com.kwad.sdk.contentalliance.profile.home.c;

import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.profile.home.b.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f32894b;

    /* renamed from: c  reason: collision with root package name */
    public long f32895c;

    /* renamed from: d  reason: collision with root package name */
    public String f32896d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f32897e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32898f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f32899g = new com.kwad.sdk.core.i.c() { // from class: com.kwad.sdk.contentalliance.profile.home.c.d.1
        @Override // com.kwad.sdk.core.i.c
        public void b() {
            if (d.this.f32895c > 0) {
                com.kwad.sdk.core.report.e.a(d.this.f32897e, System.currentTimeMillis() - d.this.f32895c);
                d.this.f32895c = 0L;
            }
        }

        @Override // com.kwad.sdk.core.i.c
        public void c_() {
            if (d.this.f32894b) {
                com.kwad.sdk.core.report.e.c(d.this.f32897e);
            } else {
                d.this.f32894b = true;
                com.kwad.sdk.core.report.e.b(d.this.f32897e);
            }
            d.this.f32895c = System.currentTimeMillis();
        }
    };

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.i.a aVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f32867a.f32872e;
        this.f32898f = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f32899g);
        com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f32867a;
        this.f32897e = bVar.f32869b;
        this.f32896d = String.valueOf(bVar.f32868a.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.core.i.a aVar = this.f32898f;
        if (aVar != null) {
            aVar.b(this.f32899g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.scene.a.a().c(this.f32896d);
    }
}
