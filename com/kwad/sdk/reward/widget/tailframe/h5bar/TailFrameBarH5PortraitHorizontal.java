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
/* loaded from: classes6.dex */
public class TailFrameBarH5PortraitHorizontal extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f36871a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f36872b;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f36873c;

    public TailFrameBarH5PortraitHorizontal(Context context) {
        this(context, null);
    }

    public TailFrameBarH5PortraitHorizontal(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5PortraitHorizontal(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        LinearLayout.inflate(context, R.layout.ksad_video_tf_bar_h5_portrait_horizontal, this);
        this.f36871a = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.f36872b = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    private void b() {
        if (this.f36873c != null) {
            a();
            this.f36873c.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.f36873c = ofFloat;
        ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.f36873c.setRepeatCount(-1);
        this.f36873c.setRepeatMode(1);
        this.f36873c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5PortraitHorizontal.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5PortraitHorizontal.this.f36872b.setScaleY(floatValue);
                TailFrameBarH5PortraitHorizontal.this.f36872b.setScaleX(floatValue);
            }
        });
        this.f36873c.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.f36873c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f36873c.cancel();
        this.f36873c.end();
    }

    public void setModel(@NonNull AdTemplate adTemplate) {
        AdInfo j = c.j(adTemplate);
        this.f36871a.setText(a.n(j));
        this.f36872b.setText(a.w(j));
        b();
    }
}
