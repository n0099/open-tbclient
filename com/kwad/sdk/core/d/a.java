package com.kwad.sdk.core.d;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.b;
import com.kwad.sdk.utils.ar;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f34404a = true;

    /* renamed from: b  reason: collision with root package name */
    public static String f34405b = "[KSAdSDK_3.3.11]";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f34406c;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f34405b : (String) invokeV.objValue;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            Log.v(a(), str);
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) && f34404a && b.f34059b.booleanValue()) {
            b(a(), f(str, str2));
        }
    }

    public static void a(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, th) == null) && f34404a) {
            Log.e(str, str2, th);
        }
    }

    public static void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, str, z) == null) {
            f34405b = PreferencesUtil.LEFT_MOUNT + str + PreferencesUtil.RIGHT_MOUNT;
            f34404a = z;
        }
    }

    public static void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, th) == null) {
            if (f34404a && th != null) {
                th.printStackTrace();
            }
            if (b.f34059b.booleanValue()) {
                ar.a(new Runnable(th) { // from class: com.kwad.sdk.core.d.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Throwable f34407a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {th};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f34407a = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            throw new RuntimeException(this.f34407a);
                        }
                    }
                });
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f34406c) {
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
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            if (str2.length() <= 4000) {
                Log.d(str, str2);
                return;
            }
            Log.d(str, str2.substring(0, 4000));
            b(str, str2.substring(4000));
        }
    }

    public static void b(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, th) == null) && b.f34059b.booleanValue() && th != null) {
            th.printStackTrace();
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) && f34404a) {
            Log.i(a(), f(str, str2));
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) && f34404a) {
            Log.w(a(), f(str, str2));
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) && f34404a) {
            Log.e(a(), f(str, str2));
        }
    }

    public static String f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, str2)) == null) {
            return PreferencesUtil.LEFT_MOUNT + str + "]: " + str2 + " " + b();
        }
        return (String) invokeLL.objValue;
    }
}
