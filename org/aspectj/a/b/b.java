package org.aspectj.a.b;

import com.baidu.ar.util.SystemInfoUtil;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.a.b.c;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public final class b {
    static Hashtable hJI = new Hashtable();
    private static Object[] hJJ;
    static Class hJK;
    String filename;
    Class hJG;
    ClassLoader hJH;

    static {
        hJI.put("void", Void.TYPE);
        hJI.put("boolean", Boolean.TYPE);
        hJI.put("byte", Byte.TYPE);
        hJI.put("char", Character.TYPE);
        hJI.put("short", Short.TYPE);
        hJI.put("int", Integer.TYPE);
        hJI.put("long", Long.TYPE);
        hJI.put("float", Float.TYPE);
        hJI.put("double", Double.TYPE);
        hJJ = new Object[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(String str, ClassLoader classLoader) {
        Class<?> cls;
        if (str.equals("*")) {
            return null;
        }
        Class cls2 = (Class) hJI.get(str);
        if (cls2 == null) {
            try {
                if (classLoader == null) {
                    cls = Class.forName(str);
                } else {
                    cls = Class.forName(str, false, classLoader);
                }
                return cls;
            } catch (ClassNotFoundException e) {
                if (hJK == null) {
                    Class wI = wI("java.lang.ClassNotFoundException");
                    hJK = wI;
                    return wI;
                }
                return hJK;
            }
        }
        return cls2;
    }

    static Class wI(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public b(String str, Class cls) {
        this.filename = str;
        this.hJG = cls;
        this.hJH = cls.getClassLoader();
    }

    public a.InterfaceC0298a a(String str, org.aspectj.lang.c cVar, int i) {
        return new c.a(str, cVar, bW(i, -1));
    }

    public static org.aspectj.lang.a a(a.InterfaceC0298a interfaceC0298a, Object obj, Object obj2) {
        return new c(interfaceC0298a, obj, obj2, hJJ);
    }

    public static org.aspectj.lang.a a(a.InterfaceC0298a interfaceC0298a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC0298a, obj, obj2, new Object[]{obj3});
    }

    public static org.aspectj.lang.a a(a.InterfaceC0298a interfaceC0298a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC0298a, obj, obj2, objArr);
    }

    public org.aspectj.lang.reflect.c b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b = b(str3, this.hJH);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, SystemInfoUtil.COLON);
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.hJH);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str5, SystemInfoUtil.COLON);
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i2 = 0; i2 < countTokens2; i2++) {
            strArr[i2] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str6, SystemInfoUtil.COLON);
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i3 = 0; i3 < countTokens3; i3++) {
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.hJH);
        }
        return new e(parseInt, str2, b, clsArr, strArr, clsArr2, b(str7, this.hJH));
    }

    public org.aspectj.lang.reflect.d bW(int i, int i2) {
        return new g(this.hJG, this.filename, i);
    }
}
