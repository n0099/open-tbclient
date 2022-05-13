package com.kwad.sdk.reward.presenter.b;

import com.baidu.tieba.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes5.dex */
public class d extends a {
    public com.kwad.sdk.reward.presenter.platdetail.a b;
    public boolean c;

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        m().findViewById(R.id.obfuscated_res_0x7f09117f).setVisibility(8);
        super.a();
        if (this.c) {
            this.b.a(((g) this).a);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        float c = bb.c(q());
        aVar.a = (int) ((bb.b(q()) / c) + 0.5f);
        aVar.b = (int) ((bb.a(q()) / c) + 0.5f);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (this.c) {
            this.b.j();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        com.kwad.sdk.reward.presenter.platdetail.a aVar = new com.kwad.sdk.reward.presenter.platdetail.a();
        this.b = aVar;
        aVar.c(m());
        m().findViewById(i()).setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public String e() {
        return "ksad-video-bottom-card.js";
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public int i() {
        return R.id.obfuscated_res_0x7f0910b2;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void r() {
        this.b.a(((g) this).a);
        this.c = true;
    }
}
