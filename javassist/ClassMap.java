package javassist;

import java.util.HashMap;
import javassist.bytecode.z;
/* loaded from: classes.dex */
public class ClassMap extends HashMap {
    private ClassMap parent;

    public ClassMap() {
        this.parent = null;
    }

    ClassMap(ClassMap classMap) {
        this.parent = classMap;
    }

    public void put(h hVar, h hVar2) {
        put(hVar.n(), hVar2.n());
    }

    public void put(String str, String str2) {
        if (str != str2) {
            String jvmName = toJvmName(str);
            String str3 = (String) get(jvmName);
            if (str3 == null || !str3.equals(jvmName)) {
                super.put((ClassMap) jvmName, toJvmName(str2));
            }
        }
    }

    public void putIfNone(String str, String str2) {
        if (str != str2) {
            String jvmName = toJvmName(str);
            if (((String) get(jvmName)) == null) {
                super.put((ClassMap) jvmName, toJvmName(str2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void put0(Object obj, Object obj2) {
        super.put((ClassMap) obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Object obj2 = super.get(obj);
        if (obj2 == null && this.parent != null) {
            return this.parent.get(obj);
        }
        return obj2;
    }

    public void fix(h hVar) {
        fix(hVar.n());
    }

    public void fix(String str) {
        String jvmName = toJvmName(str);
        super.put((ClassMap) jvmName, jvmName);
    }

    public static String toJvmName(String str) {
        return z.a(str);
    }

    public static String toJavaName(String str) {
        return z.b(str);
    }
}
