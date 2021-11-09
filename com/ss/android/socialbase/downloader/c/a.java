package com.ss.android.socialbase.downloader.c;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f69152a = 4;

    /* renamed from: b  reason: collision with root package name */
    public static AbstractC1986a f69153b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.ss.android.socialbase.downloader.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC1986a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        public void a(String str, String str2, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, th) == null) {
            }
        }

        public void b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            }
        }

        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            }
        }

        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            }
        }

        public void e(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(479251524, "Lcom/ss/android/socialbase/downloader/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(479251524, "Lcom/ss/android/socialbase/downloader/c/a;");
        }
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i2) == null) {
            f69152a = i2;
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "DownloaderLogger";
            }
            return "Downloader-" + str;
        }
        return (String) invokeL.objValue;
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) || str2 == null) {
            return;
        }
        if (f69152a <= 4) {
            b(str);
        }
        AbstractC1986a abstractC1986a = f69153b;
        if (abstractC1986a != null) {
            abstractC1986a.c(b(str), str2);
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) || str2 == null) {
            return;
        }
        if (f69152a <= 5) {
            b(str);
        }
        AbstractC1986a abstractC1986a = f69153b;
        if (abstractC1986a != null) {
            abstractC1986a.e(b(str), str2);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) || str2 == null) {
            return;
        }
        if (f69152a <= 6) {
            b(str);
        }
        AbstractC1986a abstractC1986a = f69153b;
        if (abstractC1986a != null) {
            abstractC1986a.d(b(str), str2);
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f69152a <= 3 : invokeV.booleanValue;
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || str2 == null) {
            return;
        }
        int i2 = f69152a;
        AbstractC1986a abstractC1986a = f69153b;
        if (abstractC1986a != null) {
            abstractC1986a.a(b(str), str2);
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) || str2 == null) {
            return;
        }
        if (f69152a <= 3) {
            b(str);
        }
        AbstractC1986a abstractC1986a = f69153b;
        if (abstractC1986a != null) {
            abstractC1986a.b(b(str), str2);
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            d("DownloaderLogger", str);
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            b("DownloaderLogger", str);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, th) == null) {
            if (str2 == null && th == null) {
                return;
            }
            if (f69152a <= 6) {
                b(str);
            }
            AbstractC1986a abstractC1986a = f69153b;
            if (abstractC1986a != null) {
                abstractC1986a.a(b(str), str2, th);
            }
        }
    }
}
