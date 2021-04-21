package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> f29588a;

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    public static void b(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f29588a;
        if (softReference == null || softReference.get() == null || (map = f29588a.get().get(a(str))) == null) {
            return;
        }
        map.clear();
    }

    public static SharedPreferences c(Context context, String str) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(a(str), 0);
    }

    public static Object a(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f29588a;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(a(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    public static String c(Context context, String str, String str2, String str3) {
        SharedPreferences c2 = c(context, str);
        return c2 == null ? str3 : c2.getString(str2, str3);
    }

    public static Object b(Context context, String str, String str2, String str3) {
        String a2 = a(str);
        if (a(context, a2, str2)) {
            if (str3.equalsIgnoreCase("string")) {
                return c(context, a2, str2, null);
            }
            if (str3.equalsIgnoreCase("boolean")) {
                return Boolean.valueOf(a(context, a2, str2, false));
            }
            if (str3.equalsIgnoreCase("int")) {
                return Integer.valueOf(a(context, a2, str2, 0));
            }
            if (str3.equalsIgnoreCase("long")) {
                return Long.valueOf(a(context, a2, str2, 0L));
            }
            if (str3.equalsIgnoreCase("float")) {
                return Float.valueOf(a(context, a2, str2, 0.0f));
            }
            if (str3.equalsIgnoreCase("string_set")) {
                return c(context, a2, str2, null);
            }
            return null;
        }
        return null;
    }

    public static void a(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f29588a;
        if (softReference == null || softReference.get() == null) {
            f29588a = new SoftReference<>(new ConcurrentHashMap());
        }
        String a2 = a(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = f29588a.get();
        if (concurrentHashMap.get(a2) == null) {
            concurrentHashMap.put(a2, new HashMap());
        }
        concurrentHashMap.get(a2).put(str2, obj);
    }

    public static synchronized <T> void a(Context context, String str, String str2, T t) {
        synchronized (b.class) {
            SharedPreferences c2 = c(context, str);
            if (c2 == null) {
                return;
            }
            if (t.equals(a(str, str2))) {
                return;
            }
            SharedPreferences.Editor edit = c2.edit();
            if (t instanceof Boolean) {
                edit.putBoolean(str2, ((Boolean) t).booleanValue());
            }
            if (t instanceof String) {
                edit.putString(str2, (String) t);
            }
            if (t instanceof Integer) {
                edit.putInt(str2, ((Integer) t).intValue());
            }
            if (t instanceof Long) {
                edit.putLong(str2, ((Long) t).longValue());
            }
            if (t instanceof Float) {
                edit.putFloat(str2, ((Float) t).floatValue());
            }
            edit.apply();
            a(str, str2, t);
        }
    }

    public static void b(Context context, String str, String str2) {
        Map<String, Object> map;
        try {
            SharedPreferences c2 = c(context, str);
            if (c2 == null) {
                return;
            }
            SharedPreferences.Editor edit = c2.edit();
            edit.remove(str2);
            edit.apply();
            if (f29588a == null || f29588a.get() == null) {
                return;
            }
            String a2 = a(str);
            if (!TextUtils.isEmpty(a2) && (map = f29588a.get().get(a2)) != null && map.size() != 0) {
                map.remove(str2);
                if (f29588a == null || f29588a.get() == null) {
                    return;
                }
                f29588a.get().put(a2, map);
            }
        } catch (Throwable unused) {
        }
    }

    public static Map<String, ?> b(Context context, String str) {
        return c(context, str).getAll();
    }

    public static String a(Context context, String str, String str2, String str3) {
        Object a2 = a(str, str2);
        if (a2 != null) {
            return a2 + "";
        }
        Object b2 = b(context, str, str2, str3);
        a(str, str2, b2);
        return b2 + "";
    }

    public static int a(Context context, String str, String str2, int i) {
        SharedPreferences c2 = c(context, str);
        return c2 == null ? i : c2.getInt(str2, i);
    }

    public static float a(Context context, String str, String str2, float f2) {
        SharedPreferences c2 = c(context, str);
        return c2 == null ? f2 : c2.getFloat(str2, f2);
    }

    public static boolean a(Context context, String str, String str2, boolean z) {
        SharedPreferences c2 = c(context, str);
        return c2 == null ? z : c2.getBoolean(str2, z);
    }

    public static long a(Context context, String str, String str2, long j) {
        SharedPreferences c2 = c(context, str);
        return c2 == null ? j : c2.getLong(str2, j);
    }

    public static boolean a(Context context, String str, String str2) {
        SharedPreferences c2 = c(context, str);
        return c2 != null && c2.contains(str2);
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor edit = c(context, str).edit();
        edit.clear();
        edit.apply();
        b(str);
    }
}
