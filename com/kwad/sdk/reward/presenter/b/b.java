package com.kwad.sdk.reward.presenter.b;

import com.kwad.sdk.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.fullscreen.kwai.kwai.c f59672b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.fullscreen.kwai.a.a f59673c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59674d;

    /* renamed from: e  reason: collision with root package name */
    public f f59675e = new f() { // from class: com.kwad.sdk.reward.presenter.b.b.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (com.kwad.sdk.core.response.a.d.s(((g) b.this).a.f59455g)) {
                b.this.m().findViewById(b.this.i()).setVisibility(8);
            }
        }
    };

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        m().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(8);
        m().findViewById(R.id.ksad_play_end_top_toolbar).setVisibility(8);
        super.a();
        ((g) this).a.a(this.f59675e);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        aVar.a = (int) ((bb.b(q()) / bb.c(q())) + 0.5f);
        aVar.f58575b = 44;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (this.f59674d) {
            this.f59673c.j();
            this.f59672b.j();
        }
        ((g) this).a.b(this.f59675e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59672b = new com.kwad.sdk.fullscreen.kwai.kwai.c();
        this.f59673c = new com.kwad.sdk.fullscreen.kwai.a.a();
        this.f59672b.c(m());
        this.f59673c.c(m());
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        if (this.f59674d) {
            this.f59673c.k();
            this.f59672b.k();
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
        this.f59674d = true;
        m().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(0);
        this.f59673c.a(((g) this).a);
        this.f59672b.a(((g) this).a);
    }
}
