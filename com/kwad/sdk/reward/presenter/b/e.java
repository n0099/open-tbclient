package com.kwad.sdk.reward.presenter.b;

import com.baidu.tieba.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes7.dex */
public class e extends a {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.platdetail.c f40946b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.a.b f40947c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40948d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40949e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40950f;

    /* renamed from: g  reason: collision with root package name */
    public f f40951g = new f() { // from class: com.kwad.sdk.reward.presenter.b.e.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (com.kwad.sdk.core.response.a.a.q(com.kwad.sdk.core.response.a.d.j(((g) e.this).a.f40747g))) {
                e.this.m().findViewById(e.this.i()).setVisibility(8);
            }
            e.this.s();
        }
    };

    public e(boolean z, boolean z2) {
        this.f40948d = z;
        this.f40949e = z2;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        m().findViewById(R.id.obfuscated_res_0x7f0910bf).setVisibility(8);
        m().findViewById(R.id.obfuscated_res_0x7f0910c0).setVisibility(8);
        super.a();
        ((g) this).a.a(this.f40951g);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        aVar.a = (int) ((bb.b(q()) / bb.c(q())) + 0.5f);
        aVar.f40018b = 44;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (this.f40950f) {
            this.f40947c.j();
            this.f40946b.j();
        }
        ((g) this).a.b(this.f40951g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40946b = new com.kwad.sdk.reward.presenter.platdetail.c(this.f40949e);
        this.f40947c = new com.kwad.sdk.reward.presenter.a.b(this.f40948d);
        this.f40946b.c(m());
        this.f40947c.c(m());
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        if (this.f40950f) {
            this.f40947c.k();
            this.f40946b.k();
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
        this.f40950f = true;
        m().findViewById(R.id.obfuscated_res_0x7f0910bf).setVisibility(0);
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        aVar.t = false;
        this.f40947c.a(aVar);
        this.f40946b.a(((g) this).a);
    }
}
