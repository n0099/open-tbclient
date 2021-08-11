package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes2.dex */
public class RandomUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final Random RANDOM;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1288846312, "Lorg/apache/commons/lang3/RandomUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1288846312, "Lorg/apache/commons/lang3/RandomUtils;");
                return;
            }
        }
        RANDOM = new Random();
    }

    public RandomUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean nextBoolean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? RANDOM.nextBoolean() : invokeV.booleanValue;
    }

    public static byte[] nextBytes(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            Validate.isTrue(i2 >= 0, "Count cannot be negative.", new Object[0]);
            byte[] bArr = new byte[i2];
            RANDOM.nextBytes(bArr);
            return bArr;
        }
        return (byte[]) invokeI.objValue;
    }

    public static double nextDouble(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) {
            Validate.isTrue(d3 >= d2, "Start value must be smaller or equal to end value.", new Object[0]);
            Validate.isTrue(d2 >= 0.0d, "Both range values must be non-negative.", new Object[0]);
            return d2 == d3 ? d2 : d2 + ((d3 - d2) * RANDOM.nextDouble());
        }
        return invokeCommon.doubleValue;
    }

    public static float nextFloat(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            Validate.isTrue(f3 >= f2, "Start value must be smaller or equal to end value.", new Object[0]);
            Validate.isTrue(f2 >= 0.0f, "Both range values must be non-negative.", new Object[0]);
            return f2 == f3 ? f2 : f2 + ((f3 - f2) * RANDOM.nextFloat());
        }
        return invokeCommon.floatValue;
    }

    public static int nextInt(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65545, null, i2, i3)) == null) {
            Validate.isTrue(i3 >= i2, "Start value must be smaller or equal to end value.", new Object[0]);
            Validate.isTrue(i2 >= 0, "Both range values must be non-negative.", new Object[0]);
            return i2 == i3 ? i2 : i2 + RANDOM.nextInt(i3 - i2);
        }
        return invokeII.intValue;
    }

    public static long nextLong(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            Validate.isTrue(j3 >= j2, "Start value must be smaller or equal to end value.", new Object[0]);
            Validate.isTrue(j2 >= 0, "Both range values must be non-negative.", new Object[0]);
            return j2 == j3 ? j2 : (long) nextDouble(j2, j3);
        }
        return invokeCommon.longValue;
    }

    public static double nextDouble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? nextDouble(0.0d, Double.MAX_VALUE) : invokeV.doubleValue;
    }

    public static float nextFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? nextFloat(0.0f, Float.MAX_VALUE) : invokeV.floatValue;
    }

    public static int nextInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? nextInt(0, Integer.MAX_VALUE) : invokeV.intValue;
    }

    public static long nextLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? nextLong(0L, Long.MAX_VALUE) : invokeV.longValue;
    }
}
