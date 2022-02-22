package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes4.dex */
public class i {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = null;

    /* renamed from: a  reason: collision with other field name */
    public static volatile boolean f621a = false;

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f622a;

    /* renamed from: b  reason: collision with root package name */
    public static String f61484b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f61485c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f61486d;

    /* renamed from: e  reason: collision with root package name */
    public static String f61487e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f61488f;

    /* renamed from: g  reason: collision with root package name */
    public static String f61489g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1664386483, "Lcom/xiaomi/push/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1664386483, "Lcom/xiaomi/push/i;");
                return;
            }
        }
        f61488f = String.valueOf((char) 2);
        f622a = new String[]{"--", "a-", "u-", "v-", "o-", "g-"};
        f61489g = null;
        f621a = false;
    }

    public static double a(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2)})) != null) {
            return invokeCommon.doubleValue;
        }
        int i2 = 1;
        while (true) {
            double d3 = i2;
            if (d3 >= d2) {
                return d3;
            }
            i2 <<= 1;
        }
    }

    public static float a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            float f2 = ((((((i2 + 102400) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
            double d2 = f2;
            return d2 > 0.5d ? (float) Math.ceil(d2) : f2;
        }
        return invokeI.floatValue;
    }

    @TargetApi(17)
    public static int a() {
        InterceptResult invokeV;
        Object a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (Build.VERSION.SDK_INT >= 17 && (a2 = bh.a("android.os.UserHandle", "myUserId", new Object[0])) != null) {
                return ((Integer) Integer.class.cast(a2)).intValue();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int length = str.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i2 = (i2 * 31) + str.charAt(i3);
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static long a(File file) {
        InterceptResult invokeL;
        long blockCount;
        long blockSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, file)) == null) {
            StatFs statFs = new StatFs(file.getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockCount = statFs.getBlockCountLong();
                blockSize = statFs.getBlockSizeLong();
            } else {
                blockCount = statFs.getBlockCount();
                blockSize = statFs.getBlockSize();
            }
            return blockSize * blockCount;
        }
        return invokeL.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m498a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return a(b()) + "GB";
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m499a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) {
            if (i2 > 0) {
                String[] strArr = f622a;
                if (i2 < strArr.length) {
                    return strArr[i2];
                }
            }
            return f622a[0];
        }
        return (String) invokeI.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                return j.a(context).a();
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m133a("failure to get gaid:" + e2.getMessage());
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65545, null, context, z)) == null) {
            if (f61486d == null) {
                String e2 = e(context);
                String f2 = !l.d() ? z ? f(context) : o(context) : "";
                String d2 = d(context);
                int i2 = 1;
                if (!(Build.VERSION.SDK_INT < 26) && b(f2) && b(d2)) {
                    String a2 = ax.a(context).a();
                    if (TextUtils.isEmpty(a2)) {
                        String n = n(context);
                        if (TextUtils.isEmpty(n)) {
                            String mo212b = ax.a(context).mo212b();
                            if (TextUtils.isEmpty(mo212b)) {
                                i2 = 5;
                            } else {
                                i2 = 4;
                                e2 = mo212b;
                            }
                        } else {
                            e2 = n;
                            i2 = 3;
                        }
                    } else {
                        e2 = a2 + e2;
                        i2 = 2;
                    }
                } else {
                    e2 = f2 + e2 + d2;
                }
                com.xiaomi.channel.commonutils.logger.b.b("devid rule select:" + i2);
                if (i2 == 3) {
                    f61486d = e2;
                } else {
                    f61486d = m499a(i2) + bm.b(e2);
                }
                b(context, f61486d);
            }
            return f61486d;
        }
        return (String) invokeLZ.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, str) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("update vdevid = " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            f61489g = str;
            u uVar = null;
            try {
                try {
                    if (m505c(context)) {
                        File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                        File file2 = new File(file, ".vdevid");
                        uVar = u.a(context, file2);
                        y.m705a(file2);
                        y.a(file2, f61489g);
                    }
                    y.a(new File(context.getFilesDir(), ".vdevid"), f61489g);
                    if (uVar == null) {
                        return;
                    }
                } catch (IOException unused) {
                    com.xiaomi.channel.commonutils.logger.b.m133a("update vdevid failure.");
                    if (uVar == null) {
                        return;
                    }
                }
                uVar.a();
            } catch (Throwable th) {
                if (uVar != null) {
                    uVar.a();
                }
                throw th;
            }
        }
    }

    public static void a(Context context, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, context, map) == null) || map == null || context == null) {
            return;
        }
        String n = n(context);
        if (TextUtils.isEmpty(n)) {
            return;
        }
        map.put("local_virt_devid", n);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m500a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra("status", -1);
                return intExtra == 2 || intExtra == 5;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m501a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65549, null, str)) != null) {
            return invokeL.booleanValue;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i2 = 0;
        while (true) {
            String[] strArr = f622a;
            if (i2 >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i2])) {
                return true;
            }
            i2++;
        }
    }

    public static int b() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (new File(HardwareInfoUtils.MEM_INFO_FILE).exists()) {
                BufferedReader bufferedReader2 = null;
                try {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
                    } catch (IOException unused) {
                    }
                    try {
                        String readLine = bufferedReader.readLine();
                        if (!TextUtils.isEmpty(readLine) && (split = readLine.split("\\s+")) != null && split.length >= 2 && TextUtils.isDigitsOnly(split[1])) {
                            Integer.parseInt(split[1]);
                        }
                        bufferedReader.close();
                    } catch (Exception unused2) {
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        return 0;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused4) {
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m502b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            double a2 = a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d);
            return a2 + "GB";
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            u uVar = null;
            if (m505c(context)) {
                if (TextUtils.isEmpty(f61489g)) {
                    String a2 = y.a(new File(context.getFilesDir(), ".vdevid"));
                    f61489g = a2;
                    try {
                        if (TextUtils.isEmpty(a2)) {
                            try {
                                File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevid");
                                uVar = u.a(context, file);
                                f61489g = "";
                                String a3 = y.a(file);
                                if (a3 != null) {
                                    f61489g = a3;
                                }
                                String str = f61489g;
                                if (uVar != null) {
                                    uVar.a();
                                }
                                return str;
                            } catch (IOException unused) {
                                com.xiaomi.channel.commonutils.logger.b.m133a("getVDevID failure.");
                                if (uVar != null) {
                                    uVar.a();
                                }
                                return f61489g;
                            }
                        }
                        return f61489g;
                    } catch (Throwable th) {
                        if (uVar != null) {
                            uVar.a();
                        }
                        throw th;
                    }
                }
                return f61489g;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, context, str) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("write lvdd = " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            u uVar = null;
            try {
                try {
                    if (m505c(context)) {
                        File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                        File file2 = new File(file, ".vdevidlocal");
                        if (file2.exists() && file2.isFile()) {
                            com.xiaomi.channel.commonutils.logger.b.b("vdr exists, not rewrite.");
                            return;
                        }
                        uVar = u.a(context, file2);
                        y.m705a(file2);
                        y.a(file2, f61486d + f61488f + a(f61486d));
                        com.xiaomi.channel.commonutils.logger.b.b("lvdd write succ.");
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.m133a("not support write lvdd.");
                    }
                    if (uVar == null) {
                        return;
                    }
                } catch (IOException unused) {
                    com.xiaomi.channel.commonutils.logger.b.m133a("write lvdd failure.");
                    if (0 == 0) {
                        return;
                    }
                }
                uVar.a();
            } catch (Throwable th) {
                if (0 != 0) {
                    uVar.a();
                }
                throw th;
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m503b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return powerManager == null || powerManager.isScreenOn();
        }
        return invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            if (str == null) {
                return true;
            }
            String trim = str.trim();
            return trim.length() == 0 || trim.equalsIgnoreCase(StringUtil.NULL_STRING) || trim.equalsIgnoreCase("unknown");
        }
        return invokeL.booleanValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? Build.VERSION.SDK_INT < 29 ? 10 : 0 : invokeV.intValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public static String m504c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            return b() + "KB";
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x0023 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context) {
        InterceptResult invokeL;
        u uVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            u uVar2 = null;
            if (!m505c(context) || f621a) {
                return null;
            }
            f621a = true;
            ?? filesDir = context.getFilesDir();
            String a2 = y.a(new File((File) filesDir, ".vdevid"));
            try {
                try {
                    File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevid");
                    uVar = u.a(context, file);
                    try {
                        str = y.a(file);
                        if (uVar != null) {
                            uVar.a();
                        }
                    } catch (IOException unused) {
                        com.xiaomi.channel.commonutils.logger.b.m133a("check id failure.");
                        if (uVar != null) {
                            uVar.a();
                        }
                        str = null;
                        filesDir = TextUtils.isEmpty(a2);
                        if (filesDir == 0) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    uVar2 = filesDir;
                    if (uVar2 != null) {
                        uVar2.a();
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                uVar = null;
            } catch (Throwable th2) {
                th = th2;
                if (uVar2 != null) {
                }
                throw th;
            }
            filesDir = TextUtils.isEmpty(a2);
            if (filesDir == 0) {
                com.xiaomi.channel.commonutils.logger.b.m133a("empty local vid");
                return "F*";
            }
            f61489g = a2;
            if (TextUtils.isEmpty(str) || str.length() > 128) {
                com.xiaomi.channel.commonutils.logger.b.m133a("recover vid :" + str);
                a(context, a2);
            } else if (!TextUtils.equals(a2, str)) {
                com.xiaomi.channel.commonutils.logger.b.m133a("vid changed, need sync");
                return str;
            }
            com.xiaomi.channel.commonutils.logger.b.c("vdevid = " + f61489g + " " + str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public static boolean m505c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            if ((Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && m.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && !l.m598a()) {
                boolean z = Build.VERSION.SDK_INT >= 26;
                return !z ? t.m703a(context) : z;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) ? !TextUtils.isEmpty(str) && str.length() <= 15 && str.length() >= 14 && bm.m246b(str) && !bm.c(str) : invokeL.booleanValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            long a2 = a(Environment.getDataDirectory());
            return (a2 / 1024) + "KB";
        }
        return (String) invokeV.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            if (m506d(context)) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 <= 8 || i2 >= 26) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        return (String) bh.a("android.os.Build", "getSerial", (Object[]) null);
                    }
                    return null;
                }
                return Build.SERIAL;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public static boolean m506d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            String packageName = context.getPackageName();
            return context.getPackageManager().checkPermission(com.kuaishou.weapon.un.s.f55454c, packageName) == 0 || context.getPackageManager().checkPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", packageName) == 0;
        }
        return invokeL.booleanValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            String str = f61484b;
            if (str != null) {
                return str;
            }
            try {
                f61484b = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m133a("failure to get androidId: " + th);
            }
            return f61484b;
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            int c2 = c();
            String g2 = g(context);
            while (g2 == null) {
                int i2 = c2 - 1;
                if (c2 <= 0) {
                    break;
                }
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused) {
                }
                g2 = g(context);
                c2 = i2;
            }
            return g2;
        }
        return (String) invokeL.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        String str;
        Object obj;
        Object a2;
        Object a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            if (l.d()) {
                return "";
            }
            String str2 = a;
            if (str2 != null) {
                return str2;
            }
            try {
                if (m506d(context)) {
                    str = (!l.m598a() || (a2 = bh.a("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null || (a3 = bh.a(a2, "getMiuiDeviceId", new Object[0])) == null || !(a3 instanceof String)) ? null : (String) String.class.cast(a3);
                    if (str == null) {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (Build.VERSION.SDK_INT < 26) {
                            str = telephonyManager.getDeviceId();
                        } else {
                            if (1 == telephonyManager.getPhoneType()) {
                                obj = bh.a((Object) telephonyManager, "getImei", (Object[]) null);
                            } else if (2 == telephonyManager.getPhoneType()) {
                                obj = bh.a((Object) telephonyManager, "getMeid", (Object[]) null);
                            }
                            str = (String) obj;
                        }
                    }
                } else {
                    str = null;
                }
                if (c(str)) {
                    a = str;
                    return str;
                }
                return "";
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m133a("failure to get id:" + th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            int c2 = c();
            String j2 = j(context);
            while (j2 == null) {
                int i2 = c2 - 1;
                if (c2 <= 0) {
                    break;
                }
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused) {
                }
                j2 = j(context);
                c2 = i2;
            }
            return j2;
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Object a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            if (!l.d() && Build.VERSION.SDK_INT >= 22) {
                if (TextUtils.isEmpty(f61485c)) {
                    g(context);
                    if (TextUtils.isEmpty(a)) {
                        return "";
                    }
                    try {
                        if (m506d(context)) {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            Integer num = (Integer) bh.a((Object) telephonyManager, "getPhoneCount", new Object[0]);
                            if (num != null && num.intValue() > 1) {
                                String str = null;
                                for (int i2 = 0; i2 < num.intValue(); i2++) {
                                    if (Build.VERSION.SDK_INT < 26) {
                                        a2 = bh.a((Object) telephonyManager, "getDeviceId", Integer.valueOf(i2));
                                    } else if (1 == telephonyManager.getPhoneType()) {
                                        a2 = bh.a((Object) telephonyManager, "getImei", Integer.valueOf(i2));
                                    } else {
                                        if (2 == telephonyManager.getPhoneType()) {
                                            a2 = bh.a((Object) telephonyManager, "getMeid", Integer.valueOf(i2));
                                        }
                                        if (!TextUtils.isEmpty(str) && !TextUtils.equals(a, str) && c(str)) {
                                            f61485c += str + ",";
                                        }
                                    }
                                    str = (String) a2;
                                    if (!TextUtils.isEmpty(str)) {
                                        f61485c += str + ",";
                                    }
                                }
                                int length = f61485c.length();
                                if (length > 0) {
                                    f61485c = f61485c.substring(0, length - 1);
                                }
                                return f61485c;
                            }
                        }
                        return "";
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m133a("failure to get ids: " + e2);
                        return "";
                    }
                }
                return f61485c;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            i(context);
            String str = "";
            if (TextUtils.isEmpty(f61485c)) {
                return "";
            }
            for (String str2 : f61485c.split(",")) {
                if (c(str2)) {
                    str = str + bm.a(str2) + ",";
                }
            }
            int length = str.length();
            return length > 0 ? str.substring(0, length - 1) : str;
        }
        return (String) invokeL.objValue;
    }

    public static synchronized String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            synchronized (i.class) {
                if (f61487e != null) {
                    return f61487e;
                }
                String e2 = e(context);
                String d2 = d(context);
                String b2 = bm.b(e2 + d2);
                f61487e = b2;
                return b2;
            }
        }
        return (String) invokeL.objValue;
    }

    public static synchronized String l(Context context) {
        InterceptResult invokeL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            synchronized (i.class) {
                String e2 = e(context);
                b2 = bm.b(e2 + ((String) null));
            }
            return b2;
        }
        return (String) invokeL.objValue;
    }

    public static String m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) ? ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName() : (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0077, code lost:
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0079, code lost:
        r1.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0085, code lost:
        if (r1 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String n(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65573, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        u uVar = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        String str2 = null;
        r1 = null;
        u uVar2 = null;
        if (!m505c(context)) {
            com.xiaomi.channel.commonutils.logger.b.m133a("not support read lvdd.");
            return null;
        }
        try {
            try {
                File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevidlocal");
                if (file.exists() && file.isFile()) {
                    u a2 = u.a(context, file);
                    try {
                        try {
                            String a3 = y.a(file);
                            if (!TextUtils.isEmpty(a3)) {
                                String[] split = a3.split(f61488f);
                                if (split.length == 2) {
                                    String str3 = split[0];
                                    try {
                                        if (a(str3) == Integer.parseInt(split[1])) {
                                            str2 = str3;
                                        }
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                            if (TextUtils.isEmpty(str2)) {
                                y.m705a(file);
                                com.xiaomi.channel.commonutils.logger.b.b("lvdd content invalid, remove it.");
                            }
                            String str4 = str2;
                            uVar2 = a2;
                            str = str4;
                        } catch (Throwable th) {
                            th = th;
                            uVar = a2;
                            if (uVar != null) {
                                uVar.a();
                            }
                            throw th;
                        }
                    } catch (IOException unused2) {
                        String str5 = str2;
                        uVar2 = a2;
                        str = str5;
                        com.xiaomi.channel.commonutils.logger.b.m133a("get lvdd failure.");
                    }
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("lvdf not exists");
                    str = null;
                }
            } catch (IOException unused3) {
                str = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) {
            int c2 = c();
            String g2 = g(context);
            while (TextUtils.isEmpty(g2)) {
                int i2 = c2 - 1;
                if (c2 <= 0) {
                    break;
                }
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused) {
                }
                g2 = g(context);
                c2 = i2;
            }
            return g2;
        }
        return (String) invokeL.objValue;
    }
}
