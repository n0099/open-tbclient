package org.aspectj.a.b;

import com.baidu.mobstat.Config;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.a.b.c;
import org.aspectj.lang.a;
/* loaded from: classes5.dex */
public final class b {
    static Hashtable jSJ = new Hashtable();
    private static Object[] jSK;
    static Class jSL;
    String filename;
    Class jSH;
    ClassLoader jSI;

    static {
        jSJ.put("void", Void.TYPE);
        jSJ.put("boolean", Boolean.TYPE);
        jSJ.put("byte", Byte.TYPE);
        jSJ.put("char", Character.TYPE);
        jSJ.put("short", Short.TYPE);
        jSJ.put("int", Integer.TYPE);
        jSJ.put("long", Long.TYPE);
        jSJ.put("float", Float.TYPE);
        jSJ.put("double", Double.TYPE);
        jSK = new Object[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(String str, ClassLoader classLoader) {
        Class<?> cls;
        if (str.equals("*")) {
            return null;
        }
        Class cls2 = (Class) jSJ.get(str);
        if (cls2 == null) {
            try {
                if (classLoader == null) {
                    cls = Class.forName(str);
                } else {
                    cls = Class.forName(str, false, classLoader);
                }
                return cls;
            } catch (ClassNotFoundException e) {
                if (jSL == null) {
                    Class FQ = FQ("java.lang.ClassNotFoundException");
                    jSL = FQ;
                    return FQ;
                }
                return jSL;
            }
        }
        return cls2;
    }

    static Class FQ(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public b(String str, Class cls) {
        this.filename = str;
        this.jSH = cls;
        this.jSI = cls.getClassLoader();
    }

    public a.InterfaceC0474a a(String str, org.aspectj.lang.c cVar, int i) {
        return new c.a(str, cVar, cM(i, -1));
    }

    public static org.aspectj.lang.a a(a.InterfaceC0474a interfaceC0474a, Object obj, Object obj2) {
        return new c(interfaceC0474a, obj, obj2, jSK);
    }

    public static org.aspectj.lang.a a(a.InterfaceC0474a interfaceC0474a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC0474a, obj, obj2, new Object[]{obj3});
    }

    public static org.aspectj.lang.a a(a.InterfaceC0474a interfaceC0474a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC0474a, obj, obj2, objArr);
    }

    public org.aspectj.lang.reflect.c c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b = b(str3, this.jSI);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, Config.TRACE_TODAY_VISIT_SPLIT);
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.jSI);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str5, Config.TRACE_TODAY_VISIT_SPLIT);
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i2 = 0; i2 < countTokens2; i2++) {
            strArr[i2] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str6, Config.TRACE_TODAY_VISIT_SPLIT);
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i3 = 0; i3 < countTokens3; i3++) {
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.jSI);
        }
        return new e(parseInt, str2, b, clsArr, strArr, clsArr2, b(str7, this.jSI));
    }

    public org.aspectj.lang.reflect.d cM(int i, int i2) {
        return new g(this.jSH, this.filename, i);
    }
}
