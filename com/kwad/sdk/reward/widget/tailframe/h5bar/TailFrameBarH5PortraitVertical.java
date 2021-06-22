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
public class TailFrameBarH5PortraitVertical extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f37435a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f37436b;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f37437c;

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
        this.f37435a = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.f37436b = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    private void b() {
        if (this.f37437c != null) {
            a();
            this.f37437c.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.f37437c = ofFloat;
        ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.f37437c.setRepeatCount(-1);
        this.f37437c.setRepeatMode(1);
        this.f37437c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5PortraitVertical.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5PortraitVertical.this.f37436b.setScaleY(floatValue);
                TailFrameBarH5PortraitVertical.this.f37436b.setScaleX(floatValue);
            }
        });
        this.f37437c.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.f37437c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f37437c.cancel();
        this.f37437c.end();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        AdInfo j = c.j(adTemplate);
        this.f37435a.setText(a.n(j));
        this.f37436b.setText(a.w(j));
        b();
    }
}
