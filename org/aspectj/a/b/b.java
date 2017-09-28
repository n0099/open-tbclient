package org.aspectj.a.b;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.a.b.c;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public final class b {
    static Hashtable hnN = new Hashtable();
    private static Object[] hnO;
    static Class hnP;
    String filename;
    Class hnL;
    ClassLoader hnM;

    static {
        hnN.put("void", Void.TYPE);
        hnN.put("boolean", Boolean.TYPE);
        hnN.put("byte", Byte.TYPE);
        hnN.put("char", Character.TYPE);
        hnN.put("short", Short.TYPE);
        hnN.put("int", Integer.TYPE);
        hnN.put("long", Long.TYPE);
        hnN.put("float", Float.TYPE);
        hnN.put("double", Double.TYPE);
        hnO = new Object[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(String str, ClassLoader classLoader) {
        Class<?> cls;
        if (str.equals("*")) {
            return null;
        }
        Class cls2 = (Class) hnN.get(str);
        if (cls2 == null) {
            try {
                if (classLoader == null) {
                    cls = Class.forName(str);
                } else {
                    cls = Class.forName(str, false, classLoader);
                }
                return cls;
            } catch (ClassNotFoundException e) {
                if (hnP == null) {
                    Class vv = vv("java.lang.ClassNotFoundException");
                    hnP = vv;
                    return vv;
                }
                return hnP;
            }
        }
        return cls2;
    }

    static Class vv(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public b(String str, Class cls) {
        this.filename = str;
        this.hnL = cls;
        this.hnM = cls.getClassLoader();
    }

    public a.InterfaceC0164a a(String str, org.aspectj.lang.c cVar, int i) {
        return new c.a(str, cVar, cn(i, -1));
    }

    public static org.aspectj.lang.a a(a.InterfaceC0164a interfaceC0164a, Object obj, Object obj2) {
        return new c(interfaceC0164a, obj, obj2, hnO);
    }

    public static org.aspectj.lang.a a(a.InterfaceC0164a interfaceC0164a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC0164a, obj, obj2, new Object[]{obj3});
    }

    public static org.aspectj.lang.a a(a.InterfaceC0164a interfaceC0164a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC0164a, obj, obj2, objArr);
    }

    public org.aspectj.lang.reflect.c b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b = b(str3, this.hnM);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.hnM);
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
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.hnM);
        }
        return new e(parseInt, str2, b, clsArr, strArr, clsArr2, b(str7, this.hnM));
    }

    public org.aspectj.lang.reflect.d cn(int i, int i2) {
        return new g(this.hnL, this.filename, i);
    }
}
