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
/* loaded from: classes4.dex */
public class d extends g implements RewardActionBarControl.c {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f57771b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.d.g f57772c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f57773d;

    /* renamed from: e  reason: collision with root package name */
    public int f57774e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout.LayoutParams f57775f;

    /* renamed from: g  reason: collision with root package name */
    public g.a f57776g;

    public d(ViewGroup viewGroup, g.a aVar) {
        this.f57771b = viewGroup;
        this.f57776g = aVar;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.g) this).a.n.a(this);
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.f57419g);
        this.f57774e = this.f57773d.getVisibility();
        this.f57775f = c.a(q(), j2, this.f57773d, R.dimen.ksad_reward_order_logo_margin_bottom);
        com.kwad.sdk.reward.d.g gVar = new com.kwad.sdk.reward.d.g(this.f57771b, new com.kwad.sdk.reward.d.a(q(), ((com.kwad.sdk.reward.g) this).a) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.d.1
            @Override // com.kwad.sdk.reward.d.a, com.kwad.sdk.reward.d.b
            public void a() {
                ((com.kwad.sdk.reward.g) d.this).a.a(d.this.q(), 10, 1);
            }

            @Override // com.kwad.sdk.reward.d.a, com.kwad.sdk.reward.d.b
            public void b() {
                ((com.kwad.sdk.reward.g) d.this).a.a(d.this.q(), 10, 1);
            }
        });
        this.f57772c = gVar;
        gVar.a(this.f57776g);
        this.f57772c.a(((com.kwad.sdk.reward.g) this).a.f57419g);
        w.a(new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL()), this.f57772c.a());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f57773d.setVisibility(this.f57774e);
        FrameLayout.LayoutParams layoutParams = this.f57775f;
        if (layoutParams != null) {
            this.f57773d.setLayoutParams(layoutParams);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57773d = (KsLogoView) a(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public void d() {
        this.f57771b.setVisibility(0);
    }
}
