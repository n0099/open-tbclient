package com.kwad.components.ad.reward.presenter;

import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k.g;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes10.dex */
public final class h extends a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    public RewardActionBarControl ml;
    @Nullable
    public com.kwad.components.ad.reward.k.g pK;
    public KsLogoView pM;
    @Nullable
    public com.kwad.components.ad.reward.k.k pN;
    public boolean pL = false;
    public com.kwad.components.core.video.g mVideoPlayStateListener = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.reward.presenter.h.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            super.onVideoPlayProgress(j, j2);
            if (h.this.pL) {
                return;
            }
            if (h.this.pK == null) {
                h.this.ml.S(false);
            } else {
                h.this.pK.a(new g.a() { // from class: com.kwad.components.ad.reward.presenter.h.1.1
                    @Override // com.kwad.components.ad.reward.k.g.a
                    public final void gX() {
                        h.this.ml.S(true);
                    }
                }, 500L);
            }
            h.a(h.this, true);
        }
    };

    public static /* synthetic */ boolean a(h hVar, boolean z) {
        hVar.pL = true;
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view2) {
        com.kwad.components.ad.reward.k.k kVar = this.pN;
        if (kVar != null) {
            kVar.iW();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.ad.reward.k kVar = this.nM;
        this.ml = kVar.ml;
        kVar.eF.a(this.mVideoPlayStateListener);
        AdTemplate adTemplate = this.nM.mAdTemplate;
        boolean z = com.kwad.sdk.core.response.a.b.bA(adTemplate).displayWeakCard;
        this.nM.B(z);
        if (z) {
            if (this.pK == null) {
                this.pK = new com.kwad.components.ad.reward.k.g(this.nM);
            }
            this.pK.e((AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0913de));
            this.pK.b(u.D(adTemplate));
        }
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        if (com.kwad.sdk.core.response.a.a.aK(adTemplate)) {
            if (this.pN == null) {
                this.pN = new com.kwad.components.ad.reward.k.k(this.nM);
            }
            this.pN.f(this.nM.mRootContainer);
            this.pN.b(u.D(adTemplate));
            com.kwad.components.ad.reward.presenter.platdetail.actionbar.d.a(getContext(), bQ, this.pM, R.dimen.obfuscated_res_0x7f0704d1, false);
        }
        this.nM.ml.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.pM = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09125e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.nM.eF.b(this.mVideoPlayStateListener);
        this.nM.ml.b(this);
        com.kwad.components.ad.reward.k.k kVar = this.pN;
        if (kVar != null) {
            kVar.onUnbind();
        }
    }
}
