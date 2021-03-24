package com.kwad.sdk.contentalliance.home.b;
/* loaded from: classes6.dex */
public class m extends com.kwad.sdk.contentalliance.home.e implements com.kwad.sdk.core.i.c {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32704b;

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.h hVar = ((com.kwad.sdk.contentalliance.home.e) this).f32768a.f32774f;
        if (hVar != null) {
            this.f32704b = hVar.f32788a;
        }
        this.f32704b.a(this);
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        com.kwad.sdk.core.h.d.a().b(((com.kwad.sdk.contentalliance.home.e) this).f32768a.f32769a);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32704b.b(this);
        com.kwad.sdk.core.h.d.a().b(((com.kwad.sdk.contentalliance.home.e) this).f32768a.f32769a);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        com.kwad.sdk.core.h.d.a().a(((com.kwad.sdk.contentalliance.home.e) this).f32768a.f32769a);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.h.d.a().b(((com.kwad.sdk.contentalliance.home.e) this).f32768a.f32769a);
    }
}
