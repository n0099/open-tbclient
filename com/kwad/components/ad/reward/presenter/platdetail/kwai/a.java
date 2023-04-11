package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.core.webview.b.d.b {
    public static final String[] rZ = {"%ss后获得奖励1", "已获得奖励1/2", "已获得全部奖励"};
    public TextView ey;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public TextView rV;
    public ImageView rW;
    public View rX;
    public boolean rY = false;
    public boolean sa = false;
    public final g mVideoPlayStateListener = new h() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            long a = k.a(j, a.this.mAdInfo);
            if (j2 < a - 800) {
                a.this.x((int) ((((float) (a - j2)) / 1000.0f) + 0.5f));
                return;
            }
            a.this.nM.mD = true;
            if (!k.q(a.this.mAdTemplate)) {
                a.this.notifyRewardVerify();
                a.this.hB();
                return;
            }
            if (!k.o(a.this.mAdTemplate) || a.this.nM.mK == null) {
                if (k.p(a.this.mAdTemplate) && a.this.nM.mL != null && !a.this.nM.mL.iC()) {
                    a.this.nM.mL.iB();
                }
            } else if (!a.this.nM.mK.iC()) {
                a.this.nM.mK.iB();
            }
            if (a.this.sa) {
                return;
            }
            a.this.rV.setText(a.rZ[1]);
            a.this.hC();
        }
    };
    public final com.kwad.components.ad.reward.d.h mRewardVerifyListener = new com.kwad.components.ad.reward.d.h() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.2
        @Override // com.kwad.components.ad.reward.d.h
        public final void onRewardVerify() {
            a.a(a.this, true);
            a.this.rV.setText(a.rZ[2]);
        }
    };

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.sa = true;
        return true;
    }

    private void bQ() {
        AdTemplate adTemplate = this.nM.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.mAdInfo = bQ;
        this.mApkDownloadHelper = this.nM.mApkDownloadHelper;
        long a = k.a(com.kwad.sdk.core.response.a.a.C(bQ), this.mAdInfo) / 1000;
        if (k.q(this.mAdTemplate)) {
            this.rX.setVisibility(0);
            this.rX.setOnClickListener(this);
            this.rV.setText(String.format(rZ[0], Long.valueOf(a)));
            this.ey.setVisibility(8);
        } else {
            this.rX.setVisibility(8);
            this.ey.setText(String.valueOf(a));
            this.ey.setVisibility(0);
            this.ey.setAlpha(1.0f);
        }
        com.kwad.components.ad.reward.c.eZ().a(this.mRewardVerifyListener);
        this.nM.eF.a(this.mVideoPlayStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hB() {
        if (this.rY) {
            return;
        }
        this.rY = true;
        this.rW.setAlpha(0.0f);
        this.rW.setVisibility(0);
        this.rW.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                a.this.ey.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.ey.setAlpha(1.0f - floatValue);
                a.this.rW.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hC() {
        com.kwad.components.ad.reward.d.c cVar = this.nM.mAdRewardStepListener;
        if (cVar != null) {
            cVar.ff();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, 41, this.nM.mRootContainer.getTouchCoords(), this.nM.mReportExtData);
        this.nM.mAdOpenInteractionListener.bB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        this.nM.mAdOpenInteractionListener.onRewardVerify();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i) {
        this.nM.mM = i;
        if (!k.q(this.mAdTemplate)) {
            this.ey.setText(String.valueOf(i));
        } else if (this.sa) {
        } else {
            this.rV.setText(String.format(rZ[0], Integer.valueOf(i)));
        }
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

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.rW || view2 == this.rX) {
            com.kwad.components.core.c.a.a.a(new a.C0594a(view2.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).ae(2).l(this.nM.eF.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.5
                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ey = (TextView) findViewById(R.id.obfuscated_res_0x7f09138a);
        this.rW = (ImageView) findViewById(R.id.obfuscated_res_0x7f091205);
        this.rV = (TextView) findViewById(R.id.obfuscated_res_0x7f0912d2);
        this.rX = findViewById(R.id.obfuscated_res_0x7f091203);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.c.eZ().b(this.mRewardVerifyListener);
        this.nM.eF.b(this.mVideoPlayStateListener);
        com.kwad.components.core.webview.b.c.a.pR().b(this);
        this.rW.setVisibility(8);
        this.rX.setVisibility(8);
        this.rY = false;
        this.sa = false;
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        if ("ksad-video-top-bar".equals(str)) {
            bQ();
        }
    }
}
