package org.aspectj.a.b;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.a.b.c;
import org.aspectj.lang.a;
/* loaded from: classes5.dex */
public final class b {
    static Hashtable iDu = new Hashtable();
    private static Object[] iDv;
    static Class iDw;
    String filename;
    Class iDs;
    ClassLoader iDt;

    static {
        iDu.put("void", Void.TYPE);
        iDu.put("boolean", Boolean.TYPE);
        iDu.put("byte", Byte.TYPE);
        iDu.put("char", Character.TYPE);
        iDu.put("short", Short.TYPE);
        iDu.put("int", Integer.TYPE);
        iDu.put("long", Long.TYPE);
        iDu.put("float", Float.TYPE);
        iDu.put("double", Double.TYPE);
        iDv = new Object[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(String str, ClassLoader classLoader) {
        Class<?> cls;
        if (str.equals("*")) {
            return null;
        }
        Class cls2 = (Class) iDu.get(str);
        if (cls2 == null) {
            try {
                if (classLoader == null) {
                    cls = Class.forName(str);
                } else {
                    cls = Class.forName(str, false, classLoader);
                }
                return cls;
            } catch (ClassNotFoundException e) {
                if (iDw == null) {
                    Class zX = zX("java.lang.ClassNotFoundException");
                    iDw = zX;
                    return zX;
                }
                return iDw;
            }
        }
        return cls2;
    }

    static Class zX(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public b(String str, Class cls) {
        this.filename = str;
        this.iDs = cls;
        this.iDt = cls.getClassLoader();
    }

    public a.InterfaceC0401a a(String str, org.aspectj.lang.c cVar, int i) {
        return new c.a(str, cVar, cr(i, -1));
    }

    public static org.aspectj.lang.a a(a.InterfaceC0401a interfaceC0401a, Object obj, Object obj2) {
        return new c(interfaceC0401a, obj, obj2, iDv);
    }

    public static org.aspectj.lang.a a(a.InterfaceC0401a interfaceC0401a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC0401a, obj, obj2, new Object[]{obj3});
    }

    public static org.aspectj.lang.a a(a.InterfaceC0401a interfaceC0401a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC0401a, obj, obj2, objArr);
    }

    public org.aspectj.lang.reflect.c b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b = b(str3, this.iDt);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.iDt);
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
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.iDt);
        }
        return new e(parseInt, str2, b, clsArr, strArr, clsArr2, b(str7, this.iDt));
    }

    public org.aspectj.lang.reflect.d cr(int i, int i2) {
        return new g(this.iDs, this.filename, i);
    }
}
