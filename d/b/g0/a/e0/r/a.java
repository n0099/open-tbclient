package d.b.g0.a.e0.r;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.k;
import d.b.g0.a.n1.c.f.c;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44256a = k.f45050a;

    /* renamed from: d.b.g0.a.e0.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0679a {

        /* renamed from: a  reason: collision with root package name */
        public static int f44257a = -1;

        public static String a() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_sub_pkg_launch_switch", "debug_ab");
        }

        public static boolean b() {
            if (a.f44256a) {
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
            if (f44257a < 0) {
                d.b.g0.a.w0.a.N().getSwitch("swan_sub_pkg_launch_switch", 0);
                f44257a = 0;
            }
            if (a.f44256a) {
                Log.d("AppLaunchMessenger", "isOnAppLaunchEnable sLaunchABSwitcher : " + f44257a);
            }
            return f44257a == 1;
        }
    }

    public static void b(c cVar, Bundle bundle) {
        if (f44256a) {
            Log.d("AppLaunchMessenger", "sendAppLaunchEvent event start.");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("swan_app_on_launch_event", bundle);
        d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
        d.b.g0.a.n1.c.c cVar2 = new d.b.g0.a.n1.c.c(122, bundle2);
        cVar2.b(cVar.f45390f);
        cVar2.p(true);
        e2.h(cVar2);
        if (f44256a) {
            Log.d("AppLaunchMessenger", "sendAppLaunchEvent event end.");
        }
    }
}
