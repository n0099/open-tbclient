package com.kwad.components.ad.reward.presenter;

import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.n.g;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes10.dex */
public final class l extends b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    public RewardActionBarControl oL;
    @Nullable
    public com.kwad.components.ad.reward.n.g so;
    public KsLogoView sq;
    @Nullable
    public com.kwad.components.ad.reward.n.l sr;
    public boolean sp = false;
    public com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.l.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            l.this.hs();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void hs() {
        if (!this.sp) {
            com.kwad.components.ad.reward.n.g gVar = this.so;
            if (gVar == null) {
                this.oL.O(false);
            } else {
                gVar.a(new g.a() { // from class: com.kwad.components.ad.reward.presenter.l.2
                    @Override // com.kwad.components.ad.reward.n.g.a
                    public final void ht() {
                        l.this.oL.O(true);
                    }
                }, 500L);
            }
            this.sp = true;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0912f5);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.oI.b(this.gO);
        this.qn.oL.b(this);
        com.kwad.components.ad.reward.n.l lVar = this.sr;
        if (lVar != null) {
            lVar.onUnbind();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view2) {
        com.kwad.components.ad.reward.n.l lVar = this.sr;
        if (lVar != null) {
            lVar.jX();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.reward.g gVar = this.qn;
        this.oL = gVar.oL;
        gVar.oI.a(this.gO);
        AdTemplate adTemplate = this.qn.mAdTemplate;
        boolean z = com.kwad.sdk.core.response.b.b.da(adTemplate).displayWeakCard;
        this.qn.A(z);
        if (z) {
            if (this.so == null) {
                this.so = new com.kwad.components.ad.reward.n.g(this.qn);
            }
            this.so.f((AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f09148f));
            this.so.b(com.kwad.components.ad.reward.n.r.R(adTemplate));
        }
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        if (com.kwad.sdk.core.response.b.a.ca(adTemplate)) {
            if (this.sr == null) {
                this.sr = new com.kwad.components.ad.reward.n.l(this.qn);
            }
            this.sr.h(this.qn.mRootContainer);
            this.sr.b(com.kwad.components.ad.reward.n.r.R(adTemplate));
            com.kwad.components.ad.reward.presenter.platdetail.actionbar.d.a(getContext(), dP, this.sq, R.dimen.obfuscated_res_0x7f0704e3, false);
        }
        this.qn.oL.a(this);
    }
}
