package d.a.n0.a.j2;

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
import d.a.n0.a.f1.e.b;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45757a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f45758b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f45759c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f45760d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45761e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(708382212, "Ld/a/n0/a/j2/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(708382212, "Ld/a/n0/a/j2/h;");
                return;
            }
        }
        f45757a = d.a.n0.a.k.f45831a;
        f45758b = false;
        f45759c = false;
        d.a.n0.a.c1.a.Z().getSwitch("swan_app_use_route_statistic", false);
        f45761e = false;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f45757a) {
                Log.d("SwanAppRouteUbc", "mIsStartByApi = " + f45759c);
            }
            boolean z = f45759c;
            h(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f45757a) {
                Log.d("SwanAppRouteUbc", "mIsStartFirstPage = " + f45758b);
            }
            boolean z = f45758b;
            i(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f45760d : (String) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f45758b : invokeV.booleanValue;
    }

    public static void e(String str, String str2, d.a.n0.a.p.e.j.d dVar, String str3) {
        d.a.n0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, dVar, str3) == null) && f45761e && (Q = d.a.n0.a.a2.e.Q()) != null) {
            b.a L = Q.L();
            d.a.n0.a.j2.p.f fVar = new d.a.n0.a.j2.p.f();
            fVar.f45817a = k.m(L.G());
            fVar.f45822f = L.H();
            if (d.a.n0.a.e0.f.e.e.d()) {
                fVar.f45819c = "remote-debug";
            } else if (d.a.n0.a.u1.a.a.C()) {
                fVar.f45819c = "local-debug";
            } else {
                fVar.f45819c = L.T();
            }
            fVar.f45818b = "pageshow";
            if (!TextUtils.isEmpty(str2)) {
                fVar.f45821e = str2;
            }
            fVar.a("path", str);
            fVar.a("routeType", str3);
            if (dVar != null && dVar.f46628c > 0) {
                fVar.a("valuetype", dVar.f46632g);
            }
            Bundle P = L.P();
            if (P != null) {
                fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            fVar.b(k.k(L.W()));
            if (f45757a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + fVar.f());
            }
            k.onEvent(fVar);
        }
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) {
            if (f45757a) {
                Log.d("SwanAppRouteUbc", "recordRouteByApi");
            }
            if (d()) {
                return;
            }
            h(true);
            f45760d = str2;
            e(str, null, null, str2);
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            if (f45757a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            f45760d = "6";
            e(str, null, null, f45760d);
        }
    }

    public static synchronized void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            synchronized (h.class) {
                f45759c = z;
            }
        }
    }

    public static synchronized void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            synchronized (h.class) {
                f45758b = z;
            }
        }
    }
}
