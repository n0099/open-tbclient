package com.repackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
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
/* loaded from: classes5.dex */
public class dq9 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755758619, "Lcom/repackage/dq9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755758619, "Lcom/repackage/dq9;");
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't wrap try/catch for region: R(44:3|(1:5)(20:189|190|191|192|193|194|(2:240|241)|196|197|(1:199)(1:239)|200|201|202|203|204|(1:208)|210|(4:212|213|214|215)|218|219)|6|(1:8)|9|(3:10|11|(1:13)(4:172|(2:174|(1:176)(1:186))(1:187)|177|(3:181|182|183)(1:179)))|14|(3:167|168|169)|(2:16|17)|18|(1:20)|(2:21|22)|23|(1:25)|26|(3:158|159|160)|28|(2:29|30)|(26:34|(1:36)(2:140|(2:142|143))|37|(1:39)|40|41|42|43|(19:44|45|(2:47|(2:48|(4:50|51|52|(1:126)(3:56|57|58))))(1:133)|61|(5:(1:65)|66|(2:68|69)(1:71)|70|62)|72|73|74|(3:119|120|121)|76|(7:78|79|80|81|82|83|84)|89|90|(4:92|93|94|95)|98|(4:100|101|102|103)|106|(4:108|109|110|111)|115)|60|61|(1:62)|72|73|74|(0)|76|(0)|89|90|(0)|98|(0)|106|(0)|115)|156|37|(0)|40|41|42|43|(19:44|45|(0)(0)|61|(1:62)|72|73|74|(0)|76|(0)|89|90|(0)|98|(0)|106|(0)|115)|60|61|(1:62)|72|73|74|(0)|76|(0)|89|90|(0)|98|(0)|106|(0)|115) */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02ad, code lost:
        r1 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02ae, code lost:
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00a9, code lost:
        if (r5.length() <= 0) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0372, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0373, code lost:
        r9.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0112, code lost:
        if (r0 == null) goto L230;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x021a A[Catch: Exception -> 0x0250, TRY_ENTER, TryCatch #15 {Exception -> 0x0250, blocks: (B:95:0x01fd, B:97:0x020b, B:99:0x0211, B:102:0x021a, B:104:0x0220, B:105:0x0228, B:110:0x0234, B:112:0x023a, B:114:0x0242), top: B:234:0x01fd }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0277 A[Catch: SocketException -> 0x02a9, Exception -> 0x02ab, TryCatch #4 {SocketException -> 0x02a9, blocks: (B:126:0x0271, B:128:0x0277, B:129:0x0281, B:131:0x0287), top: B:213:0x0271 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0194 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x02fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x02b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0144 A[Catch: Exception -> 0x018d, TryCatch #16 {Exception -> 0x018d, blocks: (B:57:0x013d, B:60:0x0144, B:62:0x0150, B:64:0x0158, B:67:0x016a, B:71:0x0175, B:66:0x0165), top: B:236:0x013d }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x020b A[Catch: Exception -> 0x0250, TryCatch #15 {Exception -> 0x0250, blocks: (B:95:0x01fd, B:97:0x020b, B:99:0x0211, B:102:0x021a, B:104:0x0220, B:105:0x0228, B:110:0x0234, B:112:0x023a, B:114:0x0242), top: B:234:0x01fd }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap b(Context context) {
        InterceptResult invokeL;
        int i;
        String str;
        String str2;
        String str3;
        HashMap hashMap;
        String w;
        String str4;
        String str5;
        String a2;
        String str6;
        String str7;
        InetAddress inetAddress;
        double d;
        String c;
        String d2;
        String b2;
        byte[] hardwareAddress;
        int i2;
        Enumeration<NetworkInterface> networkInterfaces;
        NetworkInfo activeNetworkInfo;
        String deviceId;
        String str8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b) {
                hashMap = a;
            } else {
                a.put("app", sl9.w(context));
                a.put("sdkna", "norm-2.3.4");
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
                a.put("rt", fn9.a() ? "1" : "0");
                a.put("dpi", String.valueOf(context.getResources().getDisplayMetrics().densityDpi));
                try {
                    str2 = Build.SERIAL;
                    try {
                        if (TextUtils.equals(str2, "unknown") && Build.VERSION.SDK_INT >= 26) {
                            str2 = Build.getSerial();
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        str3 = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                    }
                } catch (Exception e2) {
                    e = e2;
                    str2 = "";
                }
                if (!TextUtils.isEmpty(str2)) {
                    HashMap hashMap4 = a;
                    try {
                        str2 = sl9.g(str2);
                    } catch (Exception unused3) {
                    }
                    hashMap4.put("serial", str2);
                }
                try {
                    str3 = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            HashMap hashMap5 = new HashMap();
            if (hashMap != null) {
                hashMap5.putAll(hashMap);
            }
            w = in9.w(context);
            try {
                if (TextUtils.isEmpty(w)) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (Build.VERSION.SDK_INT < 23) {
                        deviceId = telephonyManager.getDeviceId();
                        str8 = "";
                    } else if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                        deviceId = telephonyManager.getDeviceId(1);
                        str8 = telephonyManager.getDeviceId(2);
                    } else {
                        str8 = "";
                        deviceId = str8;
                    }
                    if (TextUtils.isEmpty(str8)) {
                        try {
                            in9.t(context, deviceId);
                        } catch (Exception unused4) {
                        }
                        w = deviceId;
                    } else {
                        w = deviceId + "_" + str8;
                        in9.t(context, w);
                    }
                }
            } catch (Exception unused5) {
            }
            if (!TextUtils.isEmpty(w)) {
                try {
                    w = sl9.g(w);
                } catch (Exception unused6) {
                }
                hashMap5.put("imei", w);
            }
            try {
                str4 = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            } catch (Exception unused7) {
                str4 = "";
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap5.put("opcode", str4);
            }
            try {
                str5 = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
            } catch (Exception unused8) {
                str5 = HlsPlaylistParser.BOOLEAN_FALSE;
            }
            if (!TextUtils.isEmpty(str5)) {
                hashMap5.put("anid", str5);
            }
            a2 = jm9.a(context);
            if (!TextUtils.isEmpty(a2)) {
                try {
                    a2 = sl9.g(a2);
                } catch (Exception unused9) {
                }
                hashMap5.put("oaid", a2);
            }
            hashMap5.put("lic", context.getSharedPreferences("_prefs", 0).getString("lcss", ""));
            hashMap5.put("locale", Locale.getDefault().getLanguage());
            try {
                activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception unused10) {
            }
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() != 1) {
                    str6 = "WIFI";
                } else if (activeNetworkInfo.getType() == 0) {
                    String subtypeName = activeNetworkInfo.getSubtypeName();
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            str6 = "2G";
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
                            str6 = "3G";
                            break;
                        case 13:
                            str6 = "4G";
                            break;
                        default:
                            if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA")) {
                                if (!subtypeName.equalsIgnoreCase("CDMA2000")) {
                                    str6 = subtypeName;
                                    break;
                                }
                            }
                            str6 = "3G";
                            break;
                    }
                }
                if (!TextUtils.isEmpty(str6)) {
                    hashMap5.put("net", str6);
                }
                hashMap5.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
                str7 = null;
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
                                        if (nextElement.isLoopbackAddress() || nextElement.getHostAddress().contains(":")) {
                                            inetAddress = null;
                                        } else {
                                            inetAddress = nextElement;
                                            continue;
                                        }
                                    } catch (SocketException e4) {
                                        e = e4;
                                        inetAddress = nextElement;
                                        e.printStackTrace();
                                        hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
                                        StringBuffer stringBuffer = new StringBuffer();
                                        while (i2 < hardwareAddress.length) {
                                        }
                                        str7 = stringBuffer.toString().toUpperCase();
                                        if (!TextUtils.isEmpty(str7)) {
                                        }
                                        d = qm9.c.a;
                                        if (d > 0.0d) {
                                        }
                                        c = cn9.a(context).c();
                                        if (!TextUtils.isEmpty(c)) {
                                        }
                                        d2 = cn9.a(context).d();
                                        if (!TextUtils.isEmpty(d2)) {
                                        }
                                        b2 = cn9.a(context).b();
                                        if (!TextUtils.isEmpty(b2)) {
                                        }
                                        return hashMap5;
                                    }
                                }
                            }
                        }
                    } catch (SocketException e5) {
                        e = e5;
                    }
                    hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
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
                    str7 = stringBuffer2.toString().toUpperCase();
                    if (!TextUtils.isEmpty(str7)) {
                        try {
                            str7 = sl9.g(str7);
                        } catch (Exception unused11) {
                        }
                        hashMap5.put("wm", str7);
                    }
                    d = qm9.c.a;
                    if (d > 0.0d) {
                        String valueOf = String.valueOf(d);
                        try {
                            valueOf = sl9.g(valueOf);
                        } catch (Exception unused12) {
                        }
                        hashMap5.put("lau", valueOf);
                        String valueOf2 = String.valueOf(qm9.c.b);
                        try {
                            valueOf2 = sl9.g(valueOf2);
                        } catch (Exception unused13) {
                        }
                        hashMap5.put("lon", valueOf2);
                    }
                    c = cn9.a(context).c();
                    if (!TextUtils.isEmpty(c)) {
                        try {
                            c = sl9.g(c);
                        } catch (Exception unused14) {
                        }
                        hashMap5.put("oid", c);
                    }
                    d2 = cn9.a(context).d();
                    if (!TextUtils.isEmpty(d2)) {
                        try {
                            d2 = sl9.g(d2);
                        } catch (Exception unused15) {
                        }
                        hashMap5.put(TiebaStatic.Params.VID, d2);
                    }
                    b2 = cn9.a(context).b();
                    if (!TextUtils.isEmpty(b2)) {
                        try {
                            b2 = sl9.g(b2);
                        } catch (Exception unused16) {
                        }
                        hashMap5.put("aid", b2);
                    }
                    return hashMap5;
                } while (inetAddress == null);
                hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
                StringBuffer stringBuffer22 = new StringBuffer();
                while (i2 < hardwareAddress.length) {
                }
                str7 = stringBuffer22.toString().toUpperCase();
                if (!TextUtils.isEmpty(str7)) {
                }
                d = qm9.c.a;
                if (d > 0.0d) {
                }
                c = cn9.a(context).c();
                if (!TextUtils.isEmpty(c)) {
                }
                d2 = cn9.a(context).d();
                if (!TextUtils.isEmpty(d2)) {
                }
                b2 = cn9.a(context).b();
                if (!TextUtils.isEmpty(b2)) {
                }
                return hashMap5;
            }
            str6 = "";
            if (!TextUtils.isEmpty(str6)) {
            }
            hashMap5.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
            str7 = null;
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
            inetAddress = null;
            do {
                if (networkInterfaces.hasMoreElements()) {
                }
                hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
                StringBuffer stringBuffer222 = new StringBuffer();
                while (i2 < hardwareAddress.length) {
                }
                str7 = stringBuffer222.toString().toUpperCase();
                if (!TextUtils.isEmpty(str7)) {
                }
                d = qm9.c.a;
                if (d > 0.0d) {
                }
                c = cn9.a(context).c();
                if (!TextUtils.isEmpty(c)) {
                }
                d2 = cn9.a(context).d();
                if (!TextUtils.isEmpty(d2)) {
                }
                b2 = cn9.a(context).b();
                if (!TextUtils.isEmpty(b2)) {
                }
                return hashMap5;
            } while (inetAddress == null);
            hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            StringBuffer stringBuffer2222 = new StringBuffer();
            while (i2 < hardwareAddress.length) {
            }
            str7 = stringBuffer2222.toString().toUpperCase();
            if (!TextUtils.isEmpty(str7)) {
            }
            d = qm9.c.a;
            if (d > 0.0d) {
            }
            c = cn9.a(context).c();
            if (!TextUtils.isEmpty(c)) {
            }
            d2 = cn9.a(context).d();
            if (!TextUtils.isEmpty(d2)) {
            }
            b2 = cn9.a(context).b();
            if (!TextUtils.isEmpty(b2)) {
            }
            return hashMap5;
        }
        return (HashMap) invokeL.objValue;
        str3 = "";
        if (!TextUtils.isEmpty(str3)) {
            HashMap hashMap6 = a;
            try {
                str3 = sl9.g(str3);
            } catch (Exception unused17) {
            }
            hashMap6.put(BaseStatisContent.IMSI, str3);
        }
        b = true;
        hashMap = a;
        HashMap hashMap52 = new HashMap();
        if (hashMap != null) {
        }
        w = in9.w(context);
        if (TextUtils.isEmpty(w)) {
        }
        if (!TextUtils.isEmpty(w)) {
        }
        str4 = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        if (!TextUtils.isEmpty(str4)) {
        }
        str5 = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
        if (!TextUtils.isEmpty(str5)) {
        }
        a2 = jm9.a(context);
        if (!TextUtils.isEmpty(a2)) {
        }
        hashMap52.put("lic", context.getSharedPreferences("_prefs", 0).getString("lcss", ""));
        hashMap52.put("locale", Locale.getDefault().getLanguage());
        activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() != 1) {
            }
            if (!TextUtils.isEmpty(str6)) {
            }
            hashMap52.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
            str7 = null;
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
            inetAddress = null;
            do {
                if (networkInterfaces.hasMoreElements()) {
                }
                hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
                StringBuffer stringBuffer22222 = new StringBuffer();
                while (i2 < hardwareAddress.length) {
                }
                str7 = stringBuffer22222.toString().toUpperCase();
                if (!TextUtils.isEmpty(str7)) {
                }
                d = qm9.c.a;
                if (d > 0.0d) {
                }
                c = cn9.a(context).c();
                if (!TextUtils.isEmpty(c)) {
                }
                d2 = cn9.a(context).d();
                if (!TextUtils.isEmpty(d2)) {
                }
                b2 = cn9.a(context).b();
                if (!TextUtils.isEmpty(b2)) {
                }
                return hashMap52;
            } while (inetAddress == null);
            hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            StringBuffer stringBuffer222222 = new StringBuffer();
            while (i2 < hardwareAddress.length) {
            }
            str7 = stringBuffer222222.toString().toUpperCase();
            if (!TextUtils.isEmpty(str7)) {
            }
            d = qm9.c.a;
            if (d > 0.0d) {
            }
            c = cn9.a(context).c();
            if (!TextUtils.isEmpty(c)) {
            }
            d2 = cn9.a(context).d();
            if (!TextUtils.isEmpty(d2)) {
            }
            b2 = cn9.a(context).b();
            if (!TextUtils.isEmpty(b2)) {
            }
            return hashMap52;
        }
        str6 = "";
        if (!TextUtils.isEmpty(str6)) {
        }
        hashMap52.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
        str7 = null;
        networkInterfaces = NetworkInterface.getNetworkInterfaces();
        inetAddress = null;
        do {
            if (networkInterfaces.hasMoreElements()) {
            }
            hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            StringBuffer stringBuffer2222222 = new StringBuffer();
            while (i2 < hardwareAddress.length) {
            }
            str7 = stringBuffer2222222.toString().toUpperCase();
            if (!TextUtils.isEmpty(str7)) {
            }
            d = qm9.c.a;
            if (d > 0.0d) {
            }
            c = cn9.a(context).c();
            if (!TextUtils.isEmpty(c)) {
            }
            d2 = cn9.a(context).d();
            if (!TextUtils.isEmpty(d2)) {
            }
            b2 = cn9.a(context).b();
            if (!TextUtils.isEmpty(b2)) {
            }
            return hashMap52;
        } while (inetAddress == null);
        hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
        StringBuffer stringBuffer22222222 = new StringBuffer();
        while (i2 < hardwareAddress.length) {
        }
        str7 = stringBuffer22222222.toString().toUpperCase();
        if (!TextUtils.isEmpty(str7)) {
        }
        d = qm9.c.a;
        if (d > 0.0d) {
        }
        c = cn9.a(context).c();
        if (!TextUtils.isEmpty(c)) {
        }
        d2 = cn9.a(context).d();
        if (!TextUtils.isEmpty(d2)) {
        }
        b2 = cn9.a(context).b();
        if (!TextUtils.isEmpty(b2)) {
        }
        return hashMap52;
        hashMap6.put(BaseStatisContent.IMSI, str3);
        b = true;
        hashMap = a;
        HashMap hashMap522 = new HashMap();
        if (hashMap != null) {
        }
        w = in9.w(context);
        if (TextUtils.isEmpty(w)) {
        }
        if (!TextUtils.isEmpty(w)) {
        }
        str4 = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        if (!TextUtils.isEmpty(str4)) {
        }
        str5 = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
        if (!TextUtils.isEmpty(str5)) {
        }
        a2 = jm9.a(context);
        if (!TextUtils.isEmpty(a2)) {
        }
        hashMap522.put("lic", context.getSharedPreferences("_prefs", 0).getString("lcss", ""));
        hashMap522.put("locale", Locale.getDefault().getLanguage());
        activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
        }
        str6 = "";
        if (!TextUtils.isEmpty(str6)) {
        }
        hashMap522.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
        str7 = null;
        networkInterfaces = NetworkInterface.getNetworkInterfaces();
        inetAddress = null;
        do {
            if (networkInterfaces.hasMoreElements()) {
            }
            hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            StringBuffer stringBuffer222222222 = new StringBuffer();
            while (i2 < hardwareAddress.length) {
            }
            str7 = stringBuffer222222222.toString().toUpperCase();
            if (!TextUtils.isEmpty(str7)) {
            }
            d = qm9.c.a;
            if (d > 0.0d) {
            }
            c = cn9.a(context).c();
            if (!TextUtils.isEmpty(c)) {
            }
            d2 = cn9.a(context).d();
            if (!TextUtils.isEmpty(d2)) {
            }
            b2 = cn9.a(context).b();
            if (!TextUtils.isEmpty(b2)) {
            }
            return hashMap522;
        } while (inetAddress == null);
        hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
        StringBuffer stringBuffer2222222222 = new StringBuffer();
        while (i2 < hardwareAddress.length) {
        }
        str7 = stringBuffer2222222222.toString().toUpperCase();
        if (!TextUtils.isEmpty(str7)) {
        }
        d = qm9.c.a;
        if (d > 0.0d) {
        }
        c = cn9.a(context).c();
        if (!TextUtils.isEmpty(c)) {
        }
        d2 = cn9.a(context).d();
        if (!TextUtils.isEmpty(d2)) {
        }
        b2 = cn9.a(context).b();
        if (!TextUtils.isEmpty(b2)) {
        }
        return hashMap522;
    }
}
