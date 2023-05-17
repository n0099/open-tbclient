package com.kwad.sdk.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public final class aj {
    public static Map<String, Integer> anQ;
    public static Set<String> anR;
    public static Method anS;

    static {
        HashSet hashSet = new HashSet();
        anR = hashSet;
        hashSet.add("android.permission.REQUEST_INSTALL_PACKAGES");
        anR.add("android.permission.WRITE_SETTINGS");
        anR.add("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public static int Y(Context context, String str) {
        int Z;
        if (anQ == null) {
            h(ah.cE(context));
        }
        if (!anR.contains(str) || (Z = Z(context, str)) == -2) {
            int aa = aa(context, str);
            return aa != -2 ? aa : context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        return Z;
    }

    public static int Z(Context context, String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -2078357533) {
            if (str.equals("android.permission.WRITE_SETTINGS")) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode != -1561629405) {
            if (hashCode == 1777263169 && str.equals("android.permission.REQUEST_INSTALL_PACKAGES")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("android.permission.SYSTEM_ALERT_WINDOW")) {
                c = 2;
            }
            c = 65535;
        }
        if (c == 0) {
            if (Build.VERSION.SDK_INT >= 26) {
                if (ah.cD(context)) {
                    return 0;
                }
            }
            return -2;
        } else if (c == 1) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.System.canWrite(context)) {
                    return 0;
                }
            }
            return -2;
        } else {
            if (c == 2 && Build.VERSION.SDK_INT >= 23) {
                try {
                    if (Settings.canDrawOverlays(context)) {
                        return 0;
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                }
            }
            return -2;
        }
        return -1;
    }

    public static int aa(Context context, String str) {
        if (anQ == null || str == null) {
            return -2;
        }
        if (Build.VERSION.SDK_INT < 19) {
            return 0;
        }
        if (anQ.containsKey(str)) {
            try {
                Integer num = anQ.get(str);
                if (num == null) {
                    return -2;
                }
                if (anS == null) {
                    Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class);
                    anS = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                return ((Integer) anS.invoke((AppOpsManager) context.getSystemService("appops"), num, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0 ? 0 : -1;
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
                return 0;
            }
        }
        return -2;
    }

    public static boolean cF(Context context) {
        int i;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Throwable unused) {
            i = 0;
        }
        return i == 1;
    }

    public static String dP(String str) {
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

    public static void h(String[] strArr) {
        if (Build.VERSION.SDK_INT < 19 || strArr == null) {
            return;
        }
        anQ = new HashMap();
        for (String str : strArr) {
            try {
                int intValue = ((Integer) q.c((Class<?>) AppOpsManager.class, "OP_" + dP(str))).intValue();
                if (intValue >= 0) {
                    anQ.put(str, Integer.valueOf(intValue));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
