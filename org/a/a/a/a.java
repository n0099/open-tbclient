package org.a.a.a;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Object[] f3049a = new Object[0];
    private static final Class<?>[] b = {Object.class};

    public static final int a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static final int a(boolean z) {
        return z ? 1 : 0;
    }

    public static String a(Class<?> cls) {
        StringBuilder sb = new StringBuilder();
        if (cls.isArray()) {
            do {
                sb.append("Array");
                cls = cls.getComponentType();
            } while (cls.isArray());
            String name = cls.getName();
            return String.valueOf(name.substring(name.lastIndexOf(46) + 1)) + sb.toString();
        }
        String name2 = cls.getName();
        return String.valueOf(name2.substring(name2.lastIndexOf(46) + 1)) + sb.toString();
    }
}
