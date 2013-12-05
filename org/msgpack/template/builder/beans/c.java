package org.msgpack.template.builder.beans;

import com.baidu.zeus.bouncycastle.DERTags;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f3111a = {"sun.beans.infos"};
    private static Map<Class<?>, e> b = Collections.synchronizedMap(new WeakHashMap((int) DERTags.TAGGED));

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() != 0) {
            if (str.length() <= 1 || !Character.isUpperCase(str.charAt(1))) {
                char[] charArray = str.toCharArray();
                charArray[0] = Character.toLowerCase(charArray[0]);
                return new String(charArray);
            }
            return str;
        }
        return str;
    }

    public static a a(Class<?> cls) {
        e eVar = b.get(cls);
        if (eVar == null) {
            e b2 = b(cls, null, 1);
            b.put(cls, b2);
            return b2;
        }
        return eVar;
    }

    private static e a(Class<?> cls, Class<?> cls2, int i) {
        a aVar = null;
        if (i == 1) {
            aVar = b(cls);
        }
        e eVar = new e(cls, aVar, cls2);
        if (eVar.f3112a != null) {
            for (int length = eVar.f3112a.length - 1; length >= 0; length--) {
                eVar.a(eVar.f3112a[length], true);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != cls2) {
            if (superclass == null) {
                throw new IntrospectionException("Stop class is not super class of bean class");
            }
            if (i == 2) {
                i = 1;
            }
            e a2 = a(superclass, cls2, i);
            if (a2 != null) {
                eVar.a((a) a2, false);
            }
        }
        return eVar;
    }

    private static a b(Class<?> cls) {
        String str = String.valueOf(cls.getName()) + "BeanInfo";
        try {
            return a(str, cls);
        } catch (Exception e) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf >= 0) {
                str = str.substring(lastIndexOf + 1);
            }
            for (int i = 0; i < f3111a.length; i++) {
                try {
                    a a2 = a(String.valueOf(f3111a[i]) + "." + str, cls);
                    BeanDescriptor e2 = a2.e();
                    if (e2 != null && cls == e2.a()) {
                        return a2;
                    }
                } catch (Exception e3) {
                }
            }
            if (a.class.isAssignableFrom(cls)) {
                try {
                    return a(cls.getName(), cls);
                } catch (Exception e4) {
                    return null;
                }
            }
            return null;
        }
    }

    private static a a(String str, Class<?> cls) {
        try {
            if (cls.getClassLoader() != null) {
                return (a) Class.forName(str, true, cls.getClassLoader()).newInstance();
            }
        } catch (Exception e) {
        }
        try {
            return (a) Class.forName(str, true, ClassLoader.getSystemClassLoader()).newInstance();
        } catch (Exception e2) {
            return (a) Class.forName(str, true, Thread.currentThread().getContextClassLoader()).newInstance();
        }
    }

    private static e b(Class<?> cls, Class<?> cls2, int i) {
        e a2 = a(cls, cls2, i);
        a2.h();
        return a2;
    }
}
