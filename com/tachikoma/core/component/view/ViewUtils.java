package com.tachikoma.core.component.view;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ViewUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ViewUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Drawable generateBackgroundWithShadow(View view, int i2, float f2, int i3, int i4, float f3, int i5) {
        InterceptResult invokeCommon;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{view, Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f3), Integer.valueOf(i5)})) == null) {
            float f4 = 2.0f * f2;
            int i7 = (int) f3;
            float[] fArr = {f4, f4, f4, f4, f4, f4, f4, f4};
            Rect rect = new Rect();
            rect.left = i7;
            rect.right = i7;
            if (i5 == 17) {
                rect.top = i7;
                rect.bottom = i7;
                i6 = 0;
            } else if (i5 != 48) {
                rect.top = i7;
                rect.bottom = i7 * 2;
                i6 = i7 / 3;
            } else {
                rect.top = i7 * 2;
                rect.bottom = i7;
                i6 = (i7 * (-1)) / 3;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            shapeDrawable.setPadding(rect);
            shapeDrawable.getPaint().setColor(i2);
            shapeDrawable.getPaint().setShadowLayer(f2, i4, i6, i3);
            view.setLayerType(1, null);
            shapeDrawable.setShape(new RoundRectShape(fArr, null, null));
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, view.getBackground()});
            int i8 = i7 * 2;
            layerDrawable.setLayerInset(0, i8, i8, i7, i8);
            return layerDrawable;
        }
        return (Drawable) invokeCommon.objValue;
    }
}
