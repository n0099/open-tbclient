package com.kwad.components.ad.reward.presenter.b;

import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.o;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    public RewardActionBarControl oL;
    public l su = new l() { // from class: com.kwad.components.ad.reward.presenter.b.c.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            c.this.hs();
        }
    };
    @Nullable
    public o tS;

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hs() {
        this.oL.O(false);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.oI.b(this.su);
        this.qn.oL.b(this);
        o oVar = this.tS;
        if (oVar != null) {
            oVar.onUnbind();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        g gVar = this.qn;
        this.oL = gVar.oL;
        gVar.oI.a(this.su);
        AdTemplate adTemplate = this.qn.mAdTemplate;
        AdInfo dP = e.dP(adTemplate);
        if (com.kwad.sdk.core.response.b.a.cJ(dP)) {
            if (this.tS == null) {
                this.tS = new o(this.qn);
            }
            this.tS.a(this.qn.mRootContainer, com.kwad.sdk.core.response.b.a.bf(dP));
            this.tS.b(r.R(adTemplate));
            findViewById(R.id.obfuscated_res_0x7f091473).setVisibility(8);
        }
        this.qn.oL.a(this);
    }
}
