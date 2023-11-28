package com.kwad.sdk.api.loader;

import androidx.annotation.Nullable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
/* loaded from: classes10.dex */
public final class Reflect {
    public final Class<?> amq;
    public final Object amr;

    /* loaded from: classes10.dex */
    public static class b {
    }

    /* loaded from: classes10.dex */
    public static class ReflectException extends RuntimeException {
        public static final long serialVersionUID = -6213149635297151442L;

        public ReflectException() {
        }

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th) {
            super(str, th);
        }

        public ReflectException(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static final Method amA;
        public static final Method amB;
        public static final Method amC;
        public static final Method amD;
        public static final Method amE;
        public static final Method amF;
        public static final Method ams;
        public static final Method amt;
        public static final Method amu;
        public static final Method amv;
        public static final Method amw;
        public static final Method amx;
        public static final Method amy;
        public static final Method amz;

        static {
            try {
                ams = Class.class.getDeclaredMethod("forName", String.class);
                amt = Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
                amu = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                amv = Class.class.getDeclaredMethod("getDeclaredFields", new Class[0]);
                amw = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                amx = Class.class.getDeclaredMethod("getDeclaredMethods", new Class[0]);
                amy = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                amz = Class.class.getDeclaredMethod("getDeclaredConstructors", new Class[0]);
                amA = Class.class.getDeclaredMethod("getField", String.class);
                amB = Class.class.getDeclaredMethod("getFields", new Class[0]);
                amC = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                amD = Class.class.getDeclaredMethod("getMethods", new Class[0]);
                amE = Class.class.getDeclaredMethod("getConstructor", Class[].class);
                amF = Class.class.getDeclaredMethod("getConstructors", new Class[0]);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        }

        public static Constructor a(Class cls, Class<?>... clsArr) {
            try {
                return (Constructor) amy.invoke(cls, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        public static Field b(Class cls, String str) {
            try {
                return (Field) amA.invoke(cls, str);
            } catch (Exception e) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e);
                throw noSuchFieldException;
            }
        }

        public static Field a(Class cls, String str) {
            try {
                return (Field) amu.invoke(cls, str);
            } catch (Exception e) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e);
                throw noSuchFieldException;
            }
        }

        public static Method c(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) amw.invoke(cls, str, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        public static Method d(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) amC.invoke(cls, str, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        public static Method[] c(Class cls) {
            try {
                return (Method[]) amx.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        public static Method[] d(Class cls) {
            try {
                return (Method[]) amD.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        public static Constructor[] e(Class cls) {
            try {
                return (Constructor[]) amz.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        public static Class forName(String str) {
            try {
                return (Class) ams.invoke(null, str);
            } catch (Exception e) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e);
                throw classNotFoundException;
            }
        }
    }

    public Reflect(Class<?> cls) {
        this(cls, cls);
    }

    public static Reflect a(Class<?> cls) {
        return new Reflect(cls);
    }

    private Reflect b(Object... objArr) {
        return a(c(objArr), objArr);
    }

    public static Reflect bX(String str) {
        return a(forName(str));
    }

    private Reflect bY(String str) {
        try {
            Field bZ = bZ(str);
            return a(bZ.getType(), bZ.get(this.amr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Field bZ(String str) {
        Class<?> type = type();
        try {
            return (Field) a(a.b(type, str));
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) a(a.a(type, str));
                } catch (NoSuchFieldException unused) {
                    type = type.getSuperclass();
                    if (type != null) {
                        throw new ReflectException(e);
                    }
                }
            } while (type != null);
            throw new ReflectException(e);
        }
    }

    public static Class<?>[] c(Object... objArr) {
        Class<?> cls;
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                cls = b.class;
            } else {
                cls = obj.getClass();
            }
            clsArr[i] = cls;
        }
        return clsArr;
    }

    public static Class<?> forName(String str) {
        try {
            return a.forName(str);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public static Reflect h(Object obj) {
        Class<?> cls;
        if (obj == null) {
            cls = Object.class;
        } else {
            cls = obj.getClass();
        }
        return new Reflect(cls, obj);
    }

    public static Object i(Object obj) {
        if (obj instanceof Reflect) {
            return ((Reflect) obj).get();
        }
        return obj;
    }

    public final Reflect ca(String str) {
        return f(str, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Reflect) {
            return this.amr.equals(((Reflect) obj).get());
        }
        return false;
    }

    public final <T> T get(String str) {
        return (T) bY(str).get();
    }

    public Reflect(Class<?> cls, Object obj) {
        this.amq = cls;
        this.amr = obj;
    }

    public static Reflect a(Class<?> cls, Object obj) {
        return new Reflect(cls, obj);
    }

    private Reflect f(String str, Object... objArr) {
        return a(str, c(objArr), objArr);
    }

    public static Reflect a(Constructor<?> constructor, Object... objArr) {
        try {
            return a(constructor.getDeclaringClass(), ((Constructor) a(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public static Reflect a(Method method, Object obj, Object... objArr) {
        try {
            a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return h(obj);
            }
            return h(method.invoke(obj, objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    @Nullable
    public static <T extends AccessibleObject> T a(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    private Method a(String str, Class<?>[] clsArr) {
        Class<?> type = type();
        try {
            return a.d(type, str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return a.c(type, str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    type = type.getSuperclass();
                    if (type == null) {
                        throw new NoSuchMethodException();
                    }
                }
            } while (type == null);
            throw new NoSuchMethodException();
        }
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr)) {
            return true;
        }
        return false;
    }

    public static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != b.class && !b(clsArr[i]).isAssignableFrom(b(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    public static Class<?> b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (cls.isPrimitive()) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            if (Short.TYPE == cls) {
                return Short.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            if (Void.TYPE == cls) {
                return Void.class;
            }
            return cls;
        }
        return cls;
    }

    private Method b(String str, Class<?>[] clsArr) {
        Method[] d;
        Method[] c;
        Class<?> type = type();
        for (Method method : a.d(type)) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : a.c(type)) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            type = type.getSuperclass();
        } while (type != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + ".");
    }

    private Class<?> type() {
        return this.amq;
    }

    public final <T> T get() {
        return (T) this.amr;
    }

    public final int hashCode() {
        return this.amr.hashCode();
    }

    public final String toString() {
        return String.valueOf(this.amr);
    }

    public final Reflect zp() {
        return b(new Object[0]);
    }

    public final Reflect a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            try {
                return a(a(str, clsArr), this.amr, objArr);
            } catch (NoSuchMethodException unused) {
                return a(b(str, clsArr), this.amr, objArr);
            }
        } catch (NoSuchMethodException e) {
            throw new ReflectException(e);
        }
    }

    public final Reflect a(Class<?>[] clsArr, Object... objArr) {
        Constructor[] e;
        try {
            return a(a.a(type(), clsArr), objArr);
        } catch (NoSuchMethodException e2) {
            for (Constructor constructor : a.e(type())) {
                if (a(constructor.getParameterTypes(), clsArr)) {
                    return a(constructor, objArr);
                }
            }
            throw new ReflectException(e2);
        }
    }

    public final Reflect b(String str, Object obj) {
        try {
            Field bZ = bZ(str);
            if ((bZ.getModifiers() & 16) == 16) {
                try {
                    Field a2 = a.a(Field.class, "modifiers");
                    a2.setAccessible(true);
                    a2.setInt(bZ, bZ.getModifiers() & (-17));
                } catch (NoSuchFieldException unused) {
                }
            }
            bZ.set(this.amr, i(obj));
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }
}
