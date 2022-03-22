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
/* loaded from: classes7.dex */
public class TailFrameBarH5PortraitHorizontal extends LinearLayout {
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f41221b;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f41222c;

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
        LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0482, this);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091150);
        this.f41221b = (TextView) findViewById(R.id.obfuscated_res_0x7f091151);
    }

    private void b() {
        if (this.f41222c != null) {
            a();
            this.f41222c.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.f41222c = ofFloat;
        ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.f41222c.setRepeatCount(-1);
        this.f41222c.setRepeatMode(1);
        this.f41222c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5PortraitHorizontal.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5PortraitHorizontal.this.f41221b.setScaleY(floatValue);
                TailFrameBarH5PortraitHorizontal.this.f41221b.setScaleX(floatValue);
            }
        });
        this.f41222c.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.f41222c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f41222c.cancel();
        this.f41222c.end();
    }

    public void setModel(@NonNull AdTemplate adTemplate) {
        AdInfo j = d.j(adTemplate);
        this.a.setText(a.s(j));
        this.f41221b.setText(a.A(j));
        b();
    }
}
