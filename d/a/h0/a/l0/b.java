package d.a.h0.a.l0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.h0.a.k;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43130a = k.f43101a;

    public static <T extends d.a.h0.a.l0.h.a> Exception a(int i2, T t) {
        return d(i2).a(t);
    }

    public static ExtensionCore b(int i2) {
        return d(i2).b();
    }

    public static String c(int i2) {
        ExtensionCore b2 = d(i2).b();
        if (b2 != null) {
            String str = b2.extensionCoreVersionName;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    public static d.a.h0.a.l0.e.b d(int i2) {
        if (i2 == 1) {
            return c.h();
        }
        return a.h();
    }

    public static void e(int i2, int i3) {
        if (f43130a) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i2 + " ,newVersion: " + i3);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i2 != i3) {
            a h2 = a.h();
            h2.e().h(0L);
            h2.d().l(0L);
            d.a.h0.a.l0.k.a.j(0, true);
            d.a.h0.a.l0.k.a.j(1, true);
        }
    }

    public static void f(int i2, @Nullable d.a.h0.a.i2.u0.b<Exception> bVar) {
        d(i2).f(bVar);
    }
}
