package com.kwad.sdk.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f7148a = new HashMap();

    /* loaded from: classes3.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<? extends T> f7149a;
        public final T b;
    }

    static {
        f7148a.put(Boolean.class, Boolean.TYPE);
        f7148a.put(Byte.class, Byte.TYPE);
        f7148a.put(Character.class, Character.TYPE);
        f7148a.put(Short.class, Short.TYPE);
        f7148a.put(Integer.class, Integer.TYPE);
        f7148a.put(Float.class, Float.TYPE);
        f7148a.put(Long.class, Long.TYPE);
        f7148a.put(Double.class, Double.TYPE);
        f7148a.put(Boolean.TYPE, Boolean.TYPE);
        f7148a.put(Byte.TYPE, Byte.TYPE);
        f7148a.put(Character.TYPE, Character.TYPE);
        f7148a.put(Short.TYPE, Short.TYPE);
        f7148a.put(Integer.TYPE, Integer.TYPE);
        f7148a.put(Float.TYPE, Float.TYPE);
        f7148a.put(Long.TYPE, Long.TYPE);
        f7148a.put(Double.TYPE, Double.TYPE);
    }

    private static <T> T a(Class<?> cls, String str, Object... objArr) {
        return (T) a(cls, str, a(objArr)).invoke(null, b(objArr));
    }

    public static <T> T a(Object obj, String str) {
        try {
            return (T) b(obj, str);
        } catch (Throwable th) {
            throw a(th);
        }
    }

    public static <T> T a(Object obj, String str, Object... objArr) {
        try {
            return (T) b(obj, str, objArr);
        } catch (Throwable th) {
            throw a(th);
        }
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        try {
            return (T) a(Class.forName(str), str2, objArr);
        } catch (Throwable th) {
            throw a(th);
        }
    }

    private static RuntimeException a(Throwable th) {
        return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Method a2 = a(cls.getDeclaredMethods(), str, clsArr);
        if (a2 != null) {
            a2.setAccessible(true);
            return a2;
        } else if (cls.getSuperclass() != null) {
            return a((Class<?>) cls.getSuperclass(), str, clsArr);
        } else {
            throw new NoSuchMethodException();
        }
    }

    private static Method a(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str == null) {
            throw new NullPointerException("Method name must not be null.");
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        } else if (clsArr2 == null) {
            return clsArr.length == 0;
        } else if (clsArr.length != clsArr2.length) {
            return false;
        } else {
            for (int i = 0; i < clsArr.length; i++) {
                if (!clsArr[i].isAssignableFrom(clsArr2[i]) && (!f7148a.containsKey(clsArr[i]) || !f7148a.get(clsArr[i]).equals(f7148a.get(clsArr2[i])))) {
                    return false;
                }
            }
            return true;
        }
    }

    private static Class<?>[] a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return clsArr;
            }
            Object obj = objArr[i2];
            if (obj == null || !(obj instanceof a)) {
                clsArr[i2] = obj == null ? null : obj.getClass();
            } else {
                clsArr[i2] = ((a) obj).f7149a;
            }
            i = i2 + 1;
        }
    }

    private static <T> T b(Object obj, String str) {
        Class<?> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
                continue;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
                continue;
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    private static <T> T b(Object obj, String str, Object... objArr) {
        return (T) a(obj.getClass(), str, a(objArr)).invoke(obj, b(objArr));
    }

    private static Object[] b(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return objArr2;
            }
            Object obj = objArr[i2];
            if (obj == null || !(obj instanceof a)) {
                objArr2[i2] = obj;
            } else {
                objArr2[i2] = ((a) obj).b;
            }
            i = i2 + 1;
        }
    }
}
