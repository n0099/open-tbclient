package org.aspectj.a.b;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.a.b.c;
import org.aspectj.lang.a;
/* loaded from: classes5.dex */
public final class b {
    static Hashtable ksE = new Hashtable();
    private static Object[] ksF;
    static Class ksG;
    String filename;
    Class ksC;
    ClassLoader ksD;

    static {
        ksE.put("void", Void.TYPE);
        ksE.put("boolean", Boolean.TYPE);
        ksE.put("byte", Byte.TYPE);
        ksE.put("char", Character.TYPE);
        ksE.put("short", Short.TYPE);
        ksE.put("int", Integer.TYPE);
        ksE.put("long", Long.TYPE);
        ksE.put("float", Float.TYPE);
        ksE.put("double", Double.TYPE);
        ksF = new Object[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(String str, ClassLoader classLoader) {
        Class<?> cls;
        if (str.equals("*")) {
            return null;
        }
        Class cls2 = (Class) ksE.get(str);
        if (cls2 == null) {
            try {
                if (classLoader == null) {
                    cls = Class.forName(str);
                } else {
                    cls = Class.forName(str, false, classLoader);
                }
                return cls;
            } catch (ClassNotFoundException e) {
                if (ksG == null) {
                    Class Im = Im("java.lang.ClassNotFoundException");
                    ksG = Im;
                    return Im;
                }
                return ksG;
            }
        }
        return cls2;
    }

    static Class Im(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public b(String str, Class cls) {
        this.filename = str;
        this.ksC = cls;
        this.ksD = cls.getClassLoader();
    }

    public a.InterfaceC0495a a(String str, org.aspectj.lang.c cVar, int i) {
        return new c.a(str, cVar, cY(i, -1));
    }

    public static org.aspectj.lang.a a(a.InterfaceC0495a interfaceC0495a, Object obj, Object obj2) {
        return new c(interfaceC0495a, obj, obj2, ksF);
    }

    public static org.aspectj.lang.a a(a.InterfaceC0495a interfaceC0495a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC0495a, obj, obj2, new Object[]{obj3});
    }

    public static org.aspectj.lang.a a(a.InterfaceC0495a interfaceC0495a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC0495a, obj, obj2, objArr);
    }

    public org.aspectj.lang.reflect.c b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b = b(str3, this.ksD);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.ksD);
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
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.ksD);
        }
        return new e(parseInt, str2, b, clsArr, strArr, clsArr2, b(str7, this.ksD));
    }

    public org.aspectj.lang.reflect.d cY(int i, int i2) {
        return new g(this.ksC, this.filename, i);
    }
}
