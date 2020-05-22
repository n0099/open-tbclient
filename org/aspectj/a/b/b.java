package org.aspectj.a.b;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.a.b.c;
import org.aspectj.lang.a;
/* loaded from: classes7.dex */
public final class b {
    static Hashtable nAw = new Hashtable();
    private static Object[] nAx;
    static Class nAy;
    int count = 0;
    String filename;
    Class nAu;
    ClassLoader nAv;

    static {
        nAw.put("void", Void.TYPE);
        nAw.put("boolean", Boolean.TYPE);
        nAw.put("byte", Byte.TYPE);
        nAw.put("char", Character.TYPE);
        nAw.put("short", Short.TYPE);
        nAw.put("int", Integer.TYPE);
        nAw.put("long", Long.TYPE);
        nAw.put("float", Float.TYPE);
        nAw.put("double", Double.TYPE);
        nAx = new Object[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(String str, ClassLoader classLoader) {
        Class<?> cls;
        if (str.equals("*")) {
            return null;
        }
        Class cls2 = (Class) nAw.get(str);
        if (cls2 == null) {
            try {
                if (classLoader == null) {
                    cls = Class.forName(str);
                } else {
                    cls = Class.forName(str, false, classLoader);
                }
                return cls;
            } catch (ClassNotFoundException e) {
                if (nAy == null) {
                    Class RM = RM("java.lang.ClassNotFoundException");
                    nAy = RM;
                    return RM;
                }
                return nAy;
            }
        }
        return cls2;
    }

    static Class RM(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public b(String str, Class cls) {
        this.filename = str;
        this.nAu = cls;
        this.nAv = cls.getClassLoader();
    }

    public a.InterfaceC0888a a(String str, org.aspectj.lang.c cVar, int i) {
        int i2 = this.count;
        this.count = i2 + 1;
        return new c.a(i2, str, cVar, dU(i, -1));
    }

    public static org.aspectj.lang.a a(a.InterfaceC0888a interfaceC0888a, Object obj, Object obj2) {
        return new c(interfaceC0888a, obj, obj2, nAx);
    }

    public static org.aspectj.lang.a a(a.InterfaceC0888a interfaceC0888a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC0888a, obj, obj2, new Object[]{obj3});
    }

    public static org.aspectj.lang.a a(a.InterfaceC0888a interfaceC0888a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC0888a, obj, obj2, objArr);
    }

    public org.aspectj.lang.reflect.c b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b = b(str3, this.nAv);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.nAv);
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
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.nAv);
        }
        return new e(parseInt, str2, b, clsArr, strArr, clsArr2, b(str7, this.nAv));
    }

    public org.aspectj.lang.reflect.d dU(int i, int i2) {
        return new g(this.nAu, this.filename, i);
    }
}
