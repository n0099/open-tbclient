package d.a.o0.a.j2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.f1.e.b;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46261a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f46262b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f46263c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f46264d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46265e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(511868707, "Ld/a/o0/a/j2/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(511868707, "Ld/a/o0/a/j2/h;");
                return;
            }
        }
        f46261a = d.a.o0.a.k.f46335a;
        f46262b = false;
        f46263c = false;
        d.a.o0.a.c1.a.Z().getSwitch("swan_app_use_route_statistic", false);
        f46265e = false;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f46261a) {
                Log.d("SwanAppRouteUbc", "mIsStartByApi = " + f46263c);
            }
            boolean z = f46263c;
            h(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f46261a) {
                Log.d("SwanAppRouteUbc", "mIsStartFirstPage = " + f46262b);
            }
            boolean z = f46262b;
            i(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f46264d : (String) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f46262b : invokeV.booleanValue;
    }

    public static void e(String str, String str2, d.a.o0.a.p.e.j.d dVar, String str3) {
        d.a.o0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, dVar, str3) == null) && f46265e && (Q = d.a.o0.a.a2.e.Q()) != null) {
            b.a L = Q.L();
            d.a.o0.a.j2.p.f fVar = new d.a.o0.a.j2.p.f();
            fVar.f46321a = k.m(L.G());
            fVar.f46326f = L.H();
            if (d.a.o0.a.e0.f.e.e.d()) {
                fVar.f46323c = "remote-debug";
            } else if (d.a.o0.a.u1.a.a.C()) {
                fVar.f46323c = "local-debug";
            } else {
                fVar.f46323c = L.T();
            }
            fVar.f46322b = "pageshow";
            if (!TextUtils.isEmpty(str2)) {
                fVar.f46325e = str2;
            }
            fVar.a("path", str);
            fVar.a("routeType", str3);
            if (dVar != null && dVar.f47132c > 0) {
                fVar.a("valuetype", dVar.f47136g);
            }
            Bundle P = L.P();
            if (P != null) {
                fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            fVar.b(k.k(L.W()));
            if (f46261a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + fVar.f());
            }
            k.onEvent(fVar);
        }
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) {
            if (f46261a) {
                Log.d("SwanAppRouteUbc", "recordRouteByApi");
            }
            if (d()) {
                return;
            }
            h(true);
            f46264d = str2;
            e(str, null, null, str2);
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            if (f46261a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            f46264d = "6";
            e(str, null, null, f46264d);
        }
    }

    public static synchronized void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            synchronized (h.class) {
                f46263c = z;
            }
        }
    }

    public static synchronized void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            synchronized (h.class) {
                f46262b = z;
            }
        }
    }
}
