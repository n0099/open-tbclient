package d.a.i0.n.i;

import android.text.TextUtils;
import d.a.i0.t.i;
import java.util.Map;
/* loaded from: classes3.dex */
public class f {
    public static String a(String str) {
        String a2 = i.a(i.a(i.a(i.a(i.a(i.a(i.a(i.a(i.a(i.a(i.a(str, "cuid", d.a.i0.n.c.b().h()), "uuid", d.a.i0.n.c.b().e()), "ut", d.a.i0.n.c.b().E()), "ua", i.b(d.a.i0.n.c.b().i())), "host_app", d.a.i0.n.c.b().c()), "host_app_ver", d.a.i0.n.c.b().i()), "host_os", d.a.i0.t.a.f()), "host_os_ver", d.a.i0.t.a.g()), "network", d.a.i0.t.a.e()), "sdk_ver", d.a.i0.n.c.b().b()), "ut_score", String.valueOf(d.a.i0.n.c.b().a()));
        String q = d.a.i0.n.c.b().q();
        return !TextUtils.isEmpty(q) ? i.a(a2, "sid", q) : a2;
    }

    public static String b(String str, Map<String, String> map) {
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!TextUtils.isEmpty(map.get(str2))) {
                    str = i.a(str, str2, map.get(str2));
                }
            }
        }
        return str;
    }

    public static String c() {
        return String.format("%s/fetchpkglist", g());
    }

    public static String d() {
        return String.format("%s/getpkg", g());
    }

    public static String e() {
        return String.format("%s/getplugin", g());
    }

    public static String f() {
        return String.format("%s/updatecore", g());
    }

    public static String g() {
        return d.a.i0.n.c.b().B();
    }

    public static String h(String str) {
        return a(str);
    }

    public static String i(String str, Map<String, String> map) {
        return b(a(str), map);
    }
}
