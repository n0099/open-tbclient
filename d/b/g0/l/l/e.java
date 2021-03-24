package d.b.g0.l.l;

import android.text.TextUtils;
import d.b.g0.p.h;
import java.util.Map;
/* loaded from: classes3.dex */
public class e {
    public static String a(String str) {
        String a2 = h.a(h.a(h.a(h.a(h.a(h.a(h.a(h.a(h.a(h.a(str, "cuid", d.b.g0.l.f.b().o()), "uuid", d.b.g0.l.f.b().y()), "ut", d.b.g0.l.f.b().w()), "ua", h.b(d.b.g0.l.f.b().q())), "host_app", d.b.g0.l.f.b().s()), "host_app_ver", d.b.g0.l.f.b().q()), "host_os", d.b.g0.p.a.f()), "host_os_ver", d.b.g0.p.a.g()), "network", d.b.g0.p.a.e()), "sdk_ver", d.b.g0.l.f.b().b());
        String a3 = d.b.g0.l.f.a().a();
        if (!TextUtils.isEmpty(a3)) {
            a2 = h.a(a2, "extension_rule", a3);
        }
        String u = d.b.g0.l.f.b().u();
        return !TextUtils.isEmpty(u) ? h.a(a2, "sid", u) : a2;
    }

    public static String b(String str, Map<String, String> map) {
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!TextUtils.isEmpty(map.get(str2))) {
                    str = h.a(str, str2, map.get(str2));
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
        return d.b.g0.l.f.b().r();
    }

    public static String h(String str) {
        return a(str);
    }

    public static String i(String str, Map<String, String> map) {
        return b(a(str), map);
    }
}
