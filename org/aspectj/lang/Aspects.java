package org.aspectj.lang;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
public class Aspects {
    public static final String ASPECTOF = "aspectOf";
    public static final String HASASPECT = "hasAspect";
    public static final Class[] EMPTY_CLASS_ARRAY = new Class[0];
    public static final Class[] PEROBJECT_CLASS_ARRAY = {Object.class};
    public static final Class[] PERTYPEWITHIN_CLASS_ARRAY = {Class.class};
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

    public static <T> T aspectOf(Class<T> cls) throws NoAspectBoundException {
        try {
            return (T) getSingletonOrThreadAspectOf(cls).invoke(null, EMPTY_OBJECT_ARRAY);
        } catch (InvocationTargetException e) {
            throw new NoAspectBoundException(cls.getName(), e);
        } catch (Exception e2) {
            throw new NoAspectBoundException(cls.getName(), e2);
        }
    }

    public static Method getPerObjectAspectOf(Class<?> cls) throws NoSuchMethodException {
        return checkAspectOf(cls.getDeclaredMethod("aspectOf", PEROBJECT_CLASS_ARRAY), cls);
    }

    public static Method getPerObjectHasAspect(Class cls) throws NoSuchMethodException {
        return checkHasAspect(cls.getDeclaredMethod("hasAspect", PEROBJECT_CLASS_ARRAY), cls);
    }

    public static Method getPerTypeWithinAspectOf(Class<?> cls) throws NoSuchMethodException {
        return checkAspectOf(cls.getDeclaredMethod("aspectOf", PERTYPEWITHIN_CLASS_ARRAY), cls);
    }

    public static Method getPerTypeWithinHasAspect(Class cls) throws NoSuchMethodException {
        return checkHasAspect(cls.getDeclaredMethod("hasAspect", PERTYPEWITHIN_CLASS_ARRAY), cls);
    }

    public static Method getSingletonOrThreadAspectOf(Class<?> cls) throws NoSuchMethodException {
        return checkAspectOf(cls.getDeclaredMethod("aspectOf", EMPTY_CLASS_ARRAY), cls);
    }

    public static Method getSingletonOrThreadHasAspect(Class cls) throws NoSuchMethodException {
        return checkHasAspect(cls.getDeclaredMethod("hasAspect", EMPTY_CLASS_ARRAY), cls);
    }

    public static boolean hasAspect(Class<?> cls) throws NoAspectBoundException {
        try {
            return ((Boolean) getSingletonOrThreadHasAspect(cls).invoke(null, EMPTY_OBJECT_ARRAY)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static <T> T aspectOf(Class<T> cls, Class<?> cls2) throws NoAspectBoundException {
        try {
            return (T) getPerTypeWithinAspectOf(cls).invoke(null, cls2);
        } catch (InvocationTargetException e) {
            throw new NoAspectBoundException(cls.getName(), e);
        } catch (Exception e2) {
            throw new NoAspectBoundException(cls.getName(), e2);
        }
    }

    public static boolean hasAspect(Class<?> cls, Class<?> cls2) throws NoAspectBoundException {
        try {
            return ((Boolean) getPerTypeWithinHasAspect(cls).invoke(null, cls2)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static <T> T aspectOf(Class<T> cls, Object obj) throws NoAspectBoundException {
        try {
            return (T) getPerObjectAspectOf(cls).invoke(null, obj);
        } catch (InvocationTargetException e) {
            throw new NoAspectBoundException(cls.getName(), e);
        } catch (Exception e2) {
            throw new NoAspectBoundException(cls.getName(), e2);
        }
    }

    public static boolean hasAspect(Class<?> cls, Object obj) throws NoAspectBoundException {
        try {
            return ((Boolean) getPerObjectHasAspect(cls).invoke(null, obj)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static Method checkAspectOf(Method method, Class<?> cls) throws NoSuchMethodException {
        method.setAccessible(true);
        if (method.isAccessible() && Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())) {
            return method;
        }
        throw new NoSuchMethodException(cls.getName() + ".aspectOf(..) is not accessible public static");
    }

    public static Method checkHasAspect(Method method, Class cls) throws NoSuchMethodException {
        method.setAccessible(true);
        if (method.isAccessible() && Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())) {
            return method;
        }
        throw new NoSuchMethodException(cls.getName() + ".hasAspect(..) is not accessible public static");
    }
}
