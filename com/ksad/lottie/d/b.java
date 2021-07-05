package com.ksad.lottie.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static float a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65536, null, f2)) == null) ? f2 <= 0.0031308f ? f2 * 12.92f : (float) ((Math.pow(f2, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d) : invokeF.floatValue;
    }

    public static int a(float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            float f3 = ((i2 >> 24) & 255) / 255.0f;
            float b2 = b(((i2 >> 16) & 255) / 255.0f);
            float b3 = b(((i2 >> 8) & 255) / 255.0f);
            float b4 = b((i2 & 255) / 255.0f);
            return (Math.round(a(b2 + ((b(((i3 >> 16) & 255) / 255.0f) - b2) * f2)) * 255.0f) << 16) | (Math.round((f3 + (((((i3 >> 24) & 255) / 255.0f) - f3) * f2)) * 255.0f) << 24) | (Math.round(a(b3 + ((b(((i3 >> 8) & 255) / 255.0f) - b3) * f2)) * 255.0f) << 8) | Math.round(a(b4 + (f2 * (b((i3 & 255) / 255.0f) - b4))) * 255.0f);
        }
        return invokeCommon.intValue;
    }

    public static float b(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65538, null, f2)) == null) ? f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d) : invokeF.floatValue;
    }
}
