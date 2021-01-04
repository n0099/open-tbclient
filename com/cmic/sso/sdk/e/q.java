package com.cmic.sso.sdk.e;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.ETAG;
import com.cmic.sso.sdk.e.k;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f8034a = false;

    public static void b(com.cmic.sso.sdk.a aVar) {
        if (f8034a) {
            c.a("UmcConfigUtil", "正在获取配置中...");
            return;
        }
        f8034a = true;
        com.cmic.sso.sdk.c.c.a.esP().a(aVar.b("isNeedToGetCert", true), aVar, new com.cmic.sso.sdk.c.c.d() { // from class: com.cmic.sso.sdk.e.q.1
            @Override // com.cmic.sso.sdk.c.c.d
            public void i(String str, String str2, JSONObject jSONObject) {
                try {
                    if ("103000".equals(str)) {
                        q.b(jSONObject);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                boolean unused = q.f8034a = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(JSONObject jSONObject) {
        String str;
        String str2;
        CharSequence charSequence;
        CharSequence charSequence2;
        String str3;
        String str4;
        String str5;
        String str6 = null;
        k.a esV = k.esV();
        try {
            esV.a("getConfigDate", p.b());
            if (jSONObject.has("client_valid")) {
                esV.a("client_valid", (Integer.valueOf(jSONObject.getString("client_valid")).intValue() * 60 * 60 * 1000) + System.currentTimeMillis());
            }
            if (jSONObject.has("Configlist")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("Configlist");
                if (jSONObject2.has("CHANGE_HOST")) {
                    String string = jSONObject2.getString("CHANGE_HOST");
                    if (string.contains("M005")) {
                        String[] split = string.split(ETAG.ITEM_SEPARATOR);
                        int length = split.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                str4 = null;
                                break;
                            }
                            String str7 = split[i];
                            if (str7.contains("M005")) {
                                str4 = str7;
                                break;
                            }
                            i++;
                        }
                        if (!TextUtils.isEmpty(str4)) {
                            if (str4.contains(",")) {
                                str5 = str4.substring(str4.indexOf("=") + 1, str4.indexOf(","));
                                str2 = str4.substring(str4.lastIndexOf("=") + 1);
                            } else if (str4.contains("https") || str4.contains("HTTPS")) {
                                str2 = str4.substring(str4.lastIndexOf("=") + 1);
                                str5 = null;
                            } else if (str4.contains(HttpHost.DEFAULT_SCHEME_NAME) || str4.contains(HttpVersion.HTTP)) {
                                str5 = str4.substring(str4.lastIndexOf("=") + 1);
                                str2 = null;
                            }
                            c.a("UmcConfigUtil", "HTTP:" + str5 + "||||||||HTTPS:" + str2);
                            esV.a("httpHost", str5);
                            esV.a("httpsHost", str2);
                        }
                        str5 = null;
                        str2 = null;
                        c.a("UmcConfigUtil", "HTTP:" + str5 + "||||||||HTTPS:" + str2);
                        esV.a("httpHost", str5);
                        esV.a("httpsHost", str2);
                    } else {
                        str2 = null;
                    }
                    if (string.contains("M007")) {
                        String[] split2 = string.split(ETAG.ITEM_SEPARATOR);
                        int length2 = split2.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length2) {
                                str = null;
                                break;
                            }
                            str = split2[i2];
                            if (str.contains("M007")) {
                                break;
                            }
                            i2++;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            str = str.substring(str.lastIndexOf("=") + 1);
                        }
                        c.a("UmcConfigUtil", "HTTPS:" + str);
                        esV.a("logHost", str);
                    } else {
                        str = null;
                    }
                } else {
                    str = null;
                    str2 = null;
                }
                if (jSONObject2.has("HOST_CERT_INFO")) {
                    String string2 = jSONObject2.getString("HOST_CERT_INFO");
                    String[] split3 = string2.split(ETAG.ITEM_SEPARATOR);
                    if (TextUtils.isEmpty(str) || !str.contains(":")) {
                        charSequence = str;
                    } else {
                        String substring = str.substring(0, str.indexOf(":"));
                        c.a("UmcConfigUtil", "logHostWithoutHost:" + substring);
                        charSequence = substring;
                    }
                    if (!TextUtils.isEmpty(str) && string2.contains(charSequence)) {
                        int length3 = split3.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length3) {
                                break;
                            }
                            String str8 = split3[i3];
                            if (!TextUtils.isEmpty(str) && str8.contains(charSequence)) {
                                str6 = str8;
                                break;
                            }
                            i3++;
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            str6 = str6.substring(str6.indexOf(":") + 1, str6.indexOf(","));
                        }
                        c.a("UmcConfigUtil", "log CERT:");
                        esV.a(SapiUtils.COOKIE_HTTPS_URL_PREFIX + str + "/log/logReport", str6);
                    }
                    if (string2.contains("log1.cmpassport.com")) {
                        int length4 = split3.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length4) {
                                break;
                            }
                            String str9 = split3[i4];
                            if (str9.contains("log1.cmpassport.com")) {
                                str6 = str9;
                                break;
                            }
                            i4++;
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            str6 = str6.substring(str6.indexOf(":") + 1, str6.indexOf(","));
                        }
                        c.a("UmcConfigUtil", "log1 CERT:");
                        esV.a("https://log1.cmpassport.com:9443/log/logReport", str6);
                    }
                    if (TextUtils.isEmpty(str2) || !str2.contains(":")) {
                        charSequence2 = str2;
                    } else {
                        String substring2 = str2.substring(0, str2.indexOf(":"));
                        c.a("UmcConfigUtil", "httpsHostWithoutPort:" + substring2);
                        charSequence2 = substring2;
                    }
                    if (!TextUtils.isEmpty(str2) && string2.contains(charSequence2)) {
                        int length5 = split3.length;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length5) {
                                break;
                            }
                            String str10 = split3[i5];
                            if (!TextUtils.isEmpty(str2) && str10.contains(charSequence2)) {
                                str6 = str10;
                                break;
                            }
                            i5++;
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            str6 = str6.substring(str6.indexOf(":") + 1, str6.indexOf(","));
                        }
                        c.a("UmcConfigUtil", "httpsHost CERT:");
                        esV.a(SapiUtils.COOKIE_HTTPS_URL_PREFIX + str2 + "/unisdk", str6);
                    }
                    if (string2.contains("onekey1.cmpassport.com")) {
                        int length6 = split3.length;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= length6) {
                                str3 = str6;
                                break;
                            }
                            str3 = split3[i6];
                            if (str3.contains("onekey1.cmpassport.com")) {
                                break;
                            }
                            i6++;
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            str3 = str3.substring(str3.indexOf(":") + 1, str3.indexOf(","));
                        }
                        c.a("UmcConfigUtil", "omekey1 CERT:");
                        esV.a("https://onekey1.cmpassport.com/unisdk", str3);
                    }
                }
                a(jSONObject2, "CLOSE_CERT_VERIFY", "0", esV);
                a(jSONObject2, "CLOSE_FRIEND_WAPKS", "0", esV);
                a(jSONObject2, "CLOSE_LOGS_VERSION", "0", esV);
                a(jSONObject2, "CLOSE_IPV4_LIST", "0", esV);
                a(jSONObject2, "CLOSE_IPV6_LIST", "1", esV);
                a(jSONObject2, "CLOSE_M001_SDKVERSION_LIST", "0", esV);
                a(jSONObject2, "CLOSE_M001_APPID_LIST", "0", esV);
                a(jSONObject2, "CLOSE_M005_SDKVERSION_LIST", "0", esV);
                a(jSONObject2, "CLOSE_M005_APPID_LIST", "0", esV);
                if (jSONObject2.has("LOGS_CONTROL")) {
                    String[] split4 = jSONObject2.getString("LOGS_CONTROL").replace("h", "").split(ETAG.ITEM_SEPARATOR);
                    if (split4.length > 0 && !TextUtils.isEmpty(split4[0])) {
                        esV.a("maxFailedLogTimes", Integer.parseInt(split4[0]));
                    }
                    if (1 < split4.length && !TextUtils.isEmpty(split4[1])) {
                        esV.a("pauseTime", Integer.parseInt(split4[1]));
                    }
                }
            }
        } catch (Exception e) {
            c.a("UmcConfigUtil", e.getMessage());
        } finally {
            esV.b();
        }
    }

    private static void a(JSONObject jSONObject, String str, String str2, k.a aVar) {
        if (jSONObject.has(str)) {
            aVar.a(str, jSONObject.optString(str, str2));
        }
    }

    public static boolean a() {
        return System.currentTimeMillis() >= k.a("client_valid", 0L);
    }

    public static boolean b() {
        return "1".equals(k.b("CLOSE_IPV4_LIST", "0"));
    }

    public static boolean c() {
        return "1".equals(k.b("CLOSE_IPV6_LIST", "0"));
    }

    public static boolean d() {
        return "1".equals(k.b("CLOSE_M001_SDKVERSION_LIST", "0")) || "1".equals(k.b("CLOSE_M001_APPID_LIST", "0")) || "1".equals(k.b("CLOSE_M005_APPID_LIST", "0")) || "1".equals(k.b("CLOSE_M005_SDKVERSION_LIST", "0"));
    }

    public static String e() {
        String b2 = k.b("httpHost", null);
        return TextUtils.isEmpty(b2) ? "http://www.cmpassport.com/unisdk" : "http://" + b2 + "/unisdk";
    }

    public static String f() {
        String b2 = k.b("httpsHost", null);
        return TextUtils.isEmpty(b2) ? "https://onekey1.cmpassport.com/unisdk" : SapiUtils.COOKIE_HTTPS_URL_PREFIX + b2 + "/unisdk";
    }

    public static String g() {
        String b2 = k.b("logHost", "");
        return TextUtils.isEmpty(b2) ? "https://log1.cmpassport.com:9443/log/logReport" : SapiUtils.COOKIE_HTTPS_URL_PREFIX + b2 + "/log/logReport";
    }

    public static boolean h() {
        return "1".equals(k.b("CLOSE_CERT_VERIFY", "1"));
    }

    public static boolean i() {
        return k.b("CLOSE_FRIEND_WAPKS", "").contains("CU");
    }

    public static boolean j() {
        return k.b("CLOSE_FRIEND_WAPKS", "").contains("CT");
    }

    public static boolean k() {
        return "1".equals(k.b("CLOSE_LOGS_VERSION", "0"));
    }

    public static int l() {
        return k.a("maxFailedLogTimes", 0);
    }

    public static int m() {
        return k.a("pauseTime", 0) * 60 * 60 * 1000;
    }

    public static String a(String str) {
        return k.b(str, "");
    }
}
