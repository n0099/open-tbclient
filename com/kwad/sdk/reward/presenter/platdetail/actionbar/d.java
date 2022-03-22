package com.kwad.sdk.reward.presenter.platdetail.actionbar;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.reward.d.g;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes7.dex */
public class d extends g implements RewardActionBarControl.c {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f41059b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.d.g f41060c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f41061d;

    /* renamed from: e  reason: collision with root package name */
    public int f41062e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout.LayoutParams f41063f;

    /* renamed from: g  reason: collision with root package name */
    public g.a f41064g;

    public d(ViewGroup viewGroup, g.a aVar) {
        this.f41059b = viewGroup;
        this.f41064g = aVar;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.g) this).a.n.a(this);
        AdInfo j = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.f40747g);
        this.f41062e = this.f41061d.getVisibility();
        this.f41063f = c.a(q(), j, this.f41061d, R.dimen.obfuscated_res_0x7f070393);
        com.kwad.sdk.reward.d.g gVar = new com.kwad.sdk.reward.d.g(this.f41059b, new com.kwad.sdk.reward.d.a(q(), ((com.kwad.sdk.reward.g) this).a) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.d.1
            @Override // com.kwad.sdk.reward.d.a, com.kwad.sdk.reward.d.b
            public void a() {
                ((com.kwad.sdk.reward.g) d.this).a.a(d.this.q(), 10, 1);
            }

            @Override // com.kwad.sdk.reward.d.a, com.kwad.sdk.reward.d.b
            public void b() {
                ((com.kwad.sdk.reward.g) d.this).a.a(d.this.q(), 10, 1);
            }
        });
        this.f41060c = gVar;
        gVar.a(this.f41064g);
        this.f41060c.a(((com.kwad.sdk.reward.g) this).a.f40747g);
        w.a(new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL()), this.f41060c.a());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f41061d.setVisibility(this.f41062e);
        FrameLayout.LayoutParams layoutParams = this.f41063f;
        if (layoutParams != null) {
            this.f41061d.setLayoutParams(layoutParams);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f41061d = (KsLogoView) a(R.id.obfuscated_res_0x7f091020);
    }

    @Override // com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public void d() {
        this.f41059b.setVisibility(0);
    }
}
