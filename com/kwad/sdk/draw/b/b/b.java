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
    public ViewGroup f34849b;

    /* renamed from: c  reason: collision with root package name */
    public DrawCardApp f34850c;

    /* renamed from: d  reason: collision with root package name */
    public DrawCardH5 f34851d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f34852e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f34853f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC0411a f34854g = new a.InterfaceC0411a() { // from class: com.kwad.sdk.draw.b.b.b.1
        @Override // com.kwad.sdk.draw.b.b.a.InterfaceC0411a
        public void a() {
            b.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (com.kwad.sdk.core.response.b.a.y(this.f34853f)) {
            f();
        } else {
            g();
        }
    }

    private void f() {
        this.f34849b.setVisibility(8);
        this.f34850c.a(this.f34852e, new DrawCardApp.a() { // from class: com.kwad.sdk.draw.b.b.b.2
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void a() {
                b.this.f34849b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void b() {
                b.this.h();
            }
        });
        this.f34850c.setVisibility(0);
        this.f34850c.b();
    }

    private void g() {
        this.f34849b.setVisibility(8);
        this.f34851d.a(this.f34852e, new DrawCardH5.a() { // from class: com.kwad.sdk.draw.b.b.b.3
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void a() {
                b.this.f34849b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void b() {
                b.this.h();
            }
        });
        this.f34851d.setVisibility(0);
        this.f34851d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.kwad.sdk.core.report.b.a(this.f34852e, 29, ((com.kwad.sdk.draw.a.a) this).f34811a.f34813b.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = ((com.kwad.sdk.draw.a.a) this).f34811a.f34812a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f34811a.f34814c;
        this.f34852e = adTemplate;
        this.f34853f = com.kwad.sdk.core.response.b.c.j(adTemplate);
        ((com.kwad.sdk.draw.a.a) this).f34811a.f34817f.a(this.f34854g);
        this.f34850c.setVisibility(8);
        this.f34851d.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f34850c.a();
        this.f34851d.a();
        ((com.kwad.sdk.draw.a.a) this).f34811a.f34817f.a((a.InterfaceC0411a) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34849b = (ViewGroup) b(R.id.ksad_ad_normal_container);
        this.f34850c = (DrawCardApp) b(R.id.ksad_card_app_container);
        this.f34851d = (DrawCardH5) b(R.id.ksad_card_h5_container);
    }
}
