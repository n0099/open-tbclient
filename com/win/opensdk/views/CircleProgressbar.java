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
import c.m.a.r0;
import c.m.a.w4;
import c.m.a.y5;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.s2;
/* loaded from: classes7.dex */
public class CircleProgressbar extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f44035b;

    /* renamed from: c  reason: collision with root package name */
    public int f44036c;

    /* renamed from: d  reason: collision with root package name */
    public int f44037d;

    /* renamed from: e  reason: collision with root package name */
    public int f44038e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f44039f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f44040g;

    /* renamed from: h  reason: collision with root package name */
    public int f44041h;
    public s2 i;
    public long j;
    public final Rect k;
    public y5 l;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public CircleProgressbar(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 2;
        this.f44035b = ColorStateList.valueOf(0);
        this.f44037d = -16776961;
        this.f44038e = 8;
        this.f44039f = new Paint();
        this.f44040g = new RectF();
        this.f44041h = 100;
        this.i = s2.f44033b;
        this.j = 3000L;
        this.k = new Rect();
        this.m = 0;
        this.n = new w4(this);
        c(context, attributeSet);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d();
            e();
        }
    }

    public void b(int i, y5 y5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, y5Var) == null) {
            this.m = i;
            this.l = y5Var;
        }
    }

    public final void c(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet) == null) {
            this.f44039f.setAntiAlias(true);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040692});
            this.f44035b = obtainStyledAttributes.hasValue(0) ? obtainStyledAttributes.getColorStateList(0) : ColorStateList.valueOf(0);
            this.f44036c = this.f44035b.getColorForState(getDrawableState(), 0);
            obtainStyledAttributes.recycle();
        }
    }

    public final void d() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int ordinal = this.i.ordinal();
            if (ordinal == 0) {
                i = 0;
            } else if (ordinal != 1) {
                return;
            } else {
                i = 100;
            }
            this.f44041h = i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.drawableStateChanged();
            int colorForState = this.f44035b.getColorForState(getDrawableState(), 0);
            if (this.f44036c != colorForState) {
                this.f44036c = colorForState;
                invalidate();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f();
            post(this.n);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            removeCallbacks(this.n);
        }
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f44041h : invokeV.intValue;
    }

    public s2 getProgressType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : (s2) invokeV.objValue;
    }

    public long getTimeMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : invokeV.longValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            getDrawingRect(this.k);
            int width = this.k.height() > this.k.width() ? this.k.width() : this.k.height();
            int colorForState = this.f44035b.getColorForState(getDrawableState(), 0);
            this.f44039f.setStyle(Paint.Style.FILL);
            this.f44039f.setColor(colorForState);
            canvas.drawCircle(this.k.centerX(), this.k.centerY(), (width / 2) - this.a, this.f44039f);
            TextPaint paint = getPaint();
            paint.setColor(getCurrentTextColor());
            paint.setAntiAlias(true);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(getText().toString(), this.k.centerX(), this.k.centerY() - ((paint.ascent() + paint.descent()) / 2.0f), paint);
            this.f44039f.setColor(this.f44037d);
            this.f44039f.setStyle(Paint.Style.STROKE);
            this.f44039f.setStrokeWidth(this.f44038e);
            this.f44039f.setAntiAlias(true);
            int i = this.f44038e;
            int i2 = this.a;
            int i3 = i + i2;
            RectF rectF = this.f44040g;
            Rect rect = this.k;
            int i4 = i3 / 2;
            int i5 = (rect.top - i3) + i2 + i;
            Rect rect2 = this.k;
            rectF.set(rect.left + i4, r0.a(getContext(), 0.4f) + i5, rect2.right - i4, (((rect2.bottom + i3) - this.a) - this.f44038e) - r0.a(getContext(), 0.5f));
            canvas.drawArc(this.f44040g, -90.0f, (this.f44041h * (-360)) / 100, false, this.f44039f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int i3 = (this.a + this.f44038e) * 4;
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (measuredWidth <= measuredHeight) {
                measuredWidth = measuredHeight;
            }
            int i4 = measuredWidth + i3;
            setMeasuredDimension(i4, i4);
        }
    }

    public void setInCircleColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f44035b = ColorStateList.valueOf(i);
            invalidate();
        }
    }

    public void setOutLineColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            invalidate();
        }
    }

    public void setOutLineWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.a = i;
            invalidate();
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            if (i > 100) {
                i = 100;
            } else if (i < 0) {
                i = 0;
            }
            this.f44041h = i;
            invalidate();
        }
    }

    public void setProgressColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.f44037d = i;
            invalidate();
        }
    }

    public void setProgressLineWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.f44038e = i;
            invalidate();
        }
    }

    public void setProgressType(s2 s2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, s2Var) == null) {
            this.i = s2Var;
            d();
            invalidate();
        }
    }

    public void setTimeMillis(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.j = j;
            invalidate();
        }
    }
}
