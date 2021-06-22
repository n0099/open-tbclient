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
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class TailFrameBarH5Landscape extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f37427a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f37428b;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f37429c;

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
        this.f37427a = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.f37428b = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    private void b() {
        if (this.f37429c != null) {
            a();
            this.f37429c.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.f37429c = ofFloat;
        ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.f37429c.setRepeatCount(-1);
        this.f37429c.setRepeatMode(1);
        this.f37429c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5Landscape.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5Landscape.this.f37428b.setScaleY(floatValue);
                TailFrameBarH5Landscape.this.f37428b.setScaleX(floatValue);
            }
        });
        this.f37429c.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.f37429c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f37429c.cancel();
        this.f37429c.end();
    }

    public void setModel(@NonNull AdTemplate adTemplate) {
        AdInfo j = c.j(adTemplate);
        this.f37427a.setText(a.n(j));
        this.f37428b.setText(a.w(j));
        b();
    }
}
