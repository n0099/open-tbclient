package com.kwad.sdk.reward.presenter.b;

import com.baidu.tieba.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes7.dex */
public class d extends a {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.platdetail.a f40944b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40945c;

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        m().findViewById(R.id.obfuscated_res_0x7f091176).setVisibility(8);
        super.a();
        if (this.f40945c) {
            this.f40944b.a(((g) this).a);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        float c2 = bb.c(q());
        aVar.a = (int) ((bb.b(q()) / c2) + 0.5f);
        aVar.f40018b = (int) ((bb.a(q()) / c2) + 0.5f);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (this.f40945c) {
            this.f40944b.j();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        com.kwad.sdk.reward.presenter.platdetail.a aVar = new com.kwad.sdk.reward.presenter.platdetail.a();
        this.f40944b = aVar;
        aVar.c(m());
        m().findViewById(i()).setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public String e() {
        return "ksad-video-bottom-card.js";
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public int i() {
        return R.id.obfuscated_res_0x7f0910a9;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void r() {
        this.f40944b.a(((g) this).a);
        this.f40945c = true;
    }
}
