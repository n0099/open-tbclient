package com.kwad.sdk.contentalliance.home.b;
/* loaded from: classes4.dex */
public class m extends com.kwad.sdk.contentalliance.home.e implements com.kwad.sdk.core.i.c {

    /* renamed from: b  reason: collision with root package name */
    private com.kwad.sdk.core.i.a f8701b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.h hVar = this.f8734a.f;
        if (hVar != null) {
            this.f8701b = hVar.f8742a;
        }
        this.f8701b.a(this);
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        com.kwad.sdk.core.h.d.a().b(this.f8734a.f8735a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8701b.b(this);
        com.kwad.sdk.core.h.d.a().b(this.f8734a.f8735a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        com.kwad.sdk.core.h.d.a().a(this.f8734a.f8735a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.h.d.a().b(this.f8734a.f8735a);
    }
}
