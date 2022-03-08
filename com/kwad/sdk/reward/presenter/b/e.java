package com.kwad.sdk.reward.presenter.b;

import com.baidu.tieba.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes8.dex */
public class e extends a {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.platdetail.c f55990b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.a.b f55991c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55992d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55993e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55994f;

    /* renamed from: g  reason: collision with root package name */
    public f f55995g = new f() { // from class: com.kwad.sdk.reward.presenter.b.e.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (com.kwad.sdk.core.response.a.a.q(com.kwad.sdk.core.response.a.d.j(((g) e.this).a.f55769g))) {
                e.this.m().findViewById(e.this.i()).setVisibility(8);
            }
            e.this.s();
        }
    };

    public e(boolean z, boolean z2) {
        this.f55992d = z;
        this.f55993e = z2;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        m().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(8);
        m().findViewById(R.id.ksad_play_end_top_toolbar).setVisibility(8);
        super.a();
        ((g) this).a.a(this.f55995g);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        aVar.a = (int) ((bb.b(q()) / bb.c(q())) + 0.5f);
        aVar.f54928b = 44;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (this.f55994f) {
            this.f55991c.j();
            this.f55990b.j();
        }
        ((g) this).a.b(this.f55995g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55990b = new com.kwad.sdk.reward.presenter.platdetail.c(this.f55993e);
        this.f55991c = new com.kwad.sdk.reward.presenter.a.b(this.f55992d);
        this.f55990b.c(m());
        this.f55991c.c(m());
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        if (this.f55994f) {
            this.f55991c.k();
            this.f55990b.k();
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public String e() {
        return "ksad-video-top-bar.js";
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public int i() {
        return R.id.ksad_js_top;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void r() {
        this.f55994f = true;
        m().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(0);
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        aVar.t = false;
        this.f55991c.a(aVar);
        this.f55990b.a(((g) this).a);
    }
}
