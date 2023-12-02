package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.n.n;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.s.i;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes10.dex */
public final class e extends com.kwad.components.ad.reward.presenter.b implements RewardActionBarControl.c {
    public ViewGroup gS;
    public KsLogoView sq;
    public n uU;
    public int uV;
    public FrameLayout.LayoutParams uW;
    public n.a uX;

    public e(ViewGroup viewGroup, n.a aVar) {
        this.gS = viewGroup;
        this.uX = aVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public final void e(a aVar) {
        this.gS.setVisibility(0);
        RewardActionBarControl.a(aVar, this.gS, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORDER);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qn.oL.a(this);
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.qn.mAdTemplate);
        this.uV = this.sq.getVisibility();
        this.uW = d.a(getContext(), dP, this.sq, R.dimen.obfuscated_res_0x7f070537, !this.qn.oI.jK());
        n nVar = new n(this.gS, new com.kwad.components.ad.reward.n.a(getContext(), this.qn) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.e.1
            @Override // com.kwad.components.ad.reward.n.a, com.kwad.components.ad.reward.n.b
            /* renamed from: if */
            public final void mo180if() {
                e.this.qn.a(1, e.this.getContext(), 10, 2);
            }

            @Override // com.kwad.components.ad.reward.n.a, com.kwad.components.ad.reward.n.b
            public final void ig() {
                e.this.qn.a(1, e.this.getContext(), 10, 2);
            }
        });
        this.uU = nVar;
        nVar.a(this.uX);
        this.uU.b(r.R(this.qn.mAdTemplate));
        i.a(new com.kwad.components.core.widget.e(), this.uU.gD());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0912f6);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.sq.setVisibility(this.uV);
        FrameLayout.LayoutParams layoutParams = this.uW;
        if (layoutParams != null) {
            this.sq.setLayoutParams(layoutParams);
        }
    }
}
