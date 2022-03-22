package com.kwad.sdk.reward.presenter.b;

import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bb;
/* loaded from: classes7.dex */
public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public int f40938b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.platdetail.actionbar.a f40939c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.presenter.platdetail.actionbar.b f40940d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40941e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40942f;

    /* renamed from: g  reason: collision with root package name */
    public f f40943g = new f() { // from class: com.kwad.sdk.reward.presenter.b.c.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            c.this.v();
        }
    };

    public c(boolean z) {
        this.f40942f = z;
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
        this.f40938b = m().findViewById(R.id.obfuscated_res_0x7f091176).getVisibility();
        m().findViewById(R.id.obfuscated_res_0x7f091176).setVisibility(8);
        super.a();
        ((g) this).a.a(this.f40943g);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(d.a aVar) {
        float c2 = bb.c(q());
        aVar.a = (int) ((av.n(q()) / c2) + 0.5f);
        aVar.f40018b = (int) ((av.o(q()) / c2) + 0.5f);
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void a(j.a aVar) {
        FrameLayout frameLayout = (FrameLayout) ((g) this).a.j.findViewById(i());
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.height = bb.a(q(), aVar.a);
            layoutParams.leftMargin = bb.a(q(), aVar.f40049b);
            layoutParams.rightMargin = bb.a(q(), aVar.f40050c);
            layoutParams.bottomMargin = bb.a(q(), aVar.f40051d);
            layoutParams.width = -1;
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f40943g);
        if (this.f40941e) {
            this.f40939c.j();
            com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = this.f40940d;
            if (bVar != null) {
                bVar.j();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40939c = new com.kwad.sdk.reward.presenter.platdetail.actionbar.a();
        if (this.f40942f) {
            com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = new com.kwad.sdk.reward.presenter.platdetail.actionbar.b();
            this.f40940d = bVar;
            bVar.c(m());
        }
        this.f40939c.c(m());
    }

    @Override // com.kwad.sdk.reward.presenter.b.a, com.kwad.sdk.mvp.Presenter
    public void d_() {
        super.d_();
        if (this.f40941e) {
            com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = this.f40940d;
            if (bVar != null) {
                bVar.k();
            }
            this.f40939c.k();
        }
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public String e() {
        return "ksad-video-bottom-card.js";
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public int i() {
        return R.id.obfuscated_res_0x7f0910a8;
    }

    @Override // com.kwad.sdk.reward.presenter.b.a
    public void r() {
        this.f40941e = true;
        m().findViewById(R.id.obfuscated_res_0x7f091176).setVisibility(this.f40938b);
        this.f40939c.a(((g) this).a);
        com.kwad.sdk.reward.presenter.platdetail.actionbar.b bVar = this.f40940d;
        if (bVar != null) {
            bVar.a(((g) this).a);
        }
    }
}
