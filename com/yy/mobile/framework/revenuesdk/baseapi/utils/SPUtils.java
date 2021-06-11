package com.yy.mobile.framework.revenuesdk.baseapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
/* loaded from: classes7.dex */
public class SPUtils {
    public static final String FILE_NAME = "revenuesdk_share_data";

    /* loaded from: classes7.dex */
    public static class SharedPreferencesCompat {
        public static final Method sApplyMethod = findApplyMethod();

        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor, new Object[0]);
                    return;
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
            editor.commit();
        }

        public static Method findApplyMethod() {
            try {
                return SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public static void clear(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(FILE_NAME, 0).edit();
        edit.clear();
        SharedPreferencesCompat.apply(edit);
    }

    public static boolean contains(Context context, String str) {
        if (context == null || str == null) {
            return false;
        }
        return context.getSharedPreferences(FILE_NAME, 0).contains(str);
    }

    public static Object get(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences;
        if (context == null || str == null || obj == null || (sharedPreferences = context.getSharedPreferences(FILE_NAME, 0)) == null) {
            return null;
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    public static Map<String, ?> getAll(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(FILE_NAME, 0).getAll();
    }

    public static void put(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context == null || str == null || obj == null || (sharedPreferences = context.getSharedPreferences(FILE_NAME, 0)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else {
            edit.putString(str, obj.toString());
        }
        SharedPreferencesCompat.apply(edit);
    }

    public static void remove(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(FILE_NAME, 0).edit();
        edit.remove(str);
        SharedPreferencesCompat.apply(edit);
    }
}
