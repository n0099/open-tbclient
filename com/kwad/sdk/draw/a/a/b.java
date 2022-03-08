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
/* loaded from: classes8.dex */
public class b extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f55247b;

    /* renamed from: c  reason: collision with root package name */
    public DrawCardApp f55248c;

    /* renamed from: d  reason: collision with root package name */
    public DrawCardH5 f55249d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f55250e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f55251f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC2119a f55252g = new a.InterfaceC2119a() { // from class: com.kwad.sdk.draw.a.a.b.1
        @Override // com.kwad.sdk.draw.a.a.a.InterfaceC2119a
        public void a() {
            b.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (com.kwad.sdk.core.response.a.a.B(this.f55251f)) {
            f();
        } else {
            g();
        }
    }

    private void f() {
        this.f55247b.setVisibility(8);
        this.f55248c.a(this.f55250e, new DrawCardApp.a() { // from class: com.kwad.sdk.draw.a.a.b.2
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void a() {
                b.this.f55247b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void b() {
                b.this.h();
            }
        });
        this.f55248c.setVisibility(0);
        this.f55248c.b();
    }

    private void g() {
        this.f55247b.setVisibility(8);
        this.f55249d.a(this.f55250e, new DrawCardH5.a() { // from class: com.kwad.sdk.draw.a.a.b.3
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void a() {
                b.this.f55247b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void b() {
                b.this.h();
            }
        });
        this.f55249d.setVisibility(0);
        this.f55249d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.kwad.sdk.core.report.a.a(this.f55250e, 29, ((com.kwad.sdk.draw.kwai.a) this).a.f55300b.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = ((com.kwad.sdk.draw.kwai.a) this).a.a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.kwai.a) this).a.f55301c;
        this.f55250e = adTemplate;
        this.f55251f = d.j(adTemplate);
        ((com.kwad.sdk.draw.kwai.a) this).a.f55304f.a(this.f55252g);
        this.f55248c.setVisibility(8);
        this.f55249d.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f55248c.a();
        this.f55249d.a();
        ((com.kwad.sdk.draw.kwai.a) this).a.f55304f.a((a.InterfaceC2119a) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55247b = (ViewGroup) a(R.id.ksad_ad_normal_container);
        this.f55248c = (DrawCardApp) a(R.id.ksad_card_app_container);
        this.f55249d = (DrawCardH5) a(R.id.ksad_card_h5_container);
    }
}
