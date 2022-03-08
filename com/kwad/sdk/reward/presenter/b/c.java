package com.kwad.sdk.reward.presenter.b;

import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bb;
/* loaded from: classes8.dex */
public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public int f55982b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.platdetail.actionbar.a f55983c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.platdetail.actionbar.b f55984d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55985e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55986f;

    /* renamed from: g  reason: collision with root package name */
    public f f55987g = new f() { // from class: com.kwad.sdk.reward.presenter.b.c.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            c.this.v();
        }
    };

    public c(boolean z) {
        this.f55986f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        FrameLayout frameLayout = (FrameLayout) ((g) this).a.f55772j.findViewById(i());
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        this.f55982b = m().findViewById(R.id.ksad_video_play_bar_h5).getVisibility();
        m().findViewById(R.id.ksad_video_play_bar_h5).setVisibility(8);
        super.a();
        ((g) this).a.a(this.f55987g);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        float c2 = bb.c(q());
        aVar.a = (int) ((av.n(q()) / c2) + 0.5f);
        aVar.f54928b = (int) ((av.o(q()) / c2) + 0.5f);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(j.a aVar) {
        FrameLayout frameLayout = (FrameLayout) ((g) this).a.f55772j.findViewById(i());
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.height = bb.a(q(), aVar.a);
            layoutParams.leftMargin = bb.a(q(), aVar.f54963b);
            layoutParams.rightMargin = bb.a(q(), aVar.f54964c);
            layoutParams.bottomMargin = bb.a(q(), aVar.f54965d);
            layoutParams.width = -1;
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f55987g);
        if (this.f55985e) {
            this.f55983c.j();
            com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = this.f55984d;
            if (bVar != null) {
                bVar.j();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55983c = new com.kwad.sdk.reward.presenter.platdetail.actionbar.a();
        if (this.f55986f) {
            com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = new com.kwad.sdk.reward.presenter.platdetail.actionbar.b();
            this.f55984d = bVar;
            bVar.c(m());
        }
        this.f55983c.c(m());
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        if (this.f55985e) {
            com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = this.f55984d;
            if (bVar != null) {
                bVar.k();
            }
            this.f55983c.k();
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
        this.f55985e = true;
        m().findViewById(R.id.ksad_video_play_bar_h5).setVisibility(this.f55982b);
        this.f55983c.a(((g) this).a);
        com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = this.f55984d;
        if (bVar != null) {
            bVar.a(((g) this).a);
        }
    }
}
