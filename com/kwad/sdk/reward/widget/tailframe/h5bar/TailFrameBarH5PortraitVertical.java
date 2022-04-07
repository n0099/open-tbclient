package com.kwad.sdk.reward.widget.tailframe.h5bar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class TailFrameBarH5PortraitVertical extends LinearLayout {
    public TextView a;
    public TextView b;
    public ValueAnimator c;

    public TailFrameBarH5PortraitVertical(Context context) {
        this(context, null);
    }

    public TailFrameBarH5PortraitVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5PortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d047e, this);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091149);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f09114a);
    }

    private void b() {
        if (this.c != null) {
            a();
            this.c.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.c = ofFloat;
        ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.c.setRepeatCount(-1);
        this.c.setRepeatMode(1);
        this.c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5PortraitVertical.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5PortraitVertical.this.b.setScaleY(floatValue);
                TailFrameBarH5PortraitVertical.this.b.setScaleX(floatValue);
            }
        });
        this.c.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.c.cancel();
        this.c.end();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        AdInfo j = d.j(adTemplate);
        this.a.setText(a.s(j));
        this.b.setText(a.A(j));
        b();
    }
}
