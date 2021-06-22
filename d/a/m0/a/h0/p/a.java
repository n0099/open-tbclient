package d.a.m0.a.h0.p;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.m0.a.k;
import d.a.m0.a.v1.c.f.c;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46295a = k.f46983a;

    /* renamed from: d.a.m0.a.h0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0753a {

        /* renamed from: a  reason: collision with root package name */
        public static int f46296a = -1;

        /* renamed from: b  reason: collision with root package name */
        public static int f46297b = -1;

        public static String a() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_sub_pkg_launch_switch", "debug_ab");
        }

        public static boolean b() {
            if (a.f46295a) {
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
            if (f46296a < 0) {
                d.a.m0.a.c1.a.Z().getSwitch("swan_sub_pkg_launch_switch", 0);
                f46296a = 0;
            }
            if (a.f46295a) {
                Log.d("AppLaunchMessenger", "isOnAppLaunchEnable sLaunchABSwitcher : " + f46296a);
            }
            return f46296a == 1;
        }

        public static boolean c() {
            if (f46297b == -1) {
                d.a.m0.a.c1.a.Z().getSwitch("swan_app_launch_optimize_v2", 0);
                f46297b = 0;
            }
            return f46297b == 1;
        }
    }

    public static void b(c cVar, Bundle bundle) {
        if (f46295a) {
            Log.d("AppLaunchMessenger", "sendAppLaunchEvent event start.");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("swan_app_on_launch_event", bundle);
        d.a.m0.a.v1.c.c cVar2 = new d.a.m0.a.v1.c.c(122, bundle2);
        if (!cVar.H() && C0753a.c()) {
            cVar.T(cVar2.h());
        } else {
            d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
            cVar2.b(cVar.f49113f);
            cVar2.p(true);
            e2.h(cVar2);
        }
        if (f46295a) {
            Log.d("AppLaunchMessenger", "sendAppLaunchEvent event end.");
        }
    }
}
