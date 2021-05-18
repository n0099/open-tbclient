package d.q.a.a.c.a;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.yxcorp.kuaishou.addfp.android.Orange;
import d.q.a.a.c.b.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f67582a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f67583b = "";

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:20:0x003a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static synchronized java.lang.String a() {
        /*
            java.lang.Class<d.q.a.a.c.a.d> r0 = d.q.a.a.c.a.d.class
            monitor-enter(r0)
            java.lang.String r1 = d.q.a.a.c.a.d.f67582a     // Catch: java.lang.Throwable -> L36
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L36
            if (r1 != 0) goto Lf
            java.lang.String r1 = d.q.a.a.c.a.d.f67582a     // Catch: java.lang.Throwable -> L36
            monitor-exit(r0)
            return r1
        Lf:
            com.yxcorp.kuaishou.addfp.android.Orange r1 = com.yxcorp.kuaishou.addfp.android.Orange.a()     // Catch: java.lang.Throwable -> L36
            java.lang.String r1 = r1.f()     // Catch: java.lang.Throwable -> L36
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L36
            java.lang.String r3 = "nammm :"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L36
            r2.append(r1)     // Catch: java.lang.Throwable -> L36
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L36
            d.q.a.a.c.b.b.e(r2)     // Catch: java.lang.Throwable -> L36
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L36
            if (r2 != 0) goto L32
            d.q.a.a.c.a.d.f67582a = r1     // Catch: java.lang.Throwable -> L36
            monitor-exit(r0)
            return r1
        L32:
            java.lang.String r1 = "KWE_OTHER"
            monitor-exit(r0)
            return r1
        L36:
            java.lang.String r1 = "KWE_PE"
            monitor-exit(r0)
            return r1
        L3a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.q.a.a.c.a.d.a():java.lang.String");
    }

    public static String b(Context context) {
        try {
            if (d.q.a.a.c.b.e.c(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
                String str = "";
                if (Build.VERSION.SDK_INT >= 29) {
                    String[] e2 = d.q.a.a.c.b.a.e(context);
                    Arrays.sort(e2);
                    for (int i2 = 0; i2 < 2; i2++) {
                        String str2 = e2[i2];
                        if (!TextUtils.isEmpty(str2) && !str2.startsWith("KWE")) {
                            str = str2;
                        }
                    }
                } else {
                    try {
                        str = f.d(context).f67593b.c();
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
            d.q.a.a.c.b.b.c(th);
            return "";
        }
    }

    public static boolean d(Context context, String str, String str2) {
        try {
            return Settings.System.putString(context.getContentResolver(), str, str2);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static synchronized String e() {
        synchronized (d.class) {
            try {
                if (!TextUtils.isEmpty(f67583b)) {
                    return f67583b;
                }
                String f2 = Orange.a().f();
                d.q.a.a.c.b.b.e("user dis :" + f2);
                if (!TextUtils.isEmpty(f2)) {
                    byte[] bytes = f2.getBytes();
                    for (int i2 = 0; i2 < bytes.length; i2++) {
                        bytes[i2] = (byte) (bytes[i2] ^ 165);
                    }
                    f67583b = "fuels:" + Base64.encodeToString(bytes, 0).replace("\n", "").replace("\r", "");
                }
                if (TextUtils.isEmpty(f67583b)) {
                    f67583b = "KWE_N";
                    return "KWE_N";
                }
                return f67583b;
            }
        }
    }

    public static String f(Context context) {
        String str;
        TelephonyManager telephonyManager;
        try {
            if (!d.q.a.a.c.b.e.c(context, new String[]{"android.permission.READ_PHONE_STATE"}) || Build.VERSION.SDK_INT >= 29) {
                return "";
            }
            try {
                str = f.d(context).f67593b.a();
            } catch (Throwable unused) {
                str = "";
            }
            if ((TextUtils.isEmpty(str) || str.startsWith("KWE")) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                String deviceId = telephonyManager.getDeviceId();
                return TextUtils.isEmpty(deviceId) ? "" : deviceId;
            }
            return str;
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return "";
        }
    }

    public static String g(Context context) {
        try {
            return context.getPackageName().replace("=", "").replace("&", "");
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return "KWE_PE";
        }
    }

    public static String h(Context context) {
        try {
            String c2 = d.q.a.a.b.b().c(context, b.f67577a.e(), false);
            return !TextUtils.isEmpty(c2) ? c2 : "KWE_N";
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return "KWE_PE";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ac A[Catch: all -> 0x009a, TRY_LEAVE, TryCatch #1 {all -> 0x009a, blocks: (B:35:0x00a4, B:37:0x00ac), top: B:50:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c2 A[Catch: all -> 0x00c9, TRY_LEAVE, TryCatch #0 {all -> 0x00c9, blocks: (B:3:0x0004, B:6:0x0016, B:8:0x0023, B:10:0x0031, B:18:0x0057, B:20:0x005d, B:22:0x0063, B:24:0x006d, B:28:0x007d, B:30:0x0083, B:31:0x009a, B:39:0x00bc, B:41:0x00c2, B:26:0x0073, B:12:0x0038, B:14:0x0045, B:16:0x0053), top: B:48:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String i(Context context) {
        String str;
        LinkedHashMap d2;
        int i2;
        ListIterator listIterator;
        JSONObject jSONObject;
        Map.Entry entry;
        try {
            String c2 = c(context, "k_w_o_d_out_dtt");
            String str2 = "";
            if (TextUtils.isEmpty(c2)) {
                boolean e2 = d.q.a.a.c.b.e.e(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION});
                d.q.a.a.c.b.a.b();
                if (!e2) {
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
                    d(context, "k_w_o_d_out_dtt", str2);
                }
            } else {
                boolean e3 = d.q.a.a.c.b.e.e(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION});
                d.q.a.a.c.b.a.b();
                if (e3) {
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
            d.q.a.a.c.b.b.c(th);
            return "KWE_PE";
        }
    }
}
