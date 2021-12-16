package org.apache.commons.lang3.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.Validate;
/* loaded from: classes4.dex */
public class IEEE754rUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public IEEE754rUtils() {
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

    public static double max(double... dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, dArr)) == null) {
            if (dArr != null) {
                Validate.isTrue(dArr.length != 0, "Array cannot be empty.", new Object[0]);
                double d2 = dArr[0];
                for (int i2 = 1; i2 < dArr.length; i2++) {
                    d2 = max(dArr[i2], d2);
                }
                return d2;
            }
            throw new IllegalArgumentException("The Array must not be null");
        }
        return invokeL.doubleValue;
    }

    public static double min(double... dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, dArr)) == null) {
            if (dArr != null) {
                Validate.isTrue(dArr.length != 0, "Array cannot be empty.", new Object[0]);
                double d2 = dArr[0];
                for (int i2 = 1; i2 < dArr.length; i2++) {
                    d2 = min(dArr[i2], d2);
                }
                return d2;
            }
            throw new IllegalArgumentException("The Array must not be null");
        }
        return invokeL.doubleValue;
    }

    public static float max(float... fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, fArr)) == null) {
            if (fArr != null) {
                Validate.isTrue(fArr.length != 0, "Array cannot be empty.", new Object[0]);
                float f2 = fArr[0];
                for (int i2 = 1; i2 < fArr.length; i2++) {
                    f2 = max(fArr[i2], f2);
                }
                return f2;
            }
            throw new IllegalArgumentException("The Array must not be null");
        }
        return invokeL.floatValue;
    }

    public static float min(float... fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, fArr)) == null) {
            if (fArr != null) {
                Validate.isTrue(fArr.length != 0, "Array cannot be empty.", new Object[0]);
                float f2 = fArr[0];
                for (int i2 = 1; i2 < fArr.length; i2++) {
                    f2 = min(fArr[i2], f2);
                }
                return f2;
            }
            throw new IllegalArgumentException("The Array must not be null");
        }
        return invokeL.floatValue;
    }

    public static double max(double d2, double d3, double d4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)})) == null) ? max(max(d2, d3), d4) : invokeCommon.doubleValue;
    }

    public static double min(double d2, double d3, double d4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)})) == null) ? min(min(d2, d3), d4) : invokeCommon.doubleValue;
    }

    public static double max(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) ? Double.isNaN(d2) ? d3 : Double.isNaN(d3) ? d2 : Math.max(d2, d3) : invokeCommon.doubleValue;
    }

    public static double min(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) ? Double.isNaN(d2) ? d3 : Double.isNaN(d3) ? d2 : Math.min(d2, d3) : invokeCommon.doubleValue;
    }

    public static float max(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? max(max(f2, f3), f4) : invokeCommon.floatValue;
    }

    public static float min(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? min(min(f2, f3), f4) : invokeCommon.floatValue;
    }

    public static float max(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? Float.isNaN(f2) ? f3 : Float.isNaN(f3) ? f2 : Math.max(f2, f3) : invokeCommon.floatValue;
    }

    public static float min(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? Float.isNaN(f2) ? f3 : Float.isNaN(f3) ? f2 : Math.min(f2, f3) : invokeCommon.floatValue;
    }
}
