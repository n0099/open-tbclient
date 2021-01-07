package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.baidu.webkit.internal.ETAG;
import com.yxcorp.kuaishou.addfp.android.Orange;
import com.yxcorp.kuaishou.addfp.android.b.f;
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
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f14683a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f14684b = "";

    public static synchronized String a() {
        String str;
        synchronized (d.class) {
            try {
                if (TextUtils.isEmpty(f14684b)) {
                    String d = Orange.eLa().d();
                    com.yxcorp.kuaishou.addfp.android.b.b.b("user dis :" + d);
                    if (!TextUtils.isEmpty(d)) {
                        byte[] bytes = d.getBytes();
                        for (int i = 0; i < bytes.length; i++) {
                            bytes[i] = (byte) (bytes[i] ^ 165);
                        }
                        f14684b = "fuels:" + Base64.encodeToString(bytes, 0);
                    }
                    if (TextUtils.isEmpty(f14684b)) {
                        str = "KWE_N";
                        f14684b = "KWE_N";
                    } else {
                        str = f14684b;
                    }
                } else {
                    str = f14684b;
                }
            }
        }
        return str;
    }

    public static String a(Context context) {
        try {
            if (com.yxcorp.kuaishou.addfp.android.b.e.a(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
                String str = "";
                if (Build.VERSION.SDK_INT < 29) {
                    try {
                        str = f.jg(context).qgx.b();
                    } catch (Throwable th) {
                    }
                    if (TextUtils.isEmpty(str) || str.startsWith("KWE")) {
                        str = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
                    }
                    return TextUtils.isEmpty(str) ? "KWE_N" : str;
                }
                String[] jf = com.yxcorp.kuaishou.addfp.android.b.a.jf(context);
                Arrays.sort(jf);
                int i = 0;
                while (i < 2) {
                    String str2 = jf[i];
                    if (TextUtils.isEmpty(str2) || str2.startsWith("KWE")) {
                        str2 = str;
                    }
                    i++;
                    str = str2;
                }
                return str;
            }
            return "KWE_PN";
        } catch (Throwable th2) {
            return "KWE_PE";
        }
    }

    public static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            return "";
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:20:0x0048
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static synchronized java.lang.String a(android.content.Context r4, boolean r5) {
        /*
            java.lang.Class<com.yxcorp.kuaishou.addfp.android.a.d> r1 = com.yxcorp.kuaishou.addfp.android.a.d.class
            monitor-enter(r1)
            java.lang.String r0 = com.yxcorp.kuaishou.addfp.android.a.d.f14683a     // Catch: java.lang.Throwable -> L3f
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L3f
            if (r0 != 0) goto Lf
            java.lang.String r0 = com.yxcorp.kuaishou.addfp.android.a.d.f14683a     // Catch: java.lang.Throwable -> L3f
        Ld:
            monitor-exit(r1)
            return r0
        Lf:
            com.yxcorp.kuaishou.addfp.android.Orange r0 = com.yxcorp.kuaishou.addfp.android.Orange.eLa()     // Catch: java.lang.Throwable -> L3f
            java.lang.String r0 = r0.d()     // Catch: java.lang.Throwable -> L3f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f
            java.lang.String r3 = "nammm :"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L3f
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L3f
            com.yxcorp.kuaishou.addfp.android.b.b.b(r2)     // Catch: java.lang.Throwable -> L3f
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L3f
            if (r2 != 0) goto L32
            com.yxcorp.kuaishou.addfp.android.a.d.f14683a = r0     // Catch: java.lang.Throwable -> L3f
        L32:
            java.lang.String r0 = com.yxcorp.kuaishou.addfp.android.a.d.f14683a     // Catch: java.lang.Throwable -> L3f
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L3f
            if (r0 == 0) goto L44
            java.lang.String r0 = f(r4)     // Catch: java.lang.Throwable -> L3f
            goto Ld
        L3f:
            r0 = move-exception
            java.lang.String r0 = "KWE_PE"
            goto Ld
        L44:
            java.lang.String r0 = "KWE_OTHER"
            goto Ld
        L48:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.d.a(android.content.Context, boolean):java.lang.String");
    }

    private static String a(Reader reader) {
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[4096];
            int read = reader.read(cArr);
            while (read >= 0) {
                sb.append(cArr, 0, read);
                read = reader.read(cArr);
            }
            return sb.toString();
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            return null;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            return Settings.System.putString(context.getContentResolver(), str, str2);
        } catch (Throwable th) {
            return false;
        }
    }

    private static String b() {
        try {
            String e = e();
            if (TextUtils.isEmpty(e)) {
                try {
                    return f().toUpperCase().substring(0, 17);
                } catch (Throwable th) {
                }
            }
            return TextUtils.isEmpty(e) ? c() : e;
        } catch (Throwable th2) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th2);
            return null;
        }
    }

    public static String b(Context context) {
        TelephonyManager telephonyManager;
        String a2;
        try {
            if (!com.yxcorp.kuaishou.addfp.android.b.e.a(context, new String[]{"android.permission.READ_PHONE_STATE"}) || Build.VERSION.SDK_INT >= 29) {
                return "";
            }
            try {
                a2 = f.jg(context).qgx.a();
            } catch (Throwable th) {
            }
            if ((TextUtils.isEmpty(a2) || a2.startsWith("KWE")) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                String deviceId = telephonyManager.getDeviceId();
                return TextUtils.isEmpty(deviceId) ? "" : deviceId;
            }
            return a2;
        } catch (Throwable th2) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th2);
            return "";
        }
    }

    private static String c() {
        byte[] hardwareAddress;
        try {
            InetAddress eLc = eLc();
            if (eLc == null || (hardwareAddress = NetworkInterface.getByInetAddress(eLc).getHardwareAddress()) == null) {
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
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            return null;
        }
    }

    public static String c(Context context) {
        try {
            return context.getPackageName().replace("=", "").replace(ETAG.ITEM_SEPARATOR, "");
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            return "KWE_PE";
        }
    }

    public static String d(Context context) {
        try {
            String a2 = com.yxcorp.kuaishou.addfp.a.eKU().a(context, b.qgu.b(), false);
            return !TextUtils.isEmpty(a2) ? a2 : "KWE_N";
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            return "KWE_PE";
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static java.lang.String e() {
        /*
            r3 = 0
            java.lang.String r1 = ""
            java.lang.String r0 = ""
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3d
            java.lang.String r4 = "cat /sys/class/net/wlan0/address"
            java.lang.Process r2 = r2.exec(r4)     // Catch: java.lang.Throwable -> L3d
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3d
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L3d
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L3d
            java.io.LineNumberReader r2 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> L75
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L75
        L20:
            if (r1 == 0) goto L2c
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L78
            if (r1 == 0) goto L20
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L78
        L2c:
            r4.close()     // Catch: java.lang.Throwable -> L33
        L2f:
            r2.close()     // Catch: java.io.IOException -> L38
        L32:
            return r0
        L33:
            r1 = move-exception
            com.yxcorp.kuaishou.addfp.android.b.b.a(r1)
            goto L2f
        L38:
            r1 = move-exception
            com.yxcorp.kuaishou.addfp.android.b.b.a(r1)
            goto L32
        L3d:
            r1 = move-exception
            r2 = r3
            r4 = r3
        L40:
            com.yxcorp.kuaishou.addfp.android.b.b.a(r1)     // Catch: java.lang.Throwable -> L73
            if (r4 == 0) goto L48
            r4.close()     // Catch: java.lang.Throwable -> L53
        L48:
            if (r2 == 0) goto L32
            r2.close()     // Catch: java.io.IOException -> L4e
            goto L32
        L4e:
            r1 = move-exception
            com.yxcorp.kuaishou.addfp.android.b.b.a(r1)
            goto L32
        L53:
            r1 = move-exception
            com.yxcorp.kuaishou.addfp.android.b.b.a(r1)
            goto L48
        L58:
            r0 = move-exception
            r2 = r3
            r4 = r3
        L5b:
            if (r4 == 0) goto L60
            r4.close()     // Catch: java.lang.Throwable -> L66
        L60:
            if (r2 == 0) goto L65
            r2.close()     // Catch: java.io.IOException -> L6b
        L65:
            throw r0
        L66:
            r1 = move-exception
            com.yxcorp.kuaishou.addfp.android.b.b.a(r1)
            goto L60
        L6b:
            r1 = move-exception
            com.yxcorp.kuaishou.addfp.android.b.b.a(r1)
            goto L65
        L70:
            r0 = move-exception
            r2 = r3
            goto L5b
        L73:
            r0 = move-exception
            goto L5b
        L75:
            r1 = move-exception
            r2 = r3
            goto L40
        L78:
            r1 = move-exception
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.d.e():java.lang.String");
    }

    public static String e(Context context) {
        String str;
        String str2;
        int i = 0;
        String str3 = "KWE_N";
        try {
            String a2 = a(context, "k_w_o_d_out_dtt");
            String str4 = "";
            if (TextUtils.isEmpty(a2)) {
                boolean e = com.yxcorp.kuaishou.addfp.android.b.e.e(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"});
                com.yxcorp.kuaishou.addfp.android.b.a.a();
                if (e) {
                    str4 = c.je(context).b("Lm91a2R0ZnQ=");
                    if (!TextUtils.isEmpty(str4)) {
                        a(context, "k_w_o_d_out_dtt", str4);
                        str = str4;
                        str2 = "KWE_N";
                    }
                } else {
                    str3 = "KWE_PN";
                }
                str = str4;
                str2 = str3;
            } else {
                boolean e2 = com.yxcorp.kuaishou.addfp.android.b.e.e(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"});
                com.yxcorp.kuaishou.addfp.android.b.a.a();
                if (e2) {
                    str4 = c.je(context).b("Lm91a2R0ZnQ=");
                    if (TextUtils.isEmpty(str4)) {
                        c.a(context, a2);
                    }
                }
                str = str4;
                str2 = "KWE_N";
            }
            if (TextUtils.isEmpty(a2) && TextUtils.isEmpty(str)) {
                return "KWE_N";
            }
            LinkedHashMap abV = c.je(context).abV(a2);
            if (abV == null || abV.size() == 0) {
                abV = c.je(context).abV(str);
            }
            if (abV != null && abV.size() > 0) {
                ListIterator listIterator = new ArrayList(abV.entrySet()).listIterator(abV.size());
                JSONObject jSONObject = new JSONObject();
                while (listIterator.hasPrevious() && i < 10) {
                    try {
                        Map.Entry entry = (Map.Entry) listIterator.previous();
                        if (entry != null) {
                            jSONObject.put((String) entry.getKey(), entry.getValue());
                        }
                        i++;
                    } catch (Throwable th) {
                    }
                }
                if (jSONObject.length() > 0) {
                    return jSONObject.toString();
                }
            }
            return str2;
        } catch (Throwable th2) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th2);
            return "KWE_PE";
        }
    }

    private static InetAddress eLc() {
        Throwable th;
        InetAddress inetAddress;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress inetAddress2 = null;
            while (networkInterfaces.hasMoreElements()) {
                try {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    InetAddress inetAddress3 = inetAddress2;
                    while (true) {
                        try {
                            if (!inetAddresses.hasMoreElements()) {
                                inetAddress = inetAddress3;
                                break;
                            }
                            inetAddress = inetAddresses.nextElement();
                            try {
                                if (!inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().indexOf(":") == -1) {
                                    break;
                                }
                                inetAddress3 = null;
                            } catch (Throwable th2) {
                                th = th2;
                                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
                                return inetAddress;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inetAddress = inetAddress3;
                        }
                    }
                    if (inetAddress != null) {
                        return inetAddress;
                    }
                    inetAddress2 = inetAddress;
                } catch (Throwable th4) {
                    th = th4;
                    inetAddress = inetAddress2;
                }
            }
            return inetAddress2;
        } catch (Throwable th5) {
            th = th5;
            inetAddress = null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static java.lang.String f() {
        /*
            r2 = 0
            java.lang.String r0 = ""
            java.lang.String r3 = "/sys/class/net/eth0/address"
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L29
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L29
            java.lang.String r0 = a(r1)     // Catch: java.lang.Throwable -> L45
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L45
            if (r2 != 0) goto L20
            java.lang.String r2 = "\n"
            java.lang.String r3 = ""
            java.lang.String r0 = r0.replaceAll(r2, r3)     // Catch: java.lang.Throwable -> L45
        L20:
            r1.close()     // Catch: java.lang.Throwable -> L24
        L23:
            return r0
        L24:
            r1 = move-exception
            com.yxcorp.kuaishou.addfp.android.b.b.a(r1)
            goto L23
        L29:
            r1 = move-exception
            r1 = r2
        L2b:
            if (r1 == 0) goto L23
            r1.close()     // Catch: java.lang.Throwable -> L31
            goto L23
        L31:
            r1 = move-exception
            com.yxcorp.kuaishou.addfp.android.b.b.a(r1)
            goto L23
        L36:
            r0 = move-exception
            r1 = r2
        L38:
            if (r1 == 0) goto L3d
            r1.close()     // Catch: java.lang.Throwable -> L3e
        L3d:
            throw r0
        L3e:
            r1 = move-exception
            com.yxcorp.kuaishou.addfp.android.b.b.a(r1)
            goto L3d
        L43:
            r0 = move-exception
            goto L38
        L45:
            r2 = move-exception
            goto L2b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.d.f():java.lang.String");
    }

    private static String f(Context context) {
        try {
            String b2 = b();
            f14683a = b2;
            if (TextUtils.isEmpty(b2) || f14683a.equals(Config.DEF_MAC_ID)) {
                if (com.yxcorp.kuaishou.addfp.android.b.e.a(context, new String[]{"android.permission.ACCESS_WIFI_STATE"}) && context != null) {
                    try {
                        f14683a = f.jg(context).qgy.a();
                    } catch (Throwable th) {
                    }
                    if (TextUtils.isEmpty(f14683a)) {
                        f14683a = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
                    }
                    if (!TextUtils.isEmpty(f14683a) && !f14683a.equals(Config.DEF_MAC_ID)) {
                        return f14683a;
                    }
                }
                return "KWE_OTHER";
            }
            return f14683a;
        } catch (Throwable th2) {
            return "KWE_PE";
        }
    }
}
