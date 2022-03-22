package com.kwad.sdk.reward.presenter;

import com.baidu.tieba.R;
import com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
/* loaded from: classes7.dex */
public class g extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.widget.e f40997b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.a.f f40998c = new com.kwad.sdk.reward.a.f() { // from class: com.kwad.sdk.reward.presenter.g.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (g.this.f40997b != null && g.this.f40997b.e()) {
                g.this.f40997b.c();
            } else if (g.this.f40997b != null) {
                g.this.f40997b.d();
                g.this.h();
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.reward.a.g f40999d = new com.kwad.sdk.reward.a.g() { // from class: com.kwad.sdk.reward.presenter.g.2
        @Override // com.kwad.sdk.reward.a.g
        public void a() {
            if (g.this.f40997b != null && g.this.f40997b.e()) {
                g.this.f40997b.c();
                if (((com.kwad.sdk.reward.g) g.this).a != null) {
                    ((com.kwad.sdk.reward.g) g.this).a.b();
                    ((com.kwad.sdk.reward.g) g.this).a.u = true;
                    ((com.kwad.sdk.reward.g) g.this).a.k.a(true);
                }
            } else if (g.this.f40997b != null) {
                g.this.f40997b.d();
                if (com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) g.this).a.f40747g))) {
                    AdWebViewLandPageActivityProxy.launch(g.this.o(), ((com.kwad.sdk.reward.g) g.this).a.f40747g, true);
                }
            }
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.g) this).a.a(this.f40998c);
        com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.g) this).a;
        com.kwad.sdk.widget.e eVar = aVar.m;
        this.f40997b = eVar;
        eVar.a(aVar.f40747g, aVar.j, aVar.l);
        this.f40997b.b();
        com.kwad.sdk.reward.c.a().a(this.f40999d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f40997b.a();
        this.f40997b.d();
        ((com.kwad.sdk.reward.g) this).a.b(this.f40998c);
        com.kwad.sdk.reward.c.a().b(this.f40999d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        ((KsAdWebView) a(R.id.obfuscated_res_0x7f0910c4)).setVisibility(4);
    }
}
