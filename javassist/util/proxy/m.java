package javassist.util.proxy;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedActionException;
/* loaded from: classes.dex */
class m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Method[] a(Class cls) {
        return System.getSecurityManager() == null ? cls.getDeclaredMethods() : (Method[]) AccessController.doPrivileged(new n(cls));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Constructor[] b(Class cls) {
        return System.getSecurityManager() == null ? cls.getDeclaredConstructors() : (Constructor[]) AccessController.doPrivileged(new o(cls));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Method a(Class cls, String str, Class[] clsArr) {
        if (System.getSecurityManager() == null) {
            return cls.getDeclaredMethod(str, clsArr);
        }
        try {
            return (Method) AccessController.doPrivileged(new p(cls, str, clsArr));
        } catch (PrivilegedActionException e) {
            if (e.getCause() instanceof NoSuchMethodException) {
                throw ((NoSuchMethodException) e.getCause());
            }
            throw new RuntimeException(e.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AccessibleObject accessibleObject, boolean z) {
        if (System.getSecurityManager() == null) {
            accessibleObject.setAccessible(z);
        } else {
            AccessController.doPrivileged(new q(accessibleObject, z));
        }
    }
}
