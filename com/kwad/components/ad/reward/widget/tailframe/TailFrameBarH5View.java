package com.kwad.components.ad.reward.widget.tailframe;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public class TailFrameBarH5View extends LinearLayout {
    public TextView cD;
    public TextView cE;
    public ValueAnimator ju;

    public TailFrameBarH5View(Context context) {
        this(context, null, 0);
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void c(Context context, int i) {
        LinearLayout.inflate(context, i, this);
        this.cD = (TextView) findViewById(R.id.obfuscated_res_0x7f0913d8);
        this.cE = (TextView) findViewById(R.id.obfuscated_res_0x7f0913d9);
    }

    private void jk() {
        if (this.ju != null) {
            jl();
            this.ju.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.ju = ofFloat;
        ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.ju.setRepeatCount(-1);
        this.ju.setRepeatMode(1);
        this.ju.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5View.this.cE.setScaleY(floatValue);
                TailFrameBarH5View.this.cE.setScaleX(floatValue);
            }
        });
        this.ju.start();
    }

    public final void c(@NonNull AdTemplate adTemplate) {
        AdInfo bQ = d.bQ(adTemplate);
        this.cD.setText(com.kwad.sdk.core.response.a.a.ad(bQ));
        this.cE.setText(com.kwad.sdk.core.response.a.a.al(bQ));
        jk();
    }

    public final void e(boolean z, boolean z2) {
        c(getContext(), z ? z2 ? R.layout.obfuscated_res_0x7f0d04e7 : R.layout.obfuscated_res_0x7f0d04e6 : R.layout.obfuscated_res_0x7f0d04e5);
    }

    public TextView getH5OpenBtn() {
        return this.cE;
    }

    public final void jl() {
        ValueAnimator valueAnimator = this.ju;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.ju.cancel();
        this.ju.end();
    }
}
