package com.tachikoma.core.component.listview;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.listview.TKPagerIndicatorDecoration;
/* loaded from: classes7.dex */
public class TKNumberIndicator implements TKPagerIndicatorDecoration.IIndicatorRender {
    public static /* synthetic */ Interceptable $ic;
    public static final float DP;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mActiveColor;
    public int mItemWidth;
    public int mTextSize;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2041427504, "Lcom/tachikoma/core/component/listview/TKNumberIndicator;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2041427504, "Lcom/tachikoma/core/component/listview/TKNumberIndicator;");
                return;
            }
        }
        DP = Resources.getSystem().getDisplayMetrics().density;
    }

    public TKNumberIndicator(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTextSize = (int) getIndicatorHeight();
        this.mItemWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        this.mActiveColor = i;
    }

    @Override // com.tachikoma.core.component.listview.TKPagerIndicatorDecoration.IIndicatorRender
    public void drawHighlights(float f, float f2, float f3, float f4, int i, int i2, Paint paint, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i), Integer.valueOf(i2), paint, canvas}) == null) {
            String str = (i2 + 1) + "/" + i;
            canvas.drawText(str, 0, str.length(), (this.mItemWidth - getIndicatorWidth()) / 2.0f, f2, paint);
        }
    }

    @Override // com.tachikoma.core.component.listview.TKPagerIndicatorDecoration.IIndicatorRender
    public void drawInactiveIndicators(float f, float f2, float f3, float f4, Paint paint, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), paint, canvas}) == null) {
        }
    }

    @Override // com.tachikoma.core.component.listview.TKPagerIndicatorDecoration.IIndicatorRender
    public float getIndicatorHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? DP * 16.0f : invokeV.floatValue;
    }

    @Override // com.tachikoma.core.component.listview.TKPagerIndicatorDecoration.IIndicatorRender
    public float getIndicatorPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? DP * 4.0f : invokeV.floatValue;
    }

    @Override // com.tachikoma.core.component.listview.TKPagerIndicatorDecoration.IIndicatorRender
    public int getIndicatorTopMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (int) (getIndicatorHeight() * (-1.0f) * 2.0f) : invokeV.intValue;
    }

    @Override // com.tachikoma.core.component.listview.TKPagerIndicatorDecoration.IIndicatorRender
    public float getIndicatorWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? DP * 16.0f : invokeV.floatValue;
    }

    @Override // com.tachikoma.core.component.listview.TKPagerIndicatorDecoration.IIndicatorRender
    public Paint getPaint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Paint paint = new Paint();
            paint.setTextSize(this.mTextSize);
            paint.setColor(this.mActiveColor);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            return paint;
        }
        return (Paint) invokeV.objValue;
    }

    @Override // com.tachikoma.core.component.listview.TKPagerIndicatorDecoration.IIndicatorRender
    public void setItemWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.mItemWidth = i;
        }
    }

    @Override // com.tachikoma.core.component.listview.TKPagerIndicatorDecoration.IIndicatorRender
    public void setTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.mTextSize = (int) (i * DP);
        }
    }
}
