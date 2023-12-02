package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.report.j;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    public TextView vK;
    public TextView vL;

    private void cc() {
        g gVar = this.qn;
        com.kwad.sdk.core.report.a.b(gVar.mAdTemplate, 17, gVar.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iA() {
        j cA = new j().d(this.qn.mRootContainer.getTouchCoords()).cA(39);
        g gVar = this.qn;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, "native_id", "endTopBar", cA, gVar.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        this.qn.oH.bJ();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void iB() {
        if (this.qn.pi) {
            return;
        }
        iz();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vK = (TextView) findViewById(R.id.obfuscated_res_0x7f09135f);
        this.vL = (TextView) findViewById(R.id.obfuscated_res_0x7f091362);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vK.setVisibility(8);
        this.vL.setVisibility(8);
    }

    private void iz() {
        String dD = com.kwad.sdk.core.response.b.d.dD(this.qn.mAdTemplate);
        if (this.qn.mScreenOrientation == 1) {
            this.vL.setVisibility(8);
            this.vK.setText(dD);
            this.vK.setVisibility(0);
            this.vK.setOnClickListener(this);
        } else {
            this.vK.setVisibility(8);
            this.vL.setText(dD);
            this.vL.setVisibility(0);
            this.vL.setOnClickListener(this);
        }
        cc();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.vK || view2 == this.vL) {
            com.kwad.components.core.e.d.a.a(new a.C0644a(view2.getContext()).aq(this.qn.mAdTemplate).b(this.qn.mApkDownloadHelper).ao(false).an(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.d.b.a.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    a.this.iA();
                    a.this.notifyAdClick();
                }
            }));
        }
    }
}
