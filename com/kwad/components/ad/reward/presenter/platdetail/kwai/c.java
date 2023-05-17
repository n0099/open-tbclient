package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.core.webview.b.d.b {
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public ImageView sd;
    public TextView se;
    public boolean sf = false;
    public View kP = null;
    public long sg = -1;
    public final g mVideoPlayStateListener = new h() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.c.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            if (c.this.sg >= 0) {
                if (j2 > Math.min(Math.min(c.this.sg, com.kwad.sdk.core.response.a.a.T(c.this.mAdInfo)), j)) {
                    c.this.hE();
                }
            }
        }
    };
    public final com.kwad.components.ad.reward.d.d eL = new com.kwad.components.ad.reward.d.d() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.c.2
        @Override // com.kwad.components.ad.reward.d.d
        public final void bV() {
            c.a(c.this, true);
            c.this.hE();
        }
    };

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.sf = true;
        return true;
    }

    private void bQ() {
        AdTemplate adTemplate = this.nM.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.nM.eF.a(this.mVideoPlayStateListener);
        this.nM.mr.add(this.eL);
        this.sg = com.kwad.sdk.core.response.a.a.S(this.mAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hE() {
        if (this.kP.getVisibility() == 0) {
            return;
        }
        this.kP.setAlpha(0.0f);
        this.kP.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.kP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.kP.setOnClickListener(this);
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
        if (view2 == this.kP) {
            k kVar = this.nM;
            com.kwad.components.ad.reward.presenter.e.a(kVar, this.sf, kVar.fB());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        ImageView imageView;
        int i;
        View view2;
        super.onCreate();
        this.sd = (ImageView) findViewById(R.id.obfuscated_res_0x7f09124b);
        this.se = (TextView) findViewById(R.id.obfuscated_res_0x7f0913c2);
        if (TextUtils.isEmpty(com.kwad.components.ad.reward.kwai.b.fW())) {
            if (com.kwad.components.ad.reward.kwai.b.fV() == 0) {
                imageView = this.sd;
                i = R.drawable.obfuscated_res_0x7f080e1c;
            } else {
                imageView = this.sd;
                i = R.drawable.obfuscated_res_0x7f080e78;
            }
            imageView.setImageResource(i);
            this.se.setVisibility(8);
            view2 = this.sd;
        } else {
            this.se.setText(com.kwad.components.ad.reward.kwai.b.fW());
            this.sd.setVisibility(8);
            view2 = this.se;
        }
        this.kP = view2;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.b.c.a.pR().b(this);
        this.nM.eF.b(this.mVideoPlayStateListener);
        this.nM.mr.remove(this.eL);
        this.kP.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        if ("ksad-video-top-bar".equals(str)) {
            bQ();
        }
    }
}
