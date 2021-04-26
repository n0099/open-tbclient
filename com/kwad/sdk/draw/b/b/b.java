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
    public ViewGroup f33914b;

    /* renamed from: c  reason: collision with root package name */
    public DrawCardApp f33915c;

    /* renamed from: d  reason: collision with root package name */
    public DrawCardH5 f33916d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f33917e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f33918f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC0390a f33919g = new a.InterfaceC0390a() { // from class: com.kwad.sdk.draw.b.b.b.1
        @Override // com.kwad.sdk.draw.b.b.a.InterfaceC0390a
        public void a() {
            b.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (com.kwad.sdk.core.response.b.a.v(this.f33918f)) {
            m();
        } else {
            n();
        }
    }

    private void m() {
        this.f33914b.setVisibility(8);
        this.f33915c.a(this.f33917e, new DrawCardApp.a() { // from class: com.kwad.sdk.draw.b.b.b.2
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void a() {
                b.this.f33914b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void b() {
                b.this.o();
            }
        });
        this.f33915c.setVisibility(0);
        this.f33915c.b();
    }

    private void n() {
        this.f33914b.setVisibility(8);
        this.f33916d.a(this.f33917e, new DrawCardH5.a() { // from class: com.kwad.sdk.draw.b.b.b.3
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void a() {
                b.this.f33914b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void b() {
                b.this.o();
            }
        });
        this.f33916d.setVisibility(0);
        this.f33916d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        com.kwad.sdk.core.report.b.a(this.f33917e, 29, ((com.kwad.sdk.draw.a.a) this).f33875a.f33877b.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = ((com.kwad.sdk.draw.a.a) this).f33875a.f33876a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f33875a.f33878c;
        this.f33917e = adTemplate;
        this.f33918f = com.kwad.sdk.core.response.b.c.g(adTemplate);
        ((com.kwad.sdk.draw.a.a) this).f33875a.f33881f.a(this.f33919g);
        this.f33915c.setVisibility(8);
        this.f33916d.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33914b = (ViewGroup) a(R.id.ksad_ad_normal_container);
        this.f33915c = (DrawCardApp) a(R.id.ksad_card_app_container);
        this.f33916d = (DrawCardH5) a(R.id.ksad_card_h5_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33915c.a();
        this.f33916d.a();
        ((com.kwad.sdk.draw.a.a) this).f33875a.f33881f.a((a.InterfaceC0390a) null);
    }
}
