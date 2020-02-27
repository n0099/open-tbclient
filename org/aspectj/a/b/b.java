package org.aspectj.a.b;

import com.baidu.minivideo.effect.core.entity.AEffectParams;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.a.b.c;
import org.aspectj.lang.a;
/* loaded from: classes7.dex */
public final class b {
    static Hashtable nJO = new Hashtable();
    private static Object[] nJP;
    static Class nJQ;
    int count = 0;
    String filename;
    Class nJM;
    ClassLoader nJN;

    static {
        nJO.put("void", Void.TYPE);
        nJO.put("boolean", Boolean.TYPE);
        nJO.put("byte", Byte.TYPE);
        nJO.put("char", Character.TYPE);
        nJO.put("short", Short.TYPE);
        nJO.put("int", Integer.TYPE);
        nJO.put("long", Long.TYPE);
        nJO.put(AEffectParams.VALUE_TYPE_FLOAT, Float.TYPE);
        nJO.put("double", Double.TYPE);
        nJP = new Object[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(String str, ClassLoader classLoader) {
        Class<?> cls;
        if (str.equals("*")) {
            return null;
        }
        Class cls2 = (Class) nJO.get(str);
        if (cls2 == null) {
            try {
                if (classLoader == null) {
                    cls = Class.forName(str);
                } else {
                    cls = Class.forName(str, false, classLoader);
                }
                return cls;
            } catch (ClassNotFoundException e) {
                if (nJQ == null) {
                    Class Sn = Sn("java.lang.ClassNotFoundException");
                    nJQ = Sn;
                    return Sn;
                }
                return nJQ;
            }
        }
        return cls2;
    }

    static Class Sn(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public b(String str, Class cls) {
        this.filename = str;
        this.nJM = cls;
        this.nJN = cls.getClassLoader();
    }

    public a.InterfaceC0781a a(String str, org.aspectj.lang.c cVar, int i) {
        int i2 = this.count;
        this.count = i2 + 1;
        return new c.a(i2, str, cVar, eD(i, -1));
    }

    public static org.aspectj.lang.a a(a.InterfaceC0781a interfaceC0781a, Object obj, Object obj2) {
        return new c(interfaceC0781a, obj, obj2, nJP);
    }

    public static org.aspectj.lang.a a(a.InterfaceC0781a interfaceC0781a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC0781a, obj, obj2, new Object[]{obj3});
    }

    public static org.aspectj.lang.a a(a.InterfaceC0781a interfaceC0781a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC0781a, obj, obj2, objArr);
    }

    public org.aspectj.lang.reflect.c b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b = b(str3, this.nJN);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.nJN);
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
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.nJN);
        }
        return new e(parseInt, str2, b, clsArr, strArr, clsArr2, b(str7, this.nJN));
    }

    public org.aspectj.lang.reflect.d eD(int i, int i2) {
        return new g(this.nJM, this.filename, i);
    }
}
