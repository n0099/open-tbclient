package com.kwad.sdk.contentalliance.refreshview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class ShootRefreshView extends View implements d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Property<ShootRefreshView, Float> f35431a;

    /* renamed from: b  reason: collision with root package name */
    public static final Property<ShootRefreshView, Float> f35432b;

    /* renamed from: c  reason: collision with root package name */
    public static final float f35433c;

    /* renamed from: d  reason: collision with root package name */
    public static final float f35434d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f35435e;

    /* renamed from: f  reason: collision with root package name */
    public final RectF f35436f;

    /* renamed from: g  reason: collision with root package name */
    public int f35437g;

    /* renamed from: h  reason: collision with root package name */
    public int f35438h;

    /* renamed from: i  reason: collision with root package name */
    public int f35439i;
    public int j;
    public int k;
    public int l;
    public int m;
    public float n;
    public float o;
    public float p;
    public Shader q;
    public boolean r;
    public ValueAnimator s;
    public float t;
    public float u;
    public boolean v;
    public AnimatorSet w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2142577583, "Lcom/kwad/sdk/contentalliance/refreshview/ShootRefreshView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2142577583, "Lcom/kwad/sdk/contentalliance/refreshview/ShootRefreshView;");
                return;
            }
        }
        f35431a = new Property<ShootRefreshView, Float>(Float.class, null) { // from class: com.kwad.sdk.contentalliance.refreshview.ShootRefreshView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8, r9);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r8, r9};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Class) objArr2[0], (String) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            /* renamed from: a */
            public Float get(ShootRefreshView shootRefreshView) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, shootRefreshView)) == null) ? Float.valueOf(shootRefreshView.o) : (Float) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            /* renamed from: a */
            public void set(ShootRefreshView shootRefreshView, Float f2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shootRefreshView, f2) == null) {
                    shootRefreshView.o = f2.floatValue();
                    shootRefreshView.invalidate();
                }
            }
        };
        f35432b = new Property<ShootRefreshView, Float>(Float.class, null) { // from class: com.kwad.sdk.contentalliance.refreshview.ShootRefreshView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8, r9);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r8, r9};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Class) objArr2[0], (String) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            /* renamed from: a */
            public Float get(ShootRefreshView shootRefreshView) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, shootRefreshView)) == null) ? Float.valueOf(shootRefreshView.p) : (Float) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            /* renamed from: a */
            public void set(ShootRefreshView shootRefreshView, Float f2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shootRefreshView, f2) == null) {
                    shootRefreshView.p = f2.floatValue();
                    shootRefreshView.invalidate();
                }
            }
        };
        f35433c = (float) Math.toDegrees(0.5235987901687622d);
        f35434d = (float) Math.sqrt(3.0d);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShootRefreshView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShootRefreshView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShootRefreshView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f35435e = new Paint(1);
        this.f35436f = new RectF();
        this.v = false;
        a(context, attributeSet);
        g();
        h();
        a();
    }

    private void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, context, attributeSet) == null) {
            this.j = -1044481;
            this.k = -256;
            this.l = 234880768;
            this.m = ao.a(getContext(), 1.5f);
            this.q = new SweepGradient(0.0f, 0.0f, new int[]{this.k, this.l}, new float[]{0.3f, 1.0f});
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Canvas canvas) {
        Paint paint;
        Shader shader;
        float f2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, canvas) == null) {
            canvas.save();
            canvas.translate(this.f35438h, this.f35439i);
            if (this.s.isRunning()) {
                canvas.rotate(this.n - 90.0f);
                Shader shader2 = this.f35435e.getShader();
                shader = this.q;
                if (shader2 != shader) {
                    paint = this.f35435e;
                }
                f2 = this.u;
                i2 = this.f35437g;
                if (f2 >= i2 * 2) {
                    this.t = 0.0f;
                } else {
                    this.t = ((f2 - (i2 * 2)) * 360.0f) / (i2 * 4.0f);
                }
                this.f35435e.setAntiAlias(true);
                this.f35435e.setStyle(Paint.Style.STROKE);
                int i3 = this.f35437g;
                canvas.drawArc(new RectF(0.0f - i3, 0.0f - i3, i3 + 0.0f, i3 + 0.0f), -90.0f, !this.v ? 360.0f : this.t, false, this.f35435e);
                canvas.restore();
            }
            paint = this.f35435e;
            shader = null;
            paint.setShader(shader);
            f2 = this.u;
            i2 = this.f35437g;
            if (f2 >= i2 * 2) {
            }
            this.f35435e.setAntiAlias(true);
            this.f35435e.setStyle(Paint.Style.STROKE);
            int i32 = this.f35437g;
            canvas.drawArc(new RectF(0.0f - i32, 0.0f - i32, i32 + 0.0f, i32 + 0.0f), -90.0f, !this.v ? 360.0f : this.t, false, this.f35435e);
            canvas.restore();
        }
    }

    private void b(Canvas canvas) {
        int i2;
        float pow;
        float f2;
        float f3;
        Paint paint;
        Canvas canvas2;
        float pow2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, canvas) == null) {
            Canvas canvas3 = canvas;
            this.f35435e.setShader(null);
            canvas.save();
            canvas3.translate(this.f35438h, this.f35439i);
            canvas3.rotate(-this.p);
            int i3 = 0;
            while (i3 < 6) {
                canvas.save();
                canvas3.rotate(i3 * (-60));
                float f4 = this.o;
                if (f4 > 0.5235988f) {
                    double tan = Math.tan(f4);
                    double tan2 = Math.tan(this.o + 1.0471976f);
                    float f5 = f35434d;
                    double d2 = (tan - tan2) * 2.0d;
                    int i4 = this.f35437g;
                    i2 = i3;
                    pow = ((float) ((((2.0d * tan2) - tan) - ((f5 * tan) * tan2)) / d2)) * i4;
                    f2 = 0.0f;
                    f3 = -i4;
                    paint = this.f35435e;
                    canvas2 = canvas;
                    pow2 = i4 * ((float) ((1.0d - (f5 * tan2)) / d2));
                } else {
                    i2 = i3;
                    double tan3 = Math.tan(f4);
                    pow = (float) (((Math.pow(tan3, 2.0d) - 1.0d) * this.f35437g) / (Math.pow(tan3, 2.0d) + 1.0d));
                    f2 = 0.0f;
                    f3 = -this.f35437g;
                    paint = this.f35435e;
                    canvas2 = canvas;
                    pow2 = (float) (((tan3 * 2.0d) * this.f35437g) / (Math.pow(tan3, 2.0d) + 1.0d));
                }
                canvas2.drawLine(f2, f3, pow2, pow, paint);
                canvas.restore();
                i3 = i2 + 1;
                canvas3 = canvas;
            }
            canvas.restore();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f35435e.setStyle(Paint.Style.STROKE);
            this.f35435e.setStrokeWidth(this.m);
            this.f35435e.setColor(this.j);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            i();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
            this.s = ofFloat;
            ofFloat.setRepeatCount(-1);
            this.s.setInterpolator(new LinearInterpolator());
            this.s.setDuration(400L);
            this.s.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.sdk.contentalliance.refreshview.ShootRefreshView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ShootRefreshView f35440a;

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
                    this.f35440a = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        this.f35440a.n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        this.f35440a.invalidate();
                    }
                }
            });
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.5235988f);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.setDuration(30L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.sdk.contentalliance.refreshview.ShootRefreshView.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ShootRefreshView f35441a;

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
                    this.f35441a = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        this.f35441a.n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        this.f35441a.invalidate();
                    }
                }
            });
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(f35431a, 0.5235988f, 1.2566371f);
            Property<ShootRefreshView, Float> property = f35432b;
            float f2 = f35433c;
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, ofFloat2, PropertyValuesHolder.ofFloat(property, -(f2 / 2.0f), (-(f2 / 2.0f)) - 120.0f));
            ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
            ofPropertyValuesHolder.setDuration(350L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.w = animatorSet;
            animatorSet.play(ofPropertyValuesHolder).after(ofFloat);
        }
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.o = 1.2566371f;
            this.p = (-(f35433c / 2.0f)) - 240.0f;
            this.n = 0.0f;
            invalidate();
            this.v = false;
            this.r = false;
            this.w.end();
            this.s.end();
        }
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.u = f2;
            invalidate();
        }
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.n = 0.0f;
            this.p = 0.0f;
            this.o = 0.0f;
            if (this.w.isRunning()) {
                this.s.end();
            } else {
                this.s.start();
            }
            this.r = true;
            this.v = true;
        }
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.w.start();
            this.s.end();
        }
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.kwad.sdk.contentalliance.refreshview.d
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Build.VERSION.SDK_INT > 19 ? 500 : 800 : invokeV.intValue;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            a();
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.r) {
                b(canvas);
            }
            a(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048585, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.f35436f.set(getPaddingLeft() + 0, getPaddingTop() + 0, i2 - getPaddingRight(), i3 - getPaddingBottom());
            RectF rectF = this.f35436f;
            int i6 = this.m;
            rectF.inset(i6, i6);
            this.f35437g = (int) (Math.min(this.f35436f.width(), this.f35436f.height()) / 2.0f);
            this.f35438h = (int) this.f35436f.centerX();
            this.f35439i = (int) this.f35436f.centerY();
        }
    }
}
