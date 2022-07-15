package com.kwad.sdk.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class q {
    public static final Map<Class<?>, Class<?>> a;

    /* loaded from: classes5.dex */
    public static class a<T> {
        public final Class<? extends T> a;
        public final T b;
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        a.put(Byte.class, Byte.TYPE);
        a.put(Character.class, Character.TYPE);
        a.put(Short.class, Short.TYPE);
        a.put(Integer.class, Integer.TYPE);
        a.put(Float.class, Float.TYPE);
        a.put(Long.class, Long.TYPE);
        a.put(Double.class, Double.TYPE);
        Map<Class<?>, Class<?>> map = a;
        Class<?> cls = Boolean.TYPE;
        map.put(cls, cls);
        Map<Class<?>, Class<?>> map2 = a;
        Class<?> cls2 = Byte.TYPE;
        map2.put(cls2, cls2);
        Map<Class<?>, Class<?>> map3 = a;
        Class<?> cls3 = Character.TYPE;
        map3.put(cls3, cls3);
        Map<Class<?>, Class<?>> map4 = a;
        Class<?> cls4 = Short.TYPE;
        map4.put(cls4, cls4);
        Map<Class<?>, Class<?>> map5 = a;
        Class<?> cls5 = Integer.TYPE;
        map5.put(cls5, cls5);
        Map<Class<?>, Class<?>> map6 = a;
        Class<?> cls6 = Float.TYPE;
        map6.put(cls6, cls6);
        Map<Class<?>, Class<?>> map7 = a;
        Class<?> cls7 = Long.TYPE;
        map7.put(cls7, cls7);
        Map<Class<?>, Class<?>> map8 = a;
        Class<?> cls8 = Double.TYPE;
        map8.put(cls8, cls8);
    }

    public static <T> T a(Class<?> cls) {
        try {
            return (T) b(cls);
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public static <T> T a(Class<?> cls, String str) {
        try {
            return (T) b(cls, str);
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public static <T> T a(Class<?> cls, String str, Object... objArr) {
        try {
            return (T) b(cls, str, objArr);
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public static <T> T a(Class<?> cls, Object... objArr) {
        try {
            return (T) b(cls, objArr);
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public static <T> T a(Object obj, String str) {
        try {
            return (T) b(obj, str);
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public static <T> T a(Object obj, String str, Object... objArr) {
        try {
            return (T) b(obj, str, objArr);
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public static <T> T a(String str, String str2) {
        try {
            return (T) b(str, str2);
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        try {
            return (T) b(Class.forName(str), str2, objArr);
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public static <T> T a(String str, Object... objArr) {
        try {
            return (T) b(str, objArr);
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        while (true) {
            Method a2 = a(cls.getDeclaredMethods(), str, clsArr);
            if (a2 != null) {
                a2.setAccessible(true);
                return a2;
            } else if (cls.getSuperclass() == null) {
                throw new NoSuchMethodException();
            } else {
                cls = cls.getSuperclass();
            }
        }
    }

    public static Method a(Method[] methodArr, String str, Class<?>[] clsArr) {
        aj.a(str);
        for (Method method : methodArr) {
            if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    public static void a(Object obj, String str, Object obj2) {
        try {
            b(obj, str, obj2);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void a(Throwable th) {
        if (!com.kwad.a.a.a.booleanValue()) {
            com.kwad.sdk.core.d.b.a(th);
        } else if (!(th instanceof RuntimeException)) {
            throw new RuntimeException(th);
        } else {
            throw ((RuntimeException) th);
        }
    }

    public static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        } else if (clsArr2 == null) {
            return clsArr.length == 0;
        } else if (clsArr.length != clsArr2.length) {
            return false;
        } else {
            for (int i = 0; i < clsArr.length; i++) {
                if (!clsArr[i].isAssignableFrom(clsArr2[i]) && (!a.containsKey(clsArr[i]) || !a.get(clsArr[i]).equals(a.get(clsArr2[i])))) {
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
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = (obj == null || !(obj instanceof a)) ? obj == null ? null : obj.getClass() : ((a) obj).a;
        }
        return clsArr;
    }

    public static <T> T b(Class<?> cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors == null || declaredConstructors.length == 0) {
            throw new IllegalArgumentException("Can't get even one available constructor for " + cls);
        }
        Constructor<?> constructor = declaredConstructors[0];
        constructor.setAccessible(true);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length == 0) {
            return (T) constructor.newInstance(new Object[0]);
        }
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            objArr[i] = c(parameterTypes[i]);
        }
        return (T) constructor.newInstance(objArr);
    }

    public static <T> T b(Class<?> cls, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return (T) declaredField.get(null);
    }

    public static <T> T b(Class<?> cls, String str, Object... objArr) {
        return (T) a(cls, str, a(objArr)).invoke(null, b(objArr));
    }

    public static <T> T b(Class<?> cls, Object... objArr) {
        return (T) cls.getConstructor(a(objArr)).newInstance(b(objArr));
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

    public static <T> T b(String str, String str2) {
        return (T) b(Class.forName(str), str2);
    }

    public static <T> T b(String str, Object... objArr) {
        return (T) b(Class.forName(str), b(objArr));
    }

    public static void b(Object obj, String str, Object obj2) {
        Class<?> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
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
        field.set(obj, obj2);
    }

    public static Object[] b(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null || !(obj instanceof a)) {
                objArr2[i] = obj;
            } else {
                objArr2[i] = ((a) obj).b;
            }
        }
        return objArr2;
    }

    public static Object c(Class<?> cls) {
        if (Integer.TYPE.equals(cls) || Integer.class.equals(cls) || Byte.TYPE.equals(cls) || Byte.class.equals(cls) || Short.TYPE.equals(cls) || Short.class.equals(cls) || Long.TYPE.equals(cls) || Long.class.equals(cls) || Double.TYPE.equals(cls) || Double.class.equals(cls) || Float.TYPE.equals(cls) || Float.class.equals(cls)) {
            return 0;
        }
        return (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) ? Boolean.FALSE : (Character.TYPE.equals(cls) || Character.class.equals(cls)) ? (char) 0 : null;
    }
}
