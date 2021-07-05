package d.a.q0.a.j2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.f1.e.b;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49059a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f49060b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f49061c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f49062d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f49063e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(118841697, "Ld/a/q0/a/j2/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(118841697, "Ld/a/q0/a/j2/h;");
                return;
            }
        }
        f49059a = d.a.q0.a.k.f49133a;
        f49060b = false;
        f49061c = false;
        d.a.q0.a.c1.a.Z().getSwitch("swan_app_use_route_statistic", false);
        f49063e = false;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f49059a) {
                Log.d("SwanAppRouteUbc", "mIsStartByApi = " + f49061c);
            }
            boolean z = f49061c;
            h(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f49059a) {
                Log.d("SwanAppRouteUbc", "mIsStartFirstPage = " + f49060b);
            }
            boolean z = f49060b;
            i(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f49062d : (String) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? f49060b : invokeV.booleanValue;
    }

    public static void e(String str, String str2, d.a.q0.a.p.e.j.d dVar, String str3) {
        d.a.q0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, dVar, str3) == null) && f49063e && (Q = d.a.q0.a.a2.e.Q()) != null) {
            b.a L = Q.L();
            d.a.q0.a.j2.p.f fVar = new d.a.q0.a.j2.p.f();
            fVar.f49119a = k.m(L.G());
            fVar.f49124f = L.H();
            if (d.a.q0.a.e0.f.e.e.d()) {
                fVar.f49121c = "remote-debug";
            } else if (d.a.q0.a.u1.a.a.C()) {
                fVar.f49121c = "local-debug";
            } else {
                fVar.f49121c = L.T();
            }
            fVar.f49120b = "pageshow";
            if (!TextUtils.isEmpty(str2)) {
                fVar.f49123e = str2;
            }
            fVar.a("path", str);
            fVar.a("routeType", str3);
            if (dVar != null && dVar.f49930c > 0) {
                fVar.a("valuetype", dVar.f49934g);
            }
            Bundle P = L.P();
            if (P != null) {
                fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            fVar.b(k.k(L.W()));
            if (f49059a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + fVar.f());
            }
            k.onEvent(fVar);
        }
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) {
            if (f49059a) {
                Log.d("SwanAppRouteUbc", "recordRouteByApi");
            }
            if (d()) {
                return;
            }
            h(true);
            f49062d = str2;
            e(str, null, null, str2);
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            if (f49059a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            f49062d = "6";
            e(str, null, null, f49062d);
        }
    }

    public static synchronized void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            synchronized (h.class) {
                f49061c = z;
            }
        }
    }

    public static synchronized void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            synchronized (h.class) {
                f49060b = z;
            }
        }
    }
}
