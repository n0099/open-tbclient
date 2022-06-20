package com.kwad.sdk.draw.a.a;

import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.draw.a.a.a;
import com.kwad.sdk.draw.view.playcard.DrawCardApp;
import com.kwad.sdk.draw.view.playcard.DrawCardH5;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.draw.kwai.a {
    public ViewGroup b;
    public DrawCardApp c;
    public DrawCardH5 d;
    public AdTemplate e;
    public AdInfo f;
    public a.InterfaceC0328a g = new a.InterfaceC0328a() { // from class: com.kwad.sdk.draw.a.a.b.1
        @Override // com.kwad.sdk.draw.a.a.a.InterfaceC0328a
        public void a() {
            b.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (com.kwad.sdk.core.response.a.a.B(this.f)) {
            f();
        } else {
            g();
        }
    }

    private void f() {
        this.b.setVisibility(8);
        this.c.a(this.e, new DrawCardApp.a() { // from class: com.kwad.sdk.draw.a.a.b.2
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void a() {
                b.this.b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void b() {
                b.this.h();
            }
        });
        this.c.setVisibility(0);
        this.c.b();
    }

    private void g() {
        this.b.setVisibility(8);
        this.d.a(this.e, new DrawCardH5.a() { // from class: com.kwad.sdk.draw.a.a.b.3
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void a() {
                b.this.b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void b() {
                b.this.h();
            }
        });
        this.d.setVisibility(0);
        this.d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.kwad.sdk.core.report.a.a(this.e, 29, ((com.kwad.sdk.draw.kwai.a) this).a.b.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = ((com.kwad.sdk.draw.kwai.a) this).a.a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.kwai.a) this).a.c;
        this.e = adTemplate;
        this.f = d.j(adTemplate);
        ((com.kwad.sdk.draw.kwai.a) this).a.f.a(this.g);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.c.a();
        this.d.a();
        ((com.kwad.sdk.draw.kwai.a) this).a.f.a((a.InterfaceC0328a) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (ViewGroup) a(R.id.obfuscated_res_0x7f090fde);
        this.c = (DrawCardApp) a(R.id.obfuscated_res_0x7f091005);
        this.d = (DrawCardH5) a(R.id.obfuscated_res_0x7f09100e);
    }
}
