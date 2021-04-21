package com.kwad.sdk.reward.b.c.a;

import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.c.a;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.reward.d;
/* loaded from: classes6.dex */
public class b extends d {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f36788b;

    /* renamed from: c  reason: collision with root package name */
    public c f36789c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f36790d = new a.b() { // from class: com.kwad.sdk.reward.b.c.a.b.2
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            ((d) b.this).f36842a.f36602b.a();
        }
    };

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f36842a;
        AdTemplate adTemplate = aVar.f36606f;
        c cVar = aVar.l;
        this.f36789c = cVar;
        if (cVar == null) {
            return;
        }
        cVar.a(this.f36790d);
        c cVar2 = this.f36789c;
        FrameLayout frameLayout = this.f36788b;
        com.kwad.sdk.reward.a aVar2 = ((d) this).f36842a;
        cVar2.a(frameLayout, aVar2.f36608h, adTemplate, aVar2.j, aVar2.f36605e);
        this.f36789c.a(((d) this).f36842a.f36607g);
        this.f36789c.g();
        c cVar3 = this.f36789c;
        if (cVar3 instanceof com.kwad.sdk.c.a) {
            ((com.kwad.sdk.c.a) cVar3).a(new a.InterfaceC0375a() { // from class: com.kwad.sdk.reward.b.c.a.b.1
                @Override // com.kwad.sdk.c.a.InterfaceC0375a
                public void a() {
                    if (((d) b.this).f36842a.f36602b != null) {
                        ((d) b.this).f36842a.f36602b.e();
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        c cVar = this.f36789c;
        if (cVar != null) {
            cVar.i();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36788b = (FrameLayout) b(R.id.ksad_web_card_container);
    }
}
