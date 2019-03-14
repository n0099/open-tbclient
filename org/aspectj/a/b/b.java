package org.aspectj.a.b;

import com.baidu.mobstat.Config;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.a.b.c;
import org.aspectj.lang.a;
/* loaded from: classes5.dex */
public final class b {
    static Hashtable jTr = new Hashtable();
    private static Object[] jTs;
    static Class jTt;
    String filename;
    Class jTp;
    ClassLoader jTq;

    static {
        jTr.put("void", Void.TYPE);
        jTr.put("boolean", Boolean.TYPE);
        jTr.put("byte", Byte.TYPE);
        jTr.put("char", Character.TYPE);
        jTr.put("short", Short.TYPE);
        jTr.put("int", Integer.TYPE);
        jTr.put("long", Long.TYPE);
        jTr.put("float", Float.TYPE);
        jTr.put("double", Double.TYPE);
        jTs = new Object[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b(String str, ClassLoader classLoader) {
        Class<?> cls;
        if (str.equals("*")) {
            return null;
        }
        Class cls2 = (Class) jTr.get(str);
        if (cls2 == null) {
            try {
                if (classLoader == null) {
                    cls = Class.forName(str);
                } else {
                    cls = Class.forName(str, false, classLoader);
                }
                return cls;
            } catch (ClassNotFoundException e) {
                if (jTt == null) {
                    Class Gb = Gb("java.lang.ClassNotFoundException");
                    jTt = Gb;
                    return Gb;
                }
                return jTt;
            }
        }
        return cls2;
    }

    static Class Gb(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public b(String str, Class cls) {
        this.filename = str;
        this.jTp = cls;
        this.jTq = cls.getClassLoader();
    }

    public a.InterfaceC0474a a(String str, org.aspectj.lang.c cVar, int i) {
        return new c.a(str, cVar, cM(i, -1));
    }

    public static org.aspectj.lang.a a(a.InterfaceC0474a interfaceC0474a, Object obj, Object obj2) {
        return new c(interfaceC0474a, obj, obj2, jTs);
    }

    public static org.aspectj.lang.a a(a.InterfaceC0474a interfaceC0474a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC0474a, obj, obj2, new Object[]{obj3});
    }

    public static org.aspectj.lang.a a(a.InterfaceC0474a interfaceC0474a, Object obj, Object obj2, Object[] objArr) {
        return new c(interfaceC0474a, obj, obj2, objArr);
    }

    public org.aspectj.lang.reflect.c b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class b = b(str3, this.jTq);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, Config.TRACE_TODAY_VISIT_SPLIT);
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = b(stringTokenizer.nextToken(), this.jTq);
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
            clsArr2[i3] = b(stringTokenizer3.nextToken(), this.jTq);
        }
        return new e(parseInt, str2, b, clsArr, strArr, clsArr2, b(str7, this.jTq));
    }

    public org.aspectj.lang.reflect.d cM(int i, int i2) {
        return new g(this.jTp, this.filename, i);
    }
}
