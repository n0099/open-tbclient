package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class JinniuCouponLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public float b;
    public float c;
    public Rect d;
    public RectF e;
    public RectF f;
    public RectF g;
    public RectF h;
    public Path i;
    @ColorInt
    public int j;
    @ColorInt
    public int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JinniuCouponLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Paint();
        this.b = 4.0f;
        this.c = 10.0f;
        this.d = new Rect();
        this.e = new RectF();
        this.f = new RectF();
        this.g = new RectF();
        this.h = new RectF();
        this.i = new Path();
        this.j = Color.parseColor("#FFFE3666");
        this.k = Color.parseColor("#FFFD7200");
        a(context, null, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JinniuCouponLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Paint();
        this.b = 4.0f;
        this.c = 10.0f;
        this.d = new Rect();
        this.e = new RectF();
        this.f = new RectF();
        this.g = new RectF();
        this.h = new RectF();
        this.i = new Path();
        this.j = Color.parseColor("#FFFE3666");
        this.k = Color.parseColor("#FFFD7200");
        a(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JinniuCouponLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.b = 4.0f;
        this.c = 10.0f;
        this.d = new Rect();
        this.e = new RectF();
        this.f = new RectF();
        this.g = new RectF();
        this.h = new RectF();
        this.i = new Path();
        this.j = Color.parseColor("#FFFE3666");
        this.k = Color.parseColor("#FFFD7200");
        a(context, attributeSet, i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 21)
    public JinniuCouponLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = new Paint();
        this.b = 4.0f;
        this.c = 10.0f;
        this.d = new Rect();
        this.e = new RectF();
        this.f = new RectF();
        this.g = new RectF();
        this.h = new RectF();
        this.i = new Path();
        this.j = Color.parseColor("#FFFE3666");
        this.k = Color.parseColor("#FFFD7200");
        a(context, attributeSet, i);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, this, context, attributeSet, i) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040371, R.attr.obfuscated_res_0x7f0403a0}, i, 0);
            this.c = obtainStyledAttributes.getDimension(0, 4.0f);
            this.b = obtainStyledAttributes.getDimension(1, 10.0f);
            obtainStyledAttributes.recycle();
            this.a.setAntiAlias(true);
        }
    }

    private void a(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, this, path, rectF, rectF2, rectF3) == null) {
            path.reset();
            RectF rectF4 = this.e;
            path.moveTo(rectF4.left, rectF4.top + this.c);
            this.h.set(rectF);
            RectF rectF5 = this.h;
            float f = rectF5.top;
            float f2 = this.c;
            rectF5.bottom = f + (f2 * 2.0f);
            rectF5.right = rectF5.left + (f2 * 2.0f);
            path.arcTo(rectF5, 180.0f, 90.0f);
            path.lineTo(rectF2.left, rectF2.top);
            path.arcTo(rectF2, -180.0f, -180.0f);
            path.lineTo(rectF.width() - this.c, rectF.top);
            this.h.set(rectF);
            RectF rectF6 = this.h;
            float f3 = rectF6.right;
            float f4 = this.c;
            rectF6.left = f3 - (f4 * 2.0f);
            rectF6.bottom = rectF6.top + (f4 * 2.0f);
            path.arcTo(rectF6, 270.0f, 90.0f);
            this.h.set(rectF);
            RectF rectF7 = this.h;
            float f5 = rectF7.right;
            float f6 = this.c;
            rectF7.left = f5 - (f6 * 2.0f);
            rectF7.top = rectF7.bottom - (f6 * 2.0f);
            path.arcTo(rectF7, 0.0f, 90.0f);
            path.lineTo(rectF3.right, rectF3.bottom);
            path.arcTo(rectF3, 0.0f, -180.0f);
            path.lineTo(rectF.left + this.c, rectF.bottom);
            this.h.set(rectF);
            RectF rectF8 = this.h;
            float f7 = rectF8.left;
            float f8 = this.c;
            rectF8.right = f7 + (f8 * 2.0f);
            rectF8.top = rectF8.bottom - (f8 * 2.0f);
            path.arcTo(rectF8, 90.0f, 90.0f);
        }
    }

    private void setGradientPaint(RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, rectF) == null) {
            this.a.setShader(new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.bottom, this.j, this.k, Shader.TileMode.CLAMP));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.d.setEmpty();
            getDrawingRect(this.d);
            this.e.set(this.d);
            if (getChildCount() > 1) {
                View childAt = getChildAt(0);
                RectF rectF = this.f;
                if (rectF == null) {
                    this.f = new RectF();
                } else {
                    rectF.setEmpty();
                }
                RectF rectF2 = this.g;
                if (rectF2 == null) {
                    this.g = new RectF();
                } else {
                    rectF2.setEmpty();
                }
                Rect rect = this.d;
                float measuredWidth = rect.left + childAt.getMeasuredWidth();
                RectF rectF3 = this.f;
                int i = rect.top;
                float f = this.b;
                rectF3.set(measuredWidth, i - f, (2.0f * f) + measuredWidth, i + f);
                RectF rectF4 = this.g;
                RectF rectF5 = this.f;
                float f2 = rectF5.left;
                int i2 = this.d.bottom;
                float f3 = this.b;
                rectF4.set(f2, i2 - f3, rectF5.right, i2 + f3);
                a(this.i, this.e, this.f, this.g);
                setGradientPaint(this.e);
                canvas.drawPath(this.i, this.a);
            }
            super.dispatchDraw(canvas);
        }
    }
}
