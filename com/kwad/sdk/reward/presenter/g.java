package com.kwad.sdk.reward.presenter;

import com.baidu.tieba.R;
import com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
/* loaded from: classes5.dex */
public class g extends com.kwad.sdk.reward.g {
    public com.kwad.sdk.widget.e b;
    public com.kwad.sdk.reward.a.f c = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.presenter.g.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (g.this.b != null && g.this.b.e()) {
                g.this.b.c();
            } else if (g.this.b != null) {
                g.this.b.d();
                g.this.h();
            }
        }
    };
    public final com.kwad.sdk.reward.a.g d = new com.kwad.sdk.reward.a.g() { // from class: com.kwad.sdk.reward.presenter.g.2
        @Override // com.kwad.sdk.reward.a.g
        public void a() {
            if (g.this.b != null && g.this.b.e()) {
                g.this.b.c();
                if (((com.kwad.sdk.reward.g) g.this).a != null) {
                    ((com.kwad.sdk.reward.g) g.this).a.b();
                    ((com.kwad.sdk.reward.g) g.this).a.u = true;
                    ((com.kwad.sdk.reward.g) g.this).a.k.a(true);
                }
            } else if (g.this.b != null) {
                g.this.b.d();
                if (com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) g.this).a.g))) {
                    AdWebViewLandPageActivityProxy.launch(g.this.o(), ((com.kwad.sdk.reward.g) g.this).a.g, true);
                }
            }
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.g) this).a.a(this.c);
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.g) this).a;
        com.kwad.sdk.widget.e eVar = aVar.m;
        this.b = eVar;
        eVar.a(aVar.g, aVar.j, aVar.l);
        this.b.b();
        com.kwad.sdk.reward.c.a().a(this.d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b.a();
        this.b.d();
        ((com.kwad.sdk.reward.g) this).a.b(this.c);
        com.kwad.sdk.reward.c.a().b(this.d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        ((KsAdWebView) a(R.id.obfuscated_res_0x7f09107f)).setVisibility(4);
    }
}
