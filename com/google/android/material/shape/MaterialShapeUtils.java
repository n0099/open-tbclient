package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.ViewUtils;
/* loaded from: classes7.dex */
public class MaterialShapeUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MaterialShapeUtils() {
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

    public static CornerTreatment createDefaultCornerTreatment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new RoundedCornerTreatment();
        }
        return (CornerTreatment) invokeV.objValue;
    }

    public static EdgeTreatment createDefaultEdgeTreatment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new EdgeTreatment();
        }
        return (EdgeTreatment) invokeV.objValue;
    }

    public static CornerTreatment createCornerTreatment(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    return createDefaultCornerTreatment();
                }
                return new CutCornerTreatment();
            }
            return new RoundedCornerTreatment();
        }
        return (CornerTreatment) invokeI.objValue;
    }

    public static void setParentAbsoluteElevation(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, view2) == null) {
            Drawable background = view2.getBackground();
            if (background instanceof MaterialShapeDrawable) {
                setParentAbsoluteElevation(view2, (MaterialShapeDrawable) background);
            }
        }
    }

    public static void setElevation(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(InputDeviceCompat.SOURCE_TRACKBALL, null, view2, f) == null) {
            Drawable background = view2.getBackground();
            if (background instanceof MaterialShapeDrawable) {
                ((MaterialShapeDrawable) background).setElevation(f);
            }
        }
    }

    public static void setParentAbsoluteElevation(View view2, MaterialShapeDrawable materialShapeDrawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, view2, materialShapeDrawable) == null) && materialShapeDrawable.isElevationOverlayEnabled()) {
            materialShapeDrawable.setParentAbsoluteElevation(ViewUtils.getParentAbsoluteElevation(view2));
        }
    }
}
