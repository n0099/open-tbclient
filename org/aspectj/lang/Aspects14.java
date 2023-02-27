package org.aspectj.lang;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* loaded from: classes9.dex */
public class Aspects14 {
    public static final String ASPECTOF = "aspectOf";
    public static final Class[] EMPTY_CLASS_ARRAY = new Class[0];
    public static final Object[] EMPTY_OBJECT_ARRAY;
    public static final String HASASPECT = "hasAspect";
    public static final Class[] PEROBJECT_CLASS_ARRAY;
    public static final Class[] PERTYPEWITHIN_CLASS_ARRAY;
    public static /* synthetic */ Class class$java$lang$Class;
    public static /* synthetic */ Class class$java$lang$Object;

    static {
        Class[] clsArr = new Class[1];
        Class cls = class$java$lang$Object;
        if (cls == null) {
            cls = class$("java.lang.Object");
            class$java$lang$Object = cls;
        }
        clsArr[0] = cls;
        PEROBJECT_CLASS_ARRAY = clsArr;
        Class[] clsArr2 = new Class[1];
        Class cls2 = class$java$lang$Class;
        if (cls2 == null) {
            cls2 = class$("java.lang.Class");
            class$java$lang$Class = cls2;
        }
        clsArr2[0] = cls2;
        PERTYPEWITHIN_CLASS_ARRAY = clsArr2;
        EMPTY_OBJECT_ARRAY = new Object[0];
    }

    public static Object aspectOf(Class cls) throws NoAspectBoundException {
        try {
            return getSingletonOrThreadAspectOf(cls).invoke(null, EMPTY_OBJECT_ARRAY);
        } catch (InvocationTargetException e) {
            throw new NoAspectBoundException(cls.getName(), e);
        } catch (Exception e2) {
            throw new NoAspectBoundException(cls.getName(), e2);
        }
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static Method getPerObjectAspectOf(Class cls) throws NoSuchMethodException {
        return checkAspectOf(cls.getDeclaredMethod("aspectOf", PEROBJECT_CLASS_ARRAY), cls);
    }

    public static Method getPerObjectHasAspect(Class cls) throws NoSuchMethodException {
        return checkHasAspect(cls.getDeclaredMethod("hasAspect", PEROBJECT_CLASS_ARRAY), cls);
    }

    public static Method getPerTypeWithinAspectOf(Class cls) throws NoSuchMethodException {
        return checkAspectOf(cls.getDeclaredMethod("aspectOf", PERTYPEWITHIN_CLASS_ARRAY), cls);
    }

    public static Method getPerTypeWithinHasAspect(Class cls) throws NoSuchMethodException {
        return checkHasAspect(cls.getDeclaredMethod("hasAspect", PERTYPEWITHIN_CLASS_ARRAY), cls);
    }

    public static Method getSingletonOrThreadAspectOf(Class cls) throws NoSuchMethodException {
        return checkAspectOf(cls.getDeclaredMethod("aspectOf", EMPTY_CLASS_ARRAY), cls);
    }

    public static Method getSingletonOrThreadHasAspect(Class cls) throws NoSuchMethodException {
        return checkHasAspect(cls.getDeclaredMethod("hasAspect", EMPTY_CLASS_ARRAY), cls);
    }

    public static boolean hasAspect(Class cls) throws NoAspectBoundException {
        try {
            return ((Boolean) getSingletonOrThreadHasAspect(cls).invoke(null, EMPTY_OBJECT_ARRAY)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static Object aspectOf(Class cls, Class cls2) throws NoAspectBoundException {
        try {
            return getPerTypeWithinAspectOf(cls).invoke(null, cls2);
        } catch (InvocationTargetException e) {
            throw new NoAspectBoundException(cls.getName(), e);
        } catch (Exception e2) {
            throw new NoAspectBoundException(cls.getName(), e2);
        }
    }

    public static boolean hasAspect(Class cls, Class cls2) throws NoAspectBoundException {
        try {
            return ((Boolean) getPerTypeWithinHasAspect(cls).invoke(null, cls2)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static Object aspectOf(Class cls, Object obj) throws NoAspectBoundException {
        try {
            return getPerObjectAspectOf(cls).invoke(null, obj);
        } catch (InvocationTargetException e) {
            throw new NoAspectBoundException(cls.getName(), e);
        } catch (Exception e2) {
            throw new NoAspectBoundException(cls.getName(), e2);
        }
    }

    public static boolean hasAspect(Class cls, Object obj) throws NoAspectBoundException {
        try {
            return ((Boolean) getPerObjectHasAspect(cls).invoke(null, obj)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static Method checkAspectOf(Method method, Class cls) throws NoSuchMethodException {
        method.setAccessible(true);
        if (method.isAccessible() && Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())) {
            return method;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cls.getName());
        stringBuffer.append(".aspectOf(..) is not accessible public static");
        throw new NoSuchMethodException(stringBuffer.toString());
    }

    public static Method checkHasAspect(Method method, Class cls) throws NoSuchMethodException {
        method.setAccessible(true);
        if (method.isAccessible() && Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())) {
            return method;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cls.getName());
        stringBuffer.append(".hasAspect(..) is not accessible public static");
        throw new NoSuchMethodException(stringBuffer.toString());
    }
}
