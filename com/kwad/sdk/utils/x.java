package com.kwad.sdk.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Integer> f34089a;

    /* renamed from: b  reason: collision with root package name */
    public static Set<String> f34090b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f34091c;

    static {
        HashSet hashSet = new HashSet();
        f34090b = hashSet;
        hashSet.add("android.permission.REQUEST_INSTALL_PACKAGES");
        f34090b.add("android.permission.WRITE_SETTINGS");
        f34090b.add("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public static int a(Context context, String str) {
        int b2;
        if (f34089a == null) {
            try {
                a(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!f34090b.contains(str) || (b2 = b(context, str)) == -2) {
            int c2 = c(context, str);
            return c2 != -2 ? c2 : context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        return b2;
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return str;
        }
        try {
            return str.substring(lastIndexOf + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    public static void a(String[] strArr) {
        if (Build.VERSION.SDK_INT < 19 || strArr == null) {
            return;
        }
        f34089a = new HashMap();
        for (String str : strArr) {
            try {
                Field declaredField = AppOpsManager.class.getDeclaredField("OP_" + a(str));
                declaredField.setAccessible(true);
                int intValue = ((Integer) declaredField.get(null)).intValue();
                if (intValue >= 0) {
                    f34089a.put(str, Integer.valueOf(intValue));
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004b A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b(Context context, String str) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode == -2078357533) {
            if (str.equals("android.permission.WRITE_SETTINGS")) {
                c2 = 1;
            }
            c2 = 65535;
        } else if (hashCode != -1561629405) {
            if (hashCode == 1777263169 && str.equals("android.permission.REQUEST_INSTALL_PACKAGES")) {
                c2 = 0;
            }
            c2 = 65535;
        } else {
            if (str.equals("android.permission.SYSTEM_ALERT_WINDOW")) {
                c2 = 2;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            if (Build.VERSION.SDK_INT >= 26) {
                if (context.getPackageManager().canRequestPackageInstalls()) {
                    return 0;
                }
            }
            return -2;
        } else if (c2 != 1) {
            if (c2 == 2 && Build.VERSION.SDK_INT >= 23) {
                return Settings.canDrawOverlays(context) ? 0 : -1;
            }
            return -2;
        } else {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.System.canWrite(context)) {
                    return 0;
                }
            }
            return -2;
        }
    }

    public static int c(Context context, String str) {
        if (str == null) {
            return -2;
        }
        if (Build.VERSION.SDK_INT < 19) {
            return 0;
        }
        if (f34089a.containsKey(str)) {
            int intValue = f34089a.get(str).intValue();
            try {
                if (f34091c == null) {
                    Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class);
                    f34091c = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                return ((Integer) f34091c.invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(intValue), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0 ? 0 : -1;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return 0;
            }
        }
        return -2;
    }
}
