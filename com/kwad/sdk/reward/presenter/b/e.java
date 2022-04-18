package com.kwad.sdk.reward.presenter.b;

import com.baidu.tieba.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes5.dex */
public class e extends a {
    public com.kwad.sdk.reward.presenter.platdetail.c b;
    public com.kwad.sdk.reward.presenter.a.b c;
    public boolean d;
    public boolean e;
    public boolean f;
    public f g = new f() { // from class: com.kwad.sdk.reward.presenter.b.e.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (com.kwad.sdk.core.response.a.a.q(com.kwad.sdk.core.response.a.d.j(((g) e.this).a.g))) {
                e.this.m().findViewById(e.this.i()).setVisibility(8);
            }
            e.this.s();
        }
    };

    public e(boolean z, boolean z2) {
        this.d = z;
        this.e = z2;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        m().findViewById(R.id.obfuscated_res_0x7f0910b9).setVisibility(8);
        m().findViewById(R.id.obfuscated_res_0x7f0910ba).setVisibility(8);
        super.a();
        ((g) this).a.a(this.g);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        aVar.a = (int) ((bb.b(q()) / bb.c(q())) + 0.5f);
        aVar.b = 44;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (this.f) {
            this.c.j();
            this.b.j();
        }
        ((g) this).a.b(this.g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = new com.kwad.sdk.reward.presenter.platdetail.c(this.e);
        this.c = new com.kwad.sdk.reward.presenter.a.b(this.d);
        this.b.c(m());
        this.c.c(m());
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        if (this.f) {
            this.c.k();
            this.b.k();
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public String e() {
        return "ksad-video-top-bar.js";
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public int i() {
        return R.id.obfuscated_res_0x7f0910a4;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void r() {
        this.f = true;
        m().findViewById(R.id.obfuscated_res_0x7f0910b9).setVisibility(0);
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        aVar.t = false;
        this.c.a(aVar);
        this.b.a(((g) this).a);
    }
}
