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
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.a.kwai.a;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes2.dex */
public class KsShakeView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public int f58122b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f58123c;

    /* renamed from: d  reason: collision with root package name */
    public float f58124d;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    public int f58125e;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    public int f58126f;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    public int f58127g;

    /* renamed from: h  reason: collision with root package name */
    public float f58128h;

    /* renamed from: i  reason: collision with root package name */
    public float f58129i;
    @DrawableRes

    /* renamed from: j  reason: collision with root package name */
    public int f58130j;

    /* renamed from: k  reason: collision with root package name */
    public Animator f58131k;
    public boolean l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KsShakeView(@NonNull Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f58123c = new Paint();
        this.l = false;
        a(context, attributeSet, i2);
    }

    private Animator a(View view, long j2, float f2) {
        InterceptResult invokeCommon;
        Interpolator create;
        float height;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{view, Long.valueOf(j2), Float.valueOf(f2)})) == null) {
            if (view == null) {
                return null;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            if (this.f58122b == 1) {
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
        return (Animator) invokeCommon.objValue;
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, this, context, attributeSet, i2) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i2, 0);
            this.f58124d = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_outerStrokeWidth, 1.0f);
            this.f58125e = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_outerStrokeColor, Color.parseColor("#4DFFFFFF"));
            this.f58126f = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_solidColor, Color.parseColor("#66000000"));
            this.f58122b = obtainStyledAttributes.getInteger(R.styleable.ksad_KsShakeView_ksad_shakeViewStyle, 1);
            this.f58127g = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeColor, Color.parseColor("#B3FFFFFF"));
            this.f58128h = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeWidth, 1.0f);
            this.f58130j = obtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_ic_shake_hand);
            this.f58129i = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_innerCirclePadding, a.a(context, 10.0f));
            obtainStyledAttributes.recycle();
            this.a = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.a, layoutParams);
            b();
        }
    }

    private Animator b(View view, long j2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{view, Long.valueOf(j2), Float.valueOf(f2)})) == null) {
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
        return (Animator) invokeCommon.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.a.setImageResource(this.f58130j);
        }
    }

    private void setBgCirclePaint(Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, paint) == null) {
            paint.reset();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.f58126f);
            paint.setAntiAlias(true);
        }
    }

    private void setInnerCirclePaint(Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, paint) == null) {
            paint.reset();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.f58128h);
            paint.setColor(this.f58127g);
            paint.setAntiAlias(true);
        }
    }

    private void setOuterCirclePaint(Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, paint) == null) {
            paint.reset();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.f58124d);
            paint.setColor(this.f58125e);
            paint.setAntiAlias(true);
        }
    }

    @MainThread
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Animator animator = this.f58131k;
            if (animator != null) {
                animator.cancel();
                this.f58131k = null;
            }
            Animator a = a(this.a, 100L, 16.0f);
            this.f58131k = a;
            if (a != null) {
                a.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.core.widget.KsShakeView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ KsShakeView a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator2) == null) {
                            super.onAnimationCancel(animator2);
                            this.a.a.setRotation(0.0f);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator2) == null) {
                            super.onAnimationEnd(animator2);
                            if (this.a.l) {
                                return;
                            }
                            this.a.f58131k.start();
                        }
                    }
                });
                this.f58131k.start();
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f58122b = i2;
            setIconDrawableRes(i2 != 2 ? R.drawable.ksad_ic_shake_hand : R.drawable.ksad_ic_shake_phone);
        }
    }

    public void a(AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animatorListenerAdapter) == null) {
            this.l = true;
            Animator animator = this.f58131k;
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
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            float min = Math.min(getWidth(), getHeight()) / 2.0f;
            setBgCirclePaint(this.f58123c);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.f58123c);
            setOuterCirclePaint(this.f58123c);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.f58123c);
            if (this.f58122b == 2) {
                setInnerCirclePaint(this.f58123c);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min - this.f58129i, this.f58123c);
            }
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    @MainThread
    public void setIconDrawableRes(@DrawableRes int i2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (imageView = this.a) == null) {
            return;
        }
        imageView.setImageResource(i2);
    }
}
