package com.xiaomi.channel.commonutils.android;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.xiaomi.channel.commonutils.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public enum EnumC0477a {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);
        
        private final int d;

        EnumC0477a(int i) {
            this.d = i;
        }

        public int a() {
            return this.d;
        }
    }

    public static String a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context != null && (runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) != null) {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        }
        return null;
    }

    public static String a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    public static String a(String[] strArr) {
        int i;
        boolean z;
        b[] values = b.values();
        byte[] bArr = new byte[(int) Math.ceil(values.length / 8.0d)];
        if (strArr == null) {
            com.xiaomi.channel.commonutils.logger.b.c("AppInfoUtils.: no permissions");
            return "";
        }
        int length = strArr.length;
        int i2 = 0;
        int i3 = -1;
        while (i2 < length) {
            String str = strArr[i2];
            if (TextUtils.isEmpty(str)) {
                i = i3;
            } else if (str.startsWith("android.permission.")) {
                i = 0;
                while (true) {
                    if (i >= values.length) {
                        i = i3;
                        z = false;
                        break;
                    } else if (TextUtils.equals("android.permission." + values[i].name(), str)) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z && i != -1) {
                    int i4 = i / 8;
                    bArr[i4] = (byte) (bArr[i4] | (1 << (7 - (i % 8))));
                }
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        return new String(Base64.encode(bArr, 0));
    }

    public static int b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static String b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                String[] strArr = runningAppProcessInfo.pkgList;
                for (int i = 0; strArr != null && i < strArr.length; i++) {
                    if (!arrayList.contains(strArr[i])) {
                        arrayList.add(strArr[i]);
                        if (arrayList.size() == 1) {
                            sb.append(((String) arrayList.get(0)).hashCode() % 100000);
                        } else {
                            sb.append("#").append(strArr[i].hashCode() % 100000);
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    @TargetApi(19)
    public static EnumC0477a c(Context context, String str) {
        EnumC0477a enumC0477a;
        if (context == null || TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 19) {
            return EnumC0477a.UNKNOWN;
        }
        try {
            Integer num = (Integer) com.xiaomi.channel.commonutils.reflect.a.a((Class<? extends Object>) AppOpsManager.class, "OP_POST_NOTIFICATION");
            if (num == null) {
                enumC0477a = EnumC0477a.UNKNOWN;
            } else {
                Integer num2 = (Integer) com.xiaomi.channel.commonutils.reflect.a.a((AppOpsManager) context.getSystemService("appops"), "checkOpNoThrow", num, Integer.valueOf(context.getPackageManager().getApplicationInfo(str, 0).uid), str);
                enumC0477a = (num2 == null || num2.intValue() != 0) ? EnumC0477a.NOT_ALLOWED : EnumC0477a.ALLOWED;
            }
            return enumC0477a;
        } catch (Throwable th) {
            return EnumC0477a.UNKNOWN;
        }
    }

    public static boolean c(Context context) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid() && runningAppProcessInfo.processName.equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean e(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static String f(Context context, String str) {
        try {
            return a(context.getPackageManager().getPackageInfo(str, 4096).requestedPermissions);
        } catch (PackageManager.NameNotFoundException e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            return "";
        }
    }

    public static boolean g(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
