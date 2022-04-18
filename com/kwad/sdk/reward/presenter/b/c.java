package com.kwad.sdk.reward.presenter.b;

import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bb;
/* loaded from: classes5.dex */
public class c extends a {
    public int b;
    public com.kwad.sdk.reward.presenter.platdetail.actionbar.a c;
    public com.kwad.sdk.reward.presenter.platdetail.actionbar.b d;
    public boolean e;
    public boolean f;
    public f g = new f() { // from class: com.kwad.sdk.reward.presenter.b.c.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            c.this.v();
        }
    };

    public c(boolean z) {
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        FrameLayout frameLayout = (FrameLayout) ((g) this).a.j.findViewById(i());
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        this.b = m().findViewById(R.id.obfuscated_res_0x7f091170).getVisibility();
        m().findViewById(R.id.obfuscated_res_0x7f091170).setVisibility(8);
        super.a();
        ((g) this).a.a(this.g);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        float c = bb.c(q());
        aVar.a = (int) ((av.n(q()) / c) + 0.5f);
        aVar.b = (int) ((av.o(q()) / c) + 0.5f);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(j.a aVar) {
        FrameLayout frameLayout = (FrameLayout) ((g) this).a.j.findViewById(i());
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.height = bb.a(q(), aVar.a);
            layoutParams.leftMargin = bb.a(q(), aVar.b);
            layoutParams.rightMargin = bb.a(q(), aVar.c);
            layoutParams.bottomMargin = bb.a(q(), aVar.d);
            layoutParams.width = -1;
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.g);
        if (this.e) {
            this.c.j();
            com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = this.d;
            if (bVar != null) {
                bVar.j();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.c = new com.kwad.sdk.reward.presenter.platdetail.actionbar.a();
        if (this.f) {
            com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = new com.kwad.sdk.reward.presenter.platdetail.actionbar.b();
            this.d = bVar;
            bVar.c(m());
        }
        this.c.c(m());
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        if (this.e) {
            com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = this.d;
            if (bVar != null) {
                bVar.k();
            }
            this.c.k();
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public String e() {
        return "ksad-video-bottom-card.js";
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public int i() {
        return R.id.obfuscated_res_0x7f0910a2;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void r() {
        this.e = true;
        m().findViewById(R.id.obfuscated_res_0x7f091170).setVisibility(this.b);
        this.c.a(((g) this).a);
        com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = this.d;
        if (bVar != null) {
            bVar.a(((g) this).a);
        }
    }
}
