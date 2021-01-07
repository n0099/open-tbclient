package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class an {
    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            GDTLogger.d(e.toString());
            return null;
        }
    }

    public static Object a(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Object a(Object obj, Method method, boolean z, Object... objArr) {
        if (obj == null || method == null) {
            return null;
        }
        if (!z) {
            try {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return method.invoke(obj, objArr);
    }

    public static Object a(Object obj, Method method, Object... objArr) {
        return a(obj, method, true, objArr);
    }

    public static Field a(Class cls, String str) {
        return a(cls, str, true);
    }

    public static Field a(Class cls, String str, boolean z) {
        Field field = null;
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                field = z ? cls.getField(str) : cls.getDeclaredField(str);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return field;
    }

    public static Method a(Class cls, String str, boolean z, Class... clsArr) {
        Method method = null;
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                method = z ? cls.getMethod(str, clsArr) : cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return method;
    }

    public static Method a(Class cls, String str, Class... clsArr) {
        return a(cls, str, true, clsArr);
    }

    public static boolean a(Field field, Object obj, Object obj2) {
        return a(field, obj, true, obj2);
    }

    public static boolean a(Field field, Object obj, boolean z, Object obj2) {
        if (field == null || obj == null) {
            return false;
        }
        if (!z) {
            try {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return false;
            }
        }
        field.set(obj, obj2);
        return true;
    }
}
