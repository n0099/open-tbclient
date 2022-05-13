package com.repackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class f61 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, Drawable drawable, PorterDuff.Mode mode, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65536, null, context, drawable, mode, i) == null) || context == null || drawable == null) {
            return;
        }
        b(context, drawable, mode, i, e(context));
    }

    public static void b(Context context, Drawable drawable, PorterDuff.Mode mode, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, drawable, mode, Integer.valueOf(i), Integer.valueOf(i2)}) == null) || context == null || drawable == null) {
            return;
        }
        if (i >= 0 && i < 255) {
            i2 = Color.argb((Color.alpha(i2) * i) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
        }
        drawable.setColorFilter(i2, mode);
    }

    public static void c(Context context, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, drawable) == null) {
            d(context, drawable, 255);
        }
    }

    public static void d(Context context, Drawable drawable, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, null, context, drawable, i) == null) {
            a(context, drawable, PorterDuff.Mode.SRC_ATOP, i);
        }
    }

    public static int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? context.getResources().getColor(R.color.obfuscated_res_0x7f060851) : invokeL.intValue;
    }
}
