package d.a.l0.a.v2;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.l0.a.f1.e.b;
import java.util.List;
/* loaded from: classes3.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45438a = d.a.l0.a.k.f43199a;

    public static String a(int i2, boolean z) {
        if (f45438a) {
            return d.a.l0.a.u1.a.a.p() ? j.d(i2, true) : "";
        }
        return j.d(i2, z);
    }

    public static String b(Context context) {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (context == null || Q == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int l = Q.l();
        if (l != -1) {
            b.a L = Q.L();
            sb.append(c(l));
            sb.append("\n");
            if (l == 0) {
                sb.append(e(l));
                sb.append("\n");
            }
            if (Q.m0()) {
                sb.append("host version : ");
                sb.append(q0.u(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
                sb.append("\n");
            } else {
                sb.append("native version : ");
                sb.append(d.a.l0.d.c.a() != null ? d.a.l0.d.c.a().b() : "");
                sb.append("\n");
            }
            sb.append("enable V8: ");
            sb.append(d.a.l0.a.h0.u.g.N().h0());
            sb.append("\n");
            sb.append("aps version: ");
            sb.append(TextUtils.isEmpty(L.u1()) ? "" : L.u1());
            sb.append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), L.g1());
            sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            sb.append(formatFileSize);
            sb.append("\n");
            sb.append("app bundle version: ");
            sb.append(TextUtils.isEmpty(L.v1()) ? "" : L.v1());
            sb.append("\n");
            sb.append("app is opt pkg: ");
            sb.append(d.a.l0.a.l1.d.d.f().g(L.f0()));
            sb.append("\n");
            String b2 = d.a.l0.a.c1.b.h().b();
            if (!TextUtils.isEmpty(b2)) {
                sb.append("app sconsole version: ");
                sb.append(b2);
                sb.append("\n");
            }
            if (Q.m0()) {
                sb.append("game engine version: ");
                sb.append("1.3.2.3");
                sb.append("\n");
            }
            if (!Q.m0()) {
                String a2 = a(0, d.a.l0.a.h0.u.g.N().h0());
                sb.append("jsNativeEnable: ");
                sb.append(!TextUtils.isEmpty(a2));
                sb.append("\n");
            }
            if (!Q.m0()) {
                boolean m = d.a.l0.a.p0.f.b.m();
                sb.append("debugDynamicLibEnable: ");
                sb.append(m);
                sb.append('\n');
                if (m) {
                    List<String> o = d.a.l0.a.p0.f.b.o();
                    sb.append("debugDynamicLibList: {");
                    if (!o.isEmpty()) {
                        sb.append('\n');
                        for (String str : o) {
                            sb.append(str);
                            sb.append('\n');
                        }
                    }
                    sb.append("}\n");
                }
            }
            sb.append("so version: ");
            sb.append(d.a.l0.a.k2.g.h.a().getLong("swan_so_installed_version_code_zeus", 0L));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String c(int i2) {
        StringBuilder sb = new StringBuilder();
        SwanCoreVersion N = d.a.l0.a.g1.f.V().N();
        sb.append(i2 == 1 ? "game-core" : "swan-js");
        sb.append(" version : ");
        sb.append(d.a.l0.a.m2.b.i(N, i2));
        return sb.toString();
    }

    public static String d(Context context) {
        return "model: " + Build.MODEL + "\nandroid: " + Build.VERSION.RELEASE + "\napi level: " + Build.VERSION.SDK_INT + "\ncuid: " + d.a.l0.a.c1.a.a0().i(d.a.l0.a.c1.a.b()) + "\n";
    }

    public static String e(int i2) {
        String str;
        int i3;
        StringBuilder sb = new StringBuilder();
        if (i2 == 0) {
            ExtensionCore M = d.a.l0.a.h0.u.g.N().M();
            if (M != null) {
                str = M.extensionCoreVersionName;
                i3 = M.extensionCoreType;
            } else {
                str = "";
                i3 = -1;
            }
            sb.append("extension-js version : ");
            sb.append(str);
            sb.append("   type：");
            sb.append(i3);
        }
        return sb.toString();
    }

    public static String f(Context context) {
        d.a.l0.d.a a2 = d.a.l0.d.c.a();
        StringBuilder sb = new StringBuilder();
        sb.append("name: ");
        sb.append(d.a.l0.a.c1.a.m().a());
        sb.append("\n");
        sb.append("version: ");
        sb.append(a2 != null ? a2.i() : "");
        sb.append("\n");
        return sb.toString();
    }

    public static void g(Context context, d.a.l0.a.v2.e1.b<String> bVar) {
        d.a.l0.a.h0.i.i.f(bVar);
    }

    public static String h(Context context) {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null || context == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("=========================");
        sb.append("\n");
        sb.append("= ");
        sb.append(Q.L().K());
        sb.append("\n");
        sb.append("=========================");
        sb.append("\n");
        sb.append("===== 小程序信息 =====");
        sb.append("\n");
        sb.append(b(context));
        sb.append("\n");
        sb.append("===== 设备信息 =====");
        sb.append("\n");
        sb.append(d(context));
        sb.append("\n");
        sb.append("===== 宿主信息 =====");
        sb.append("\n");
        sb.append(f(context));
        sb.append("\n");
        d.a.l0.a.e0.d.h("SwanAppEnvironmentUtils", sb.toString());
        return sb.toString();
    }

    public static void i(Activity activity) {
        String str;
        if (activity == null) {
            return;
        }
        try {
            str = h(activity);
        } catch (Exception e2) {
            if (!f45438a) {
                d.a.l0.a.e0.d.i("SwanAppEnvironmentUtils", "getExtraInfo error", e2);
                str = "";
            } else {
                throw e2;
            }
        }
        d.a.l0.a.e0.d.h("SwanAppEnvironmentUtils", "recordExtraInfoToLogSystem\n--------------------ExtraInfo list----------------------\n" + str + "--------------------ExtraInfo end-----------------------");
        String k = d.a.l0.a.c1.a.Z().k();
        d.a.l0.a.e0.d.h("SwanAppEnvironmentUtils", "sid = " + k);
        d.a.l0.a.h0.o.e.a.i();
    }
}
