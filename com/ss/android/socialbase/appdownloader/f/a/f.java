package com.ss.android.socialbase.appdownloader.f.a;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public class f {
    public static Object a(String str) {
        Object obj = null;
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                obj = n("android.content.pm.PackageParser", null);
            } else {
                obj = n("android.content.pm.PackageParser", new Object[]{str});
            }
        } catch (Exception e) {
        }
        return obj;
    }

    public static Object a(Object obj, String str, int i) {
        Object obj2 = null;
        try {
            File file = new File(str);
            if (Build.VERSION.SDK_INT >= 21) {
                obj2 = a(obj, "parsePackage", new Object[]{file, Integer.valueOf(i)});
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                displayMetrics.setToDefaults();
                obj2 = a(obj, "parsePackage", new Object[]{file, str, displayMetrics, Integer.valueOf(i)});
            }
        } catch (Exception e) {
        }
        return obj2;
    }

    public static Object n(String str, Object[] objArr) throws Exception {
        Class<?>[] clsArr;
        Class<?> cls = Class.forName(str);
        if (objArr == null) {
            clsArr = null;
        } else {
            clsArr = new Class[objArr.length];
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
        }
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static Object a(Object obj, String str, Object[] objArr) throws Exception {
        Class<?> cls = obj.getClass();
        Class<?>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            } else if (clsArr[i] == Boolean.class) {
                clsArr[i] = Boolean.TYPE;
            }
        }
        return cls.getMethod(str, clsArr).invoke(obj, objArr);
    }

    public static Object a(Object obj, String str) throws Exception {
        return obj.getClass().getField(str).get(obj);
    }

    public static PackageInfo b(Object obj, Object obj2, int i) {
        PackageInfo packageInfo;
        try {
            Class<?> cls = obj.getClass();
            cls.getMethods();
            if (Build.VERSION.SDK_INT >= 17) {
                Class<?> cls2 = Class.forName("android.content.pm.PackageUserState");
                packageInfo = (PackageInfo) cls.getMethod("generatePackageInfo", obj2.getClass(), int[].class, Integer.TYPE, Long.TYPE, Long.TYPE, Set.class, cls2).invoke(null, obj2, null, Integer.valueOf(i), 0L, 0L, null, cls2.getConstructor(new Class[0]).newInstance(new Object[0]));
            } else {
                packageInfo = (PackageInfo) cls.getMethod("generatePackageInfo", obj2.getClass(), int[].class, Integer.TYPE, Long.TYPE, Long.TYPE, Set.class).invoke(null, obj2, null, Integer.valueOf(i), 0L, 0L, null);
            }
            return packageInfo;
        } catch (Exception e) {
            return null;
        }
    }
}
