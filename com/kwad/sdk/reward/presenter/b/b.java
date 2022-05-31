package com.kwad.sdk.reward.presenter.b;

import com.baidu.tieba.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes5.dex */
public class b extends a {
    public com.kwad.sdk.fullscreen.kwai.kwai.c b;
    public com.kwad.sdk.fullscreen.kwai.a.a c;
    public boolean d;
    public f e = new f() { // from class: com.kwad.sdk.reward.presenter.b.b.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (com.kwad.sdk.core.response.a.d.s(((g) b.this).a.g)) {
                b.this.m().findViewById(b.this.i()).setVisibility(8);
            }
        }
    };

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        m().findViewById(R.id.obfuscated_res_0x7f09108a).setVisibility(8);
        m().findViewById(R.id.obfuscated_res_0x7f09108b).setVisibility(8);
        super.a();
        ((g) this).a.a(this.e);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        aVar.a = (int) ((bb.b(q()) / bb.c(q())) + 0.5f);
        aVar.b = 44;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (this.d) {
            this.c.j();
            this.b.j();
        }
        ((g) this).a.b(this.e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = new com.kwad.sdk.fullscreen.kwai.kwai.c();
        this.c = new com.kwad.sdk.fullscreen.kwai.a.a();
        this.b.c(m());
        this.c.c(m());
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        if (this.d) {
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
        return R.id.obfuscated_res_0x7f091075;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void r() {
        this.d = true;
        m().findViewById(R.id.obfuscated_res_0x7f09108a).setVisibility(0);
        this.c.a(((g) this).a);
        this.b.a(((g) this).a);
    }
}
