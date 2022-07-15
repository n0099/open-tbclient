package com.repackage;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class t80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65536, null, context, f)) == null) ? (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static float b(Resources resources, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, resources, f)) == null) ? (f * resources.getDisplayMetrics().density) + 0.5f : invokeLF.floatValue;
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        return invokeL.intValue;
    }

    public static boolean d(View view2, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, view2, i, i2)) == null) {
            if (view2 == null) {
                return false;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            return i2 >= i4 && i2 <= view2.getMeasuredHeight() + i4 && i >= i3 && i <= view2.getMeasuredWidth() + i3;
        }
        return invokeLII.booleanValue;
    }

    public static int e(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(InputDeviceCompat.SOURCE_TRACKBALL, null, context, f)) == null) ? (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }
}
