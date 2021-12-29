package com.kwad.sdk.reward.presenter.b;

import com.kwad.sdk.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes3.dex */
public class e extends a {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.platdetail.c f59684b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.a.b f59685c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59686d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59687e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59688f;

    /* renamed from: g  reason: collision with root package name */
    public f f59689g = new f() { // from class: com.kwad.sdk.reward.presenter.b.e.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (com.kwad.sdk.core.response.a.a.q(com.kwad.sdk.core.response.a.d.j(((g) e.this).a.f59455g))) {
                e.this.m().findViewById(e.this.i()).setVisibility(8);
            }
            e.this.s();
        }
    };

    public e(boolean z, boolean z2) {
        this.f59686d = z;
        this.f59687e = z2;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        m().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(8);
        m().findViewById(R.id.ksad_play_end_top_toolbar).setVisibility(8);
        super.a();
        ((g) this).a.a(this.f59689g);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        aVar.a = (int) ((bb.b(q()) / bb.c(q())) + 0.5f);
        aVar.f58575b = 44;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (this.f59688f) {
            this.f59685c.j();
            this.f59684b.j();
        }
        ((g) this).a.b(this.f59689g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59684b = new com.kwad.sdk.reward.presenter.platdetail.c(this.f59687e);
        this.f59685c = new com.kwad.sdk.reward.presenter.a.b(this.f59686d);
        this.f59684b.c(m());
        this.f59685c.c(m());
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        if (this.f59688f) {
            this.f59685c.k();
            this.f59684b.k();
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
        this.f59688f = true;
        m().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(0);
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        aVar.t = false;
        this.f59685c.a(aVar);
        this.f59684b.a(((g) this).a);
    }
}
