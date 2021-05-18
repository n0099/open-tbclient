package d.a.i0.a.v2;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.tbadk.core.util.StringHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45235a = d.a.i0.a.k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f45236b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f45237c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static final Object f45238d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static int f45239e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static int f45240f = 0;

    /* loaded from: classes3.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f45241a;

        public a(boolean z) {
            this.f45241a = z;
        }
    }

    public static boolean a() {
        if (f45239e == 2) {
            if (f45235a) {
                Log.d("SwanAppCompat", "has used ab description");
            }
            return true;
        } else if (!l0.f("3.230.0")) {
            return d.a.i0.a.c1.a.Z().m() && !d.a.i0.a.k2.g.h.a().getBoolean("swan_app_js_native_ab_update_key", false);
        } else {
            if (f45235a) {
                Log.w("SwanAppCompat", "disable chrome net, swan js version lower than 3.230.0");
            }
            return false;
        }
    }

    public static String b(String str) {
        d.a.i0.a.e0.d.b("JsNative", f45240f + "-true");
        return f45240f + "-true-" + str + "-" + c();
    }

    public static String c() {
        StringBuilder sb = new StringBuilder();
        synchronized (f45238d) {
            if (f45236b != null) {
                sb.append("v8list:{");
                for (String str : f45236b) {
                    if (!TextUtils.isEmpty(str)) {
                        if (str.length() > 100) {
                            sb.append(str.substring(0, 99));
                            sb.append(StringHelper.STRING_MORE);
                        } else {
                            sb.append(str);
                        }
                        sb.append(";");
                    }
                }
                sb.append("},");
            }
            if (f45237c != null) {
                sb.append("weblist:{");
                for (String str2 : f45237c) {
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.length() > 100) {
                            sb.append(str2.substring(0, 99));
                            sb.append(StringHelper.STRING_MORE);
                        } else {
                            sb.append(str2);
                        }
                        sb.append(";");
                    }
                }
                sb.append("}");
            }
        }
        return sb.toString();
    }

    public static String d(int i2, boolean z) {
        List<String> list;
        f45240f = 0;
        String str = z ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
        if (f45239e == 1) {
            if (f45235a) {
                Log.d("SwanAppCompat", "type support default");
            }
            f45240f = 1;
            return SchemeCollecter.getSchemesDes(str, i2);
        }
        if (d.a.i0.a.u.e.j.d.b()) {
            synchronized (f45238d) {
                if (z) {
                    list = f45236b;
                } else {
                    list = f45237c;
                }
                if (list != null && list.size() > 0) {
                    if (f45235a) {
                        Log.d("SwanAppCompat", "support ab js native descriptions");
                    }
                    f45239e = 2;
                    f45240f = 2;
                    return list.get(i2);
                } else if (list != null) {
                    f45240f = 3;
                } else {
                    f45240f = 4;
                }
            }
        }
        if (f45235a) {
            Log.d("SwanAppCompat", "use default descriptions");
        }
        f45239e = 1;
        return SchemeCollecter.getSchemesDes(str, i2);
    }

    public static boolean e() {
        return !l0.f("3.120.2");
    }

    public static void f() {
        if (f45235a) {
            Log.d("SwanAppCompat", "on App upgrade");
        }
        if (d.a.i0.n.c.b() != null && d.a.i0.n.j.i.m.b()) {
            d.a.i0.n.c.b().j().putString("key_online_description_fix_version", "0");
        }
        d.a.i0.a.k2.g.h.a().putBoolean("swan_app_js_native_ab_update_key", true);
        d.a.i0.a.u.e.j.d.f(false);
    }

    public static void g() {
        if (f45235a) {
            Log.e("JsNative", f45240f + "-true");
        }
    }

    public static void h() {
        if (f45235a) {
            Log.d("SwanAppCompat", "start release descriptions");
        }
        synchronized (f45238d) {
            f45239e = 0;
            f45236b = new ArrayList();
            f45237c = new ArrayList();
        }
    }

    public static void i() {
        if (f45235a) {
            Log.d("SwanAppCompat", "start prepare ab description");
        }
        synchronized (f45238d) {
            j(true);
            j(false);
        }
        if (f45235a) {
            Log.d("SwanAppCompat", "end prepare ab description");
        }
    }

    public static void j(boolean z) {
        if (f45235a) {
            StringBuilder sb = new StringBuilder();
            sb.append("start prepare ab description :");
            sb.append(z ? V8Engine.TYPE_V8 : "webview");
            Log.d("SwanAppCompat", sb.toString());
        }
        d.a.i0.a.v2.b1.b.a aVar = new d.a.i0.a.v2.b1.b.a(z);
        if (d.a.i0.a.k2.g.h.a().getBoolean("swan_app_js_native_ab_update_key", false)) {
            if (!aVar.a(3)) {
                return;
            }
            d.a.i0.a.k2.g.h.a().putBoolean("swan_app_js_native_ab_update_key", false);
        }
        List<String> d2 = aVar.d();
        if (d2 != null) {
            k(d2, z);
        }
    }

    public static void k(List<String> list, boolean z) {
        if (list != null && f45239e == 0) {
            if (z) {
                f45236b = list;
            } else {
                f45237c = list;
            }
            if (f45235a) {
                StringBuilder sb = new StringBuilder();
                sb.append("has update descriptions, list :");
                sb.append(list.toString());
                sb.append(" type :");
                sb.append(z ? V8Engine.TYPE_V8 : "webview");
                Log.d("SwanAppCompat", sb.toString());
            }
        }
    }
}
