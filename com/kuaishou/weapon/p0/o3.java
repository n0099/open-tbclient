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
/* loaded from: classes7.dex */
public class o3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
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
                Object obj = q3.a(classLoader, "pathList").get(classLoader);
                Field a = q3.a(obj, "nativeLibraryDirectories");
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

    /* loaded from: classes7.dex */
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
                Object obj = q3.a(classLoader, "pathList").get(classLoader);
                Field a = q3.a(obj, "nativeLibraryDirectories");
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
                    q3.b(obj, "nativeLibraryDirectories").set(obj, arrayList);
                }
                List list = (List) q3.a(obj, "systemNativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size() + list.size() + 1);
                arrayList2.addAll(arrayList);
                arrayList2.addAll(list);
                Object[] objArr = (Object[]) q3.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList());
                Field a2 = q3.a(obj, "nativeLibraryPathElements");
                a2.set(obj, objArr);
                if (a2.get(obj) != objArr) {
                    q3.b(obj, "nativeLibraryPathElements").set(obj, objArr);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
                Object obj = q3.a(classLoader, "pathList").get(classLoader);
                List<File> list = (List) q3.a(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                for (File file2 : list) {
                    if (file.equals(file2)) {
                        return;
                    }
                }
                list.add(file);
                List list2 = (List) q3.a(obj, "systemNativeLibraryDirectories").get(obj);
                if (list2 == null) {
                    list2 = new ArrayList(2);
                }
                ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
                arrayList.addAll(list);
                arrayList.addAll(list2);
                q3.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) q3.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
            }
        }
    }

    /* loaded from: classes7.dex */
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
                Object obj = q3.a(classLoader, "pathList").get(classLoader);
                List<File> list = (List) q3.a(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                for (File file2 : list) {
                    if (file.equals(file2)) {
                        return;
                    }
                }
                list.add(file);
                List list2 = (List) q3.a(obj, "systemNativeLibraryDirectories").get(obj);
                if (list2 == null) {
                    list2 = new ArrayList(2);
                }
                ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
                arrayList.addAll(list);
                arrayList.addAll(list2);
                q3.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) q3.a(obj, "makePathElements", List.class).invoke(obj, arrayList));
            }
        }
    }

    /* loaded from: classes7.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, classLoader, file) == null) {
                String path = file.getPath();
                Field a = q3.a(classLoader, "libPath");
                String valueOf = String.valueOf(a.get(classLoader));
                a.set(classLoader, TextUtils.isEmpty(valueOf) ? path : valueOf + ":" + path);
                Field a2 = q3.a(classLoader, "libraryPathElements");
                List<String> list = (List) a2.get(classLoader);
                for (String str : list) {
                    if (path.equals(str)) {
                        return;
                    }
                }
                list.add(path);
                a2.set(classLoader, list);
            }
        }
    }

    public o3() {
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
            synchronized (o3.class) {
                if (file != null) {
                    if (file.exists()) {
                        if ((Build.VERSION.SDK_INT == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || (i = Build.VERSION.SDK_INT) > 25) {
                            d.b(classLoader, file);
                        } else if (i == 24) {
                            c.b(classLoader, file);
                        } else if (i >= 23) {
                            b.b(classLoader, file);
                        } else if (i >= 14) {
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
