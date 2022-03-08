package com.kwad.sdk.reward.presenter.a.kwai;

import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.reward.g;
/* loaded from: classes8.dex */
public class d extends g {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f55964b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.i.b f55965c;

    /* renamed from: d  reason: collision with root package name */
    public b.c f55966d = new b.c() { // from class: com.kwad.sdk.reward.presenter.a.kwai.d.1
        @Override // com.kwad.sdk.core.webview.jshandler.b.c
        public void a(b.a aVar) {
            ((g) d.this).a.f55764b.a();
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        AdTemplate adTemplate = aVar.f55769g;
        com.kwad.sdk.i.b bVar = aVar.o;
        this.f55965c = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.f55966d);
        com.kwad.sdk.i.b bVar2 = this.f55965c;
        FrameLayout frameLayout = this.f55964b;
        com.kwad.sdk.reward.a aVar2 = ((g) this).a;
        bVar2.a(frameLayout, aVar2.f55772j, adTemplate, aVar2.l, aVar2.f55768f);
        this.f55965c.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.i.b bVar = this.f55965c;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55964b = (FrameLayout) a(R.id.ksad_web_card_container);
    }
}
