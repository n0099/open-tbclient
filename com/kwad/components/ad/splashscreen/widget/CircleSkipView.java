package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes10.dex */
public class CircleSkipView extends KSFrameLayout implements a {
    public boolean Aa;
    public SkipView.a Ab;
    public long Ac;
    public float Ad;
    public Paint mPaint;
    public boolean pX;
    public int padding;
    public int radius;
    public RectF zV;
    public float zW;
    public float zX;
    public int zY;
    public ValueAnimator zZ;

    public CircleSkipView(@NonNull Context context) {
        this(context, null, 0);
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.zW = 270.0f;
        this.zX = 360.0f;
        this.radius = 0;
        this.zY = 0;
        this.Aa = false;
        this.Ac = 0L;
        this.Ad = 0.0f;
        this.padding = 0;
        this.pX = true;
        ab(context);
    }

    public static /* synthetic */ boolean a(CircleSkipView circleSkipView, boolean z) {
        circleSkipView.Aa = true;
        return true;
    }

    private void ab(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        ac(context);
        addView(ad(context), layoutParams);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (CircleSkipView.this.Ab != null) {
                    CircleSkipView.this.Ab.kb();
                }
            }
        });
    }

    private void ac(Context context) {
        this.zY = com.kwad.sdk.b.kwai.a.a(context, 2.0f);
        int a = com.kwad.sdk.b.kwai.a.a(context, 32.0f);
        int i = this.zY;
        this.radius = a - i;
        this.padding = i / 2;
        int i2 = this.padding;
        int i3 = this.radius;
        this.zV = new RectF(i2, i2, i3 + i2, i3 + i2);
    }

    public static TextView ad(Context context) {
        TextView textView = new TextView(context);
        textView.setText(context.getString(R.string.obfuscated_res_0x7f0f0b5d));
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        return textView;
    }

    private void d(int i, final boolean z) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.zZ = ofFloat;
        ofFloat.setDuration(i);
        this.zZ.setInterpolator(new LinearInterpolator());
        this.zZ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (CircleSkipView.this.Ad != 1.0f || CircleSkipView.this.Ab == null) {
                    return;
                }
                CircleSkipView.this.Ab.kc();
            }
        });
        this.zZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircleSkipView.this.Ad = floatValue;
                if (z) {
                    CircleSkipView.a(CircleSkipView.this, true);
                    float f = floatValue * 360.0f;
                    CircleSkipView.this.zW = 270.0f - f;
                    CircleSkipView.this.zX = 360.0f - f;
                    CircleSkipView.this.invalidate();
                }
            }
        });
    }

    private void kB() {
        this.Aa = true;
        ValueAnimator valueAnimator = this.zZ;
        if (valueAnimator != null) {
            valueAnimator.setCurrentPlayTime(this.Ac);
            this.zZ.start();
        }
    }

    private void kC() {
        this.Aa = false;
        ValueAnimator valueAnimator = this.zZ;
        if (valueAnimator != null) {
            this.Ac = valueAnimator.getCurrentPlayTime();
            this.zZ.cancel();
        }
    }

    private void setAnimationPaint(Paint paint) {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.zY);
        paint.setColor(-1);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#4D000000"));
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.zY);
        paint.setColor(Color.parseColor("#33FFFFFF"));
        paint.setAntiAlias(true);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final int Y(int i) {
        getLayoutParams().height = com.kwad.sdk.b.kwai.a.a(getContext(), 35.0f);
        return getWidth();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.pX = com.kwad.sdk.core.response.a.a.bz(adInfo);
        boolean bA = com.kwad.sdk.core.response.a.a.bA(adInfo);
        if (this.pX) {
            setVisibility(0);
        }
        d(splashSkipViewModel.skipSecond * 1000, bA);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void bj() {
        kC();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (Math.min(getWidth(), getHeight()) / 2.0f) - this.zY, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawArc(this.zV, 0.0f, 360.0f, false, this.mPaint);
        if (this.Aa) {
            setAnimationPaint(this.mPaint);
            canvas.drawArc(this.zV, this.zW, -this.zX, false, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void s(AdInfo adInfo) {
        kC();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public void setOnViewListener(SkipView.a aVar) {
        this.Ab = aVar;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void t(AdInfo adInfo) {
        kB();
    }
}
