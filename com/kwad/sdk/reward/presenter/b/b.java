package com.kwad.sdk.reward.presenter.b;

import com.kwad.sdk.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.fullscreen.kwai.kwai.c f57416b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.fullscreen.kwai.a.a f57417c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57418d;

    /* renamed from: e  reason: collision with root package name */
    public f f57419e = new f() { // from class: com.kwad.sdk.reward.presenter.b.b.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (com.kwad.sdk.core.response.a.d.s(((g) b.this).a.f57207g)) {
                b.this.m().findViewById(b.this.i()).setVisibility(8);
            }
        }
    };

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        m().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(8);
        m().findViewById(R.id.ksad_play_end_top_toolbar).setVisibility(8);
        super.a();
        ((g) this).a.a(this.f57419e);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        aVar.a = (int) ((bb.b(q()) / bb.c(q())) + 0.5f);
        aVar.f56366b = 44;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (this.f57418d) {
            this.f57417c.j();
            this.f57416b.j();
        }
        ((g) this).a.b(this.f57419e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57416b = new com.kwad.sdk.fullscreen.kwai.kwai.c();
        this.f57417c = new com.kwad.sdk.fullscreen.kwai.a.a();
        this.f57416b.c(m());
        this.f57417c.c(m());
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        if (this.f57418d) {
            this.f57417c.k();
            this.f57416b.k();
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
        this.f57418d = true;
        m().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(0);
        this.f57417c.a(((g) this).a);
        this.f57416b.a(((g) this).a);
    }
}
