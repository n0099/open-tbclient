package com.kwad.components.ad.reward.presenter.platdetail;

import android.graphics.Color;
import android.view.View;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.c;
/* loaded from: classes8.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements c {
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public DetailVideoView mDetailVideoView;

    /* JADX INFO: Access modifiers changed from: private */
    public void P(boolean z) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, new f().aI(z ? 1 : 153).b(this.nM.mRootContainer.getTouchCoords()), this.nM.mReportExtData);
        this.nM.mAdOpenInteractionListener.bB();
    }

    private void b(View view2, final boolean z) {
        com.kwad.components.core.c.a.a.a(new a.C0588a(view2.getContext()).L(this.mAdTemplate).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.1
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                b.this.P(z);
            }
        }).b(this.mApkDownloadHelper).aj(false).ae(3));
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        k kVar = this.nM;
        this.mAdTemplate = kVar.mAdTemplate;
        this.mApkDownloadHelper = kVar.mApkDownloadHelper;
        new com.kwad.sdk.widget.f(this.mDetailVideoView, this);
        this.mDetailVideoView.setBackgroundColor(Color.parseColor(com.kwad.sdk.core.response.a.a.ay(d.bQ(this.mAdTemplate)) ? "#B3000000" : "#4D000000"));
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        b(view2, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        if (com.kwad.sdk.core.response.a.c.bF(this.mAdTemplate)) {
            b(view2, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f091361);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mDetailVideoView.setClickListener(null);
    }
}
