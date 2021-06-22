package com.cmic.sso.sdk.d;

import android.text.TextUtils;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.cmic.sso.sdk.d.k;
import java.net.URL;
import org.apache.http.HttpVersion;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f30764a = false;

    /* JADX WARN: Removed duplicated region for block: B:197:0x036e A[Catch: all -> 0x03b0, Exception -> 0x03b2, Merged into TryCatch #0 {all -> 0x03b0, Exception -> 0x03b2, blocks: (B:3:0x001a, B:5:0x0027, B:6:0x0046, B:8:0x004c, B:11:0x005a, B:14:0x0066, B:16:0x006e, B:21:0x007b, B:23:0x0081, B:25:0x0087, B:44:0x00d9, B:46:0x00e0, B:48:0x00e8, B:50:0x00f7, B:52:0x00fc, B:54:0x0101, B:56:0x0107, B:58:0x010f, B:63:0x011c, B:65:0x0122, B:66:0x012c, B:68:0x0133, B:70:0x0142, B:73:0x0148, B:75:0x014e, B:78:0x015e, B:80:0x0164, B:82:0x0174, B:84:0x0183, B:87:0x018b, B:89:0x0191, B:91:0x0195, B:93:0x019f, B:98:0x01ac, B:100:0x01b2, B:101:0x01c0, B:104:0x01da, B:106:0x01de, B:110:0x01eb, B:112:0x01f2, B:114:0x0205, B:116:0x020b, B:118:0x020f, B:123:0x0221, B:125:0x0227, B:126:0x0235, B:128:0x0252, B:130:0x0258, B:132:0x025e, B:134:0x026e, B:136:0x027d, B:138:0x0283, B:140:0x0289, B:142:0x028d, B:144:0x0295, B:147:0x029d, B:148:0x02a0, B:150:0x02a6, B:151:0x02b5, B:153:0x02bc, B:154:0x02cc, B:156:0x02d0, B:160:0x02dd, B:162:0x02e4, B:164:0x02f7, B:166:0x02fd, B:168:0x0301, B:171:0x030b, B:172:0x030e, B:174:0x0314, B:175:0x0322, B:177:0x0329, B:159:0x02d9, B:121:0x021a, B:109:0x01e7, B:96:0x01a6, B:179:0x033b, B:181:0x0340, B:183:0x0345, B:185:0x034a, B:187:0x0351, B:189:0x0356, B:191:0x035b, B:193:0x0360, B:195:0x0365, B:197:0x036e, B:199:0x0376, B:201:0x0381, B:204:0x038c, B:205:0x0395, B:207:0x0399, B:210:0x03a3, B:61:0x0118, B:28:0x00a1, B:31:0x00a9, B:35:0x00b2, B:38:0x00ba, B:40:0x00c0, B:41:0x00cb, B:19:0x0077, B:216:0x03b5), top: B:221:0x001a }, TRY_LEAVE] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014e A[Catch: all -> 0x03b0, Exception -> 0x03b2, Merged into TryCatch #0 {all -> 0x03b0, Exception -> 0x03b2, blocks: (B:3:0x001a, B:5:0x0027, B:6:0x0046, B:8:0x004c, B:11:0x005a, B:14:0x0066, B:16:0x006e, B:21:0x007b, B:23:0x0081, B:25:0x0087, B:44:0x00d9, B:46:0x00e0, B:48:0x00e8, B:50:0x00f7, B:52:0x00fc, B:54:0x0101, B:56:0x0107, B:58:0x010f, B:63:0x011c, B:65:0x0122, B:66:0x012c, B:68:0x0133, B:70:0x0142, B:73:0x0148, B:75:0x014e, B:78:0x015e, B:80:0x0164, B:82:0x0174, B:84:0x0183, B:87:0x018b, B:89:0x0191, B:91:0x0195, B:93:0x019f, B:98:0x01ac, B:100:0x01b2, B:101:0x01c0, B:104:0x01da, B:106:0x01de, B:110:0x01eb, B:112:0x01f2, B:114:0x0205, B:116:0x020b, B:118:0x020f, B:123:0x0221, B:125:0x0227, B:126:0x0235, B:128:0x0252, B:130:0x0258, B:132:0x025e, B:134:0x026e, B:136:0x027d, B:138:0x0283, B:140:0x0289, B:142:0x028d, B:144:0x0295, B:147:0x029d, B:148:0x02a0, B:150:0x02a6, B:151:0x02b5, B:153:0x02bc, B:154:0x02cc, B:156:0x02d0, B:160:0x02dd, B:162:0x02e4, B:164:0x02f7, B:166:0x02fd, B:168:0x0301, B:171:0x030b, B:172:0x030e, B:174:0x0314, B:175:0x0322, B:177:0x0329, B:159:0x02d9, B:121:0x021a, B:109:0x01e7, B:96:0x01a6, B:179:0x033b, B:181:0x0340, B:183:0x0345, B:185:0x034a, B:187:0x0351, B:189:0x0356, B:191:0x035b, B:193:0x0360, B:195:0x0365, B:197:0x036e, B:199:0x0376, B:201:0x0381, B:204:0x038c, B:205:0x0395, B:207:0x0399, B:210:0x03a3, B:61:0x0118, B:28:0x00a1, B:31:0x00a9, B:35:0x00b2, B:38:0x00ba, B:40:0x00c0, B:41:0x00cb, B:19:0x0077, B:216:0x03b5), top: B:221:0x001a }, TRY_LEAVE] */
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
        String str8;
        String str9;
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
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                str8 = null;
                                break;
                            }
                            str8 = split[i2];
                            if (str8.contains("M005")) {
                                break;
                            }
                            i2++;
                        }
                        if (!TextUtils.isEmpty(str8)) {
                            if (str8.contains(",")) {
                                str9 = str8.substring(str8.indexOf("=") + 1, str8.indexOf(","));
                                str = str8.substring(str8.lastIndexOf("=") + 1);
                            } else if (!str8.contains("https") && !str8.contains("HTTPS")) {
                                if (str8.contains("http") || str8.contains(HttpVersion.HTTP)) {
                                    str9 = str8.substring(str8.lastIndexOf("=") + 1);
                                    str = null;
                                }
                            } else {
                                str = str8.substring(str8.lastIndexOf("=") + 1);
                                str9 = null;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("HTTP:");
                            sb.append(str9);
                            sb.append("||||||||HTTPS:");
                            sb.append(str);
                            c.a("UmcConfigUtil", sb.toString());
                            a2.a("httpHost", str9);
                            a2.a("httpsHost", str);
                        }
                        str9 = null;
                        str = null;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("HTTP:");
                        sb2.append(str9);
                        sb2.append("||||||||HTTPS:");
                        sb2.append(str);
                        c.a("UmcConfigUtil", sb2.toString());
                        a2.a("httpHost", str9);
                        a2.a("httpsHost", str);
                    } else {
                        str = null;
                    }
                    if (string.contains("M007")) {
                        String[] split2 = string.split("&");
                        int length2 = split2.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length2) {
                                str2 = null;
                                break;
                            }
                            str2 = split2[i3];
                            if (str2.contains("M007")) {
                                break;
                            }
                            i3++;
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
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= length3) {
                                        str4 = null;
                                        break;
                                    }
                                    int i5 = length3;
                                    str4 = split3[i4];
                                    if (!TextUtils.isEmpty(str2) && str4.contains(str3)) {
                                        break;
                                    }
                                    i4++;
                                    length3 = i5;
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    str4 = str4.substring(str4.indexOf(":") + 1, str4.indexOf(","));
                                }
                                c.b("UmcConfigUtil", str2 + " CERT:" + str4);
                                a2.a(str2, str4);
                            }
                            try {
                                str5 = new URL("https://log2.cmpassport.com:9443/log/logReport").getHost();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                str5 = null;
                            }
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("localLogURLHOST = ");
                            sb5.append(str5);
                            c.a("UmcConfigUtil", sb5.toString());
                            if (TextUtils.isEmpty(str5) || !string2.contains(str5)) {
                                str4 = str4;
                            } else {
                                int length4 = split3.length;
                                int i6 = 0;
                                while (i6 < length4) {
                                    String str10 = str4;
                                    str4 = split3[i6];
                                    if (str4.contains(str5)) {
                                        break;
                                    }
                                    i6++;
                                    str4 = str10;
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    str4 = str4.substring(str4.indexOf(":") + 1, str4.indexOf(","));
                                }
                                c.b("UmcConfigUtil", str5 + " CERT:" + str4);
                                a2.a(str5, str4);
                            }
                            if (TextUtils.isEmpty(str) || !str.contains(":")) {
                                str6 = str;
                            } else {
                                str6 = str.substring(0, str.indexOf(":"));
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("httpsHostWithoutPort:");
                                sb6.append(str6);
                                c.a("UmcConfigUtil", sb6.toString());
                            }
                            if (!TextUtils.isEmpty(str) && string2.contains(str6)) {
                                int length5 = split3.length;
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= length5) {
                                        break;
                                    }
                                    String str11 = split3[i7];
                                    if (!TextUtils.isEmpty(str) && str11.contains(str6)) {
                                        str4 = str11;
                                        break;
                                    }
                                    i7++;
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    str4 = str4.substring(str4.indexOf(":") + 1, str4.indexOf(","));
                                }
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("httpsHost CERT: ");
                                sb7.append(str4);
                                c.a("UmcConfigUtil", sb7.toString());
                                a2.a(str, str4);
                            }
                            try {
                                str7 = new URL("https://onekey2.cmpassport.com/unisdk").getHost();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                str7 = null;
                            }
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append("localBaseURLHost = ");
                            sb8.append(str7);
                            c.a("UmcConfigUtil", sb8.toString());
                            if (!TextUtils.isEmpty(str7) && string2.contains(str7)) {
                                int length6 = split3.length;
                                int i8 = 0;
                                while (true) {
                                    if (i8 >= length6) {
                                        break;
                                    }
                                    String str12 = split3[i8];
                                    if (str12.contains(str7)) {
                                        str4 = str12;
                                        break;
                                    }
                                    i8++;
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    str4 = str4.substring(str4.indexOf(":") + 1, str4.indexOf(","));
                                }
                                StringBuilder sb9 = new StringBuilder();
                                sb9.append("localBaseURLHost CERT:");
                                sb9.append(str4);
                                c.a("UmcConfigUtil", sb9.toString());
                                a2.a(str7, str4);
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
        } catch (Exception e4) {
            c.a("UmcConfigUtil", "配置下发存在异常数据");
            c.a("UmcConfigUtil", e4.getMessage());
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
            return "http://onekey.cmpassport.com/unisdk";
        }
        return "http://" + b2 + "/unisdk";
    }

    public static String f() {
        try {
            return new URL(g()).getHost();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String g() {
        String b2 = k.b("httpsHost", null);
        if (TextUtils.isEmpty(b2)) {
            return "https://onekey2.cmpassport.com/unisdk";
        }
        return "https://" + b2 + "/unisdk";
    }

    public static String h() {
        try {
            return new URL(i()).getHost();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String i() {
        String b2 = k.b("logHost", "");
        if (TextUtils.isEmpty(b2)) {
            return "https://log2.cmpassport.com:9443/log/logReport";
        }
        return "https://" + b2 + "/log/logReport";
    }

    public static boolean j() {
        return "1".equals(k.b("CLOSE_CERT_VERIFY", "1"));
    }

    public static boolean k() {
        return k.b("CLOSE_FRIEND_WAPKS", "").contains(OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC);
    }

    public static boolean l() {
        return k.b("CLOSE_FRIEND_WAPKS", "").contains(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC);
    }

    public static boolean m() {
        return "1".equals(k.b("CLOSE_LOGS_VERSION", "0"));
    }

    public static int n() {
        return k.a("maxFailedLogTimes", 3);
    }

    public static int o() {
        return k.a("pauseTime", 1) * 60 * 60 * 1000;
    }

    public static void a(com.cmic.sso.sdk.a aVar) {
        if (f30764a) {
            c.a("UmcConfigUtil", "正在获取配置中...");
            return;
        }
        f30764a = true;
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
                boolean unused = q.f30764a = false;
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
        c.b("UmcConfigUtil", "getCertByHost host = " + str);
        return k.b(str, "");
    }

    public static boolean b() {
        return "1".equals(k.b("CLOSE_IPV4_LIST", "0"));
    }
}
