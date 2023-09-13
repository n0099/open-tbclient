package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.vivo.push.PushClientConstants;
import java.util.Map;
/* loaded from: classes10.dex */
public class g {
    public static a a;

    /* loaded from: classes10.dex */
    public interface a {
        Map<String, String> a(Context context, String str);

        /* renamed from: a  reason: collision with other method in class */
        boolean m522a(Context context, String str);

        boolean b(Context context, String str);
    }

    /* loaded from: classes10.dex */
    public enum b {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);
        

        /* renamed from: a  reason: collision with other field name */
        public final int f426a;

        b(int i) {
            this.f426a = i;
        }

        public int a() {
            return this.f426a;
        }
    }

    public static int a(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(PushClientConstants.COM_ANDROID_SYSTEMUI, 128);
                if (applicationInfo == null || applicationInfo.metaData == null) {
                    return 0;
                }
                return applicationInfo.metaData.getInt("SupportForPushVersionCode");
            } catch (PackageManager.NameNotFoundException unused) {
                return 0;
            }
        }
        return 0;
    }

    public static int a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static ApplicationInfo m514a(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.b.m181a("not found app info " + str);
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Drawable m515a(Context context, String str) {
        ApplicationInfo m514a = m514a(context, str);
        Drawable drawable = null;
        if (m514a != null) {
            try {
                drawable = m514a.loadIcon(context.getPackageManager());
                if (drawable == null) {
                    drawable = m514a.loadLogo(context.getPackageManager());
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m181a("get app icon drawable failed, " + e);
            }
        }
        return drawable != null ? drawable : new ColorDrawable(0);
    }

    public static b a(Context context, ApplicationInfo applicationInfo) {
        int i = Build.VERSION.SDK_INT;
        if (applicationInfo == null || i < 24) {
            return b.UNKNOWN;
        }
        Boolean bool = null;
        try {
            if (applicationInfo.packageName.equals(context.getPackageName())) {
                bool = Boolean.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
            } else {
                Object a2 = i >= 29 ? bj.a(context.getSystemService("notification"), "getService", new Object[0]) : context.getSystemService("security");
                if (a2 != null) {
                    bool = (Boolean) bj.b(a2, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid));
                }
            }
            if (bool != null) {
                return bool.booleanValue() ? b.ALLOWED : b.NOT_ALLOWED;
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m181a("are notifications enabled error " + e);
        }
        return b.UNKNOWN;
    }

    @TargetApi(19)
    public static b a(Context context, String str, boolean z) {
        ApplicationInfo applicationInfo;
        b a2;
        if (context == null || TextUtils.isEmpty(str)) {
            return b.UNKNOWN;
        }
        try {
            applicationInfo = str.equals(context.getPackageName()) ? context.getApplicationInfo() : context.getPackageManager().getApplicationInfo(str, 0);
            a2 = a(context, applicationInfo);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m181a("get app op error " + th);
        }
        if (a2 != b.UNKNOWN) {
            return a2;
        }
        Integer num = (Integer) bj.a((Class<? extends Object>) AppOpsManager.class, NotificationManagerCompat.OP_POST_NOTIFICATION);
        if (num == null) {
            return b.UNKNOWN;
        }
        Integer num2 = (Integer) bj.a((Object) ((AppOpsManager) context.getSystemService("appops")), NotificationManagerCompat.CHECK_OP_NO_THROW, num, Integer.valueOf(applicationInfo.uid), str);
        int i = (Integer) bj.a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
        int i2 = (Integer) bj.a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
        com.xiaomi.channel.commonutils.logger.b.b(String.format("get app mode %s|%s|%s", num2, i, i2));
        if (i == null) {
            i = 0;
        }
        if (i2 == null) {
            i2 = 1;
        }
        if (num2 != null) {
            return z ? !num2.equals(i2) ? b.ALLOWED : b.NOT_ALLOWED : num2.equals(i) ? b.ALLOWED : b.NOT_ALLOWED;
        }
        return b.UNKNOWN;
    }

    public static String a() {
        String processName = Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : (String) bj.a("android.app.ActivityThread", "currentProcessName", new Object[0]);
        return !TextUtils.isEmpty(processName) ? processName : "";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m516a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Map<String, String> m517a(Context context, String str) {
        a aVar = a;
        if (aVar == null) {
            return null;
        }
        return aVar.a(context, str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m518a(Context context) {
        String a2 = a();
        if (TextUtils.isEmpty(a2) || context == null) {
            return false;
        }
        return a2.equals(context.getPackageName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m519a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (j.m711a()) {
            a aVar = a;
            return aVar != null && aVar.m522a(context, str);
        }
        return context.getPackageName().equals(str);
    }

    public static int b(Context context, String str) {
        ApplicationInfo m514a = m514a(context, str);
        if (m514a != null) {
            int i = m514a.icon;
            return i == 0 ? m514a.logo : i;
        }
        return 0;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m520b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) ? str : packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return str;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m521b(Context context, String str) {
        a aVar = a;
        return aVar != null && aVar.b(context, str);
    }

    public static boolean c(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean d(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static boolean e(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                return str.equals(ApiReplaceUtil.Overload.getString(context.getContentResolver(), "freeform_package_name"));
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
