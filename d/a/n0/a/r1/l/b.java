package d.a.n0.a.r1.l;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.n0.a.k;
import d.a.n0.n.j.i.l;
import d.a.n0.n.j.i.m;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47144a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f47145b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f47146c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f47147d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47148e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47149f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f47150g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f47151h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f47152i;
    public static final int j;
    public static final boolean k;
    public static final int l;
    public static int m;
    public static int n;
    public static final boolean o;
    public static final int p;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(632049398, "Ld/a/n0/a/r1/l/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(632049398, "Ld/a/n0/a/r1/l/b;");
                return;
            }
        }
        f47144a = k.f45831a;
        m = -1;
        n = -1;
        f47145b = p("swan_get_swan_id_cache");
        p("swan_pms_use_outback");
        p("swan_package_download_use_outback");
        p("swan_outback_use_independent_pool");
        p("swan_outback_support_quic");
        d.a.n0.a.c1.a.Z().getSwitch("swan_preload_game_strategy", 0);
        f47146c = 0;
        boolean p2 = p("swan_mbd_request_use_http2");
        f47147d = p2;
        l.f50778a = p2;
        f47148e = p("swan_memorywarning_alert_switch");
        f47149f = p("swan_memorywarning_not_show_dialog");
        d.a.n0.a.c1.a.Z().getSwitch("swan_memorywarning_memory_ratio", 80);
        f47150g = 80;
        d.a.n0.a.c1.a.Z().getSwitch("swan_memorywarning_interval", 30);
        f47151h = 30;
        d.a.n0.a.c1.a.Z().getSwitch("swan_memorywarning_alert_interval", 300);
        f47152i = 300;
        d.a.n0.a.c1.a.Z().getSwitch("swan_memorywarning_release_interval", 5);
        j = 5;
        k = p("swan_watchdog_switch");
        d.a.n0.a.c1.a.Z().getSwitch("swan_watchdog_interval", 5);
        l = 5;
        d.a.n0.a.c1.a.Z().getSwitch("swan_launch_loading_hidden_interval", 0);
        q = 0;
        d.a.n0.a.c1.a.Z().getSwitch("swan_launch_page_loading_type", 0);
        p = 0;
        o = p("swan_670_append_request_info");
        d.a.n0.a.c1.a.Z().getSwitch("swan_description_online_control", 0);
        m.f50781a = 0;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (m == -1) {
                d.a.n0.a.c1.a.Z().getSwitch("swan_upgrade_js_thread_priority", 0);
                m = 0;
            }
            return m;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? l : invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? q : invokeV.intValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? p : invokeV.intValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f47152i : invokeV.intValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f47151h : invokeV.intValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f47150g : invokeV.intValue;
    }

    public static int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f47146c : invokeV.intValue;
    }

    public static int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? j : invokeV.intValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f47145b : invokeV.booleanValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (n == -1) {
                d.a.n0.a.c1.a.Z().getSwitch("swan_ipc_use_aidl", -1);
                n = -1;
            }
            return n == 1;
        }
        return invokeV.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? k : invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? f47147d : invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? f47149f : invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? f47148e : invokeV.booleanValue;
    }

    public static boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            d.a.n0.a.c1.a.Z().getSwitch(str, 0);
            if (f47144a) {
                Log.d("SwanApiCostOpt", str + " value : 0");
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
