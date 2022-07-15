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
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.l.n;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes5.dex */
public class KsShakeView extends KSFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public int b;
    public Paint c;
    public float d;
    @ColorInt
    public int e;
    @ColorInt
    public int f;
    @ColorInt
    public int g;
    public float h;
    public float i;
    @DrawableRes
    public int j;
    @Nullable
    public Animator k;
    public Animator l;
    public boolean m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KsShakeView(@NonNull Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.c = new Paint();
        this.m = false;
        a(context, attributeSet, i);
    }

    private Animator a(View view2, long j, float f) {
        InterceptResult invokeCommon;
        Interpolator create;
        float height;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{view2, Long.valueOf(j), Float.valueOf(f)})) == null) {
            if (view2 == null) {
                return null;
            }
            if (this.b == 1) {
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
        return (Animator) invokeCommon.objValue;
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, this, context, attributeSet, i) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040369, R.attr.obfuscated_res_0x7f04036a, R.attr.obfuscated_res_0x7f04036b, R.attr.obfuscated_res_0x7f040372, R.attr.obfuscated_res_0x7f040373, R.attr.obfuscated_res_0x7f040379, R.attr.obfuscated_res_0x7f04037a, R.attr.obfuscated_res_0x7f04037d}, i, 0);
            this.d = obtainStyledAttributes.getDimension(4, 1.0f);
            this.e = obtainStyledAttributes.getColor(3, Color.parseColor("#4DFFFFFF"));
            this.f = obtainStyledAttributes.getColor(7, Color.parseColor("#66000000"));
            this.b = obtainStyledAttributes.getInteger(6, 1);
            this.g = obtainStyledAttributes.getColor(1, Color.parseColor("#B3FFFFFF"));
            this.h = obtainStyledAttributes.getDimension(2, 1.0f);
            this.j = obtainStyledAttributes.getResourceId(5, R.drawable.obfuscated_res_0x7f080bd6);
            this.i = obtainStyledAttributes.getDimension(0, com.kwad.sdk.b.kwai.a.a(context, 10.0f));
            obtainStyledAttributes.recycle();
            this.a = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.a, layoutParams);
            e();
        }
    }

    public static Animator b(View view2, long j, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{view2, Long.valueOf(j), Float.valueOf(f)})) == null) {
            Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator duration = ObjectAnimator.ofFloat(view2, "translationY", f).setDuration(100L);
            duration.setInterpolator(create);
            float f2 = -f;
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, "translationY", f2).setDuration(200L);
            duration2.setInterpolator(create);
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(view2, "translationY", f).setDuration(200L);
            duration3.setInterpolator(create);
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(view2, "translationY", f2).setDuration(200L);
            duration4.setInterpolator(create);
            animatorSet.playSequentially(duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view2, "translationY", f).setDuration(100L), ObjectAnimator.ofFloat(view2, "alpha", 1.0f, 1.0f).setDuration(100L));
            return animatorSet;
        }
        return (Animator) invokeCommon.objValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.a.setImageResource(this.j);
        }
    }

    private void setBgCirclePaint(Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, paint) == null) {
            paint.reset();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.f);
            paint.setAntiAlias(true);
        }
    }

    private void setInnerCirclePaint(Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, paint) == null) {
            paint.reset();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.h);
            paint.setColor(this.g);
            paint.setAntiAlias(true);
        }
    }

    private void setOuterCirclePaint(Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, paint) == null) {
            paint.reset();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.d);
            paint.setColor(this.e);
            paint.setAntiAlias(true);
        }
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.b = i;
            setIconDrawableRes(i != 2 ? R.drawable.obfuscated_res_0x7f080bd6 : R.drawable.obfuscated_res_0x7f080bd7);
        }
    }

    public final void a(AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animatorListenerAdapter) == null) {
            this.m = true;
            Animator animator = this.k;
            if (animator != null) {
                animator.cancel();
            }
            this.a.setRotation(0.0f);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070402);
            Animator animator2 = this.l;
            if (animator2 != null) {
                animator2.cancel();
            }
            Animator b = b(this, 100L, dimensionPixelSize);
            this.l = b;
            b.addListener(animatorListenerAdapter);
            this.l.start();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void a_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.a_();
            Animator animator = this.k;
            if (animator != null) {
                animator.cancel();
            }
        }
    }

    @MainThread
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.m = false;
            Animator animator = this.k;
            if (animator != null) {
                animator.cancel();
                this.k = null;
            }
            Animator a = a(this.a, 100L, 16.0f);
            this.k = a;
            if (a != null) {
                a.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.splashscreen.widget.KsShakeView.1
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationCancel(Animator animator2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator2) == null) {
                            super.onAnimationCancel(animator2);
                            this.a.a.setRotation(0.0f);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator2) == null) {
                            super.onAnimationEnd(animator2);
                            if (this.a.m || this.a.k == null) {
                                return;
                            }
                            this.a.k.start();
                        }
                    }
                });
                this.k.start();
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Animator animator = this.k;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.l;
            if (animator2 != null) {
                animator2.cancel();
            }
            this.k = null;
            this.l = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            float min = Math.min(getWidth(), getHeight()) / 2.0f;
            setBgCirclePaint(this.c);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.c);
            setOuterCirclePaint(this.c);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.c);
            if (this.b == 2) {
                setInnerCirclePaint(this.c);
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min - this.i, this.c);
            }
            super.dispatchDraw(canvas);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }

    @MainThread
    public void setIconDrawableRes(@DrawableRes int i) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (imageView = this.a) == null) {
            return;
        }
        imageView.setImageResource(i);
    }
}
