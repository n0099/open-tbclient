package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.ViewUtils;
/* loaded from: classes2.dex */
public class MaterialShapeUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MaterialShapeUtils() {
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

    @NonNull
    public static CornerTreatment createCornerTreatment(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return createDefaultCornerTreatment();
                }
                return new CutCornerTreatment();
            }
            return new RoundedCornerTreatment();
        }
        return (CornerTreatment) invokeI.objValue;
    }

    @NonNull
    public static CornerTreatment createDefaultCornerTreatment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new RoundedCornerTreatment() : (CornerTreatment) invokeV.objValue;
    }

    @NonNull
    public static EdgeTreatment createDefaultEdgeTreatment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new EdgeTreatment() : (EdgeTreatment) invokeV.objValue;
    }

    public static void setElevation(@NonNull View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(InputDeviceCompat.SOURCE_TRACKBALL, null, view, f2) == null) {
            Drawable background = view.getBackground();
            if (background instanceof MaterialShapeDrawable) {
                ((MaterialShapeDrawable) background).setElevation(f2);
            }
        }
    }

    public static void setParentAbsoluteElevation(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, view) == null) {
            Drawable background = view.getBackground();
            if (background instanceof MaterialShapeDrawable) {
                setParentAbsoluteElevation(view, (MaterialShapeDrawable) background);
            }
        }
    }

    public static void setParentAbsoluteElevation(@NonNull View view, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, view, materialShapeDrawable) == null) && materialShapeDrawable.isElevationOverlayEnabled()) {
            materialShapeDrawable.setParentAbsoluteElevation(ViewUtils.getParentAbsoluteElevation(view));
        }
    }
}
