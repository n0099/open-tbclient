package d.a.i0.a.d0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import d.a.i0.a.l;
import d.a.i0.a.r1.l.d;
import d.a.i0.a.s.a.f;
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.q0;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f41135a = a.b();

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f41136b = {a.c(), a.d(), "https://ossapi.baidu.com", "https://ext.baidu.com"};

    public static String a(String str, String str2, String str3) {
        StringBuilder sb;
        StringBuilder sb2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str4 = str2 + "=";
        int indexOf = str.indexOf("?");
        String str5 = null;
        if (indexOf < 0) {
            int indexOf2 = str.indexOf("#");
            if (indexOf2 < 0) {
                sb2 = new StringBuilder(str);
            } else {
                str5 = str.substring(indexOf2);
                sb2 = new StringBuilder(str.substring(0, indexOf2));
            }
            sb2.append("?");
            sb2.append(str4);
            sb2.append(str3);
            if (str5 != null) {
                sb2.append(str5);
            }
            return sb2.toString();
        }
        if (str.indexOf("&" + str4, indexOf) < 0) {
            if (str.indexOf("?" + str4, indexOf) < 0) {
                int indexOf3 = str.indexOf("#");
                if (indexOf3 < 0) {
                    sb = new StringBuilder(str);
                } else {
                    str5 = str.substring(indexOf3);
                    str = str.substring(0, indexOf3);
                    sb = new StringBuilder(str);
                }
                if (!str.endsWith("&") && !str.endsWith("?")) {
                    sb.append("&");
                }
                sb.append(str4);
                sb.append(str3);
                if (str5 != null) {
                    sb.append(str5);
                }
                return sb.toString();
            }
            return str;
        }
        return str;
    }

    public static String b(String str) {
        String a2 = d.a();
        return a2 != null ? a(str, "launchid", a2) : str;
    }

    public static int c() {
        NetworkInfo networkInfo;
        String str = null;
        try {
            networkInfo = ((ConnectivityManager) d.a.i0.a.c1.a.b().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (NullPointerException unused) {
            networkInfo = null;
        }
        if (networkInfo != null) {
            str = "wifi".equals(networkInfo.getTypeName().toLowerCase()) ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : networkInfo.getExtraInfo();
        }
        if (str != null) {
            String upperCase = str.toUpperCase();
            if (CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING.equals(upperCase)) {
                return 1;
            }
            if ("3GNET".equals(upperCase)) {
                return 21;
            }
            if ("3GWAP".equals(upperCase)) {
                return 22;
            }
            if ("CMNET".equals(upperCase)) {
                return 31;
            }
            if ("UNINET".equals(upperCase)) {
                return 32;
            }
            if ("CTNET".equals(upperCase)) {
                return 33;
            }
            if ("CMWAP".equals(upperCase)) {
                return 41;
            }
            if ("UNIWAP".equals(upperCase)) {
                return 42;
            }
            return "CTWAP".equals(upperCase) ? 43 : 5;
        }
        return 5;
    }

    public static String d() {
        return d.a.i0.a.c1.a.m().a();
    }

    public static String e() {
        return "a0";
    }

    public static String f() {
        String g2 = g();
        String h2 = h();
        int i2 = Build.VERSION.SDK_INT;
        String i3 = i();
        return g2 + "_" + h2 + "_" + i2 + "_" + i3;
    }

    public static String g() {
        String str = Build.MODEL;
        return TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
    }

    public static String h() {
        String str = Build.VERSION.RELEASE;
        return TextUtils.isEmpty(str) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : str.replace("_", "-");
    }

    public static String i() {
        String str = Build.MANUFACTURER;
        return TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String k() {
        return j(s());
    }

    public static String l() {
        return j(t());
    }

    public static String m() {
        return j(f());
    }

    public static int n() {
        NetworkInfo c2 = SwanAppNetworkUtils.c(d.a.i0.a.c1.a.b());
        if (c2 == null) {
            return 0;
        }
        return c2.getSubtype();
    }

    public static String o() {
        return c() + "_" + n();
    }

    public static String p() {
        return AppRuntime.getApplication().getPackageName();
    }

    public static String q() {
        return "android";
    }

    public static String r() {
        return l.a();
    }

    public static String s() {
        Context appContext = AppRuntime.getAppContext();
        int o = n0.o(appContext);
        int n = n0.n(appContext);
        int m = n0.m(appContext);
        String q = q();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(o);
        stringBuffer.append("_");
        stringBuffer.append(n);
        stringBuffer.append("_");
        stringBuffer.append(q);
        stringBuffer.append("_");
        stringBuffer.append(q0.D());
        stringBuffer.append("_");
        stringBuffer.append(m);
        return stringBuffer.toString();
    }

    public static String t() {
        return d.a.i0.a.c1.a.a0().i(AppRuntime.getAppContext());
    }

    public static boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : f41136b) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String v(String str) {
        return w(str, false);
    }

    public static String w(String str, boolean z) {
        String a2 = a(a(a(a(a(a(a(a(a(a(str, "uid", l()), "ua", k()), "ut", m()), "osbranch", e()), "pkgname", p()), "network", o()), "appname", d()), "hostname", d()), "swan_sdk_version", r()), "mnpunion", String.valueOf(f.f44406d.f() ? 2 : 0));
        return z ? b(a2) : a2;
    }
}
