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
    public ViewGroup f58904b;

    /* renamed from: c  reason: collision with root package name */
    public DrawCardApp f58905c;

    /* renamed from: d  reason: collision with root package name */
    public DrawCardH5 f58906d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f58907e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f58908f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC2107a f58909g = new a.InterfaceC2107a() { // from class: com.kwad.sdk.draw.a.a.b.1
        @Override // com.kwad.sdk.draw.a.a.a.InterfaceC2107a
        public void a() {
            b.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (com.kwad.sdk.core.response.a.a.B(this.f58908f)) {
            f();
        } else {
            g();
        }
    }

    private void f() {
        this.f58904b.setVisibility(8);
        this.f58905c.a(this.f58907e, new DrawCardApp.a() { // from class: com.kwad.sdk.draw.a.a.b.2
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void a() {
                b.this.f58904b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void b() {
                b.this.h();
            }
        });
        this.f58905c.setVisibility(0);
        this.f58905c.b();
    }

    private void g() {
        this.f58904b.setVisibility(8);
        this.f58906d.a(this.f58907e, new DrawCardH5.a() { // from class: com.kwad.sdk.draw.a.a.b.3
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void a() {
                b.this.f58904b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void b() {
                b.this.h();
            }
        });
        this.f58906d.setVisibility(0);
        this.f58906d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.kwad.sdk.core.report.a.a(this.f58907e, 29, ((com.kwad.sdk.draw.kwai.a) this).a.f58959b.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = ((com.kwad.sdk.draw.kwai.a) this).a.a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.kwai.a) this).a.f58960c;
        this.f58907e = adTemplate;
        this.f58908f = d.j(adTemplate);
        ((com.kwad.sdk.draw.kwai.a) this).a.f58963f.a(this.f58909g);
        this.f58905c.setVisibility(8);
        this.f58906d.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f58905c.a();
        this.f58906d.a();
        ((com.kwad.sdk.draw.kwai.a) this).a.f58963f.a((a.InterfaceC2107a) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f58904b = (ViewGroup) a(R.id.ksad_ad_normal_container);
        this.f58905c = (DrawCardApp) a(R.id.ksad_card_app_container);
        this.f58906d = (DrawCardH5) a(R.id.ksad_card_h5_container);
    }
}
