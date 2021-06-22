package com.kwad.sdk.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f37637a;

    /* loaded from: classes7.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<? extends T> f37638a;

        /* renamed from: b  reason: collision with root package name */
        public final T f37639b;
    }

    static {
        HashMap hashMap = new HashMap();
        f37637a = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        f37637a.put(Byte.class, Byte.TYPE);
        f37637a.put(Character.class, Character.TYPE);
        f37637a.put(Short.class, Short.TYPE);
        f37637a.put(Integer.class, Integer.TYPE);
        f37637a.put(Float.class, Float.TYPE);
        f37637a.put(Long.class, Long.TYPE);
        f37637a.put(Double.class, Double.TYPE);
        Map<Class<?>, Class<?>> map = f37637a;
        Class<?> cls = Boolean.TYPE;
        map.put(cls, cls);
        Map<Class<?>, Class<?>> map2 = f37637a;
        Class<?> cls2 = Byte.TYPE;
        map2.put(cls2, cls2);
        Map<Class<?>, Class<?>> map3 = f37637a;
        Class<?> cls3 = Character.TYPE;
        map3.put(cls3, cls3);
        Map<Class<?>, Class<?>> map4 = f37637a;
        Class<?> cls4 = Short.TYPE;
        map4.put(cls4, cls4);
        Map<Class<?>, Class<?>> map5 = f37637a;
        Class<?> cls5 = Integer.TYPE;
        map5.put(cls5, cls5);
        Map<Class<?>, Class<?>> map6 = f37637a;
        Class<?> cls6 = Float.TYPE;
        map6.put(cls6, cls6);
        Map<Class<?>, Class<?>> map7 = f37637a;
        Class<?> cls7 = Long.TYPE;
        map7.put(cls7, cls7);
        Map<Class<?>, Class<?>> map8 = f37637a;
        Class<?> cls8 = Double.TYPE;
        map8.put(cls8, cls8);
    }

    public static <T> T a(Class<?> cls, String str, Object... objArr) {
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

    public static RuntimeException a(Throwable th) {
        return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
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

    public static Method a(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str != null) {
            for (Method method : methodArr) {
                if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        }
        throw new NullPointerException("Method name must not be null.");
    }

    public static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        } else if (clsArr2 == null) {
            return clsArr.length == 0;
        } else if (clsArr.length != clsArr2.length) {
            return false;
        } else {
            for (int i2 = 0; i2 < clsArr.length; i2++) {
                if (!clsArr[i2].isAssignableFrom(clsArr2[i2]) && (!f37637a.containsKey(clsArr[i2]) || !f37637a.get(clsArr[i2]).equals(f37637a.get(clsArr2[i2])))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static Class<?>[] a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj == null || !(obj instanceof a)) {
                clsArr[i2] = obj == null ? null : obj.getClass();
            } else {
                clsArr[i2] = ((a) obj).f37638a;
            }
        }
        return clsArr;
    }

    public static <T> T b(Object obj, String str) {
        Class<?> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
                continue;
            } catch (NoSuchFieldException unused) {
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

    public static <T> T b(Object obj, String str, Object... objArr) {
        return (T) a(obj.getClass(), str, a(objArr)).invoke(obj, b(objArr));
    }

    public static Object[] b(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj == null || !(obj instanceof a)) {
                objArr2[i2] = obj;
            } else {
                objArr2[i2] = ((a) obj).f37639b;
            }
        }
        return objArr2;
    }
}
