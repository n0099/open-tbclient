package d.a.c.h.k;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.util.Util;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Object f42934a = new Object();

    /* renamed from: d.a.c.h.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0554a implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if ((obj instanceof String) && (obj2 instanceof String)) {
                return a.e((String) obj, (String) obj2);
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Comparator<File> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            if (file == null || file2 == null) {
                return 0;
            }
            return a.e(file.getAbsolutePath(), file2.getAbsolutePath());
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f42935a;

        /* renamed from: b  reason: collision with root package name */
        public String f42936b;
    }

    public static Object b(Object obj, Object obj2) {
        Class<?> componentType = obj.getClass().getComponentType();
        int length = Array.getLength(obj);
        int i2 = length + 1;
        Object newInstance = Array.newInstance(componentType, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 < length) {
                Array.set(newInstance, i3, Array.get(obj, i3));
            } else {
                Array.set(newInstance, i3, obj2);
            }
        }
        return newInstance;
    }

    public static Object c(Object obj, Object obj2) {
        Class<?> componentType = obj.getClass().getComponentType();
        int length = Array.getLength(obj) + 1;
        Object newInstance = Array.newInstance(componentType, length);
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 > 0) {
                Array.set(newInstance, i2, Array.get(obj, i2 - 1));
            } else {
                Array.set(newInstance, 0, obj2);
            }
        }
        return newInstance;
    }

    public static Object d(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj2 == null) {
            return obj;
        }
        if (obj.getClass().isArray() && obj2.getClass().isArray()) {
            Class<?> componentType = obj.getClass().getComponentType();
            int length = Array.getLength(obj);
            int length2 = Array.getLength(obj2) + length;
            Object newInstance = Array.newInstance(componentType, length2);
            for (int i2 = 0; i2 < length2; i2++) {
                if (i2 < length) {
                    Array.set(newInstance, i2, Array.get(obj, i2));
                } else {
                    Array.set(newInstance, i2, Array.get(obj2, i2 - length));
                }
            }
            return newInstance;
        } else if ((obj instanceof List) && (obj2 instanceof List)) {
            List list = (List) obj;
            List list2 = (List) obj2;
            ArrayList arrayList = new ArrayList(list.size() + list2.size());
            arrayList.addAll(list);
            arrayList.addAll(list2);
            return arrayList;
        } else {
            return obj;
        }
    }

    public static final int e(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        return (str.contains("com.baidu.tieba") ? -1 : 0) - (str2.contains("com.baidu.tieba") ? -1 : 0);
    }

    public static Object f(Object obj) throws IllegalArgumentException, NoSuchFieldException, NoSuchFieldError, IllegalAccessException {
        return g(obj, obj.getClass(), "dexElements");
    }

    public static Object g(Object obj, Class<?> cls, String str) throws NoSuchFieldException, NoSuchFieldError, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Object h(Object obj) throws IllegalArgumentException, NoSuchFieldException, NoSuchFieldError, IllegalAccessException {
        return g(obj, obj.getClass(), "nativeLibraryDirectories");
    }

    public static Object i(Object obj) throws IllegalArgumentException, NoSuchFieldException, NoSuchFieldError, IllegalAccessException, ClassNotFoundException {
        return g(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
    }

    public static final Comparator<File> j() {
        return new b();
    }

    public static c k(ClassLoader classLoader, ClassLoader classLoader2, String str, boolean z, String str2) {
        if (classLoader == null || classLoader2 == null) {
            return null;
        }
        synchronized (f42934a) {
            boolean z2 = true;
            try {
                Class.forName("dalvik.system.BaseDexClassLoader");
            } catch (ClassNotFoundException unused) {
                z2 = false;
            }
            if (!z2) {
                return n(classLoader, classLoader2, str, z);
            }
            return m(classLoader, classLoader2, str, z, str2);
        }
    }

    public static c l(Context context, ClassLoader classLoader, String str) {
        Object g2;
        try {
            classLoader.loadClass(str);
            if (Build.VERSION.SDK_INT <= 7) {
                g2 = g(context.getApplicationContext(), Class.forName("android.app.ApplicationContext"), "mPackageInfo");
            } else {
                g2 = g(g(context.getApplicationContext(), ContextWrapper.class, "mBase"), Class.forName("android.app.ContextImpl"), "mPackageInfo");
            }
            p(g2, g2.getClass(), "mClassLoader", classLoader);
            return o(true, null);
        } catch (IllegalAccessException e2) {
            return o(false, e2);
        } catch (IllegalArgumentException e3) {
            return o(false, e3);
        } catch (Throwable th) {
            return o(false, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c m(ClassLoader classLoader, ClassLoader classLoader2, String str, boolean z, String str2) {
        c o;
        Object i2;
        Object i3;
        List list;
        Object d2;
        List list2;
        Object d3;
        List list3;
        if (classLoader == null || classLoader2 == null) {
            return null;
        }
        try {
            DexClassLoader dexClassLoader = (DexClassLoader) classLoader2;
            dexClassLoader.loadClass(str);
            i2 = i((PathClassLoader) classLoader);
            i3 = i(dexClassLoader);
        } catch (ClassNotFoundException e2) {
            o = o(false, e2);
            BdLog.e(e2);
        } catch (IllegalAccessException e3) {
            o = o(false, e3);
            BdLog.e(e3);
        } catch (IllegalArgumentException e4) {
            o = o(false, e4);
            BdLog.e(e4);
        } catch (NoSuchFieldError e5) {
            o = o(false, e5);
            BdLog.e(e5);
        } catch (NoSuchFieldException e6) {
            o = o(false, e6);
            BdLog.e(e6);
        } catch (NoSuchMethodException e7) {
            o = o(false, e7);
            BdLog.e(e7);
        } catch (SecurityException e8) {
            o = o(false, e8);
            BdLog.e(e8);
        } catch (Throwable th) {
            o = o(false, th);
            BdLog.e(th);
        }
        if (Build.VERSION.SDK_INT <= 25 && (Build.VERSION.SDK_INT != 25 || !Util.t())) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (z) {
                    d3 = d(f(i2), f(i3));
                } else {
                    d3 = d(f(i3), f(i2));
                }
                p(i2, i2.getClass(), "dexElements", d3);
                Object d4 = d(h(i2), h(i3));
                if (d4 instanceof File[]) {
                    Arrays.sort((File[]) d4, j());
                    list3 = d4;
                } else {
                    boolean z2 = d4 instanceof List;
                    list3 = d4;
                    if (z2) {
                        List list4 = (List) d4;
                        Collections.sort(list4, j());
                        list3 = list4;
                    }
                }
                p(i2, i2.getClass(), "nativeLibraryDirectories", list3);
                ArrayList arrayList = new ArrayList((List) list3);
                arrayList.addAll((List) g(i2, i2.getClass(), "systemNativeLibraryDirectories"));
                Method declaredMethod = i2.getClass().getDeclaredMethod("makePathElements", List.class, File.class, List.class);
                declaredMethod.setAccessible(true);
                p(i2, i2.getClass(), "nativeLibraryPathElements", declaredMethod.invoke(i2.getClass(), arrayList, null, new ArrayList()));
            } else {
                if (z) {
                    d2 = d(f(i2), f(i3));
                } else {
                    d2 = d(f(i3), f(i2));
                }
                p(i2, i2.getClass(), "dexElements", d2);
                Object d5 = d(h(i2), h(i3));
                if (d5 instanceof File[]) {
                    Arrays.sort((File[]) d5, j());
                    list2 = d5;
                } else {
                    boolean z3 = d5 instanceof List;
                    list2 = d5;
                    if (z3) {
                        List list5 = (List) d5;
                        Collections.sort(list5, j());
                        list2 = list5;
                    }
                }
                p(i2, i2.getClass(), "nativeLibraryDirectories", list2);
            }
            o = null;
            return o != null ? o(true, null) : o;
        }
        Method declaredMethod2 = i2.getClass().getDeclaredMethod("addDexPath", String.class, File.class);
        declaredMethod2.setAccessible(true);
        declaredMethod2.invoke(i2, str2, null);
        Object d6 = d(h(i2), h(i3));
        if (d6 instanceof File[]) {
            Arrays.sort((File[]) d6, j());
            list = d6;
        } else {
            boolean z4 = d6 instanceof List;
            list = d6;
            if (z4) {
                List list6 = (List) d6;
                Collections.sort(list6, j());
                list = list6;
            }
        }
        p(i2, i2.getClass(), "nativeLibraryDirectories", list);
        ArrayList arrayList2 = new ArrayList((List) list);
        arrayList2.addAll((List) g(i2, i2.getClass(), "systemNativeLibraryDirectories"));
        Method declaredMethod3 = i2.getClass().getDeclaredMethod("makePathElements", List.class);
        declaredMethod3.setAccessible(true);
        p(i2, i2.getClass(), "nativeLibraryPathElements", declaredMethod3.invoke(i2.getClass(), arrayList2));
        o = null;
        if (o != null) {
        }
    }

    public static c n(ClassLoader classLoader, ClassLoader classLoader2, String str, boolean z) {
        c o;
        if (classLoader == null || classLoader2 == null) {
            return null;
        }
        try {
            try {
                PathClassLoader pathClassLoader = (PathClassLoader) classLoader;
                DexClassLoader dexClassLoader = (DexClassLoader) classLoader2;
                dexClassLoader.loadClass(str);
                p(pathClassLoader, PathClassLoader.class, "mPaths", b(g(pathClassLoader, PathClassLoader.class, "mPaths"), g(dexClassLoader, DexClassLoader.class, "mRawDexPath")));
                if (z) {
                    p(pathClassLoader, PathClassLoader.class, "mDexs", d(g(pathClassLoader, PathClassLoader.class, "mDexs"), g(dexClassLoader, DexClassLoader.class, "mDexs")));
                    p(pathClassLoader, PathClassLoader.class, "mFiles", d(g(pathClassLoader, PathClassLoader.class, "mFiles"), g(dexClassLoader, DexClassLoader.class, "mFiles")));
                    p(pathClassLoader, PathClassLoader.class, "mZips", d(g(pathClassLoader, PathClassLoader.class, "mZips"), g(dexClassLoader, DexClassLoader.class, "mZips")));
                } else {
                    p(pathClassLoader, PathClassLoader.class, "mDexs", d(g(dexClassLoader, DexClassLoader.class, "mDexs"), g(pathClassLoader, PathClassLoader.class, "mDexs")));
                    p(pathClassLoader, PathClassLoader.class, "mFiles", d(g(dexClassLoader, DexClassLoader.class, "mFiles"), g(pathClassLoader, PathClassLoader.class, "mFiles")));
                    p(pathClassLoader, PathClassLoader.class, "mZips", d(g(dexClassLoader, DexClassLoader.class, "mZips"), g(pathClassLoader, PathClassLoader.class, "mZips")));
                }
                try {
                    ArrayList arrayList = (ArrayList) g(pathClassLoader, PathClassLoader.class, "libraryPathElements");
                    for (String str2 : (String[]) g(dexClassLoader, DexClassLoader.class, "mLibPaths")) {
                        arrayList.add(str2);
                    }
                    Collections.sort(arrayList, new C0554a());
                } catch (Exception unused) {
                    p(pathClassLoader, PathClassLoader.class, "mLibPaths", d(g(pathClassLoader, PathClassLoader.class, "mLibPaths"), g(dexClassLoader, DexClassLoader.class, "mLibPaths")));
                }
                o = null;
            } catch (IllegalAccessException e2) {
                o = o(false, e2);
                BdLog.e(e2);
            } catch (NoSuchFieldException e3) {
                o = o(false, e3);
                BdLog.e(e3);
            }
        } catch (NoSuchFieldError e4) {
            o = o(false, e4);
            BdLog.e(e4);
        } catch (Throwable th) {
            o = o(false, th);
            BdLog.e(th);
        }
        return o == null ? o(true, null) : o;
    }

    public static c o(boolean z, Throwable th) {
        c cVar = new c();
        cVar.f42935a = z;
        cVar.f42936b = th != null ? th.getLocalizedMessage() : null;
        return cVar;
    }

    public static void p(Object obj, Class<?> cls, String str, Object obj2) throws NoSuchFieldException, NoSuchFieldError, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }
}
