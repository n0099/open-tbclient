package com.kwad.components.ad.reward.presenter;

import android.app.Activity;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes8.dex */
public class a extends Presenter {
    public com.kwad.components.ad.reward.k nM;

    public final void L(boolean z) {
        int i = z ? 1 : 153;
        com.kwad.components.ad.reward.k kVar = this.nM;
        com.kwad.sdk.core.report.a.a(kVar.mAdTemplate, i, kVar.mRootContainer.getTouchCoords(), this.nM.mReportExtData);
        this.nM.mAdOpenInteractionListener.bB();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void aq() {
        super.aq();
        this.nM = (com.kwad.components.ad.reward.k) xR();
    }

    public final void gR() {
        Activity activity = this.nM.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
