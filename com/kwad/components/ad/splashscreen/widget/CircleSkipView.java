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
    public ValueAnimator FA;
    public boolean FB;
    public SkipView.a FC;
    public long FD;
    public float FE;
    public float Fx;
    public float Fy;
    public int Fz;
    public Paint mPaint;
    public RectF mRectF;
    public int padding;
    public int radius;
    public boolean sA;

    public CircleSkipView(@NonNull Context context) {
        this(context, null, 0);
    }

    private void S(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        T(context);
        addView(U(context), layoutParams);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (CircleSkipView.this.FC != null) {
                    CircleSkipView.this.FC.kT();
                }
            }
        });
    }

    private void T(Context context) {
        this.Fz = com.kwad.sdk.d.a.a.a(context, 2.0f);
        int a = com.kwad.sdk.d.a.a.a(context, 32.0f);
        int i = this.Fz;
        this.radius = a - i;
        this.padding = i / 2;
        int i2 = this.padding;
        int i3 = this.radius;
        this.mRectF = new RectF(i2, i2, i3 + i2, i3 + i2);
    }

    public static TextView U(Context context) {
        TextView textView = new TextView(context);
        textView.setText(context.getString(R.string.obfuscated_res_0x7f0f0ba7));
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i) {
        SkipView.a aVar = this.FC;
        if (aVar != null) {
            aVar.Y(i);
        }
    }

    private void setAnimationPaint(Paint paint) {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Fz);
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
        paint.setStrokeWidth(this.Fz);
        paint.setColor(Color.parseColor("#33FFFFFF"));
        paint.setAntiAlias(true);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void A(AdInfo adInfo) {
        lJ();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void B(AdInfo adInfo) {
        lI();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final int aa(int i) {
        getLayoutParams().height = com.kwad.sdk.d.a.a.a(getContext(), 35.0f);
        return getWidth();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public void setOnViewListener(SkipView.a aVar) {
        this.FC = aVar;
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.Fx = 270.0f;
        this.Fy = 360.0f;
        this.radius = 0;
        this.Fz = 0;
        this.FB = false;
        this.FD = 0L;
        this.FE = 0.0f;
        this.padding = 0;
        this.sA = true;
        S(context);
    }

    public static /* synthetic */ boolean a(CircleSkipView circleSkipView, boolean z) {
        circleSkipView.FB = true;
        return true;
    }

    private void c(final int i, final boolean z) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.FA = ofFloat;
        ofFloat.setDuration(i);
        this.FA.setInterpolator(new LinearInterpolator());
        this.FA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (CircleSkipView.this.FE == 1.0f && CircleSkipView.this.FC != null) {
                    CircleSkipView.this.FC.kU();
                }
            }
        });
        this.FA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircleSkipView.this.FE = floatValue;
                CircleSkipView circleSkipView = CircleSkipView.this;
                circleSkipView.X((int) ((i / 1000) * circleSkipView.FE));
                if (z) {
                    CircleSkipView.a(CircleSkipView.this, true);
                    float f = floatValue * 360.0f;
                    CircleSkipView.this.Fx = 270.0f - f;
                    CircleSkipView.this.Fy = 360.0f - f;
                    CircleSkipView.this.invalidate();
                }
            }
        });
    }

    private void lI() {
        this.FB = true;
        ValueAnimator valueAnimator = this.FA;
        if (valueAnimator != null) {
            valueAnimator.setCurrentPlayTime(this.FD);
            this.FA.start();
        }
    }

    private void lJ() {
        this.FB = false;
        ValueAnimator valueAnimator = this.FA;
        if (valueAnimator != null) {
            this.FD = valueAnimator.getCurrentPlayTime();
            this.FA.cancel();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void bf() {
        lJ();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.sA = com.kwad.sdk.core.response.b.a.cv(adInfo);
        boolean cw = com.kwad.sdk.core.response.b.a.cw(adInfo);
        if (this.sA) {
            setVisibility(0);
        }
        c(splashSkipViewModel.skipSecond * 1000, cw);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (Math.min(getWidth(), getHeight()) / 2.0f) - this.Fz, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawArc(this.mRectF, 0.0f, 360.0f, false, this.mPaint);
        if (this.FB) {
            setAnimationPaint(this.mPaint);
            canvas.drawArc(this.mRectF, this.Fx, -this.Fy, false, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }
}
