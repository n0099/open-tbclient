package d.b.g0.a.s1.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.facebook.common.internal.Sets;
import d.b.g0.a.k;
import d.b.g0.a.r1.d;
import d.b.g0.a.r1.e;
import d.b.g0.a.z1.h;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import okhttp3.CertificatePinner;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45907a = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f45908b = Sets.newHashSet("https", "wss");

    public static boolean a(String str) {
        if (f45907a && !d.b.g0.a.m1.a.a.x()) {
            Log.w("WebSafeCheckers", "checkWebAction: Debug下鉴权未开启");
            return true;
        } else if (TextUtils.isEmpty(str)) {
            d.b.g0.a.c0.c.g("WebSafeCheckers", "action is not in white list: action=" + str);
            return false;
        } else {
            e y = e.y();
            if (y == null) {
                d.b.g0.a.c0.c.l("WebSafeCheckers", "get swanApp Null " + str);
                return false;
            }
            ArrayList<String> a2 = y.X().a();
            if (a2 != null && a2.contains(str)) {
                if (f45907a) {
                    Log.d("WebSafeCheckers", "Action in white list: " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + a2);
                }
                return true;
            }
            d.b.g0.a.c0.c.g("WebSafeCheckers", "action is not in adLanding white list: action=" + str);
            return false;
        }
    }

    public static boolean b(String str, ArrayList<String> arrayList) {
        if (!TextUtils.isEmpty(str) && arrayList != null && arrayList.size() != 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    if (TextUtils.equals(str, next)) {
                        return true;
                    }
                    if (next.startsWith(CertificatePinner.Pin.WILDCARD) && str.endsWith(next.substring(2))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(String str, String str2, String str3) {
        boolean z;
        String host;
        ArrayList<String> arrayList;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (f45907a) {
                Log.i("WebSafeCheckers", "requestName : " + str);
                Log.i("WebSafeCheckers", "requestUrl : " + str2);
            }
            boolean z2 = !d.b.g0.a.m1.a.a.t();
            boolean z3 = false;
            if (z2) {
                if (f45907a) {
                    Log.d("WebSafeCheckers", "debug包serverDomains鉴权关闭： " + z2);
                }
                return 0;
            }
            boolean i = i();
            if (!i) {
                if (f45907a) {
                    Log.d("WebSafeCheckers", "开发包serverDomains鉴权关闭： " + i);
                }
                return 0;
            } else if (d(str2)) {
                boolean J = d.b.g0.a.w0.a.N().J();
                if (!J) {
                    if (f45907a) {
                        Log.d("WebSafeCheckers", "AB实验serverDomains鉴权关闭： " + J);
                    }
                    return 0;
                }
                e y = e.y();
                if (y == null) {
                    return 1;
                }
                String str4 = y.f45740f;
                if (TextUtils.isEmpty(str4)) {
                    return 1;
                }
                if (TextUtils.isEmpty(str3)) {
                    if (!new File(c.d(str4, "aiapps_folder/cloud_config", "server_domains.json")).exists()) {
                        if (f45907a) {
                            Log.w("WebSafeCheckers", "服务器域名配置文件未下发放行");
                        }
                        return 0;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        host = new URI(str2).getHost();
                        arrayList = y.X().b(e.T(), str, false).f45918b;
                        z = b(host, arrayList);
                    } catch (URISyntaxException e2) {
                        e = e2;
                    }
                    try {
                        d.b.g0.a.c0.c.a("WebSafeCheckers", "serverDomain: " + host + ", ServerDomains: ", arrayList);
                        StringBuilder sb = new StringBuilder();
                        sb.append("domain: ");
                        sb.append(host);
                        d.b.g0.a.c0.c.g("WebSafeCheckers", sb.toString());
                    } catch (URISyntaxException e3) {
                        e = e3;
                        z3 = z;
                        if (f45907a) {
                            Log.e("WebSafeCheckers", Log.getStackTraceString(e));
                        }
                        z = z3;
                        if (!z) {
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (f45907a) {
                        }
                        return !z;
                    }
                    if (!z) {
                        d.b.g0.a.c0.c.g("WebSafeCheckers", "domain is not in white list");
                    }
                    long currentTimeMillis22 = System.currentTimeMillis();
                    if (f45907a) {
                        Log.d("WebSafeCheckers", "serverDomain: cost time = " + (currentTimeMillis22 - currentTimeMillis) + "ms");
                        if (z != 0) {
                            Log.d("WebSafeCheckers", "serverDomain in white list");
                        } else {
                            Log.d("WebSafeCheckers", "serverDomain not in white list");
                        }
                    }
                    return !z;
                }
                return !d.b.g0.a.l1.g.a.c(str, str2, d.b.g0.a.l1.g.b.g(str3)) ? 1 : 0;
            } else {
                return 2;
            }
        }
        if (f45907a) {
            Log.d("WebSafeCheckers", "server domains: requestName or requestUrl is empty");
        }
        return 1;
    }

    public static boolean d(String str) {
        for (String str2 : f45908b) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        if (d.b.g0.a.m1.a.a.m()) {
            return true;
        }
        boolean C = d.b.g0.a.w0.a.N().C();
        if (f45907a) {
            Log.d("WebSafeCheckers", "abTestHttpsProtocolSwitch=" + C);
        }
        return !C && str.startsWith("http");
    }

    public static boolean e(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("weixin://wap/pay");
    }

    public static boolean f(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("alipays://platformapi/startapp");
    }

    public static boolean g(String str) {
        if (f45907a && !d.b.g0.a.m1.a.a.x()) {
            Log.w("WebSafeCheckers", "checkWebAction: Debug下鉴权未开启");
            return true;
        } else if (TextUtils.isEmpty(str)) {
            d.b.g0.a.c0.c.l("WebSafeCheckers", "action is not in white list: action=" + str);
            return false;
        } else {
            e y = e.y();
            if (y == null) {
                d.b.g0.a.c0.c.l("WebSafeCheckers", "get swanApp Null " + str);
                return false;
            }
            ArrayList<String> c2 = y.X().c(true);
            if (c2 != null && c2.contains(str)) {
                if (f45907a) {
                    Log.d("WebSafeCheckers", "Action in white list: " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + c2);
                }
                return true;
            }
            d.b.g0.a.c0.c.a("WebSafeCheckers", "Action not in white list: action=" + str + ", whitelist=", c2);
            StringBuilder sb = new StringBuilder();
            sb.append("action is not in white list: action=");
            sb.append(str);
            d.b.g0.a.c0.c.g("WebSafeCheckers", sb.toString());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean h(String str) {
        boolean z;
        e y = e.y();
        boolean z2 = false;
        if (y == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (!d.b.g0.a.m1.a.a.x()) {
            if (f45907a) {
                Log.w("WebSafeCheckers", "checkWebHost: Debug下鉴权未开启");
            }
            return true;
        }
        boolean r = d.b.g0.a.w0.a.N().r();
        if (!r) {
            if (f45907a) {
                Log.w("WebSafeCheckers", "ABTest : webDomains switch " + r);
            }
            return true;
        } else if (!i()) {
            if (f45907a) {
                Log.d("WebSafeCheckers", "checkWebDomains: 线下环境开发者授权跳过域名校验");
            }
            return true;
        } else {
            String T = e.T();
            if (c.i(T)) {
                ArrayList<String> d2 = y.X().d(T, false);
                if (lowerCase.startsWith("weixin://wap/pay") && d2.contains("wx.tenpay.com")) {
                    if (f45907a) {
                        Log.d("WebSafeCheckers", "url is weixin pay, Domain in white list url: " + str + " name: " + y.M());
                    }
                    h.A("wechatH5", str, d2);
                    return true;
                } else if (lowerCase.startsWith("alipays://platformapi/startapp") && (d2.contains("*.alipay.com") || d2.contains("*.alipayobjects.com"))) {
                    if (f45907a) {
                        Log.d("WebSafeCheckers", "url is ali pay, Domain in white list url: " + str + " name: " + y.M());
                    }
                    h.A("alipayH5", str, d2);
                    return true;
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (TextUtils.isEmpty(str)) {
                        if (f45907a) {
                            Log.w("WebSafeCheckers", "checkWebDomain: url is empty");
                        }
                        return false;
                    }
                    try {
                        String host = new URL(str).getHost();
                        if (!TextUtils.isEmpty(host) && d2 != null) {
                            Iterator<String> it = d2.iterator();
                            while (it.hasNext()) {
                                String next = it.next();
                                if (next != null) {
                                    if (next.startsWith(CertificatePinner.Pin.WILDCARD)) {
                                        if (host.endsWith(next.substring(2))) {
                                            z = true;
                                            break;
                                        }
                                    } else if (TextUtils.equals(next, host)) {
                                        z = true;
                                        break;
                                    }
                                }
                            }
                        }
                        z = false;
                        try {
                            d.b.g0.a.c0.c.a("WebSafeCheckers", "domain: " + host + ", domains: ", d2);
                            StringBuilder sb = new StringBuilder();
                            sb.append("domain: ");
                            sb.append(host);
                            d.b.g0.a.c0.c.g("WebSafeCheckers", sb.toString());
                        } catch (MalformedURLException e2) {
                            e = e2;
                            z2 = z;
                            if (f45907a) {
                                Log.e("WebSafeCheckers", Log.getStackTraceString(e));
                            }
                            z = z2;
                            if (f45907a) {
                            }
                            if (!z) {
                            }
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (f45907a) {
                            }
                            return z;
                        }
                    } catch (MalformedURLException e3) {
                        e = e3;
                    }
                    if (f45907a) {
                        if (z) {
                            Log.d("WebSafeCheckers", "Domain in white list");
                        } else {
                            Log.d("WebSafeCheckers", "Domain not in white list");
                        }
                    }
                    if (!z) {
                        d.b.g0.a.c0.c.g("WebSafeCheckers", "domain is not in white list");
                    }
                    long currentTimeMillis22 = System.currentTimeMillis();
                    if (f45907a) {
                        Log.d("WebSafeCheckers", "checkWebDomain: cost time = " + (currentTimeMillis22 - currentTimeMillis) + "ms");
                    }
                    return z;
                }
            }
            return true;
        }
    }

    public static boolean i() {
        if (d.e().h() == 0 && SwanAppConfigData.f.d()) {
            if (f45907a) {
                Log.d("WebSafeCheckers", "授权跳过url校验");
                return false;
            }
            return false;
        }
        return true;
    }
}
