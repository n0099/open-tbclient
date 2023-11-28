package com.kwad.sdk.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class s {
    public static final Map<Class<?>, Class<?>> aNA;

    /* loaded from: classes10.dex */
    public static class a<T> {
        public final Class<? extends T> aNB;
        public final T obj;
    }

    static {
        HashMap hashMap = new HashMap();
        aNA = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        aNA.put(Byte.class, Byte.TYPE);
        aNA.put(Character.class, Character.TYPE);
        aNA.put(Short.class, Short.TYPE);
        aNA.put(Integer.class, Integer.TYPE);
        aNA.put(Float.class, Float.TYPE);
        aNA.put(Long.class, Long.TYPE);
        aNA.put(Double.class, Double.TYPE);
        Map<Class<?>, Class<?>> map = aNA;
        Class<?> cls = Boolean.TYPE;
        map.put(cls, cls);
        Map<Class<?>, Class<?>> map2 = aNA;
        Class<?> cls2 = Byte.TYPE;
        map2.put(cls2, cls2);
        Map<Class<?>, Class<?>> map3 = aNA;
        Class<?> cls3 = Character.TYPE;
        map3.put(cls3, cls3);
        Map<Class<?>, Class<?>> map4 = aNA;
        Class<?> cls4 = Short.TYPE;
        map4.put(cls4, cls4);
        Map<Class<?>, Class<?>> map5 = aNA;
        Class<?> cls5 = Integer.TYPE;
        map5.put(cls5, cls5);
        Map<Class<?>, Class<?>> map6 = aNA;
        Class<?> cls6 = Float.TYPE;
        map6.put(cls6, cls6);
        Map<Class<?>, Class<?>> map7 = aNA;
        Class<?> cls7 = Long.TYPE;
        map7.put(cls7, cls7);
        Map<Class<?>, Class<?>> map8 = aNA;
        Class<?> cls8 = Double.TYPE;
        map8.put(cls8, cls8);
    }

    public static Class<?> a(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return null;
        }
    }

    public static <T> T ao(String str, String str2) {
        try {
            return (T) ap(str, str2);
        } catch (Throwable th) {
            r(th);
            return null;
        }
    }

    public static <T> T ap(String str, String str2) {
        return (T) d(Class.forName(str), str2);
    }

    public static <T> T b(Class<?> cls, Object... objArr) {
        return (T) cls.getConstructor(d(objArr)).newInstance(e(objArr));
    }

    public static <T> T c(Class<?> cls, String str) {
        try {
            return (T) d(cls, str);
        } catch (Throwable th) {
            r(th);
            return null;
        }
    }

    public static <T> T d(Class<?> cls, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return (T) declaredField.get(null);
    }

    public static <T> T f(Object obj, String str) {
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

    public static <T> T g(String str, Object... objArr) {
        try {
            return (T) h(str, objArr);
        } catch (Throwable th) {
            r(th);
            return null;
        }
    }

    public static <T> T getField(Object obj, String str) {
        try {
            return (T) f(obj, str);
        } catch (Throwable th) {
            r(th);
            return null;
        }
    }

    public static <T> T h(String str, Object... objArr) {
        return (T) b(Class.forName(str), e(objArr));
    }

    public static <T> T a(Class<?> cls, Object... objArr) {
        try {
            return (T) b(cls, objArr);
        } catch (Throwable th) {
            r(th);
            return null;
        }
    }

    public static boolean b(Class<?>[] clsArr, Class<?>[] clsArr2) {
        return a(clsArr, clsArr2, true);
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        try {
            return (T) b(Class.forName(str), str2, objArr);
        } catch (Throwable th) {
            r(th);
            return null;
        }
    }

    public static <T> T b(Class<?> cls, String str, Object... objArr) {
        return (T) c(cls, str, d(objArr)).invoke(null, e(objArr));
    }

    public static Method c(Class<?> cls, String str, Class<?>... clsArr) {
        while (true) {
            Method a2 = a(cls.getDeclaredMethods(), str, clsArr);
            if (a2 == null) {
                if (cls.getSuperclass() != null) {
                    cls = cls.getSuperclass();
                } else {
                    throw new NoSuchMethodException();
                }
            } else {
                a2.setAccessible(true);
                return a2;
            }
        }
    }

    public static <T> T callMethod(Object obj, String str, Object... objArr) {
        try {
            return (T) g(obj, str, objArr);
        } catch (Throwable th) {
            r(th);
            return null;
        }
    }

    public static <T> T callStaticMethod(Class<?> cls, String str, Object... objArr) {
        try {
            return (T) b(cls, str, objArr);
        } catch (Throwable th) {
            r(th);
            return null;
        }
    }

    public static Method e(Class<?> cls, String str, Class<?>... clsArr) {
        while (true) {
            Method b = b(cls.getDeclaredMethods(), str, clsArr);
            if (b == null) {
                if (cls.getSuperclass() != null) {
                    cls = cls.getSuperclass();
                } else {
                    throw new NoSuchMethodException();
                }
            } else {
                b.setAccessible(true);
                return b;
            }
        }
    }

    public static <T> T f(Object obj, String str, Object... objArr) {
        try {
            return (T) h(obj, str, objArr);
        } catch (Throwable th) {
            r(th);
            return null;
        }
    }

    public static <T> T g(Object obj, String str, Object... objArr) {
        return (T) c(obj.getClass(), str, d(objArr)).invoke(obj, e(objArr));
    }

    public static <T> T h(Object obj, String str, Object... objArr) {
        return (T) e(obj.getClass(), str, d(objArr)).invoke(obj, e(objArr));
    }

    public static void setStaticField(Class<?> cls, String str, Object obj) {
        try {
            a(cls, str, obj);
        } catch (Throwable th) {
            r(th);
        }
    }

    public static Object a(Field field, Object obj) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            return field.get(obj);
        } catch (Throwable th) {
            r(th);
            return null;
        }
    }

    public static Method a(Method[] methodArr, String str, Class<?>[] clsArr) {
        ap.fZ(str);
        for (Method method : methodArr) {
            if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr, false)) {
                return method;
            }
        }
        return null;
    }

    public static Method b(Method[] methodArr, String str, Class<?>[] clsArr) {
        ap.fZ(str);
        for (Method method : methodArr) {
            if (method.getName().equals(str) && b(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    public static void a(Class<?> cls, String str, Object obj) {
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
        field.set(null, obj);
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

    public static void a(Object obj, String str, Object obj2) {
        try {
            b(obj, str, obj2);
        } catch (Throwable th) {
            r(th);
        }
    }

    public static void a(Field field, Object obj, Object obj2) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        if (clsArr == null) {
            if (clsArr2 == null || clsArr2.length == 0) {
                return true;
            }
            return false;
        } else if (clsArr2 == null) {
            if (clsArr.length == 0) {
                return true;
            }
            return false;
        } else if (clsArr.length != clsArr2.length) {
            return false;
        } else {
            for (int i = 0; i < clsArr.length; i++) {
                if ((!z || (clsArr[i] != null && clsArr2[i] != null)) && !clsArr[i].isAssignableFrom(clsArr2[i]) && (!aNA.containsKey(clsArr[i]) || !aNA.get(clsArr[i]).equals(aNA.get(clsArr2[i])))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean classExists(String str) {
        try {
            if (Class.forName(str) == null) {
                return false;
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return false;
        }
    }

    public static Class<?>[] d(Object... objArr) {
        Class<?> cls;
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null && (obj instanceof a)) {
                cls = ((a) obj).aNB;
            } else if (obj == null) {
                cls = null;
            } else {
                cls = obj.getClass();
            }
            clsArr[i] = cls;
        }
        return clsArr;
    }

    public static Object[] e(Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            Object[] objArr2 = new Object[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                if (obj != null && (obj instanceof a)) {
                    objArr2[i] = ((a) obj).obj;
                } else {
                    objArr2[i] = obj;
                }
            }
            return objArr2;
        }
        return null;
    }

    public static <T> T fO(String str) {
        try {
            return (T) j(Class.forName(str));
        } catch (Throwable th) {
            r(th);
            return null;
        }
    }

    public static <T> T i(Class<?> cls) {
        try {
            return (T) j(cls);
        } catch (Throwable th) {
            r(th);
            return null;
        }
    }

    public static void r(Throwable th) {
        if (!com.kwad.library.a.a.mc.booleanValue()) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw new RuntimeException(th);
        }
    }

    public static <T> T j(Class<?> cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors != null && declaredConstructors.length != 0) {
            Constructor<?> constructor = declaredConstructors[0];
            constructor.setAccessible(true);
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes != null && parameterTypes.length != 0) {
                Object[] objArr = new Object[parameterTypes.length];
                for (int i = 0; i < parameterTypes.length; i++) {
                    objArr[i] = k(parameterTypes[i]);
                }
                return (T) constructor.newInstance(objArr);
            }
            return (T) constructor.newInstance(new Object[0]);
        }
        throw new IllegalArgumentException("Can't get even one available constructor for " + cls);
    }

    public static Object k(Class<?> cls) {
        if (!Integer.TYPE.equals(cls) && !Integer.class.equals(cls) && !Byte.TYPE.equals(cls) && !Byte.class.equals(cls) && !Short.TYPE.equals(cls) && !Short.class.equals(cls) && !Long.TYPE.equals(cls) && !Long.class.equals(cls) && !Double.TYPE.equals(cls) && !Double.class.equals(cls) && !Float.TYPE.equals(cls) && !Float.class.equals(cls)) {
            if (!Boolean.TYPE.equals(cls) && !Boolean.class.equals(cls)) {
                if (!Character.TYPE.equals(cls) && !Character.class.equals(cls)) {
                    return null;
                }
                return (char) 0;
            }
            return Boolean.FALSE;
        }
        return 0;
    }
}
