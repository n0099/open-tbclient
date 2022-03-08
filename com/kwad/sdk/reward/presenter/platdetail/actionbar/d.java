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
/* loaded from: classes8.dex */
public class d extends g implements RewardActionBarControl.c {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f56121b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.d.g f56122c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f56123d;

    /* renamed from: e  reason: collision with root package name */
    public int f56124e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout.LayoutParams f56125f;

    /* renamed from: g  reason: collision with root package name */
    public g.a f56126g;

    public d(ViewGroup viewGroup, g.a aVar) {
        this.f56121b = viewGroup;
        this.f56126g = aVar;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.g) this).a.n.a(this);
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.f55769g);
        this.f56124e = this.f56123d.getVisibility();
        this.f56125f = c.a(q(), j2, this.f56123d, R.dimen.ksad_reward_order_logo_margin_bottom);
        com.kwad.sdk.reward.d.g gVar = new com.kwad.sdk.reward.d.g(this.f56121b, new com.kwad.sdk.reward.d.a(q(), ((com.kwad.sdk.reward.g) this).a) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.d.1
            @Override // com.kwad.sdk.reward.d.a, com.kwad.sdk.reward.d.b
            public void a() {
                ((com.kwad.sdk.reward.g) d.this).a.a(d.this.q(), 10, 1);
            }

            @Override // com.kwad.sdk.reward.d.a, com.kwad.sdk.reward.d.b
            public void b() {
                ((com.kwad.sdk.reward.g) d.this).a.a(d.this.q(), 10, 1);
            }
        });
        this.f56122c = gVar;
        gVar.a(this.f56126g);
        this.f56122c.a(((com.kwad.sdk.reward.g) this).a.f55769g);
        w.a(new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL()), this.f56122c.a());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f56123d.setVisibility(this.f56124e);
        FrameLayout.LayoutParams layoutParams = this.f56125f;
        if (layoutParams != null) {
            this.f56123d.setLayoutParams(layoutParams);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56123d = (KsLogoView) a(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public void d() {
        this.f56121b.setVisibility(0);
    }
}
