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
/* loaded from: classes7.dex */
public class KsShakeView extends FrameLayout {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public int f40139b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f40140c;

    /* renamed from: d  reason: collision with root package name */
    public float f40141d;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    public int f40142e;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    public int f40143f;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    public int f40144g;

    /* renamed from: h  reason: collision with root package name */
    public float f40145h;
    public float i;
    @DrawableRes
    public int j;
    public Animator k;
    public boolean l;

    public KsShakeView(@NonNull Context context) {
        this(context, null, 0);
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f40140c = new Paint();
        this.l = false;
        a(context, attributeSet, i);
    }

    private Animator a(View view, long j, float f2) {
        Interpolator create;
        float height;
        if (view == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        if (this.f40139b == 1) {
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
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "rotation", 0.0f, f2).setDuration(j);
        float f3 = -f2;
        long j2 = j * 2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "rotation", f2, f3).setDuration(j2);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "rotation", f3, f2).setDuration(j2);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "rotation", f2, f3).setDuration(j2);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(ofFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "rotation", f3, 0.0f).setDuration(j));
        return animatorSet;
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040315, R.attr.obfuscated_res_0x7f040316, R.attr.obfuscated_res_0x7f040317, R.attr.obfuscated_res_0x7f04031c, R.attr.obfuscated_res_0x7f04031d, R.attr.obfuscated_res_0x7f040323, R.attr.obfuscated_res_0x7f040324, R.attr.obfuscated_res_0x7f040326}, i, 0);
        this.f40141d = obtainStyledAttributes.getDimension(4, 1.0f);
        this.f40142e = obtainStyledAttributes.getColor(3, Color.parseColor("#4DFFFFFF"));
        this.f40143f = obtainStyledAttributes.getColor(7, Color.parseColor("#66000000"));
        this.f40139b = obtainStyledAttributes.getInteger(6, 1);
        this.f40144g = obtainStyledAttributes.getColor(1, Color.parseColor("#B3FFFFFF"));
        this.f40145h = obtainStyledAttributes.getDimension(2, 1.0f);
        this.j = obtainStyledAttributes.getResourceId(5, R.drawable.obfuscated_res_0x7f080baf);
        this.i = obtainStyledAttributes.getDimension(0, a.a(context, 10.0f));
        obtainStyledAttributes.recycle();
        this.a = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.a, layoutParams);
        b();
    }

    private Animator b(View view, long j, float f2) {
        if (view == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_Y, f2).setDuration(j);
        duration.setInterpolator(create);
        float f3 = -f2;
        long j2 = 2 * j;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_Y, f3).setDuration(j2);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_Y, f2).setDuration(j2);
        duration3.setInterpolator(create);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_Y, f3).setDuration(j2);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_Y, f2).setDuration(j), ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, 1.0f, 1.0f).setDuration(j));
        return animatorSet;
    }

    private void b() {
        this.a.setImageResource(this.j);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.f40143f);
        paint.setAntiAlias(true);
    }

    private void setInnerCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f40145h);
        paint.setColor(this.f40144g);
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f40141d);
        paint.setColor(this.f40142e);
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

    public void a(int i) {
        this.f40139b = i;
        setIconDrawableRes(i != 2 ? R.drawable.obfuscated_res_0x7f080baf : R.drawable.obfuscated_res_0x7f080bb0);
    }

    public void a(AnimatorListenerAdapter animatorListenerAdapter) {
        this.l = true;
        Animator animator = this.k;
        if (animator != null) {
            animator.cancel();
        }
        this.a.setRotation(0.0f);
        Animator b2 = b(this, 100L, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a6));
        if (animatorListenerAdapter != null) {
            b2.addListener(animatorListenerAdapter);
        }
        b2.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float min = Math.min(getWidth(), getHeight()) / 2.0f;
        setBgCirclePaint(this.f40140c);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.f40140c);
        setOuterCirclePaint(this.f40140c);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.f40140c);
        if (this.f40139b == 2) {
            setInnerCirclePaint(this.f40140c);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min - this.i, this.f40140c);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @MainThread
    public void setIconDrawableRes(@DrawableRes int i) {
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }
}
