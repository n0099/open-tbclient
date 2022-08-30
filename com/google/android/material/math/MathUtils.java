package com.google.android.material.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class MathUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DEFAULT_EPSILON = 1.0E-4f;
    public transient /* synthetic */ FieldHolder $fh;

    public MathUtils() {
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

    public static float dist(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? (float) Math.hypot(f3 - f, f4 - f2) : invokeCommon.floatValue;
    }

    public static float distanceToFurthestCorner(float f, float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) ? max(dist(f, f2, f3, f4), dist(f, f2, f5, f4), dist(f, f2, f5, f6), dist(f, f2, f3, f6)) : invokeCommon.floatValue;
    }

    public static float floorMod(float f, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Float.valueOf(f), Integer.valueOf(i)})) == null) {
            float f2 = i;
            int i2 = (int) (f / f2);
            if (Math.signum(f) * f2 < 0.0f && i2 * i != f) {
                i2--;
            }
            return f - (i2 * i);
        }
        return invokeCommon.floatValue;
    }

    public static boolean geq(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? f + f3 >= f2 : invokeCommon.booleanValue;
    }

    public static float lerp(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? ((1.0f - f3) * f) + (f3 * f2) : invokeCommon.floatValue;
    }

    public static float max(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? (f <= f2 || f <= f3 || f <= f4) ? (f2 <= f3 || f2 <= f4) ? f3 > f4 ? f3 : f4 : f2 : f : invokeCommon.floatValue;
    }

    public static int floorMod(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2)) == null) {
            int i3 = i / i2;
            if ((i ^ i2) < 0 && i3 * i2 != i) {
                i3--;
            }
            return i - (i3 * i2);
        }
        return invokeII.intValue;
    }
}
