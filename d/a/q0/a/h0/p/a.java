package d.a.q0.a.h0.p;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.k;
import d.a.q0.a.v1.c.f.c;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48445a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.h0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0813a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static int f48446a = -1;

        /* renamed from: b  reason: collision with root package name */
        public static int f48447b = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-441260246, "Ld/a/q0/a/h0/p/a$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-441260246, "Ld/a/q0/a/h0/p/a$a;");
            }
        }

        public static String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_sub_pkg_launch_switch", "debug_ab") : (String) invokeV.objValue;
        }

        public static boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (a.f48445a) {
                    Log.d("AppLaunchMessenger", "isOnAppLaunchEnable getAppLaunchDebugSwitch : " + a());
                    String a2 = a();
                    char c2 = 65535;
                    int hashCode = a2.hashCode();
                    if (hashCode != 251117829) {
                        if (hashCode != 547804557) {
                            if (hashCode == 569516856 && a2.equals("debug_on_activity_create")) {
                                c2 = 1;
                            }
                        } else if (a2.equals("debug_ab")) {
                            c2 = 2;
                        }
                    } else if (a2.equals("debug_on_app_launch")) {
                        c2 = 0;
                    }
                    if (c2 == 0) {
                        return true;
                    }
                    if (c2 == 1) {
                        return false;
                    }
                }
                if (f48446a < 0) {
                    d.a.q0.a.c1.a.Z().getSwitch("swan_sub_pkg_launch_switch", 0);
                    f48446a = 0;
                }
                if (a.f48445a) {
                    Log.d("AppLaunchMessenger", "isOnAppLaunchEnable sLaunchABSwitcher : " + f48446a);
                }
                return f48446a == 1;
            }
            return invokeV.booleanValue;
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (f48447b == -1) {
                    d.a.q0.a.c1.a.Z().getSwitch("swan_app_launch_optimize_v2", 0);
                    f48447b = 0;
                }
                return f48447b == 1;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705685319, "Ld/a/q0/a/h0/p/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705685319, "Ld/a/q0/a/h0/p/a;");
                return;
            }
        }
        f48445a = k.f49133a;
    }

    public static void b(c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cVar, bundle) == null) {
            if (f48445a) {
                Log.d("AppLaunchMessenger", "sendAppLaunchEvent event start.");
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("swan_app_on_launch_event", bundle);
            d.a.q0.a.v1.c.c cVar2 = new d.a.q0.a.v1.c.c(122, bundle2);
            if (!cVar.H() && C0813a.c()) {
                cVar.T(cVar2.h());
            } else {
                d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
                cVar2.b(cVar.f51259f);
                cVar2.p(true);
                e2.h(cVar2);
            }
            if (f48445a) {
                Log.d("AppLaunchMessenger", "sendAppLaunchEvent event end.");
            }
        }
    }
}
