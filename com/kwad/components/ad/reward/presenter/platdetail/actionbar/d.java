package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k.h;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ag;
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.k.b {
    public ViewGroup es;
    public KsLogoView pM;
    public h rM;

    public d(ViewGroup viewGroup) {
        this.es = viewGroup;
    }

    public static FrameLayout.LayoutParams a(Context context, AdInfo adInfo, KsLogoView ksLogoView, int i, boolean z) {
        FrameLayout.LayoutParams layoutParams = null;
        if (ksLogoView != null && context != null) {
            ViewGroup.LayoutParams layoutParams2 = ksLogoView.getLayoutParams();
            if (!(layoutParams2 instanceof FrameLayout.LayoutParams)) {
                return null;
            }
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
            layoutParams = a(layoutParams3);
            boolean z2 = false;
            if (z) {
                ksLogoView.setVisibility(0);
            }
            z2 = ((!ag.cB(context) && (com.kwad.components.ad.reward.kwai.b.h(adInfo) || com.kwad.sdk.core.response.a.a.bF(adInfo))) || (ag.cB(context) && com.kwad.sdk.core.response.a.a.bE(adInfo))) ? true : true;
            layoutParams3.gravity = 85;
            if (z2) {
                i = R.dimen.obfuscated_res_0x7f07050f;
            }
            layoutParams3.bottomMargin = context.getResources().getDimensionPixelOffset(i);
            layoutParams3.rightMargin = context.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07050f);
            ksLogoView.setLayoutParams(layoutParams3);
        }
        return layoutParams;
    }

    public static FrameLayout.LayoutParams a(FrameLayout.LayoutParams layoutParams) {
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        layoutParams2.gravity = layoutParams.gravity;
        return layoutParams2;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        h hVar = new h(this.nM, this.es, this.pM);
        this.rM = hVar;
        hVar.b(u.D(this.nM.mAdTemplate));
        a(getContext(), com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate), this.pM, R.dimen.obfuscated_res_0x7f07052b, false);
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void gn() {
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void hA() {
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void hz() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.pM = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09127a);
    }
}
