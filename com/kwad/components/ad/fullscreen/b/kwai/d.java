package com.kwad.components.ad.fullscreen.b.kwai;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.core.webview.b.d.b {
    public ImageView eI;
    public TextView eJ;
    public AdTemplate mAdTemplate;
    public View eK = null;
    public com.kwad.components.ad.reward.d.d eL = new com.kwad.components.ad.reward.d.d() { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.1
        @Override // com.kwad.components.ad.reward.d.d
        public final void bV() {
            d.this.bU();
        }
    };
    public g mVideoPlayStateListener = new h() { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.2
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            if (j2 >= com.kwad.sdk.core.response.a.a.W(com.kwad.sdk.core.response.a.d.bQ(d.this.mAdTemplate))) {
                d.this.bU();
            }
        }
    };

    private void bQ() {
        k kVar = this.nM;
        this.mAdTemplate = kVar.mAdTemplate;
        kVar.eF.a(this.mVideoPlayStateListener);
        this.nM.mr.add(this.eL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU() {
        if (this.eK.getVisibility() == 0) {
            return;
        }
        this.eK.setAlpha(0.0f);
        this.eK.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.b.kwai.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.eK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
        this.eK.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        if (k.b(this.nM)) {
            com.kwad.components.core.webview.b.c.a.pR().a(this);
        } else {
            bQ();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.eK) {
            k kVar = this.nM;
            com.kwad.components.ad.reward.presenter.e.a(kVar, false, kVar.fB());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        ImageView imageView;
        int i;
        View view2;
        super.onCreate();
        this.eI = (ImageView) findViewById(R.id.obfuscated_res_0x7f09139c);
        this.eJ = (TextView) findViewById(R.id.obfuscated_res_0x7f0913c2);
        if (TextUtils.isEmpty(com.kwad.components.ad.fullscreen.kwai.b.bD())) {
            if (com.kwad.components.ad.fullscreen.kwai.b.bC() == 0) {
                imageView = this.eI;
                i = R.drawable.obfuscated_res_0x7f080e1c;
            } else {
                imageView = this.eI;
                i = R.drawable.obfuscated_res_0x7f080e78;
            }
            imageView.setImageResource(i);
            this.eJ.setVisibility(8);
            view2 = this.eI;
        } else {
            this.eJ.setText(com.kwad.components.ad.fullscreen.kwai.b.bD());
            this.eI.setVisibility(8);
            view2 = this.eJ;
        }
        this.eK = view2;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.b.c.a.pR().b(this);
        this.nM.eF.b(this.mVideoPlayStateListener);
        this.nM.mr.remove(this.eL);
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        if ("ksad-video-top-bar".equals(str)) {
            bQ();
        }
    }
}
