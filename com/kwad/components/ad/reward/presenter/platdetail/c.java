package com.kwad.components.ad.reward.presenter.platdetail;

import android.graphics.Color;
import android.view.View;
import com.baidu.tieba.R;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.widget.f;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements com.kwad.sdk.widget.c {
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public DetailVideoView mDetailVideoView;

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        String str;
        super.aj();
        this.mApkDownloadHelper = this.qn.mApkDownloadHelper;
        new f(this.mDetailVideoView, this);
        if (com.kwad.sdk.core.response.b.a.aY(e.dP(this.mAdTemplate))) {
            str = "#B3000000";
        } else {
            str = "#4D000000";
        }
        this.mDetailVideoView.setBackgroundColor(Color.parseColor(str));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f091500);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mDetailVideoView.setClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(boolean z) {
        int i;
        if (z) {
            i = 85;
        } else {
            i = 153;
        }
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", "videoPlayer", new j().cA(i).d(this.qn.mRootContainer.getTouchCoords()), this.qn.mReportExtData);
        this.qn.oH.bJ();
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        b(view2, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        if (d.dE(this.mAdTemplate)) {
            b(view2, false);
        }
    }

    private void b(View view2, final boolean z) {
        com.kwad.components.core.e.d.a.a(new a.C0644a(view2.getContext()).aq(this.mAdTemplate).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.c.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                c.this.K(z);
            }
        }).b(this.mApkDownloadHelper).ao(false).an(3));
    }
}
