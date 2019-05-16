package com.xiaomi.metoknlp.a;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class a {
    private static String a = "NLPBuild";
    private static boolean b = false;
    private static String c = Build.BRAND;
    private static String d = Build.TYPE;
    private static Class e;
    private static Field f;
    private static Field g;
    private static Field h;
    private static Field i;

    static {
        boolean z = false;
        try {
            e = Class.forName("miui.os.Build");
            f = e.getField("IS_CTA_BUILD");
            g = e.getField("IS_ALPHA_BUILD");
            h = e.getField("IS_DEVELOPMENT_VERSION");
            i = e.getField("IS_STABLE_VERSION");
        } catch (ClassNotFoundException e2) {
            z = true;
        } catch (NoSuchFieldException e3) {
            z = true;
        } catch (Exception e4) {
            z = true;
        }
        if (z) {
            e = null;
            f = null;
            g = null;
            h = null;
            i = null;
        }
    }

    public static boolean a() {
        if (b) {
            Log.d(a, "brand=" + c);
        }
        return c != null && c.equalsIgnoreCase("xiaomi");
    }

    public static String b() {
        return "3rdROM-" + d;
    }

    public static boolean c() {
        if (a() && e != null && g != null) {
            try {
                boolean z = g.getBoolean(e);
                if (b) {
                    Log.d(a, "is alpha version=" + z);
                    return z;
                }
                return z;
            } catch (IllegalAccessException e2) {
            }
        }
        return false;
    }

    public static boolean d() {
        if (a() && e != null && h != null) {
            try {
                boolean z = h.getBoolean(e);
                if (b) {
                    Log.d(a, "is dev version=" + z);
                    return z;
                }
                return z;
            } catch (IllegalAccessException e2) {
            }
        }
        return false;
    }

    public static boolean e() {
        if (a() && e != null && i != null) {
            try {
                boolean z = i.getBoolean(e);
                if (b) {
                    Log.d(a, "is stable version=" + z);
                    return z;
                }
                return z;
            } catch (IllegalAccessException e2) {
            }
        }
        return false;
    }
}
