package com.kwad.sdk.reward.presenter.platdetail.actionbar;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.reward.d.g;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes3.dex */
public class d extends g implements RewardActionBarControl.c {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f57559b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.d.g f57560c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f57561d;

    /* renamed from: e  reason: collision with root package name */
    public int f57562e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout.LayoutParams f57563f;

    /* renamed from: g  reason: collision with root package name */
    public g.a f57564g;

    public d(ViewGroup viewGroup, g.a aVar) {
        this.f57559b = viewGroup;
        this.f57564g = aVar;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.g) this).a.n.a(this);
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.f57207g);
        this.f57562e = this.f57561d.getVisibility();
        this.f57563f = c.a(q(), j2, this.f57561d, R.dimen.ksad_reward_order_logo_margin_bottom);
        com.kwad.sdk.reward.d.g gVar = new com.kwad.sdk.reward.d.g(this.f57559b, new com.kwad.sdk.reward.d.a(q(), ((com.kwad.sdk.reward.g) this).a) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.d.1
            @Override // com.kwad.sdk.reward.d.a, com.kwad.sdk.reward.d.b
            public void a() {
                ((com.kwad.sdk.reward.g) d.this).a.a(d.this.q(), 10, 1);
            }

            @Override // com.kwad.sdk.reward.d.a, com.kwad.sdk.reward.d.b
            public void b() {
                ((com.kwad.sdk.reward.g) d.this).a.a(d.this.q(), 10, 1);
            }
        });
        this.f57560c = gVar;
        gVar.a(this.f57564g);
        this.f57560c.a(((com.kwad.sdk.reward.g) this).a.f57207g);
        w.a(new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL()), this.f57560c.a());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f57561d.setVisibility(this.f57562e);
        FrameLayout.LayoutParams layoutParams = this.f57563f;
        if (layoutParams != null) {
            this.f57561d.setLayoutParams(layoutParams);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57561d = (KsLogoView) a(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public void d() {
        this.f57559b.setVisibility(0);
    }
}
