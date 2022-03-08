package com.kwad.sdk.core.widget;

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
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.kwad.sdk.a.kwai.a;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes8.dex */
public class KsShakeView extends FrameLayout {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public int f55054b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f55055c;

    /* renamed from: d  reason: collision with root package name */
    public float f55056d;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    public int f55057e;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    public int f55058f;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    public int f55059g;

    /* renamed from: h  reason: collision with root package name */
    public float f55060h;

    /* renamed from: i  reason: collision with root package name */
    public float f55061i;
    @DrawableRes

    /* renamed from: j  reason: collision with root package name */
    public int f55062j;
    public Animator k;
    public boolean l;

    public KsShakeView(@NonNull Context context) {
        this(context, null, 0);
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f55055c = new Paint();
        this.l = false;
        a(context, attributeSet, i2);
    }

    private Animator a(View view, long j2, float f2) {
        Interpolator create;
        float height;
        if (view == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        if (this.f55054b == 1) {
            create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
            view.setPivotX(view.getWidth());
            height = view.getHeight();
        } else {
            create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
            view.setPivotX(view.getWidth() / 2.0f);
            height = view.getHeight() / 2.0f;
        }
        view.setPivotY(height);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, 1.0f, 1.0f);
        ofFloat.setDuration(300L);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "rotation", 0.0f, f2).setDuration(j2);
        float f3 = -f2;
        long j3 = j2 * 2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "rotation", f2, f3).setDuration(j3);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "rotation", f3, f2).setDuration(j3);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "rotation", f2, f3).setDuration(j3);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(ofFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "rotation", f3, 0.0f).setDuration(j2));
        return animatorSet;
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.ksad_innerCirclePadding, R.attr.ksad_innerCircleStrokeColor, R.attr.ksad_innerCircleStrokeWidth, R.attr.ksad_outerStrokeColor, R.attr.ksad_outerStrokeWidth, R.attr.ksad_shakeIcon, R.attr.ksad_shakeViewStyle, R.attr.ksad_solidColor}, i2, 0);
        this.f55056d = obtainStyledAttributes.getDimension(4, 1.0f);
        this.f55057e = obtainStyledAttributes.getColor(3, Color.parseColor("#4DFFFFFF"));
        this.f55058f = obtainStyledAttributes.getColor(7, Color.parseColor("#66000000"));
        this.f55054b = obtainStyledAttributes.getInteger(6, 1);
        this.f55059g = obtainStyledAttributes.getColor(1, Color.parseColor("#B3FFFFFF"));
        this.f55060h = obtainStyledAttributes.getDimension(2, 1.0f);
        this.f55062j = obtainStyledAttributes.getResourceId(5, R.drawable.ksad_ic_shake_hand);
        this.f55061i = obtainStyledAttributes.getDimension(0, a.a(context, 10.0f));
        obtainStyledAttributes.recycle();
        this.a = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.a, layoutParams);
        b();
    }

    private Animator b(View view, long j2, float f2) {
        if (view == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_Y, f2).setDuration(j2);
        duration.setInterpolator(create);
        float f3 = -f2;
        long j3 = 2 * j2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_Y, f3).setDuration(j3);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_Y, f2).setDuration(j3);
        duration3.setInterpolator(create);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_Y, f3).setDuration(j3);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_Y, f2).setDuration(j2), ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, 1.0f, 1.0f).setDuration(j2));
        return animatorSet;
    }

    private void b() {
        this.a.setImageResource(this.f55062j);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.f55058f);
        paint.setAntiAlias(true);
    }

    private void setInnerCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f55060h);
        paint.setColor(this.f55059g);
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f55056d);
        paint.setColor(this.f55057e);
        paint.setAntiAlias(true);
    }

    @MainThread
    public void a() {
        Animator animator = this.k;
        if (animator != null) {
            animator.cancel();
            this.k = null;
        }
        Animator a = a(this.a, 100L, 16.0f);
        this.k = a;
        if (a != null) {
            a.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.core.widget.KsShakeView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    KsShakeView.this.a.setRotation(0.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (KsShakeView.this.l) {
                        return;
                    }
                    KsShakeView.this.k.start();
                }
            });
            this.k.start();
        }
    }

    public void a(int i2) {
        this.f55054b = i2;
        setIconDrawableRes(i2 != 2 ? R.drawable.ksad_ic_shake_hand : R.drawable.ksad_ic_shake_phone);
    }

    public void a(AnimatorListenerAdapter animatorListenerAdapter) {
        this.l = true;
        Animator animator = this.k;
        if (animator != null) {
            animator.cancel();
        }
        this.a.setRotation(0.0f);
        Animator b2 = b(this, 100L, getResources().getDimensionPixelSize(R.dimen.ksad_splash_shake_animator_height));
        if (animatorListenerAdapter != null) {
            b2.addListener(animatorListenerAdapter);
        }
        b2.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float min = Math.min(getWidth(), getHeight()) / 2.0f;
        setBgCirclePaint(this.f55055c);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.f55055c);
        setOuterCirclePaint(this.f55055c);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.f55055c);
        if (this.f55054b == 2) {
            setInnerCirclePaint(this.f55055c);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min - this.f55061i, this.f55055c);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @MainThread
    public void setIconDrawableRes(@DrawableRes int i2) {
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setImageResource(i2);
        }
    }
}
