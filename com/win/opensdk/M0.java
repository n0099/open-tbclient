package com.win.opensdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes7.dex */
public class M0 {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap f36951a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f36952b = false;

    public static String a(Map map) {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't wrap try/catch for region: R(45:1|(1:3)(20:187|188|189|190|191|192|(2:238|239)|194|195|(1:197)(1:237)|198|199|200|202|203|(1:207)|209|(4:211|212|213|214)|217|218)|4|(1:6)|7|(3:8|9|(1:11)(4:170|(2:172|(1:174)(1:184))(1:185)|175|(3:179|180|181)(1:177)))|12|(3:165|166|167)|(2:14|15)|16|(1:18)|(2:19|20)|21|(1:23)|24|(3:156|157|158)|26|(2:27|28)|(26:32|(1:34)(2:138|(2:140|141))|35|(1:37)|38|39|40|41|(19:42|43|(2:45|(2:46|(4:48|49|50|(1:124)(3:54|55|56))))(1:131)|59|(5:(1:63)|64|(2:66|67)(1:69)|68|60)|70|71|72|(3:117|118|119)|74|(7:76|77|78|79|80|81|82)|87|88|(4:90|91|92|93)|96|(4:98|99|100|101)|104|(4:106|107|108|109)|113)|58|59|(1:60)|70|71|72|(0)|74|(0)|87|88|(0)|96|(0)|104|(0)|113)|154|35|(0)|38|39|40|41|(19:42|43|(0)(0)|59|(1:60)|70|71|72|(0)|74|(0)|87|88|(0)|96|(0)|104|(0)|113)|58|59|(1:60)|70|71|72|(0)|74|(0)|87|88|(0)|96|(0)|104|(0)|113|(5:(1:230)|(0)|(0)|(51:229|220|(4:222|223|224|225)|228|4|(0)|7|8|9|(0)(0)|12|(0)|14|15|16|(0)|19|20|21|(0)|24|(0)|26|27|28|(27:30|32|(0)(0)|35|(0)|38|39|40|41|(19:42|43|(0)(0)|59|(1:60)|70|71|72|(0)|74|(0)|87|88|(0)|96|(0)|104|(0)|113)|58|59|(1:60)|70|71|72|(0)|74|(0)|87|88|(0)|96|(0)|104|(0)|113)|154|35|(0)|38|39|40|41|(19:42|43|(0)(0)|59|(1:60)|70|71|72|(0)|74|(0)|87|88|(0)|96|(0)|104|(0)|113)|58|59|(1:60)|70|71|72|(0)|74|(0)|87|88|(0)|96|(0)|104|(0)|113)|(49:225|228|4|(0)|7|8|9|(0)(0)|12|(0)|14|15|16|(0)|19|20|21|(0)|24|(0)|26|27|28|(0)|154|35|(0)|38|39|40|41|(19:42|43|(0)(0)|59|(1:60)|70|71|72|(0)|74|(0)|87|88|(0)|96|(0)|104|(0)|113)|58|59|(1:60)|70|71|72|(0)|74|(0)|87|88|(0)|96|(0)|104|(0)|113))) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00a5, code lost:
        if (r5.length() <= 0) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02a9, code lost:
        r1 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02aa, code lost:
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x036e, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x036f, code lost:
        r9.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x010e, code lost:
        if (r0 == null) goto L229;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0216 A[Catch: Exception -> 0x024c, TRY_ENTER, TryCatch #14 {Exception -> 0x024c, blocks: (B:93:0x01f9, B:95:0x0207, B:97:0x020d, B:100:0x0216, B:102:0x021c, B:103:0x0224, B:108:0x0230, B:110:0x0236, B:112:0x023e), top: B:226:0x01f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0273 A[Catch: SocketException -> 0x02a5, Exception -> 0x02a7, TryCatch #0 {SocketException -> 0x02a5, blocks: (B:124:0x026d, B:126:0x0273, B:127:0x027d, B:129:0x0283), top: B:199:0x026d }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x01d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0190 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x02ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0140 A[Catch: Exception -> 0x0189, TryCatch #15 {Exception -> 0x0189, blocks: (B:55:0x0139, B:58:0x0140, B:60:0x014c, B:62:0x0154, B:65:0x0166, B:69:0x0171, B:64:0x0161), top: B:228:0x0139 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0207 A[Catch: Exception -> 0x024c, TryCatch #14 {Exception -> 0x024c, blocks: (B:93:0x01f9, B:95:0x0207, B:97:0x020d, B:100:0x0216, B:102:0x021c, B:103:0x0224, B:108:0x0230, B:110:0x0236, B:112:0x023e), top: B:226:0x01f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0213  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap a(Context context) {
        int i2;
        String str;
        String str2;
        String str3;
        HashMap hashMap;
        String str4;
        String str5;
        String str6;
        String str7;
        InetAddress inetAddress;
        double d2;
        String b2;
        String c2;
        String a2;
        byte[] hardwareAddress;
        int i3;
        Enumeration<NetworkInterface> networkInterfaces;
        NetworkInfo activeNetworkInfo;
        String deviceId;
        String str8;
        if (f36952b) {
            hashMap = f36951a;
        } else {
            f36951a.put("app", z.b(context));
            f36951a.put("sdkna", "norm-1.2.2");
            f36951a.put("plat", "a");
            f36951a.put("model", Build.MODEL);
            f36951a.put("manu", Build.MANUFACTURER);
            f36951a.put("sysv", String.valueOf(Build.VERSION.SDK_INT));
            f36951a.put("h", String.valueOf(context.getResources().getDisplayMetrics().heightPixels));
            f36951a.put("w", String.valueOf(context.getResources().getDisplayMetrics().widthPixels));
            HashMap hashMap2 = f36951a;
            try {
                i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception unused) {
                i2 = -1;
            }
            hashMap2.put("appv", String.valueOf(i2));
            HashMap hashMap3 = f36951a;
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                if (str != null) {
                }
            } catch (Exception unused2) {
            }
            str = "";
            hashMap3.put("appvn", str);
            f36951a.put("rt", r1.a() ? "1" : "0");
            f36951a.put("dpi", String.valueOf(context.getResources().getDisplayMetrics().densityDpi));
            try {
                str2 = Build.SERIAL;
            } catch (Exception e2) {
                e = e2;
                str2 = "";
            }
            try {
                if (TextUtils.equals(str2, "unknown") && Build.VERSION.SDK_INT >= 26) {
                    str2 = Build.getSerial();
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                if (!TextUtils.isEmpty(str2)) {
                }
                str3 = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            }
            if (!TextUtils.isEmpty(str2)) {
                HashMap hashMap4 = f36951a;
                try {
                    str2 = z.a(str2);
                } catch (Exception unused3) {
                }
                hashMap4.put("serial", str2);
            }
            try {
                str3 = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        HashMap hashMap5 = new HashMap();
        if (hashMap != null) {
            hashMap5.putAll(hashMap);
        }
        String e5 = s1.e(context);
        try {
            if (TextUtils.isEmpty(e5)) {
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
                        s1.d(context, deviceId);
                    } catch (Exception unused4) {
                    }
                    e5 = deviceId;
                } else {
                    e5 = deviceId + "_" + str8;
                    s1.d(context, e5);
                }
            }
        } catch (Exception unused5) {
        }
        if (!TextUtils.isEmpty(e5)) {
            try {
                e5 = z.a(e5);
            } catch (Exception unused6) {
            }
            hashMap5.put("imei", e5);
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
            str5 = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        } catch (Exception unused8) {
            str5 = "NO";
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap5.put("anid", str5);
        }
        String a3 = j1.a(context);
        if (!TextUtils.isEmpty(a3)) {
            try {
                a3 = z.a(a3);
            } catch (Exception unused9) {
            }
            hashMap5.put("oaid", a3);
        }
        hashMap5.put("lic", context.getSharedPreferences("_prefs", 0).getString("lcss", ""));
        hashMap5.put("locale", Locale.getDefault().getLanguage());
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused10) {
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() != 1) {
                str6 = CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
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
                        str6 = com.baidu.apollon.statistics.g.f3963b;
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
                        str6 = com.baidu.apollon.statistics.g.f3963b;
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
                                } catch (SocketException e6) {
                                    e = e6;
                                    inetAddress = nextElement;
                                    e.printStackTrace();
                                    hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
                                    StringBuffer stringBuffer = new StringBuffer();
                                    while (i3 < hardwareAddress.length) {
                                    }
                                    str7 = stringBuffer.toString().toUpperCase();
                                    if (!TextUtils.isEmpty(str7)) {
                                    }
                                    d2 = m1.f37156c.f37157a;
                                    if (d2 > 0.0d) {
                                    }
                                    b2 = q1.a(context).b();
                                    if (!TextUtils.isEmpty(b2)) {
                                    }
                                    c2 = q1.a(context).c();
                                    if (!TextUtils.isEmpty(c2)) {
                                    }
                                    a2 = q1.a(context).a();
                                    if (!TextUtils.isEmpty(a2)) {
                                    }
                                    return hashMap5;
                                }
                            }
                        }
                    }
                } catch (SocketException e7) {
                    e = e7;
                }
                hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
                StringBuffer stringBuffer2 = new StringBuffer();
                for (i3 = 0; i3 < hardwareAddress.length; i3++) {
                    if (i3 != 0) {
                        stringBuffer2.append(':');
                    }
                    String hexString = Integer.toHexString(hardwareAddress[i3] & 255);
                    if (hexString.length() == 1) {
                        hexString = 0 + hexString;
                    }
                    stringBuffer2.append(hexString);
                }
                str7 = stringBuffer2.toString().toUpperCase();
                if (!TextUtils.isEmpty(str7)) {
                    try {
                        str7 = z.a(str7);
                    } catch (Exception unused11) {
                    }
                    hashMap5.put("wm", str7);
                }
                d2 = m1.f37156c.f37157a;
                if (d2 > 0.0d) {
                    String valueOf = String.valueOf(d2);
                    try {
                        valueOf = z.a(valueOf);
                    } catch (Exception unused12) {
                    }
                    hashMap5.put("lau", valueOf);
                    String valueOf2 = String.valueOf(m1.f37156c.f37158b);
                    try {
                        valueOf2 = z.a(valueOf2);
                    } catch (Exception unused13) {
                    }
                    hashMap5.put("lon", valueOf2);
                }
                b2 = q1.a(context).b();
                if (!TextUtils.isEmpty(b2)) {
                    try {
                        b2 = z.a(b2);
                    } catch (Exception unused14) {
                    }
                    hashMap5.put("oid", b2);
                }
                c2 = q1.a(context).c();
                if (!TextUtils.isEmpty(c2)) {
                    try {
                        c2 = z.a(c2);
                    } catch (Exception unused15) {
                    }
                    hashMap5.put(TiebaStatic.Params.VID, c2);
                }
                a2 = q1.a(context).a();
                if (!TextUtils.isEmpty(a2)) {
                    try {
                        a2 = z.a(a2);
                    } catch (Exception unused16) {
                    }
                    hashMap5.put("aid", a2);
                }
                return hashMap5;
            } while (inetAddress == null);
            hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            StringBuffer stringBuffer22 = new StringBuffer();
            while (i3 < hardwareAddress.length) {
            }
            str7 = stringBuffer22.toString().toUpperCase();
            if (!TextUtils.isEmpty(str7)) {
            }
            d2 = m1.f37156c.f37157a;
            if (d2 > 0.0d) {
            }
            b2 = q1.a(context).b();
            if (!TextUtils.isEmpty(b2)) {
            }
            c2 = q1.a(context).c();
            if (!TextUtils.isEmpty(c2)) {
            }
            a2 = q1.a(context).a();
            if (!TextUtils.isEmpty(a2)) {
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
            while (i3 < hardwareAddress.length) {
            }
            str7 = stringBuffer222.toString().toUpperCase();
            if (!TextUtils.isEmpty(str7)) {
            }
            d2 = m1.f37156c.f37157a;
            if (d2 > 0.0d) {
            }
            b2 = q1.a(context).b();
            if (!TextUtils.isEmpty(b2)) {
            }
            c2 = q1.a(context).c();
            if (!TextUtils.isEmpty(c2)) {
            }
            a2 = q1.a(context).a();
            if (!TextUtils.isEmpty(a2)) {
            }
            return hashMap5;
        } while (inetAddress == null);
        hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
        StringBuffer stringBuffer2222 = new StringBuffer();
        while (i3 < hardwareAddress.length) {
        }
        str7 = stringBuffer2222.toString().toUpperCase();
        if (!TextUtils.isEmpty(str7)) {
        }
        d2 = m1.f37156c.f37157a;
        if (d2 > 0.0d) {
        }
        b2 = q1.a(context).b();
        if (!TextUtils.isEmpty(b2)) {
        }
        c2 = q1.a(context).c();
        if (!TextUtils.isEmpty(c2)) {
        }
        a2 = q1.a(context).a();
        if (!TextUtils.isEmpty(a2)) {
        }
        return hashMap5;
        str3 = "";
        if (!TextUtils.isEmpty(str3)) {
            HashMap hashMap6 = f36951a;
            try {
                str3 = z.a(str3);
            } catch (Exception unused17) {
            }
            hashMap6.put("imsi", str3);
        }
        f36952b = true;
        hashMap = f36951a;
        HashMap hashMap52 = new HashMap();
        if (hashMap != null) {
        }
        String e52 = s1.e(context);
        if (TextUtils.isEmpty(e52)) {
        }
        if (!TextUtils.isEmpty(e52)) {
        }
        str4 = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        if (!TextUtils.isEmpty(str4)) {
        }
        str5 = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        if (!TextUtils.isEmpty(str5)) {
        }
        String a32 = j1.a(context);
        if (!TextUtils.isEmpty(a32)) {
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
                while (i3 < hardwareAddress.length) {
                }
                str7 = stringBuffer22222.toString().toUpperCase();
                if (!TextUtils.isEmpty(str7)) {
                }
                d2 = m1.f37156c.f37157a;
                if (d2 > 0.0d) {
                }
                b2 = q1.a(context).b();
                if (!TextUtils.isEmpty(b2)) {
                }
                c2 = q1.a(context).c();
                if (!TextUtils.isEmpty(c2)) {
                }
                a2 = q1.a(context).a();
                if (!TextUtils.isEmpty(a2)) {
                }
                return hashMap52;
            } while (inetAddress == null);
            hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            StringBuffer stringBuffer222222 = new StringBuffer();
            while (i3 < hardwareAddress.length) {
            }
            str7 = stringBuffer222222.toString().toUpperCase();
            if (!TextUtils.isEmpty(str7)) {
            }
            d2 = m1.f37156c.f37157a;
            if (d2 > 0.0d) {
            }
            b2 = q1.a(context).b();
            if (!TextUtils.isEmpty(b2)) {
            }
            c2 = q1.a(context).c();
            if (!TextUtils.isEmpty(c2)) {
            }
            a2 = q1.a(context).a();
            if (!TextUtils.isEmpty(a2)) {
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
            while (i3 < hardwareAddress.length) {
            }
            str7 = stringBuffer2222222.toString().toUpperCase();
            if (!TextUtils.isEmpty(str7)) {
            }
            d2 = m1.f37156c.f37157a;
            if (d2 > 0.0d) {
            }
            b2 = q1.a(context).b();
            if (!TextUtils.isEmpty(b2)) {
            }
            c2 = q1.a(context).c();
            if (!TextUtils.isEmpty(c2)) {
            }
            a2 = q1.a(context).a();
            if (!TextUtils.isEmpty(a2)) {
            }
            return hashMap52;
        } while (inetAddress == null);
        hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
        StringBuffer stringBuffer22222222 = new StringBuffer();
        while (i3 < hardwareAddress.length) {
        }
        str7 = stringBuffer22222222.toString().toUpperCase();
        if (!TextUtils.isEmpty(str7)) {
        }
        d2 = m1.f37156c.f37157a;
        if (d2 > 0.0d) {
        }
        b2 = q1.a(context).b();
        if (!TextUtils.isEmpty(b2)) {
        }
        c2 = q1.a(context).c();
        if (!TextUtils.isEmpty(c2)) {
        }
        a2 = q1.a(context).a();
        if (!TextUtils.isEmpty(a2)) {
        }
        return hashMap52;
        hashMap6.put("imsi", str3);
        f36952b = true;
        hashMap = f36951a;
        HashMap hashMap522 = new HashMap();
        if (hashMap != null) {
        }
        String e522 = s1.e(context);
        if (TextUtils.isEmpty(e522)) {
        }
        if (!TextUtils.isEmpty(e522)) {
        }
        str4 = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        if (!TextUtils.isEmpty(str4)) {
        }
        str5 = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        if (!TextUtils.isEmpty(str5)) {
        }
        String a322 = j1.a(context);
        if (!TextUtils.isEmpty(a322)) {
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
            while (i3 < hardwareAddress.length) {
            }
            str7 = stringBuffer222222222.toString().toUpperCase();
            if (!TextUtils.isEmpty(str7)) {
            }
            d2 = m1.f37156c.f37157a;
            if (d2 > 0.0d) {
            }
            b2 = q1.a(context).b();
            if (!TextUtils.isEmpty(b2)) {
            }
            c2 = q1.a(context).c();
            if (!TextUtils.isEmpty(c2)) {
            }
            a2 = q1.a(context).a();
            if (!TextUtils.isEmpty(a2)) {
            }
            return hashMap522;
        } while (inetAddress == null);
        hardwareAddress = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
        StringBuffer stringBuffer2222222222 = new StringBuffer();
        while (i3 < hardwareAddress.length) {
        }
        str7 = stringBuffer2222222222.toString().toUpperCase();
        if (!TextUtils.isEmpty(str7)) {
        }
        d2 = m1.f37156c.f37157a;
        if (d2 > 0.0d) {
        }
        b2 = q1.a(context).b();
        if (!TextUtils.isEmpty(b2)) {
        }
        c2 = q1.a(context).c();
        if (!TextUtils.isEmpty(c2)) {
        }
        a2 = q1.a(context).a();
        if (!TextUtils.isEmpty(a2)) {
        }
        return hashMap522;
    }
}
