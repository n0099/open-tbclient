package javassist.util.proxy;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import javassist.CannotCompileException;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Class[] f2870a;
    public static final String[] b;
    public static final String[] c;
    public static final String[] d;
    public static final String[] e;
    public static final int[] f;
    private static Method g;
    private static Method h;

    static {
        try {
            Class<?> cls = Class.forName("java.lang.ClassLoader");
            g = m.a(cls, "defineClass", new Class[]{String.class, byte[].class, Integer.TYPE, Integer.TYPE});
            h = m.a(cls, "defineClass", new Class[]{String.class, byte[].class, Integer.TYPE, Integer.TYPE, ProtectionDomain.class});
            f2870a = new Class[]{Boolean.TYPE, Byte.TYPE, Character.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Void.TYPE};
            b = new String[]{"java.lang.Boolean", "java.lang.Byte", "java.lang.Character", "java.lang.Short", "java.lang.Integer", "java.lang.Long", "java.lang.Float", "java.lang.Double", "java.lang.Void"};
            c = new String[]{"(Z)V", "(B)V", "(C)V", "(S)V", "(I)V", "(J)V", "(F)V", "(D)V"};
            d = new String[]{"booleanValue", "byteValue", "charValue", "shortValue", "intValue", "longValue", "floatValue", "doubleValue"};
            e = new String[]{"()Z", "()B", "()C", "()S", "()I", "()J", "()F", "()D"};
            f = new int[]{1, 1, 1, 1, 1, 2, 1, 2};
        } catch (Exception e2) {
            throw new RuntimeException("cannot initialize");
        }
    }

    public static final int a(Class cls) {
        Class[] clsArr = f2870a;
        int length = clsArr.length;
        for (int i = 0; i < length; i++) {
            if (clsArr[i] == cls) {
                return i;
            }
        }
        throw new RuntimeException("bad type:" + cls.getName());
    }

    public static Class a(javassist.bytecode.i iVar, ClassLoader classLoader, ProtectionDomain protectionDomain) {
        Method method;
        Object[] objArr;
        try {
            byte[] a2 = a(iVar);
            if (protectionDomain == null) {
                method = g;
                objArr = new Object[]{iVar.f(), a2, new Integer(0), new Integer(a2.length)};
            } else {
                method = h;
                objArr = new Object[]{iVar.f(), a2, new Integer(0), new Integer(a2.length), protectionDomain};
            }
            return a(method, classLoader, objArr);
        } catch (RuntimeException e2) {
            throw e2;
        } catch (InvocationTargetException e3) {
            throw new CannotCompileException(e3.getTargetException());
        } catch (Exception e4) {
            throw new CannotCompileException(e4);
        }
    }

    private static synchronized Class a(Method method, ClassLoader classLoader, Object[] objArr) {
        Class cls;
        synchronized (a.class) {
            m.a(method, true);
            cls = (Class) method.invoke(classLoader, objArr);
            m.a(method, false);
        }
        return cls;
    }

    private static byte[] a(javassist.bytecode.i iVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            iVar.a(dataOutputStream);
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            dataOutputStream.close();
            throw th;
        }
    }

    public static void a(javassist.bytecode.i iVar, String str) {
        try {
            b(iVar, str);
        } catch (IOException e2) {
            throw new CannotCompileException(e2);
        }
    }

    private static void b(javassist.bytecode.i iVar, String str) {
        String str2 = str + File.separatorChar + iVar.f().replace('.', File.separatorChar) + ".class";
        int lastIndexOf = str2.lastIndexOf(File.separatorChar);
        if (lastIndexOf > 0) {
            String substring = str2.substring(0, lastIndexOf);
            if (!substring.equals(".")) {
                new File(substring).mkdirs();
            }
        }
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(str2)));
        try {
            try {
                iVar.a(dataOutputStream);
            } catch (IOException e2) {
                throw e2;
            }
        } finally {
            dataOutputStream.close();
        }
    }
}
