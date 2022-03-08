package com.kwad.sdk.reward.presenter;

import com.baidu.tieba.R;
import com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
/* loaded from: classes8.dex */
public class g extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.widget.e f56046b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f56047c = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.presenter.g.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (g.this.f56046b != null && g.this.f56046b.e()) {
                g.this.f56046b.c();
            } else if (g.this.f56046b != null) {
                g.this.f56046b.d();
                g.this.h();
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.reward.a.g f56048d = new com.kwad.sdk.reward.a.g() { // from class: com.kwad.sdk.reward.presenter.g.2
        @Override // com.kwad.sdk.reward.a.g
        public void a() {
            if (g.this.f56046b != null && g.this.f56046b.e()) {
                g.this.f56046b.c();
                if (((com.kwad.sdk.reward.g) g.this).a != null) {
                    ((com.kwad.sdk.reward.g) g.this).a.b();
                    ((com.kwad.sdk.reward.g) g.this).a.u = true;
                    ((com.kwad.sdk.reward.g) g.this).a.k.a(true);
                }
            } else if (g.this.f56046b != null) {
                g.this.f56046b.d();
                if (com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) g.this).a.f55769g))) {
                    AdWebViewLandPageActivityProxy.launch(g.this.o(), ((com.kwad.sdk.reward.g) g.this).a.f55769g, true);
                }
            }
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.g) this).a.a(this.f56047c);
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.g) this).a;
        com.kwad.sdk.widget.e eVar = aVar.m;
        this.f56046b = eVar;
        eVar.a(aVar.f55769g, aVar.f55772j, aVar.l);
        this.f56046b.b();
        com.kwad.sdk.reward.c.a().a(this.f56048d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f56046b.a();
        this.f56046b.d();
        ((com.kwad.sdk.reward.g) this).a.b(this.f56047c);
        com.kwad.sdk.reward.c.a().b(this.f56048d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        ((KsAdWebView) a(R.id.ksad_playable_webview)).setVisibility(4);
    }
}
