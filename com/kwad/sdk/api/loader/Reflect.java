package com.kwad.sdk.api.loader;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class Reflect {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f8482a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f8483b;

    /* loaded from: classes5.dex */
    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = -6213149635297151442L;

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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final Method f8484a;

        /* renamed from: b  reason: collision with root package name */
        private static final Method f8485b;
        private static final Method c;
        private static final Method d;
        private static final Method e;
        private static final Method f;
        private static final Method g;
        private static final Method h;
        private static final Method i;
        private static final Method j;
        private static final Method k;
        private static final Method l;
        private static final Method m;
        private static final Method n;

        static {
            try {
                f8484a = Class.class.getDeclaredMethod("forName", String.class);
                f8485b = Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
                c = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                d = Class.class.getDeclaredMethod("getDeclaredFields", new Class[0]);
                e = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                f = Class.class.getDeclaredMethod("getDeclaredMethods", new Class[0]);
                g = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                h = Class.class.getDeclaredMethod("getDeclaredConstructors", new Class[0]);
                i = Class.class.getDeclaredMethod("getField", String.class);
                j = Class.class.getDeclaredMethod("getFields", new Class[0]);
                k = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                l = Class.class.getDeclaredMethod("getMethods", new Class[0]);
                m = Class.class.getDeclaredMethod("getConstructor", Class[].class);
                n = Class.class.getDeclaredMethod("getConstructors", new Class[0]);
            } catch (NoSuchMethodException e2) {
                throw new ReflectException(e2);
            }
        }

        static Class a(String str) {
            try {
                return (Class) f8484a.invoke(null, str);
            } catch (Exception e2) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e2);
                throw classNotFoundException;
            }
        }

        static Constructor a(Class cls, Class<?>... clsArr) {
            try {
                return (Constructor) g.invoke(cls, clsArr);
            } catch (Exception e2) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e2);
                throw noSuchMethodException;
            }
        }

        static Field a(Class cls, String str) {
            try {
                return (Field) c.invoke(cls, str);
            } catch (Exception e2) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e2);
                throw noSuchFieldException;
            }
        }

        static Method a(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) e.invoke(cls, str, clsArr);
            } catch (Exception e2) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e2);
                throw noSuchMethodException;
            }
        }

        static Method[] a(Class cls) {
            try {
                return (Method[]) f.invoke(cls, new Object[0]);
            } catch (Exception e2) {
                throw new ReflectException(e2);
            }
        }

        static Field b(Class cls, String str) {
            try {
                return (Field) i.invoke(cls, str);
            } catch (Exception e2) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e2);
                throw noSuchFieldException;
            }
        }

        static Method b(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) k.invoke(cls, str, clsArr);
            } catch (Exception e2) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e2);
                throw noSuchMethodException;
            }
        }

        static Method[] b(Class cls) {
            try {
                return (Method[]) l.invoke(cls, new Object[0]);
            } catch (Exception e2) {
                throw new ReflectException(e2);
            }
        }

        static Constructor[] c(Class cls) {
            try {
                return (Constructor[]) h.invoke(cls, new Object[0]);
            } catch (Exception e2) {
                throw new ReflectException(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {
        private b() {
        }
    }

    private Reflect(Class<?> cls) {
        this(cls, cls);
    }

    private Reflect(Class<?> cls, Object obj) {
        this.f8482a = cls;
        this.f8483b = obj;
    }

    public static Reflect a(Class<?> cls) {
        return new Reflect(cls);
    }

    private static Reflect a(Class<?> cls, Object obj) {
        return new Reflect(cls, obj);
    }

    public static Reflect a(Object obj) {
        return new Reflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    public static Reflect a(String str) {
        return a(f(str));
    }

    private static Reflect a(Constructor<?> constructor, Object... objArr) {
        try {
            return a(constructor.getDeclaringClass(), ((Constructor) a(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static Reflect a(Method method, Object obj, Object... objArr) {
        try {
            a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return a(obj);
            }
            return a(method.invoke(obj, objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

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
        if (t.isAccessible()) {
            return t;
        }
        t.setAccessible(true);
        return t;
    }

    private Method a(String str, Class<?>[] clsArr) {
        Class<?> c = c();
        try {
            return a.b(c, str, clsArr);
        } catch (NoSuchMethodException e) {
            do {
                try {
                    return a.a(c, str, clsArr);
                } catch (NoSuchMethodException e2) {
                    c = c.getSuperclass();
                    if (c == null) {
                        throw new NoSuchMethodException();
                    }
                }
            } while (c == null);
            throw new NoSuchMethodException();
        }
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length == clsArr2.length) {
            for (int i = 0; i < clsArr2.length; i++) {
                if (clsArr2[i] != b.class && !b(clsArr[i]).isAssignableFrom(b(clsArr2[i]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static Class<?> b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    private static Object b(Object obj) {
        return obj instanceof Reflect ? ((Reflect) obj).a() : obj;
    }

    private Method b(String str, Class<?>[] clsArr) {
        Method[] b2;
        Method[] a2;
        Class<?> c = c();
        for (Method method : a.b(c)) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : a.a(c)) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            c = c.getSuperclass();
        } while (c != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + c() + ".");
    }

    private static Class<?>[] b(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? b.class : obj.getClass();
        }
        return clsArr;
    }

    private Field e(String str) {
        Class<?> c = c();
        try {
            return (Field) a(a.b(c, str));
        } catch (NoSuchFieldException e) {
            while (true) {
                try {
                    return (Field) a(a.a(c, str));
                } catch (NoSuchFieldException e2) {
                    Class<? super Object> superclass = c.getSuperclass();
                    if (superclass == null) {
                        throw new ReflectException(e);
                    }
                    c = superclass;
                }
            }
        }
    }

    private static Class<?> f(String str) {
        try {
            return a.a(str);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public Reflect a(String str, Object obj) {
        try {
            Field e = e(str);
            if ((e.getModifiers() & 16) == 16) {
                try {
                    Field a2 = a.a(Field.class, "modifiers");
                    a2.setAccessible(true);
                    a2.setInt(e, e.getModifiers() & (-17));
                } catch (NoSuchFieldException e2) {
                }
            }
            e.set(this.f8483b, b(obj));
            return this;
        } catch (Exception e3) {
            throw new ReflectException(e3);
        }
    }

    public Reflect a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return a(a(str, clsArr), this.f8483b, objArr);
        } catch (NoSuchMethodException e) {
            try {
                return a(b(str, clsArr), this.f8483b, objArr);
            } catch (NoSuchMethodException e2) {
                throw new ReflectException(e2);
            }
        }
    }

    public Reflect a(String str, Object... objArr) {
        return a(str, b(objArr), objArr);
    }

    public Reflect a(Class<?>[] clsArr, Object... objArr) {
        Constructor[] c;
        try {
            return a(a.a(c(), clsArr), objArr);
        } catch (NoSuchMethodException e) {
            for (Constructor constructor : a.c(c())) {
                if (a(constructor.getParameterTypes(), clsArr)) {
                    return a(constructor, objArr);
                }
            }
            throw new ReflectException(e);
        }
    }

    public Reflect a(Object... objArr) {
        return a(b(objArr), objArr);
    }

    public <T> T a() {
        return (T) this.f8483b;
    }

    public Reflect b() {
        return a(new Object[0]);
    }

    public <T> T b(String str) {
        return (T) c(str).a();
    }

    public Reflect c(String str) {
        try {
            Field e = e(str);
            return a(e.getType(), e.get(this.f8483b));
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    public Class<?> c() {
        return this.f8482a;
    }

    public Reflect d(String str) {
        return a(str, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Reflect) {
            return this.f8483b.equals(((Reflect) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f8483b.hashCode();
    }

    public String toString() {
        return String.valueOf(this.f8483b);
    }
}
