package com.kwad.sdk.contentalliance.home.b;
/* loaded from: classes3.dex */
public class m extends com.kwad.sdk.contentalliance.home.e implements com.kwad.sdk.core.i.c {
    private com.kwad.sdk.core.i.a b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.home.h hVar = this.f5821a.f;
        if (hVar != null) {
            this.b = hVar.f5826a;
        }
        this.b.a(this);
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        com.kwad.sdk.core.h.d.a().b(this.f5821a.f5822a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.b.b(this);
        com.kwad.sdk.core.h.d.a().b(this.f5821a.f5822a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        com.kwad.sdk.core.h.d.a().a(this.f5821a.f5822a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        com.kwad.sdk.core.h.d.a().b(this.f5821a.f5822a);
    }
}
