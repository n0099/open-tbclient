package d.a.h0.a.i2;

import android.app.Activity;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.h0.a.y0.e.b;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42777a = d.a.h0.a.k.f43101a;

    public static String a(int i2, boolean z) {
        return f42777a ? d.a.h0.a.m1.a.a.n() ? i.d(i2, true) : "" : !i.h() ? "" : i.d(i2, z);
    }

    public static String b(int i2) {
        StringBuilder sb = new StringBuilder();
        SwanCoreVersion N = d.a.h0.a.z0.f.V().N();
        sb.append(i2 == 1 ? "game-core" : "swan-js");
        sb.append(" version : ");
        sb.append(d.a.h0.a.b2.b.g(N, i2));
        return sb.toString();
    }

    public static String c(int i2) {
        String str;
        int i3;
        StringBuilder sb = new StringBuilder();
        if (i2 == 0) {
            ExtensionCore K = d.a.h0.a.e0.w.d.L().K();
            if (K != null) {
                str = K.extensionCoreVersionName;
                i3 = K.extensionCoreType;
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

    public static String d(Activity activity) {
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (activity == null || O == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int j = O.j();
        if (j != -1) {
            b.a J = O.J();
            sb.append(b(j));
            sb.append("\n");
            if (j == 0) {
                sb.append(c(j));
                sb.append("\n");
            }
            sb.append("host version : ");
            sb.append(k0.t(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            sb.append("enable code cache: ");
            sb.append(d.a.h0.a.w0.a.N().u(j));
            sb.append("\n");
            sb.append("enable V8: ");
            sb.append(d.a.h0.a.e0.w.d.L().d0());
            sb.append("\n");
            sb.append("aps version: ");
            sb.append(TextUtils.isEmpty(J.n1()) ? "" : J.n1());
            sb.append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), J.a1());
            sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            sb.append(formatFileSize);
            sb.append("\n");
            sb.append("app bundle version: ");
            sb.append(TextUtils.isEmpty(J.o1()) ? "" : J.o1());
            sb.append("\n");
            String e2 = d.a.h0.g.f.d.m().e();
            if (!TextUtils.isEmpty(e2)) {
                sb.append("app sconsole version: ");
                sb.append(e2);
                sb.append("\n");
            }
            if (O.i0()) {
                sb.append("game engine version: ");
                sb.append("1.3.1.15");
                sb.append("\n");
            }
            long f2 = d.a.h0.g.i0.f.d.f();
            sb.append("v8 so version: ");
            sb.append(f2);
            sb.append(f2 < 0 ? "(old)" : "(new)");
            sb.append("\n");
            if (!O.i0()) {
                String a2 = a(0, d.a.h0.a.e0.w.d.L().d0());
                sb.append("jsNativeEnble: ");
                sb.append(!TextUtils.isEmpty(a2));
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static void e(Activity activity) {
        String str;
        if (activity == null) {
            return;
        }
        try {
            str = d(activity);
        } catch (Exception e2) {
            if (!f42777a) {
                d.a.h0.a.c0.c.i("SwanAppEnvironmentUtils", "getExtraInfo error", e2);
                str = "";
            } else {
                throw e2;
            }
        }
        d.a.h0.a.c0.c.h("SwanAppEnvironmentUtils", "recordExtraInfoToLogSystem\n--------------------ExtraInfo list----------------------\n" + str + "--------------------ExtraInfo end-----------------------");
        String b2 = d.a.h0.a.w0.a.N().b();
        d.a.h0.a.c0.c.h("SwanAppEnvironmentUtils", "sid = " + b2);
    }
}
