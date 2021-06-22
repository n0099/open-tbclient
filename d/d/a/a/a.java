package d.d.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.duxiaoman.dxmpay.statistics.internal.StatService;
import d.d.a.a.b.c;
import d.d.a.a.b.d;
import d.d.a.a.b.i;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static Context f69877d;

    /* renamed from: a  reason: collision with root package name */
    public d.d.a.a.b.a f69878a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f69879b;

    /* renamed from: c  reason: collision with root package name */
    public c f69880c;

    /* renamed from: d.d.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1906a {

        /* renamed from: a  reason: collision with root package name */
        public static a f69881a = new a();
    }

    public static boolean b(Context context) {
        if (f69877d == null && context != null) {
            f69877d = context.getApplicationContext();
        }
        return f69877d != null;
    }

    public static Context c() {
        return f69877d;
    }

    public static a e() {
        return C1906a.f69881a;
    }

    public static void g(Context context, d.d.a.a.b.a aVar) {
        e();
        if (!b(context) || aVar == null) {
            return;
        }
        a e2 = e();
        e2.f69878a = aVar;
        try {
            if (e2.f69879b) {
                return;
            }
            e2.f69879b = true;
            i.a().e();
            d.h().i("normal_log");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void h(String str, String str2) {
        if (e().a()) {
            return;
        }
        u(str, null, str2);
    }

    public static void i(String str, int i2) {
        l(str, i2, null, null);
    }

    public static void j(String str, int i2, String str2) {
        l(str, i2, null, str2);
    }

    public static void k(String str, int i2, String str2) {
        l(str, i2, str2, null);
    }

    public static void l(String str, int i2, String str2, String str3) {
        if (e().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.d(str, Integer.toString(i2), str2, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void m(String str, int i2, Collection<String> collection) {
        p(str, i2, collection, null, null);
    }

    public static void n(String str, int i2, Collection<String> collection, String str2) {
        p(str, i2, collection, null, str2);
    }

    public static void o(String str, int i2, Collection<String> collection, Map<String, Object> map) {
        p(str, i2, collection, map, null);
    }

    public static void onEvent(String str) {
        if (e().a()) {
            return;
        }
        w(str, null, null, null);
    }

    public static void p(String str, int i2, Collection<String> collection, Map<String, Object> map, String str2) {
        if (e().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.g(str, Integer.toString(i2), collection, map, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void q(String str) {
        if (e().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.b(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void r(String str, String str2) {
        s(str, str2, null);
    }

    public static void s(String str, String str2, String str3) {
        if (e().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.c(str, str2, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void t(String str, Collection<String> collection) {
        w(str, collection, null, null);
    }

    public static void u(String str, Collection<String> collection, String str2) {
        w(str, collection, null, str2);
    }

    public static void v(String str, Collection<String> collection, Map<String, Object> map) {
        w(str, collection, map, null);
    }

    public static void w(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        if (e().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.e(str, null, collection, map, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void x(c cVar) {
        e().f69880c = cVar;
    }

    public final boolean a() {
        d.d.a.a.b.a aVar = this.f69878a;
        if (aVar != null) {
            return aVar.isDisabled();
        }
        return false;
    }

    public c d() {
        return this.f69880c;
    }

    public d.d.a.a.b.a f() {
        return this.f69878a;
    }

    public a() {
    }
}
