package com.google.android.material.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class MathUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DEFAULT_EPSILON = 1.0E-4f;
    public transient /* synthetic */ FieldHolder $fh;

    public MathUtils() {
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

    public static float dist(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) ? (float) Math.hypot(f4 - f2, f5 - f3) : invokeCommon.floatValue;
    }

    public static float distanceToFurthestCorner(float f2, float f3, float f4, float f5, float f6, float f7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)})) == null) ? max(dist(f2, f3, f4, f5), dist(f2, f3, f6, f5), dist(f2, f3, f6, f7), dist(f2, f3, f4, f7)) : invokeCommon.floatValue;
    }

    public static float floorMod(float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)})) == null) {
            float f3 = i2;
            int i3 = (int) (f2 / f3);
            if (Math.signum(f2) * f3 < 0.0f && i3 * i2 != f2) {
                i3--;
            }
            return f2 - (i3 * i2);
        }
        return invokeCommon.floatValue;
    }

    public static boolean geq(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? f2 + f4 >= f3 : invokeCommon.booleanValue;
    }

    public static float lerp(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? ((1.0f - f4) * f2) + (f4 * f3) : invokeCommon.floatValue;
    }

    public static float max(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) ? (f2 <= f3 || f2 <= f4 || f2 <= f5) ? (f3 <= f4 || f3 <= f5) ? f4 > f5 ? f4 : f5 : f3 : f2 : invokeCommon.floatValue;
    }

    public static int floorMod(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3)) == null) {
            int i4 = i2 / i3;
            if ((i2 ^ i3) < 0 && i4 * i3 != i2) {
                i4--;
            }
            return i2 - (i4 * i3);
        }
        return invokeII.intValue;
    }
}
