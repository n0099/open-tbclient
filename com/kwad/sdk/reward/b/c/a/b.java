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
    public FrameLayout f37146b;

    /* renamed from: c  reason: collision with root package name */
    public c f37147c;

    /* renamed from: d  reason: collision with root package name */
    public a.b f37148d = new a.b() { // from class: com.kwad.sdk.reward.b.c.a.b.2
        @Override // com.kwad.sdk.core.webview.jshandler.a.b
        public void a() {
            ((d) b.this).f37201a.f36951b.a();
        }
    };

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f37201a;
        AdTemplate adTemplate = aVar.f36955f;
        c cVar = aVar.l;
        this.f37147c = cVar;
        if (cVar == null) {
            return;
        }
        cVar.a(this.f37148d);
        c cVar2 = this.f37147c;
        FrameLayout frameLayout = this.f37146b;
        com.kwad.sdk.reward.a aVar2 = ((d) this).f37201a;
        cVar2.a(frameLayout, aVar2.f36957h, adTemplate, aVar2.j, aVar2.f36954e);
        this.f37147c.a(((d) this).f37201a.f36956g);
        this.f37147c.g();
        c cVar3 = this.f37147c;
        if (cVar3 instanceof com.kwad.sdk.c.a) {
            ((com.kwad.sdk.c.a) cVar3).a(new a.InterfaceC0358a() { // from class: com.kwad.sdk.reward.b.c.a.b.1
                @Override // com.kwad.sdk.c.a.InterfaceC0358a
                public void a() {
                    if (((d) b.this).f37201a.f36951b != null) {
                        ((d) b.this).f37201a.f36951b.e();
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        c cVar = this.f37147c;
        if (cVar != null) {
            cVar.i();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37146b = (FrameLayout) b(R.id.ksad_web_card_container);
    }
}
