package com.kwad.sdk.reward.presenter;

import com.kwad.sdk.R;
import com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
/* loaded from: classes3.dex */
public class g extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.widget.e f59742b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f59743c = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.presenter.g.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (g.this.f59742b != null && g.this.f59742b.e()) {
                g.this.f59742b.c();
            } else if (g.this.f59742b != null) {
                g.this.f59742b.d();
                g.this.h();
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.reward.a.g f59744d = new com.kwad.sdk.reward.a.g() { // from class: com.kwad.sdk.reward.presenter.g.2
        @Override // com.kwad.sdk.reward.a.g
        public void a() {
            if (g.this.f59742b != null && g.this.f59742b.e()) {
                g.this.f59742b.c();
                if (((com.kwad.sdk.reward.g) g.this).a != null) {
                    ((com.kwad.sdk.reward.g) g.this).a.b();
                    ((com.kwad.sdk.reward.g) g.this).a.u = true;
                    ((com.kwad.sdk.reward.g) g.this).a.f59459k.a(true);
                }
            } else if (g.this.f59742b != null) {
                g.this.f59742b.d();
                if (com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) g.this).a.f59455g))) {
                    AdWebViewLandPageActivityProxy.launch(g.this.o(), ((com.kwad.sdk.reward.g) g.this).a.f59455g, true);
                }
            }
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.g) this).a.a(this.f59743c);
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.g) this).a;
        com.kwad.sdk.widget.e eVar = aVar.m;
        this.f59742b = eVar;
        eVar.a(aVar.f59455g, aVar.f59458j, aVar.l);
        this.f59742b.b();
        com.kwad.sdk.reward.c.a().a(this.f59744d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f59742b.a();
        this.f59742b.d();
        ((com.kwad.sdk.reward.g) this).a.b(this.f59743c);
        com.kwad.sdk.reward.c.a().b(this.f59744d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        ((KsAdWebView) a(R.id.ksad_playable_webview)).setVisibility(4);
    }
}
