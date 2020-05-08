package org.aspectj.a.b;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.a.b.c;
import org.aspectj.lang.a;
/* loaded from: classes7.dex */
public final class b {
    static Hashtable nfv = new Hashtable();
    private static Object[] nfw;
    static Class nfx;
    int count = 0;
    String filename;
    Class nft;
    ClassLoader nfu;

    static {
        nfv.put("void", Void.TYPE);
        nfv.put("boolean", Boolean.TYPE);
        nfv.put("byte", Byte.TYPE);
        nfv.put("char", Character.TYPE);
        nfv.put("short", Short.TYPE);
        nfv.put("int", Integer.TYPE);
        nfv.put("long", Long.TYPE);
        nfv.put("float", Float.TYPE);
        nfv.put("double", Double.TYPE);
        nfw = new Object[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(String str, ClassLoader classLoader) {
        Class<?> cls;
        if (str.equals("*")) {
            return null;
        }
        Class cls2 = (Class) nfv.get(str);
        if (cls2 == null) {
            try {
                if (classLoader == null) {
                    cls = Class.forName(str);
                } else {
                    cls = Class.forName(str, false, classLoader);
                }
                return cls;
            } catch (ClassNotFoundException e) {
                if (nfx == null) {
                    Class PG = PG("java.lang.ClassNotFoundException");
                    nfx = PG;
                    return PG;
                }
                return nfx;
            }
        }
        return cls2;
    }

    static Class PG(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public b(String str, Class cls) {
        this.filename = str;
        this.nft = cls;
        this.nfu = cls.getClassLoader();
    }

    public a.InterfaceC0826a a(String str, org.aspectj.lang.c cVar, int i) {
        int i2 = this.count;
        this.count = i2 + 1;
        return new c.a(i2, str, cVar, dP(i, -1));
    }

    public static org.aspectj.lang.a a(a.InterfaceC0826a interfaceC0826a, Object obj, Object obj2) {
        return new c(interfaceC0826a, obj, obj2, nfw);
    }

    public static org.aspectj.lang.a a(a.InterfaceC0826a interfaceC0826a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC0826a, obj, obj2, new Object[]{obj3});
    }

    public static org.aspectj.lang.a a(a.InterfaceC0826a interfaceC0826a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC0826a, obj, obj2, objArr);
    }

    public org.aspectj.lang.reflect.c b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b = b(str3, this.nfu);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.nfu);
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
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.nfu);
        }
        return new e(parseInt, str2, b, clsArr, strArr, clsArr2, b(str7, this.nfu));
    }

    public org.aspectj.lang.reflect.d dP(int i, int i2) {
        return new g(this.nft, this.filename, i);
    }
}
