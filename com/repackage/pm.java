package com.repackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.util.Util;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes6.dex */
public class pm {
    public static /* synthetic */ Interceptable $ic;
    public static Object a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Comparator<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) {
                if ((obj instanceof String) && (obj2 instanceof String)) {
                    return pm.d((String) obj, (String) obj2);
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) {
                if (file == null || file2 == null) {
                    return 0;
                }
                return pm.d(file.getAbsolutePath(), file2.getAbsolutePath());
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964030552, "Lcom/repackage/pm;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964030552, "Lcom/repackage/pm;");
                return;
            }
        }
        a = new Object();
    }

    public static Object b(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, obj, obj2)) == null) {
            Class<?> componentType = obj.getClass().getComponentType();
            int length = Array.getLength(obj);
            int i = length + 1;
            Object newInstance = Array.newInstance(componentType, i);
            for (int i2 = 0; i2 < i; i2++) {
                if (i2 < length) {
                    Array.set(newInstance, i2, Array.get(obj, i2));
                } else {
                    Array.set(newInstance, i2, obj2);
                }
            }
            return newInstance;
        }
        return invokeLL.objValue;
    }

    public static Object c(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, obj, obj2)) == null) {
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
                for (int i = 0; i < length2; i++) {
                    if (i < length) {
                        Array.set(newInstance, i, Array.get(obj, i));
                    } else {
                        Array.set(newInstance, i, Array.get(obj2, i - length));
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
        return invokeLL.objValue;
    }

    public static final int d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (str == null || str2 == null) {
                return 0;
            }
            return (str.contains("com.baidu.tieba") ? -1 : 0) - (str2.contains("com.baidu.tieba") ? -1 : 0);
        }
        return invokeLL.intValue;
    }

    public static Object e(Object obj) throws IllegalArgumentException, NoSuchFieldException, NoSuchFieldError, IllegalAccessException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) ? f(obj, obj.getClass(), "dexElements") : invokeL.objValue;
    }

    public static Object f(Object obj, Class<?> cls, String str) throws NoSuchFieldException, NoSuchFieldError, IllegalArgumentException, IllegalAccessException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, obj, cls, str)) == null) {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        }
        return invokeLLL.objValue;
    }

    public static Object g(Object obj) throws IllegalArgumentException, NoSuchFieldException, NoSuchFieldError, IllegalAccessException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) ? f(obj, obj.getClass(), "nativeLibraryDirectories") : invokeL.objValue;
    }

    public static Object h(Object obj) throws IllegalArgumentException, NoSuchFieldException, NoSuchFieldError, IllegalAccessException, ClassNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) ? f(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList") : invokeL.objValue;
    }

    public static final Comparator<File> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new b() : (Comparator) invokeV.objValue;
    }

    public static c j(ClassLoader classLoader, ClassLoader classLoader2, String str, boolean z, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{classLoader, classLoader2, str, Boolean.valueOf(z), str2})) == null) {
            if (classLoader == null || classLoader2 == null) {
                return null;
            }
            synchronized (a) {
                boolean z2 = true;
                try {
                    Class.forName("dalvik.system.BaseDexClassLoader");
                } catch (ClassNotFoundException unused) {
                    z2 = false;
                }
                if (!z2) {
                    return m(classLoader, classLoader2, str, z);
                }
                return l(classLoader, classLoader2, str, z, str2);
            }
        }
        return (c) invokeCommon.objValue;
    }

    public static c k(Context context, ClassLoader classLoader, String str) {
        InterceptResult invokeLLL;
        Object f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, context, classLoader, str)) == null) {
            try {
                classLoader.loadClass(str);
                if (Build.VERSION.SDK_INT <= 7) {
                    f = f(context.getApplicationContext(), Class.forName("android.app.ApplicationContext"), "mPackageInfo");
                } else {
                    f = f(f(context.getApplicationContext(), ContextWrapper.class, "mBase"), Class.forName("android.app.ContextImpl"), "mPackageInfo");
                }
                o(f, f.getClass(), "mClassLoader", classLoader);
                return n(true, null);
            } catch (IllegalAccessException e) {
                return n(false, e);
            } catch (IllegalArgumentException e2) {
                return n(false, e2);
            } catch (Throwable th) {
                return n(false, th);
            }
        }
        return (c) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c l(ClassLoader classLoader, ClassLoader classLoader2, String str, boolean z, String str2) {
        InterceptResult invokeCommon;
        c n;
        Object h;
        Object h2;
        List list;
        Object c2;
        List list2;
        Object c3;
        List list3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{classLoader, classLoader2, str, Boolean.valueOf(z), str2})) != null) {
            return (c) invokeCommon.objValue;
        }
        if (classLoader == null || classLoader2 == null) {
            return null;
        }
        try {
            DexClassLoader dexClassLoader = (DexClassLoader) classLoader2;
            dexClassLoader.loadClass(str);
            h = h((PathClassLoader) classLoader);
            h2 = h(dexClassLoader);
        } catch (ClassNotFoundException e) {
            n = n(false, e);
            BdLog.e(e);
        } catch (IllegalAccessException e2) {
            n = n(false, e2);
            BdLog.e(e2);
        } catch (IllegalArgumentException e3) {
            n = n(false, e3);
            BdLog.e(e3);
        } catch (NoSuchFieldError e4) {
            n = n(false, e4);
            BdLog.e(e4);
        } catch (NoSuchFieldException e5) {
            n = n(false, e5);
            BdLog.e(e5);
        } catch (NoSuchMethodException e6) {
            n = n(false, e6);
            BdLog.e(e6);
        } catch (SecurityException e7) {
            n = n(false, e7);
            BdLog.e(e7);
        } catch (Throwable th) {
            n = n(false, th);
            BdLog.e(th);
        }
        if (Build.VERSION.SDK_INT <= 25 && (Build.VERSION.SDK_INT != 25 || !Util.o())) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (z) {
                    c3 = c(e(h), e(h2));
                } else {
                    c3 = c(e(h2), e(h));
                }
                o(h, h.getClass(), "dexElements", c3);
                Object c4 = c(g(h), g(h2));
                if (c4 instanceof File[]) {
                    Arrays.sort((File[]) c4, i());
                    list3 = c4;
                } else {
                    boolean z2 = c4 instanceof List;
                    list3 = c4;
                    if (z2) {
                        List list4 = (List) c4;
                        Collections.sort(list4, i());
                        list3 = list4;
                    }
                }
                o(h, h.getClass(), "nativeLibraryDirectories", list3);
                ArrayList arrayList = new ArrayList((List) list3);
                arrayList.addAll((List) f(h, h.getClass(), "systemNativeLibraryDirectories"));
                Method declaredMethod = h.getClass().getDeclaredMethod("makePathElements", List.class, File.class, List.class);
                declaredMethod.setAccessible(true);
                o(h, h.getClass(), "nativeLibraryPathElements", declaredMethod.invoke(h.getClass(), arrayList, null, new ArrayList()));
            } else {
                if (z) {
                    c2 = c(e(h), e(h2));
                } else {
                    c2 = c(e(h2), e(h));
                }
                o(h, h.getClass(), "dexElements", c2);
                Object c5 = c(g(h), g(h2));
                if (c5 instanceof File[]) {
                    Arrays.sort((File[]) c5, i());
                    list2 = c5;
                } else {
                    boolean z3 = c5 instanceof List;
                    list2 = c5;
                    if (z3) {
                        List list5 = (List) c5;
                        Collections.sort(list5, i());
                        list2 = list5;
                    }
                }
                o(h, h.getClass(), "nativeLibraryDirectories", list2);
            }
            n = null;
            return n != null ? n(true, null) : n;
        }
        Method declaredMethod2 = h.getClass().getDeclaredMethod("addDexPath", String.class, File.class);
        declaredMethod2.setAccessible(true);
        declaredMethod2.invoke(h, str2, null);
        Object c6 = c(g(h), g(h2));
        if (c6 instanceof File[]) {
            Arrays.sort((File[]) c6, i());
            list = c6;
        } else {
            boolean z4 = c6 instanceof List;
            list = c6;
            if (z4) {
                List list6 = (List) c6;
                Collections.sort(list6, i());
                list = list6;
            }
        }
        o(h, h.getClass(), "nativeLibraryDirectories", list);
        ArrayList arrayList2 = new ArrayList((List) list);
        arrayList2.addAll((List) f(h, h.getClass(), "systemNativeLibraryDirectories"));
        Method declaredMethod3 = h.getClass().getDeclaredMethod("makePathElements", List.class);
        declaredMethod3.setAccessible(true);
        o(h, h.getClass(), "nativeLibraryPathElements", declaredMethod3.invoke(h.getClass(), arrayList2));
        n = null;
        if (n != null) {
        }
    }

    public static c m(ClassLoader classLoader, ClassLoader classLoader2, String str, boolean z) {
        InterceptResult invokeCommon;
        c n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{classLoader, classLoader2, str, Boolean.valueOf(z)})) == null) {
            if (classLoader == null || classLoader2 == null) {
                return null;
            }
            try {
                try {
                    PathClassLoader pathClassLoader = (PathClassLoader) classLoader;
                    DexClassLoader dexClassLoader = (DexClassLoader) classLoader2;
                    dexClassLoader.loadClass(str);
                    o(pathClassLoader, PathClassLoader.class, "mPaths", b(f(pathClassLoader, PathClassLoader.class, "mPaths"), f(dexClassLoader, DexClassLoader.class, "mRawDexPath")));
                    if (z) {
                        o(pathClassLoader, PathClassLoader.class, "mDexs", c(f(pathClassLoader, PathClassLoader.class, "mDexs"), f(dexClassLoader, DexClassLoader.class, "mDexs")));
                        o(pathClassLoader, PathClassLoader.class, "mFiles", c(f(pathClassLoader, PathClassLoader.class, "mFiles"), f(dexClassLoader, DexClassLoader.class, "mFiles")));
                        o(pathClassLoader, PathClassLoader.class, "mZips", c(f(pathClassLoader, PathClassLoader.class, "mZips"), f(dexClassLoader, DexClassLoader.class, "mZips")));
                    } else {
                        o(pathClassLoader, PathClassLoader.class, "mDexs", c(f(dexClassLoader, DexClassLoader.class, "mDexs"), f(pathClassLoader, PathClassLoader.class, "mDexs")));
                        o(pathClassLoader, PathClassLoader.class, "mFiles", c(f(dexClassLoader, DexClassLoader.class, "mFiles"), f(pathClassLoader, PathClassLoader.class, "mFiles")));
                        o(pathClassLoader, PathClassLoader.class, "mZips", c(f(dexClassLoader, DexClassLoader.class, "mZips"), f(pathClassLoader, PathClassLoader.class, "mZips")));
                    }
                    try {
                        ArrayList arrayList = (ArrayList) f(pathClassLoader, PathClassLoader.class, "libraryPathElements");
                        for (String str2 : (String[]) f(dexClassLoader, DexClassLoader.class, "mLibPaths")) {
                            arrayList.add(str2);
                        }
                        Collections.sort(arrayList, new a());
                    } catch (Exception unused) {
                        o(pathClassLoader, PathClassLoader.class, "mLibPaths", c(f(pathClassLoader, PathClassLoader.class, "mLibPaths"), f(dexClassLoader, DexClassLoader.class, "mLibPaths")));
                    }
                    n = null;
                } catch (NoSuchFieldError e) {
                    n = n(false, e);
                    BdLog.e(e);
                } catch (Throwable th) {
                    n = n(false, th);
                    BdLog.e(th);
                }
            } catch (IllegalAccessException e2) {
                n = n(false, e2);
                BdLog.e(e2);
            } catch (NoSuchFieldException e3) {
                n = n(false, e3);
                BdLog.e(e3);
            }
            return n == null ? n(true, null) : n;
        }
        return (c) invokeCommon.objValue;
    }

    public static c n(boolean z, Throwable th) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65550, null, z, th)) == null) {
            c cVar = new c();
            cVar.a = z;
            cVar.b = th != null ? th.getLocalizedMessage() : null;
            return cVar;
        }
        return (c) invokeZL.objValue;
    }

    public static void o(Object obj, Class<?> cls, String str, Object obj2) throws NoSuchFieldException, NoSuchFieldError, IllegalArgumentException, IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, obj, cls, str, obj2) == null) {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        }
    }
}
