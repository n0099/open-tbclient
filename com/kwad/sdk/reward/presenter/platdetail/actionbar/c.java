package com.kwad.sdk.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.d.e;
import com.kwad.sdk.reward.d.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.widget.KsAuthorIconView;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes3.dex */
public class c extends g implements View.OnClickListener, RewardActionBarControl.a {

    /* renamed from: b  reason: collision with root package name */
    public KsAuthorIconView f59816b;

    /* renamed from: c  reason: collision with root package name */
    public KsLogoView f59817c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f59818d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.reward.d.d f59819e;

    /* renamed from: f  reason: collision with root package name */
    public int f59820f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout.LayoutParams f59821g;

    public c(ViewGroup viewGroup) {
        this.f59818d = viewGroup;
    }

    public static FrameLayout.LayoutParams a(Context context, AdInfo adInfo, KsLogoView ksLogoView, int i2) {
        FrameLayout.LayoutParams layoutParams = null;
        if (ksLogoView != null && context != null) {
            ViewGroup.LayoutParams layoutParams2 = ksLogoView.getLayoutParams();
            if (!(layoutParams2 instanceof FrameLayout.LayoutParams)) {
                return null;
            }
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
            layoutParams = a(layoutParams3);
            boolean z = false;
            ksLogoView.setVisibility(0);
            z = ((!af.e(context) && (com.kwad.sdk.core.response.a.a.aH(adInfo) || com.kwad.sdk.core.response.a.a.aI(adInfo))) || (af.e(context) && com.kwad.sdk.core.response.a.a.aH(adInfo) && com.kwad.sdk.core.response.a.a.aA(adInfo))) ? true : true;
            layoutParams3.gravity = 85;
            if (z) {
                i2 = R.dimen.ksad_reward_follow_card_margin;
            }
            layoutParams3.bottomMargin = context.getResources().getDimensionPixelOffset(i2);
            layoutParams3.rightMargin = context.getResources().getDimensionPixelOffset(R.dimen.ksad_reward_follow_card_margin);
            ksLogoView.setLayoutParams(layoutParams3);
        }
        return layoutParams;
    }

    public static FrameLayout.LayoutParams a(FrameLayout.LayoutParams layoutParams) {
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        layoutParams2.gravity = layoutParams.gravity;
        return layoutParams2;
    }

    private void a(AdTemplate adTemplate, com.kwad.sdk.widget.c cVar) {
        this.f59816b.setVisibility(0);
        this.f59816b.a(adTemplate);
        this.f59816b.a(com.kwad.sdk.core.config.b.aK(), cVar);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(((g) this).a.f59455g);
        com.kwad.sdk.widget.c cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aJ());
        boolean z = com.kwad.sdk.core.config.b.aH() == 2;
        this.f59820f = this.f59817c.getVisibility();
        this.f59821g = a(q(), j2, this.f59817c, R.dimen.ksad_reward_follow_logo_margin_bottom);
        if (z) {
            a(((g) this).a.f59455g, cVar);
        }
        ((g) this).a.n.a(this);
        boolean aA = com.kwad.sdk.core.response.a.a.aA(j2);
        com.kwad.sdk.reward.d.a aVar = new com.kwad.sdk.reward.d.a(q(), ((g) this).a);
        this.f59819e = aA ? new f(this.f59818d, aVar) : new e(this.f59818d, z, aVar);
        w.a(cVar, this.f59819e.a());
        this.f59819e.a(((g) this).a.f59455g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.n.a((RewardActionBarControl.a) null);
        this.f59817c.setVisibility(this.f59820f);
        FrameLayout.LayoutParams layoutParams = this.f59821g;
        if (layoutParams != null) {
            this.f59817c.setLayoutParams(layoutParams);
        }
        this.f59816b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59817c = (KsLogoView) a(R.id.ksad_ad_label_play_bar);
        KsAuthorIconView ksAuthorIconView = (KsAuthorIconView) a(R.id.ksad_reward_author_view);
        this.f59816b = ksAuthorIconView;
        ksAuthorIconView.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.a
    public void d() {
        this.f59818d.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.f59816b)) {
            ((g) this).a.a(q(), 1, 1);
        }
    }
}
