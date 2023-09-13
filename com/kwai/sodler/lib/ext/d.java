package com.kwai.sodler.lib.ext;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@SuppressLint({"LongLogTag"})
/* loaded from: classes10.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void d(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, classLoader, file) == null) {
                Object obj = com.kwai.sodler.lib.ext.e.f(classLoader, "pathList").get(classLoader);
                Field f = com.kwai.sodler.lib.ext.e.f(obj, "nativeLibraryDirectories");
                File[] fileArr = (File[]) f.get(obj);
                ArrayList arrayList = new ArrayList();
                for (File file2 : fileArr) {
                    if (!file.equals(file2)) {
                        arrayList.add(file2);
                    }
                }
                arrayList.add(file);
                f.set(obj, arrayList.toArray(new File[0]));
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void d(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, classLoader, file) == null) {
                Object obj = com.kwai.sodler.lib.ext.e.f(classLoader, "pathList").get(classLoader);
                Field f = com.kwai.sodler.lib.ext.e.f(obj, "nativeLibraryDirectories");
                Collection collection = (List) f.get(obj);
                if (collection == null) {
                    collection = new ArrayList(2);
                }
                ArrayList<File> arrayList = new ArrayList(collection);
                for (File file2 : arrayList) {
                    if (file.equals(file2)) {
                        return;
                    }
                }
                arrayList.add(file);
                f.set(obj, arrayList);
                if (f.get(obj) != arrayList) {
                    com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryDirectories").set(obj, arrayList);
                }
                List list = (List) com.kwai.sodler.lib.ext.e.f(obj, "systemNativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size() + list.size() + 1);
                arrayList2.addAll(arrayList);
                arrayList2.addAll(list);
                Object[] objArr = (Object[]) com.kwai.sodler.lib.ext.e.b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList());
                Field f2 = com.kwai.sodler.lib.ext.e.f(obj, "nativeLibraryPathElements");
                f2.set(obj, objArr);
                if (f2.get(obj) != objArr) {
                    com.kwai.sodler.lib.ext.e.g(obj, "nativeLibraryPathElements").set(obj, objArr);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void d(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, classLoader, file) == null) {
                Object obj = com.kwai.sodler.lib.ext.e.f(classLoader, "pathList").get(classLoader);
                List<File> list = (List) com.kwai.sodler.lib.ext.e.f(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                for (File file2 : list) {
                    if (file.equals(file2)) {
                        return;
                    }
                }
                list.add(file);
                List list2 = (List) com.kwai.sodler.lib.ext.e.f(obj, "systemNativeLibraryDirectories").get(obj);
                if (list2 == null) {
                    list2 = new ArrayList(2);
                }
                ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
                arrayList.addAll(list);
                arrayList.addAll(list2);
                com.kwai.sodler.lib.ext.e.f(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwai.sodler.lib.ext.e.b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
            }
        }
    }

    /* renamed from: com.kwai.sodler.lib.ext.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0707d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void d(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, classLoader, file) == null) {
                Object obj = com.kwai.sodler.lib.ext.e.f(classLoader, "pathList").get(classLoader);
                List<File> list = (List) com.kwai.sodler.lib.ext.e.f(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                for (File file2 : list) {
                    if (file.equals(file2)) {
                        return;
                    }
                }
                list.add(file);
                List list2 = (List) com.kwai.sodler.lib.ext.e.f(obj, "systemNativeLibraryDirectories").get(obj);
                if (list2 == null) {
                    list2 = new ArrayList(2);
                }
                ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
                arrayList.addAll(list);
                arrayList.addAll(list2);
                com.kwai.sodler.lib.ext.e.f(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwai.sodler.lib.ext.e.b(obj, "makePathElements", List.class).invoke(obj, arrayList));
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void d(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, classLoader, file) == null) {
                String path = file.getPath();
                Field f = com.kwai.sodler.lib.ext.e.f(classLoader, "libPath");
                String valueOf = String.valueOf(f.get(classLoader));
                f.set(classLoader, TextUtils.isEmpty(valueOf) ? path : valueOf + ":" + path);
                Field f2 = com.kwai.sodler.lib.ext.e.f(classLoader, "libraryPathElements");
                List<String> list = (List) f2.get(classLoader);
                for (String str : list) {
                    if (path.equals(str)) {
                        return;
                    }
                }
                list.add(path);
                f2.set(classLoader, list);
            }
        }
    }

    public static synchronized void c(ClassLoader classLoader, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, classLoader, file) == null) {
            synchronized (d.class) {
                if (file != null) {
                    if (file.exists()) {
                        if ((Build.VERSION.SDK_INT == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || Build.VERSION.SDK_INT > 25) {
                            C0707d.d(classLoader, file);
                            return;
                        } else if (Build.VERSION.SDK_INT == 24) {
                            c.d(classLoader, file);
                            return;
                        } else if (Build.VERSION.SDK_INT >= 23) {
                            b.d(classLoader, file);
                            return;
                        } else if (Build.VERSION.SDK_INT >= 14) {
                            a.d(classLoader, file);
                            return;
                        } else {
                            e.d(classLoader, file);
                            return;
                        }
                    }
                }
                com.kwai.sodler.lib.a.e("Sodler.ShareLibraryLoader", String.format("installNativeLibraryPath, folder %s is illegal", file));
            }
        }
    }
}
