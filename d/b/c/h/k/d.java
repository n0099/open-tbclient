package d.b.c.h.k;

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
    public static final HashMap<Class<?>, Class<?>> f43051a;

    /* loaded from: classes.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<? extends T> f43052a;

        /* renamed from: b  reason: collision with root package name */
        public final T f43053b;
    }

    static {
        HashMap<Class<?>, Class<?>> hashMap = new HashMap<>();
        f43051a = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        f43051a.put(Byte.class, Byte.TYPE);
        f43051a.put(Character.class, Character.TYPE);
        f43051a.put(Short.class, Short.TYPE);
        f43051a.put(Integer.class, Integer.TYPE);
        f43051a.put(Float.class, Float.TYPE);
        f43051a.put(Long.class, Long.TYPE);
        f43051a.put(Double.class, Double.TYPE);
        HashMap<Class<?>, Class<?>> hashMap2 = f43051a;
        Class<?> cls = Boolean.TYPE;
        hashMap2.put(cls, cls);
        HashMap<Class<?>, Class<?>> hashMap3 = f43051a;
        Class<?> cls2 = Byte.TYPE;
        hashMap3.put(cls2, cls2);
        HashMap<Class<?>, Class<?>> hashMap4 = f43051a;
        Class<?> cls3 = Character.TYPE;
        hashMap4.put(cls3, cls3);
        HashMap<Class<?>, Class<?>> hashMap5 = f43051a;
        Class<?> cls4 = Short.TYPE;
        hashMap5.put(cls4, cls4);
        HashMap<Class<?>, Class<?>> hashMap6 = f43051a;
        Class<?> cls5 = Integer.TYPE;
        hashMap6.put(cls5, cls5);
        HashMap<Class<?>, Class<?>> hashMap7 = f43051a;
        Class<?> cls6 = Float.TYPE;
        hashMap7.put(cls6, cls6);
        HashMap<Class<?>, Class<?>> hashMap8 = f43051a;
        Class<?> cls7 = Long.TYPE;
        hashMap8.put(cls7, cls7);
        HashMap<Class<?>, Class<?>> hashMap9 = f43051a;
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
            for (int i = 0; i < length2; i++) {
                if (i < length) {
                    Array.set(newInstance, i, Array.get(obj, i));
                } else {
                    Array.set(newInstance, i, Array.get(obj2, i - length));
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
            for (int i = length - 1; i >= 0; i--) {
                if (clsArr[i].isAssignableFrom(clsArr2[i]) || (f43051a.containsKey(clsArr[i]) && f43051a.get(clsArr[i]).equals(f43051a.get(clsArr2[i])))) {
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
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null && (obj instanceof a)) {
                clsArr[i] = ((a) obj).f43052a;
            } else {
                clsArr[i] = obj == null ? null : obj.getClass();
            }
        }
        return clsArr;
    }

    public static Object[] j(Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null && (obj instanceof a)) {
                objArr2[i] = ((a) obj).f43053b;
            } else {
                objArr2[i] = obj;
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
