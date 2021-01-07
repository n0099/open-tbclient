package com.pgl.a.b;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f11684a = new HashMap();

    /* loaded from: classes4.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<? extends T> f11685a;

        /* renamed from: b  reason: collision with root package name */
        public final T f11686b;
    }

    static {
        f11684a.put(Boolean.class, Boolean.TYPE);
        f11684a.put(Byte.class, Byte.TYPE);
        f11684a.put(Character.class, Character.TYPE);
        f11684a.put(Short.class, Short.TYPE);
        f11684a.put(Integer.class, Integer.TYPE);
        f11684a.put(Float.class, Float.TYPE);
        f11684a.put(Long.class, Long.TYPE);
        f11684a.put(Double.class, Double.TYPE);
        f11684a.put(Boolean.TYPE, Boolean.TYPE);
        f11684a.put(Byte.TYPE, Byte.TYPE);
        f11684a.put(Character.TYPE, Character.TYPE);
        f11684a.put(Short.TYPE, Short.TYPE);
        f11684a.put(Integer.TYPE, Integer.TYPE);
        f11684a.put(Float.TYPE, Float.TYPE);
        f11684a.put(Long.TYPE, Long.TYPE);
        f11684a.put(Double.TYPE, Double.TYPE);
    }

    private static Method a(Class<?> cls, String str, Class... clsArr) {
        Method a2 = a(cls.getDeclaredMethods(), str, clsArr);
        if (a2 != null) {
            a2.setAccessible(true);
            return a2;
        } else if (cls.getSuperclass() != null) {
            return a(cls.getSuperclass(), str, clsArr);
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

    public static void a(String str, String str2, Object... objArr) {
        try {
            e(Class.forName(str), str2, objArr);
        } catch (Exception e) {
        }
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
                if (!clsArr[i].isAssignableFrom(clsArr2[i]) && (!f11684a.containsKey(clsArr[i]) || !f11684a.get(clsArr[i]).equals(f11684a.get(clsArr2[i])))) {
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
                clsArr[i2] = ((a) obj).f11685a;
            }
            i = i2 + 1;
        }
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
                objArr2[i2] = ((a) obj).f11686b;
            }
            i = i2 + 1;
        }
    }

    public static void e(Class<?> cls, String str, Object... objArr) {
        a(cls, str, a(objArr)).invoke(null, b(objArr));
    }
}
