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
/* loaded from: classes8.dex */
public class TailFrameBarH5PortraitVertical extends LinearLayout {
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f56313b;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f56314c;

    public TailFrameBarH5PortraitVertical(Context context) {
        this(context, null);
    }

    public TailFrameBarH5PortraitVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5PortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        LinearLayout.inflate(context, R.layout.ksad_video_tf_bar_h5_portrait_vertical, this);
        this.a = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.f56313b = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    private void b() {
        if (this.f56314c != null) {
            a();
            this.f56314c.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.f56314c = ofFloat;
        ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.f56314c.setRepeatCount(-1);
        this.f56314c.setRepeatMode(1);
        this.f56314c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5PortraitVertical.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5PortraitVertical.this.f56313b.setScaleY(floatValue);
                TailFrameBarH5PortraitVertical.this.f56313b.setScaleX(floatValue);
            }
        });
        this.f56314c.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.f56314c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f56314c.cancel();
        this.f56314c.end();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        AdInfo j2 = d.j(adTemplate);
        this.a.setText(a.s(j2));
        this.f56313b.setText(a.A(j2));
        b();
    }
}
