package com.win.opensdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.webkit.internal.ETAG;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes14.dex */
public class dw {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap f8160a = new HashMap();
    public static boolean b = false;

    public static String a(Map map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            sb.append(URLEncoder.encode((String) entry.getKey(), "UTF-8")).append("=").append(URLEncoder.encode((String) entry.getValue(), "UTF-8")).append(ETAG.ITEM_SEPARATOR);
        }
        return sb.substring(0, sb.length() - 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [41=4] */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't wrap try/catch for region: R(51:1|(1:3)(23:193|194|195|196|197|198|(1:200)|242|202|(1:204)(1:240)|205|206|207|(1:211)|213|(4:215|216|217|218)|221|222|223|(1:225)|226|(4:228|229|230|231)|234)|4|(1:6)|7|(2:8|9)|(49:174|175|(2:177|(1:179)(1:190))(1:191)|180|181|(1:183)(2:186|187)|184|12|(4:14|15|16|17)|20|21|22|(1:24)|25|26|27|28|(1:30)|31|(4:33|34|35|36)|39|40|41|(26:45|(1:47)(2:153|(2:155|156))|48|(1:50)|51|52|53|54|(19:55|56|(2:58|(2:59|(4:61|62|63|(1:137)(3:67|68|69))))(1:144)|72|(6:(1:76)|77|(1:79)|80|81|73)|82|83|84|(4:86|87|88|89)|92|(7:94|95|96|97|98|99|100)|105|106|(4:108|109|110|111)|114|(4:116|117|118|119)|122|(4:124|125|126|127)|131)|71|72|(1:73)|82|83|84|(0)|92|(0)|105|106|(0)|114|(0)|122|(0)|131)|167|48|(0)|51|52|53|54|(19:55|56|(0)(0)|72|(1:73)|82|83|84|(0)|92|(0)|105|106|(0)|114|(0)|122|(0)|131)|71|72|(1:73)|82|83|84|(0)|92|(0)|105|106|(0)|114|(0)|122|(0)|131)|11|12|(0)|20|21|22|(0)|25|26|27|28|(0)|31|(0)|39|40|41|(27:43|45|(0)(0)|48|(0)|51|52|53|54|(19:55|56|(0)(0)|72|(1:73)|82|83|84|(0)|92|(0)|105|106|(0)|114|(0)|122|(0)|131)|71|72|(1:73)|82|83|84|(0)|92|(0)|105|106|(0)|114|(0)|122|(0)|131)|167|48|(0)|51|52|53|54|(19:55|56|(0)(0)|72|(1:73)|82|83|84|(0)|92|(0)|105|106|(0)|114|(0)|122|(0)|131)|71|72|(1:73)|82|83|84|(0)|92|(0)|105|106|(0)|114|(0)|122|(0)|131|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(52:1|(1:3)(23:193|194|195|196|197|198|(1:200)|242|202|(1:204)(1:240)|205|206|207|(1:211)|213|(4:215|216|217|218)|221|222|223|(1:225)|226|(4:228|229|230|231)|234)|4|(1:6)|7|8|9|(49:174|175|(2:177|(1:179)(1:190))(1:191)|180|181|(1:183)(2:186|187)|184|12|(4:14|15|16|17)|20|21|22|(1:24)|25|26|27|28|(1:30)|31|(4:33|34|35|36)|39|40|41|(26:45|(1:47)(2:153|(2:155|156))|48|(1:50)|51|52|53|54|(19:55|56|(2:58|(2:59|(4:61|62|63|(1:137)(3:67|68|69))))(1:144)|72|(6:(1:76)|77|(1:79)|80|81|73)|82|83|84|(4:86|87|88|89)|92|(7:94|95|96|97|98|99|100)|105|106|(4:108|109|110|111)|114|(4:116|117|118|119)|122|(4:124|125|126|127)|131)|71|72|(1:73)|82|83|84|(0)|92|(0)|105|106|(0)|114|(0)|122|(0)|131)|167|48|(0)|51|52|53|54|(19:55|56|(0)(0)|72|(1:73)|82|83|84|(0)|92|(0)|105|106|(0)|114|(0)|122|(0)|131)|71|72|(1:73)|82|83|84|(0)|92|(0)|105|106|(0)|114|(0)|122|(0)|131)|11|12|(0)|20|21|22|(0)|25|26|27|28|(0)|31|(0)|39|40|41|(27:43|45|(0)(0)|48|(0)|51|52|53|54|(19:55|56|(0)(0)|72|(1:73)|82|83|84|(0)|92|(0)|105|106|(0)|114|(0)|122|(0)|131)|71|72|(1:73)|82|83|84|(0)|92|(0)|105|106|(0)|114|(0)|122|(0)|131)|167|48|(0)|51|52|53|54|(19:55|56|(0)(0)|72|(1:73)|82|83|84|(0)|92|(0)|105|106|(0)|114|(0)|122|(0)|131)|71|72|(1:73)|82|83|84|(0)|92|(0)|105|106|(0)|114|(0)|122|(0)|131|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02e3, code lost:
        r0 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0312, code lost:
        if (r0.equalsIgnoreCase("CDMA2000") != false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x032b, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x03af, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x03b0, code lost:
        r1 = r0;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x03c1, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x03c2, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01f0, code lost:
        if (r0.length() <= 0) goto L242;
     */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02e8 A[Catch: Exception -> 0x0323, TRY_ENTER, TryCatch #21 {Exception -> 0x0323, blocks: (B:32:0x009d, B:34:0x00ac, B:36:0x00b2, B:124:0x02e8, B:126:0x02ee, B:127:0x02f6, B:128:0x02f9, B:130:0x0302, B:132:0x030b), top: B:250:0x009d }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e9 A[Catch: Exception -> 0x032a, SocketException -> 0x03e3, TryCatch #3 {Exception -> 0x032a, blocks: (B:43:0x00de, B:45:0x00e3, B:47:0x00e9, B:48:0x00f3, B:50:0x00f9, B:51:0x00ff, B:53:0x0105, B:172:0x03b2, B:57:0x0115, B:58:0x0123, B:61:0x0128, B:62:0x012d, B:64:0x013b, B:65:0x014d, B:173:0x03b7), top: B:214:0x00de }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap iV(Context context) {
        int i;
        String str;
        HashMap hashMap;
        String str2;
        String str3;
        String str4;
        String a2;
        String str5;
        SocketException e;
        InetAddress inetAddress;
        String str6;
        double d;
        String b2;
        String c;
        String a3;
        byte[] hardwareAddress;
        int i2;
        Enumeration<NetworkInterface> networkInterfaces;
        NetworkInfo activeNetworkInfo;
        if (b) {
            hashMap = f8160a;
        } else {
            f8160a.put("app", v.b(context));
            f8160a.put("sdkna", "norm-1.1.7");
            f8160a.put("plat", "a");
            f8160a.put("model", Build.MODEL);
            f8160a.put("manu", Build.MANUFACTURER);
            f8160a.put("sysv", String.valueOf(Build.VERSION.SDK_INT));
            f8160a.put("h", String.valueOf(v.c(context)));
            f8160a.put("w", String.valueOf(v.e(context)));
            HashMap hashMap2 = f8160a;
            try {
                i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception e2) {
                i = -1;
            }
            hashMap2.put("appv", String.valueOf(i));
            HashMap hashMap3 = f8160a;
            String str7 = "";
            try {
                str7 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                if (str7 != null) {
                }
                str7 = "";
            } catch (Exception e3) {
            }
            hashMap3.put("appvn", str7);
            f8160a.put("rt", bn.a() ? "1" : "0");
            f8160a.put("dpi", String.valueOf(context.getResources().getDisplayMetrics().densityDpi));
            String str8 = "";
            try {
                str8 = Build.SERIAL;
                if (TextUtils.equals(str8, "unknown") && Build.VERSION.SDK_INT >= 26) {
                    str8 = Build.getSerial();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (!TextUtils.isEmpty(str8)) {
                HashMap hashMap4 = f8160a;
                try {
                    str8 = v.a(str8);
                } catch (Exception e5) {
                }
                hashMap4.put("serial", str8);
            }
            try {
                str = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                if (str == null) {
                    str = "";
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                HashMap hashMap5 = f8160a;
                try {
                    str = v.a(str);
                } catch (Exception e7) {
                }
                hashMap5.put("imsi", str);
            }
            b = true;
            hashMap = f8160a;
        }
        HashMap hashMap6 = new HashMap();
        if (hashMap != null) {
            hashMap6.putAll(hashMap);
        }
        String e8 = bp.e(context);
        if (TextUtils.isEmpty(e8)) {
            String str9 = "";
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT < 23) {
                str2 = telephonyManager.getDeviceId();
            } else if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                String deviceId = telephonyManager.getDeviceId(1);
                str9 = telephonyManager.getDeviceId(2);
                str2 = deviceId;
            } else {
                str2 = "";
            }
            try {
                if (TextUtils.isEmpty(str9)) {
                    bp.d(context, str2);
                } else {
                    str2 = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str9;
                    bp.d(context, str2);
                }
            } catch (Exception e9) {
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    str2 = v.a(str2);
                } catch (Exception e10) {
                }
                hashMap6.put("imei", str2);
            }
            str3 = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (!TextUtils.isEmpty(str3)) {
                hashMap6.put("opcode", str3);
            }
            str4 = "NO";
            str4 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(str4)) {
                hashMap6.put("anid", str4);
            }
            a2 = an.a(context);
            if (!TextUtils.isEmpty(a2)) {
                try {
                    a2 = v.a(a2);
                } catch (Exception e11) {
                }
                hashMap6.put("oaid", a2);
            }
            hashMap6.put("lic", context.getSharedPreferences("_prefs", 0).getString("lcss", ""));
            hashMap6.put("locale", Locale.getDefault().getLanguage());
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() != 1) {
                    str5 = "WIFI";
                } else if (activeNetworkInfo.getType() == 0) {
                    str5 = activeNetworkInfo.getSubtypeName();
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            str5 = "2G";
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
                            str5 = "3G";
                            break;
                        case 13:
                            str5 = "4G";
                            break;
                        default:
                            if (!str5.equalsIgnoreCase("TD-SCDMA") && !str5.equalsIgnoreCase("WCDMA")) {
                                break;
                            }
                            str5 = "3G";
                            break;
                    }
                }
                if (!TextUtils.isEmpty(str5)) {
                    hashMap6.put("net", str5);
                }
                hashMap6.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
                networkInterfaces = NetworkInterface.getNetworkInterfaces();
                inetAddress = null;
                do {
                    try {
                        if (!networkInterfaces.hasMoreElements()) {
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
                                    } catch (SocketException e12) {
                                        e = e12;
                                        inetAddress = nextElement;
                                        e.printStackTrace();
                                        hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
                                        StringBuffer stringBuffer = new StringBuffer();
                                        while (i2 < hardwareAddress.length) {
                                        }
                                        str6 = stringBuffer.toString().toUpperCase();
                                        if (!TextUtils.isEmpty(str6)) {
                                        }
                                        d = av.qkR.f8113a;
                                        if (d > 0.0d) {
                                        }
                                        b2 = bl.iN(context).b();
                                        if (!TextUtils.isEmpty(b2)) {
                                        }
                                        c = bl.iN(context).c();
                                        if (!TextUtils.isEmpty(c)) {
                                        }
                                        a3 = bl.iN(context).a();
                                        if (!TextUtils.isEmpty(a3)) {
                                        }
                                        return hashMap6;
                                    }
                                }
                            }
                        }
                    } catch (SocketException e13) {
                        e = e13;
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
                    str6 = stringBuffer2.toString().toUpperCase();
                    if (!TextUtils.isEmpty(str6)) {
                        try {
                            str6 = v.a(str6);
                        } catch (Exception e14) {
                        }
                        hashMap6.put("wm", str6);
                    }
                    d = av.qkR.f8113a;
                    if (d > 0.0d) {
                        String valueOf = String.valueOf(d);
                        try {
                            valueOf = v.a(valueOf);
                        } catch (Exception e15) {
                        }
                        hashMap6.put("lau", valueOf);
                        String valueOf2 = String.valueOf(av.qkR.b);
                        try {
                            valueOf2 = v.a(valueOf2);
                        } catch (Exception e16) {
                        }
                        hashMap6.put("lon", valueOf2);
                    }
                    b2 = bl.iN(context).b();
                    if (!TextUtils.isEmpty(b2)) {
                        try {
                            b2 = v.a(b2);
                        } catch (Exception e17) {
                        }
                        hashMap6.put("oid", b2);
                    }
                    c = bl.iN(context).c();
                    if (!TextUtils.isEmpty(c)) {
                        try {
                            c = v.a(c);
                        } catch (Exception e18) {
                        }
                        hashMap6.put("vid", c);
                    }
                    a3 = bl.iN(context).a();
                    if (!TextUtils.isEmpty(a3)) {
                        try {
                            a3 = v.a(a3);
                        } catch (Exception e19) {
                        }
                        hashMap6.put("aid", a3);
                    }
                    return hashMap6;
                } while (inetAddress == null);
                hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
                StringBuffer stringBuffer22 = new StringBuffer();
                while (i2 < hardwareAddress.length) {
                }
                str6 = stringBuffer22.toString().toUpperCase();
                if (!TextUtils.isEmpty(str6)) {
                }
                d = av.qkR.f8113a;
                if (d > 0.0d) {
                }
                b2 = bl.iN(context).b();
                if (!TextUtils.isEmpty(b2)) {
                }
                c = bl.iN(context).c();
                if (!TextUtils.isEmpty(c)) {
                }
                a3 = bl.iN(context).a();
                if (!TextUtils.isEmpty(a3)) {
                }
                return hashMap6;
            }
            str5 = "";
            if (!TextUtils.isEmpty(str5)) {
            }
            hashMap6.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
            inetAddress = null;
            do {
                if (!networkInterfaces.hasMoreElements()) {
                }
                hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
                StringBuffer stringBuffer222 = new StringBuffer();
                while (i2 < hardwareAddress.length) {
                }
                str6 = stringBuffer222.toString().toUpperCase();
                if (!TextUtils.isEmpty(str6)) {
                }
                d = av.qkR.f8113a;
                if (d > 0.0d) {
                }
                b2 = bl.iN(context).b();
                if (!TextUtils.isEmpty(b2)) {
                }
                c = bl.iN(context).c();
                if (!TextUtils.isEmpty(c)) {
                }
                a3 = bl.iN(context).a();
                if (!TextUtils.isEmpty(a3)) {
                }
                return hashMap6;
            } while (inetAddress == null);
            hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            StringBuffer stringBuffer2222 = new StringBuffer();
            while (i2 < hardwareAddress.length) {
            }
            str6 = stringBuffer2222.toString().toUpperCase();
            if (!TextUtils.isEmpty(str6)) {
            }
            d = av.qkR.f8113a;
            if (d > 0.0d) {
            }
            b2 = bl.iN(context).b();
            if (!TextUtils.isEmpty(b2)) {
            }
            c = bl.iN(context).c();
            if (!TextUtils.isEmpty(c)) {
            }
            a3 = bl.iN(context).a();
            if (!TextUtils.isEmpty(a3)) {
            }
            return hashMap6;
        }
        str2 = e8;
        if (!TextUtils.isEmpty(str2)) {
        }
        str3 = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        if (!TextUtils.isEmpty(str3)) {
        }
        str4 = "NO";
        str4 = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(str4)) {
        }
        a2 = an.a(context);
        if (!TextUtils.isEmpty(a2)) {
        }
        hashMap6.put("lic", context.getSharedPreferences("_prefs", 0).getString("lcss", ""));
        hashMap6.put("locale", Locale.getDefault().getLanguage());
        activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() != 1) {
            }
            if (!TextUtils.isEmpty(str5)) {
            }
            hashMap6.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
            inetAddress = null;
            do {
                if (!networkInterfaces.hasMoreElements()) {
                }
                hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
                StringBuffer stringBuffer22222 = new StringBuffer();
                while (i2 < hardwareAddress.length) {
                }
                str6 = stringBuffer22222.toString().toUpperCase();
                if (!TextUtils.isEmpty(str6)) {
                }
                d = av.qkR.f8113a;
                if (d > 0.0d) {
                }
                b2 = bl.iN(context).b();
                if (!TextUtils.isEmpty(b2)) {
                }
                c = bl.iN(context).c();
                if (!TextUtils.isEmpty(c)) {
                }
                a3 = bl.iN(context).a();
                if (!TextUtils.isEmpty(a3)) {
                }
                return hashMap6;
            } while (inetAddress == null);
            hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            StringBuffer stringBuffer222222 = new StringBuffer();
            while (i2 < hardwareAddress.length) {
            }
            str6 = stringBuffer222222.toString().toUpperCase();
            if (!TextUtils.isEmpty(str6)) {
            }
            d = av.qkR.f8113a;
            if (d > 0.0d) {
            }
            b2 = bl.iN(context).b();
            if (!TextUtils.isEmpty(b2)) {
            }
            c = bl.iN(context).c();
            if (!TextUtils.isEmpty(c)) {
            }
            a3 = bl.iN(context).a();
            if (!TextUtils.isEmpty(a3)) {
            }
            return hashMap6;
        }
        str5 = "";
        if (!TextUtils.isEmpty(str5)) {
        }
        hashMap6.put("bt", context.getSharedPreferences("_prefs", 0).getString("sever_tk", ""));
        networkInterfaces = NetworkInterface.getNetworkInterfaces();
        inetAddress = null;
        do {
            if (!networkInterfaces.hasMoreElements()) {
            }
            hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            StringBuffer stringBuffer2222222 = new StringBuffer();
            while (i2 < hardwareAddress.length) {
            }
            str6 = stringBuffer2222222.toString().toUpperCase();
            if (!TextUtils.isEmpty(str6)) {
            }
            d = av.qkR.f8113a;
            if (d > 0.0d) {
            }
            b2 = bl.iN(context).b();
            if (!TextUtils.isEmpty(b2)) {
            }
            c = bl.iN(context).c();
            if (!TextUtils.isEmpty(c)) {
            }
            a3 = bl.iN(context).a();
            if (!TextUtils.isEmpty(a3)) {
            }
            return hashMap6;
        } while (inetAddress == null);
        hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
        StringBuffer stringBuffer22222222 = new StringBuffer();
        while (i2 < hardwareAddress.length) {
        }
        str6 = stringBuffer22222222.toString().toUpperCase();
        if (!TextUtils.isEmpty(str6)) {
        }
        d = av.qkR.f8113a;
        if (d > 0.0d) {
        }
        b2 = bl.iN(context).b();
        if (!TextUtils.isEmpty(b2)) {
        }
        c = bl.iN(context).c();
        if (!TextUtils.isEmpty(c)) {
        }
        a3 = bl.iN(context).a();
        if (!TextUtils.isEmpty(a3)) {
        }
        return hashMap6;
    }
}
