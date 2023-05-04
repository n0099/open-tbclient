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
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class i {
    public static String a = null;

    /* renamed from: a  reason: collision with other field name */
    public static final Set<String> f601a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f602a = false;
    public static String b = null;
    public static String c = "";
    public static String d;
    public static String e;
    public static final String f = String.valueOf((char) 2);

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f603a = {"--", "a-", "u-", "v-", "o-", "g-"};

    static {
        HashSet hashSet = new HashSet();
        f601a = hashSet;
        hashSet.add("com.xiaomi.xmsf");
        f601a.add("com.xiaomi.finddevice");
        f601a.add("com.miui.securitycenter");
        f602a = true;
    }

    public static double a(double d2) {
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
        float f2 = ((((((i + 102400) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        double d2 = f2;
        return d2 > 0.5d ? (float) Math.ceil(d2) : f2;
    }

    @TargetApi(17)
    public static int a() {
        Object a2 = bj.a("android.os.UserHandle", "myUserId", new Object[0]);
        if (a2 == null) {
            return -1;
        }
        return ((Integer) Integer.class.cast(a2)).intValue();
    }

    public static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m527a() {
        return a(b()) + "GB";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m528a(int i) {
        if (i > 0) {
            String[] strArr = f603a;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        return f603a[0];
    }

    @Deprecated
    public static String a(Context context) {
        return null;
    }

    public static String a(Context context, boolean z) {
        if (d == null) {
            String b2 = b(context);
            String c2 = !j.m637d() ? z ? c(context) : j(context) : "";
            String a2 = a(context);
            int i = 1;
            if (!(Build.VERSION.SDK_INT < 26) && b(c2) && b(a2)) {
                String b3 = az.a(context).b();
                if (TextUtils.isEmpty(b3)) {
                    String mo186a = az.a(context).mo186a();
                    if (TextUtils.isEmpty(mo186a) || mo186a.startsWith("00000000-0000-0000-0000-000000000000")) {
                        i = 5;
                    } else {
                        i = 4;
                        b2 = mo186a;
                    }
                } else {
                    b2 = b3 + b2;
                    i = 2;
                }
            } else {
                b2 = c2 + b2 + a2;
            }
            com.xiaomi.channel.commonutils.logger.b.b("devid rule select:" + i);
            if (i == 3) {
                d = b2;
            } else {
                d = m528a(i) + bo.b(b2);
            }
        }
        return d;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m529a(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = (PackageInfo) bj.a((Object) context.getPackageManager(), "getPackageInfoAsUser", str, 0, 999);
        if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
            int i = applicationInfo.flags;
            if ((i & 2097152) != 2097152 || (i & 8388608) == 8388608) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = f603a;
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
        BufferedReader bufferedReader;
        Throwable th;
        String[] split;
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

    /* renamed from: b  reason: collision with other method in class */
    public static String m530b() {
        double a2 = a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d);
        return a2 + "GB";
    }

    public static String b(Context context) {
        if (b == null && f602a) {
            boolean m532c = m532c(context);
            f602a = m532c;
            if (m532c) {
                try {
                    b = ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.m101a("failure to get androidId: " + th);
                }
                return b;
            }
            return null;
        }
        return b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m531b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    public static boolean b(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        return trim.length() == 0 || trim.equalsIgnoreCase(StringUtil.NULL_STRING) || trim.equalsIgnoreCase("unknown");
    }

    public static String c() {
        return b() + "KB";
    }

    @Deprecated
    public static String c(Context context) {
        return null;
    }

    /* renamed from: c  reason: collision with other method in class */
    public static boolean m532c(Context context) {
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

    public static String d() {
        long a2 = a(Environment.getDataDirectory());
        return (a2 / 1024) + "KB";
    }

    @Deprecated
    public static String d(Context context) {
        return null;
    }

    @Deprecated
    public static String e(Context context) {
        return null;
    }

    @Deprecated
    public static String f(Context context) {
        return "";
    }

    public static synchronized String g(Context context) {
        synchronized (i.class) {
            if (e != null) {
                return e;
            }
            String b2 = b(context);
            String a2 = a(context);
            String b3 = bo.b(b2 + a2);
            e = b3;
            return b3;
        }
    }

    public static synchronized String h(Context context) {
        String b2;
        synchronized (i.class) {
            String b3 = b(context);
            b2 = bo.b(b3 + ((String) null));
        }
        return b2;
    }

    public static String i(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    @Deprecated
    public static String j(Context context) {
        return "";
    }
}
