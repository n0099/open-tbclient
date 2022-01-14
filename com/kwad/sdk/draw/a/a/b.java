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
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f56685b;

    /* renamed from: c  reason: collision with root package name */
    public DrawCardApp f56686c;

    /* renamed from: d  reason: collision with root package name */
    public DrawCardH5 f56687d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f56688e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f56689f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC2124a f56690g = new a.InterfaceC2124a() { // from class: com.kwad.sdk.draw.a.a.b.1
        @Override // com.kwad.sdk.draw.a.a.a.InterfaceC2124a
        public void a() {
            b.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (com.kwad.sdk.core.response.a.a.B(this.f56689f)) {
            f();
        } else {
            g();
        }
    }

    private void f() {
        this.f56685b.setVisibility(8);
        this.f56686c.a(this.f56688e, new DrawCardApp.a() { // from class: com.kwad.sdk.draw.a.a.b.2
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void a() {
                b.this.f56685b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void b() {
                b.this.h();
            }
        });
        this.f56686c.setVisibility(0);
        this.f56686c.b();
    }

    private void g() {
        this.f56685b.setVisibility(8);
        this.f56687d.a(this.f56688e, new DrawCardH5.a() { // from class: com.kwad.sdk.draw.a.a.b.3
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void a() {
                b.this.f56685b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void b() {
                b.this.h();
            }
        });
        this.f56687d.setVisibility(0);
        this.f56687d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.kwad.sdk.core.report.a.a(this.f56688e, 29, ((com.kwad.sdk.draw.kwai.a) this).a.f56738b.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = ((com.kwad.sdk.draw.kwai.a) this).a.a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.kwai.a) this).a.f56739c;
        this.f56688e = adTemplate;
        this.f56689f = d.j(adTemplate);
        ((com.kwad.sdk.draw.kwai.a) this).a.f56742f.a(this.f56690g);
        this.f56686c.setVisibility(8);
        this.f56687d.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f56686c.a();
        this.f56687d.a();
        ((com.kwad.sdk.draw.kwai.a) this).a.f56742f.a((a.InterfaceC2124a) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56685b = (ViewGroup) a(R.id.ksad_ad_normal_container);
        this.f56686c = (DrawCardApp) a(R.id.ksad_card_app_container);
        this.f56687d = (DrawCardH5) a(R.id.ksad_card_h5_container);
    }
}
