package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.m.n;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes10.dex */
public class KsShakeView extends KSFrameLayout {
    public Animator AA;
    public boolean AB;
    public int Ar;
    public float As;
    @ColorInt
    public int At;
    @ColorInt
    public int Au;
    @ColorInt
    public int Av;
    public float Aw;
    public float Ax;
    @DrawableRes
    public int Ay;
    @Nullable
    public Animator Az;
    public Paint mPaint;
    public ImageView nC;

    public KsShakeView(@NonNull Context context) {
        this(context, null, 0);
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.AB = false;
        a(context, attributeSet, i);
    }

    private Animator a(View view2, long j, float f) {
        Interpolator create;
        float height;
        if (view2 == null) {
            return null;
        }
        if (this.Ar == 1) {
            create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
            view2.setPivotX(view2.getWidth());
            height = view2.getHeight();
        } else {
            create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
            view2.setPivotX(view2.getWidth() / 2.0f);
            height = view2.getHeight() / 2.0f;
        }
        view2.setPivotY(height);
        return n.a(view2, create, 100L, 16.0f);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i, 0);
        this.As = obtainStyledAttributes.getDimension(4, 1.0f);
        this.At = obtainStyledAttributes.getColor(3, Color.parseColor("#4DFFFFFF"));
        this.Au = obtainStyledAttributes.getColor(7, Color.parseColor("#66000000"));
        this.Ar = obtainStyledAttributes.getInteger(6, 1);
        this.Av = obtainStyledAttributes.getColor(1, Color.parseColor("#B3FFFFFF"));
        this.Aw = obtainStyledAttributes.getDimension(2, 1.0f);
        this.Ay = obtainStyledAttributes.getResourceId(5, com.baidu.tieba.R.drawable.obfuscated_res_0x7f080e33);
        this.Ax = obtainStyledAttributes.getDimension(0, com.kwad.sdk.b.kwai.a.a(context, 10.0f));
        obtainStyledAttributes.recycle();
        this.nC = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.nC, layoutParams);
        kp();
    }

    public static Animator b(View view2, long j, float f) {
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, f).setDuration(100L);
        duration.setInterpolator(create);
        float f2 = -f;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, f2).setDuration(200L);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, f).setDuration(200L);
        duration3.setInterpolator(create);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, f2).setDuration(200L);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, f).setDuration(100L), ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 1.0f).setDuration(100L));
        return animatorSet;
    }

    private void kp() {
        this.nC.setImageResource(this.Ay);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.Au);
        paint.setAntiAlias(true);
    }

    private void setInnerCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Aw);
        paint.setColor(this.Av);
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.As);
        paint.setColor(this.At);
        paint.setAntiAlias(true);
    }

    public final void Z(int i) {
        this.Ar = i;
        setIconDrawableRes(i != 2 ? com.baidu.tieba.R.drawable.obfuscated_res_0x7f080e33 : com.baidu.tieba.R.drawable.obfuscated_res_0x7f080e34);
    }

    public final void a(AnimatorListenerAdapter animatorListenerAdapter) {
        this.AB = true;
        Animator animator = this.Az;
        if (animator != null) {
            animator.cancel();
        }
        this.nC.setRotation(0.0f);
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.R.dimen.obfuscated_res_0x7f070558);
        Animator animator2 = this.AA;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator b = b(this, 100L, dimensionPixelSize);
        this.AA = b;
        b.addListener(animatorListenerAdapter);
        this.AA.start();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void an() {
        super.an();
        Animator animator = this.Az;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void bt() {
        Animator animator = this.Az;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.AA;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.Az = null;
        this.AA = null;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float min = Math.min(getWidth(), getHeight()) / 2.0f;
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.mPaint);
        if (this.Ar == 2) {
            setInnerCirclePaint(this.mPaint);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min - this.Ax, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    @MainThread
    public final void kG() {
        this.AB = false;
        Animator animator = this.Az;
        if (animator != null) {
            animator.cancel();
            this.Az = null;
        }
        Animator a = a(this.nC, 100L, 16.0f);
        this.Az = a;
        if (a != null) {
            a.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.KsShakeView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    KsShakeView.this.nC.setRotation(0.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (KsShakeView.this.AB || KsShakeView.this.Az == null) {
                        return;
                    }
                    KsShakeView.this.Az.start();
                }
            });
            this.Az.start();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @MainThread
    public void setIconDrawableRes(@DrawableRes int i) {
        ImageView imageView = this.nC;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }
}
