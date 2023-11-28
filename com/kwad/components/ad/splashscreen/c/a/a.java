package com.kwad.components.ad.splashscreen.c.a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.splashscreen.c.e {
    public AnimatorSet Eq;
    public TextView Er;
    public ViewGroup Es;
    public ViewGroup Et;

    private void initView() {
        this.Er = (TextView) findViewById(R.id.obfuscated_res_0x7f0912e1);
        this.Es = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0914be);
        this.Et = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0914bc);
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        lt();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        AnimatorSet animatorSet = this.Eq;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    private void lt() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.Et, Key.ALPHA, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.Er, Key.ALPHA, 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.Es, Key.SCALE_X, 0.8f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.Es, Key.SCALE_Y, 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.Eq = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        this.Eq.setDuration(300L);
        this.Eq.start();
    }
}
