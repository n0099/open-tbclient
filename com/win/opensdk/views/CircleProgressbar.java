package com.win.opensdk.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.p.a.b5;
import c.p.a.d6;
import c.p.a.n1;
import c.p.a.r0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.s2;
/* loaded from: classes3.dex */
public class CircleProgressbar extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f62652b;

    /* renamed from: c  reason: collision with root package name */
    public int f62653c;

    /* renamed from: d  reason: collision with root package name */
    public int f62654d;

    /* renamed from: e  reason: collision with root package name */
    public int f62655e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f62656f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f62657g;

    /* renamed from: h  reason: collision with root package name */
    public int f62658h;

    /* renamed from: i  reason: collision with root package name */
    public s2 f62659i;

    /* renamed from: j  reason: collision with root package name */
    public long f62660j;

    /* renamed from: k  reason: collision with root package name */
    public final Rect f62661k;
    public d6 l;
    public int m;
    public Runnable n;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleProgressbar(Context context) {
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
    public CircleProgressbar(Context context, AttributeSet attributeSet) {
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
    public CircleProgressbar(Context context, AttributeSet attributeSet, int i2) {
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
        this.a = 2;
        this.f62652b = ColorStateList.valueOf(0);
        this.f62654d = -16776961;
        this.f62655e = 8;
        this.f62656f = new Paint();
        this.f62657g = new RectF();
        this.f62658h = 100;
        this.f62659i = s2.f62650b;
        this.f62660j = 3000L;
        this.f62661k = new Rect();
        this.m = 0;
        this.n = new b5(this);
        a(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressbar(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = 2;
        this.f62652b = ColorStateList.valueOf(0);
        this.f62654d = -16776961;
        this.f62655e = 8;
        this.f62656f = new Paint();
        this.f62657g = new RectF();
        this.f62658h = 100;
        this.f62659i = s2.f62650b;
        this.f62660j = 3000L;
        this.f62661k = new Rect();
        this.m = 0;
        this.n = new b5(this);
        a(context, attributeSet);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b();
            c();
        }
    }

    public void a(int i2, d6 d6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, d6Var) == null) {
            this.m = i2;
            this.l = d6Var;
        }
    }

    public final void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet) == null) {
            this.f62656f.setAntiAlias(true);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n1.win_CircleProgressbar);
            this.f62652b = obtainStyledAttributes.hasValue(n1.win_CircleProgressbar_win_in_circle_color) ? obtainStyledAttributes.getColorStateList(n1.win_CircleProgressbar_win_in_circle_color) : ColorStateList.valueOf(0);
            this.f62653c = this.f62652b.getColorForState(getDrawableState(), 0);
            obtainStyledAttributes.recycle();
        }
    }

    public final void b() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int ordinal = this.f62659i.ordinal();
            if (ordinal == 0) {
                i2 = 0;
            } else if (ordinal != 1) {
                return;
            } else {
                i2 = 100;
            }
            this.f62658h = i2;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
            post(this.n);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            removeCallbacks(this.n);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.drawableStateChanged();
            int colorForState = this.f62652b.getColorForState(getDrawableState(), 0);
            if (this.f62653c != colorForState) {
                this.f62653c = colorForState;
                invalidate();
            }
        }
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f62658h : invokeV.intValue;
    }

    public s2 getProgressType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f62659i : (s2) invokeV.objValue;
    }

    public long getTimeMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f62660j : invokeV.longValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            getDrawingRect(this.f62661k);
            int width = this.f62661k.height() > this.f62661k.width() ? this.f62661k.width() : this.f62661k.height();
            int colorForState = this.f62652b.getColorForState(getDrawableState(), 0);
            this.f62656f.setStyle(Paint.Style.FILL);
            this.f62656f.setColor(colorForState);
            canvas.drawCircle(this.f62661k.centerX(), this.f62661k.centerY(), (width / 2) - this.a, this.f62656f);
            TextPaint paint = getPaint();
            paint.setColor(getCurrentTextColor());
            paint.setAntiAlias(true);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(getText().toString(), this.f62661k.centerX(), this.f62661k.centerY() - ((paint.ascent() + paint.descent()) / 2.0f), paint);
            this.f62656f.setColor(this.f62654d);
            this.f62656f.setStyle(Paint.Style.STROKE);
            this.f62656f.setStrokeWidth(this.f62655e);
            this.f62656f.setAntiAlias(true);
            int i2 = this.f62655e;
            int i3 = this.a;
            int i4 = i2 + i3;
            RectF rectF = this.f62657g;
            Rect rect = this.f62661k;
            int i5 = i4 / 2;
            int i6 = (rect.top - i4) + i3 + i2;
            Rect rect2 = this.f62661k;
            rectF.set(rect.left + i5, r0.a(getContext(), 0.4f) + i6, rect2.right - i5, (((rect2.bottom + i4) - this.a) - this.f62655e) - r0.a(getContext(), 0.5f));
            canvas.drawArc(this.f62657g, -90.0f, (this.f62658h * (-360)) / 100, false, this.f62656f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int i4 = (this.a + this.f62655e) * 4;
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (measuredWidth <= measuredHeight) {
                measuredWidth = measuredHeight;
            }
            int i5 = measuredWidth + i4;
            setMeasuredDimension(i5, i5);
        }
    }

    public void setInCircleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f62652b = ColorStateList.valueOf(i2);
            invalidate();
        }
    }

    public void setOutLineColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            invalidate();
        }
    }

    public void setOutLineWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.a = i2;
            invalidate();
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            if (i2 > 100) {
                i2 = 100;
            } else if (i2 < 0) {
                i2 = 0;
            }
            this.f62658h = i2;
            invalidate();
        }
    }

    public void setProgressColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f62654d = i2;
            invalidate();
        }
    }

    public void setProgressLineWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f62655e = i2;
            invalidate();
        }
    }

    public void setProgressType(s2 s2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, s2Var) == null) {
            this.f62659i = s2Var;
            b();
            invalidate();
        }
    }

    public void setTimeMillis(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j2) == null) {
            this.f62660j = j2;
            invalidate();
        }
    }
}
