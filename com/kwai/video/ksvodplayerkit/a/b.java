package com.kwai.video.ksvodplayerkit.a;

import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static a f39858a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f39859b = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-593788049, "Lcom/kwai/video/ksvodplayerkit/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-593788049, "Lcom/kwai/video/ksvodplayerkit/a/b;");
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            a(str, str2, null);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, str2, th) == null) && f39859b && (aVar = f39858a) != null) {
            try {
                aVar.a(str, str2, th);
            } catch (Exception e2) {
                Log.e("ksvodplayer", Log.getStackTraceString(e2));
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            b(str, str2, null);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65540, null, str, str2, th) == null) && f39859b && (aVar = f39858a) != null) {
            try {
                aVar.c(str, str2, th);
            } catch (Exception e2) {
                Log.e("ksvodplayer", Log.getStackTraceString(e2));
            }
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) {
            c(str, str2, null);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, th) == null) && f39859b && (aVar = f39858a) != null) {
            try {
                aVar.b(str, str2, th);
            } catch (Exception e2) {
                Log.e("ksvodplayer", Log.getStackTraceString(e2));
            }
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            d(str, str2, null);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65544, null, str, str2, th) == null) && f39859b && (aVar = f39858a) != null) {
            try {
                aVar.d(str, str2, th);
            } catch (Exception e2) {
                Log.e("ksvodplayer", Log.getStackTraceString(e2));
            }
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) {
            e(str, str2, null);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, str, str2, th) == null) && f39859b && (aVar = f39858a) != null) {
            try {
                aVar.e(str, str2, th);
            } catch (Exception e2) {
                Log.e("ksvodplayer", Log.getStackTraceString(e2));
            }
        }
    }
}
