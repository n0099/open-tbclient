package com.kwad.components.ad.reward.presenter.a.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.c.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, c, com.kwad.components.core.webview.b.d.b {
    @NonNull
    public com.kwad.components.ad.reward.d.a mAdOpenInteractionListener;
    @NonNull
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public TextView sH;
    public TextView sI;

    private void bQ() {
        k kVar = this.nM;
        this.mAdOpenInteractionListener = kVar.mAdOpenInteractionListener;
        this.mAdTemplate = kVar.mAdTemplate;
        this.mApkDownloadHelper = kVar.mApkDownloadHelper;
    }

    private void bS() {
        com.kwad.sdk.core.report.a.c(this.mAdTemplate, 17, this.nM.mReportExtData);
    }

    private void hP() {
        TextView textView;
        String bE = com.kwad.sdk.core.response.a.c.bE(this.mAdTemplate);
        if (TextUtils.isEmpty(bE)) {
            return;
        }
        if (this.nM.mScreenOrientation == 1) {
            this.sI.setVisibility(8);
            this.sH.setText(bE);
            this.sH.setVisibility(0);
            textView = this.sH;
        } else {
            this.sH.setVisibility(8);
            this.sI.setText(bE);
            this.sI.setVisibility(0);
            textView = this.sI;
        }
        textView.setOnClickListener(this);
        bS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hQ() {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, 39, this.nM.mRootContainer.getTouchCoords(), this.nM.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        this.mAdOpenInteractionListener.bB();
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
        if (this.nM.mF) {
            return;
        }
        hP();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.sH || view2 == this.sI) {
            com.kwad.components.core.c.a.a.a(new a.C0636a(view2.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(false).ae(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.a.a.a.1
                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    a.this.hQ();
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sH = (TextView) findViewById(R.id.obfuscated_res_0x7f0912c2);
        this.sI = (TextView) findViewById(R.id.obfuscated_res_0x7f0912c5);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.b.c.a.pR().b(this);
        this.sH.setVisibility(8);
        this.sI.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        if ("ksad-video-top-bar".equals(str)) {
            bQ();
        }
    }
}
