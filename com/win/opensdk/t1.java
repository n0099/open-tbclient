package com.win.opensdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.report.sdk.FunReportSdk;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes10.dex */
public class t1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1639696718, "Lcom/win/opensdk/t1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1639696718, "Lcom/win/opensdk/t1;");
                return;
            }
        }
        a = new HashMap();
        b = false;
    }

    public static String a(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, map)) == null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : map.entrySet()) {
                String encode = URLEncoder.encode((String) entry.getValue(), "UTF-8");
                sb.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
                sb.append("=");
                sb.append(encode);
                sb.append("&");
            }
            return sb.substring(0, sb.length() - 1);
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v23, resolved type: boolean */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't wrap try/catch for region: R(41:3|(1:5)(20:161|162|163|164|165|166|(2:212|213)|168|169|(1:171)(1:211)|172|173|174|175|176|(1:180)|182|(4:184|185|186|187)|190|191)|6|(1:8)|9|(3:10|11|(1:13)(4:144|(2:146|(1:148)(1:158))(1:159)|149|(3:153|154|155)(1:151)))|14|(3:139|140|141)|16|17|18|(1:20)|(2:21|22)|23|(1:25)|26|(3:130|131|132)|28|(2:29|30)|(22:34|(1:36)(2:113|(2:115|116))|37|(1:39)|40|(3:108|109|110)|42|(7:44|45|46|47|48|49|50)|55|56|(4:58|59|60|61)|64|(4:66|67|68|69)|72|(4:74|75|76|77)|81|82|83|84|85|86|87)|128|37|(0)|40|(0)|42|(0)|55|56|(0)|64|(0)|72|(0)|81|82|83|84|85|86|87) */
    /* JADX WARN: Can't wrap try/catch for region: R(45:3|(1:5)(20:161|162|163|164|165|166|(2:212|213)|168|169|(1:171)(1:211)|172|173|174|175|176|(1:180)|182|(4:184|185|186|187)|190|191)|6|(1:8)|9|10|11|(1:13)(4:144|(2:146|(1:148)(1:158))(1:159)|149|(3:153|154|155)(1:151))|14|(3:139|140|141)|16|17|18|(1:20)|21|22|23|(1:25)|26|(3:130|131|132)|28|29|30|(22:34|(1:36)(2:113|(2:115|116))|37|(1:39)|40|(3:108|109|110)|42|(7:44|45|46|47|48|49|50)|55|56|(4:58|59|60|61)|64|(4:66|67|68|69)|72|(4:74|75|76|77)|81|82|83|84|85|86|87)|128|37|(0)|40|(0)|42|(0)|55|56|(0)|64|(0)|72|(0)|81|82|83|84|85|86|87) */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0248, code lost:
        if (r1.equalsIgnoreCase("CDMA2000") != false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02e6, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02e7, code lost:
        r10.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02f3, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x02f4, code lost:
        r10.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02f9, code lost:
        if ((r10 instanceof java.lang.ClassNotFoundException) == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0300, code lost:
        r6 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0302, code lost:
        r6 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00a9, code lost:
        if (r5.length() <= 0) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0313, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0314, code lost:
        r10.printStackTrace();
        r10.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x031c, code lost:
        if ((r10 instanceof java.lang.ClassNotFoundException) != false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0323, code lost:
        r10 = "4";
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0326, code lost:
        r10 = "2";
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0329, code lost:
        r10 = "3";
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0112, code lost:
        if (r0 == null) goto L202;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x021a A[Catch: Exception -> 0x024d, TRY_ENTER, TryCatch #15 {Exception -> 0x024d, blocks: (B:95:0x01fd, B:97:0x020b, B:99:0x0211, B:102:0x021a, B:104:0x0220, B:105:0x0228, B:110:0x0234, B:112:0x023a, B:114:0x0242), top: B:217:0x01fd }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x026f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0194 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0145 A[Catch: Exception -> 0x018d, TryCatch #16 {Exception -> 0x018d, blocks: (B:57:0x013e, B:60:0x0145, B:62:0x0151, B:64:0x0159, B:67:0x016a, B:71:0x0175, B:66:0x0165), top: B:219:0x013e }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x020b A[Catch: Exception -> 0x024d, TryCatch #15 {Exception -> 0x024d, blocks: (B:95:0x01fd, B:97:0x020b, B:99:0x0211, B:102:0x021a, B:104:0x0220, B:105:0x0228, B:110:0x0234, B:112:0x023a, B:114:0x0242), top: B:217:0x01fd }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap a(Context context) {
        InterceptResult invokeL;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        HashMap hashMap;
        String f;
        String str5;
        String str6;
        String a2;
        String str7;
        double d;
        String b2;
        String c;
        String a3;
        NetworkInfo activeNetworkInfo;
        String deviceId;
        String str8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b) {
                hashMap = a;
            } else {
                a.put("app", M.b(context));
                a.put("sdkna", "norm-2.4.3");
                a.put("plat", "a");
                a.put("model", Build.MODEL);
                a.put("manu", Build.MANUFACTURER);
                a.put("sysv", String.valueOf(Build.VERSION.SDK_INT));
                a.put("h", String.valueOf(context.getResources().getDisplayMetrics().heightPixels));
                a.put("w", String.valueOf(context.getResources().getDisplayMetrics().widthPixels));
                HashMap hashMap2 = a;
                try {
                    i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (Exception unused) {
                    i = -1;
                }
                hashMap2.put("appv", String.valueOf(i));
                HashMap hashMap3 = a;
                try {
                    str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                    if (str != null) {
                    }
                } catch (Exception unused2) {
                }
                str = "";
                hashMap3.put("appvn", str);
                HashMap hashMap4 = a;
                if (Y1.a()) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                hashMap4.put("rt", str2);
                a.put("dpi", String.valueOf(context.getResources().getDisplayMetrics().densityDpi));
                try {
                    str3 = Build.SERIAL;
                    try {
                        if (TextUtils.equals(str3, "unknown") && Build.VERSION.SDK_INT >= 26) {
                            str3 = Build.getSerial();
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (!TextUtils.isEmpty(str3)) {
                        }
                        str4 = ApiReplaceUtil.getSubscriberId((TelephonyManager) context.getSystemService("phone"));
                    }
                } catch (Exception e2) {
                    e = e2;
                    str3 = "";
                }
                if (!TextUtils.isEmpty(str3)) {
                    HashMap hashMap5 = a;
                    try {
                        str3 = M.a(str3);
                    } catch (Exception unused3) {
                    }
                    hashMap5.put("serial", str3);
                }
                try {
                    str4 = ApiReplaceUtil.getSubscriberId((TelephonyManager) context.getSystemService("phone"));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            HashMap hashMap6 = new HashMap();
            if (hashMap != null) {
                hashMap6.putAll(hashMap);
            }
            f = Z1.f(context);
            int i2 = 2;
            i2 = 2;
            try {
                if (TextUtils.isEmpty(f)) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (Build.VERSION.SDK_INT >= 23) {
                        if (context.checkSelfPermission(com.kuaishou.weapon.p0.h.c) != 0) {
                            str8 = "";
                            deviceId = str8;
                        } else {
                            deviceId = telephonyManager.getDeviceId(1);
                            str8 = telephonyManager.getDeviceId(2);
                        }
                    } else {
                        deviceId = ApiReplaceUtil.getDeviceId(telephonyManager);
                        str8 = "";
                    }
                    if (TextUtils.isEmpty(str8)) {
                        try {
                            Z1.d(context, deviceId);
                        } catch (Exception unused4) {
                        }
                        f = deviceId;
                    } else {
                        f = deviceId + "_" + str8;
                        Z1.d(context, f);
                    }
                }
            } catch (Exception unused5) {
            }
            if (!TextUtils.isEmpty(f)) {
                try {
                    f = M.a(f);
                } catch (Exception unused6) {
                }
                hashMap6.put("imei", f);
            }
            try {
                str5 = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            } catch (Exception unused7) {
                str5 = "";
            }
            if (!TextUtils.isEmpty(str5)) {
                hashMap6.put("opcode", str5);
            }
            try {
                str6 = ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
            } catch (Exception unused8) {
                str6 = HlsPlaylistParser.BOOLEAN_FALSE;
            }
            if (!TextUtils.isEmpty(str6)) {
                hashMap6.put("anid", str6);
            }
            a2 = Q1.a(context);
            if (!TextUtils.isEmpty(a2)) {
                try {
                    a2 = M.a(a2);
                } catch (Exception unused9) {
                }
                hashMap6.put("oaid", a2);
            }
            hashMap6.put("lic", context.getSharedPreferences("_prefs", 0).getString("lcss", ""));
            hashMap6.put("locale", Locale.getDefault().getLanguage());
            try {
                activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception unused10) {
            }
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() != 1) {
                    str7 = "WIFI";
                } else if (activeNetworkInfo.getType() == 0) {
                    str7 = activeNetworkInfo.getSubtypeName();
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            str7 = "2G";
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            str7 = "3G";
                            break;
                        case 13:
                            str7 = "4G";
                            break;
                        default:
                            if (!str7.equalsIgnoreCase("TD-SCDMA") && !str7.equalsIgnoreCase("WCDMA")) {
                                break;
                            }
                            str7 = "3G";
                            break;
                    }
                }
                if (!TextUtils.isEmpty(str7)) {
                    hashMap6.put("net", str7);
                }
                hashMap6.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
                String str9 = null;
                if (!TextUtils.isEmpty(null)) {
                    try {
                        str9 = M.a((String) null);
                    } catch (Exception unused11) {
                    }
                    hashMap6.put("wm", str9);
                }
                d = T1.c.a;
                if (d > 0.0d) {
                    String valueOf = String.valueOf(d);
                    try {
                        valueOf = M.a(valueOf);
                    } catch (Exception unused12) {
                    }
                    hashMap6.put("lau", valueOf);
                    String valueOf2 = String.valueOf(T1.c.b);
                    try {
                        valueOf2 = M.a(valueOf2);
                    } catch (Exception unused13) {
                    }
                    hashMap6.put("lon", valueOf2);
                }
                b2 = X1.a(context).b();
                if (!TextUtils.isEmpty(b2)) {
                    try {
                        b2 = M.a(b2);
                    } catch (Exception unused14) {
                    }
                    hashMap6.put("oid", b2);
                }
                c = X1.a(context).c();
                if (!TextUtils.isEmpty(c)) {
                    try {
                        c = M.a(c);
                    } catch (Exception unused15) {
                    }
                    hashMap6.put(TiebaStatic.Params.VID, c);
                }
                a3 = X1.a(context).a();
                if (!TextUtils.isEmpty(a3)) {
                    try {
                        a3 = M.a(a3);
                    } catch (Exception unused16) {
                    }
                    hashMap6.put("aid", a3);
                }
                i2 = FunReportSdk.getInstance().isPaidUser();
                hashMap6.put("ibu", String.valueOf(i2));
                String str10 = FunAdSdk.getFunAdConfig().userId;
                hashMap6.put("tk", str10);
                return hashMap6;
            }
            str7 = "";
            if (!TextUtils.isEmpty(str7)) {
            }
            hashMap6.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
            String str92 = null;
            if (!TextUtils.isEmpty(null)) {
            }
            d = T1.c.a;
            if (d > 0.0d) {
            }
            b2 = X1.a(context).b();
            if (!TextUtils.isEmpty(b2)) {
            }
            c = X1.a(context).c();
            if (!TextUtils.isEmpty(c)) {
            }
            a3 = X1.a(context).a();
            if (!TextUtils.isEmpty(a3)) {
            }
            i2 = FunReportSdk.getInstance().isPaidUser();
            hashMap6.put("ibu", String.valueOf(i2));
            String str102 = FunAdSdk.getFunAdConfig().userId;
            hashMap6.put("tk", str102);
            return hashMap6;
        }
        return (HashMap) invokeL.objValue;
        str4 = "";
        if (!TextUtils.isEmpty(str4)) {
            HashMap hashMap7 = a;
            try {
                str4 = M.a(str4);
            } catch (Exception unused17) {
            }
            hashMap7.put(BaseStatisContent.IMSI, str4);
        }
        b = true;
        hashMap = a;
        HashMap hashMap62 = new HashMap();
        if (hashMap != null) {
        }
        f = Z1.f(context);
        int i22 = 2;
        i22 = 2;
        if (TextUtils.isEmpty(f)) {
        }
        if (!TextUtils.isEmpty(f)) {
        }
        str5 = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        if (!TextUtils.isEmpty(str5)) {
        }
        str6 = ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
        if (!TextUtils.isEmpty(str6)) {
        }
        a2 = Q1.a(context);
        if (!TextUtils.isEmpty(a2)) {
        }
        hashMap62.put("lic", context.getSharedPreferences("_prefs", 0).getString("lcss", ""));
        hashMap62.put("locale", Locale.getDefault().getLanguage());
        activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() != 1) {
            }
            if (!TextUtils.isEmpty(str7)) {
            }
            hashMap62.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
            String str922 = null;
            if (!TextUtils.isEmpty(null)) {
            }
            d = T1.c.a;
            if (d > 0.0d) {
            }
            b2 = X1.a(context).b();
            if (!TextUtils.isEmpty(b2)) {
            }
            c = X1.a(context).c();
            if (!TextUtils.isEmpty(c)) {
            }
            a3 = X1.a(context).a();
            if (!TextUtils.isEmpty(a3)) {
            }
            i22 = FunReportSdk.getInstance().isPaidUser();
            hashMap62.put("ibu", String.valueOf(i22));
            String str1022 = FunAdSdk.getFunAdConfig().userId;
            hashMap62.put("tk", str1022);
            return hashMap62;
        }
        str7 = "";
        if (!TextUtils.isEmpty(str7)) {
        }
        hashMap62.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
        String str9222 = null;
        if (!TextUtils.isEmpty(null)) {
        }
        d = T1.c.a;
        if (d > 0.0d) {
        }
        b2 = X1.a(context).b();
        if (!TextUtils.isEmpty(b2)) {
        }
        c = X1.a(context).c();
        if (!TextUtils.isEmpty(c)) {
        }
        a3 = X1.a(context).a();
        if (!TextUtils.isEmpty(a3)) {
        }
        i22 = FunReportSdk.getInstance().isPaidUser();
        hashMap62.put("ibu", String.valueOf(i22));
        String str10222 = FunAdSdk.getFunAdConfig().userId;
        hashMap62.put("tk", str10222);
        return hashMap62;
        hashMap7.put(BaseStatisContent.IMSI, str4);
        b = true;
        hashMap = a;
        HashMap hashMap622 = new HashMap();
        if (hashMap != null) {
        }
        f = Z1.f(context);
        int i222 = 2;
        i222 = 2;
        if (TextUtils.isEmpty(f)) {
        }
        if (!TextUtils.isEmpty(f)) {
        }
        str5 = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        if (!TextUtils.isEmpty(str5)) {
        }
        str6 = ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
        if (!TextUtils.isEmpty(str6)) {
        }
        a2 = Q1.a(context);
        if (!TextUtils.isEmpty(a2)) {
        }
        hashMap622.put("lic", context.getSharedPreferences("_prefs", 0).getString("lcss", ""));
        hashMap622.put("locale", Locale.getDefault().getLanguage());
        activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
        }
        str7 = "";
        if (!TextUtils.isEmpty(str7)) {
        }
        hashMap622.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
        String str92222 = null;
        if (!TextUtils.isEmpty(null)) {
        }
        d = T1.c.a;
        if (d > 0.0d) {
        }
        b2 = X1.a(context).b();
        if (!TextUtils.isEmpty(b2)) {
        }
        c = X1.a(context).c();
        if (!TextUtils.isEmpty(c)) {
        }
        a3 = X1.a(context).a();
        if (!TextUtils.isEmpty(a3)) {
        }
        i222 = FunReportSdk.getInstance().isPaidUser();
        hashMap622.put("ibu", String.valueOf(i222));
        String str102222 = FunAdSdk.getFunAdConfig().userId;
        hashMap622.put("tk", str102222);
        return hashMap622;
    }
}
