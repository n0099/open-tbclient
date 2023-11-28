package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.response.b.e;
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    public static final String[] vV = {"未获得奖励", "已获得奖励1/2", "已获得全部奖励"};
    public final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.b.d.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (g.G(d.this.qn.mAdTemplate)) {
                d.this.iF();
            }
        }
    };
    public ViewGroup vR;
    public ImageView vS;
    public ViewGroup vT;
    public TextView vU;

    private void ca() {
        com.kwad.components.ad.reward.b.fa().a(this.mRewardVerifyListener);
        int i = 0;
        this.vR.setVisibility(0);
        ViewGroup viewGroup = this.vT;
        if (!g.G(this.qn.mAdTemplate)) {
            i = 8;
        }
        viewGroup.setVisibility(i);
    }

    private void iE() {
        ImageView imageView = this.vS;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.vS.setOnClickListener(this);
        }
        ViewGroup viewGroup = this.vR;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
            this.vR.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iF() {
        this.vU.setText(vV[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        j cA = new j().d(this.qn.mRootContainer.getTouchCoords()).cA(41);
        g gVar = this.qn;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, (String) null, (String) null, cA, gVar.mReportExtData);
        this.qn.oH.bJ();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ca();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vR = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091360);
        this.vS = (ImageView) findViewById(R.id.obfuscated_res_0x7f09135f);
        this.vT = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091349);
        this.vU = (TextView) findViewById(R.id.obfuscated_res_0x7f091424);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.fa().b(this.mRewardVerifyListener);
        this.vR.setVisibility(8);
        this.vS.setVisibility(8);
        this.vT.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void iB() {
        String str;
        g gVar = this.qn;
        if (gVar.pi) {
            if (com.kwad.sdk.core.response.b.a.as(e.dP(gVar.mAdTemplate))) {
                this.vT.setVisibility(8);
            }
        } else if (!g.E(gVar.mAdTemplate) && !g.F(this.qn.mAdTemplate)) {
            if (!this.qn.fL()) {
                return;
            }
            iE();
        } else if (!this.qn.fL()) {
            TextView textView = this.vU;
            if (this.qn.pd) {
                str = vV[1];
            } else {
                str = vV[0];
            }
            textView.setText(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.vS || view2 == this.vR) {
            com.kwad.components.core.e.d.a.a(new a.C0644a(view2.getContext()).aq(this.qn.mAdTemplate).b(this.qn.mApkDownloadHelper).ao(false).an(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.d.b.d.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    d.this.notifyAdClick();
                }
            }));
        }
    }
}
