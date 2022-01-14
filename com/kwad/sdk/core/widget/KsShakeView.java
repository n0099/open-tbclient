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
import com.kwad.sdk.R;
import com.kwad.sdk.a.kwai.a;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes3.dex */
public class KsShakeView extends FrameLayout {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public int f56492b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f56493c;

    /* renamed from: d  reason: collision with root package name */
    public float f56494d;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    public int f56495e;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    public int f56496f;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    public int f56497g;

    /* renamed from: h  reason: collision with root package name */
    public float f56498h;

    /* renamed from: i  reason: collision with root package name */
    public float f56499i;
    @DrawableRes

    /* renamed from: j  reason: collision with root package name */
    public int f56500j;
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
        this.f56493c = new Paint();
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
        if (this.f56492b == 1) {
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i2, 0);
        this.f56494d = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_outerStrokeWidth, 1.0f);
        this.f56495e = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_outerStrokeColor, Color.parseColor("#4DFFFFFF"));
        this.f56496f = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_solidColor, Color.parseColor("#66000000"));
        this.f56492b = obtainStyledAttributes.getInteger(R.styleable.ksad_KsShakeView_ksad_shakeViewStyle, 1);
        this.f56497g = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeColor, Color.parseColor("#B3FFFFFF"));
        this.f56498h = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeWidth, 1.0f);
        this.f56500j = obtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_ic_shake_hand);
        this.f56499i = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_innerCirclePadding, a.a(context, 10.0f));
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
        this.a.setImageResource(this.f56500j);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.f56496f);
        paint.setAntiAlias(true);
    }

    private void setInnerCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f56498h);
        paint.setColor(this.f56497g);
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f56494d);
        paint.setColor(this.f56495e);
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
        this.f56492b = i2;
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
        setBgCirclePaint(this.f56493c);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.f56493c);
        setOuterCirclePaint(this.f56493c);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.f56493c);
        if (this.f56492b == 2) {
            setInnerCirclePaint(this.f56493c);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min - this.f56499i, this.f56493c);
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
