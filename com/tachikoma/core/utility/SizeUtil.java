package com.tachikoma.core.utility;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SizeUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SizeUtil() {
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

    public static int dp2Px(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65537, null, f)) == null) ? (int) ((TKContextUtil.getContext().getResources().getDisplayMetrics().density * f) + 0.5f) : invokeF.intValue;
    }

    public static int dp2Px(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? (int) ((TKContextUtil.getContext().getResources().getDisplayMetrics().density * i) + 0.5f) : invokeI.intValue;
    }

    public static int px2Dp(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65539, null, f)) == null) ? (int) (f / TKContextUtil.getContext().getResources().getDisplayMetrics().density) : invokeF.intValue;
    }

    public static int px2Dp(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? (int) (i / TKContextUtil.getContext().getResources().getDisplayMetrics().density) : invokeI.intValue;
    }

    public static float px2DpAsFloat(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65541, null, f)) == null) ? (f * 1.0f) / TKContextUtil.getContext().getResources().getDisplayMetrics().density : invokeF.floatValue;
    }
}
