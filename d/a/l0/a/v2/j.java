package d.a.l0.a.v2;

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
    public static final boolean f45411a = d.a.l0.a.k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f45412b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f45413c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static final Object f45414d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static int f45415e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static int f45416f = 0;

    /* loaded from: classes3.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f45417a;

        public a(boolean z) {
            this.f45417a = z;
        }
    }

    public static boolean a() {
        if (f45415e == 2) {
            if (f45411a) {
                Log.d("SwanAppCompat", "has used ab description");
            }
            return true;
        } else if (!l0.f("3.230.0")) {
            return d.a.l0.a.c1.a.Z().m() && !d.a.l0.a.k2.g.h.a().getBoolean("swan_app_js_native_ab_update_key", false);
        } else {
            if (f45411a) {
                Log.w("SwanAppCompat", "disable chrome net, swan js version lower than 3.230.0");
            }
            return false;
        }
    }

    public static String b(String str) {
        d.a.l0.a.e0.d.b("JsNative", f45416f + "-true");
        return f45416f + "-true-" + str + "-" + c();
    }

    public static String c() {
        StringBuilder sb = new StringBuilder();
        synchronized (f45414d) {
            if (f45412b != null) {
                sb.append("v8list:{");
                for (String str : f45412b) {
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
            if (f45413c != null) {
                sb.append("weblist:{");
                for (String str2 : f45413c) {
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
        f45416f = 0;
        String str = z ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
        if (f45415e == 1) {
            if (f45411a) {
                Log.d("SwanAppCompat", "type support default");
            }
            f45416f = 1;
            return SchemeCollecter.getSchemesDes(str, i2);
        }
        if (d.a.l0.a.u.e.j.d.b()) {
            synchronized (f45414d) {
                if (z) {
                    list = f45412b;
                } else {
                    list = f45413c;
                }
                if (list != null && list.size() > 0) {
                    if (f45411a) {
                        Log.d("SwanAppCompat", "support ab js native descriptions");
                    }
                    f45415e = 2;
                    f45416f = 2;
                    return list.get(i2);
                } else if (list != null) {
                    f45416f = 3;
                } else {
                    f45416f = 4;
                }
            }
        }
        if (f45411a) {
            Log.d("SwanAppCompat", "use default descriptions");
        }
        f45415e = 1;
        return SchemeCollecter.getSchemesDes(str, i2);
    }

    public static boolean e() {
        return !l0.f("3.120.2");
    }

    public static void f() {
        if (f45411a) {
            Log.d("SwanAppCompat", "on App upgrade");
        }
        if (d.a.l0.n.c.b() != null && d.a.l0.n.j.i.m.b()) {
            d.a.l0.n.c.b().j().putString("key_online_description_fix_version", "0");
        }
        d.a.l0.a.k2.g.h.a().putBoolean("swan_app_js_native_ab_update_key", true);
        d.a.l0.a.u.e.j.d.f(false);
    }

    public static void g() {
        if (f45411a) {
            Log.e("JsNative", f45416f + "-true");
        }
    }

    public static void h() {
        if (f45411a) {
            Log.d("SwanAppCompat", "start release descriptions");
        }
        synchronized (f45414d) {
            f45415e = 0;
            f45412b = new ArrayList();
            f45413c = new ArrayList();
        }
    }

    public static void i() {
        if (f45411a) {
            Log.d("SwanAppCompat", "start prepare ab description");
        }
        synchronized (f45414d) {
            j(true);
            j(false);
        }
        if (f45411a) {
            Log.d("SwanAppCompat", "end prepare ab description");
        }
    }

    public static void j(boolean z) {
        if (f45411a) {
            StringBuilder sb = new StringBuilder();
            sb.append("start prepare ab description :");
            sb.append(z ? V8Engine.TYPE_V8 : "webview");
            Log.d("SwanAppCompat", sb.toString());
        }
        d.a.l0.a.v2.b1.b.a aVar = new d.a.l0.a.v2.b1.b.a(z);
        if (d.a.l0.a.k2.g.h.a().getBoolean("swan_app_js_native_ab_update_key", false)) {
            if (!aVar.a(3)) {
                return;
            }
            d.a.l0.a.k2.g.h.a().putBoolean("swan_app_js_native_ab_update_key", false);
        }
        List<String> d2 = aVar.d();
        if (d2 != null) {
            k(d2, z);
        }
    }

    public static void k(List<String> list, boolean z) {
        if (list != null && f45415e == 0) {
            if (z) {
                f45412b = list;
            } else {
                f45413c = list;
            }
            if (f45411a) {
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
