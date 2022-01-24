package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.weapon.un.s;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.android.Orange;
import com.yxcorp.kuaishou.addfp.android.b.f;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f61586b = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-28101665, "Lcom/yxcorp/kuaishou/addfp/android/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-28101665, "Lcom/yxcorp/kuaishou/addfp/android/a/d;");
        }
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                return statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Throwable unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (com.yxcorp.kuaishou.addfp.android.b.e.a(context, new String[]{s.f55287c})) {
                    String str = "";
                    if (Build.VERSION.SDK_INT < 29) {
                        try {
                            str = f.a(context).a.b();
                        } catch (Throwable unused) {
                        }
                        if (TextUtils.isEmpty(str) || str.startsWith("KWE")) {
                            str = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
                        }
                        return TextUtils.isEmpty(str) ? "KWE_N" : str;
                    }
                    String[] a2 = com.yxcorp.kuaishou.addfp.android.b.b.a(context);
                    Arrays.sort(a2);
                    for (int i2 = 0; i2 < 2; i2++) {
                        String str2 = a2[i2];
                        if (!TextUtils.isEmpty(str2) && !str2.startsWith("KWE")) {
                            str = str2;
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

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            try {
                return Settings.System.getString(context.getContentResolver(), str);
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2)) == null) {
            try {
                return Settings.System.putString(context.getContentResolver(), str, str2);
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static long b() {
        InterceptResult invokeV;
        Throwable th;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65541, null)) != null) {
            return invokeV.longValue;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
            try {
                long parseLong = Long.parseLong(bufferedReader.readLine().split("\\s+")[1]) << 10;
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return parseLong;
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            return 0L;
                        } catch (IOException unused2) {
                            return 0L;
                        }
                    }
                    return 0L;
                } catch (Throwable th3) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        String str;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            try {
                if (!com.yxcorp.kuaishou.addfp.android.b.e.a(context, new String[]{s.f55287c}) || Build.VERSION.SDK_INT >= 29) {
                    return "";
                }
                try {
                    str = f.a(context).a.a();
                } catch (Throwable unused) {
                    str = "";
                }
                if ((TextUtils.isEmpty(str) || str.startsWith("KWE")) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    String deviceId = telephonyManager.getDeviceId();
                    return TextUtils.isEmpty(deviceId) ? "" : deviceId;
                }
                return str;
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:22:0x0037
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static synchronized java.lang.String c() {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.yxcorp.kuaishou.addfp.android.a.d.$ic
            if (r0 != 0) goto L3a
        L4:
            java.lang.Class<com.yxcorp.kuaishou.addfp.android.a.d> r0 = com.yxcorp.kuaishou.addfp.android.a.d.class
            monitor-enter(r0)
            java.lang.String r1 = com.yxcorp.kuaishou.addfp.android.a.d.a     // Catch: java.lang.Throwable -> L33
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L13
            java.lang.String r1 = com.yxcorp.kuaishou.addfp.android.a.d.a     // Catch: java.lang.Throwable -> L33
            monitor-exit(r0)
            return r1
        L13:
            com.yxcorp.kuaishou.addfp.android.Orange r1 = com.yxcorp.kuaishou.addfp.android.Orange.getInstance()     // Catch: java.lang.Throwable -> L33
            java.lang.String r1 = r1.gMas()     // Catch: java.lang.Throwable -> L33
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = "nammm :"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L33
            r2.append(r1)     // Catch: java.lang.Throwable -> L33
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L33
            if (r2 != 0) goto L2f
            com.yxcorp.kuaishou.addfp.android.a.d.a = r1     // Catch: java.lang.Throwable -> L33
            monitor-exit(r0)
            return r1
        L2f:
            java.lang.String r1 = "KWE_OTHER"
            monitor-exit(r0)
            return r1
        L33:
            java.lang.String r1 = "KWE_PE"
            monitor-exit(r0)
            return r1
        L37:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L3a:
            r1 = r0
            r2 = 65543(0x10007, float:9.1845E-41)
            r3 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r1.invokeV(r2, r3)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.d.c():java.lang.String");
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                return context.getPackageName().replace("=", "").replace("&", "");
            } catch (Throwable th) {
                th.printStackTrace();
                return "KWE_PE";
            }
        }
        return (String) invokeL.objValue;
    }

    public static synchronized String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (d.class) {
                try {
                    if (TextUtils.isEmpty(f61586b)) {
                        String gMas = Orange.getInstance().gMas();
                        new StringBuilder("user dis :").append(gMas);
                        if (!TextUtils.isEmpty(gMas)) {
                            byte[] bytes = gMas.getBytes();
                            for (int i2 = 0; i2 < bytes.length; i2++) {
                                bytes[i2] = (byte) (bytes[i2] ^ 165);
                            }
                            f61586b = "fuels:" + Base64.encodeToString(bytes, 0).replace(StringUtils.LF, "").replace(StringUtils.CR, "");
                        }
                        if (TextUtils.isEmpty(f61586b)) {
                            f61586b = "KWE_N";
                            return "KWE_N";
                        }
                        return f61586b;
                    }
                    return f61586b;
                }
            }
        }
        return (String) invokeV.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
                String eGidLocal = KWEGIDDFP.instance().getEGidLocal(context, b.a.b(), false);
                return !TextUtils.isEmpty(eGidLocal) ? eGidLocal : "KWE_N";
            } catch (Throwable th) {
                th.printStackTrace();
                return "KWE_PE";
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b0 A[Catch: all -> 0x009e, TRY_LEAVE, TryCatch #1 {all -> 0x009e, blocks: (B:37:0x00a8, B:39:0x00b0), top: B:56:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6 A[Catch: all -> 0x00cd, TRY_LEAVE, TryCatch #0 {all -> 0x00cd, blocks: (B:5:0x0008, B:8:0x001a, B:10:0x0027, B:12:0x0035, B:20:0x005b, B:22:0x0061, B:24:0x0067, B:26:0x0071, B:30:0x0081, B:32:0x0087, B:33:0x009e, B:41:0x00c0, B:43:0x00c6, B:28:0x0077, B:14:0x003c, B:16:0x0049, B:18:0x0057), top: B:54:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(Context context) {
        InterceptResult invokeL;
        String str;
        LinkedHashMap a2;
        int i2;
        ListIterator listIterator;
        JSONObject jSONObject;
        Map.Entry entry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            try {
                String a3 = a(context, "k_w_o_d_out_dtt");
                String str2 = "";
                if (TextUtils.isEmpty(a3)) {
                    boolean b2 = com.yxcorp.kuaishou.addfp.android.b.e.b(context, new String[]{s.f55293i, "android.permission.WRITE_EXTERNAL_STORAGE"});
                    com.yxcorp.kuaishou.addfp.android.b.b.a();
                    if (!b2) {
                        str = "KWE_PN";
                        if (TextUtils.isEmpty(a3) || !TextUtils.isEmpty(str2)) {
                            a2 = c.a(context).a(a3);
                            if (a2 != null || a2.size() == 0) {
                                a2 = c.a(context).a(str2);
                            }
                            if (a2 != null && a2.size() > 0) {
                                i2 = 0;
                                listIterator = new ArrayList(a2.entrySet()).listIterator(a2.size());
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
                    str2 = c.a(context).b("Lm91a2R0ZnQ=");
                    if (!TextUtils.isEmpty(str2)) {
                        a(context, "k_w_o_d_out_dtt", str2);
                    }
                } else {
                    boolean b3 = com.yxcorp.kuaishou.addfp.android.b.e.b(context, new String[]{s.f55293i, "android.permission.WRITE_EXTERNAL_STORAGE"});
                    com.yxcorp.kuaishou.addfp.android.b.b.a();
                    if (b3) {
                        str2 = c.a(context).b("Lm91a2R0ZnQ=");
                        if (TextUtils.isEmpty(str2)) {
                            c.a(context, a3);
                        }
                    }
                }
                str = "KWE_N";
                if (TextUtils.isEmpty(a3)) {
                }
                a2 = c.a(context).a(a3);
                if (a2 != null) {
                }
                a2 = c.a(context).a(str2);
                if (a2 != null) {
                    i2 = 0;
                    listIterator = new ArrayList(a2.entrySet()).listIterator(a2.size());
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
                th.printStackTrace();
                return "KWE_PE";
            }
        }
        return (String) invokeL.objValue;
    }
}
