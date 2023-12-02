package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.n.i;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ai;
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.n.b {
    public ViewGroup gS;
    public KsLogoView sq;
    public i uT;

    @Override // com.kwad.components.ad.reward.n.b
    public final void gH() {
    }

    @Override // com.kwad.components.ad.reward.n.b
    /* renamed from: if */
    public final void mo180if() {
    }

    @Override // com.kwad.components.ad.reward.n.b
    public final void ig() {
    }

    public d(ViewGroup viewGroup) {
        this.gS = viewGroup;
    }

    public static FrameLayout.LayoutParams a(FrameLayout.LayoutParams layoutParams) {
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        layoutParams2.gravity = layoutParams.gravity;
        return layoutParams2;
    }

    public static FrameLayout.LayoutParams a(Context context, AdInfo adInfo, KsLogoView ksLogoView, int i, boolean z) {
        boolean z2;
        boolean z3;
        FrameLayout.LayoutParams layoutParams = null;
        if (ksLogoView != null && context != null) {
            ViewGroup.LayoutParams layoutParams2 = ksLogoView.getLayoutParams();
            if (!(layoutParams2 instanceof FrameLayout.LayoutParams)) {
                return null;
            }
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
            layoutParams = a(layoutParams3);
            boolean z4 = false;
            if (z) {
                ksLogoView.setVisibility(0);
            }
            if (!ai.Kx() && (com.kwad.components.ad.reward.a.b.i(adInfo) || com.kwad.sdk.core.response.b.a.cD(adInfo))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (ai.Kx() && com.kwad.sdk.core.response.b.a.cC(adInfo)) {
                z3 = true;
            } else {
                z3 = false;
            }
            z4 = (z2 || z3) ? true : true;
            layoutParams3.gravity = 85;
            if (z4) {
                i = R.dimen.obfuscated_res_0x7f07050b;
            }
            layoutParams3.bottomMargin = context.getResources().getDimensionPixelOffset(i);
            layoutParams3.rightMargin = context.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07050b);
            ksLogoView.setLayoutParams(layoutParams3);
        }
        return layoutParams;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        i iVar = new i(this.qn, this.gS, this.sq);
        this.uT = iVar;
        iVar.b(r.R(this.qn.mAdTemplate));
        a(getContext(), com.kwad.sdk.core.response.b.e.dP(this.qn.mAdTemplate), this.sq, R.dimen.obfuscated_res_0x7f070527, false);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0912f6);
    }
}
