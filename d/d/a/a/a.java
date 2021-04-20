package d.d.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.duxiaoman.dxmpay.statistics.internal.StatService;
import d.d.a.a.b.c;
import d.d.a.a.b.d;
import d.d.a.a.b.i;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static Context f66756d;

    /* renamed from: a  reason: collision with root package name */
    public d.d.a.a.b.a f66757a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66758b;

    /* renamed from: c  reason: collision with root package name */
    public c f66759c;

    /* renamed from: d.d.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1832a {

        /* renamed from: a  reason: collision with root package name */
        public static a f66760a = new a();
    }

    public static boolean b(Context context) {
        if (f66756d == null && context != null) {
            f66756d = context.getApplicationContext();
        }
        return f66756d != null;
    }

    public static Context c() {
        return f66756d;
    }

    public static a e() {
        return C1832a.f66760a;
    }

    public static void g(Context context, d.d.a.a.b.a aVar) {
        e();
        if (!b(context) || aVar == null) {
            return;
        }
        a e2 = e();
        e2.f66757a = aVar;
        try {
            if (e2.f66758b) {
                return;
            }
            e2.f66758b = true;
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

    public static void i(String str, int i) {
        l(str, i, null, null);
    }

    public static void j(String str, int i, String str2) {
        l(str, i, null, str2);
    }

    public static void k(String str, int i, String str2) {
        l(str, i, str2, null);
    }

    public static void l(String str, int i, String str2, String str3) {
        if (e().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.d(str, Integer.toString(i), str2, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void m(String str, int i, Collection<String> collection) {
        p(str, i, collection, null, null);
    }

    public static void n(String str, int i, Collection<String> collection, String str2) {
        p(str, i, collection, null, str2);
    }

    public static void o(String str, int i, Collection<String> collection, Map<String, Object> map) {
        p(str, i, collection, map, null);
    }

    public static void onEvent(String str) {
        if (e().a()) {
            return;
        }
        w(str, null, null, null);
    }

    public static void p(String str, int i, Collection<String> collection, Map<String, Object> map, String str2) {
        if (e().a() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.g(str, Integer.toString(i), collection, map, str2);
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
        e().f66759c = cVar;
    }

    public final boolean a() {
        d.d.a.a.b.a aVar = this.f66757a;
        if (aVar != null) {
            return aVar.isDisabled();
        }
        return false;
    }

    public c d() {
        return this.f66759c;
    }

    public d.d.a.a.b.a f() {
        return this.f66757a;
    }

    public a() {
    }
}
