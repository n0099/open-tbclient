package com.huawei.hms.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class Checker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Checker() {
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

    public static void assertHandlerThread(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, handler) == null) {
            assertHandlerThread(handler, "Must be called on the handler thread");
        }
    }

    public static void assertNonEmpty(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, str) != null) || !TextUtils.isEmpty(str)) {
            return;
        }
        throw new IllegalStateException("Given String is empty or null");
    }

    public static <T> T assertNonNull(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, t)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException("Null reference");
        }
        return (T) invokeL.objValue;
    }

    public static void assertNotUiThread(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, str) != null) || Looper.myLooper() != Looper.getMainLooper()) {
            return;
        }
        throw new IllegalStateException(str);
    }

    public static void assertUiThread(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65544, null, str) != null) || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new IllegalStateException(str);
    }

    public static String checkNonEmpty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return (String) invokeL.objValue;
    }

    public static <T> T checkNonNull(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, t)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException("Null reference");
        }
        return (T) invokeL.objValue;
    }

    public static int checkNonZero(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i)) == null) {
            if (i != 0) {
                return i;
            }
            throw new IllegalArgumentException("Given Integer is zero");
        }
        return invokeI.intValue;
    }

    public static long checkNotZero(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65551, null, j)) == null) {
            if (j != 0) {
                return j;
            }
            throw new IllegalArgumentException("Given Long is zero");
        }
        return invokeJ.longValue;
    }

    public static void assertHandlerThread(Handler handler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, handler, str) != null) || Looper.myLooper() == handler.getLooper()) {
            return;
        }
        throw new IllegalStateException(str);
    }

    public static void assertNonEmpty(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) != null) || !TextUtils.isEmpty(str)) {
            return;
        }
        throw new IllegalStateException(String.valueOf(str2));
    }

    public static <T> T assertNonNull(T t, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, t, str)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(String.valueOf(str));
        }
        return (T) invokeLL.objValue;
    }

    public static String checkNonEmpty(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            throw new IllegalArgumentException(String.valueOf(str2));
        }
        return (String) invokeLL.objValue;
    }

    public static <T> T checkNonNull(T t, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, t, str)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(String.valueOf(str));
        }
        return (T) invokeLL.objValue;
    }

    public static int checkNonZero(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65550, null, i, str)) == null) {
            if (i != 0) {
                return i;
            }
            throw new IllegalArgumentException(String.valueOf(str));
        }
        return invokeIL.intValue;
    }

    public static long checkNotZero(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65552, null, j, str)) == null) {
            if (j != 0) {
                return j;
            }
            throw new IllegalArgumentException(String.valueOf(str));
        }
        return invokeJL.longValue;
    }
}
