package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.android.util.io.ActionJsonData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class g {

    /* loaded from: classes7.dex */
    public enum a {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);
        

        /* renamed from: a  reason: collision with other field name */
        public final int f419a;

        a(int i) {
            this.f419a = i;
        }

        public int a() {
            return this.f419a;
        }
    }

    public static int a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static ApplicationInfo m317a(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.b.m51a("not found app info " + str);
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Drawable m318a(Context context, String str) {
        ApplicationInfo m317a = m317a(context, str);
        Drawable drawable = null;
        if (m317a != null) {
            try {
                drawable = m317a.loadIcon(context.getPackageManager());
                if (drawable == null && Build.VERSION.SDK_INT >= 9) {
                    drawable = m317a.loadLogo(context.getPackageManager());
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m51a("get app icon drawable failed, " + e2);
            }
        }
        return drawable != null ? drawable : new ColorDrawable(0);
    }

    public static a a(Context context, ApplicationInfo applicationInfo) {
        int i = Build.VERSION.SDK_INT;
        if (applicationInfo == null || i < 24) {
            return a.UNKNOWN;
        }
        Boolean bool = null;
        try {
            if (applicationInfo.packageName.equals(context.getPackageName())) {
                bool = Boolean.valueOf(((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).areNotificationsEnabled());
            } else {
                Object a2 = i >= 29 ? bh.a(context.getSystemService(ActionJsonData.TAG_NOTIFICATION), "getService", new Object[0]) : context.getSystemService("security");
                if (a2 != null) {
                    bool = (Boolean) bh.b(a2, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid));
                }
            }
            if (bool != null) {
                return bool.booleanValue() ? a.ALLOWED : a.NOT_ALLOWED;
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m51a("are notifications enabled error " + e2);
        }
        return a.UNKNOWN;
    }

    @TargetApi(19)
    public static a a(Context context, String str, boolean z) {
        ApplicationInfo applicationInfo;
        a a2;
        if (context == null || TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 19) {
            return a.UNKNOWN;
        }
        try {
            applicationInfo = str.equals(context.getPackageName()) ? context.getApplicationInfo() : context.getPackageManager().getApplicationInfo(str, 0);
            a2 = a(context, applicationInfo);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m51a("get app op error " + th);
        }
        if (a2 != a.UNKNOWN) {
            return a2;
        }
        Integer num = (Integer) bh.a((Class<? extends Object>) AppOpsManager.class, NotificationManagerCompat.OP_POST_NOTIFICATION);
        if (num == null) {
            return a.UNKNOWN;
        }
        Integer num2 = (Integer) bh.a((Object) ((AppOpsManager) context.getSystemService("appops")), NotificationManagerCompat.CHECK_OP_NO_THROW, num, Integer.valueOf(applicationInfo.uid), str);
        int i = (Integer) bh.a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
        int i2 = (Integer) bh.a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
        com.xiaomi.channel.commonutils.logger.b.b(String.format("get app mode %s|%s|%s", num2, i, i2));
        if (i == null) {
            i = 0;
        }
        if (i2 == null) {
            i2 = 1;
        }
        if (num2 != null) {
            return z ? !num2.equals(i2) ? a.ALLOWED : a.NOT_ALLOWED : num2.equals(i) ? a.ALLOWED : a.NOT_ALLOWED;
        }
        return a.UNKNOWN;
    }

    public static String a(Context context) {
        return a(context, Process.myPid());
    }

    public static String a(Context context, int i) {
        List<ActivityManager.RunningAppProcessInfo> list;
        if (context == null) {
            return null;
        }
        try {
            list = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        } catch (Exception unused) {
            list = null;
        }
        if (list == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            if (runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m319a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m320a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() >= 1) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == Process.myPid() && runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m321a(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static int b(Context context, String str) {
        ApplicationInfo m317a = m317a(context, str);
        if (m317a != null) {
            int i = m317a.icon;
            return (i != 0 || Build.VERSION.SDK_INT < 9) ? i : m317a.logo;
        }
        return 0;
    }

    public static String b(Context context) {
        String str;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                String[] strArr = runningAppProcessInfo.pkgList;
                for (int i = 0; strArr != null && i < strArr.length; i++) {
                    if (!arrayList.contains(strArr[i])) {
                        arrayList.add(strArr[i]);
                        if (arrayList.size() == 1) {
                            str = (String) arrayList.get(0);
                        } else {
                            sb.append("#");
                            str = strArr[i];
                        }
                        sb.append(str.hashCode() % 100000);
                    }
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m322b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) ? str : packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (PackageManager.NameNotFoundException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return str;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m323b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean c(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
