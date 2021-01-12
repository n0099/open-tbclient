package com.kwad.sdk.contentalliance.home.b;
/* loaded from: classes4.dex */
public class a extends com.kwad.sdk.contentalliance.home.e {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.entry.model.a a2 = com.kwad.sdk.entry.a.a();
        if (a2 == null) {
            return;
        }
        com.kwad.sdk.contentalliance.home.c.a(a2.a(this.f8734a.e));
        com.kwad.sdk.entry.a.b();
        this.f8734a.c.setInitStartPosition(this.f8734a.j);
    }
}
