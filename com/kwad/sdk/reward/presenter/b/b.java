package com.kwad.sdk.reward.presenter.b;

import com.baidu.tieba.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes7.dex */
public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.fullscreen.kwai.kwai.c f40934b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.fullscreen.kwai.a.a f40935c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40936d;

    /* renamed from: e  reason: collision with root package name */
    public f f40937e = new f() { // from class: com.kwad.sdk.reward.presenter.b.b.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (com.kwad.sdk.core.response.a.d.s(((g) b.this).a.f40747g)) {
                b.this.m().findViewById(b.this.i()).setVisibility(8);
            }
        }
    };

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        m().findViewById(R.id.obfuscated_res_0x7f0910bf).setVisibility(8);
        m().findViewById(R.id.obfuscated_res_0x7f0910c0).setVisibility(8);
        super.a();
        ((g) this).a.a(this.f40937e);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        aVar.a = (int) ((bb.b(q()) / bb.c(q())) + 0.5f);
        aVar.f40018b = 44;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (this.f40936d) {
            this.f40935c.j();
            this.f40934b.j();
        }
        ((g) this).a.b(this.f40937e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40934b = new com.kwad.sdk.fullscreen.kwai.kwai.c();
        this.f40935c = new com.kwad.sdk.fullscreen.kwai.a.a();
        this.f40934b.c(m());
        this.f40935c.c(m());
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        if (this.f40936d) {
            this.f40935c.k();
            this.f40934b.k();
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public String e() {
        return "ksad-video-top-bar.js";
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public int i() {
        return R.id.obfuscated_res_0x7f0910aa;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void r() {
        this.f40936d = true;
        m().findViewById(R.id.obfuscated_res_0x7f0910bf).setVisibility(0);
        this.f40935c.a(((g) this).a);
        this.f40934b.a(((g) this).a);
    }
}
