package com.kwad.sdk.reward.presenter.b;

import com.kwad.sdk.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.bb;
/* loaded from: classes4.dex */
public class d extends a {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.platdetail.a f57638b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57639c;

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        m().findViewById(R.id.ksad_video_play_bar_h5).setVisibility(8);
        super.a();
        if (this.f57639c) {
            this.f57638b.a(((g) this).a);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        float c2 = bb.c(q());
        aVar.a = (int) ((bb.b(q()) / c2) + 0.5f);
        aVar.f56578b = (int) ((bb.a(q()) / c2) + 0.5f);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (this.f57639c) {
            this.f57638b.j();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        com.kwad.sdk.reward.presenter.platdetail.a aVar = new com.kwad.sdk.reward.presenter.platdetail.a();
        this.f57638b = aVar;
        aVar.c(m());
        m().findViewById(i()).setVisibility(0);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public String e() {
        return "ksad-video-bottom-card.js";
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public int i() {
        return R.id.ksad_js_slide_black;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void r() {
        this.f57638b.a(((g) this).a);
        this.f57639c = true;
    }
}
