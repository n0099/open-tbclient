package com.win.opensdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
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
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.Enumeration;
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
    /* JADX WARN: Can't wrap try/catch for region: R(50:3|(1:5)(20:212|213|214|215|216|217|(2:263|264)|219|220|(1:222)(1:262)|223|224|225|226|227|(1:231)|233|(4:235|236|237|238)|241|242)|6|(1:8)|9|(3:10|11|(1:13)(4:195|(2:197|(1:199)(1:209))(1:210)|200|(3:204|205|206)(1:202)))|14|(3:190|191|192)|(2:16|17)|18|(1:20)|(2:21|22)|23|(1:25)|26|(3:181|182|183)|28|(2:29|30)|(32:34|(1:36)(2:163|(2:165|166))|37|(1:39)|40|41|42|43|(25:44|45|(2:47|(2:48|(4:50|51|52|(1:149)(3:56|57|58))))(1:156)|61|(5:(1:65)|66|(2:68|69)(1:71)|70|62)|72|73|74|(3:142|143|144)|76|(7:78|79|80|81|82|83|84)|89|90|(4:92|93|94|95)|98|(4:100|101|102|103)|106|(4:108|109|110|111)|115|116|117|118|119|120|121)|60|61|(1:62)|72|73|74|(0)|76|(0)|89|90|(0)|98|(0)|106|(0)|115|116|117|118|119|120|121)|179|37|(0)|40|41|42|43|(25:44|45|(0)(0)|61|(1:62)|72|73|74|(0)|76|(0)|89|90|(0)|98|(0)|106|(0)|115|116|117|118|119|120|121)|60|61|(1:62)|72|73|74|(0)|76|(0)|89|90|(0)|98|(0)|106|(0)|115|116|117|118|119|120|121) */
    /* JADX WARN: Can't wrap try/catch for region: R(55:3|(1:5)(20:212|213|214|215|216|217|(2:263|264)|219|220|(1:222)(1:262)|223|224|225|226|227|(1:231)|233|(4:235|236|237|238)|241|242)|6|(1:8)|9|10|11|(1:13)(4:195|(2:197|(1:199)(1:209))(1:210)|200|(3:204|205|206)(1:202))|14|(3:190|191|192)|16|17|18|(1:20)|21|22|23|(1:25)|26|(3:181|182|183)|28|29|30|(32:34|(1:36)(2:163|(2:165|166))|37|(1:39)|40|41|42|43|(25:44|45|(2:47|(2:48|(4:50|51|52|(1:149)(3:56|57|58))))(1:156)|61|(5:(1:65)|66|(2:68|69)(1:71)|70|62)|72|73|74|(3:142|143|144)|76|(7:78|79|80|81|82|83|84)|89|90|(4:92|93|94|95)|98|(4:100|101|102|103)|106|(4:108|109|110|111)|115|116|117|118|119|120|121)|60|61|(1:62)|72|73|74|(0)|76|(0)|89|90|(0)|98|(0)|106|(0)|115|116|117|118|119|120|121)|179|37|(0)|40|41|42|43|(25:44|45|(0)(0)|61|(1:62)|72|73|74|(0)|76|(0)|89|90|(0)|98|(0)|106|(0)|115|116|117|118|119|120|121)|60|61|(1:62)|72|73|74|(0)|76|(0)|89|90|(0)|98|(0)|106|(0)|115|116|117|118|119|120|121) */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02ad, code lost:
        r1 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02ae, code lost:
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00a9, code lost:
        if (r5.length() <= 0) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0372, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0373, code lost:
        r10.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x037f, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0380, code lost:
        r10.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0385, code lost:
        if ((r10 instanceof java.lang.ClassNotFoundException) == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x038c, code lost:
        r6 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x038e, code lost:
        r6 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x039f, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x03a0, code lost:
        r10.printStackTrace();
        r10.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x03a8, code lost:
        if ((r10 instanceof java.lang.ClassNotFoundException) != false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x03af, code lost:
        r10 = "4";
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x03b2, code lost:
        r10 = "2";
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x03b5, code lost:
        r10 = "3";
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0112, code lost:
        if (r0 == null) goto L253;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x021a A[Catch: Exception -> 0x0250, TRY_ENTER, TryCatch #17 {Exception -> 0x0250, blocks: (B:95:0x01fd, B:97:0x020b, B:99:0x0211, B:102:0x021a, B:104:0x0220, B:105:0x0228, B:110:0x0234, B:112:0x023a, B:114:0x0242), top: B:257:0x01fd }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0277 A[Catch: SocketException -> 0x02a9, Exception -> 0x02ab, TryCatch #4 {SocketException -> 0x02a9, blocks: (B:126:0x0271, B:128:0x0277, B:129:0x0281, B:131:0x0287), top: B:236:0x0271 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0194 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x02fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x02b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0145 A[Catch: Exception -> 0x018d, TryCatch #18 {Exception -> 0x018d, blocks: (B:57:0x013e, B:60:0x0145, B:62:0x0151, B:64:0x0159, B:67:0x016a, B:71:0x0175, B:66:0x0165), top: B:259:0x013e }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x020b A[Catch: Exception -> 0x0250, TryCatch #17 {Exception -> 0x0250, blocks: (B:95:0x01fd, B:97:0x020b, B:99:0x0211, B:102:0x021a, B:104:0x0220, B:105:0x0228, B:110:0x0234, B:112:0x023a, B:114:0x0242), top: B:257:0x01fd }] */
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
        String str8;
        InetAddress inetAddress;
        double d;
        String b2;
        String c;
        String a3;
        byte[] hardwareAddress;
        int i2;
        Enumeration<NetworkInterface> networkInterfaces;
        NetworkInfo activeNetworkInfo;
        String deviceId;
        String str9;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b) {
                hashMap = a;
            } else {
                a.put("app", M.b(context));
                a.put("sdkna", "norm-2.4.4");
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
            int i3 = 2;
            i3 = 2;
            try {
                if (TextUtils.isEmpty(f)) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (Build.VERSION.SDK_INT >= 23) {
                        if (context.checkSelfPermission(com.kuaishou.weapon.p0.h.c) != 0) {
                            str9 = "";
                            deviceId = str9;
                        } else {
                            deviceId = telephonyManager.getDeviceId(1);
                            str9 = telephonyManager.getDeviceId(2);
                        }
                    } else {
                        deviceId = ApiReplaceUtil.getDeviceId(telephonyManager);
                        str9 = "";
                    }
                    if (TextUtils.isEmpty(str9)) {
                        try {
                            Z1.d(context, deviceId);
                        } catch (Exception unused4) {
                        }
                        f = deviceId;
                    } else {
                        f = deviceId + "_" + str9;
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
                    String subtypeName = activeNetworkInfo.getSubtypeName();
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
                            if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA")) {
                                if (!subtypeName.equalsIgnoreCase("CDMA2000")) {
                                    str7 = subtypeName;
                                    break;
                                }
                            }
                            str7 = "3G";
                            break;
                    }
                }
                if (!TextUtils.isEmpty(str7)) {
                    hashMap6.put("net", str7);
                }
                hashMap6.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
                str8 = null;
                networkInterfaces = NetworkInterface.getNetworkInterfaces();
                inetAddress = null;
                do {
                    try {
                        if (networkInterfaces.hasMoreElements()) {
                            Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                            while (true) {
                                if (inetAddresses.hasMoreElements()) {
                                    InetAddress nextElement = inetAddresses.nextElement();
                                    try {
                                        if (!nextElement.isLoopbackAddress() && !nextElement.getHostAddress().contains(":")) {
                                            inetAddress = nextElement;
                                            continue;
                                        } else {
                                            inetAddress = null;
                                        }
                                    } catch (SocketException e4) {
                                        e = e4;
                                        inetAddress = nextElement;
                                        e.printStackTrace();
                                        hardwareAddress = ApiReplaceUtil.getHardwareAddress(NetworkInterface.getByInetAddress(inetAddress));
                                        StringBuffer stringBuffer = new StringBuffer();
                                        while (i2 < hardwareAddress.length) {
                                        }
                                        str8 = stringBuffer.toString().toUpperCase();
                                        if (!TextUtils.isEmpty(str8)) {
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
                                        i3 = FunReportSdk.getInstance().isPaidUser();
                                        hashMap6.put("ibu", String.valueOf(i3));
                                        String str10 = FunAdSdk.getFunAdConfig().userId;
                                        hashMap6.put("tk", str10);
                                        return hashMap6;
                                    }
                                }
                            }
                        }
                    } catch (SocketException e5) {
                        e = e5;
                    }
                    hardwareAddress = ApiReplaceUtil.getHardwareAddress(NetworkInterface.getByInetAddress(inetAddress));
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (i2 = 0; i2 < hardwareAddress.length; i2++) {
                        if (i2 != 0) {
                            stringBuffer2.append(':');
                        }
                        String hexString = Integer.toHexString(hardwareAddress[i2] & 255);
                        if (hexString.length() == 1) {
                            hexString = 0 + hexString;
                        }
                        stringBuffer2.append(hexString);
                    }
                    str8 = stringBuffer2.toString().toUpperCase();
                    if (!TextUtils.isEmpty(str8)) {
                        try {
                            str8 = M.a(str8);
                        } catch (Exception unused11) {
                        }
                        hashMap6.put("wm", str8);
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
                        hashMap6.put("vid", c);
                    }
                    a3 = X1.a(context).a();
                    if (!TextUtils.isEmpty(a3)) {
                        try {
                            a3 = M.a(a3);
                        } catch (Exception unused16) {
                        }
                        hashMap6.put("aid", a3);
                    }
                    i3 = FunReportSdk.getInstance().isPaidUser();
                    hashMap6.put("ibu", String.valueOf(i3));
                    String str102 = FunAdSdk.getFunAdConfig().userId;
                    hashMap6.put("tk", str102);
                    return hashMap6;
                } while (inetAddress == null);
                hardwareAddress = ApiReplaceUtil.getHardwareAddress(NetworkInterface.getByInetAddress(inetAddress));
                StringBuffer stringBuffer22 = new StringBuffer();
                while (i2 < hardwareAddress.length) {
                }
                str8 = stringBuffer22.toString().toUpperCase();
                if (!TextUtils.isEmpty(str8)) {
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
                i3 = FunReportSdk.getInstance().isPaidUser();
                hashMap6.put("ibu", String.valueOf(i3));
                String str1022 = FunAdSdk.getFunAdConfig().userId;
                hashMap6.put("tk", str1022);
                return hashMap6;
            }
            str7 = "";
            if (!TextUtils.isEmpty(str7)) {
            }
            hashMap6.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
            str8 = null;
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
            inetAddress = null;
            do {
                if (networkInterfaces.hasMoreElements()) {
                }
                hardwareAddress = ApiReplaceUtil.getHardwareAddress(NetworkInterface.getByInetAddress(inetAddress));
                StringBuffer stringBuffer222 = new StringBuffer();
                while (i2 < hardwareAddress.length) {
                }
                str8 = stringBuffer222.toString().toUpperCase();
                if (!TextUtils.isEmpty(str8)) {
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
                i3 = FunReportSdk.getInstance().isPaidUser();
                hashMap6.put("ibu", String.valueOf(i3));
                String str10222 = FunAdSdk.getFunAdConfig().userId;
                hashMap6.put("tk", str10222);
                return hashMap6;
            } while (inetAddress == null);
            hardwareAddress = ApiReplaceUtil.getHardwareAddress(NetworkInterface.getByInetAddress(inetAddress));
            StringBuffer stringBuffer2222 = new StringBuffer();
            while (i2 < hardwareAddress.length) {
            }
            str8 = stringBuffer2222.toString().toUpperCase();
            if (!TextUtils.isEmpty(str8)) {
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
            i3 = FunReportSdk.getInstance().isPaidUser();
            hashMap6.put("ibu", String.valueOf(i3));
            String str102222 = FunAdSdk.getFunAdConfig().userId;
            hashMap6.put("tk", str102222);
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
        int i32 = 2;
        i32 = 2;
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
            str8 = null;
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
            inetAddress = null;
            do {
                if (networkInterfaces.hasMoreElements()) {
                }
                hardwareAddress = ApiReplaceUtil.getHardwareAddress(NetworkInterface.getByInetAddress(inetAddress));
                StringBuffer stringBuffer22222 = new StringBuffer();
                while (i2 < hardwareAddress.length) {
                }
                str8 = stringBuffer22222.toString().toUpperCase();
                if (!TextUtils.isEmpty(str8)) {
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
                i32 = FunReportSdk.getInstance().isPaidUser();
                hashMap62.put("ibu", String.valueOf(i32));
                String str1022222 = FunAdSdk.getFunAdConfig().userId;
                hashMap62.put("tk", str1022222);
                return hashMap62;
            } while (inetAddress == null);
            hardwareAddress = ApiReplaceUtil.getHardwareAddress(NetworkInterface.getByInetAddress(inetAddress));
            StringBuffer stringBuffer222222 = new StringBuffer();
            while (i2 < hardwareAddress.length) {
            }
            str8 = stringBuffer222222.toString().toUpperCase();
            if (!TextUtils.isEmpty(str8)) {
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
            i32 = FunReportSdk.getInstance().isPaidUser();
            hashMap62.put("ibu", String.valueOf(i32));
            String str10222222 = FunAdSdk.getFunAdConfig().userId;
            hashMap62.put("tk", str10222222);
            return hashMap62;
        }
        str7 = "";
        if (!TextUtils.isEmpty(str7)) {
        }
        hashMap62.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
        str8 = null;
        networkInterfaces = NetworkInterface.getNetworkInterfaces();
        inetAddress = null;
        do {
            if (networkInterfaces.hasMoreElements()) {
            }
            hardwareAddress = ApiReplaceUtil.getHardwareAddress(NetworkInterface.getByInetAddress(inetAddress));
            StringBuffer stringBuffer2222222 = new StringBuffer();
            while (i2 < hardwareAddress.length) {
            }
            str8 = stringBuffer2222222.toString().toUpperCase();
            if (!TextUtils.isEmpty(str8)) {
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
            i32 = FunReportSdk.getInstance().isPaidUser();
            hashMap62.put("ibu", String.valueOf(i32));
            String str102222222 = FunAdSdk.getFunAdConfig().userId;
            hashMap62.put("tk", str102222222);
            return hashMap62;
        } while (inetAddress == null);
        hardwareAddress = ApiReplaceUtil.getHardwareAddress(NetworkInterface.getByInetAddress(inetAddress));
        StringBuffer stringBuffer22222222 = new StringBuffer();
        while (i2 < hardwareAddress.length) {
        }
        str8 = stringBuffer22222222.toString().toUpperCase();
        if (!TextUtils.isEmpty(str8)) {
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
        i32 = FunReportSdk.getInstance().isPaidUser();
        hashMap62.put("ibu", String.valueOf(i32));
        String str1022222222 = FunAdSdk.getFunAdConfig().userId;
        hashMap62.put("tk", str1022222222);
        return hashMap62;
        hashMap7.put(BaseStatisContent.IMSI, str4);
        b = true;
        hashMap = a;
        HashMap hashMap622 = new HashMap();
        if (hashMap != null) {
        }
        f = Z1.f(context);
        int i322 = 2;
        i322 = 2;
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
        str8 = null;
        networkInterfaces = NetworkInterface.getNetworkInterfaces();
        inetAddress = null;
        do {
            if (networkInterfaces.hasMoreElements()) {
            }
            hardwareAddress = ApiReplaceUtil.getHardwareAddress(NetworkInterface.getByInetAddress(inetAddress));
            StringBuffer stringBuffer222222222 = new StringBuffer();
            while (i2 < hardwareAddress.length) {
            }
            str8 = stringBuffer222222222.toString().toUpperCase();
            if (!TextUtils.isEmpty(str8)) {
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
            i322 = FunReportSdk.getInstance().isPaidUser();
            hashMap622.put("ibu", String.valueOf(i322));
            String str10222222222 = FunAdSdk.getFunAdConfig().userId;
            hashMap622.put("tk", str10222222222);
            return hashMap622;
        } while (inetAddress == null);
        hardwareAddress = ApiReplaceUtil.getHardwareAddress(NetworkInterface.getByInetAddress(inetAddress));
        StringBuffer stringBuffer2222222222 = new StringBuffer();
        while (i2 < hardwareAddress.length) {
        }
        str8 = stringBuffer2222222222.toString().toUpperCase();
        if (!TextUtils.isEmpty(str8)) {
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
        i322 = FunReportSdk.getInstance().isPaidUser();
        hashMap622.put("ibu", String.valueOf(i322));
        String str102222222222 = FunAdSdk.getFunAdConfig().userId;
        hashMap622.put("tk", str102222222222);
        return hashMap622;
    }
}
