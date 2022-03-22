package com.kwad.sdk.reward.presenter.a.kwai;

import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.reward.g;
/* loaded from: classes7.dex */
public class d extends g {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f40922b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.i.b f40923c;

    /* renamed from: d  reason: collision with root package name */
    public b.c f40924d = new b.c() { // from class: com.kwad.sdk.reward.presenter.a.kwai.d.1
        @Override // com.kwad.sdk.core.webview.jshandler.b.c
        public void a(b.a aVar) {
            ((g) d.this).a.f40742b.a();
        }
    };

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        AdTemplate adTemplate = aVar.f40747g;
        com.kwad.sdk.i.b bVar = aVar.o;
        this.f40923c = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.f40924d);
        com.kwad.sdk.i.b bVar2 = this.f40923c;
        FrameLayout frameLayout = this.f40922b;
        com.kwad.sdk.reward.a aVar2 = ((g) this).a;
        bVar2.a(frameLayout, aVar2.j, adTemplate, aVar2.l, aVar2.f40746f);
        this.f40923c.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.i.b bVar = this.f40923c;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40922b = (FrameLayout) a(R.id.obfuscated_res_0x7f091189);
    }
}
