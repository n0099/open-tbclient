package com.kuaishou.weapon.p0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@SuppressLint({"LongLogTag"})
/* renamed from: com.kuaishou.weapon.p0.do  reason: invalid class name */
/* loaded from: classes10.dex */
public class Cdo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kuaishou.weapon.p0.do$a */
    /* loaded from: classes10.dex */
    public static final class a {
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

        public static void b(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, classLoader, file) == null) {
                Object obj = dq.a(classLoader, "pathList").get(classLoader);
                Field a = dq.a(obj, "nativeLibraryDirectories");
                File[] fileArr = (File[]) a.get(obj);
                ArrayList arrayList = new ArrayList();
                for (File file2 : fileArr) {
                    if (!file.equals(file2)) {
                        arrayList.add(file2);
                    }
                }
                arrayList.add(file);
                a.set(obj, arrayList.toArray(new File[0]));
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$b */
    /* loaded from: classes10.dex */
    public static final class b {
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

        public static void b(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, classLoader, file) == null) {
                Object obj = dq.a(classLoader, "pathList").get(classLoader);
                Field a = dq.a(obj, "nativeLibraryDirectories");
                Collection collection = (List) a.get(obj);
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
                a.set(obj, arrayList);
                if (a.get(obj) != arrayList) {
                    dq.b(obj, "nativeLibraryDirectories").set(obj, arrayList);
                }
                List list = (List) dq.a(obj, "systemNativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size() + list.size() + 1);
                arrayList2.addAll(arrayList);
                arrayList2.addAll(list);
                Object[] objArr = (Object[]) dq.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList());
                Field a2 = dq.a(obj, "nativeLibraryPathElements");
                a2.set(obj, objArr);
                if (a2.get(obj) != objArr) {
                    dq.b(obj, "nativeLibraryPathElements").set(obj, objArr);
                }
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$c */
    /* loaded from: classes10.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public static void b(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, classLoader, file) == null) {
                Object obj = dq.a(classLoader, "pathList").get(classLoader);
                List<File> list = (List) dq.a(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                for (File file2 : list) {
                    if (file.equals(file2)) {
                        return;
                    }
                }
                list.add(file);
                List list2 = (List) dq.a(obj, "systemNativeLibraryDirectories").get(obj);
                if (list2 == null) {
                    list2 = new ArrayList(2);
                }
                ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
                arrayList.addAll(list);
                arrayList.addAll(list2);
                dq.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) dq.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$d */
    /* loaded from: classes10.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        public static void b(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, classLoader, file) == null) {
                Object obj = dq.a(classLoader, "pathList").get(classLoader);
                List<File> list = (List) dq.a(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                for (File file2 : list) {
                    if (file.equals(file2)) {
                        return;
                    }
                }
                list.add(file);
                List list2 = (List) dq.a(obj, "systemNativeLibraryDirectories").get(obj);
                if (list2 == null) {
                    list2 = new ArrayList(2);
                }
                ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
                arrayList.addAll(list);
                arrayList.addAll(list2);
                dq.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) dq.a(obj, "makePathElements", List.class).invoke(obj, arrayList));
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$e */
    /* loaded from: classes10.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        public static void b(ClassLoader classLoader, File file) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, classLoader, file) == null) {
                String path = file.getPath();
                Field a = dq.a(classLoader, "libPath");
                String valueOf = String.valueOf(a.get(classLoader));
                if (!TextUtils.isEmpty(valueOf)) {
                    str = valueOf + ":" + path;
                } else {
                    str = path;
                }
                a.set(classLoader, str);
                Field a2 = dq.a(classLoader, "libraryPathElements");
                List<String> list = (List) a2.get(classLoader);
                for (String str2 : list) {
                    if (path.equals(str2)) {
                        return;
                    }
                }
                list.add(path);
                a2.set(classLoader, list);
            }
        }
    }

    public Cdo() {
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

    public static synchronized void a(ClassLoader classLoader, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
            synchronized (Cdo.class) {
                if (file != null) {
                    if (file.exists()) {
                        if ((Build.VERSION.SDK_INT == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || Build.VERSION.SDK_INT > 25) {
                            d.b(classLoader, file);
                        } else if (Build.VERSION.SDK_INT == 24) {
                            c.b(classLoader, file);
                        } else if (Build.VERSION.SDK_INT >= 23) {
                            b.b(classLoader, file);
                        } else if (Build.VERSION.SDK_INT >= 14) {
                            a.b(classLoader, file);
                        } else {
                            e.b(classLoader, file);
                        }
                    }
                }
            }
        }
    }
}
