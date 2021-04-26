package d.a.h0.l.l;

import android.text.TextUtils;
import d.a.h0.p.h;
import java.util.Map;
/* loaded from: classes3.dex */
public class e {
    public static String a(String str) {
        String a2 = h.a(h.a(h.a(h.a(h.a(h.a(h.a(h.a(h.a(h.a(str, "cuid", d.a.h0.l.f.b().w()), "uuid", d.a.h0.l.f.b().s()), "ut", d.a.h0.l.f.b().B()), "ua", h.b(d.a.h0.l.f.b().y())), "host_app", d.a.h0.l.f.b().o()), "host_app_ver", d.a.h0.l.f.b().y()), "host_os", d.a.h0.p.a.f()), "host_os_ver", d.a.h0.p.a.g()), "network", d.a.h0.p.a.e()), "sdk_ver", d.a.h0.l.f.b().i());
        String a3 = d.a.h0.l.f.a().a();
        if (!TextUtils.isEmpty(a3)) {
            a2 = h.a(a2, "extension_rule", a3);
        }
        String q = d.a.h0.l.f.b().q();
        return !TextUtils.isEmpty(q) ? h.a(a2, "sid", q) : a2;
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
        return d.a.h0.l.f.b().z();
    }

    public static String h(String str) {
        return a(str);
    }

    public static String i(String str, Map<String, String> map) {
        return b(a(str), map);
    }
}
