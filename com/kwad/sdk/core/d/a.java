package com.kwad.sdk.core.d;

import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f35940a = true;

    /* renamed from: b  reason: collision with root package name */
    public static String f35941b = "[KSAdSDK_3.3.9]";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f35942c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1889952122, "Lcom/kwad/sdk/core/d/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1889952122, "Lcom/kwad/sdk/core/d/a;");
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f35941b : (String) invokeV.objValue;
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
        }
    }

    public static void a(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, str, str2, th) == null) && f35940a) {
            Log.e(str, str2, th);
        }
    }

    public static void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65540, null, str, z) == null) {
            f35941b = PreferencesUtil.LEFT_MOUNT + str + PreferencesUtil.RIGHT_MOUNT;
            f35940a = z;
        }
    }

    public static void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, th) == null) {
            if (f35940a && th != null) {
                th.printStackTrace();
            }
            if (com.kwad.sdk.a.f34045b.booleanValue()) {
                throw new RuntimeException(th);
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f35942c) {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                if (stackTrace.length > 3) {
                    str = stackTrace[3].getFileName();
                    i2 = stackTrace[3].getLineNumber();
                } else {
                    str = "unknown";
                    i2 = -1;
                }
                return "(" + str + ':' + i2 + ')';
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) && f35940a) {
            Log.i(a(), e(str, str2));
        }
    }

    public static void b(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, th) == null) && f35940a && th != null) {
            th.printStackTrace();
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) && f35940a) {
            Log.w(a(), e(str, str2));
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) && f35940a) {
            Log.e(a(), e(str, str2));
        }
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, str2)) == null) {
            return PreferencesUtil.LEFT_MOUNT + str + "]: " + str2 + " " + b();
        }
        return (String) invokeLL.objValue;
    }
}
