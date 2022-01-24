package com.kwad.sdk.reward.widget.tailframe.h5bar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class TailFrameBarH5Landscape extends LinearLayout {
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f57792b;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f57793c;

    public TailFrameBarH5Landscape(Context context) {
        this(context, null);
    }

    public TailFrameBarH5Landscape(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5Landscape(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        LinearLayout.inflate(context, R.layout.ksad_video_tf_bar_h5_landscape, this);
        this.a = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.f57792b = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    private void b() {
        if (this.f57793c != null) {
            a();
            this.f57793c.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.f57793c = ofFloat;
        ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.f57793c.setRepeatCount(-1);
        this.f57793c.setRepeatMode(1);
        this.f57793c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5Landscape.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5Landscape.this.f57792b.setScaleY(floatValue);
                TailFrameBarH5Landscape.this.f57792b.setScaleX(floatValue);
            }
        });
        this.f57793c.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.f57793c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f57793c.cancel();
        this.f57793c.end();
    }

    public void setModel(@NonNull AdTemplate adTemplate) {
        AdInfo j2 = d.j(adTemplate);
        this.a.setText(a.s(j2));
        this.f57792b.setText(a.A(j2));
        b();
    }
}
