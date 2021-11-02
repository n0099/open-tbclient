package com.cmic.sso.sdk.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.d.k;
import java.net.URL;
import org.apache.http.HttpVersion;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f61994a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1436819589, "Lcom/cmic/sso/sdk/d/q;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1436819589, "Lcom/cmic/sso/sdk/d/q;");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:199:0x0373 A[Catch: all -> 0x03b5, Exception -> 0x03b7, Merged into TryCatch #2 {all -> 0x03b5, Exception -> 0x03b7, blocks: (B:5:0x001e, B:7:0x002b, B:8:0x004a, B:10:0x0050, B:13:0x005e, B:16:0x006a, B:18:0x0072, B:23:0x007f, B:25:0x0085, B:27:0x008b, B:46:0x00dd, B:48:0x00e4, B:50:0x00ed, B:52:0x00fc, B:54:0x0101, B:56:0x0106, B:58:0x010c, B:60:0x0114, B:65:0x0121, B:67:0x0127, B:68:0x0131, B:70:0x0138, B:72:0x0147, B:75:0x014d, B:77:0x0153, B:80:0x0163, B:82:0x0169, B:84:0x0179, B:86:0x0188, B:89:0x0190, B:91:0x0196, B:93:0x019a, B:95:0x01a4, B:100:0x01b1, B:102:0x01b7, B:103:0x01c5, B:106:0x01df, B:108:0x01e3, B:112:0x01f0, B:114:0x01f7, B:116:0x020a, B:118:0x0210, B:120:0x0214, B:125:0x0226, B:127:0x022c, B:128:0x023a, B:130:0x0257, B:132:0x025d, B:134:0x0263, B:136:0x0273, B:138:0x0282, B:140:0x0288, B:142:0x028e, B:144:0x0292, B:146:0x029a, B:149:0x02a2, B:150:0x02a5, B:152:0x02ab, B:153:0x02ba, B:155:0x02c1, B:156:0x02d1, B:158:0x02d5, B:162:0x02e2, B:164:0x02e9, B:166:0x02fc, B:168:0x0302, B:170:0x0306, B:173:0x0310, B:174:0x0313, B:176:0x0319, B:177:0x0327, B:179:0x032e, B:161:0x02de, B:123:0x021f, B:111:0x01ec, B:98:0x01ab, B:181:0x0340, B:183:0x0345, B:185:0x034a, B:187:0x034f, B:189:0x0356, B:191:0x035b, B:193:0x0360, B:195:0x0365, B:197:0x036a, B:199:0x0373, B:201:0x037b, B:203:0x0386, B:206:0x0391, B:207:0x039a, B:209:0x039e, B:212:0x03a8, B:63:0x011d, B:30:0x00a5, B:33:0x00ad, B:37:0x00b6, B:40:0x00be, B:42:0x00c4, B:43:0x00cf, B:21:0x007b, B:218:0x03bb), top: B:230:0x001e }, TRY_LEAVE] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0153 A[Catch: all -> 0x03b5, Exception -> 0x03b7, Merged into TryCatch #2 {all -> 0x03b5, Exception -> 0x03b7, blocks: (B:5:0x001e, B:7:0x002b, B:8:0x004a, B:10:0x0050, B:13:0x005e, B:16:0x006a, B:18:0x0072, B:23:0x007f, B:25:0x0085, B:27:0x008b, B:46:0x00dd, B:48:0x00e4, B:50:0x00ed, B:52:0x00fc, B:54:0x0101, B:56:0x0106, B:58:0x010c, B:60:0x0114, B:65:0x0121, B:67:0x0127, B:68:0x0131, B:70:0x0138, B:72:0x0147, B:75:0x014d, B:77:0x0153, B:80:0x0163, B:82:0x0169, B:84:0x0179, B:86:0x0188, B:89:0x0190, B:91:0x0196, B:93:0x019a, B:95:0x01a4, B:100:0x01b1, B:102:0x01b7, B:103:0x01c5, B:106:0x01df, B:108:0x01e3, B:112:0x01f0, B:114:0x01f7, B:116:0x020a, B:118:0x0210, B:120:0x0214, B:125:0x0226, B:127:0x022c, B:128:0x023a, B:130:0x0257, B:132:0x025d, B:134:0x0263, B:136:0x0273, B:138:0x0282, B:140:0x0288, B:142:0x028e, B:144:0x0292, B:146:0x029a, B:149:0x02a2, B:150:0x02a5, B:152:0x02ab, B:153:0x02ba, B:155:0x02c1, B:156:0x02d1, B:158:0x02d5, B:162:0x02e2, B:164:0x02e9, B:166:0x02fc, B:168:0x0302, B:170:0x0306, B:173:0x0310, B:174:0x0313, B:176:0x0319, B:177:0x0327, B:179:0x032e, B:161:0x02de, B:123:0x021f, B:111:0x01ec, B:98:0x01ab, B:181:0x0340, B:183:0x0345, B:185:0x034a, B:187:0x034f, B:189:0x0356, B:191:0x035b, B:193:0x0360, B:195:0x0365, B:197:0x036a, B:199:0x0373, B:201:0x037b, B:203:0x0386, B:206:0x0391, B:207:0x039a, B:209:0x039e, B:212:0x03a8, B:63:0x011d, B:30:0x00a5, B:33:0x00ad, B:37:0x00b6, B:40:0x00be, B:42:0x00c4, B:43:0x00cf, B:21:0x007b, B:218:0x03bb), top: B:230:0x001e }, TRY_LEAVE] */
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, jSONObject) == null) {
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
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? "1".equals(k.b("CLOSE_IPV6_LIST", "0")) : invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? "1".equals(k.b("CLOSE_M001_SDKVERSION_LIST", "0")) || "1".equals(k.b("CLOSE_M001_APPID_LIST", "0")) || "1".equals(k.b("CLOSE_M005_APPID_LIST", "0")) || "1".equals(k.b("CLOSE_M005_SDKVERSION_LIST", "0")) : invokeV.booleanValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String b2 = k.b("httpHost", null);
            if (TextUtils.isEmpty(b2)) {
                return "http://onekey.cmpassport.com/unisdk";
            }
            return "http://" + b2 + "/unisdk";
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            try {
                return new URL(g()).getHost();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            String b2 = k.b("httpsHost", null);
            if (TextUtils.isEmpty(b2)) {
                return "https://onekey2.cmpassport.com/unisdk";
            }
            return "https://" + b2 + "/unisdk";
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            try {
                return new URL(i()).getHost();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            String b2 = k.b("logHost", "");
            if (TextUtils.isEmpty(b2)) {
                return "https://log2.cmpassport.com:9443/log/logReport";
            }
            return "https://" + b2 + "/log/logReport";
        }
        return (String) invokeV.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? "1".equals(k.b("CLOSE_CERT_VERIFY", "1")) : invokeV.booleanValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? k.b("CLOSE_FRIEND_WAPKS", "").contains(OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC) : invokeV.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? k.b("CLOSE_FRIEND_WAPKS", "").contains(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC) : invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? "1".equals(k.b("CLOSE_LOGS_VERSION", "0")) : invokeV.booleanValue;
    }

    public static int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? k.a("maxFailedLogTimes", 3) : invokeV.intValue;
    }

    public static int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? k.a("pauseTime", 1) * 60 * 60 * 1000 : invokeV.intValue;
    }

    public static void a(com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            if (f61994a) {
                c.a("UmcConfigUtil", "正在获取配置中...");
                return;
            }
            f61994a = true;
            com.cmic.sso.sdk.b.c.a.a().a(aVar.b("isNeedToGetCert", true), aVar, new com.cmic.sso.sdk.b.c.d() { // from class: com.cmic.sso.sdk.d.q.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.cmic.sso.sdk.b.c.d
                public void a(String str, String str2, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
                        try {
                            if ("103000".equals(str)) {
                                q.b(jSONObject);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        boolean unused = q.f61994a = false;
                    }
                }
            });
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2, k.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, str, str2, aVar) == null) && jSONObject.has(str)) {
            aVar.a(str, jSONObject.optString(str, str2));
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? System.currentTimeMillis() >= k.a("client_valid", 0L) : invokeV.booleanValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            c.b("UmcConfigUtil", "getCertByHost host = " + str);
            return k.b(str, "");
        }
        return (String) invokeL.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? "1".equals(k.b("CLOSE_IPV4_LIST", "0")) : invokeV.booleanValue;
    }
}
