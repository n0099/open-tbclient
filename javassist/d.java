package javassist;

import java.lang.reflect.Method;
import java.net.URL;
import java.security.PrivilegedExceptionAction;
import java.security.ProtectionDomain;
/* loaded from: classes.dex */
final class d implements PrivilegedExceptionAction {
    @Override // java.security.PrivilegedExceptionAction
    public Object run() {
        Class<?> cls = Class.forName("java.lang.ClassLoader");
        Method unused = c.g = cls.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE);
        Method unused2 = c.h = cls.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE, ProtectionDomain.class);
        Method unused3 = c.i = cls.getDeclaredMethod("definePackage", String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class);
        return null;
    }
}
