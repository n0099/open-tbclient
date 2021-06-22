package d.a.c.h.k;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<Class<?>, Class<?>> f42937a;

    /* loaded from: classes.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<? extends T> f42938a;

        /* renamed from: b  reason: collision with root package name */
        public final T f42939b;
    }

    static {
        HashMap<Class<?>, Class<?>> hashMap = new HashMap<>();
        f42937a = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        f42937a.put(Byte.class, Byte.TYPE);
        f42937a.put(Character.class, Character.TYPE);
        f42937a.put(Short.class, Short.TYPE);
        f42937a.put(Integer.class, Integer.TYPE);
        f42937a.put(Float.class, Float.TYPE);
        f42937a.put(Long.class, Long.TYPE);
        f42937a.put(Double.class, Double.TYPE);
        HashMap<Class<?>, Class<?>> hashMap2 = f42937a;
        Class<?> cls = Boolean.TYPE;
        hashMap2.put(cls, cls);
        HashMap<Class<?>, Class<?>> hashMap3 = f42937a;
        Class<?> cls2 = Byte.TYPE;
        hashMap3.put(cls2, cls2);
        HashMap<Class<?>, Class<?>> hashMap4 = f42937a;
        Class<?> cls3 = Character.TYPE;
        hashMap4.put(cls3, cls3);
        HashMap<Class<?>, Class<?>> hashMap5 = f42937a;
        Class<?> cls4 = Short.TYPE;
        hashMap5.put(cls4, cls4);
        HashMap<Class<?>, Class<?>> hashMap6 = f42937a;
        Class<?> cls5 = Integer.TYPE;
        hashMap6.put(cls5, cls5);
        HashMap<Class<?>, Class<?>> hashMap7 = f42937a;
        Class<?> cls6 = Float.TYPE;
        hashMap7.put(cls6, cls6);
        HashMap<Class<?>, Class<?>> hashMap8 = f42937a;
        Class<?> cls7 = Long.TYPE;
        hashMap8.put(cls7, cls7);
        HashMap<Class<?>, Class<?>> hashMap9 = f42937a;
        Class<?> cls8 = Double.TYPE;
        hashMap9.put(cls8, cls8);
    }

    public static <T> T a(Object obj, String str, Object[] objArr) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return (T) b(obj, str, objArr);
    }

    public static <T> T b(Object obj, String str, Object[] objArr) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return (T) f(obj.getClass(), str, i(objArr)).invoke(obj, j(objArr));
    }

    public static Object c(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj2 == null) {
            return obj;
        }
        if (obj.getClass().isArray() && obj2.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            int length = Array.getLength(obj);
            int length2 = Array.getLength(obj2) + length;
            Object newInstance = Array.newInstance(componentType, length2);
            for (int i2 = 0; i2 < length2; i2++) {
                if (i2 < length) {
                    Array.set(newInstance, i2, Array.get(obj, i2));
                } else {
                    Array.set(newInstance, i2, Array.get(obj2, i2 - length));
                }
            }
            return newInstance;
        } else if ((obj instanceof List) && (obj2 instanceof List)) {
            List list = (List) obj;
            List list2 = (List) obj2;
            ArrayList arrayList = new ArrayList(list.size() + list2.size());
            arrayList.addAll(list);
            arrayList.addAll(list2);
            return arrayList;
        } else {
            return obj;
        }
    }

    public static boolean d(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        int length = clsArr.length;
        if (clsArr2 == null) {
            return length == 0;
        } else if (length != clsArr2.length) {
            return false;
        } else {
            for (int i2 = length - 1; i2 >= 0; i2--) {
                if (clsArr[i2].isAssignableFrom(clsArr2[i2]) || (f42937a.containsKey(clsArr[i2]) && f42937a.get(clsArr[i2]).equals(f42937a.get(clsArr2[i2])))) {
                    return true;
                }
            }
            return false;
        }
    }

    public static Method e(Method[] methodArr, String str, Class<?>[] clsArr) throws NoSuchMethodException {
        if (str != null) {
            for (Method method : methodArr) {
                if (method.getName().equals(str) && d(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            throw new NoSuchMethodException(str);
        }
        throw new NullPointerException("Method name must not be null.");
    }

    public static Method f(Class<?> cls, String str, Class<?>[] clsArr) throws NoSuchMethodException, SecurityException {
        Method e2 = e(cls.getDeclaredMethods(), str, clsArr);
        if (e2 != null) {
            e2.setAccessible(true);
        }
        return e2;
    }

    public static Method g(Object obj, String str, Class<?>[] clsArr) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Object h(Object obj, Class<?> cls, String str) throws NoSuchFieldException, NoSuchFieldError, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Class<?>[] i(Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj != null && (obj instanceof a)) {
                clsArr[i2] = ((a) obj).f42938a;
            } else {
                clsArr[i2] = obj == null ? null : obj.getClass();
            }
        }
        return clsArr;
    }

    public static Object[] j(Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj != null && (obj instanceof a)) {
                objArr2[i2] = ((a) obj).f42939b;
            } else {
                objArr2[i2] = obj;
            }
        }
        return objArr2;
    }

    public static Object k(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Method g2 = g(obj, str, clsArr);
        if (g2 != null) {
            try {
                g2.setAccessible(true);
                return g2.invoke(obj, objArr);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static void l(Object obj, Class<?> cls, String str, Object obj2) throws NoSuchFieldException, NoSuchFieldError, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }
}
