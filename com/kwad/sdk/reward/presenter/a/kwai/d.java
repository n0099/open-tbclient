package com.kwad.sdk.reward.presenter.a.kwai;

import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.reward.g;
/* loaded from: classes4.dex */
public class d extends g {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f57614b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.i.b f57615c;

    /* renamed from: d  reason: collision with root package name */
    public b.c f57616d = new b.c() { // from class: com.kwad.sdk.reward.presenter.a.kwai.d.1
        @Override // com.kwad.sdk.core.webview.jshandler.b.c
        public void a(b.a aVar) {
            ((g) d.this).a.f57414b.a();
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        AdTemplate adTemplate = aVar.f57419g;
        com.kwad.sdk.i.b bVar = aVar.o;
        this.f57615c = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.f57616d);
        com.kwad.sdk.i.b bVar2 = this.f57615c;
        FrameLayout frameLayout = this.f57614b;
        com.kwad.sdk.reward.a aVar2 = ((g) this).a;
        bVar2.a(frameLayout, aVar2.f57422j, adTemplate, aVar2.l, aVar2.f57418f);
        this.f57615c.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.i.b bVar = this.f57615c;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57614b = (FrameLayout) a(R.id.ksad_web_card_container);
    }
}
