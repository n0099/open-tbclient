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
    public int f57465b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.platdetail.actionbar.a f57466c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.platdetail.actionbar.b f57467d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57468e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57469f;

    /* renamed from: g  reason: collision with root package name */
    public f f57470g = new f() { // from class: com.kwad.sdk.reward.presenter.b.c.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            c.this.v();
        }
    };

    public c(boolean z) {
        this.f57469f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        FrameLayout frameLayout = (FrameLayout) ((g) this).a.f57255j.findViewById(i());
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        this.f57465b = m().findViewById(R.id.ksad_video_play_bar_h5).getVisibility();
        m().findViewById(R.id.ksad_video_play_bar_h5).setVisibility(8);
        super.a();
        ((g) this).a.a(this.f57470g);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        float c2 = bb.c(q());
        aVar.a = (int) ((av.n(q()) / c2) + 0.5f);
        aVar.f56411b = (int) ((av.o(q()) / c2) + 0.5f);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(j.a aVar) {
        FrameLayout frameLayout = (FrameLayout) ((g) this).a.f57255j.findViewById(i());
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.height = bb.a(q(), aVar.a);
            layoutParams.leftMargin = bb.a(q(), aVar.f56446b);
            layoutParams.rightMargin = bb.a(q(), aVar.f56447c);
            layoutParams.bottomMargin = bb.a(q(), aVar.f56448d);
            layoutParams.width = -1;
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f57470g);
        if (this.f57468e) {
            this.f57466c.j();
            com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = this.f57467d;
            if (bVar != null) {
                bVar.j();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57466c = new com.kwad.sdk.reward.presenter.platdetail.actionbar.a();
        if (this.f57469f) {
            com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = new com.kwad.sdk.reward.presenter.platdetail.actionbar.b();
            this.f57467d = bVar;
            bVar.c(m());
        }
        this.f57466c.c(m());
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        if (this.f57468e) {
            com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = this.f57467d;
            if (bVar != null) {
                bVar.k();
            }
            this.f57466c.k();
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
        this.f57468e = true;
        m().findViewById(R.id.ksad_video_play_bar_h5).setVisibility(this.f57465b);
        this.f57466c.a(((g) this).a);
        com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = this.f57467d;
        if (bVar != null) {
            bVar.a(((g) this).a);
        }
    }
}
