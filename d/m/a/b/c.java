package d.m.a.b;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f70369a;

    /* loaded from: classes7.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<? extends T> f70370a;

        /* renamed from: b  reason: collision with root package name */
        public final T f70371b;
    }

    static {
        HashMap hashMap = new HashMap();
        f70369a = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        f70369a.put(Byte.class, Byte.TYPE);
        f70369a.put(Character.class, Character.TYPE);
        f70369a.put(Short.class, Short.TYPE);
        f70369a.put(Integer.class, Integer.TYPE);
        f70369a.put(Float.class, Float.TYPE);
        f70369a.put(Long.class, Long.TYPE);
        f70369a.put(Double.class, Double.TYPE);
        Map<Class<?>, Class<?>> map = f70369a;
        Class<?> cls = Boolean.TYPE;
        map.put(cls, cls);
        Map<Class<?>, Class<?>> map2 = f70369a;
        Class<?> cls2 = Byte.TYPE;
        map2.put(cls2, cls2);
        Map<Class<?>, Class<?>> map3 = f70369a;
        Class<?> cls3 = Character.TYPE;
        map3.put(cls3, cls3);
        Map<Class<?>, Class<?>> map4 = f70369a;
        Class<?> cls4 = Short.TYPE;
        map4.put(cls4, cls4);
        Map<Class<?>, Class<?>> map5 = f70369a;
        Class<?> cls5 = Integer.TYPE;
        map5.put(cls5, cls5);
        Map<Class<?>, Class<?>> map6 = f70369a;
        Class<?> cls6 = Float.TYPE;
        map6.put(cls6, cls6);
        Map<Class<?>, Class<?>> map7 = f70369a;
        Class<?> cls7 = Long.TYPE;
        map7.put(cls7, cls7);
        Map<Class<?>, Class<?>> map8 = f70369a;
        Class<?> cls8 = Double.TYPE;
        map8.put(cls8, cls8);
    }

    public static Method a(Class<?> cls, String str, Class... clsArr) {
        Method b2 = b(cls.getDeclaredMethods(), str, clsArr);
        if (b2 != null) {
            b2.setAccessible(true);
            return b2;
        } else if (cls.getSuperclass() != null) {
            return a(cls.getSuperclass(), str, clsArr);
        } else {
            throw new NoSuchMethodException();
        }
    }

    public static Method b(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str != null) {
            for (Method method : methodArr) {
                if (method.getName().equals(str) && e(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        }
        throw new NullPointerException("Method name must not be null.");
    }

    public static void c(Class<?> cls, String str, Object... objArr) {
        a(cls, str, f(objArr)).invoke(null, g(objArr));
    }

    public static void d(String str, String str2, Object... objArr) {
        try {
            c(Class.forName(str), str2, objArr);
        } catch (Exception unused) {
        }
    }

    public static boolean e(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        } else if (clsArr2 == null) {
            return clsArr.length == 0;
        } else if (clsArr.length != clsArr2.length) {
            return false;
        } else {
            for (int i2 = 0; i2 < clsArr.length; i2++) {
                if (!clsArr[i2].isAssignableFrom(clsArr2[i2]) && (!f70369a.containsKey(clsArr[i2]) || !f70369a.get(clsArr[i2]).equals(f70369a.get(clsArr2[i2])))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static Class<?>[] f(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj == null || !(obj instanceof a)) {
                clsArr[i2] = obj == null ? null : obj.getClass();
            } else {
                clsArr[i2] = ((a) obj).f70370a;
            }
        }
        return clsArr;
    }

    public static Object[] g(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj == null || !(obj instanceof a)) {
                objArr2[i2] = obj;
            } else {
                objArr2[i2] = ((a) obj).f70371b;
            }
        }
        return objArr2;
    }
}
