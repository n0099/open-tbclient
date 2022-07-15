package com.kwad.sdk.utils;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.baidu.sofire.utility.PermissionChecker;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.be;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class ao {
    public static String a = "";

    public static String a() {
        return i(false);
    }

    public static List<be.a> a(Context context, int i) {
        return be.a(context, 15);
    }

    public static void a(Context context) {
        com.kwad.sdk.c.b.a(q(context));
    }

    public static com.kwad.sdk.g.kwai.f b() {
        return com.kwad.sdk.g.kwai.f.a();
    }

    public static String b(Context context) {
        return l(context, false);
    }

    public static com.kwad.sdk.g.kwai.b c() {
        return com.kwad.sdk.g.kwai.b.a();
    }

    public static String c(Context context) {
        return m(context, false);
    }

    public static String d(Context context) {
        return n(context, false);
    }

    public static List<com.kwad.sdk.g.kwai.e> d() {
        return aq.b();
    }

    public static String e() {
        return j(false);
    }

    public static String e(Context context) {
        return o(context, false);
    }

    public static String f() {
        com.kwad.sdk.g.kwai.f a2 = com.kwad.sdk.g.kwai.f.a();
        int i = a2 != null ? a2.b : -1;
        if (i >= 0) {
            return com.kwad.sdk.c.b.a(false, String.valueOf(i), 0);
        }
        boolean a3 = ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a();
        String valueOf = String.valueOf(i);
        return !a3 ? com.kwad.sdk.c.b.a(false, valueOf, 1) : com.kwad.sdk.c.b.a(false, valueOf, 2);
    }

    public static String f(Context context) {
        return p(context, false);
    }

    public static String g() {
        com.kwad.sdk.g.kwai.b a2 = com.kwad.sdk.g.kwai.b.a();
        return a2 != null ? com.kwad.sdk.c.b.a(false, a2.toJson(), 0) : !((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).c() ? com.kwad.sdk.c.b.a(false, "", 1) : com.kwad.sdk.c.b.a(false, "", 2);
    }

    public static String g(Context context) {
        return q(context, false);
    }

    public static String h() {
        return com.kwad.sdk.c.b.a(false, "1", 0);
    }

    public static String h(Context context) {
        return r(context, false);
    }

    public static int i(Context context) {
        return av.f(context);
    }

    public static String i() {
        return BuildConfig.VERSION_NAME;
    }

    public static String i(boolean z) {
        String a2 = av.a(z);
        if (!z) {
            return TextUtils.isEmpty(a2) ? "" : a2;
        }
        boolean z2 = true;
        if (TextUtils.isEmpty(a2)) {
            return (an.i() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(2048L)) ? com.kwad.sdk.c.b.a(false, a2, 1) : com.kwad.sdk.c.b.a(false, a2, 5);
        }
        return com.kwad.sdk.c.b.a((!an.i() || TextUtils.isEmpty(an.j())) ? false : false, a2, 0);
    }

    public static int j(Context context) {
        return av.g(context);
    }

    public static String j() {
        return com.kwad.sdk.c.b.a(false, String.valueOf(i()), 0);
    }

    public static String j(boolean z) {
        String u = av.u();
        if (!z) {
            return TextUtils.isEmpty(u) ? "" : u;
        }
        boolean z2 = true;
        if (TextUtils.isEmpty(u)) {
            return (an.c() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(2L)) ? com.kwad.sdk.c.b.a(false, u, 1) : com.kwad.sdk.c.b.a(false, u, 5);
        }
        return com.kwad.sdk.c.b.a((!an.c() || TextUtils.isEmpty(an.f())) ? false : false, u, 0);
    }

    public static String k() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).l();
    }

    public static String k(boolean z) {
        String t = av.t();
        return !z ? TextUtils.isEmpty(t) ? "" : t : !TextUtils.isEmpty(t) ? com.kwad.sdk.c.b.a(an.k(), t, 0) : (an.k() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(8L)) ? com.kwad.sdk.c.b.a(false, t, 1) : com.kwad.sdk.c.b.a(false, t, 2);
    }

    public static Map<String, InstalledAppInfoManager.AppPackageInfo> k(Context context) {
        return InstalledAppInfoManager.b(context);
    }

    public static Location l(Context context) {
        return p.a(context);
    }

    public static String l() {
        return com.kwad.sdk.c.b.a(false, String.valueOf(k()), 0);
    }

    public static String l(Context context, boolean z) {
        String a2 = av.a(context, z);
        if (!z) {
            return TextUtils.isEmpty(a2) ? "" : a2;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(a2)) {
            return com.kwad.sdk.c.b.a((!an.c() || TextUtils.isEmpty(an.d())) ? false : false, a2, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.c.b.a(false, a2, 4);
        } else {
            if (an.c() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(1L)) {
                return com.kwad.sdk.c.b.a(false, a2, 1);
            }
            return com.kwad.sdk.c.b.a(false, a2, SystemUtil.a(context) ? 3 : 1);
        }
    }

    public static String m(Context context) {
        int f = av.f(context);
        if (f > 0) {
            return com.kwad.sdk.c.b.a(false, String.valueOf(f), 0);
        }
        int i = Build.VERSION.SDK_INT;
        String valueOf = String.valueOf(f);
        return i < 23 ? com.kwad.sdk.c.b.a(false, valueOf, 1) : com.kwad.sdk.c.b.a(false, valueOf, 3);
    }

    public static String m(Context context, boolean z) {
        String m = av.m(context);
        if (!z) {
            return TextUtils.isEmpty(m) ? "" : m;
        }
        boolean z2 = true;
        if (TextUtils.isEmpty(m)) {
            return (an.c() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(2L)) ? com.kwad.sdk.c.b.a(false, m, 1) : com.kwad.sdk.c.b.a(false, m, 5);
        }
        return com.kwad.sdk.c.b.a((!an.c() || TextUtils.isEmpty(an.f())) ? false : false, m, 0);
    }

    public static String n(Context context) {
        List<be.a> a2 = a(context, 15);
        if (a2 == null || a2.size() <= 0) {
            if (an.k() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(32L)) {
                return com.kwad.sdk.c.b.a(false, "", 1);
            }
            return com.kwad.sdk.c.b.a(false, "", be.a(context) ? 1 : 3);
        }
        return com.kwad.sdk.c.b.a(an.k(), r.b(a2), 0);
    }

    public static String n(Context context, boolean z) {
        String n = av.n(context);
        if (!z) {
            return TextUtils.isEmpty(n) ? "" : n;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(n)) {
            return com.kwad.sdk.c.b.a((!an.g() || TextUtils.isEmpty(an.h())) ? false : false, n.toLowerCase(), 0);
        } else if (an.g() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(4L)) {
            return com.kwad.sdk.c.b.a(false, n, 0);
        } else {
            return com.kwad.sdk.c.b.a(false, n, ag.a(context, PermissionChecker.ACCESS_WIFI_STATE) == 0 ? 3 : 1);
        }
    }

    public static String o(Context context) {
        Map<String, InstalledAppInfoManager.AppPackageInfo> b = InstalledAppInfoManager.b(context);
        boolean z = true;
        if (b.size() > 0) {
            return com.kwad.sdk.c.b.a((!an.m() || an.n() == null) ? false : false, InstalledAppInfoManager.a(b), 0);
        } else if (an.m() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(16L)) {
            return com.kwad.sdk.c.b.a(false, "", 1);
        } else {
            return com.kwad.sdk.c.b.a(false, "", av.p(context) ? 3 : 1);
        }
    }

    public static String o(Context context, boolean z) {
        String[] e = av.e(context);
        String str = (e == null || e.length <= 0) ? null : e[0];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.c.b.a((!an.c() || TextUtils.isEmpty(an.d())) ? false : false, str, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.c.b.a(false, str, 4);
        } else {
            if (an.c() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(1L)) {
                return com.kwad.sdk.c.b.a(false, str, 1);
            }
            return com.kwad.sdk.c.b.a(false, str, SystemUtil.a(context) ? 3 : 1);
        }
    }

    public static String p(Context context) {
        Location a2 = p.a(context);
        boolean z = true;
        if (a2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("latitude", String.valueOf(a2.getLatitude()));
            hashMap.put("longitude", String.valueOf(a2.getLongitude()));
            return com.kwad.sdk.c.b.a((!an.a() || an.b() == null) ? false : false, r.a(hashMap), 0);
        } else if (an.a() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(64L)) {
            return com.kwad.sdk.c.b.a(false, "", 1);
        } else {
            return com.kwad.sdk.c.b.a(false, "", ContextCompat.checkSelfPermission(context, PermissionChecker.ACCESS_FINE_LOCATION) == 0 ? 3 : 1);
        }
    }

    public static String p(Context context, boolean z) {
        String[] e = av.e(context);
        boolean z2 = true;
        String str = (e == null || e.length <= 1) ? null : e[1];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        } else if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.c.b.a((!an.c() || TextUtils.isEmpty(an.d())) ? false : false, str, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.c.b.a(false, str, 4);
        } else {
            if (an.c() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(1L)) {
                return com.kwad.sdk.c.b.a(false, str, 1);
            }
            return com.kwad.sdk.c.b.a(false, str, SystemUtil.a(context) ? 3 : 1);
        }
    }

    @NonNull
    public static com.kwad.sdk.c.c q(final Context context) {
        return new com.kwad.sdk.c.c() { // from class: com.kwad.sdk.utils.ao.1
            @Override // com.kwad.sdk.c.a
            public final String a() {
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getIMEI:" + ao.l(context, true));
                return ao.l(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String b() {
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getOaid:" + ao.i(true));
                return ao.i(true);
            }

            @Override // com.kwad.sdk.c.a
            public final String c() {
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getAndroidID:" + ao.m(context, true));
                return ao.m(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String d() {
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getMac:" + ao.n(context, true));
                return ao.n(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String e() {
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getIMEI2:" + ao.o(context, true));
                return ao.o(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String f() {
                String p = ao.p(context, true);
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getIMEI2:" + p);
                return p;
            }

            @Override // com.kwad.sdk.c.a
            public final String g() {
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getIMSI:" + ao.q(context, true));
                return ao.q(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String h() {
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getIccId:" + ao.r(context, true));
                return ao.r(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String i() {
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + ao.m(context));
                return ao.m(context);
            }

            @Override // com.kwad.sdk.c.a
            public final String j() {
                String f = ao.f();
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getSimCardActivePhoneCount:" + f);
                return f;
            }

            @Override // com.kwad.sdk.c.a
            public final String k() {
                String g = ao.g();
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getBaseStationInfo:" + g);
                return g;
            }

            @Override // com.kwad.sdk.c.a
            public final String l() {
                String j = ao.j(true);
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getDeviceId:" + j);
                return j;
            }

            @Override // com.kwad.sdk.c.a
            public final String m() {
                String k = ao.k(true);
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getIp:" + k);
                return k;
            }

            @Override // com.kwad.sdk.c.a
            public final String n() {
                String n = ao.n(context);
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getWifiList:" + n);
                return n;
            }

            @Override // com.kwad.sdk.c.a
            public final String o() {
                String p = ao.p(context);
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getLocation:" + p);
                return p;
            }

            @Override // com.kwad.sdk.c.a
            public final String p() {
                String o = ao.o(context);
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getAppList:" + o);
                return o;
            }

            @Override // com.kwad.sdk.c.a
            public final String q() {
                String h = ao.h();
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getSdkType:" + h);
                return h;
            }

            @Override // com.kwad.sdk.c.a
            public final String r() {
                String j = ao.j();
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getSdkVersion:" + j);
                return j;
            }

            @Override // com.kwad.sdk.c.a
            public final String s() {
                String l = ao.l();
                com.kwad.sdk.core.d.b.a("SDKPrivateSafetyDataUtil", "getAppId:" + l);
                return l;
            }
        };
    }

    public static String q(Context context, boolean z) {
        String h = av.h(context);
        if (!z) {
            return TextUtils.isEmpty(h) ? "" : h;
        } else if (TextUtils.isEmpty(h)) {
            if (Build.VERSION.SDK_INT >= 29) {
                return com.kwad.sdk.c.b.a(false, h, 4);
            }
            if (an.c() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(128L)) {
                return com.kwad.sdk.c.b.a(false, h, 1);
            }
            return com.kwad.sdk.c.b.a(false, h, SystemUtil.a(context) ? 3 : 1);
        } else {
            return com.kwad.sdk.c.b.a(an.c(), h, 0);
        }
    }

    public static String r(Context context, boolean z) {
        String i = av.i(context);
        if (!z) {
            return TextUtils.isEmpty(i) ? "" : i;
        } else if (TextUtils.isEmpty(i)) {
            if (an.c() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(128L)) {
                return com.kwad.sdk.c.b.a(false, i, 1);
            }
            return com.kwad.sdk.c.b.a(false, i, SystemUtil.a(context) ? 3 : 1);
        } else {
            return com.kwad.sdk.c.b.a(an.c(), i, 0);
        }
    }
}
