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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.resources.MaterialAttributes;
/* loaded from: classes11.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int i2, @IntRange(from = 0, to = 255) int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i2, i3)) == null) ? ColorUtils.setAlphaComponent(i2, (Color.alpha(i2) * i3) / 255) : invokeII.intValue;
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, view, i2)) == null) ? MaterialAttributes.resolveOrThrow(view, i2) : invokeLI.intValue;
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i2, @AttrRes int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, view, i2, i3)) == null) ? layer(view, i2, i3, 1.0f) : invokeLII.intValue;
    }

    @ColorInt
    public static int getColor(Context context, @AttrRes int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, context, i2, str)) == null) ? MaterialAttributes.resolveOrThrow(context, i2, str) : invokeLIL.intValue;
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i2, @AttrRes int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) ? layer(getColor(view, i2), getColor(view, i3), f2) : invokeCommon.intValue;
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i2, @ColorInt int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.AD_TEXT_ID, null, view, i2, i3)) == null) ? getColor(view.getContext(), i2, i3) : invokeLII.intValue;
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @AttrRes int i2, @ColorInt int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, context, i2, i3)) == null) {
            TypedValue resolve = MaterialAttributes.resolve(context, i2);
            return resolve != null ? resolve.data : i3;
        }
        return invokeLII.intValue;
    }

    @ColorInt
    public static int layer(@ColorInt int i2, @ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) ? layer(i2, ColorUtils.setAlphaComponent(i3, Math.round(Color.alpha(i3) * f2))) : invokeCommon.intValue;
    }

    @ColorInt
    public static int layer(@ColorInt int i2, @ColorInt int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3)) == null) ? ColorUtils.compositeColors(i3, i2) : invokeII.intValue;
    }
}
