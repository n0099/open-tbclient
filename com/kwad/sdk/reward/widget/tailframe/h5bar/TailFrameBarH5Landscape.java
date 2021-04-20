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
public class TailFrameBarH5Landscape extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f36867a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f36868b;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f36869c;

    public TailFrameBarH5Landscape(Context context) {
        this(context, null);
    }

    public TailFrameBarH5Landscape(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5Landscape(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        LinearLayout.inflate(context, R.layout.ksad_video_tf_bar_h5_landscape, this);
        this.f36867a = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.f36868b = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    private void b() {
        if (this.f36869c != null) {
            a();
            this.f36869c.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.f36869c = ofFloat;
        ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.f36869c.setRepeatCount(-1);
        this.f36869c.setRepeatMode(1);
        this.f36869c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5Landscape.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5Landscape.this.f36868b.setScaleY(floatValue);
                TailFrameBarH5Landscape.this.f36868b.setScaleX(floatValue);
            }
        });
        this.f36869c.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.f36869c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f36869c.cancel();
        this.f36869c.end();
    }

    public void setModel(@NonNull AdTemplate adTemplate) {
        AdInfo j = c.j(adTemplate);
        this.f36867a.setText(a.n(j));
        this.f36868b.setText(a.w(j));
        b();
    }
}
