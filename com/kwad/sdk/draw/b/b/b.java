package com.kwad.sdk.draw.b.b;

import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.draw.b.b.a;
import com.kwad.sdk.draw.view.playcard.DrawCardApp;
import com.kwad.sdk.draw.view.playcard.DrawCardH5;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.draw.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f35310b;

    /* renamed from: c  reason: collision with root package name */
    public DrawCardApp f35311c;

    /* renamed from: d  reason: collision with root package name */
    public DrawCardH5 f35312d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f35313e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f35314f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC0400a f35315g = new a.InterfaceC0400a() { // from class: com.kwad.sdk.draw.b.b.b.1
        @Override // com.kwad.sdk.draw.b.b.a.InterfaceC0400a
        public void a() {
            b.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (com.kwad.sdk.core.response.b.a.y(this.f35314f)) {
            f();
        } else {
            g();
        }
    }

    private void f() {
        this.f35310b.setVisibility(8);
        this.f35311c.a(this.f35313e, new DrawCardApp.a() { // from class: com.kwad.sdk.draw.b.b.b.2
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void a() {
                b.this.f35310b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void b() {
                b.this.h();
            }
        });
        this.f35311c.setVisibility(0);
        this.f35311c.b();
    }

    private void g() {
        this.f35310b.setVisibility(8);
        this.f35312d.a(this.f35313e, new DrawCardH5.a() { // from class: com.kwad.sdk.draw.b.b.b.3
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void a() {
                b.this.f35310b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void b() {
                b.this.h();
            }
        });
        this.f35312d.setVisibility(0);
        this.f35312d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.kwad.sdk.core.report.b.a(this.f35313e, 29, ((com.kwad.sdk.draw.a.a) this).f35271a.f35273b.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = ((com.kwad.sdk.draw.a.a) this).f35271a.f35272a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f35271a.f35274c;
        this.f35313e = adTemplate;
        this.f35314f = com.kwad.sdk.core.response.b.c.j(adTemplate);
        ((com.kwad.sdk.draw.a.a) this).f35271a.f35277f.a(this.f35315g);
        this.f35311c.setVisibility(8);
        this.f35312d.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f35311c.a();
        this.f35312d.a();
        ((com.kwad.sdk.draw.a.a) this).f35271a.f35277f.a((a.InterfaceC0400a) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35310b = (ViewGroup) b(R.id.ksad_ad_normal_container);
        this.f35311c = (DrawCardApp) b(R.id.ksad_card_app_container);
        this.f35312d = (DrawCardH5) b(R.id.ksad_card_h5_container);
    }
}
