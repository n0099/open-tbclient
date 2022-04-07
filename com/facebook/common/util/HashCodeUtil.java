package com.facebook.common.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class HashCodeUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int X = 31;
    public transient /* synthetic */ FieldHolder $fh;

    public HashCodeUtil() {
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

    public static int hashCode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? i + 31 : invokeI.intValue;
    }

    public static int hashCode(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) ? ((i + 31) * 31) + i2 : invokeII.intValue;
    }

    public static int hashCode(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65539, null, i, i2, i3)) == null) ? ((((i + 31) * 31) + i2) * 31) + i3 : invokeIII.intValue;
    }

    public static int hashCode(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2, i3, i4)) == null) ? ((((((i + 31) * 31) + i2) * 31) + i3) * 31) + i4 : invokeIIII.intValue;
    }

    public static int hashCode(int i, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) ? ((((((((i + 31) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5 : invokeCommon.intValue;
    }

    public static int hashCode(int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) ? ((((((((((i + 31) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i6 : invokeCommon.intValue;
    }

    public static int hashCode(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) {
            return hashCode(obj == null ? 0 : obj.hashCode());
        }
        return invokeL.intValue;
    }

    public static int hashCode(@Nullable Object obj, @Nullable Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, obj, obj2)) == null) {
            return hashCode(obj == null ? 0 : obj.hashCode(), obj2 != null ? obj2.hashCode() : 0);
        }
        return invokeLL.intValue;
    }

    public static int hashCode(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, obj, obj2, obj3)) == null) {
            return hashCode(obj == null ? 0 : obj.hashCode(), obj2 == null ? 0 : obj2.hashCode(), obj3 != null ? obj3.hashCode() : 0);
        }
        return invokeLLL.intValue;
    }

    public static int hashCode(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, obj, obj2, obj3, obj4)) == null) {
            return hashCode(obj == null ? 0 : obj.hashCode(), obj2 == null ? 0 : obj2.hashCode(), obj3 == null ? 0 : obj3.hashCode(), obj4 != null ? obj4.hashCode() : 0);
        }
        return invokeLLLL.intValue;
    }

    public static int hashCode(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65547, null, obj, obj2, obj3, obj4, obj5)) == null) {
            return hashCode(obj == null ? 0 : obj.hashCode(), obj2 == null ? 0 : obj2.hashCode(), obj3 == null ? 0 : obj3.hashCode(), obj4 == null ? 0 : obj4.hashCode(), obj5 != null ? obj5.hashCode() : 0);
        }
        return invokeLLLLL.intValue;
    }

    public static int hashCode(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{obj, obj2, obj3, obj4, obj5, obj6})) == null) {
            return hashCode(obj == null ? 0 : obj.hashCode(), obj2 == null ? 0 : obj2.hashCode(), obj3 == null ? 0 : obj3.hashCode(), obj4 == null ? 0 : obj4.hashCode(), obj5 == null ? 0 : obj5.hashCode(), obj6 == null ? 0 : obj6.hashCode());
        }
        return invokeCommon.intValue;
    }
}
