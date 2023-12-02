package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    public View vN;
    public boolean vO;
    public final Runnable vP = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.d.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.getActivity() != null && !b.this.getActivity().isFinishing()) {
                b.this.iC();
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.vO = com.kwad.sdk.core.response.b.b.dN(e.dP(this.qn.mAdTemplate));
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void iB() {
        g gVar = this.qn;
        if (gVar.pi) {
            return;
        }
        long j = gVar.pt;
        if (j == 0) {
            this.vP.run();
        } else {
            bn.runOnUiThreadDelay(this.vP, j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        View findViewById = findViewById(R.id.obfuscated_res_0x7f09135e);
        this.vN = findViewById;
        findViewById.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vN.setVisibility(8);
        bn.c(this.vP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iC() {
        com.kwad.sdk.core.e.c.d("RewardPlayEndCloseBtn", "showPageCloseBtn mPlayEndH5ShowSuccess: " + this.qn.pz + ", needHideCloseButton: " + this.vO);
        if (this.qn.pz && this.vO) {
            return;
        }
        this.vN.setVisibility(0);
        this.vN.setAlpha(0.0f);
        this.vN.animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.vN) {
            PlayableSource fF = this.qn.fF();
            if (fF != null && (fF.equals(PlayableSource.PENDANT_CLICK_NOT_AUTO) || fF.equals(PlayableSource.PENDANT_CLICK_AUTO) || fF.equals(PlayableSource.PENDANT_AUTO) || fF.equals(PlayableSource.ACTIONBAR_CLICK))) {
                com.kwad.components.ad.reward.a.eW().eX();
            } else {
                f.t(this.qn);
            }
        }
    }
}
