package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
/* loaded from: classes7.dex */
public final class Preconditions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Preconditions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new AssertionError("Uninstantiable");
    }

    public static void checkNotMainThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            checkNotMainThread("Must not be called on the main application thread");
        }
    }

    public static void checkArgument(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65537, null, z) != null) || z) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void checkMainThread(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, str) != null) || com.google.android.gms.common.util.zzb.zza()) {
            return;
        }
        throw new IllegalStateException(str);
    }

    @EnsuresNonNull({"#1"})
    public static String checkNotEmpty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return (String) invokeL.objValue;
    }

    public static void checkNotMainThread(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, str) != null) || !com.google.android.gms.common.util.zzb.zza()) {
            return;
        }
        throw new IllegalStateException(str);
    }

    @EnsuresNonNull({"#1"})
    public static Object checkNotNull(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, obj)) == null) {
            if (obj != null) {
                return obj;
            }
            throw new NullPointerException("null reference");
        }
        return invokeL.objValue;
    }

    public static int checkNotZero(int i) {
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

    public static void checkState(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65553, null, z) != null) || z) {
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

    public static void checkHandlerThread(Handler handler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, handler, str) != null) || Looper.myLooper() == handler.getLooper()) {
            return;
        }
        throw new IllegalStateException(str);
    }

    @EnsuresNonNull({"#1"})
    public static String checkNotEmpty(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, obj)) == null) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return (String) invokeLL.objValue;
    }

    @EnsuresNonNull({"#1"})
    public static Object checkNotNull(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, obj, obj2)) == null) {
            if (obj != null) {
                return obj;
            }
            throw new NullPointerException(String.valueOf(obj2));
        }
        return invokeLL.objValue;
    }

    public static int checkNotZero(int i, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65550, null, i, obj)) == null) {
            if (i != 0) {
                return i;
            }
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return invokeIL.intValue;
    }

    public static void checkState(boolean z, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(65554, null, z, obj) != null) || z) {
            return;
        }
        throw new IllegalStateException(String.valueOf(obj));
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), str, objArr}) != null) || z) {
            return;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static void checkState(boolean z, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65555, null, new Object[]{Boolean.valueOf(z), str, objArr}) != null) || z) {
            return;
        }
        throw new IllegalStateException(String.format(str, objArr));
    }

    public static void checkHandlerThread(Handler handler) {
        Looper myLooper;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler) == null) && (myLooper = Looper.myLooper()) != handler.getLooper()) {
            if (myLooper != null) {
                str = myLooper.getThread().getName();
            } else {
                str = "null current looper";
            }
            String name = handler.getLooper().getThread().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 36 + String.valueOf(str).length());
            sb.append("Must be called on ");
            sb.append(name);
            sb.append(" thread, but got ");
            sb.append(str);
            sb.append(".");
            throw new IllegalStateException(sb.toString());
        }
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

    public static long checkNotZero(long j, Object obj) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65552, null, j, obj)) == null) {
            if (j != 0) {
                return j;
            }
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return invokeJL.longValue;
    }
}
