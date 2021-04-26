package d.a.x.i;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
public class h {
    public static Field a(Class<?> cls, String str) {
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                h(declaredField, true);
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = null;
        for (Class<?> cls3 : cls.getInterfaces()) {
            try {
                Field field2 = cls3.getField(str);
                k.a(field == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                field = field2;
            } catch (NoSuchFieldException unused2) {
            }
        }
        return field;
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Method declaredMethod = cls2.getDeclaredMethod(str, clsArr);
                h(declaredMethod, true);
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        Method method = null;
        for (Class<?> cls3 : cls.getInterfaces()) {
            try {
                Method method2 = cls3.getMethod(str, clsArr);
                k.a(method == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                method = method2;
            } catch (NoSuchMethodException unused2) {
            }
        }
        return method;
    }

    public static Object c(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method b2 = b(obj.getClass(), str, clsArr);
        b2.setAccessible(true);
        return b2.invoke(obj, objArr);
    }

    public static Object d(Class<?> cls, Object obj, String str) throws IllegalAccessException, NoSuchFieldException {
        return f(a(cls, str), obj);
    }

    public static Object e(Object obj, String str) throws IllegalAccessException, NoSuchFieldException {
        return d(obj.getClass(), obj, str);
    }

    public static Object f(Field field, Object obj) throws IllegalAccessException {
        return field.get(obj);
    }

    public static void g(Field field) {
        k.a(field != null, "The field must not be null", new Object[0]);
        try {
            if (Modifier.isFinal(field.getModifiers())) {
                Field declaredField = Field.class.getDeclaredField("modifiers");
                boolean z = !declaredField.isAccessible();
                if (z) {
                    declaredField.setAccessible(true);
                }
                declaredField.setInt(field, field.getModifiers() & (-17));
                if (z) {
                    declaredField.setAccessible(false);
                }
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
    }

    public static void h(AccessibleObject accessibleObject, boolean z) {
        if (accessibleObject.isAccessible() != z) {
            accessibleObject.setAccessible(z);
        }
    }

    public static void i(Class<?> cls, Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        k(a(cls, str), obj, obj2);
    }

    public static void j(Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        i(obj.getClass(), obj, str, obj2);
    }

    public static void k(Field field, Object obj, Object obj2) throws IllegalAccessException {
        field.set(obj, obj2);
    }
}
