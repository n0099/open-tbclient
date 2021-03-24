package d.b.b.h.k;

import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class b {
    public static Object a(Object obj) {
        if (obj == null) {
            return null;
        }
        return c(obj, obj.getClass(), "dexElements");
    }

    public static DexFile b(ClassLoader classLoader) {
        if (classLoader == null) {
            return null;
        }
        boolean z = true;
        try {
            Class.forName("dalvik.system.BaseDexClassLoader");
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        try {
            if (!z) {
                Object c2 = c(classLoader, DexClassLoader.class, "mDexs");
                if (c2 == null) {
                    return null;
                }
                return (DexFile) Array.get(c2, 0);
            }
            Object a2 = a(d(classLoader));
            if (a2 == null) {
                return null;
            }
            return (DexFile) c(Array.get(a2, 0), Class.forName("dalvik.system.DexPathList$Element"), "dexFile");
        } catch (Exception unused2) {
            return null;
        }
    }

    public static Object c(Object obj, Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (NoSuchFieldException | SecurityException | Exception unused) {
            return null;
        }
    }

    public static Object d(Object obj) {
        try {
            return c(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
        } catch (ClassNotFoundException | Exception unused) {
            return null;
        }
    }
}
