package com.fun.ad.sdk.internal.api.utils;

import android.content.Context;
import android.util.TypedValue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
/* loaded from: classes3.dex */
public class PxUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PxUtils() {
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

    public static int dp2px(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65537, null, f2)) == null) ? (int) ((f2 * FunAdSdk.getAppContext().getResources().getDisplayMetrics().density) + 0.5f) : invokeF.intValue;
    }

    public static int dpToPx(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, context, i2)) == null) ? (int) TypedValue.applyDimension(1, i2, context.getApplicationContext().getResources().getDisplayMetrics()) : invokeLI.intValue;
    }

    public static int getDeviceHeightInPixel(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context.getApplicationContext().getResources().getDisplayMetrics().heightPixels : invokeL.intValue;
    }

    public static int getDeviceWidthInPixel(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? context.getApplicationContext().getResources().getDisplayMetrics().widthPixels : invokeL.intValue;
    }

    public static int pxToDp(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, context, i2)) == null) ? (int) ((i2 / context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f) : invokeLI.intValue;
    }
}
