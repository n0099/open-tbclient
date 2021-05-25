package d.a.l0.a.h0.p;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.k;
import d.a.l0.a.v1.c.f.c;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42511a = k.f43199a;

    /* renamed from: d.a.l0.a.h0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0694a {

        /* renamed from: a  reason: collision with root package name */
        public static int f42512a = -1;

        /* renamed from: b  reason: collision with root package name */
        public static int f42513b = -1;

        public static String a() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_sub_pkg_launch_switch", "debug_ab");
        }

        public static boolean b() {
            if (a.f42511a) {
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
            if (f42512a < 0) {
                d.a.l0.a.c1.a.Z().getSwitch("swan_sub_pkg_launch_switch", 0);
                f42512a = 0;
            }
            if (a.f42511a) {
                Log.d("AppLaunchMessenger", "isOnAppLaunchEnable sLaunchABSwitcher : " + f42512a);
            }
            return f42512a == 1;
        }

        public static boolean c() {
            if (f42513b == -1) {
                d.a.l0.a.c1.a.Z().getSwitch("swan_app_launch_optimize_v2", 0);
                f42513b = 0;
            }
            return f42513b == 1;
        }
    }

    public static void b(c cVar, Bundle bundle) {
        if (f42511a) {
            Log.d("AppLaunchMessenger", "sendAppLaunchEvent event start.");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("swan_app_on_launch_event", bundle);
        d.a.l0.a.v1.c.c cVar2 = new d.a.l0.a.v1.c.c(122, bundle2);
        if (!cVar.H() && C0694a.c()) {
            cVar.T(cVar2.h());
        } else {
            d.a.l0.a.v1.c.a e2 = d.a.l0.a.v1.c.a.e();
            cVar2.b(cVar.f45331f);
            cVar2.p(true);
            e2.h(cVar2);
        }
        if (f42511a) {
            Log.d("AppLaunchMessenger", "sendAppLaunchEvent event end.");
        }
    }
}
