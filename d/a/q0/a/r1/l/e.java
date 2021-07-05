package d.a.q0.a.r1.l;

import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class e implements d.a.q0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static Integer f50457b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Integer f50458c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Integer f50459d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Boolean f50460e = null;

    /* renamed from: f  reason: collision with root package name */
    public static Integer f50461f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Boolean f50462g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f50463h = -1;

    /* renamed from: i  reason: collision with root package name */
    public static int f50464i = -1;
    public static int j = -1;
    public static int k = -1;
    public static int l = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1019297648, "Ld/a/q0/a/r1/l/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1019297648, "Ld/a/q0/a/r1/l/e;");
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f50460e == null) {
                f50460e = Boolean.valueOf(h("swan_api_callback_opt"));
            }
            return f50460e.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            d.a.q0.a.c1.a.Z().getSwitch(str, 0);
            if (d.a.q0.a.f1.f.a.f47786a) {
                Log.d("SwanPerformance", "packing[" + str + " = 0" + PreferencesUtil.RIGHT_MOUNT);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f50458c == null) {
                f50458c = Integer.valueOf(e() % 10000);
            }
            return f50458c.intValue();
        }
        return invokeV.intValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            if (f50459d == null) {
                f50459d = Integer.valueOf(e() / 10000);
            }
            return f50459d.intValue();
        }
        return invokeV.intValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f50457b == null) {
                f50457b = Integer.valueOf(b("swan_launch_api_trigger"));
            }
            return f50457b.intValue();
        }
        return invokeV.intValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (f50464i == -1) {
                f50464i = b("swan_idle_handler_opt");
            }
            return f50464i;
        }
        return invokeV.intValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f() > 0 : invokeV.booleanValue;
    }

    public static boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? b(str) != 0 : invokeL.booleanValue;
    }

    public static int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f50461f == null) {
                f50461f = Integer.valueOf(b("swan_launch_thread_dispatch"));
            }
            return f50461f.intValue();
        }
        return invokeV.intValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? i() > 0 : invokeV.booleanValue;
    }

    public static int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f50463h == -1) {
                f50463h = b("swan_optimize_launch_cpu");
            }
            return f50463h;
        }
        return invokeV.intValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (k == -1) {
                k = b("swan_http_thread_opt");
            }
            return k > 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f50462g == null) {
                f50462g = Boolean.valueOf(h("swan_js_thread_dispatch"));
            }
            return f50462g.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (l == -1) {
                l = b("swan_webview_ssl_opt");
            }
            return l > 0;
        }
        return invokeV.booleanValue;
    }

    public static int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (j == -1) {
                j = b("swan_mmap_loger_opt");
            }
            return j;
        }
        return invokeV.intValue;
    }
}
