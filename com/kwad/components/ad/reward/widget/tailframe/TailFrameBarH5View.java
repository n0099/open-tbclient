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
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
/* loaded from: classes10.dex */
public class TailFrameBarH5View extends LinearLayout {
    public TextView dL;
    public TextView dM;
    public ValueAnimator jo;

    public TailFrameBarH5View(Context context) {
        this(context, null, 0);
    }

    public final void b(@NonNull AdTemplate adTemplate) {
        AdInfo dP = e.dP(adTemplate);
        this.dL.setText(com.kwad.sdk.core.response.b.a.au(dP));
        this.dM.setText(com.kwad.sdk.core.response.b.a.aE(dP));
        kj();
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void f(Context context, int i) {
        l.inflate(context, i, this);
        this.dL = (TextView) findViewById(R.id.obfuscated_res_0x7f0914d7);
        this.dM = (TextView) findViewById(R.id.obfuscated_res_0x7f0914d8);
    }

    public final void g(boolean z, boolean z2) {
        int i;
        if (z) {
            if (z2) {
                i = R.layout.obfuscated_res_0x7f0d052c;
            } else {
                i = R.layout.obfuscated_res_0x7f0d052b;
            }
        } else {
            i = R.layout.obfuscated_res_0x7f0d052a;
        }
        f(getContext(), i);
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void kj() {
        if (this.jo != null) {
            kk();
            this.jo.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.jo = ofFloat;
        ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.jo.setRepeatCount(-1);
        this.jo.setRepeatMode(1);
        this.jo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5View.this.dM.setScaleY(floatValue);
                TailFrameBarH5View.this.dM.setScaleX(floatValue);
            }
        });
        this.jo.start();
    }

    public TextView getH5OpenBtn() {
        return this.dM;
    }

    public final void kk() {
        ValueAnimator valueAnimator = this.jo;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.jo.cancel();
            this.jo.end();
        }
    }
}
