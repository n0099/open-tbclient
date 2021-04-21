package d.r.a.a.c.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.yxcorp.kuaishou.addfp.android.Orange;
import d.r.a.a.c.b.f;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f68517a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f68518b = "";

    public static synchronized String a() {
        synchronized (d.class) {
            try {
                if (!TextUtils.isEmpty(f68518b)) {
                    return f68518b;
                }
                String f2 = Orange.a().f();
                d.r.a.a.c.b.b.e("user dis :" + f2);
                if (!TextUtils.isEmpty(f2)) {
                    byte[] bytes = f2.getBytes();
                    for (int i = 0; i < bytes.length; i++) {
                        bytes[i] = (byte) (bytes[i] ^ 165);
                    }
                    f68518b = "fuels:" + Base64.encodeToString(bytes, 0);
                }
                if (TextUtils.isEmpty(f68518b)) {
                    f68518b = "KWE_N";
                    return "KWE_N";
                }
                return f68518b;
            }
        }
    }

    public static String b(Context context) {
        try {
            if (d.r.a.a.c.b.e.e(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
                String str = "";
                if (Build.VERSION.SDK_INT >= 29) {
                    String[] e2 = d.r.a.a.c.b.a.e(context);
                    Arrays.sort(e2);
                    for (int i = 0; i < 2; i++) {
                        String str2 = e2[i];
                        if (!TextUtils.isEmpty(str2) && !str2.startsWith("KWE")) {
                            str = str2;
                        }
                    }
                } else {
                    try {
                        str = f.d(context).f68528b.c();
                    } catch (Throwable unused) {
                    }
                    if (TextUtils.isEmpty(str) || str.startsWith("KWE")) {
                        str = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
                    }
                    if (TextUtils.isEmpty(str)) {
                        return "KWE_N";
                    }
                }
                return str;
            }
            return "KWE_PN";
        } catch (Throwable unused2) {
            return "KWE_PE";
        }
    }

    public static String c(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            return "";
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:23:0x0046
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static synchronized java.lang.String d(android.content.Context r3, boolean r4) {
        /*
            java.lang.Class<d.r.a.a.c.a.d> r4 = d.r.a.a.c.a.d.class
            monitor-enter(r4)
            java.lang.String r0 = d.r.a.a.c.a.d.f68517a     // Catch: java.lang.Throwable -> L42
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L42
            if (r0 != 0) goto Lf
            java.lang.String r3 = d.r.a.a.c.a.d.f68517a     // Catch: java.lang.Throwable -> L42
            monitor-exit(r4)
            return r3
        Lf:
            com.yxcorp.kuaishou.addfp.android.Orange r0 = com.yxcorp.kuaishou.addfp.android.Orange.a()     // Catch: java.lang.Throwable -> L42
            java.lang.String r0 = r0.f()     // Catch: java.lang.Throwable -> L42
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42
            java.lang.String r2 = "nammm :"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L42
            r1.append(r0)     // Catch: java.lang.Throwable -> L42
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L42
            d.r.a.a.c.b.b.e(r1)     // Catch: java.lang.Throwable -> L42
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L42
            if (r1 != 0) goto L30
            d.r.a.a.c.a.d.f68517a = r0     // Catch: java.lang.Throwable -> L42
        L30:
            java.lang.String r0 = d.r.a.a.c.a.d.f68517a     // Catch: java.lang.Throwable -> L42
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L3e
            java.lang.String r3 = p(r3)     // Catch: java.lang.Throwable -> L42
            monitor-exit(r4)
            return r3
        L3e:
            java.lang.String r3 = "KWE_OTHER"
            monitor-exit(r4)
            return r3
        L42:
            java.lang.String r3 = "KWE_PE"
            monitor-exit(r4)
            return r3
        L46:
            r3 = move-exception
            monitor-exit(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d.r.a.a.c.a.d.d(android.content.Context, boolean):java.lang.String");
    }

    public static String e(Reader reader) {
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[4096];
            while (true) {
                int read = reader.read(cArr);
                if (read < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            return null;
        }
    }

    public static boolean f(Context context, String str, String str2) {
        try {
            return Settings.System.putString(context.getContentResolver(), str, str2);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String g() {
        try {
            String m = m();
            try {
                if (TextUtils.isEmpty(m)) {
                    try {
                        return o().toUpperCase().substring(0, 17);
                    } catch (Throwable unused) {
                    }
                }
                return TextUtils.isEmpty(m) ? i() : m;
            } catch (Throwable th) {
                th = th;
                d.r.a.a.c.b.b.c(th);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String h(Context context) {
        String str;
        TelephonyManager telephonyManager;
        try {
            if (!d.r.a.a.c.b.e.e(context, new String[]{"android.permission.READ_PHONE_STATE"}) || Build.VERSION.SDK_INT >= 29) {
                return "";
            }
            try {
                str = f.d(context).f68528b.a();
            } catch (Throwable unused) {
                str = "";
            }
            if ((TextUtils.isEmpty(str) || str.startsWith("KWE")) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                String deviceId = telephonyManager.getDeviceId();
                return TextUtils.isEmpty(deviceId) ? "" : deviceId;
            }
            return str;
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            return "";
        }
    }

    public static String i() {
        byte[] hardwareAddress;
        try {
            InetAddress l = l();
            if (l == null || (hardwareAddress = NetworkInterface.getByInetAddress(l).getHardwareAddress()) == null) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < hardwareAddress.length; i++) {
                if (i != 0) {
                    stringBuffer.append(':');
                }
                String hexString = Integer.toHexString(hardwareAddress[i] & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            return null;
        }
    }

    public static String j(Context context) {
        try {
            return context.getPackageName().replace("=", "").replace("&", "");
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            return "KWE_PE";
        }
    }

    public static String k(Context context) {
        try {
            String d2 = d.r.a.a.b.c().d(context, b.f68512a.e(), false);
            return !TextUtils.isEmpty(d2) ? d2 : "KWE_N";
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            return "KWE_PE";
        }
    }

    public static InetAddress l() {
        InetAddress inetAddress;
        Throwable th;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            inetAddress = null;
            do {
                try {
                    if (!networkInterfaces.hasMoreElements()) {
                        break;
                    }
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            try {
                                if (!nextElement.isLoopbackAddress() && nextElement.getHostAddress().indexOf(":") == -1) {
                                    inetAddress = nextElement;
                                    continue;
                                    break;
                                }
                                inetAddress = null;
                            } catch (Throwable th2) {
                                th = th2;
                                inetAddress = nextElement;
                                d.r.a.a.c.b.b.c(th);
                                return inetAddress;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } while (inetAddress == null);
        } catch (Throwable th4) {
            inetAddress = null;
            th = th4;
        }
        return inetAddress;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0038 -> B:50:0x0057). Please submit an issue!!! */
    public static String m() {
        InputStreamReader inputStreamReader;
        Throwable th;
        LineNumberReader lineNumberReader;
        String str = "";
        try {
            try {
                inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address").getInputStream());
                try {
                    lineNumberReader = new LineNumberReader(inputStreamReader);
                    String str2 = "";
                    while (str2 != null) {
                        try {
                            str2 = lineNumberReader.readLine();
                            if (str2 != null) {
                                str = str2.trim();
                                break;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                d.r.a.a.c.b.b.c(th);
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (Throwable th3) {
                                        d.r.a.a.c.b.b.c(th3);
                                    }
                                }
                                if (lineNumberReader != null) {
                                    lineNumberReader.close();
                                }
                                return str;
                            } catch (Throwable th4) {
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (Throwable th5) {
                                        d.r.a.a.c.b.b.c(th5);
                                    }
                                }
                                if (lineNumberReader != null) {
                                    try {
                                        lineNumberReader.close();
                                    } catch (IOException e2) {
                                        d.r.a.a.c.b.b.c(e2);
                                    }
                                }
                                throw th4;
                            }
                        }
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Throwable th6) {
                        d.r.a.a.c.b.b.c(th6);
                    }
                    lineNumberReader.close();
                } catch (Throwable th7) {
                    lineNumberReader = null;
                    th = th7;
                }
            } catch (Throwable th8) {
                inputStreamReader = null;
                th = th8;
                lineNumberReader = null;
            }
        } catch (IOException e3) {
            d.r.a.a.c.b.b.c(e3);
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ac A[Catch: all -> 0x009a, TRY_LEAVE, TryCatch #1 {all -> 0x009a, blocks: (B:35:0x00a4, B:37:0x00ac), top: B:50:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c2 A[Catch: all -> 0x00c9, TRY_LEAVE, TryCatch #0 {all -> 0x00c9, blocks: (B:3:0x0004, B:6:0x0016, B:8:0x0023, B:10:0x0031, B:18:0x0057, B:20:0x005d, B:22:0x0063, B:24:0x006d, B:28:0x007d, B:30:0x0083, B:31:0x009a, B:39:0x00bc, B:41:0x00c2, B:26:0x0073, B:12:0x0038, B:14:0x0045, B:16:0x0053), top: B:48:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String n(Context context) {
        String str;
        LinkedHashMap d2;
        int i;
        ListIterator listIterator;
        JSONObject jSONObject;
        Map.Entry entry;
        try {
            String c2 = c(context, "k_w_o_d_out_dtt");
            String str2 = "";
            if (TextUtils.isEmpty(c2)) {
                boolean g2 = d.r.a.a.c.b.e.g(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION});
                d.r.a.a.c.b.a.b();
                if (!g2) {
                    str = "KWE_PN";
                    if (TextUtils.isEmpty(c2) || !TextUtils.isEmpty(str2)) {
                        d2 = c.b(context).d(c2);
                        if (d2 != null || d2.size() == 0) {
                            d2 = c.b(context).d(str2);
                        }
                        if (d2 != null && d2.size() > 0) {
                            i = 0;
                            listIterator = new ArrayList(d2.entrySet()).listIterator(d2.size());
                            jSONObject = new JSONObject();
                            while (listIterator.hasPrevious() && i < 10) {
                                try {
                                    entry = (Map.Entry) listIterator.previous();
                                    if (entry != null) {
                                        jSONObject.put((String) entry.getKey(), entry.getValue());
                                    }
                                    i++;
                                } catch (Throwable unused) {
                                }
                            }
                            if (jSONObject.length() > 0) {
                                return jSONObject.toString();
                            }
                        }
                        return str;
                    }
                    return "KWE_N";
                }
                str2 = c.b(context).g("Lm91a2R0ZnQ=");
                if (!TextUtils.isEmpty(str2)) {
                    f(context, "k_w_o_d_out_dtt", str2);
                }
            } else {
                boolean g3 = d.r.a.a.c.b.e.g(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION});
                d.r.a.a.c.b.a.b();
                if (g3) {
                    str2 = c.b(context).g("Lm91a2R0ZnQ=");
                    if (TextUtils.isEmpty(str2)) {
                        c.e(context, c2);
                    }
                }
            }
            str = "KWE_N";
            if (TextUtils.isEmpty(c2)) {
            }
            d2 = c.b(context).d(c2);
            if (d2 != null) {
            }
            d2 = c.b(context).d(str2);
            if (d2 != null) {
                i = 0;
                listIterator = new ArrayList(d2.entrySet()).listIterator(d2.size());
                jSONObject = new JSONObject();
                while (listIterator.hasPrevious()) {
                    entry = (Map.Entry) listIterator.previous();
                    if (entry != null) {
                    }
                    i++;
                }
                if (jSONObject.length() > 0) {
                }
            }
            return str;
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            return "KWE_PE";
        }
    }

    public static String o() {
        FileReader fileReader;
        String str;
        String str2 = "";
        try {
            fileReader = new FileReader("/sys/class/net/eth0/address");
            try {
                String e2 = e(fileReader);
                try {
                    if (!TextUtils.isEmpty(e2)) {
                        e2 = e2.replaceAll("\n", "");
                    }
                    try {
                        fileReader.close();
                        return e2;
                    } catch (Throwable th) {
                        d.r.a.a.c.b.b.c(th);
                        return e2;
                    }
                } catch (Throwable unused) {
                    str2 = str;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th2) {
                            d.r.a.a.c.b.b.c(th2);
                        }
                    }
                    return str2;
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            fileReader = null;
        }
    }

    public static String p(Context context) {
        try {
            String g2 = g();
            f68517a = g2;
            if (TextUtils.isEmpty(g2) || f68517a.equals(Config.DEF_MAC_ID)) {
                if (!d.r.a.a.c.b.e.e(context, new String[]{"android.permission.ACCESS_WIFI_STATE"}) || context == null) {
                    return "KWE_OTHER";
                }
                try {
                    f68517a = f.d(context).f68529c.a();
                } catch (Throwable unused) {
                }
                if (TextUtils.isEmpty(f68517a)) {
                    f68517a = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
                }
                return (TextUtils.isEmpty(f68517a) || f68517a.equals(Config.DEF_MAC_ID)) ? "KWE_OTHER" : f68517a;
            }
            return f68517a;
        } catch (Throwable unused2) {
            return "KWE_PE";
        }
    }
}
