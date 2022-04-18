package com.kwad.sdk.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
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
/* loaded from: classes5.dex */
public class c extends g implements View.OnClickListener, RewardActionBarControl.a {
    public KsAuthorIconView b;
    public KsLogoView c;
    public ViewGroup d;
    public com.kwad.sdk.reward.d.d e;
    public int f;
    public FrameLayout.LayoutParams g;

    public c(ViewGroup viewGroup) {
        this.d = viewGroup;
    }

    public static FrameLayout.LayoutParams a(Context context, AdInfo adInfo, KsLogoView ksLogoView, int i) {
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
                i = R.dimen.obfuscated_res_0x7f070386;
            }
            layoutParams3.bottomMargin = context.getResources().getDimensionPixelOffset(i);
            layoutParams3.rightMargin = context.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070386);
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
        this.b.setVisibility(0);
        this.b.a(adTemplate);
        this.b.a(com.kwad.sdk.core.config.b.aK(), cVar);
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdInfo j = com.kwad.sdk.core.response.a.d.j(((g) this).a.g);
        com.kwad.sdk.widget.c cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aJ());
        boolean z = com.kwad.sdk.core.config.b.aH() == 2;
        this.f = this.c.getVisibility();
        this.g = a(q(), j, this.c, R.dimen.obfuscated_res_0x7f07038f);
        if (z) {
            a(((g) this).a.g, cVar);
        }
        ((g) this).a.n.a(this);
        boolean aA = com.kwad.sdk.core.response.a.a.aA(j);
        com.kwad.sdk.reward.d.a aVar = new com.kwad.sdk.reward.d.a(q(), ((g) this).a);
        this.e = aA ? new f(this.d, aVar) : new e(this.d, z, aVar);
        w.a(cVar, this.e.a());
        this.e.a(((g) this).a.g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.n.a((RewardActionBarControl.a) null);
        this.c.setVisibility(this.f);
        FrameLayout.LayoutParams layoutParams = this.g;
        if (layoutParams != null) {
            this.c.setLayoutParams(layoutParams);
        }
        this.b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.c = (KsLogoView) a(R.id.obfuscated_res_0x7f09101a);
        KsAuthorIconView ksAuthorIconView = (KsAuthorIconView) a(R.id.obfuscated_res_0x7f0910e8);
        this.b = ksAuthorIconView;
        ksAuthorIconView.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.a
    public void d() {
        this.d.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.equals(this.b)) {
            ((g) this).a.a(q(), 1, 1);
        }
    }
}
