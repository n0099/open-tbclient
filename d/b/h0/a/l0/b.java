package d.b.h0.a.l0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45801a = k.f45772a;

    public static <T extends d.b.h0.a.l0.h.a> Exception a(int i, T t) {
        return d(i).a(t);
    }

    public static ExtensionCore b(int i) {
        return d(i).b();
    }

    public static String c(int i) {
        ExtensionCore b2 = d(i).b();
        if (b2 != null) {
            String str = b2.extensionCoreVersionName;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    public static d.b.h0.a.l0.e.b d(int i) {
        if (i == 1) {
            return c.h();
        }
        return a.h();
    }

    public static void e(int i, int i2) {
        if (f45801a) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            a h2 = a.h();
            h2.e().h(0L);
            h2.d().l(0L);
            d.b.h0.a.l0.k.a.j(0, true);
            d.b.h0.a.l0.k.a.j(1, true);
        }
    }

    public static void f(int i, @Nullable d.b.h0.a.i2.u0.b<Exception> bVar) {
        d(i).f(bVar);
    }
}
