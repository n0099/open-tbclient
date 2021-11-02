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
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void b(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
                Object obj = com.kwai.sodler.lib.ext.e.a(classLoader, "pathList").get(classLoader);
                Field a2 = com.kwai.sodler.lib.ext.e.a(obj, "nativeLibraryDirectories");
                File[] fileArr = (File[]) a2.get(obj);
                ArrayList arrayList = new ArrayList();
                for (File file2 : fileArr) {
                    if (!file.equals(file2)) {
                        arrayList.add(file2);
                    }
                }
                arrayList.add(file);
                a2.set(obj, arrayList.toArray(new File[0]));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void b(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
                Object obj = com.kwai.sodler.lib.ext.e.a(classLoader, "pathList").get(classLoader);
                Field a2 = com.kwai.sodler.lib.ext.e.a(obj, "nativeLibraryDirectories");
                Collection collection = (List) a2.get(obj);
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
                a2.set(obj, arrayList);
                if (a2.get(obj) != arrayList) {
                    com.kwai.sodler.lib.ext.e.b(obj, "nativeLibraryDirectories").set(obj, arrayList);
                }
                List list = (List) com.kwai.sodler.lib.ext.e.a(obj, "systemNativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size() + list.size() + 1);
                arrayList2.addAll(arrayList);
                arrayList2.addAll(list);
                Object[] objArr = (Object[]) com.kwai.sodler.lib.ext.e.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList());
                Field a3 = com.kwai.sodler.lib.ext.e.a(obj, "nativeLibraryPathElements");
                a3.set(obj, objArr);
                if (a3.get(obj) != objArr) {
                    com.kwai.sodler.lib.ext.e.b(obj, "nativeLibraryPathElements").set(obj, objArr);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void b(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
                Object obj = com.kwai.sodler.lib.ext.e.a(classLoader, "pathList").get(classLoader);
                List<File> list = (List) com.kwai.sodler.lib.ext.e.a(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                for (File file2 : list) {
                    if (file.equals(file2)) {
                        return;
                    }
                }
                list.add(file);
                List list2 = (List) com.kwai.sodler.lib.ext.e.a(obj, "systemNativeLibraryDirectories").get(obj);
                if (list2 == null) {
                    list2 = new ArrayList(2);
                }
                ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
                arrayList.addAll(list);
                arrayList.addAll(list2);
                com.kwai.sodler.lib.ext.e.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwai.sodler.lib.ext.e.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
            }
        }
    }

    /* renamed from: com.kwai.sodler.lib.ext.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C1948d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void b(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
                Object obj = com.kwai.sodler.lib.ext.e.a(classLoader, "pathList").get(classLoader);
                List<File> list = (List) com.kwai.sodler.lib.ext.e.a(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                for (File file2 : list) {
                    if (file.equals(file2)) {
                        return;
                    }
                }
                list.add(file);
                List list2 = (List) com.kwai.sodler.lib.ext.e.a(obj, "systemNativeLibraryDirectories").get(obj);
                if (list2 == null) {
                    list2 = new ArrayList(2);
                }
                ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
                arrayList.addAll(list);
                arrayList.addAll(list2);
                com.kwai.sodler.lib.ext.e.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwai.sodler.lib.ext.e.a(obj, "makePathElements", List.class).invoke(obj, arrayList));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void b(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
                String path = file.getPath();
                Field a2 = com.kwai.sodler.lib.ext.e.a(classLoader, "libPath");
                String valueOf = String.valueOf(a2.get(classLoader));
                a2.set(classLoader, TextUtils.isEmpty(valueOf) ? path : valueOf + ":" + path);
                Field a3 = com.kwai.sodler.lib.ext.e.a(classLoader, "libraryPathElements");
                List<String> list = (List) a3.get(classLoader);
                for (String str : list) {
                    if (path.equals(str)) {
                        return;
                    }
                }
                list.add(path);
                a3.set(classLoader, list);
            }
        }
    }

    public static synchronized void a(ClassLoader classLoader, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, classLoader, file) == null) {
            synchronized (d.class) {
                if (file != null) {
                    if (file.exists()) {
                        if ((Build.VERSION.SDK_INT == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || Build.VERSION.SDK_INT > 25) {
                            C1948d.b(classLoader, file);
                        } else if (Build.VERSION.SDK_INT == 24) {
                            c.b(classLoader, file);
                        } else if (Build.VERSION.SDK_INT >= 23) {
                            b.b(classLoader, file);
                        } else if (Build.VERSION.SDK_INT >= 14) {
                            a.b(classLoader, file);
                        } else {
                            e.b(classLoader, file);
                        }
                        return;
                    }
                }
                String.format("installNativeLibraryPath, folder %s is illegal", file);
            }
        }
    }
}
