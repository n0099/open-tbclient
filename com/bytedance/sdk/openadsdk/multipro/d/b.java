package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> f7410a;

    private static SharedPreferences c(Context context, String str) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(a(str), 0);
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static Object a(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        if (f7410a == null || (concurrentHashMap = f7410a.get()) == null || (map = concurrentHashMap.get(a(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    private static void a(String str, String str2, Object obj) {
        if (f7410a == null || f7410a.get() == null) {
            f7410a = new SoftReference<>(new ConcurrentHashMap());
        }
        String a2 = a(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = f7410a.get();
        if (concurrentHashMap.get(a2) == null) {
            concurrentHashMap.put(a2, new HashMap());
        }
        concurrentHashMap.get(a2).put(str2, obj);
    }

    private static void b(String str) {
        Map<String, Object> map;
        if (f7410a != null && f7410a.get() != null && (map = f7410a.get().get(a(str))) != null) {
            map.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized <T> void a(Context context, String str, String str2, T t) {
        synchronized (b.class) {
            SharedPreferences c = c(context, str);
            if (c != null && !t.equals(a(str, str2))) {
                SharedPreferences.Editor edit = c.edit();
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
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, String str, String str2, String str3) {
        Object a2 = a(str, str2);
        if (a2 != null) {
            return a2 + "";
        }
        Object b2 = b(context, str, str2, str3);
        a(str, str2, b2);
        return b2 + "";
    }

    private static Object b(Context context, String str, String str2, String str3) {
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

    private static String c(Context context, String str, String str2, String str3) {
        SharedPreferences c = c(context, str);
        return c == null ? str3 : c.getString(str2, str3);
    }

    private static int a(Context context, String str, String str2, int i) {
        SharedPreferences c = c(context, str);
        return c == null ? i : c.getInt(str2, i);
    }

    private static float a(Context context, String str, String str2, float f) {
        SharedPreferences c = c(context, str);
        return c == null ? f : c.getFloat(str2, f);
    }

    private static boolean a(Context context, String str, String str2, boolean z) {
        SharedPreferences c = c(context, str);
        return c == null ? z : c.getBoolean(str2, z);
    }

    private static long a(Context context, String str, String str2, long j) {
        SharedPreferences c = c(context, str);
        return c == null ? j : c.getLong(str2, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, String str, String str2) {
        SharedPreferences c = c(context, str);
        return c != null && c.contains(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, String str, String str2) {
        Map<String, Object> map;
        try {
            SharedPreferences c = c(context, str);
            if (c != null) {
                SharedPreferences.Editor edit = c.edit();
                edit.remove(str2);
                edit.apply();
                if (f7410a != null && f7410a.get() != null) {
                    String a2 = a(str);
                    if (!TextUtils.isEmpty(a2) && (map = f7410a.get().get(a2)) != null && map.size() != 0) {
                        map.remove(str2);
                        if (f7410a != null && f7410a.get() != null) {
                            f7410a.get().put(a2, map);
                        }
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str) {
        SharedPreferences.Editor edit = c(context, str).edit();
        edit.clear();
        edit.apply();
        b(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, ?> b(Context context, String str) {
        return c(context, str).getAll();
    }
}
