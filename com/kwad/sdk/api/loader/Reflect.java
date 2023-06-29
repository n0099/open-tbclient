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
    public final Class<?> RO;
    public final Object a;

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
        public static final Method RP;
        public static final Method RQ;
        public static final Method RR;
        public static final Method RS;
        public static final Method RT;
        public static final Method RU;
        public static final Method RV;
        public static final Method RW;
        public static final Method RX;
        public static final Method RY;
        public static final Method RZ;
        public static final Method Sa;
        public static final Method Sb;
        public static final Method b;

        static {
            try {
                RP = Class.class.getDeclaredMethod("forName", String.class);
                b = Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
                RQ = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                RR = Class.class.getDeclaredMethod("getDeclaredFields", new Class[0]);
                RS = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                RT = Class.class.getDeclaredMethod("getDeclaredMethods", new Class[0]);
                RU = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                RV = Class.class.getDeclaredMethod("getDeclaredConstructors", new Class[0]);
                RW = Class.class.getDeclaredMethod("getField", String.class);
                RX = Class.class.getDeclaredMethod("getFields", new Class[0]);
                RY = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                RZ = Class.class.getDeclaredMethod("getMethods", new Class[0]);
                Sa = Class.class.getDeclaredMethod("getConstructor", Class[].class);
                Sb = Class.class.getDeclaredMethod("getConstructors", new Class[0]);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        }

        public static Constructor a(Class cls, Class<?>... clsArr) {
            try {
                return (Constructor) RU.invoke(cls, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        public static Field a(Class cls, String str) {
            try {
                return (Field) RQ.invoke(cls, str);
            } catch (Exception e) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e);
                throw noSuchFieldException;
            }
        }

        public static Method a(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) RS.invoke(cls, str, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        public static Field b(Class cls, String str) {
            try {
                return (Field) RW.invoke(cls, str);
            } catch (Exception e) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e);
                throw noSuchFieldException;
            }
        }

        public static Method b(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) RY.invoke(cls, str, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        public static Class bf(String str) {
            try {
                return (Class) RP.invoke(null, str);
            } catch (Exception e) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e);
                throw classNotFoundException;
            }
        }

        public static Method[] c(Class cls) {
            try {
                return (Method[]) RT.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        public static Method[] d(Class cls) {
            try {
                return (Method[]) RZ.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        public static Constructor[] e(Class cls) {
            try {
                return (Constructor[]) RV.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
    }

    public Reflect(Class<?> cls) {
        this(cls, cls);
    }

    public Reflect(Class<?> cls, Object obj) {
        this.RO = cls;
        this.a = obj;
    }

    public static Reflect a(Class<?> cls) {
        return new Reflect(cls);
    }

    public static Reflect a(Class<?> cls, Object obj) {
        return new Reflect(cls, obj);
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
                return b(obj);
            }
            return b(method.invoke(obj, objArr));
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
        Class<?> cls = this.RO;
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

    public static Reflect b(Object obj) {
        return new Reflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    public static Class<?> b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    private Reflect bb(String str) {
        try {
            Field bc = bc(str);
            return a(bc.getType(), bc.get(this.a));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Field bc(String str) {
        Class<?> cls = this.RO;
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

    public static Class<?> be(String str) {
        try {
            return a.bf(str);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public final Reflect a(String str, Object obj) {
        try {
            Field bc = bc(str);
            if ((bc.getModifiers() & 16) == 16) {
                try {
                    Field a2 = a.a(Field.class, "modifiers");
                    a2.setAccessible(true);
                    a2.setInt(bc, bc.getModifiers() & (-17));
                } catch (NoSuchFieldException unused) {
                }
            }
            Object obj2 = this.a;
            if (obj instanceof Reflect) {
                obj = ((Reflect) obj).a;
            }
            bc.set(obj2, obj);
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public final Reflect a(String str, Class<?>[] clsArr, Object... objArr) {
        Method method;
        try {
            try {
                return a(a(str, clsArr), this.a, objArr);
            } catch (NoSuchMethodException unused) {
                Class<?> cls = this.RO;
                Method[] d = a.d(cls);
                int length = d.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        method = d[i];
                        if (a(method, str, clsArr)) {
                            break;
                        }
                        i++;
                    } else {
                        loop1: while (true) {
                            Method[] c = a.c(cls);
                            int length2 = c.length;
                            for (int i2 = 0; i2 < length2; i2++) {
                                method = c[i2];
                                if (a(method, str, clsArr)) {
                                    break loop1;
                                }
                            }
                            cls = cls.getSuperclass();
                            if (cls == null) {
                                throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + this.RO + ".");
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
        Constructor[] e;
        try {
            return a(a.a(this.RO, clsArr), objArr);
        } catch (NoSuchMethodException e2) {
            for (Constructor constructor : a.e(this.RO)) {
                if (a(constructor.getParameterTypes(), clsArr)) {
                    return a(constructor, objArr);
                }
            }
            throw new ReflectException(e2);
        }
    }

    public final <T> T ba(String str) {
        return (T) bb(str).a;
    }

    public final Reflect bd(String str) {
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
