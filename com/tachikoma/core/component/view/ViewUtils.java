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
/* loaded from: classes7.dex */
public class ViewUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ViewUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Drawable generateBackgroundWithShadow(View view2, int i, float f, int i2, int i3, float f2, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{view2, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4)})) == null) {
            float f3 = 2.0f * f;
            int i6 = (int) f2;
            float[] fArr = {f3, f3, f3, f3, f3, f3, f3, f3};
            Rect rect = new Rect();
            rect.left = i6;
            rect.right = i6;
            if (i4 == 17) {
                rect.top = i6;
                rect.bottom = i6;
                i5 = 0;
            } else if (i4 != 48) {
                rect.top = i6;
                rect.bottom = i6 * 2;
                i5 = i6 / 3;
            } else {
                rect.top = i6 * 2;
                rect.bottom = i6;
                i5 = (i6 * (-1)) / 3;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            shapeDrawable.setPadding(rect);
            shapeDrawable.getPaint().setColor(i);
            shapeDrawable.getPaint().setShadowLayer(f, i3, i5, i2);
            view2.setLayerType(1, null);
            shapeDrawable.setShape(new RoundRectShape(fArr, null, null));
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, view2.getBackground()});
            int i7 = i6 * 2;
            layerDrawable.setLayerInset(0, i7, i7, i6, i7);
            return layerDrawable;
        }
        return (Drawable) invokeCommon.objValue;
    }
}
