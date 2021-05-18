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
    public ViewGroup f33159b;

    /* renamed from: c  reason: collision with root package name */
    public DrawCardApp f33160c;

    /* renamed from: d  reason: collision with root package name */
    public DrawCardH5 f33161d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f33162e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f33163f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC0377a f33164g = new a.InterfaceC0377a() { // from class: com.kwad.sdk.draw.b.b.b.1
        @Override // com.kwad.sdk.draw.b.b.a.InterfaceC0377a
        public void a() {
            b.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (com.kwad.sdk.core.response.b.a.v(this.f33163f)) {
            m();
        } else {
            n();
        }
    }

    private void m() {
        this.f33159b.setVisibility(8);
        this.f33160c.a(this.f33162e, new DrawCardApp.a() { // from class: com.kwad.sdk.draw.b.b.b.2
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void a() {
                b.this.f33159b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void b() {
                b.this.o();
            }
        });
        this.f33160c.setVisibility(0);
        this.f33160c.b();
    }

    private void n() {
        this.f33159b.setVisibility(8);
        this.f33161d.a(this.f33162e, new DrawCardH5.a() { // from class: com.kwad.sdk.draw.b.b.b.3
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void a() {
                b.this.f33159b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void b() {
                b.this.o();
            }
        });
        this.f33161d.setVisibility(0);
        this.f33161d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        com.kwad.sdk.core.report.b.a(this.f33162e, 29, ((com.kwad.sdk.draw.a.a) this).f33120a.f33122b.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = ((com.kwad.sdk.draw.a.a) this).f33120a.f33121a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f33120a.f33123c;
        this.f33162e = adTemplate;
        this.f33163f = com.kwad.sdk.core.response.b.c.g(adTemplate);
        ((com.kwad.sdk.draw.a.a) this).f33120a.f33126f.a(this.f33164g);
        this.f33160c.setVisibility(8);
        this.f33161d.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33159b = (ViewGroup) a(R.id.ksad_ad_normal_container);
        this.f33160c = (DrawCardApp) a(R.id.ksad_card_app_container);
        this.f33161d = (DrawCardH5) a(R.id.ksad_card_h5_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33160c.a();
        this.f33161d.a();
        ((com.kwad.sdk.draw.a.a) this).f33120a.f33126f.a((a.InterfaceC0377a) null);
    }
}
