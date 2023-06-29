package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k.m;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.m.j;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes9.dex */
public final class e extends com.kwad.components.ad.reward.presenter.a implements RewardActionBarControl.c {
    public ViewGroup es;
    public KsLogoView pM;
    public m rN;
    public int rO;
    public FrameLayout.LayoutParams rP;
    public m.a rQ;

    public e(ViewGroup viewGroup, m.a aVar) {
        this.es = viewGroup;
        this.rQ = aVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.nM.ml.a(this);
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate);
        this.rO = this.pM.getVisibility();
        this.rP = d.a(getContext(), bQ, this.pM, R.dimen.obfuscated_res_0x7f070530, true);
        m mVar = new m(this.es, new com.kwad.components.ad.reward.k.a(getContext(), this.nM) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.e.1
            @Override // com.kwad.components.ad.reward.k.a, com.kwad.components.ad.reward.k.b
            public final void hA() {
                e.this.nM.a(e.this.getContext(), 10, 2);
            }

            @Override // com.kwad.components.ad.reward.k.a, com.kwad.components.ad.reward.k.b
            public final void hz() {
                e.this.nM.a(e.this.getContext(), 10, 2);
            }
        });
        this.rN = mVar;
        mVar.a(this.rQ);
        this.rN.b(u.D(this.nM.mAdTemplate));
        j.a(new com.kwad.components.core.widget.f(), this.rN.fR());
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public final void e(a aVar) {
        this.es.setVisibility(0);
        RewardActionBarControl.a(aVar, this.es, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORDER);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.pM = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091237);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.pM.setVisibility(this.rO);
        FrameLayout.LayoutParams layoutParams = this.rP;
        if (layoutParams != null) {
            this.pM.setLayoutParams(layoutParams);
        }
    }
}
