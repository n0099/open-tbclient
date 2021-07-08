package d.l.a.e.b.c;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f71728a = 4;

    /* renamed from: b  reason: collision with root package name */
    public static AbstractC2041a f71729b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.l.a.e.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static abstract class AbstractC2041a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void a(String str, String str2);

        public abstract void b(String str, String str2, Throwable th);

        public abstract void c(String str, String str2);

        public abstract void d(String str, String str2);

        public abstract void e(String str, String str2);

        public abstract void f(String str, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1799479845, "Ld/l/a/e/b/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1799479845, "Ld/l/a/e/b/c/a;");
        }
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i2) == null) {
            f71728a = i2;
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            g("DownloaderLogger", str);
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || str2 == null) {
            return;
        }
        if (f71728a <= 2) {
            Log.v(str, str2);
        }
        AbstractC2041a abstractC2041a = f71729b;
        if (abstractC2041a != null) {
            abstractC2041a.a(f(str), str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, th) == null) {
            if (str2 == null && th == null) {
                return;
            }
            if (f71728a <= 6) {
                Log.e(f(str), str2, th);
            }
            AbstractC2041a abstractC2041a = f71729b;
            if (abstractC2041a != null) {
                abstractC2041a.b(f(str), str2, th);
            }
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f71728a <= 3 : invokeV.booleanValue;
    }

    public static String f(String str) {
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

    public static void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) || str2 == null) {
            return;
        }
        if (f71728a <= 3) {
            Log.d(f(str), str2);
        }
        AbstractC2041a abstractC2041a = f71729b;
        if (abstractC2041a != null) {
            abstractC2041a.c(f(str), str2);
        }
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            j("DownloaderLogger", str);
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) || str2 == null) {
            return;
        }
        if (f71728a <= 4) {
            Log.i(f(str), str2);
        }
        AbstractC2041a abstractC2041a = f71729b;
        if (abstractC2041a != null) {
            abstractC2041a.d(f(str), str2);
        }
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) || str2 == null) {
            return;
        }
        if (f71728a <= 5) {
            Log.w(f(str), str2);
        }
        AbstractC2041a abstractC2041a = f71729b;
        if (abstractC2041a != null) {
            abstractC2041a.f(f(str), str2);
        }
    }

    public static void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) || str2 == null) {
            return;
        }
        if (f71728a <= 6) {
            Log.e(f(str), str2);
        }
        AbstractC2041a abstractC2041a = f71729b;
        if (abstractC2041a != null) {
            abstractC2041a.e(f(str), str2);
        }
    }
}
