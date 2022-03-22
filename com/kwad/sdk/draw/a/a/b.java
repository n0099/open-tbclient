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
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f40310b;

    /* renamed from: c  reason: collision with root package name */
    public DrawCardApp f40311c;

    /* renamed from: d  reason: collision with root package name */
    public DrawCardH5 f40312d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f40313e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f40314f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC1980a f40315g = new a.InterfaceC1980a() { // from class: com.kwad.sdk.draw.a.a.b.1
        @Override // com.kwad.sdk.draw.a.a.a.InterfaceC1980a
        public void a() {
            b.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (com.kwad.sdk.core.response.a.a.B(this.f40314f)) {
            f();
        } else {
            g();
        }
    }

    private void f() {
        this.f40310b.setVisibility(8);
        this.f40311c.a(this.f40313e, new DrawCardApp.a() { // from class: com.kwad.sdk.draw.a.a.b.2
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void a() {
                b.this.f40310b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void b() {
                b.this.h();
            }
        });
        this.f40311c.setVisibility(0);
        this.f40311c.b();
    }

    private void g() {
        this.f40310b.setVisibility(8);
        this.f40312d.a(this.f40313e, new DrawCardH5.a() { // from class: com.kwad.sdk.draw.a.a.b.3
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void a() {
                b.this.f40310b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void b() {
                b.this.h();
            }
        });
        this.f40312d.setVisibility(0);
        this.f40312d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.kwad.sdk.core.report.a.a(this.f40313e, 29, ((com.kwad.sdk.draw.kwai.a) this).a.f40359b.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = ((com.kwad.sdk.draw.kwai.a) this).a.a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.draw.kwai.a) this).a.f40360c;
        this.f40313e = adTemplate;
        this.f40314f = d.j(adTemplate);
        ((com.kwad.sdk.draw.kwai.a) this).a.f40363f.a(this.f40315g);
        this.f40311c.setVisibility(8);
        this.f40312d.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f40311c.a();
        this.f40312d.a();
        ((com.kwad.sdk.draw.kwai.a) this).a.f40363f.a((a.InterfaceC1980a) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40310b = (ViewGroup) a(R.id.obfuscated_res_0x7f091023);
        this.f40311c = (DrawCardApp) a(R.id.obfuscated_res_0x7f09104a);
        this.f40312d = (DrawCardH5) a(R.id.obfuscated_res_0x7f091053);
    }
}
