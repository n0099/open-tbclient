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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes5.dex */
public class CircleSkipView extends KSFrameLayout implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public RectF b;
    public float c;
    public float d;
    public int e;
    public int f;
    public ValueAnimator g;
    public boolean h;
    public SkipView.a i;
    public long j;
    public float k;
    public int l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleSkipView(@NonNull Context context) {
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
    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = new Paint();
        this.c = 270.0f;
        this.d = 360.0f;
        this.e = 0;
        this.f = 0;
        this.h = false;
        this.j = 0L;
        this.k = 0.0f;
        this.l = 0;
        a(context);
    }

    private void a(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.g = ofFloat;
            ofFloat.setDuration(i);
            this.g.setInterpolator(new LinearInterpolator());
            this.g.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CircleSkipView a;

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
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) && this.a.k == 1.0f && this.a.i != null) {
                        this.a.i.b();
                    }
                }
            });
            this.g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, z) { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ CircleSkipView b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = z;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        this.b.k = floatValue;
                        if (this.a) {
                            this.b.h = true;
                            float f = floatValue * 360.0f;
                            this.b.c = 270.0f - f;
                            this.b.d = 360.0f - f;
                            this.b.invalidate();
                        }
                    }
                }
            });
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            b(context);
            addView(c(context), layoutParams);
            setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CircleSkipView a;

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

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.a.i == null) {
                        return;
                    }
                    this.a.i.a();
                }
            });
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, context) == null) {
            this.f = com.kwad.sdk.b.kwai.a.a(context, 2.0f);
            int a = com.kwad.sdk.b.kwai.a.a(context, 32.0f);
            int i = this.f;
            this.e = a - i;
            this.l = i / 2;
            int i2 = this.l;
            int i3 = this.e;
            this.b = new RectF(i2, i2, i3 + i2, i3 + i2);
        }
    }

    public static TextView c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            TextView textView = new TextView(context);
            textView.setText(context.getString(R.string.obfuscated_res_0x7f0f09be));
            textView.setTextColor(-1);
            textView.setTextSize(12.0f);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.h = true;
            ValueAnimator valueAnimator = this.g;
            if (valueAnimator != null) {
                valueAnimator.setCurrentPlayTime(this.j);
                this.g.start();
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.h = false;
            ValueAnimator valueAnimator = this.g;
            if (valueAnimator != null) {
                this.j = valueAnimator.getCurrentPlayTime();
                this.g.cancel();
            }
        }
    }

    private void setAnimationPaint(Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, paint) == null) {
            paint.reset();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.f);
            paint.setColor(-1);
        }
    }

    private void setBgCirclePaint(Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, paint) == null) {
            paint.reset();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.parseColor("#4D000000"));
            paint.setAntiAlias(true);
        }
    }

    private void setOuterCirclePaint(Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, paint) == null) {
            paint.reset();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.f);
            paint.setColor(Color.parseColor("#33FFFFFF"));
            paint.setAntiAlias(true);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            getLayoutParams().height = com.kwad.sdk.b.kwai.a.a(getContext(), 35.0f);
            return getWidth();
        }
        return invokeI.intValue;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, splashSkipViewModel, adInfo) == null) {
            boolean aQ = com.kwad.sdk.core.response.a.a.aQ(adInfo);
            setVisibility(0);
            a(splashSkipViewModel.skipSecond * 1000, aQ);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void a(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adInfo) == null) {
            e();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void b(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adInfo) == null) {
            d();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            setBgCirclePaint(this.a);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (Math.min(getWidth(), getHeight()) / 2.0f) - this.f, this.a);
            setOuterCirclePaint(this.a);
            canvas.drawArc(this.b, 0.0f, 360.0f, false, this.a);
            if (this.h) {
                setAnimationPaint(this.a);
                canvas.drawArc(this.b, this.c, -this.d, false, this.a);
            }
            super.dispatchDraw(canvas);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public void setOnViewListener(SkipView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.i = aVar;
        }
    }
}
