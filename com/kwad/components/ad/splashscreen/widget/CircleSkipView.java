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
/* loaded from: classes8.dex */
public class CircleSkipView extends KSFrameLayout implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean Aa;
    public SkipView.a Ab;
    public long Ac;
    public float Ad;
    public Paint mPaint;
    public boolean pX;
    public int padding;
    public int radius;
    public RectF zV;
    public float zW;
    public float zX;
    public int zY;
    public ValueAnimator zZ;

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
        this.mPaint = new Paint();
        this.zW = 270.0f;
        this.zX = 360.0f;
        this.radius = 0;
        this.zY = 0;
        this.Aa = false;
        this.Ac = 0L;
        this.Ad = 0.0f;
        this.padding = 0;
        this.pX = true;
        ab(context);
    }

    public static /* synthetic */ boolean a(CircleSkipView circleSkipView, boolean z) {
        circleSkipView.Aa = true;
        return true;
    }

    private void ab(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            ac(context);
            addView(ad(context), layoutParams);
            setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CircleSkipView Ae;

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
                    this.Ae = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || this.Ae.Ab == null) {
                        return;
                    }
                    this.Ae.Ab.kb();
                }
            });
        }
    }

    private void ac(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, context) == null) {
            this.zY = com.kwad.sdk.b.kwai.a.a(context, 2.0f);
            int a = com.kwad.sdk.b.kwai.a.a(context, 32.0f);
            int i = this.zY;
            this.radius = a - i;
            this.padding = i / 2;
            int i2 = this.padding;
            int i3 = this.radius;
            this.zV = new RectF(i2, i2, i3 + i2, i3 + i2);
        }
    }

    public static TextView ad(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            TextView textView = new TextView(context);
            textView.setText(context.getString(R.string.obfuscated_res_0x7f0f0a66));
            textView.setTextColor(-1);
            textView.setTextSize(12.0f);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    private void d(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.zZ = ofFloat;
            ofFloat.setDuration(i);
            this.zZ.setInterpolator(new LinearInterpolator());
            this.zZ.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CircleSkipView Ae;

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
                    this.Ae = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) && this.Ae.Ad == 1.0f && this.Ae.Ab != null) {
                        this.Ae.Ab.kc();
                    }
                }
            });
            this.zZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, z) { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CircleSkipView Ae;
                public final /* synthetic */ boolean Af;

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
                    this.Ae = this;
                    this.Af = z;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        this.Ae.Ad = floatValue;
                        if (this.Af) {
                            CircleSkipView.a(this.Ae, true);
                            float f = floatValue * 360.0f;
                            this.Ae.zW = 270.0f - f;
                            this.Ae.zX = 360.0f - f;
                            this.Ae.invalidate();
                        }
                    }
                }
            });
        }
    }

    private void kB() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.Aa = true;
            ValueAnimator valueAnimator = this.zZ;
            if (valueAnimator != null) {
                valueAnimator.setCurrentPlayTime(this.Ac);
                this.zZ.start();
            }
        }
    }

    private void kC() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.Aa = false;
            ValueAnimator valueAnimator = this.zZ;
            if (valueAnimator != null) {
                this.Ac = valueAnimator.getCurrentPlayTime();
                this.zZ.cancel();
            }
        }
    }

    private void setAnimationPaint(Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, paint) == null) {
            paint.reset();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.zY);
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
            paint.setStrokeWidth(this.zY);
            paint.setColor(Color.parseColor("#33FFFFFF"));
            paint.setAntiAlias(true);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final int Y(int i) {
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
            this.pX = com.kwad.sdk.core.response.a.a.bz(adInfo);
            boolean bA = com.kwad.sdk.core.response.a.a.bA(adInfo);
            if (this.pX) {
                setVisibility(0);
            }
            d(splashSkipViewModel.skipSecond * 1000, bA);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void bj() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            kC();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            setBgCirclePaint(this.mPaint);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (Math.min(getWidth(), getHeight()) / 2.0f) - this.zY, this.mPaint);
            setOuterCirclePaint(this.mPaint);
            canvas.drawArc(this.zV, 0.0f, 360.0f, false, this.mPaint);
            if (this.Aa) {
                setAnimationPaint(this.mPaint);
                canvas.drawArc(this.zV, this.zW, -this.zX, false, this.mPaint);
            }
            super.dispatchDraw(canvas);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void s(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, adInfo) == null) {
            kC();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public void setOnViewListener(SkipView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.Ab = aVar;
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void t(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adInfo) == null) {
            kB();
        }
    }
}
