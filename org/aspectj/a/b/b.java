package org.aspectj.a.b;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.a.b.c;
import org.aspectj.lang.a;
/* loaded from: classes4.dex */
public final class b {
    static Hashtable qoT = new Hashtable();
    private static Object[] qoU;
    static Class qoV;
    int count = 0;
    String filename;
    Class qoR;
    ClassLoader qoS;

    static {
        qoT.put("void", Void.TYPE);
        qoT.put("boolean", Boolean.TYPE);
        qoT.put("byte", Byte.TYPE);
        qoT.put("char", Character.TYPE);
        qoT.put("short", Short.TYPE);
        qoT.put("int", Integer.TYPE);
        qoT.put("long", Long.TYPE);
        qoT.put("float", Float.TYPE);
        qoT.put("double", Double.TYPE);
        qoU = new Object[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(String str, ClassLoader classLoader) {
        Class<?> cls;
        if (str.equals("*")) {
            return null;
        }
        Class cls2 = (Class) qoT.get(str);
        if (cls2 == null) {
            try {
                if (classLoader == null) {
                    cls = Class.forName(str);
                } else {
                    cls = Class.forName(str, false, classLoader);
                }
                return cls;
            } catch (ClassNotFoundException e) {
                if (qoV == null) {
                    Class acp = acp("java.lang.ClassNotFoundException");
                    qoV = acp;
                    return acp;
                }
                return qoV;
            }
        }
        return cls2;
    }

    static Class acp(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public b(String str, Class cls) {
        this.filename = str;
        this.qoR = cls;
        this.qoS = cls.getClassLoader();
    }

    public a.InterfaceC1315a a(String str, org.aspectj.lang.c cVar, int i) {
        int i2 = this.count;
        this.count = i2 + 1;
        return new c.a(i2, str, cVar, es(i, -1));
    }

    public static org.aspectj.lang.a a(a.InterfaceC1315a interfaceC1315a, Object obj, Object obj2) {
        return new c(interfaceC1315a, obj, obj2, qoU);
    }

    public static org.aspectj.lang.a a(a.InterfaceC1315a interfaceC1315a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC1315a, obj, obj2, new Object[]{obj3});
    }

    public static org.aspectj.lang.a a(a.InterfaceC1315a interfaceC1315a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC1315a, obj, obj2, objArr);
    }

    public org.aspectj.lang.reflect.c d(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b2 = b(str3, this.qoS);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.qoS);
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
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.qoS);
        }
        return new e(parseInt, str2, b2, clsArr, strArr, clsArr2, b(str7, this.qoS));
    }

    public org.aspectj.lang.reflect.d es(int i, int i2) {
        return new g(this.qoR, this.filename, i);
    }
}
