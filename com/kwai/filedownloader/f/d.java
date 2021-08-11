package com.kwai.filedownloader.f;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f73864a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1185650851, "Lcom/kwai/filedownloader/f/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1185650851, "Lcom/kwai/filedownloader/f/d;");
        }
    }

    public static String a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("FileDownloader.");
            sb.append((obj instanceof Class ? (Class) obj : obj.getClass()).getSimpleName());
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void a(int i2, Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), obj, str, objArr}) == null) {
            a(i2, obj, null, str, objArr);
        }
    }

    public static void a(int i2, Object obj, Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), obj, th, str, objArr}) == null) {
            if ((i2 >= 5) || f73864a) {
                Log.println(i2, a(obj), f.a(str, objArr));
                if (th != null) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str, objArr) == null) {
            a(6, obj, str, objArr);
        }
    }

    public static void a(Object obj, Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, obj, th, str, objArr) == null) {
            a(6, obj, th, str, objArr);
        }
    }

    public static void b(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, obj, str, objArr) == null) {
            a(4, obj, str, objArr);
        }
    }

    public static void c(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, obj, str, objArr) == null) {
            a(3, obj, str, objArr);
        }
    }

    public static void d(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, obj, str, objArr) == null) {
            a(5, obj, str, objArr);
        }
    }

    public static void e(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, obj, str, objArr) == null) {
            a(2, obj, str, objArr);
        }
    }
}
