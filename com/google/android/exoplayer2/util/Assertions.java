package com.google.android.exoplayer2.util;

import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class Assertions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Assertions() {
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

    public static void checkMainThread() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) != null) || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new IllegalStateException("Not in applications main thread");
    }

    public static void checkArgument(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65537, null, z) != null) || z) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static String checkNotEmpty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            throw new IllegalArgumentException();
        }
        return (String) invokeL.objValue;
    }

    public static Object checkNotNull(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) {
            if (obj != null) {
                return obj;
            }
            throw null;
        }
        return invokeL.objValue;
    }

    public static void checkState(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65545, null, z) != null) || z) {
            return;
        }
        throw new IllegalStateException();
    }

    public static void checkArgument(boolean z, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(65538, null, z, obj) != null) || z) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static String checkNotEmpty(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, obj)) == null) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return (String) invokeLL.objValue;
    }

    public static Object checkNotNull(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, obj, obj2)) == null) {
            if (obj != null) {
                return obj;
            }
            throw new NullPointerException(String.valueOf(obj2));
        }
        return invokeLL.objValue;
    }

    public static void checkState(boolean z, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(65546, null, z, obj) != null) || z) {
            return;
        }
        throw new IllegalStateException(String.valueOf(obj));
    }

    public static int checkIndex(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65539, null, i, i2, i3)) == null) {
            if (i >= i2 && i < i3) {
                return i;
            }
            throw new IndexOutOfBoundsException();
        }
        return invokeIII.intValue;
    }
}
