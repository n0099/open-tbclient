package com.kwad.sdk.reward.presenter.a.kwai;

import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.reward.g;
/* loaded from: classes5.dex */
public class d extends g {
    public FrameLayout b;
    public com.kwad.sdk.i.b c;
    public b.c d = new b.c() { // from class: com.kwad.sdk.reward.presenter.a.kwai.d.1
        @Override // com.kwad.sdk.core.webview.jshandler.b.c
        public void a(b.a aVar) {
            ((g) d.this).a.b.a();
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        AdTemplate adTemplate = aVar.g;
        com.kwad.sdk.i.b bVar = aVar.o;
        this.c = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.d);
        com.kwad.sdk.i.b bVar2 = this.c;
        FrameLayout frameLayout = this.b;
        com.kwad.sdk.reward.a aVar2 = ((g) this).a;
        bVar2.a(frameLayout, aVar2.j, adTemplate, aVar2.l, aVar2.f);
        this.c.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.i.b bVar = this.c;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (FrameLayout) a(R.id.obfuscated_res_0x7f091154);
    }
}
