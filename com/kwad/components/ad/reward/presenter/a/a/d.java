package com.kwad.components.ad.reward.presenter.a.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.c.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, c, com.kwad.components.core.webview.b.d.b {
    public static final String[] sR = {"未获得奖励", "已获得奖励1/2", "已获得全部奖励"};
    public final h mRewardVerifyListener = new h() { // from class: com.kwad.components.ad.reward.presenter.a.a.d.1
        @Override // com.kwad.components.ad.reward.d.h
        public final void onRewardVerify() {
            if (k.q(d.this.nM.mAdTemplate)) {
                d.this.hU();
            }
        }
    };
    public ViewGroup sN;
    public ImageView sO;
    public ViewGroup sP;
    public TextView sQ;

    private void bQ() {
        com.kwad.components.ad.reward.c.eZ().a(this.mRewardVerifyListener);
        this.sN.setVisibility(0);
        this.sP.setVisibility(k.q(this.nM.mAdTemplate) ? 0 : 8);
    }

    private void hT() {
        ImageView imageView = this.sO;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.sO.setOnClickListener(this);
        }
        ViewGroup viewGroup = this.sN;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
            this.sN.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hU() {
        this.sQ.setText(sR[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        k kVar = this.nM;
        com.kwad.sdk.core.report.a.a(kVar.mAdTemplate, 41, kVar.mRootContainer.getTouchCoords(), this.nM.mReportExtData);
        this.nM.mAdOpenInteractionListener.bB();
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        if (k.a(this.nM)) {
            com.kwad.components.core.webview.b.c.a.pR().a(this);
        } else {
            bQ();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a.a.c
    public final void hR() {
        k kVar = this.nM;
        boolean z = kVar.mF;
        AdTemplate adTemplate = kVar.mAdTemplate;
        if (z) {
            if (com.kwad.sdk.core.response.a.a.Z(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) {
                this.sP.setVisibility(8);
            }
        } else if (!k.o(adTemplate) && !k.p(this.nM.mAdTemplate)) {
            if (this.nM.mRewardVerifyCalled) {
                hT();
            }
        } else {
            k kVar2 = this.nM;
            if (kVar2.mRewardVerifyCalled) {
                return;
            }
            this.sQ.setText(kVar2.mD ? sR[1] : sR[0]);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.sO || view2 == this.sN) {
            com.kwad.components.core.c.a.a.a(new a.C0593a(view2.getContext()).L(this.nM.mAdTemplate).b(this.nM.mApkDownloadHelper).aj(false).ae(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.a.a.d.2
                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    d.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sN = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09121b);
        this.sO = (ImageView) findViewById(R.id.obfuscated_res_0x7f09121a);
        this.sP = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091204);
        this.sQ = (TextView) findViewById(R.id.obfuscated_res_0x7f0912d3);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.c.eZ().b(this.mRewardVerifyListener);
        com.kwad.components.core.webview.b.c.a.pR().b(this);
        this.sN.setVisibility(8);
        this.sO.setVisibility(8);
        this.sP.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        if ("ksad-video-top-bar".equals(str)) {
            bQ();
        }
    }
}
