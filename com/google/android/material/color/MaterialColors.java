package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.resources.MaterialAttributes;
/* loaded from: classes7.dex */
public class MaterialColors {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    public transient /* synthetic */ FieldHolder $fh;

    public MaterialColors() {
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

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int i, @IntRange(from = 0, to = 255) int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i, i2)) == null) ? ColorUtils.setAlphaComponent(i, (Color.alpha(i) * i2) / 255) : invokeII.intValue;
    }

    @ColorInt
    public static int getColor(@NonNull View view2, @AttrRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, view2, i)) == null) ? MaterialAttributes.resolveOrThrow(view2, i) : invokeLI.intValue;
    }

    @ColorInt
    public static int layer(@NonNull View view2, @AttrRes int i, @AttrRes int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, view2, i, i2)) == null) ? layer(view2, i, i2, 1.0f) : invokeLII.intValue;
    }

    @ColorInt
    public static int getColor(Context context, @AttrRes int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, context, i, str)) == null) ? MaterialAttributes.resolveOrThrow(context, i, str) : invokeLIL.intValue;
    }

    @ColorInt
    public static int layer(@NonNull View view2, @AttrRes int i, @AttrRes int i2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)})) == null) ? layer(getColor(view2, i), getColor(view2, i2), f) : invokeCommon.intValue;
    }

    @ColorInt
    public static int getColor(@NonNull View view2, @AttrRes int i, @ColorInt int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, view2, i, i2)) == null) ? getColor(view2.getContext(), i, i2) : invokeLII.intValue;
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @AttrRes int i, @ColorInt int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, context, i, i2)) == null) {
            TypedValue resolve = MaterialAttributes.resolve(context, i);
            return resolve != null ? resolve.data : i2;
        }
        return invokeLII.intValue;
    }

    @ColorInt
    public static int layer(@ColorInt int i, @ColorInt int i2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)})) == null) ? layer(i, ColorUtils.setAlphaComponent(i2, Math.round(Color.alpha(i2) * f))) : invokeCommon.intValue;
    }

    @ColorInt
    public static int layer(@ColorInt int i, @ColorInt int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65542, null, i, i2)) == null) ? ColorUtils.compositeColors(i2, i) : invokeII.intValue;
    }
}
