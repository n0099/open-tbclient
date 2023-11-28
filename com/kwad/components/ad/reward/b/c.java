package com.kwad.components.ad.reward.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.b.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements b.a {
    public AdTemplate mAdTemplate;
    public boolean rd = false;

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.mAdTemplate = this.qn.mAdTemplate;
    }

    @Override // com.kwad.components.ad.reward.b.b.a
    public final void gH() {
        this.qn.a(1, getContext(), 29, 1);
    }

    public static boolean l(AdInfo adInfo) {
        AdProductInfo cM = com.kwad.sdk.core.response.b.a.cM(adInfo);
        if (com.kwad.components.ad.reward.a.b.i(adInfo) && cM != null && !cM.isCouponListEmpty()) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.rd = true;
        return true;
    }

    public final void showDialog() {
        com.kwad.sdk.core.e.c.d("RewardCouponDialogPresenter", "onBind hasShown : " + this.rd);
        if (this.rd) {
            return;
        }
        AdInfo dP = e.dP(this.mAdTemplate);
        ViewGroup viewGroup = (ViewGroup) this.qn.mRootContainer.findViewById(R.id.obfuscated_res_0x7f09145b);
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        View view2 = viewGroup;
        if (childCount > 0) {
            view2 = viewGroup.getChildAt(0);
        }
        final int[] E = com.kwad.sdk.d.a.a.E(view2);
        if (l(dP) && E != null) {
            view2.post(new Runnable() { // from class: com.kwad.components.ad.reward.b.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.e.c.d("RewardCouponDialogPresenter", "targetView x: " + E[0] + ", y: " + E[1]);
                    b.a(c.this.getActivity(), c.this.mAdTemplate, c.this, E);
                    c.a(c.this, true);
                }
            });
        }
    }
}
