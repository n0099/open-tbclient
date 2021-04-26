package d.a.h0.a.b0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.l;
import d.a.h0.a.r.a.f;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f41267a = {BaseUrlManager.ONLINE_URL, "https://ossapi.baidu.com", "https://ext.baidu.com"};

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

    public static int b() {
        NetworkInfo networkInfo;
        String str = null;
        try {
            networkInfo = ((ConnectivityManager) d.a.h0.a.w0.a.c().getSystemService("connectivity")).getActiveNetworkInfo();
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

    public static String c() {
        return d.a.h0.a.w0.a.k().f();
    }

    public static String d() {
        return "a0";
    }

    public static String e() {
        String f2 = f();
        String g2 = g();
        int i2 = Build.VERSION.SDK_INT;
        String h2 = h();
        return f2 + "_" + g2 + "_" + i2 + "_" + h2;
    }

    public static String f() {
        String str = Build.MODEL;
        return TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
    }

    public static String g() {
        String str = Build.VERSION.RELEASE;
        return TextUtils.isEmpty(str) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : str.replace("_", "-");
    }

    public static String h() {
        String str = Build.MANUFACTURER;
        return TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
    }

    public static String i(String str) {
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

    public static String j() {
        return i(r());
    }

    public static String k() {
        return i(s());
    }

    public static String l() {
        return i(e());
    }

    public static int m() {
        NetworkInfo c2 = SwanAppNetworkUtils.c(d.a.h0.a.w0.a.c());
        if (c2 == null) {
            return 0;
        }
        return c2.getSubtype();
    }

    public static String n() {
        return b() + "_" + m();
    }

    public static String o() {
        return AppRuntime.getApplication().getPackageName();
    }

    public static String p() {
        return "android";
    }

    public static String q() {
        return l.a();
    }

    public static String r() {
        Context appContext = AppRuntime.getAppContext();
        int m = h0.m(appContext);
        int l = h0.l(appContext);
        int k = h0.k(appContext);
        String p = p();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(m);
        stringBuffer.append("_");
        stringBuffer.append(l);
        stringBuffer.append("_");
        stringBuffer.append(p);
        stringBuffer.append("_");
        stringBuffer.append(k0.z());
        stringBuffer.append("_");
        stringBuffer.append(k);
        return stringBuffer.toString();
    }

    public static String s() {
        return d.a.h0.a.w0.a.O().f(AppRuntime.getAppContext());
    }

    public static boolean t(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : f41267a) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String u(String str) {
        return a(a(a(a(a(a(a(a(a(a(str, "uid", k()), "ua", j()), "ut", l()), "osbranch", d()), "pkgname", o()), "network", n()), "appname", c()), "hostname", c()), "swan_sdk_version", q()), "mnpunion", String.valueOf(f.f43778d.e() ? 2 : 0));
    }
}
