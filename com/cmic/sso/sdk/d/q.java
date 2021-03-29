package com.cmic.sso.sdk.d;

import android.text.TextUtils;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.cmic.sso.sdk.d.k;
import org.apache.http.HttpVersion;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f30707a = false;

    /* JADX WARN: Removed duplicated region for block: B:193:0x0314 A[Catch: all -> 0x0356, Exception -> 0x0358, Merged into TryCatch #0 {all -> 0x0356, Exception -> 0x0358, blocks: (B:3:0x001a, B:5:0x0027, B:6:0x0046, B:8:0x004c, B:11:0x005a, B:14:0x0066, B:16:0x006e, B:21:0x007b, B:23:0x0081, B:25:0x0087, B:44:0x00d9, B:46:0x00e0, B:48:0x00e8, B:50:0x00f7, B:52:0x00fc, B:54:0x0101, B:56:0x0107, B:58:0x010f, B:63:0x011c, B:65:0x0122, B:66:0x012c, B:68:0x0133, B:70:0x0142, B:73:0x0148, B:75:0x014e, B:78:0x015e, B:80:0x0164, B:82:0x0174, B:84:0x0183, B:87:0x018b, B:89:0x0191, B:91:0x0195, B:93:0x019f, B:98:0x01ac, B:100:0x01b2, B:103:0x01c3, B:105:0x01d3, B:109:0x01e1, B:111:0x01e7, B:113:0x01eb, B:118:0x01fd, B:120:0x0203, B:123:0x0214, B:125:0x0219, B:127:0x021f, B:129:0x0225, B:131:0x022b, B:133:0x023b, B:135:0x024a, B:137:0x0250, B:139:0x0256, B:141:0x025a, B:143:0x0264, B:148:0x0272, B:150:0x0278, B:153:0x0289, B:155:0x0299, B:159:0x02aa, B:161:0x02b0, B:163:0x02b4, B:166:0x02be, B:167:0x02c1, B:169:0x02c7, B:171:0x02d7, B:173:0x02dc, B:146:0x026b, B:116:0x01f6, B:96:0x01a6, B:175:0x02e1, B:177:0x02e6, B:179:0x02eb, B:181:0x02f0, B:183:0x02f7, B:185:0x02fc, B:187:0x0301, B:189:0x0306, B:191:0x030b, B:193:0x0314, B:195:0x031c, B:197:0x0327, B:200:0x0332, B:201:0x033b, B:203:0x033f, B:206:0x0349, B:61:0x0118, B:28:0x00a1, B:31:0x00a9, B:35:0x00b2, B:38:0x00ba, B:40:0x00c0, B:41:0x00cb, B:19:0x0077, B:211:0x0359), top: B:216:0x001a }, TRY_LEAVE] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014e A[Catch: all -> 0x0356, Exception -> 0x0358, Merged into TryCatch #0 {all -> 0x0356, Exception -> 0x0358, blocks: (B:3:0x001a, B:5:0x0027, B:6:0x0046, B:8:0x004c, B:11:0x005a, B:14:0x0066, B:16:0x006e, B:21:0x007b, B:23:0x0081, B:25:0x0087, B:44:0x00d9, B:46:0x00e0, B:48:0x00e8, B:50:0x00f7, B:52:0x00fc, B:54:0x0101, B:56:0x0107, B:58:0x010f, B:63:0x011c, B:65:0x0122, B:66:0x012c, B:68:0x0133, B:70:0x0142, B:73:0x0148, B:75:0x014e, B:78:0x015e, B:80:0x0164, B:82:0x0174, B:84:0x0183, B:87:0x018b, B:89:0x0191, B:91:0x0195, B:93:0x019f, B:98:0x01ac, B:100:0x01b2, B:103:0x01c3, B:105:0x01d3, B:109:0x01e1, B:111:0x01e7, B:113:0x01eb, B:118:0x01fd, B:120:0x0203, B:123:0x0214, B:125:0x0219, B:127:0x021f, B:129:0x0225, B:131:0x022b, B:133:0x023b, B:135:0x024a, B:137:0x0250, B:139:0x0256, B:141:0x025a, B:143:0x0264, B:148:0x0272, B:150:0x0278, B:153:0x0289, B:155:0x0299, B:159:0x02aa, B:161:0x02b0, B:163:0x02b4, B:166:0x02be, B:167:0x02c1, B:169:0x02c7, B:171:0x02d7, B:173:0x02dc, B:146:0x026b, B:116:0x01f6, B:96:0x01a6, B:175:0x02e1, B:177:0x02e6, B:179:0x02eb, B:181:0x02f0, B:183:0x02f7, B:185:0x02fc, B:187:0x0301, B:189:0x0306, B:191:0x030b, B:193:0x0314, B:195:0x031c, B:197:0x0327, B:200:0x0332, B:201:0x033b, B:203:0x033f, B:206:0x0349, B:61:0x0118, B:28:0x00a1, B:31:0x00a9, B:35:0x00b2, B:38:0x00ba, B:40:0x00c0, B:41:0x00cb, B:19:0x0077, B:211:0x0359), top: B:216:0x001a }, TRY_LEAVE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        k.a a2 = k.a();
        try {
            a2.a("getConfigDate", p.b());
            if (jSONObject.has("client_valid")) {
                a2.a("client_valid", System.currentTimeMillis() + (Integer.valueOf(jSONObject.getString("client_valid")).intValue() * 60 * 60 * 1000));
            }
            if (jSONObject.has("Configlist")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("Configlist");
                if (jSONObject2.has("CHANGE_HOST")) {
                    String string = jSONObject2.getString("CHANGE_HOST");
                    if (string.contains("M005")) {
                        String[] split = string.split("&");
                        int length = split.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                str6 = null;
                                break;
                            }
                            str6 = split[i];
                            if (str6.contains("M005")) {
                                break;
                            }
                            i++;
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            if (str6.contains(",")) {
                                str7 = str6.substring(str6.indexOf("=") + 1, str6.indexOf(","));
                                str = str6.substring(str6.lastIndexOf("=") + 1);
                            } else if (!str6.contains("https") && !str6.contains("HTTPS")) {
                                if (str6.contains("http") || str6.contains(HttpVersion.HTTP)) {
                                    str7 = str6.substring(str6.lastIndexOf("=") + 1);
                                    str = null;
                                }
                            } else {
                                str = str6.substring(str6.lastIndexOf("=") + 1);
                                str7 = null;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("HTTP:");
                            sb.append(str7);
                            sb.append("||||||||HTTPS:");
                            sb.append(str);
                            c.a("UmcConfigUtil", sb.toString());
                            a2.a("httpHost", str7);
                            a2.a("httpsHost", str);
                        }
                        str7 = null;
                        str = null;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("HTTP:");
                        sb2.append(str7);
                        sb2.append("||||||||HTTPS:");
                        sb2.append(str);
                        c.a("UmcConfigUtil", sb2.toString());
                        a2.a("httpHost", str7);
                        a2.a("httpsHost", str);
                    } else {
                        str = null;
                    }
                    if (string.contains("M007")) {
                        String[] split2 = string.split("&");
                        int length2 = split2.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length2) {
                                str2 = null;
                                break;
                            }
                            str2 = split2[i2];
                            if (str2.contains("M007")) {
                                break;
                            }
                            i2++;
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            str2 = str2.substring(str2.lastIndexOf("=") + 1);
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("HTTPS:");
                        sb3.append(str2);
                        c.a("UmcConfigUtil", sb3.toString());
                        a2.a("logHost", str2);
                        if (jSONObject2.has("HOST_CERT_INFO")) {
                            String string2 = jSONObject2.getString("HOST_CERT_INFO");
                            String[] split3 = string2.split("&");
                            if (TextUtils.isEmpty(str2) || !str2.contains(":")) {
                                str3 = str2;
                            } else {
                                str3 = str2.substring(0, str2.indexOf(":"));
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("logHostWithoutHost:");
                                sb4.append(str3);
                                c.a("UmcConfigUtil", sb4.toString());
                            }
                            if (TextUtils.isEmpty(str2) || !string2.contains(str3)) {
                                str4 = null;
                            } else {
                                int length3 = split3.length;
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= length3) {
                                        str4 = null;
                                        break;
                                    }
                                    int i4 = length3;
                                    str4 = split3[i3];
                                    if (!TextUtils.isEmpty(str2) && str4.contains(str3)) {
                                        break;
                                    }
                                    i3++;
                                    length3 = i4;
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    str4 = str4.substring(str4.indexOf(":") + 1, str4.indexOf(","));
                                }
                                c.a("UmcConfigUtil", "log CERT:");
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("https://");
                                sb5.append(str2);
                                sb5.append("/log/logReport");
                                a2.a(sb5.toString(), str4);
                            }
                            if (string2.contains("log1.cmpassport.com")) {
                                int length4 = split3.length;
                                int i5 = 0;
                                while (i5 < length4) {
                                    String str8 = str4;
                                    str4 = split3[i5];
                                    if (str4.contains("log1.cmpassport.com")) {
                                        break;
                                    }
                                    i5++;
                                    str4 = str8;
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    str4 = str4.substring(str4.indexOf(":") + 1, str4.indexOf(","));
                                }
                                c.a("UmcConfigUtil", "log1 CERT:");
                                a2.a("https://log1.cmpassport.com:9443/log/logReport", str4);
                            }
                            if (TextUtils.isEmpty(str) || !str.contains(":")) {
                                str5 = str;
                            } else {
                                str5 = str.substring(0, str.indexOf(":"));
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("httpsHostWithoutPort:");
                                sb6.append(str5);
                                c.a("UmcConfigUtil", sb6.toString());
                            }
                            if (TextUtils.isEmpty(str) || !string2.contains(str5)) {
                                str4 = str4;
                            } else {
                                int length5 = split3.length;
                                int i6 = 0;
                                while (i6 < length5) {
                                    String str9 = str4;
                                    str4 = split3[i6];
                                    if (!TextUtils.isEmpty(str) && str4.contains(str5)) {
                                        break;
                                    }
                                    i6++;
                                    str4 = str9;
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    str4 = str4.substring(str4.indexOf(":") + 1, str4.indexOf(","));
                                }
                                c.a("UmcConfigUtil", "httpsHost CERT:");
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("https://");
                                sb7.append(str);
                                sb7.append("/unisdk");
                                a2.a(sb7.toString(), str4);
                            }
                            if (string2.contains("onekey1.cmpassport.com")) {
                                int length6 = split3.length;
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= length6) {
                                        break;
                                    }
                                    String str10 = split3[i7];
                                    if (str10.contains("onekey1.cmpassport.com")) {
                                        str4 = str10;
                                        break;
                                    }
                                    i7++;
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    str4 = str4.substring(str4.indexOf(":") + 1, str4.indexOf(","));
                                }
                                c.a("UmcConfigUtil", "omekey1 CERT:");
                                a2.a("https://onekey1.cmpassport.com/unisdk", str4);
                            }
                        }
                        a(jSONObject2, "CLOSE_CERT_VERIFY", "0", a2);
                        a(jSONObject2, "CLOSE_FRIEND_WAPKS", "0", a2);
                        a(jSONObject2, "CLOSE_LOGS_VERSION", "0", a2);
                        a(jSONObject2, "CLOSE_IPV4_LIST", "0", a2);
                        a(jSONObject2, "CLOSE_IPV6_LIST", "1", a2);
                        a(jSONObject2, "CLOSE_M001_SDKVERSION_LIST", "0", a2);
                        a(jSONObject2, "CLOSE_M001_APPID_LIST", "0", a2);
                        a(jSONObject2, "CLOSE_M005_SDKVERSION_LIST", "0", a2);
                        a(jSONObject2, "CLOSE_M005_APPID_LIST", "0", a2);
                        if (jSONObject2.has("LOGS_CONTROL")) {
                            String[] split4 = jSONObject2.getString("LOGS_CONTROL").replace("h", "").split("&");
                            if (split4.length > 0 && !TextUtils.isEmpty(split4[0])) {
                                a2.a("maxFailedLogTimes", Integer.parseInt(split4[0]));
                            }
                            if (1 < split4.length && !TextUtils.isEmpty(split4[1])) {
                                a2.a("pauseTime", Integer.parseInt(split4[1]));
                            }
                        }
                    }
                } else {
                    str = null;
                }
                str2 = null;
                if (jSONObject2.has("HOST_CERT_INFO")) {
                }
                a(jSONObject2, "CLOSE_CERT_VERIFY", "0", a2);
                a(jSONObject2, "CLOSE_FRIEND_WAPKS", "0", a2);
                a(jSONObject2, "CLOSE_LOGS_VERSION", "0", a2);
                a(jSONObject2, "CLOSE_IPV4_LIST", "0", a2);
                a(jSONObject2, "CLOSE_IPV6_LIST", "1", a2);
                a(jSONObject2, "CLOSE_M001_SDKVERSION_LIST", "0", a2);
                a(jSONObject2, "CLOSE_M001_APPID_LIST", "0", a2);
                a(jSONObject2, "CLOSE_M005_SDKVERSION_LIST", "0", a2);
                a(jSONObject2, "CLOSE_M005_APPID_LIST", "0", a2);
                if (jSONObject2.has("LOGS_CONTROL")) {
                }
            }
        } catch (Exception e2) {
            c.a("UmcConfigUtil", e2.getMessage());
        } finally {
            a2.b();
        }
    }

    public static boolean c() {
        return "1".equals(k.b("CLOSE_IPV6_LIST", "0"));
    }

    public static boolean d() {
        return "1".equals(k.b("CLOSE_M001_SDKVERSION_LIST", "0")) || "1".equals(k.b("CLOSE_M001_APPID_LIST", "0")) || "1".equals(k.b("CLOSE_M005_APPID_LIST", "0")) || "1".equals(k.b("CLOSE_M005_SDKVERSION_LIST", "0"));
    }

    public static String e() {
        String b2 = k.b("httpHost", null);
        if (TextUtils.isEmpty(b2)) {
            return "http://www.cmpassport.com/unisdk";
        }
        return "http://" + b2 + "/unisdk";
    }

    public static String f() {
        String b2 = k.b("httpsHost", null);
        if (TextUtils.isEmpty(b2)) {
            return "https://onekey1.cmpassport.com/unisdk";
        }
        return "https://" + b2 + "/unisdk";
    }

    public static String g() {
        String b2 = k.b("logHost", "");
        if (TextUtils.isEmpty(b2)) {
            return "https://log1.cmpassport.com:9443/log/logReport";
        }
        return "https://" + b2 + "/log/logReport";
    }

    public static boolean h() {
        return "1".equals(k.b("CLOSE_CERT_VERIFY", "1"));
    }

    public static boolean i() {
        return k.b("CLOSE_FRIEND_WAPKS", "").contains(OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC);
    }

    public static boolean j() {
        return k.b("CLOSE_FRIEND_WAPKS", "").contains(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC);
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

    public static void a(com.cmic.sso.sdk.a aVar) {
        if (f30707a) {
            c.a("UmcConfigUtil", "正在获取配置中...");
            return;
        }
        f30707a = true;
        com.cmic.sso.sdk.b.c.a.a().a(aVar.b("isNeedToGetCert", true), aVar, new com.cmic.sso.sdk.b.c.d() { // from class: com.cmic.sso.sdk.d.q.1
            @Override // com.cmic.sso.sdk.b.c.d
            public void a(String str, String str2, JSONObject jSONObject) {
                try {
                    if ("103000".equals(str)) {
                        q.b(jSONObject);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                boolean unused = q.f30707a = false;
            }
        });
    }

    public static void a(JSONObject jSONObject, String str, String str2, k.a aVar) {
        if (jSONObject.has(str)) {
            aVar.a(str, jSONObject.optString(str, str2));
        }
    }

    public static boolean a() {
        return System.currentTimeMillis() >= k.a("client_valid", 0L);
    }

    public static String a(String str) {
        return k.b(str, "");
    }

    public static boolean b() {
        return "1".equals(k.b("CLOSE_IPV4_LIST", "0"));
    }
}
