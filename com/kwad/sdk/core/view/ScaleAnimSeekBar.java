package com.kwad.sdk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.av;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class ScaleAnimSeekBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public WeakReference<a> E;
    public boolean F;
    public boolean G;
    public ValueAnimator H;
    public ValueAnimator I;
    public ValueAnimator J;
    public float K;
    public float L;
    public float M;
    public float N;
    public int O;
    public boolean P;

    /* renamed from: a  reason: collision with root package name */
    public Paint f72028a;

    /* renamed from: b  reason: collision with root package name */
    public int f72029b;

    /* renamed from: c  reason: collision with root package name */
    public int f72030c;

    /* renamed from: d  reason: collision with root package name */
    public int f72031d;

    /* renamed from: e  reason: collision with root package name */
    public int f72032e;

    /* renamed from: f  reason: collision with root package name */
    public int f72033f;

    /* renamed from: g  reason: collision with root package name */
    public int f72034g;

    /* renamed from: h  reason: collision with root package name */
    public int f72035h;

    /* renamed from: i  reason: collision with root package name */
    public int f72036i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f72037j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public GradientDrawable r;
    public GradientDrawable s;
    public GradientDrawable t;
    public Rect u;
    public Rect v;
    public Rect w;
    public Rect x;
    public Drawable y;
    public boolean z;

    /* loaded from: classes10.dex */
    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, int i2, boolean z);

        void b(ScaleAnimSeekBar scaleAnimSeekBar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScaleAnimSeekBar(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
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
    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i2) {
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
        this.f72034g = 100;
        this.f72037j = false;
        this.y = null;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = true;
        this.F = true;
        this.G = false;
        this.K = 1.0f;
        this.L = 1.34f;
        this.M = 1.0f;
        this.N = 2.0f;
        a(context, attributeSet);
    }

    private float a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) {
            int i3 = this.k;
            int i4 = this.f72033f;
            return ((i3 * (i2 - i4)) / (this.f72034g - i4)) - (i3 / 2.0f);
        }
        return invokeI.floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(AdIconUtil.AD_TEXT_ID, this, f2) == null) {
            Rect rect = this.x;
            int i2 = this.f72032e;
            rect.left = (int) (f2 - i2);
            rect.right = (int) (i2 + f2);
            this.v.right = (int) f2;
            invalidate();
        }
    }

    private void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(AdIconUtil.BAIDU_LOGO_ID, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        this.k = this.F ? (int) (i2 - ((this.O * 2) * (this.L - this.K))) : i2 - (this.O * 2);
        Rect rect = this.u;
        int i4 = -this.f72036i;
        rect.top = i4;
        rect.bottom = -i4;
        rect.left = (this.f72037j ? -i2 : -this.k) / 2;
        this.u.right = this.f72037j ? i2 / 2 : this.k / 2;
        Rect rect2 = this.v;
        int i5 = -this.f72036i;
        rect2.top = i5;
        rect2.bottom = -i5;
        rect2.left = (this.f72037j ? -i2 : -this.k) / 2;
        Rect rect3 = this.v;
        int i6 = this.k;
        rect3.right = (-i6) / 2;
        Rect rect4 = this.w;
        rect4.top = -this.f72036i;
        rect4.bottom = -rect3.top;
        rect4.left = (this.f72037j ? -i2 : -i6) / 2;
        Rect rect5 = this.w;
        int i7 = this.k;
        rect5.right = (-i7) / 2;
        Rect rect6 = this.x;
        int i8 = this.f72032e;
        rect6.top = -i8;
        rect6.bottom = i8;
        rect6.left = ((-i7) / 2) - i8;
        rect6.right = ((-i7) / 2) + i8;
        setThumbDrawable(this.y);
        setProgress(this.m);
        setSecondaryProgress(this.o);
    }

    private void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, context, attributeSet) == null) {
            if (attributeSet != null) {
                a(context);
            }
            Paint paint = new Paint();
            this.f72028a = paint;
            paint.setStyle(Paint.Style.FILL);
            this.f72028a.setAntiAlias(true);
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.r = gradientDrawable;
            gradientDrawable.setShape(0);
            this.r.setColor(this.f72029b);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            this.s = gradientDrawable2;
            gradientDrawable2.setShape(0);
            this.s.setColor(this.f72030c);
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            this.t = gradientDrawable3;
            gradientDrawable3.setShape(0);
            this.t.setColor(this.f72031d);
            this.u = new Rect();
            this.v = new Rect();
            this.x = new Rect();
            this.w = new Rect();
            this.m = this.f72033f;
        }
    }

    private void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, canvas) == null) {
            canvas.save();
            Drawable drawable = this.y;
            if (drawable != null) {
                drawable.setBounds(this.x);
                this.y.draw(canvas);
            } else {
                this.f72028a.setColor(this.f72030c);
                canvas.drawCircle(this.x.centerX(), this.x.centerY(), (this.x.width() * this.K) / 2.0f, this.f72028a);
            }
            canvas.restore();
        }
    }

    private void a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, this, canvas, rect, gradientDrawable) == null) {
            canvas.save();
            Rect rect2 = new Rect();
            float f2 = this.M;
            rect2.top = (int) (rect.top * f2);
            rect2.bottom = (int) (rect.bottom * f2);
            rect2.left = rect.left;
            rect2.right = rect.right;
            gradientDrawable.setBounds(rect2);
            gradientDrawable.setCornerRadius(this.f72035h * this.M);
            gradientDrawable.draw(canvas);
            canvas.restore();
        }
    }

    private void a(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (!z) {
                this.m = i2;
                a(b(a(i2)));
                return;
            }
            float b2 = b(a(this.m));
            float b3 = b(a(i2));
            ValueAnimator valueAnimator = this.J;
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.J = valueAnimator2;
                valueAnimator2.setDuration(300L);
                this.J.setInterpolator(new Interpolator(this) { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ScaleAnimSeekBar f72038a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f72038a = this;
                    }

                    @Override // android.animation.TimeInterpolator
                    public float getInterpolation(float f2) {
                        InterceptResult invokeF;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeF = interceptable2.invokeF(1048576, this, f2)) == null) {
                            float f3 = f2 - 1.0f;
                            return (f3 * f3 * f3) + 1.0f;
                        }
                        return invokeF.floatValue;
                    }
                });
                this.J.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ScaleAnimSeekBar f72039a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f72039a = this;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator3) == null) {
                            float floatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                            ScaleAnimSeekBar scaleAnimSeekBar = this.f72039a;
                            scaleAnimSeekBar.m = scaleAnimSeekBar.b((int) floatValue);
                            this.f72039a.a(floatValue);
                        }
                    }
                });
            } else {
                valueAnimator.cancel();
            }
            this.J.setFloatValues(b2, b3);
            this.J.start();
        }
    }

    private boolean a(float f2, float f3) {
        InterceptResult invokeCommon;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            Rect rect = this.x;
            int i4 = rect.left;
            int i5 = rect.right;
            if (i4 < i5 && (i2 = rect.top) < (i3 = rect.bottom)) {
                float f4 = this.K;
                int i6 = this.l;
                if (f2 >= (i4 * f4) - i6 && f2 <= (i5 * f4) + i6 && f3 >= (i2 * f4) - i6 && f3 <= (i3 * f4) + i6) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private float b(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65549, this, f2)) == null) {
            float f3 = this.k / 2;
            if (f2 > f3) {
                return f3;
            }
            float f4 = -f3;
            return f2 < f4 ? f4 : f2;
        }
        return invokeF.floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, this, i2)) == null) {
            int i3 = this.k;
            return i2 > i3 / 2 ? this.f72034g : i2 < (-i3) / 2 ? this.f72033f : Math.round(((i2 + (i3 / 2.0f)) * (this.f72034g - this.f72033f)) / i3) + this.f72033f;
        }
        return invokeI.intValue;
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65553, this, z) == null) && this.F) {
            boolean z2 = z;
            c(z2);
            d(z2);
        }
    }

    private boolean b(float f2, float f3) {
        InterceptResult invokeCommon;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            Rect rect = this.u;
            int i4 = rect.left;
            int i5 = rect.right;
            if (i4 < i5 && (i2 = rect.top) < (i3 = rect.bottom)) {
                float f4 = this.M;
                int i6 = this.l;
                if (f2 >= (i4 * f4) - i6 && f2 <= (i5 * f4) + i6 && f3 >= (i2 * f4) - i6 && f3 <= (i3 * f4) + i6) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65556, this, z) == null) {
            float f2 = this.K;
            float f3 = z ? this.L : 1.0f;
            ValueAnimator valueAnimator = this.H;
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.H = valueAnimator2;
                valueAnimator2.setDuration(250L);
                this.H.setInterpolator(new LinearInterpolator());
                this.H.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ScaleAnimSeekBar f72040a;

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
                        this.f72040a = this;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator3) == null) {
                            this.f72040a.K = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                            this.f72040a.requestLayout();
                        }
                    }
                });
            } else {
                valueAnimator.cancel();
            }
            this.H.setFloatValues(f2, f3);
            this.H.start();
        }
    }

    private void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65557, this, z) == null) {
            float f2 = this.M;
            float f3 = z ? this.N : 1.0f;
            ValueAnimator valueAnimator = this.I;
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.I = valueAnimator2;
                valueAnimator2.setDuration(250L);
                this.I.setInterpolator(new LinearInterpolator());
                this.I.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ScaleAnimSeekBar f72041a;

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
                        this.f72041a = this;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator3) == null) {
                            this.f72041a.M = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                            this.f72041a.requestLayout();
                        }
                    }
                });
            } else {
                valueAnimator.cancel();
            }
            this.I.setFloatValues(f2, f3);
            this.I.start();
        }
    }

    private a getOnSeekBarChangedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            WeakReference<a> weakReference = this.E;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (a) invokeV.objValue;
    }

    public void a(int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            int i3 = this.f72033f;
            if (i2 <= i3 || i2 >= (i3 = this.f72034g)) {
                i2 = i3;
            }
            a(z, i2);
            a onSeekBarChangedListener = getOnSeekBarChangedListener();
            if (onSeekBarChangedListener != null) {
                int i4 = this.n;
                int i5 = this.m;
                if (i4 != i5) {
                    this.B = z2;
                    onSeekBarChangedListener.a(this, i5, z2);
                    this.B = false;
                }
            }
            this.n = this.m;
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.F = true;
            this.O = av.a(context, 10.0f);
            this.f72032e = av.a(context, 3.0f);
            this.l = av.a(context, 20.0f);
            this.y = null;
            this.G = false;
            this.f72036i = av.a(context, 0.3f);
            this.f72035h = av.a(context, 1.0f);
            this.f72029b = 654311423;
            this.f72030c = -1;
            this.f72031d = 1090519039;
            this.f72033f = 0;
            this.f72034g = 100;
            this.f72037j = false;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.P = z;
            b(z);
        }
    }

    public int getMaxProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f72034g : invokeV.intValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : invokeV.intValue;
    }

    public int getProgressLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : invokeV.intValue;
    }

    public int getProgressX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (int) (getX() + (this.f72032e * this.L)) : invokeV.intValue;
    }

    public int getSecondaryProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.o : invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.save();
            canvas.translate(this.q / 2, this.p / 2);
            a(canvas, this.u, this.r);
            a(canvas, this.w, this.t);
            a(canvas, this.v, this.s);
            if (this.P) {
                a(canvas);
            }
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode != 1073741824) {
                size = getWidth();
            }
            this.q = size;
            if (mode2 == 1073741824) {
                this.p = size2;
            } else {
                this.p = getHeight();
            }
            a(this.q, this.p);
            setMeasuredDimension(this.q, this.p);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
        if (r3 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007e, code lost:
        r3.requestDisallowInterceptTouchEvent(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0092, code lost:
        if (r3 != null) goto L34;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            float x = motionEvent.getX() - (this.q / 2);
            float y = motionEvent.getY() - (this.p / 2);
            ViewParent parent = getParent();
            a onSeekBarChangedListener = getOnSeekBarChangedListener();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    this.D = false;
                    if (this.A || this.z) {
                        this.A = false;
                        this.z = false;
                        a(b((int) x), this.G, true);
                        if (onSeekBarChangedListener != null) {
                            onSeekBarChangedListener.b(this);
                        }
                    }
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(false);
                    }
                } else if (action == 2 && (this.z || this.A)) {
                    a(b((int) x), false, true);
                }
            } else if (!this.C) {
                return super.onTouchEvent(motionEvent);
            } else {
                if (a(x, y)) {
                    b(true);
                    this.z = true;
                    this.D = true;
                    if (onSeekBarChangedListener != null) {
                        onSeekBarChangedListener.a(this);
                    }
                } else if (b(x, y)) {
                    b(true);
                    this.A = true;
                    if (onSeekBarChangedListener != null) {
                        onSeekBarChangedListener.a(this);
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setMaxProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f72034g = i2;
        }
    }

    public void setMinProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f72033f = i2;
            if (this.m < i2) {
                this.m = i2;
            }
        }
    }

    public void setOnSeekBarChangeListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.E = new WeakReference<>(aVar);
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            a(i2, false, false);
        }
    }

    public void setProgressBackgroundColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f72029b = i2;
            this.r.setColor(i2);
        }
    }

    public void setProgressColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f72030c = i2;
            this.s.setColor(i2);
        }
    }

    public void setSecondaryProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            int i3 = this.f72033f;
            if (i2 <= i3 || i2 >= (i3 = this.f72034g)) {
                i2 = i3;
            }
            this.o = i2;
            this.w.right = (int) b(a(i2));
            invalidate();
        }
    }

    public void setSecondaryProgressColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f72031d = i2;
            this.t.setColor(i2);
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, drawable) == null) || drawable == null) {
            return;
        }
        this.y = drawable;
    }

    public void setThumbEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.C = z;
        }
    }

    public void setThumbScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            this.K = f2;
        }
    }

    public void setThumbTouchOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.l = i2;
            invalidate();
        }
    }
}
