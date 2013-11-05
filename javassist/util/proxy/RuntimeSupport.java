package javassist.util.proxy;

import java.io.Serializable;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class RuntimeSupport {

    /* renamed from: a  reason: collision with root package name */
    public static c f2821a = new DefaultMethodHandler();

    /* loaded from: classes.dex */
    class DefaultMethodHandler implements Serializable, c {
        DefaultMethodHandler() {
        }

        public Object invoke(Object obj, Method method, Method method2, Object[] objArr) {
            return method2.invoke(obj, objArr);
        }
    }

    public static String a(Method method) {
        return a(method.getParameterTypes(), method.getReturnType());
    }

    public static String a(Class[] clsArr, Class cls) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        for (Class cls2 : clsArr) {
            a(stringBuffer, cls2);
        }
        stringBuffer.append(')');
        if (cls != null) {
            a(stringBuffer, cls);
        }
        return stringBuffer.toString();
    }

    private static void a(StringBuffer stringBuffer, Class cls) {
        if (cls.isArray()) {
            stringBuffer.append('[');
            a(stringBuffer, cls.getComponentType());
        } else if (cls.isPrimitive()) {
            if (cls == Void.TYPE) {
                stringBuffer.append('V');
            } else if (cls == Integer.TYPE) {
                stringBuffer.append('I');
            } else if (cls == Byte.TYPE) {
                stringBuffer.append('B');
            } else if (cls == Long.TYPE) {
                stringBuffer.append('J');
            } else if (cls == Double.TYPE) {
                stringBuffer.append('D');
            } else if (cls == Float.TYPE) {
                stringBuffer.append('F');
            } else if (cls == Character.TYPE) {
                stringBuffer.append('C');
            } else if (cls == Short.TYPE) {
                stringBuffer.append('S');
            } else if (cls == Boolean.TYPE) {
                stringBuffer.append('Z');
            } else {
                throw new RuntimeException("bad type: " + cls.getName());
            }
        } else {
            stringBuffer.append('L').append(cls.getName().replace('.', '/')).append(';');
        }
    }
}
