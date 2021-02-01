package org.aspectj.a.b;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.a.b.c;
import org.aspectj.lang.a;
/* loaded from: classes5.dex */
public final class b {
    static Hashtable quv = new Hashtable();
    private static Object[] quw;
    static Class qux;
    int count = 0;
    String filename;
    Class qut;
    ClassLoader quu;

    static {
        quv.put("void", Void.TYPE);
        quv.put("boolean", Boolean.TYPE);
        quv.put("byte", Byte.TYPE);
        quv.put("char", Character.TYPE);
        quv.put("short", Short.TYPE);
        quv.put("int", Integer.TYPE);
        quv.put("long", Long.TYPE);
        quv.put("float", Float.TYPE);
        quv.put("double", Double.TYPE);
        quw = new Object[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(String str, ClassLoader classLoader) {
        Class<?> cls;
        if (str.equals("*")) {
            return null;
        }
        Class cls2 = (Class) quv.get(str);
        if (cls2 == null) {
            try {
                if (classLoader == null) {
                    cls = Class.forName(str);
                } else {
                    cls = Class.forName(str, false, classLoader);
                }
                return cls;
            } catch (ClassNotFoundException e) {
                if (qux == null) {
                    Class acj = acj("java.lang.ClassNotFoundException");
                    qux = acj;
                    return acj;
                }
                return qux;
            }
        }
        return cls2;
    }

    static Class acj(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public b(String str, Class cls) {
        this.filename = str;
        this.qut = cls;
        this.quu = cls.getClassLoader();
    }

    public a.InterfaceC1308a a(String str, org.aspectj.lang.c cVar, int i) {
        int i2 = this.count;
        this.count = i2 + 1;
        return new c.a(i2, str, cVar, ep(i, -1));
    }

    public static org.aspectj.lang.a a(a.InterfaceC1308a interfaceC1308a, Object obj, Object obj2) {
        return new c(interfaceC1308a, obj, obj2, quw);
    }

    public static org.aspectj.lang.a a(a.InterfaceC1308a interfaceC1308a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC1308a, obj, obj2, new Object[]{obj3});
    }

    public static org.aspectj.lang.a a(a.InterfaceC1308a interfaceC1308a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC1308a, obj, obj2, objArr);
    }

    public org.aspectj.lang.reflect.c d(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b2 = b(str3, this.quu);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.quu);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str5, ":");
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i2 = 0; i2 < countTokens2; i2++) {
            strArr[i2] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str6, ":");
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i3 = 0; i3 < countTokens3; i3++) {
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.quu);
        }
        return new e(parseInt, str2, b2, clsArr, strArr, clsArr2, b(str7, this.quu));
    }

    public org.aspectj.lang.reflect.d ep(int i, int i2) {
        return new g(this.qut, this.filename, i);
    }
}
