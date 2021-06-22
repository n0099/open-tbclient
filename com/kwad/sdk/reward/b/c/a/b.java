package com.kwad.sdk.reward.b.c.a;

import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.c.a;
import com.kwad.sdk.c.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.reward.d;
/* loaded from: classes7.dex */
public class b extends d {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f37244b;

    /* renamed from: c  reason: collision with root package name */
    public c f37245c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f37246d = new a.b() { // from class: com.kwad.sdk.reward.b.c.a.b.2
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            ((d) b.this).f37299a.f37049b.a();
        }
    };

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f37299a;
        AdTemplate adTemplate = aVar.f37053f;
        c cVar = aVar.l;
        this.f37245c = cVar;
        if (cVar == null) {
            return;
        }
        cVar.a(this.f37246d);
        c cVar2 = this.f37245c;
        FrameLayout frameLayout = this.f37244b;
        com.kwad.sdk.reward.a aVar2 = ((d) this).f37299a;
        cVar2.a(frameLayout, aVar2.f37055h, adTemplate, aVar2.j, aVar2.f37052e);
        this.f37245c.a(((d) this).f37299a.f37054g);
        this.f37245c.g();
        c cVar3 = this.f37245c;
        if (cVar3 instanceof com.kwad.sdk.c.a) {
            ((com.kwad.sdk.c.a) cVar3).a(new a.InterfaceC0361a() { // from class: com.kwad.sdk.reward.b.c.a.b.1
                @Override // com.kwad.sdk.c.a.InterfaceC0361a
                public void a() {
                    if (((d) b.this).f37299a.f37049b != null) {
                        ((d) b.this).f37299a.f37049b.e();
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        c cVar = this.f37245c;
        if (cVar != null) {
            cVar.i();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37244b = (FrameLayout) b(R.id.ksad_web_card_container);
    }
}
