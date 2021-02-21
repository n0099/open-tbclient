package com.kwad.sdk.reward.b.c.a;

import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.c.a;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.reward.d;
/* loaded from: classes3.dex */
public class b extends d {

    /* renamed from: b  reason: collision with root package name */
    private FrameLayout f10625b;
    private c c;
    private a.b d = new a.b() { // from class: com.kwad.sdk.reward.b.c.a.b.2
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            b.this.f10652a.f10527b.a();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = this.f10652a.f;
        this.c = this.f10652a.l;
        if (this.c == null) {
            return;
        }
        this.c.a(this.d);
        this.c.a(this.f10625b, this.f10652a.h, adTemplate, this.f10652a.j, this.f10652a.e);
        this.c.a(this.f10652a.g);
        this.c.g();
        if (this.c instanceof com.kwad.sdk.c.a) {
            ((com.kwad.sdk.c.a) this.c).a(new a.InterfaceC1073a() { // from class: com.kwad.sdk.reward.b.c.a.b.1
                @Override // com.kwad.sdk.c.a.InterfaceC1073a
                public void a() {
                    if (b.this.f10652a.f10527b != null) {
                        b.this.f10652a.f10527b.e();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.c != null) {
            this.c.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f10625b = (FrameLayout) b(R.id.ksad_web_card_container);
    }
}
