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
    public FrameLayout f36403b;

    /* renamed from: c  reason: collision with root package name */
    public c f36404c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f36405d = new a.b() { // from class: com.kwad.sdk.reward.b.c.a.b.2
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            ((d) b.this).f36457a.f36217b.a();
        }
    };

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f36457a;
        AdTemplate adTemplate = aVar.f36221f;
        c cVar = aVar.l;
        this.f36404c = cVar;
        if (cVar == null) {
            return;
        }
        cVar.a(this.f36405d);
        c cVar2 = this.f36404c;
        FrameLayout frameLayout = this.f36403b;
        com.kwad.sdk.reward.a aVar2 = ((d) this).f36457a;
        cVar2.a(frameLayout, aVar2.f36223h, adTemplate, aVar2.j, aVar2.f36220e);
        this.f36404c.a(((d) this).f36457a.f36222g);
        this.f36404c.g();
        c cVar3 = this.f36404c;
        if (cVar3 instanceof com.kwad.sdk.c.a) {
            ((com.kwad.sdk.c.a) cVar3).a(new a.InterfaceC0357a() { // from class: com.kwad.sdk.reward.b.c.a.b.1
                @Override // com.kwad.sdk.c.a.InterfaceC0357a
                public void a() {
                    if (((d) b.this).f36457a.f36217b != null) {
                        ((d) b.this).f36457a.f36217b.e();
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        c cVar = this.f36404c;
        if (cVar != null) {
            cVar.i();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36403b = (FrameLayout) b(R.id.ksad_web_card_container);
    }
}
