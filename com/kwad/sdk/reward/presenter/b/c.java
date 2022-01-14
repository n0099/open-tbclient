package com.kwad.sdk.reward.presenter.b;

import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bb;
/* loaded from: classes3.dex */
public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public int f57420b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.platdetail.actionbar.a f57421c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.platdetail.actionbar.b f57422d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57423e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57424f;

    /* renamed from: g  reason: collision with root package name */
    public f f57425g = new f() { // from class: com.kwad.sdk.reward.presenter.b.c.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            c.this.v();
        }
    };

    public c(boolean z) {
        this.f57424f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        FrameLayout frameLayout = (FrameLayout) ((g) this).a.f57210j.findViewById(i());
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        this.f57420b = m().findViewById(R.id.ksad_video_play_bar_h5).getVisibility();
        m().findViewById(R.id.ksad_video_play_bar_h5).setVisibility(8);
        super.a();
        ((g) this).a.a(this.f57425g);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        float c2 = bb.c(q());
        aVar.a = (int) ((av.n(q()) / c2) + 0.5f);
        aVar.f56366b = (int) ((av.o(q()) / c2) + 0.5f);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(j.a aVar) {
        FrameLayout frameLayout = (FrameLayout) ((g) this).a.f57210j.findViewById(i());
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.height = bb.a(q(), aVar.a);
            layoutParams.leftMargin = bb.a(q(), aVar.f56401b);
            layoutParams.rightMargin = bb.a(q(), aVar.f56402c);
            layoutParams.bottomMargin = bb.a(q(), aVar.f56403d);
            layoutParams.width = -1;
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f57425g);
        if (this.f57423e) {
            this.f57421c.j();
            com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = this.f57422d;
            if (bVar != null) {
                bVar.j();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57421c = new com.kwad.sdk.reward.presenter.platdetail.actionbar.a();
        if (this.f57424f) {
            com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = new com.kwad.sdk.reward.presenter.platdetail.actionbar.b();
            this.f57422d = bVar;
            bVar.c(m());
        }
        this.f57421c.c(m());
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        if (this.f57423e) {
            com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = this.f57422d;
            if (bVar != null) {
                bVar.k();
            }
            this.f57421c.k();
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public String e() {
        return "ksad-video-bottom-card.js";
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public int i() {
        return R.id.ksad_js_bottom;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void r() {
        this.f57423e = true;
        m().findViewById(R.id.ksad_video_play_bar_h5).setVisibility(this.f57420b);
        this.f57421c.a(((g) this).a);
        com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = this.f57422d;
        if (bVar != null) {
            bVar.a(((g) this).a);
        }
    }
}
