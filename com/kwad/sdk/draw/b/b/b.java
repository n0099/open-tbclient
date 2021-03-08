package com.kwad.sdk.draw.b.b;

import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.draw.b.b.a;
import com.kwad.sdk.draw.view.playcard.DrawCardApp;
import com.kwad.sdk.draw.view.playcard.DrawCardH5;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.draw.a.a {
    private ViewGroup b;
    private DrawCardApp c;
    private DrawCardH5 d;
    private AdTemplate e;
    private AdInfo f;
    private a.InterfaceC1129a g = new a.InterfaceC1129a() { // from class: com.kwad.sdk.draw.b.b.b.1
        @Override // com.kwad.sdk.draw.b.b.a.InterfaceC1129a
        public void a() {
            b.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (com.kwad.sdk.core.response.b.a.y(this.f)) {
            f();
        } else {
            g();
        }
    }

    private void f() {
        this.b.setVisibility(8);
        this.c.a(this.e, new DrawCardApp.a() { // from class: com.kwad.sdk.draw.b.b.b.2
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void a() {
                b.this.b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardApp.a
            public void b() {
                b.this.h();
            }
        });
        this.c.setVisibility(0);
        this.c.b();
    }

    private void g() {
        this.b.setVisibility(8);
        this.d.a(this.e, new DrawCardH5.a() { // from class: com.kwad.sdk.draw.b.b.b.3
            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void a() {
                b.this.b.setVisibility(0);
            }

            @Override // com.kwad.sdk.draw.view.playcard.DrawCardH5.a
            public void b() {
                b.this.h();
            }
        });
        this.d.setVisibility(0);
        this.d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.kwad.sdk.core.report.b.a(this.e, 29, this.f6403a.b.getTouchCoords());
        if (this.f6403a.f6404a != null) {
            this.f6403a.f6404a.onAdClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.e = this.f6403a.c;
        this.f = com.kwad.sdk.core.response.b.c.j(this.e);
        this.f6403a.f.a(this.g);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.c.a();
        this.d.a();
        this.f6403a.f.a((a.InterfaceC1129a) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (ViewGroup) b(R.id.ksad_ad_normal_container);
        this.c = (DrawCardApp) b(R.id.ksad_card_app_container);
        this.d = (DrawCardH5) b(R.id.ksad_card_h5_container);
    }
}
