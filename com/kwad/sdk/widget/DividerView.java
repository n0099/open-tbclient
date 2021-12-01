package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
/* loaded from: classes2.dex */
public class DividerView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f59673b = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Paint f59674c;

    /* renamed from: d  reason: collision with root package name */
    public int f59675d;

    /* renamed from: e  reason: collision with root package name */
    public int f59676e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1575344621, "Lcom/kwad/sdk/widget/DividerView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1575344621, "Lcom/kwad/sdk/widget/DividerView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DividerView(Context context) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ksad_DividerView, 0, 0);
        try {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DividerView_ksad_dashGap, 5);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DividerView_ksad_dashLength, 5);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DividerView_ksad_dashThickness, 3);
            this.f59676e = obtainStyledAttributes.getColor(R.styleable.ksad_DividerView_ksad_color, -16777216);
            this.f59675d = obtainStyledAttributes.getInt(R.styleable.ksad_DividerView_ksad_orientation, a);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.f59674c = paint;
            paint.setAntiAlias(true);
            this.f59674c.setColor(this.f59676e);
            this.f59674c.setStyle(Paint.Style.STROKE);
            this.f59674c.setStrokeWidth(dimensionPixelSize3);
            this.f59674c.setPathEffect(new DashPathEffect(new float[]{dimensionPixelSize2, dimensionPixelSize}, 0.0f));
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float width;
        float f2;
        float height;
        Paint paint;
        Canvas canvas2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (this.f59675d == a) {
                height = getHeight() * 0.5f;
                f3 = 0.0f;
                width = getWidth();
                paint = this.f59674c;
                canvas2 = canvas;
                f2 = height;
            } else {
                width = getWidth() * 0.5f;
                f2 = 0.0f;
                height = getHeight();
                paint = this.f59674c;
                canvas2 = canvas;
                f3 = width;
            }
            canvas2.drawLine(f3, f2, width, height, paint);
        }
    }

    public void setDividerColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f59676e = i2;
            this.f59674c.setColor(i2);
            postInvalidate();
        }
    }
}
