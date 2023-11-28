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
/* loaded from: classes10.dex */
public final class am {
    public static Map<String, Integer> aNQ;
    public static Set<String> aNR;
    public static Method aNS;

    static {
        HashSet hashSet = new HashSet();
        aNR = hashSet;
        hashSet.add("android.permission.REQUEST_INSTALL_PACKAGES");
        aNR.add("android.permission.WRITE_SETTINGS");
        aNR.add("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public static int aq(Context context, String str) {
        int ar;
        if (aNQ == null) {
            h(aj.cq(context));
        }
        if (aNR.contains(str) && (ar = ar(context, str)) != -2) {
            return ar;
        }
        int as = as(context, str);
        if (as != -2) {
            return as;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return as;
        }
    }

    public static int ar(Context context, String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -2078357533) {
            if (hashCode != -1561629405) {
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
        } else {
            if (str.equals("android.permission.WRITE_SETTINGS")) {
                c = 1;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c == 2 && Build.VERSION.SDK_INT >= 23) {
                    try {
                        if (Settings.canDrawOverlays(context)) {
                            return 0;
                        }
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    }
                }
                return -2;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    if (Settings.System.canWrite(context)) {
                        return 0;
                    }
                } catch (Throwable unused) {
                }
            }
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (aj.cp(context)) {
                return 0;
            }
        }
        return -2;
        return -1;
    }

    public static int as(Context context, String str) {
        if (aNQ == null || str == null) {
            return -2;
        }
        if (Build.VERSION.SDK_INT < 19) {
            return 0;
        }
        if (!aNQ.containsKey(str)) {
            return -2;
        }
        try {
            Integer num = aNQ.get(str);
            if (num == null) {
                return -2;
            }
            if (aNS == null) {
                Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class);
                aNS = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            if (((Integer) aNS.invoke((AppOpsManager) context.getSystemService("appops"), num, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0) {
                return 0;
            }
            return -1;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            return 0;
        }
    }

    public static boolean cr(Context context) {
        int i;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Throwable unused) {
            i = 0;
        }
        if (i != 1) {
            return false;
        }
        return true;
    }

    public static String fY(String str) {
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
        if (Build.VERSION.SDK_INT >= 19 && strArr != null) {
            aNQ = new HashMap();
            for (String str : strArr) {
                try {
                    int intValue = ((Integer) s.c(AppOpsManager.class, "OP_" + fY(str))).intValue();
                    if (intValue >= 0) {
                        aNQ.put(str, Integer.valueOf(intValue));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}
