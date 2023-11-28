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
import com.baidu.tieba.R;
import com.kwad.components.core.s.n;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes10.dex */
public class KsShakeView extends KSFrameLayout {
    public int Ga;
    public float Gb;
    @ColorInt
    public int Gc;
    @ColorInt
    public int Gd;
    @ColorInt
    public int Ge;
    public float Gf;
    public float Gg;
    @DrawableRes
    public int Gh;
    public Animator Gi;
    public boolean Gj;
    public ImageView fq;
    @Nullable
    public Animator fr;
    public Paint mPaint;

    public KsShakeView(@NonNull Context context) {
        this(context, null, 0);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.Gd);
        paint.setAntiAlias(true);
    }

    private void setInnerCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Gf);
        paint.setColor(this.Ge);
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Gb);
        paint.setColor(this.Gc);
        paint.setAntiAlias(true);
    }

    public final void ac(int i) {
        this.Ga = i;
        if (i != 2) {
            setIconDrawableRes(R.drawable.obfuscated_res_0x7f080e83);
        } else {
            setIconDrawableRes(R.drawable.obfuscated_res_0x7f080e84);
        }
    }

    @MainThread
    public void setIconDrawableRes(@DrawableRes int i) {
        ImageView imageView = this.fq;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.Gj = false;
        a(context, attributeSet, i);
    }

    private Animator a(View view2, long j, float f) {
        Interpolator create;
        if (view2 == null) {
            return null;
        }
        if (this.Ga == 1) {
            create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
            view2.setPivotX(view2.getWidth());
            view2.setPivotY(view2.getHeight());
        } else {
            create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
            view2.setPivotX(view2.getWidth() / 2.0f);
            view2.setPivotY(view2.getHeight() / 2.0f);
        }
        return n.a(view2, create, 100L, 16.0f);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.kwad.sdk.R.styleable.ksad_KsShakeView, i, 0);
        this.Gb = obtainStyledAttributes.getDimension(4, 1.0f);
        this.Gc = obtainStyledAttributes.getColor(3, Color.parseColor("#4DFFFFFF"));
        this.Gd = obtainStyledAttributes.getColor(7, Color.parseColor("#66000000"));
        this.Ga = obtainStyledAttributes.getInteger(6, 1);
        this.Ge = obtainStyledAttributes.getColor(1, Color.parseColor("#B3FFFFFF"));
        this.Gf = obtainStyledAttributes.getDimension(2, 1.0f);
        this.Gh = obtainStyledAttributes.getResourceId(5, R.drawable.obfuscated_res_0x7f080e83);
        this.Gg = obtainStyledAttributes.getDimension(0, com.kwad.sdk.d.a.a.a(context, 10.0f));
        obtainStyledAttributes.recycle();
        this.fq = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.fq, layoutParams);
        lK();
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

    private void lK() {
        this.fq.setImageResource(this.Gh);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        Animator animator = this.fr;
        if (animator != null) {
            animator.cancel();
        }
    }

    @MainThread
    public final void lO() {
        this.Gj = false;
        Animator animator = this.fr;
        if (animator != null) {
            animator.cancel();
            this.fr = null;
        }
        Animator a = a(this.fq, 100L, 16.0f);
        this.fr = a;
        if (a != null) {
            a.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.KsShakeView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    KsShakeView.this.fq.setRotation(0.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (!KsShakeView.this.Gj && KsShakeView.this.fr != null) {
                        KsShakeView.this.fr.start();
                    }
                }
            });
            this.fr.start();
        }
    }

    public final void lP() {
        Animator animator = this.fr;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.Gi;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.fr = null;
        this.Gi = null;
    }

    public final void b(AnimatorListenerAdapter animatorListenerAdapter) {
        this.Gj = true;
        Animator animator = this.fr;
        if (animator != null) {
            animator.cancel();
        }
        this.fq.setRotation(0.0f);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07056b);
        Animator animator2 = this.Gi;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator b = b(this, 100L, dimensionPixelSize);
        this.Gi = b;
        b.addListener(animatorListenerAdapter);
        this.Gi.start();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float min = Math.min(getWidth(), getHeight()) / 2.0f;
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.mPaint);
        if (this.Ga == 2) {
            setInnerCirclePaint(this.mPaint);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min - this.Gg, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }
}
