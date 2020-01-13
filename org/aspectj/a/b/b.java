package org.aspectj.a.b;

import com.baidu.minivideo.effect.core.entity.AEffectParams;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.a.b.c;
import org.aspectj.lang.a;
/* loaded from: classes5.dex */
public final class b {
    static Hashtable nIU = new Hashtable();
    private static Object[] nIV;
    static Class nIW;
    int count = 0;
    String filename;
    Class nIS;
    ClassLoader nIT;

    static {
        nIU.put("void", Void.TYPE);
        nIU.put("boolean", Boolean.TYPE);
        nIU.put("byte", Byte.TYPE);
        nIU.put("char", Character.TYPE);
        nIU.put("short", Short.TYPE);
        nIU.put("int", Integer.TYPE);
        nIU.put("long", Long.TYPE);
        nIU.put(AEffectParams.VALUE_TYPE_FLOAT, Float.TYPE);
        nIU.put("double", Double.TYPE);
        nIV = new Object[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(String str, ClassLoader classLoader) {
        Class<?> cls;
        if (str.equals("*")) {
            return null;
        }
        Class cls2 = (Class) nIU.get(str);
        if (cls2 == null) {
            try {
                if (classLoader == null) {
                    cls = Class.forName(str);
                } else {
                    cls = Class.forName(str, false, classLoader);
                }
                return cls;
            } catch (ClassNotFoundException e) {
                if (nIW == null) {
                    Class Sc = Sc("java.lang.ClassNotFoundException");
                    nIW = Sc;
                    return Sc;
                }
                return nIW;
            }
        }
        return cls2;
    }

    static Class Sc(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public b(String str, Class cls) {
        this.filename = str;
        this.nIS = cls;
        this.nIT = cls.getClassLoader();
    }

    public a.InterfaceC0773a a(String str, org.aspectj.lang.c cVar, int i) {
        int i2 = this.count;
        this.count = i2 + 1;
        return new c.a(i2, str, cVar, eA(i, -1));
    }

    public static org.aspectj.lang.a a(a.InterfaceC0773a interfaceC0773a, Object obj, Object obj2) {
        return new c(interfaceC0773a, obj, obj2, nIV);
    }

    public static org.aspectj.lang.a a(a.InterfaceC0773a interfaceC0773a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC0773a, obj, obj2, new Object[]{obj3});
    }

    public static org.aspectj.lang.a a(a.InterfaceC0773a interfaceC0773a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC0773a, obj, obj2, objArr);
    }

    public org.aspectj.lang.reflect.c b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b = b(str3, this.nIT);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.nIT);
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
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.nIT);
        }
        return new e(parseInt, str2, b, clsArr, strArr, clsArr2, b(str7, this.nIT));
    }

    public org.aspectj.lang.reflect.d eA(int i, int i2) {
        return new g(this.nIS, this.filename, i);
    }
}
