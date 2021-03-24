package com.kwad.sdk.draw.b.b;

import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.draw.b.b.a;
import com.kwad.sdk.draw.view.playcard.DrawCardApp;
import com.kwad.sdk.draw.view.playcard.DrawCardH5;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f34559b;

    /* renamed from: c  reason: collision with root package name */
    public DrawCardApp f34560c;

    /* renamed from: d  reason: collision with root package name */
    public DrawCardH5 f34561d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f34562e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f34563f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC0396a f34564g = new a.InterfaceC0396a() { // from class: com.kwad.sdk.draw.b.b.b.1
        @Override // com.kwad.sdk.draw.b.b.a.InterfaceC0396a
        public void a() {
            b.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (com.kwad.sdk.core.response.b.a.y(this.f34563f)) {
            f();
        } else {
            g();
        }
    }

    private void f() {
        this.f34559b.setVisibility(8);
        this.f34560c.a(this.f34562e, new DrawCardApp.a() { // from class: com.kwad.sdk.draw.b.b.b.2
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void a() {
                b.this.f34559b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void b() {
                b.this.h();
            }
        });
        this.f34560c.setVisibility(0);
        this.f34560c.b();
    }

    private void g() {
        this.f34559b.setVisibility(8);
        this.f34561d.a(this.f34562e, new DrawCardH5.a() { // from class: com.kwad.sdk.draw.b.b.b.3
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void a() {
                b.this.f34559b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void b() {
                b.this.h();
            }
        });
        this.f34561d.setVisibility(0);
        this.f34561d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.kwad.sdk.core.report.b.a(this.f34562e, 29, ((com.kwad.sdk.draw.a.a) this).f34521a.f34523b.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = ((com.kwad.sdk.draw.a.a) this).f34521a.f34522a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f34521a.f34524c;
        this.f34562e = adTemplate;
        this.f34563f = com.kwad.sdk.core.response.b.c.j(adTemplate);
        ((com.kwad.sdk.draw.a.a) this).f34521a.f34527f.a(this.f34564g);
        this.f34560c.setVisibility(8);
        this.f34561d.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f34560c.a();
        this.f34561d.a();
        ((com.kwad.sdk.draw.a.a) this).f34521a.f34527f.a((a.InterfaceC0396a) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34559b = (ViewGroup) b(R.id.ksad_ad_normal_container);
        this.f34560c = (DrawCardApp) b(R.id.ksad_card_app_container);
        this.f34561d = (DrawCardH5) b(R.id.ksad_card_h5_container);
    }
}
