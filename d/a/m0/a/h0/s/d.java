package d.a.m0.a.h0.s;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public static void a(Context context, String str) throws Exception {
        Object e2 = e((PathClassLoader) context.getClassLoader());
        Field declaredField = e2.getClass().getDeclaredField("nativeLibraryDirectories");
        declaredField.setAccessible(true);
        File[] fileArr = (File[]) declaredField.get(e2);
        Object newInstance = Array.newInstance(File.class, fileArr.length + 1);
        Array.set(newInstance, 0, new File(str));
        for (int i2 = 1; i2 < fileArr.length + 1; i2++) {
            Array.set(newInstance, i2, fileArr[i2 - 1]);
        }
        declaredField.set(e2, newInstance);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static void b(Context context, String str) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        Object e2 = e((PathClassLoader) context.getClassLoader());
        Field declaredField = e2.getClass().getDeclaredField("systemNativeLibraryDirectories");
        declaredField.setAccessible(true);
        List list = (List) declaredField.get(e2);
        list.add(new File(str));
        declaredField.set(e2, list);
        Field declaredField2 = e2.getClass().getDeclaredField("nativeLibraryDirectories");
        declaredField2.setAccessible(true);
        ArrayList arrayList = (ArrayList) declaredField2.get(e2);
        arrayList.add(new File(str));
        declaredField2.set(e2, arrayList);
        Class<?> cls = Class.forName("dalvik.system.DexPathList$Element");
        Constructor<?> constructor = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
        Field declaredField3 = e2.getClass().getDeclaredField("nativeLibraryPathElements");
        declaredField3.setAccessible(true);
        Object[] objArr = (Object[]) declaredField3.get(e2);
        Object newInstance = Array.newInstance(cls, objArr.length + 1);
        if (constructor != null) {
            try {
                Array.set(newInstance, 0, constructor.newInstance(new File(str), Boolean.TRUE, null, null));
                for (int i2 = 1; i2 < objArr.length + 1; i2++) {
                    Array.set(newInstance, i2, objArr[i2 - 1]);
                }
                declaredField3.set(e2, newInstance);
            } catch (IllegalArgumentException unused) {
                Method declaredMethod = e2.getClass().getDeclaredMethod("makePathElements", List.class);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, arrayList);
                Field declaredField4 = e2.getClass().getDeclaredField("nativeLibraryPathElements");
                declaredField4.setAccessible(true);
                declaredField4.set(e2, invoke);
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
    }

    public static void c(Context context, String str) throws NoSuchFieldException, IllegalAccessException {
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        Field declaredField = pathClassLoader.getClass().getDeclaredField("mLibPaths");
        declaredField.setAccessible(true);
        String[] strArr = (String[]) declaredField.get(pathClassLoader);
        Object newInstance = Array.newInstance(String.class, strArr.length + 1);
        Array.set(newInstance, 0, str);
        for (int i2 = 1; i2 < strArr.length + 1; i2++) {
            Array.set(newInstance, i2, strArr[i2 - 1]);
        }
        declaredField.set(pathClassLoader, newInstance);
    }

    public static Object d(Object obj, Class cls, String str) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Object e(Object obj) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return d(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
    }

    public static boolean f() {
        try {
            Class.forName("dalvik.system.BaseDexClassLoader");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void g(Context context, String str) {
        if (f()) {
            try {
                try {
                    a(context, str);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            } catch (Exception unused) {
                b(context, str);
                return;
            }
        }
        try {
            c(context, str);
        } catch (Exception unused2) {
        }
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static boolean h(String str, String str2, boolean z) {
        if (!z) {
            try {
                System.loadLibrary(str);
                return true;
            } catch (Throwable unused) {
            }
        }
        try {
            System.load(str2 + File.separator + "lib" + str + ".so");
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }
}
