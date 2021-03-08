package com.kwad.sdk.reward.widget.tailframe.h5bar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class TailFrameBarH5Landscape extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f7069a;
    private TextView b;
    private ValueAnimator c;

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
        inflate(context, R.layout.ksad_video_tf_bar_h5_landscape, this);
        this.f7069a = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.b = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    private void b() {
        if (this.c != null) {
            a();
            this.c.start();
        }
        this.c = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.c.setDuration(1200L);
        this.c.setRepeatCount(-1);
        this.c.setRepeatMode(1);
        this.c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5Landscape.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5Landscape.this.b.setScaleY(floatValue);
                TailFrameBarH5Landscape.this.b.setScaleX(floatValue);
            }
        });
        this.c.start();
    }

    public void a() {
        if (this.c == null || !this.c.isRunning()) {
            return;
        }
        this.c.cancel();
        this.c.end();
    }

    public void setModel(@NonNull AdTemplate adTemplate) {
        AdInfo j = c.j(adTemplate);
        this.f7069a.setText(a.n(j));
        this.b.setText(a.w(j));
        b();
    }
}
