package com.kwad.sdk.reward.b.c.a;

import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.c.a;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.reward.d;
/* loaded from: classes4.dex */
public class b extends d {

    /* renamed from: b  reason: collision with root package name */
    private FrameLayout f10623b;
    private c c;
    private a.b d = new a.b() { // from class: com.kwad.sdk.reward.b.c.a.b.2
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            b.this.f10650a.f10525b.a();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = this.f10650a.f;
        this.c = this.f10650a.l;
        if (this.c == null) {
            return;
        }
        this.c.a(this.d);
        this.c.a(this.f10623b, this.f10650a.h, adTemplate, this.f10650a.j, this.f10650a.e);
        this.c.a(this.f10650a.g);
        this.c.g();
        if (this.c instanceof com.kwad.sdk.c.a) {
            ((com.kwad.sdk.c.a) this.c).a(new a.InterfaceC1067a() { // from class: com.kwad.sdk.reward.b.c.a.b.1
                @Override // com.kwad.sdk.c.a.InterfaceC1067a
                public void a() {
                    if (b.this.f10650a.f10525b != null) {
                        b.this.f10650a.f10525b.e();
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
        this.f10623b = (FrameLayout) b(R.id.ksad_web_card_container);
    }
}
