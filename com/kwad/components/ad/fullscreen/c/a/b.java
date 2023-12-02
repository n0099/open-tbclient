package com.kwad.components.ad.fullscreen.c.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.report.j;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    public l gO = new l() { // from class: com.kwad.components.ad.fullscreen.c.a.b.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            b.this.g(j2);
        }
    };
    public TextView hl;
    public String hm;
    public long hn;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;

    private void ca() {
        this.hn = com.kwad.sdk.core.response.b.d.dB(this.mAdTemplate);
        String dC = com.kwad.sdk.core.response.b.d.dC(this.mAdTemplate);
        this.hm = dC;
        if (TextUtils.isEmpty(dC)) {
            return;
        }
        g gVar = this.qn;
        this.mApkDownloadHelper = gVar.mApkDownloadHelper;
        gVar.oI.a(this.gO);
    }

    private void cb() {
        if (this.hl.getVisibility() == 0) {
            return;
        }
        this.hl.setText(com.kwad.sdk.core.response.b.d.dC(this.mAdTemplate));
        this.hl.setVisibility(0);
        this.hl.setOnClickListener(this);
        cc();
    }

    private void cc() {
        com.kwad.sdk.core.report.a.b(this.mAdTemplate, 18, this.qn.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, new j().d(this.qn.mRootContainer.getTouchCoords()).cA(40), this.qn.mReportExtData);
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
        this.hl = (TextView) findViewById(R.id.obfuscated_res_0x7f091347);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.hl = null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (!TextUtils.isEmpty(this.hm)) {
            this.qn.oI.b(this.gO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j) {
        if (j >= this.hn) {
            cb();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.hl) {
            com.kwad.components.core.e.d.a.a(new a.C0644a(view2.getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).am(40).al(1).ao(false).af(this.qn.fy()).an(1).a(new a.b() { // from class: com.kwad.components.ad.fullscreen.c.a.b.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    b.this.notifyAdClick();
                }
            }));
        }
    }
}
