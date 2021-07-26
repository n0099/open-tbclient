package d.a.v.a.h;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f68439a = "lcpsdk";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(789024489, "Ld/a/v/a/h/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(789024489, "Ld/a/v/a/h/e;");
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) && c.f68435a) {
            String str3 = f68439a;
            Log.d(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) && c.f68435a) {
            String str3 = f68439a;
            Log.e(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, str, str2, th) == null) && c.f68435a) {
            String str3 = f68439a;
            Log.e(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2, th);
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) && c.f68435a) {
            String str3 = f68439a;
            Log.i(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) && c.f68435a) {
            String str3 = f68439a;
            Log.v(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) && c.f68435a) {
            String str3 = f68439a;
            Log.w(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }
}
