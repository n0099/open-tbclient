package com.facebook.common.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class HashCodeUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int X = 31;
    public transient /* synthetic */ FieldHolder $fh;

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

    public static int hashCode(@Nullable Object obj) {
        InterceptResult invokeL;
        int hashCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) {
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            return hashCode(hashCode);
        }
        return invokeL.intValue;
    }

    public static int hashCode(@Nullable Object obj, @Nullable Object obj2) {
        InterceptResult invokeLL;
        int hashCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, obj, obj2)) == null) {
            int i = 0;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            if (obj2 != null) {
                i = obj2.hashCode();
            }
            return hashCode(hashCode, i);
        }
        return invokeLL.intValue;
    }

    public static int hashCode(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        InterceptResult invokeLLL;
        int hashCode;
        int hashCode2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, obj, obj2, obj3)) == null) {
            int i = 0;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            if (obj2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = obj2.hashCode();
            }
            if (obj3 != null) {
                i = obj3.hashCode();
            }
            return hashCode(hashCode, hashCode2, i);
        }
        return invokeLLL.intValue;
    }

    public static int hashCode(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4) {
        InterceptResult invokeLLLL;
        int hashCode;
        int hashCode2;
        int hashCode3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, obj, obj2, obj3, obj4)) == null) {
            int i = 0;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            if (obj2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = obj2.hashCode();
            }
            if (obj3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = obj3.hashCode();
            }
            if (obj4 != null) {
                i = obj4.hashCode();
            }
            return hashCode(hashCode, hashCode2, hashCode3, i);
        }
        return invokeLLLL.intValue;
    }

    public static int hashCode(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5) {
        InterceptResult invokeLLLLL;
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65547, null, obj, obj2, obj3, obj4, obj5)) == null) {
            int i = 0;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            if (obj2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = obj2.hashCode();
            }
            if (obj3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = obj3.hashCode();
            }
            if (obj4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = obj4.hashCode();
            }
            if (obj5 != null) {
                i = obj5.hashCode();
            }
            return hashCode(hashCode, hashCode2, hashCode3, hashCode4, i);
        }
        return invokeLLLLL.intValue;
    }

    public static int hashCode(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6) {
        InterceptResult invokeCommon;
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{obj, obj2, obj3, obj4, obj5, obj6})) == null) {
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            if (obj2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = obj2.hashCode();
            }
            if (obj3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = obj3.hashCode();
            }
            if (obj4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = obj4.hashCode();
            }
            if (obj5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = obj5.hashCode();
            }
            if (obj6 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = obj6.hashCode();
            }
            return hashCode(hashCode, hashCode2, hashCode3, hashCode4, hashCode5, hashCode6);
        }
        return invokeCommon.intValue;
    }
}
