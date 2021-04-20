package d.b.b.a.a.a.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class k {
    public static Class a(Class cls) {
        if (cls == Character.TYPE) {
            return Character.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        throw new IllegalArgumentException(String.format("Don't know the wrapper type for primitive type %s.", cls));
    }

    public static Object b(Class cls, Object[] objArr) {
        return (objArr == null || objArr.length <= 0) ? cls.newInstance() : e(cls, objArr);
    }

    public static String c(byte[] bArr) {
        return new String(new d.b.b.a.a.c.a.a().a(bArr), "UTF-8");
    }

    public static Method d(Class cls, String str, Class[] clsArr) {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public static Object e(Class cls, Object[] objArr) {
        Constructor<?>[] constructors;
        Constructor<?> constructor = null;
        for (Constructor<?> constructor2 : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if (parameterTypes.length >= objArr.length) {
                int i = 0;
                int i2 = 0;
                while (i < objArr.length) {
                    Object obj = objArr[i];
                    while (obj != null && i2 < parameterTypes.length) {
                        Class<?> cls2 = parameterTypes[i2];
                        if (cls2.isPrimitive()) {
                            cls2 = a(cls2);
                        }
                        if (cls2.isInstance(obj)) {
                            break;
                        }
                        i2++;
                    }
                    if (i2 == parameterTypes.length) {
                        break;
                    }
                    i2++;
                    i++;
                }
                if (i != objArr.length) {
                    continue;
                } else if (constructor == null || parameterTypes.length < constructor.getParameterTypes().length) {
                    constructor = constructor2;
                } else if (parameterTypes.length == constructor.getParameterTypes().length) {
                    throw new IllegalArgumentException("Multiple consturctors match parameters");
                }
            }
        }
        if (constructor != null) {
            return constructor.newInstance(objArr);
        }
        return null;
    }
}
