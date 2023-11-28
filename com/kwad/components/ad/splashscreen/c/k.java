package com.kwad.components.ad.splashscreen.c;
/* loaded from: classes10.dex */
public final class k extends e implements com.kwad.sdk.core.h.c {
    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        this.Df.Q(getContext());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Df.Cr.b(this);
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Df.Cr.a(this);
        com.kwad.components.ad.splashscreen.monitor.b.kO();
        com.kwad.components.ad.splashscreen.monitor.b.Z(this.Df.mAdTemplate);
        com.kwad.components.ad.splashscreen.monitor.b.kO();
        com.kwad.components.ad.splashscreen.monitor.b.ab(this.Df.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.cx(com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate))) {
            this.Df.Q(getContext());
        }
    }
}
