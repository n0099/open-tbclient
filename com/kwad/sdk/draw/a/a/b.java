package com.kwad.sdk.draw.a.a;

import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.draw.a.a.a;
import com.kwad.sdk.draw.view.playcard.DrawCardApp;
import com.kwad.sdk.draw.view.playcard.DrawCardH5;
/* loaded from: classes4.dex */
public class b extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f56897b;

    /* renamed from: c  reason: collision with root package name */
    public DrawCardApp f56898c;

    /* renamed from: d  reason: collision with root package name */
    public DrawCardH5 f56899d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f56900e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f56901f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC2140a f56902g = new a.InterfaceC2140a() { // from class: com.kwad.sdk.draw.a.a.b.1
        @Override // com.kwad.sdk.draw.a.a.a.InterfaceC2140a
        public void a() {
            b.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (com.kwad.sdk.core.response.a.a.B(this.f56901f)) {
            f();
        } else {
            g();
        }
    }

    private void f() {
        this.f56897b.setVisibility(8);
        this.f56898c.a(this.f56900e, new DrawCardApp.a() { // from class: com.kwad.sdk.draw.a.a.b.2
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void a() {
                b.this.f56897b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void b() {
                b.this.h();
            }
        });
        this.f56898c.setVisibility(0);
        this.f56898c.b();
    }

    private void g() {
        this.f56897b.setVisibility(8);
        this.f56899d.a(this.f56900e, new DrawCardH5.a() { // from class: com.kwad.sdk.draw.a.a.b.3
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void a() {
                b.this.f56897b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void b() {
                b.this.h();
            }
        });
        this.f56899d.setVisibility(0);
        this.f56899d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.kwad.sdk.core.report.a.a(this.f56900e, 29, ((com.kwad.sdk.draw.kwai.a) this).a.f56950b.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = ((com.kwad.sdk.draw.kwai.a) this).a.a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.kwai.a) this).a.f56951c;
        this.f56900e = adTemplate;
        this.f56901f = d.j(adTemplate);
        ((com.kwad.sdk.draw.kwai.a) this).a.f56954f.a(this.f56902g);
        this.f56898c.setVisibility(8);
        this.f56899d.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f56898c.a();
        this.f56899d.a();
        ((com.kwad.sdk.draw.kwai.a) this).a.f56954f.a((a.InterfaceC2140a) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56897b = (ViewGroup) a(R.id.ksad_ad_normal_container);
        this.f56898c = (DrawCardApp) a(R.id.ksad_card_app_container);
        this.f56899d = (DrawCardH5) a(R.id.ksad_card_h5_container);
    }
}
