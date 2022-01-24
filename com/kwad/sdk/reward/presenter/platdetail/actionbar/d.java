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
    public ViewGroup f57604b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.d.g f57605c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f57606d;

    /* renamed from: e  reason: collision with root package name */
    public int f57607e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout.LayoutParams f57608f;

    /* renamed from: g  reason: collision with root package name */
    public g.a f57609g;

    public d(ViewGroup viewGroup, g.a aVar) {
        this.f57604b = viewGroup;
        this.f57609g = aVar;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.g) this).a.n.a(this);
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.f57252g);
        this.f57607e = this.f57606d.getVisibility();
        this.f57608f = c.a(q(), j2, this.f57606d, R.dimen.ksad_reward_order_logo_margin_bottom);
        com.kwad.sdk.reward.d.g gVar = new com.kwad.sdk.reward.d.g(this.f57604b, new com.kwad.sdk.reward.d.a(q(), ((com.kwad.sdk.reward.g) this).a) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.d.1
            @Override // com.kwad.sdk.reward.d.a, com.kwad.sdk.reward.d.b
            public void a() {
                ((com.kwad.sdk.reward.g) d.this).a.a(d.this.q(), 10, 1);
            }

            @Override // com.kwad.sdk.reward.d.a, com.kwad.sdk.reward.d.b
            public void b() {
                ((com.kwad.sdk.reward.g) d.this).a.a(d.this.q(), 10, 1);
            }
        });
        this.f57605c = gVar;
        gVar.a(this.f57609g);
        this.f57605c.a(((com.kwad.sdk.reward.g) this).a.f57252g);
        w.a(new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL()), this.f57605c.a());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f57606d.setVisibility(this.f57607e);
        FrameLayout.LayoutParams layoutParams = this.f57608f;
        if (layoutParams != null) {
            this.f57606d.setLayoutParams(layoutParams);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57606d = (KsLogoView) a(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public void d() {
        this.f57604b.setVisibility(0);
    }
}
