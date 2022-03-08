package com.kwad.sdk.reward.presenter.b;

import com.baidu.tieba.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes8.dex */
public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.fullscreen.kwai.kwai.c f55978b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.fullscreen.kwai.a.a f55979c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55980d;

    /* renamed from: e  reason: collision with root package name */
    public f f55981e = new f() { // from class: com.kwad.sdk.reward.presenter.b.b.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (com.kwad.sdk.core.response.a.d.s(((g) b.this).a.f55769g)) {
                b.this.m().findViewById(b.this.i()).setVisibility(8);
            }
        }
    };

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        m().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(8);
        m().findViewById(R.id.ksad_play_end_top_toolbar).setVisibility(8);
        super.a();
        ((g) this).a.a(this.f55981e);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        aVar.a = (int) ((bb.b(q()) / bb.c(q())) + 0.5f);
        aVar.f54928b = 44;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (this.f55980d) {
            this.f55979c.j();
            this.f55978b.j();
        }
        ((g) this).a.b(this.f55981e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55978b = new com.kwad.sdk.fullscreen.kwai.kwai.c();
        this.f55979c = new com.kwad.sdk.fullscreen.kwai.a.a();
        this.f55978b.c(m());
        this.f55979c.c(m());
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        if (this.f55980d) {
            this.f55979c.k();
            this.f55978b.k();
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
        this.f55980d = true;
        m().findViewById(R.id.ksad_play_detail_top_toolbar).setVisibility(0);
        this.f55979c.a(((g) this).a);
        this.f55978b.a(((g) this).a);
    }
}
