package d.n.a.a.c.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.yxcorp.kuaishou.addfp.android.Orange;
import d.n.a.a.c.b.f;
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
/* loaded from: classes10.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f75142a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f75143b = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-590059099, "Ld/n/a/a/c/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-590059099, "Ld/n/a/a/c/a/d;");
        }
    }

    public static synchronized String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (d.class) {
                try {
                    if (TextUtils.isEmpty(f75143b)) {
                        String f2 = Orange.a().f();
                        d.n.a.a.c.b.b.e("user dis :" + f2);
                        if (!TextUtils.isEmpty(f2)) {
                            byte[] bytes = f2.getBytes();
                            for (int i2 = 0; i2 < bytes.length; i2++) {
                                bytes[i2] = (byte) (bytes[i2] ^ 165);
                            }
                            f75143b = "fuels:" + Base64.encodeToString(bytes, 0);
                        }
                        if (TextUtils.isEmpty(f75143b)) {
                            f75143b = "KWE_N";
                            return "KWE_N";
                        }
                        return f75143b;
                    }
                    return f75143b;
                }
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (d.n.a.a.c.b.e.e(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
                    String str = "";
                    if (Build.VERSION.SDK_INT >= 29) {
                        String[] e2 = d.n.a.a.c.b.a.e(context);
                        Arrays.sort(e2);
                        for (int i2 = 0; i2 < 2; i2++) {
                            String str2 = e2[i2];
                            if (!TextUtils.isEmpty(str2) && !str2.startsWith("KWE")) {
                                str = str2;
                            }
                        }
                    } else {
                        try {
                            str = f.d(context).f75153b.c();
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
        return (String) invokeL.objValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            try {
                return Settings.System.getString(context.getContentResolver(), str);
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:25:0x004a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static synchronized java.lang.String d(android.content.Context r4, boolean r5) {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = d.n.a.a.c.a.d.$ic
            if (r0 != 0) goto L4d
        L4:
            java.lang.Class<d.n.a.a.c.a.d> r5 = d.n.a.a.c.a.d.class
            monitor-enter(r5)
            java.lang.String r0 = d.n.a.a.c.a.d.f75142a     // Catch: java.lang.Throwable -> L46
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L46
            if (r0 != 0) goto L13
            java.lang.String r4 = d.n.a.a.c.a.d.f75142a     // Catch: java.lang.Throwable -> L46
            monitor-exit(r5)
            return r4
        L13:
            com.yxcorp.kuaishou.addfp.android.Orange r0 = com.yxcorp.kuaishou.addfp.android.Orange.a()     // Catch: java.lang.Throwable -> L46
            java.lang.String r0 = r0.f()     // Catch: java.lang.Throwable -> L46
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L46
            java.lang.String r2 = "nammm :"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L46
            r1.append(r0)     // Catch: java.lang.Throwable -> L46
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L46
            d.n.a.a.c.b.b.e(r1)     // Catch: java.lang.Throwable -> L46
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L46
            if (r1 != 0) goto L34
            d.n.a.a.c.a.d.f75142a = r0     // Catch: java.lang.Throwable -> L46
        L34:
            java.lang.String r0 = d.n.a.a.c.a.d.f75142a     // Catch: java.lang.Throwable -> L46
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L42
            java.lang.String r4 = p(r4)     // Catch: java.lang.Throwable -> L46
            monitor-exit(r5)
            return r4
        L42:
            java.lang.String r4 = "KWE_OTHER"
            monitor-exit(r5)
            return r4
        L46:
            java.lang.String r4 = "KWE_PE"
            monitor-exit(r5)
            return r4
        L4a:
            r4 = move-exception
            monitor-exit(r5)
            throw r4
        L4d:
            r1 = r0
            r2 = 65540(0x10004, float:9.1841E-41)
            r3 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r1.invokeLZ(r2, r3, r4, r5)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.n.a.a.c.a.d.d(android.content.Context, boolean):java.lang.String");
    }

    public static String e(Reader reader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, reader)) != null) {
            return (String) invokeL.objValue;
        }
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
            d.n.a.a.c.b.b.c(th);
            return null;
        }
    }

    public static boolean f(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, str2)) == null) {
            try {
                return Settings.System.putString(context.getContentResolver(), str, str2);
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65543, null)) != null) {
            return (String) invokeV.objValue;
        }
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
                d.n.a.a.c.b.b.c(th);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        String str;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                if (!d.n.a.a.c.b.e.e(context, new String[]{"android.permission.READ_PHONE_STATE"}) || Build.VERSION.SDK_INT >= 29) {
                    return "";
                }
                try {
                    str = f.d(context).f75153b.a();
                } catch (Throwable unused) {
                    str = "";
                }
                if ((TextUtils.isEmpty(str) || str.startsWith("KWE")) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    String deviceId = telephonyManager.getDeviceId();
                    return TextUtils.isEmpty(deviceId) ? "" : deviceId;
                }
                return str;
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        byte[] hardwareAddress;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                InetAddress l = l();
                if (l == null || (hardwareAddress = NetworkInterface.getByInetAddress(l).getHardwareAddress()) == null) {
                    return null;
                }
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < hardwareAddress.length; i2++) {
                    if (i2 != 0) {
                        stringBuffer.append(':');
                    }
                    String hexString = Integer.toHexString(hardwareAddress[i2] & 255);
                    if (hexString.length() == 1) {
                        hexString = "0" + hexString;
                    }
                    stringBuffer.append(hexString);
                }
                return stringBuffer.toString();
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
                return context.getPackageName().replace("=", "").replace("&", "");
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return "KWE_PE";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            try {
                String d2 = d.n.a.a.b.c().d(context, b.f75137a.e(), false);
                return !TextUtils.isEmpty(d2) ? d2 : "KWE_N";
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return "KWE_PE";
            }
        }
        return (String) invokeL.objValue;
    }

    public static InetAddress l() {
        InterceptResult invokeV;
        InetAddress inetAddress;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
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
                                    d.n.a.a.c.b.b.c(th);
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
        return (InetAddress) invokeV.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x003c -> B:68:0x005b). Please submit an issue!!! */
    public static String m() {
        InterceptResult invokeV;
        InputStreamReader inputStreamReader;
        Throwable th;
        LineNumberReader lineNumberReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
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
                                    d.n.a.a.c.b.b.c(th);
                                    if (inputStreamReader != null) {
                                        try {
                                            inputStreamReader.close();
                                        } catch (Throwable th3) {
                                            d.n.a.a.c.b.b.c(th3);
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
                                            d.n.a.a.c.b.b.c(th5);
                                        }
                                    }
                                    if (lineNumberReader != null) {
                                        try {
                                            lineNumberReader.close();
                                        } catch (IOException e2) {
                                            d.n.a.a.c.b.b.c(e2);
                                        }
                                    }
                                    throw th4;
                                }
                            }
                        }
                        try {
                            inputStreamReader.close();
                        } catch (Throwable th6) {
                            d.n.a.a.c.b.b.c(th6);
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
                d.n.a.a.c.b.b.c(e3);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b0 A[Catch: all -> 0x009e, TRY_LEAVE, TryCatch #1 {all -> 0x009e, blocks: (B:37:0x00a8, B:39:0x00b0), top: B:56:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6 A[Catch: all -> 0x00cd, TRY_LEAVE, TryCatch #0 {all -> 0x00cd, blocks: (B:5:0x0008, B:8:0x001a, B:10:0x0027, B:12:0x0035, B:20:0x005b, B:22:0x0061, B:24:0x0067, B:26:0x0071, B:30:0x0081, B:32:0x0087, B:33:0x009e, B:41:0x00c0, B:43:0x00c6, B:28:0x0077, B:14:0x003c, B:16:0x0049, B:18:0x0057), top: B:54:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String n(Context context) {
        InterceptResult invokeL;
        String str;
        LinkedHashMap d2;
        int i2;
        ListIterator listIterator;
        JSONObject jSONObject;
        Map.Entry entry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            try {
                String c2 = c(context, "k_w_o_d_out_dtt");
                String str2 = "";
                if (TextUtils.isEmpty(c2)) {
                    boolean g2 = d.n.a.a.c.b.e.g(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION});
                    d.n.a.a.c.b.a.b();
                    if (!g2) {
                        str = "KWE_PN";
                        if (TextUtils.isEmpty(c2) || !TextUtils.isEmpty(str2)) {
                            d2 = c.b(context).d(c2);
                            if (d2 != null || d2.size() == 0) {
                                d2 = c.b(context).d(str2);
                            }
                            if (d2 != null && d2.size() > 0) {
                                i2 = 0;
                                listIterator = new ArrayList(d2.entrySet()).listIterator(d2.size());
                                jSONObject = new JSONObject();
                                while (listIterator.hasPrevious() && i2 < 10) {
                                    try {
                                        entry = (Map.Entry) listIterator.previous();
                                        if (entry != null) {
                                            jSONObject.put((String) entry.getKey(), entry.getValue());
                                        }
                                        i2++;
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
                    boolean g3 = d.n.a.a.c.b.e.g(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION});
                    d.n.a.a.c.b.a.b();
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
                    i2 = 0;
                    listIterator = new ArrayList(d2.entrySet()).listIterator(d2.size());
                    jSONObject = new JSONObject();
                    while (listIterator.hasPrevious()) {
                        entry = (Map.Entry) listIterator.previous();
                        if (entry != null) {
                        }
                        i2++;
                    }
                    if (jSONObject.length() > 0) {
                    }
                }
                return str;
            } catch (Throwable th) {
                d.n.a.a.c.b.b.c(th);
                return "KWE_PE";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String o() {
        InterceptResult invokeV;
        FileReader fileReader;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65551, null)) != null) {
            return (String) invokeV.objValue;
        }
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
                        d.n.a.a.c.b.b.c(th);
                        return e2;
                    }
                } catch (Throwable unused) {
                    str2 = str;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th2) {
                            d.n.a.a.c.b.b.c(th2);
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            try {
                String g2 = g();
                f75142a = g2;
                if (TextUtils.isEmpty(g2) || f75142a.equals(Config.DEF_MAC_ID)) {
                    if (!d.n.a.a.c.b.e.e(context, new String[]{"android.permission.ACCESS_WIFI_STATE"}) || context == null) {
                        return "KWE_OTHER";
                    }
                    try {
                        f75142a = f.d(context).f75154c.a();
                    } catch (Throwable unused) {
                    }
                    if (TextUtils.isEmpty(f75142a)) {
                        f75142a = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
                    }
                    return (TextUtils.isEmpty(f75142a) || f75142a.equals(Config.DEF_MAC_ID)) ? "KWE_OTHER" : f75142a;
                }
                return f75142a;
            } catch (Throwable unused2) {
                return "KWE_PE";
            }
        }
        return (String) invokeL.objValue;
    }
}
