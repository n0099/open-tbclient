package com.kwad.sdk.reward.presenter.b;

import com.kwad.sdk.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes3.dex */
public class e extends a {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.platdetail.c f57428b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.a.b f57429c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57430d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57431e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57432f;

    /* renamed from: g  reason: collision with root package name */
    public f f57433g = new f() { // from class: com.kwad.sdk.reward.presenter.b.e.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (com.kwad.sdk.core.response.a.a.q(com.kwad.sdk.core.response.a.d.j(((g) e.this).a.f57207g))) {
                e.this.m().findViewById(e.this.i()).setVisibility(8);
            }
            e.this.s();
        }
    };

    public e(boolean z, boolean z2) {
        this.f57430d = z;
        this.f57431e = z2;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        m().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(8);
        m().findViewById(R.id.ksad_play_end_top_toolbar).setVisibility(8);
        super.a();
        ((g) this).a.a(this.f57433g);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        aVar.a = (int) ((bb.b(q()) / bb.c(q())) + 0.5f);
        aVar.f56366b = 44;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (this.f57432f) {
            this.f57429c.j();
            this.f57428b.j();
        }
        ((g) this).a.b(this.f57433g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57428b = new com.kwad.sdk.reward.presenter.platdetail.c(this.f57431e);
        this.f57429c = new com.kwad.sdk.reward.presenter.a.b(this.f57430d);
        this.f57428b.c(m());
        this.f57429c.c(m());
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        if (this.f57432f) {
            this.f57429c.k();
            this.f57428b.k();
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
        this.f57432f = true;
        m().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(0);
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        aVar.t = false;
        this.f57429c.a(aVar);
        this.f57428b.a(((g) this).a);
    }
}
