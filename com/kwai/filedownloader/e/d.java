package com.kwai.filedownloader.e;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static boolean awL;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1185680642, "Lcom/kwai/filedownloader/e/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1185680642, "Lcom/kwai/filedownloader/e/d;");
        }
    }

    public static void a(int i, Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), obj, str, objArr}) == null) {
            a(i, obj, null, str, objArr);
        }
    }

    public static void a(int i, Object obj, Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), obj, th, str, objArr}) == null) {
            if ((i >= 5) || awL) {
                Log.println(i, h(obj), f.h(str, objArr));
                if (th != null) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(Object obj, Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, obj, th, str, objArr) == null) {
            a(6, obj, th, str, objArr);
        }
    }

    public static void c(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str, objArr) == null) {
            a(6, obj, str, objArr);
        }
    }

    public static void d(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, obj, str, objArr) == null) {
            a(4, obj, str, objArr);
        }
    }

    public static void e(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, obj, str, objArr) == null) {
            a(3, obj, str, objArr);
        }
    }

    public static void f(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, obj, str, objArr) == null) {
            a(5, obj, str, objArr);
        }
    }

    public static void g(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, obj, str, objArr) == null) {
            a(2, obj, str, objArr);
        }
    }

    public static String h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, obj)) == null) {
            StringBuilder sb = new StringBuilder("FileDownloader.");
            sb.append((obj instanceof Class ? (Class) obj : obj.getClass()).getSimpleName());
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
