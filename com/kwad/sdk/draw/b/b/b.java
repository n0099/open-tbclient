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
    public ViewGroup f33088b;

    /* renamed from: c  reason: collision with root package name */
    public DrawCardApp f33089c;

    /* renamed from: d  reason: collision with root package name */
    public DrawCardH5 f33090d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f33091e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f33092f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC0378a f33093g = new a.InterfaceC0378a() { // from class: com.kwad.sdk.draw.b.b.b.1
        @Override // com.kwad.sdk.draw.b.b.a.InterfaceC0378a
        public void a() {
            b.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (com.kwad.sdk.core.response.b.a.v(this.f33092f)) {
            m();
        } else {
            n();
        }
    }

    private void m() {
        this.f33088b.setVisibility(8);
        this.f33089c.a(this.f33091e, new DrawCardApp.a() { // from class: com.kwad.sdk.draw.b.b.b.2
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void a() {
                b.this.f33088b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void b() {
                b.this.o();
            }
        });
        this.f33089c.setVisibility(0);
        this.f33089c.b();
    }

    private void n() {
        this.f33088b.setVisibility(8);
        this.f33090d.a(this.f33091e, new DrawCardH5.a() { // from class: com.kwad.sdk.draw.b.b.b.3
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void a() {
                b.this.f33088b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void b() {
                b.this.o();
            }
        });
        this.f33090d.setVisibility(0);
        this.f33090d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        com.kwad.sdk.core.report.b.a(this.f33091e, 29, ((com.kwad.sdk.draw.a.a) this).f33049a.f33051b.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = ((com.kwad.sdk.draw.a.a) this).f33049a.f33050a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f33049a.f33052c;
        this.f33091e = adTemplate;
        this.f33092f = com.kwad.sdk.core.response.b.c.g(adTemplate);
        ((com.kwad.sdk.draw.a.a) this).f33049a.f33055f.a(this.f33093g);
        this.f33089c.setVisibility(8);
        this.f33090d.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33088b = (ViewGroup) a(R.id.ksad_ad_normal_container);
        this.f33089c = (DrawCardApp) a(R.id.ksad_card_app_container);
        this.f33090d = (DrawCardH5) a(R.id.ksad_card_h5_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33089c.a();
        this.f33090d.a();
        ((com.kwad.sdk.draw.a.a) this).f33049a.f33055f.a((a.InterfaceC0378a) null);
    }
}
