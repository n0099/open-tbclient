package org.aspectj.a.b;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.a.b.c;
import org.aspectj.lang.a;
/* loaded from: classes3.dex */
public final class b {
    static Hashtable qkr = new Hashtable();
    private static Object[] qks;
    static Class qkt;
    int count = 0;
    String filename;
    Class qkp;
    ClassLoader qkq;

    static {
        qkr.put("void", Void.TYPE);
        qkr.put("boolean", Boolean.TYPE);
        qkr.put("byte", Byte.TYPE);
        qkr.put("char", Character.TYPE);
        qkr.put("short", Short.TYPE);
        qkr.put("int", Integer.TYPE);
        qkr.put("long", Long.TYPE);
        qkr.put("float", Float.TYPE);
        qkr.put("double", Double.TYPE);
        qks = new Object[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(String str, ClassLoader classLoader) {
        Class<?> cls;
        if (str.equals("*")) {
            return null;
        }
        Class cls2 = (Class) qkr.get(str);
        if (cls2 == null) {
            try {
                if (classLoader == null) {
                    cls = Class.forName(str);
                } else {
                    cls = Class.forName(str, false, classLoader);
                }
                return cls;
            } catch (ClassNotFoundException e) {
                if (qkt == null) {
                    Class abh = abh("java.lang.ClassNotFoundException");
                    qkt = abh;
                    return abh;
                }
                return qkt;
            }
        }
        return cls2;
    }

    static Class abh(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public b(String str, Class cls) {
        this.filename = str;
        this.qkp = cls;
        this.qkq = cls.getClassLoader();
    }

    public a.InterfaceC1298a a(String str, org.aspectj.lang.c cVar, int i) {
        int i2 = this.count;
        this.count = i2 + 1;
        return new c.a(i2, str, cVar, es(i, -1));
    }

    public static org.aspectj.lang.a a(a.InterfaceC1298a interfaceC1298a, Object obj, Object obj2) {
        return new c(interfaceC1298a, obj, obj2, qks);
    }

    public static org.aspectj.lang.a a(a.InterfaceC1298a interfaceC1298a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC1298a, obj, obj2, new Object[]{obj3});
    }

    public static org.aspectj.lang.a a(a.InterfaceC1298a interfaceC1298a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC1298a, obj, obj2, objArr);
    }

    public org.aspectj.lang.reflect.c d(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b2 = b(str3, this.qkq);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.qkq);
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
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.qkq);
        }
        return new e(parseInt, str2, b2, clsArr, strArr, clsArr2, b(str7, this.qkq));
    }

    public org.aspectj.lang.reflect.d es(int i, int i2) {
        return new g(this.qkp, this.filename, i);
    }
}
