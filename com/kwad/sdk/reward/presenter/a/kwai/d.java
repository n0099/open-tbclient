package com.kwad.sdk.reward.presenter.a.kwai;

import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.reward.g;
/* loaded from: classes3.dex */
public class d extends g {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f59657b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.i.b f59658c;

    /* renamed from: d  reason: collision with root package name */
    public b.c f59659d = new b.c() { // from class: com.kwad.sdk.reward.presenter.a.kwai.d.1
        @Override // com.kwad.sdk.core.webview.jshandler.b.c
        public void a(b.a aVar) {
            ((g) d.this).a.f59450b.a();
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        AdTemplate adTemplate = aVar.f59455g;
        com.kwad.sdk.i.b bVar = aVar.o;
        this.f59658c = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.f59659d);
        com.kwad.sdk.i.b bVar2 = this.f59658c;
        FrameLayout frameLayout = this.f59657b;
        com.kwad.sdk.reward.a aVar2 = ((g) this).a;
        bVar2.a(frameLayout, aVar2.f59458j, adTemplate, aVar2.l, aVar2.f59454f);
        this.f59658c.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.i.b bVar = this.f59658c;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59657b = (FrameLayout) a(R.id.ksad_web_card_container);
    }
}
