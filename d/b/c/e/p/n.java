package d.b.c.e.p;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, String> f42529a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f42529a = hashMap;
        hashMap.put("java.lang.String", "java.lang.String");
        f42529a.put("java.lang.Integer", "java.lang.Integer");
        f42529a.put("java.lang.Double", "java.lang.Double");
        f42529a.put("java.lang.Float", "java.lang.Float");
        f42529a.put("java.lang.Boolean", "java.lang.Boolean");
        f42529a.put("java.lang.Character", "java.lang.Character");
        f42529a.put("java.lang.Short", "java.lang.Short");
        f42529a.put("java.lang.Long", "java.lang.Long");
        f42529a.put("java.lang.Byte", "java.lang.Byte");
        f42529a.put("java.util.Date", "java.util.Date");
        f42529a.put("java.lang.Integer", "java.lang.Integer");
        f42529a.put("java.lang.Integer", "java.lang.Integer");
    }

    public static Object a(Object obj, Field field) {
        Object obj2 = null;
        if (obj != null && field != null) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            try {
                obj2 = field.get(obj);
            } catch (Throwable unused) {
            }
            field.setAccessible(isAccessible);
        }
        return obj2;
    }
}
