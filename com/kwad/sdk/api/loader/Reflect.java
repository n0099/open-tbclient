package com.kwad.sdk.api.loader;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class Reflect {
    public final Object a;
    public final Class<?> b;

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public static class a {
        public static final Method a;
        public static final Method b;
        public static final Method c;
        public static final Method d;
        public static final Method e;
        public static final Method f;
        public static final Method g;
        public static final Method h;
        public static final Method i;
        public static final Method j;
        public static final Method k;
        public static final Method l;
        public static final Method m;
        public static final Method n;

        static {
            try {
                a = Class.class.getDeclaredMethod("forName", String.class);
                b = Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
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

        public static Class a(String str) {
            try {
                return (Class) a.invoke(null, str);
            } catch (Exception e2) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e2);
                throw classNotFoundException;
            }
        }

        public static Constructor a(Class cls, Class<?>... clsArr) {
            try {
                return (Constructor) g.invoke(cls, clsArr);
            } catch (Exception e2) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e2);
                throw noSuchMethodException;
            }
        }

        public static Field a(Class cls, String str) {
            try {
                return (Field) c.invoke(cls, str);
            } catch (Exception e2) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e2);
                throw noSuchFieldException;
            }
        }

        public static Method a(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) e.invoke(cls, str, clsArr);
            } catch (Exception e2) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e2);
                throw noSuchMethodException;
            }
        }

        public static Method[] a(Class cls) {
            try {
                return (Method[]) f.invoke(cls, new Object[0]);
            } catch (Exception e2) {
                throw new ReflectException(e2);
            }
        }

        public static Field b(Class cls, String str) {
            try {
                return (Field) i.invoke(cls, str);
            } catch (Exception e2) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e2);
                throw noSuchFieldException;
            }
        }

        public static Method b(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) k.invoke(cls, str, clsArr);
            } catch (Exception e2) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e2);
                throw noSuchMethodException;
            }
        }

        public static Method[] b(Class cls) {
            try {
                return (Method[]) l.invoke(cls, new Object[0]);
            } catch (Exception e2) {
                throw new ReflectException(e2);
            }
        }

        public static Constructor[] c(Class cls) {
            try {
                return (Constructor[]) h.invoke(cls, new Object[0]);
            } catch (Exception e2) {
                throw new ReflectException(e2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
    }

    public Reflect(Class<?> cls) {
        this(cls, cls);
    }

    public Reflect(Class<?> cls, Object obj) {
        this.b = cls;
        this.a = obj;
    }

    public static Reflect a(Class<?> cls) {
        return new Reflect(cls);
    }

    public static Reflect a(Class<?> cls, Object obj) {
        return new Reflect(cls, obj);
    }

    public static Reflect a(Object obj) {
        return new Reflect(obj == null ? Object.class : obj.getClass(), obj);
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
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    private Method a(String str, Class<?>[] clsArr) {
        Class<?> cls = this.b;
        try {
            return a.b(cls, str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return a.a(cls, str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    cls = cls.getSuperclass();
                    if (cls != null) {
                        throw new NoSuchMethodException();
                    }
                }
            } while (cls != null);
            throw new NoSuchMethodException();
        }
    }

    public static boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    public static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
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

    public static Class<?> c(String str) {
        try {
            return a.a(str);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Reflect d(String str) {
        try {
            Field e = e(str);
            return a(e.getType(), e.get(this.a));
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    private Field e(String str) {
        Class<?> cls = this.b;
        try {
            return (Field) a(a.b(cls, str));
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) a(a.a(cls, str));
                } catch (NoSuchFieldException unused) {
                    cls = cls.getSuperclass();
                    if (cls != null) {
                        throw new ReflectException(e);
                    }
                }
            } while (cls != null);
            throw new ReflectException(e);
        }
    }

    public final Reflect a(String str, Object obj) {
        try {
            Field e = e(str);
            if ((e.getModifiers() & 16) == 16) {
                try {
                    Field a2 = a.a(Field.class, "modifiers");
                    a2.setAccessible(true);
                    a2.setInt(e, e.getModifiers() & (-17));
                } catch (NoSuchFieldException unused) {
                }
            }
            Object obj2 = this.a;
            if (obj instanceof Reflect) {
                obj = ((Reflect) obj).a;
            }
            e.set(obj2, obj);
            return this;
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    public final Reflect a(String str, Class<?>[] clsArr, Object... objArr) {
        Method method;
        try {
            try {
                return a(a(str, clsArr), this.a, objArr);
            } catch (NoSuchMethodException unused) {
                Class<?> cls = this.b;
                Method[] b2 = a.b(cls);
                int length = b2.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        method = b2[i];
                        if (a(method, str, clsArr)) {
                            break;
                        }
                        i++;
                    } else {
                        loop1: while (true) {
                            Method[] a2 = a.a(cls);
                            int length2 = a2.length;
                            for (int i2 = 0; i2 < length2; i2++) {
                                method = a2[i2];
                                if (a(method, str, clsArr)) {
                                    break loop1;
                                }
                            }
                            cls = cls.getSuperclass();
                            if (cls == null) {
                                throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + this.b + ".");
                            }
                        }
                    }
                }
                return a(method, this.a, objArr);
            }
        } catch (NoSuchMethodException e) {
            throw new ReflectException(e);
        }
    }

    public final Reflect a(Class<?>[] clsArr, Object... objArr) {
        Constructor[] c;
        try {
            return a(a.a(this.b, clsArr), objArr);
        } catch (NoSuchMethodException e) {
            for (Constructor constructor : a.c(this.b)) {
                if (a(constructor.getParameterTypes(), clsArr)) {
                    return a(constructor, objArr);
                }
            }
            throw new ReflectException(e);
        }
    }

    public final <T> T a(String str) {
        return (T) d(str).a;
    }

    public final Reflect b(String str) {
        return a(str, new Class[0], new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Reflect) {
            return this.a.equals(((Reflect) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return String.valueOf(this.a);
    }
}
