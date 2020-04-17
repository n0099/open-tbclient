package org.aspectj.a.b;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.a.b.c;
import org.aspectj.lang.a;
/* loaded from: classes7.dex */
public final class b {
    static Hashtable nfs = new Hashtable();
    private static Object[] nft;
    static Class nfu;
    int count = 0;
    String filename;
    Class nfq;
    ClassLoader nfr;

    static {
        nfs.put("void", Void.TYPE);
        nfs.put("boolean", Boolean.TYPE);
        nfs.put("byte", Byte.TYPE);
        nfs.put("char", Character.TYPE);
        nfs.put("short", Short.TYPE);
        nfs.put("int", Integer.TYPE);
        nfs.put("long", Long.TYPE);
        nfs.put("float", Float.TYPE);
        nfs.put("double", Double.TYPE);
        nft = new Object[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(String str, ClassLoader classLoader) {
        Class<?> cls;
        if (str.equals("*")) {
            return null;
        }
        Class cls2 = (Class) nfs.get(str);
        if (cls2 == null) {
            try {
                if (classLoader == null) {
                    cls = Class.forName(str);
                } else {
                    cls = Class.forName(str, false, classLoader);
                }
                return cls;
            } catch (ClassNotFoundException e) {
                if (nfu == null) {
                    Class PD = PD("java.lang.ClassNotFoundException");
                    nfu = PD;
                    return PD;
                }
                return nfu;
            }
        }
        return cls2;
    }

    static Class PD(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public b(String str, Class cls) {
        this.filename = str;
        this.nfq = cls;
        this.nfr = cls.getClassLoader();
    }

    public a.InterfaceC0805a a(String str, org.aspectj.lang.c cVar, int i) {
        int i2 = this.count;
        this.count = i2 + 1;
        return new c.a(i2, str, cVar, dP(i, -1));
    }

    public static org.aspectj.lang.a a(a.InterfaceC0805a interfaceC0805a, Object obj, Object obj2) {
        return new c(interfaceC0805a, obj, obj2, nft);
    }

    public static org.aspectj.lang.a a(a.InterfaceC0805a interfaceC0805a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC0805a, obj, obj2, new Object[]{obj3});
    }

    public static org.aspectj.lang.a a(a.InterfaceC0805a interfaceC0805a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC0805a, obj, obj2, objArr);
    }

    public org.aspectj.lang.reflect.c b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b = b(str3, this.nfr);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.nfr);
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
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.nfr);
        }
        return new e(parseInt, str2, b, clsArr, strArr, clsArr2, b(str7, this.nfr));
    }

    public org.aspectj.lang.reflect.d dP(int i, int i2) {
        return new g(this.nfq, this.filename, i);
    }
}
