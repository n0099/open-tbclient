package d.a.l0.a.p0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44010a = k.f43199a;

    public static void a() {
        f(0).f().c();
        f(0).e().f();
        if (f(1) != null) {
            f(1).f().c();
            f(1).e().f();
        }
    }

    public static <T extends d.a.l0.a.p0.g.a> Exception b(int i2, T t) {
        d.a.l0.a.p0.d.b f2 = f(i2);
        if (f2 == null) {
            return new Exception("SwanExtCore-Manager doRemoteUpdate: null extensionCoreManager");
        }
        return f2.a(t);
    }

    public static ExtensionCore c(int i2) {
        d.a.l0.a.p0.d.b f2 = f(i2);
        if (f2 == null) {
            return null;
        }
        return f2.c();
    }

    public static long d(int i2) {
        ExtensionCore c2 = c(i2);
        if (c2 != null) {
            return c2.extensionCoreVersionCode;
        }
        return 0L;
    }

    public static String e(int i2) {
        ExtensionCore c2 = c(i2);
        return (c2 == null || TextUtils.isEmpty(c2.extensionCoreVersionName)) ? "0" : c2.extensionCoreVersionName;
    }

    public static d.a.l0.a.p0.d.b f(int i2) {
        if (i2 == 1) {
            d.a.l0.a.p0.d.b u = d.a.l0.a.c1.b.i().u();
            if (u == null && k.f43199a) {
                Log.e("SwanGameRuntime", "非手百环境依赖注入接口getSwanGameExtensionCoreManager未实现，直接返回");
            }
            return u;
        }
        return a.l();
    }

    public static void g(int i2, int i3) {
        if (f44010a) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i2 + " ,newVersion: " + i3);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i2 != i3) {
            a();
            d.a.l0.a.p0.j.a.i(0, true);
            d.a.l0.a.p0.j.a.i(1, true);
        }
    }

    public static void h(int i2, @Nullable d.a.l0.a.v2.e1.b<Exception> bVar) {
        d.a.l0.a.p0.d.b f2 = f(i2);
        if (f2 != null) {
            f2.g(bVar);
        } else if (bVar != null) {
            bVar.onCallback(null);
        }
    }
}
