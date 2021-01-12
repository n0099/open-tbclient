package com.pgl.sys.ces.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.ArrayMap;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {
    public static String a(Context context) {
        String str = "";
        try {
            str = context.getPackageName();
        } catch (Throwable th) {
        }
        return str == null ? "" : str.trim();
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable th) {
            return 0;
        }
    }

    public static String c() {
        String str = null;
        try {
            str = Environment.getExternalStorageDirectory().getAbsolutePath();
        } catch (Throwable th) {
        }
        return str == null ? "" : str.trim();
    }

    public static String c(Context context) {
        String str = "";
        try {
            str = context.getFilesDir().getAbsolutePath();
        } catch (Throwable th) {
        }
        return str == null ? "" : str.trim();
    }

    public static String d() {
        String str = null;
        try {
            str = Environment.getDataDirectory().getPath();
        } catch (Throwable th) {
        }
        return str == null ? "" : str.trim();
    }

    public static String d(Context context) {
        String str = "";
        try {
            str = context.getApplicationInfo().sourceDir;
        } catch (Throwable th) {
        }
        return str == null ? "" : str.trim();
    }

    @SuppressLint({"PrivateApi"})
    public static Activity eBk() {
        Map map;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            if (invoke != null || Build.VERSION.SDK_INT <= 17) {
            }
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            map = Build.VERSION.SDK_INT < 19 ? (HashMap) declaredField.get(invoke) : (ArrayMap) declaredField.get(invoke);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (map.size() < 1) {
            return null;
        }
        for (Object obj : map.values()) {
            Class<?> cls2 = obj.getClass();
            Field declaredField2 = cls2.getDeclaredField("paused");
            declaredField2.setAccessible(true);
            if (!declaredField2.getBoolean(obj)) {
                Field declaredField3 = cls2.getDeclaredField(PushConstants.INTENT_ACTIVITY_NAME);
                declaredField3.setAccessible(true);
                return (Activity) declaredField3.get(obj);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    public static Application eBl() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Throwable th) {
            return null;
        }
    }
}
