package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
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
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = null;

    /* renamed from: a  reason: collision with other field name */
    public static final Set<String> f798a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f799a = false;

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f800a;
    public static String b = null;
    public static String c = "";
    public static String d;
    public static String e;
    public static final String f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1664386452, "Lcom/xiaomi/push/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1664386452, "Lcom/xiaomi/push/j;");
                return;
            }
        }
        f = String.valueOf((char) 2);
        f800a = new String[]{"--", "a-", "u-", "v-", "o-", "g-"};
        HashSet hashSet = new HashSet();
        f798a = hashSet;
        hashSet.add("com.xiaomi.xmsf");
        f798a.add("com.xiaomi.finddevice");
        f798a.add("com.miui.securitycenter");
        f799a = true;
    }

    public static double a(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2)})) != null) {
            return invokeCommon.doubleValue;
        }
        int i = 1;
        while (true) {
            double d3 = i;
            if (d3 >= d2) {
                return d3;
            }
            i <<= 1;
        }
    }

    public static float a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            float f2 = ((((((i + 102400) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
            double d2 = f2;
            return d2 > 0.5d ? (float) Math.ceil(d2) : f2;
        }
        return invokeI.floatValue;
    }

    @TargetApi(17)
    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Object a2 = bk.a("android.os.UserHandle", "myUserId", new Object[0]);
            if (a2 == null) {
                return -1;
            }
            return ((Integer) Integer.class.cast(a2)).intValue();
        }
        return invokeV.intValue;
    }

    public static long a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            StatFs statFs = new StatFs(file.getPath());
            return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
        }
        return invokeL.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m534a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return a(b()) + "GB";
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m535a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            if (i > 0) {
                String[] strArr = f800a;
                if (i < strArr.length) {
                    return strArr[i];
                }
            }
            return f800a[0];
        }
        return (String) invokeI.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                return k.a(context).a();
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m89a("failure to get gaid:" + e2.getMessage());
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65544, null, context, z)) == null) {
            if (d == null) {
                String c2 = c(context);
                String d2 = !m.m566d() ? z ? d(context) : l(context) : "";
                String b2 = b(context);
                int i = 1;
                if (!(Build.VERSION.SDK_INT < 26) && b(d2) && b(b2)) {
                    String b3 = ba.a(context).b();
                    if (TextUtils.isEmpty(b3)) {
                        String a2 = ba.a(context).a();
                        if (TextUtils.isEmpty(a2) || a2.startsWith("00000000-0000-0000-0000-000000000000")) {
                            i = 5;
                        } else {
                            i = 4;
                            c2 = a2;
                        }
                    } else {
                        c2 = b3 + c2;
                        i = 2;
                    }
                } else {
                    c2 = d2 + c2 + b2;
                }
                com.xiaomi.channel.commonutils.logger.b.b("devid rule select:" + i);
                if (i == 3) {
                    d = c2;
                } else {
                    d = m535a(i) + bp.b(c2);
                }
            }
            return d;
        }
        return (String) invokeLZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m536a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra("status", -1);
                return intExtra == 2 || intExtra == 5;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            PackageInfo packageInfo = (PackageInfo) bk.a((Object) context.getPackageManager(), "getPackageInfoAsUser", str, 0, 999);
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                int i = applicationInfo.flags;
                if ((i & 2097152) != 2097152 || (i & 8388608) == 8388608) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65547, null, str)) != null) {
            return invokeL.booleanValue;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = f800a;
            if (i >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    public static int b() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
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
    public static String m537b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            double a2 = a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d);
            return a2 + "GB";
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m538b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return powerManager == null || powerManager.isScreenOn();
        }
        return invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? Build.VERSION.SDK_INT < 29 ? 10 : 0 : invokeV.intValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public static String m539c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return b() + "KB";
        }
        return (String) invokeV.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            if (b == null && f799a) {
                boolean m541d = m541d(context);
                f799a = m541d;
                if (m541d) {
                    try {
                        b = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
                    } catch (Throwable th) {
                        com.xiaomi.channel.commonutils.logger.b.m89a("failure to get androidId: " + th);
                    }
                    return b;
                }
                return null;
            }
            return b;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public static boolean m540c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            String packageName = context.getPackageName();
            if (m.m560a() && f798a.contains(packageName)) {
                return context.getPackageManager().checkPermission(com.kuaishou.weapon.p0.h.c, packageName) == 0 || context.getPackageManager().checkPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", packageName) == 0;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) ? !TextUtils.isEmpty(str) && str.length() <= 15 && str.length() >= 14 && bp.m206b(str) && !bp.c(str) : invokeL.booleanValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            long a2 = a(Environment.getDataDirectory());
            return (a2 / 1024) + "KB";
        }
        return (String) invokeV.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            int c2 = c();
            String e2 = e(context);
            while (e2 == null) {
                int i = c2 - 1;
                if (c2 <= 0) {
                    break;
                }
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused) {
                }
                e2 = e(context);
                c2 = i;
            }
            return e2;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public static boolean m541d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
                return true;
            }
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName(context.getPackageName(), "com.xiaomi.push.service.XMPushService");
            intent.setComponent(componentName);
            try {
                Bundle bundle = context.getPackageManager().getServiceInfo(componentName, 128).metaData;
                if (bundle != null) {
                    String string = bundle.getString("supportGetAndroidID");
                    if (TextUtils.isEmpty(string)) {
                        return true;
                    }
                    return Boolean.parseBoolean(string);
                }
            } catch (Exception unused) {
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        String str;
        Object obj;
        Object a2;
        Object a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            if (m.m566d()) {
                return "";
            }
            String str2 = a;
            if (str2 != null) {
                return str2;
            }
            try {
                if (m540c(context)) {
                    str = (!m.m560a() || (a2 = bk.a("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null || (a3 = bk.a(a2, "getMiuiDeviceId", new Object[0])) == null || !(a3 instanceof String)) ? null : (String) String.class.cast(a3);
                    if (str == null) {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (Build.VERSION.SDK_INT < 26) {
                            str = telephonyManager.getDeviceId();
                        } else {
                            if (1 == telephonyManager.getPhoneType()) {
                                obj = bk.a((Object) telephonyManager, "getImei", (Object[]) null);
                            } else if (2 == telephonyManager.getPhoneType()) {
                                obj = bk.a((Object) telephonyManager, "getMeid", (Object[]) null);
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
                com.xiaomi.channel.commonutils.logger.b.m89a("failure to get id:" + th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            int c2 = c();
            String h = h(context);
            while (h == null) {
                int i = c2 - 1;
                if (c2 <= 0) {
                    break;
                }
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused) {
                }
                h = h(context);
                c2 = i;
            }
            return h;
        }
        return (String) invokeL.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Object a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            if (!m.m566d() && Build.VERSION.SDK_INT >= 22) {
                if (TextUtils.isEmpty(c)) {
                    e(context);
                    if (TextUtils.isEmpty(a)) {
                        return "";
                    }
                    try {
                        if (m540c(context)) {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            Integer num = (Integer) bk.a((Object) telephonyManager, "getPhoneCount", new Object[0]);
                            if (num != null && num.intValue() > 1) {
                                String str = null;
                                for (int i = 0; i < num.intValue(); i++) {
                                    if (Build.VERSION.SDK_INT < 26) {
                                        a2 = bk.a((Object) telephonyManager, "getDeviceId", Integer.valueOf(i));
                                    } else if (1 == telephonyManager.getPhoneType()) {
                                        a2 = bk.a((Object) telephonyManager, "getImei", Integer.valueOf(i));
                                    } else {
                                        if (2 == telephonyManager.getPhoneType()) {
                                            a2 = bk.a((Object) telephonyManager, "getMeid", Integer.valueOf(i));
                                        }
                                        if (!TextUtils.isEmpty(str) && !TextUtils.equals(a, str) && c(str)) {
                                            c += str + ",";
                                        }
                                    }
                                    str = (String) a2;
                                    if (!TextUtils.isEmpty(str)) {
                                        c += str + ",";
                                    }
                                }
                                int length = c.length();
                                if (length > 0) {
                                    c = c.substring(0, length - 1);
                                }
                                return c;
                            }
                        }
                        return "";
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.m89a("failure to get ids: " + e2);
                        return "";
                    }
                }
                return c;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            g(context);
            String str = "";
            if (TextUtils.isEmpty(c)) {
                return "";
            }
            for (String str2 : c.split(",")) {
                if (c(str2)) {
                    str = str + bp.a(str2) + ",";
                }
            }
            int length = str.length();
            return length > 0 ? str.substring(0, length - 1) : str;
        }
        return (String) invokeL.objValue;
    }

    public static synchronized String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            synchronized (j.class) {
                if (e != null) {
                    return e;
                }
                String c2 = c(context);
                String b2 = b(context);
                String b3 = bp.b(c2 + b2);
                e = b3;
                return b3;
            }
        }
        return (String) invokeL.objValue;
    }

    public static synchronized String j(Context context) {
        InterceptResult invokeL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            synchronized (j.class) {
                String c2 = c(context);
                b2 = bp.b(c2 + ((String) null));
            }
            return b2;
        }
        return (String) invokeL.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) ? ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName() : (String) invokeL.objValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            int c2 = c();
            String e2 = e(context);
            while (TextUtils.isEmpty(e2)) {
                int i = c2 - 1;
                if (c2 <= 0) {
                    break;
                }
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused) {
                }
                e2 = e(context);
                c2 = i;
            }
            return e2;
        }
        return (String) invokeL.objValue;
    }
}
