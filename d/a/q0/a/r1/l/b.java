package d.a.q0.a.r1.l;

import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.k;
import d.a.q0.n.j.i.l;
import d.a.q0.n.j.i.m;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50446a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f50447b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f50448c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f50449d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f50450e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f50451f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f50452g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f50453h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f50454i;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1019297555, "Ld/a/q0/a/r1/l/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1019297555, "Ld/a/q0/a/r1/l/b;");
                return;
            }
        }
        f50446a = k.f49133a;
        m = -1;
        n = -1;
        f50447b = p("swan_get_swan_id_cache");
        p("swan_pms_use_outback");
        p("swan_package_download_use_outback");
        p("swan_outback_use_independent_pool");
        p("swan_outback_support_quic");
        d.a.q0.a.c1.a.Z().getSwitch("swan_preload_game_strategy", 0);
        f50448c = 0;
        boolean p2 = p("swan_mbd_request_use_http2");
        f50449d = p2;
        l.f54080a = p2;
        f50450e = p("swan_memorywarning_alert_switch");
        f50451f = p("swan_memorywarning_not_show_dialog");
        d.a.q0.a.c1.a.Z().getSwitch("swan_memorywarning_memory_ratio", 80);
        f50452g = 80;
        d.a.q0.a.c1.a.Z().getSwitch("swan_memorywarning_interval", 30);
        f50453h = 30;
        d.a.q0.a.c1.a.Z().getSwitch("swan_memorywarning_alert_interval", 300);
        f50454i = 300;
        d.a.q0.a.c1.a.Z().getSwitch("swan_memorywarning_release_interval", 5);
        j = 5;
        k = p("swan_watchdog_switch");
        d.a.q0.a.c1.a.Z().getSwitch("swan_watchdog_interval", 5);
        l = 5;
        d.a.q0.a.c1.a.Z().getSwitch("swan_launch_loading_hidden_interval", 0);
        q = 0;
        d.a.q0.a.c1.a.Z().getSwitch("swan_launch_page_loading_type", 0);
        p = 0;
        o = p("swan_670_append_request_info");
        d.a.q0.a.c1.a.Z().getSwitch("swan_description_online_control", 0);
        m.f54083a = 0;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (m == -1) {
                d.a.q0.a.c1.a.Z().getSwitch("swan_upgrade_js_thread_priority", 0);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? p : invokeV.intValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f50454i : invokeV.intValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f50453h : invokeV.intValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f50452g : invokeV.intValue;
    }

    public static int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f50448c : invokeV.intValue;
    }

    public static int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? j : invokeV.intValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f50447b : invokeV.booleanValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (n == -1) {
                d.a.q0.a.c1.a.Z().getSwitch("swan_ipc_use_aidl", -1);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? f50449d : invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? f50451f : invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? f50450e : invokeV.booleanValue;
    }

    public static boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            d.a.q0.a.c1.a.Z().getSwitch(str, 0);
            if (f50446a) {
                Log.d("SwanApiCostOpt", str + " value : 0");
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
