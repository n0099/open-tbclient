package com.kwad.components.ad.splashscreen.c.a;
/* loaded from: classes10.dex */
public final class f extends com.kwad.components.ad.splashscreen.c.e {
    public com.kwad.components.ad.splashscreen.f EQ = new com.kwad.components.ad.splashscreen.f() { // from class: com.kwad.components.ad.splashscreen.c.a.f.1
        @Override // com.kwad.components.ad.splashscreen.f
        public final void ku() {
            f.this.a(new e(), true);
            f.this.a(new g(), true);
        }
    };

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Df.a(this.EQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Df.b(this.EQ);
    }
}
