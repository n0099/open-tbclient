package com.kwad.components.ad.reward.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.a.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements b.a {
    public AdTemplate mAdTemplate;
    public boolean oB = false;

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.oB = true;
        return true;
    }

    public static boolean k(AdInfo adInfo) {
        AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(adInfo);
        return (!com.kwad.components.ad.reward.kwai.b.h(adInfo) || bN == null || bN.isCouponListEmpty()) ? false : true;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.mAdTemplate = this.nM.mAdTemplate;
    }

    @Override // com.kwad.components.ad.reward.a.b.a
    public final void gn() {
        this.nM.a(getContext(), 29, 1);
    }

    public final void showDialog() {
        com.kwad.sdk.core.e.b.d("RewardCouponDialogPresenter", "onBind hasShown : " + this.oB);
        if (this.oB) {
            return;
        }
        AdInfo bQ = d.bQ(this.mAdTemplate);
        ViewGroup viewGroup = (ViewGroup) this.nM.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091380);
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        View view2 = viewGroup;
        if (childCount > 0) {
            view2 = viewGroup.getChildAt(0);
        }
        final int[] z = com.kwad.sdk.b.kwai.a.z(view2);
        if (!k(bQ) || z == null) {
            return;
        }
        view2.post(new Runnable() { // from class: com.kwad.components.ad.reward.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.e.b.d("RewardCouponDialogPresenter", "targetView x: " + z[0] + ", y: " + z[1]);
                b.a(c.this.getActivity(), c.this.mAdTemplate, c.this, z);
                c.a(c.this, true);
            }
        });
    }
}
