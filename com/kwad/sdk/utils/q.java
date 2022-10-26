package com.kwad.sdk.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class q {
    public static final Map anz;

    /* loaded from: classes8.dex */
    public final class a {
        public final Class anA;
        public final Object obj;
    }

    static {
        HashMap hashMap = new HashMap();
        anz = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        anz.put(Byte.class, Byte.TYPE);
        anz.put(Character.class, Character.TYPE);
        anz.put(Short.class, Short.TYPE);
        anz.put(Integer.class, Integer.TYPE);
        anz.put(Float.class, Float.TYPE);
        anz.put(Long.class, Long.TYPE);
        anz.put(Double.class, Double.TYPE);
        Map map = anz;
        Class cls = Boolean.TYPE;
        map.put(cls, cls);
        Map map2 = anz;
        Class cls2 = Byte.TYPE;
        map2.put(cls2, cls2);
        Map map3 = anz;
        Class cls3 = Character.TYPE;
        map3.put(cls3, cls3);
        Map map4 = anz;
        Class cls4 = Short.TYPE;
        map4.put(cls4, cls4);
        Map map5 = anz;
        Class cls5 = Integer.TYPE;
        map5.put(cls5, cls5);
        Map map6 = anz;
        Class cls6 = Float.TYPE;
        map6.put(cls6, cls6);
        Map map7 = anz;
        Class cls7 = Long.TYPE;
        map7.put(cls7, cls7);
        Map map8 = anz;
        Class cls8 = Double.TYPE;
        map8.put(cls8, cls8);
    }

    public static Object N(String str, String str2) {
        try {
            return O(str, str2);
        } catch (Throwable th) {
            m(th);
            return null;
        }
    }

    public static Object O(String str, String str2) {
        return d((Class) Class.forName(str), str2);
    }

    public static Object a(Class cls, Object... objArr) {
        try {
            return b(cls, objArr);
        } catch (Throwable th) {
            m(th);
            return null;
        }
    }

    public static Object a(Object obj, String str, Object... objArr) {
        try {
            return b(obj, str, objArr);
        } catch (Throwable th) {
            m(th);
            return null;
        }
    }

    public static Object a(String str, String str2, Object... objArr) {
        try {
            return c(Class.forName(str), str2, objArr);
        } catch (Throwable th) {
            m(th);
            return null;
        }
    }

    public static Method a(Method[] methodArr, String str, Class[] clsArr) {
        am.dQ(str);
        for (Method method : methodArr) {
            if (method.getName().equals(str) && b(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    public static void a(Object obj, String str, Object obj2) {
        try {
            b(obj, str, obj2);
        } catch (Throwable th) {
            m(th);
        }
    }

    public static Class[] a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = (obj == null || !(obj instanceof a)) ? obj == null ? null : obj.getClass() : ((a) obj).anA;
        }
        return clsArr;
    }

    public static Object b(Class cls, String str, Object... objArr) {
        try {
            return c(cls, str, objArr);
        } catch (Throwable th) {
            m(th);
            return null;
        }
    }

    public static Object b(Class cls, Object... objArr) {
        return cls.getConstructor(a(objArr)).newInstance(b(objArr));
    }

    public static Object b(Object obj, String str, Object... objArr) {
        return c((Class) obj.getClass(), str, a(objArr)).invoke(obj, b(objArr));
    }

    public static Object b(String str, Object... objArr) {
        try {
            return c(str, objArr);
        } catch (Throwable th) {
            m(th);
            return null;
        }
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

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.lang.Class */
    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean b(Class[] clsArr, Class[] clsArr2) {
        if (clsArr == 0) {
            return clsArr2 == null || clsArr2.length == 0;
        } else if (clsArr2 == null) {
            return clsArr.length == 0;
        } else if (clsArr.length != clsArr2.length) {
            return false;
        } else {
            for (int i = 0; i < clsArr.length; i++) {
                if (!clsArr[i].isAssignableFrom(clsArr2[i]) && (!anz.containsKey(clsArr[i]) || !((Class) anz.get(clsArr[i])).equals(anz.get(clsArr2[i])))) {
                    return false;
                }
            }
            return true;
        }
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
                objArr2[i] = ((a) obj).obj;
            }
        }
        return objArr2;
    }

    public static Object c(Class cls, String str) {
        try {
            return d(cls, str);
        } catch (Throwable th) {
            m(th);
            return null;
        }
    }

    public static Object c(Class cls, String str, Object... objArr) {
        return c(cls, str, a(objArr)).invoke(null, b(objArr));
    }

    public static Object c(Object obj, String str) {
        try {
            return d(obj, str);
        } catch (Throwable th) {
            m(th);
            return null;
        }
    }

    public static Object c(String str, Object... objArr) {
        return b(Class.forName(str), b(objArr));
    }

    public static Method c(Class cls, String str, Class... clsArr) {
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

    public static Object d(Class cls, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(null);
    }

    public static Object d(Object obj, String str) {
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
        return field.get(obj);
    }

    public static Object g(Class cls) {
        try {
            return h(cls);
        } catch (Throwable th) {
            m(th);
            return null;
        }
    }

    public static Object h(Class cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors == null || declaredConstructors.length == 0) {
            throw new IllegalArgumentException("Can't get even one available constructor for " + cls);
        }
        Constructor<?> constructor = declaredConstructors[0];
        constructor.setAccessible(true);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length == 0) {
            return constructor.newInstance(new Object[0]);
        }
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            objArr[i] = i(parameterTypes[i]);
        }
        return constructor.newInstance(objArr);
    }

    public static Object i(Class cls) {
        if (Integer.TYPE.equals(cls) || Integer.class.equals(cls) || Byte.TYPE.equals(cls) || Byte.class.equals(cls) || Short.TYPE.equals(cls) || Short.class.equals(cls) || Long.TYPE.equals(cls) || Long.class.equals(cls) || Double.TYPE.equals(cls) || Double.class.equals(cls) || Float.TYPE.equals(cls) || Float.class.equals(cls)) {
            return 0;
        }
        return (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) ? Boolean.FALSE : (Character.TYPE.equals(cls) || Character.class.equals(cls)) ? (char) 0 : null;
    }

    public static void m(Throwable th) {
        if (!com.kwad.a.a.aw.booleanValue()) {
            com.kwad.sdk.core.e.b.printStackTrace(th);
        } else if (!(th instanceof RuntimeException)) {
            throw new RuntimeException(th);
        } else {
            throw ((RuntimeException) th);
        }
    }
}
