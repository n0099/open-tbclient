package com.kwad.sdk.contentalliance.home.b;
/* loaded from: classes6.dex */
public class m extends com.kwad.sdk.contentalliance.home.e implements com.kwad.sdk.core.i.c {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32705b;

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.h hVar = ((com.kwad.sdk.contentalliance.home.e) this).f32769a.f32775f;
        if (hVar != null) {
            this.f32705b = hVar.f32789a;
        }
        this.f32705b.a(this);
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        com.kwad.sdk.core.h.d.a().b(((com.kwad.sdk.contentalliance.home.e) this).f32769a.f32770a);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32705b.b(this);
        com.kwad.sdk.core.h.d.a().b(((com.kwad.sdk.contentalliance.home.e) this).f32769a.f32770a);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        com.kwad.sdk.core.h.d.a().a(((com.kwad.sdk.contentalliance.home.e) this).f32769a.f32770a);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.h.d.a().b(((com.kwad.sdk.contentalliance.home.e) this).f32769a.f32770a);
    }
}
