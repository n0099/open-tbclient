package com.kwad.components.ad.splashscreen.c.a;
/* loaded from: classes10.dex */
public final class e extends com.kwad.components.ad.splashscreen.c.e {
    public com.kwad.components.core.webview.tachikoma.e.e jR = new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.ad.splashscreen.c.a.e.1
        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void q(String str) {
            if ("tk_splash_end_card".equals(str)) {
                e.this.a(new d(), true);
                e.this.a(new a(), true);
                e.this.a(new b(), true);
                e.this.a(new c(), true);
            }
        }
    };

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.core.webview.tachikoma.d.b.sS().a(this.jR);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.tachikoma.d.b.sS().b(this.jR);
    }
}
