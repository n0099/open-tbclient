package org.aspectj.a.b;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.a.b.c;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public final class b {
    static Hashtable hMX = new Hashtable();
    private static Object[] hMY;
    static Class hMZ;
    String filename;
    Class hMV;
    ClassLoader hMW;

    static {
        hMX.put("void", Void.TYPE);
        hMX.put("boolean", Boolean.TYPE);
        hMX.put("byte", Byte.TYPE);
        hMX.put("char", Character.TYPE);
        hMX.put("short", Short.TYPE);
        hMX.put("int", Integer.TYPE);
        hMX.put("long", Long.TYPE);
        hMX.put("float", Float.TYPE);
        hMX.put("double", Double.TYPE);
        hMY = new Object[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(String str, ClassLoader classLoader) {
        Class<?> cls;
        if (str.equals("*")) {
            return null;
        }
        Class cls2 = (Class) hMX.get(str);
        if (cls2 == null) {
            try {
                if (classLoader == null) {
                    cls = Class.forName(str);
                } else {
                    cls = Class.forName(str, false, classLoader);
                }
                return cls;
            } catch (ClassNotFoundException e) {
                if (hMZ == null) {
                    Class xa = xa("java.lang.ClassNotFoundException");
                    hMZ = xa;
                    return xa;
                }
                return hMZ;
            }
        }
        return cls2;
    }

    static Class xa(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public b(String str, Class cls) {
        this.filename = str;
        this.hMV = cls;
        this.hMW = cls.getClassLoader();
    }

    public a.InterfaceC0184a a(String str, org.aspectj.lang.c cVar, int i) {
        return new c.a(str, cVar, cr(i, -1));
    }

    public static org.aspectj.lang.a a(a.InterfaceC0184a interfaceC0184a, Object obj, Object obj2) {
        return new c(interfaceC0184a, obj, obj2, hMY);
    }

    public static org.aspectj.lang.a a(a.InterfaceC0184a interfaceC0184a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC0184a, obj, obj2, new Object[]{obj3});
    }

    public static org.aspectj.lang.a a(a.InterfaceC0184a interfaceC0184a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC0184a, obj, obj2, objArr);
    }

    public org.aspectj.lang.reflect.c b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b = b(str3, this.hMW);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.hMW);
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
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.hMW);
        }
        return new e(parseInt, str2, b, clsArr, strArr, clsArr2, b(str7, this.hMW));
    }

    public org.aspectj.lang.reflect.d cr(int i, int i2) {
        return new g(this.hMV, this.filename, i);
    }
}
