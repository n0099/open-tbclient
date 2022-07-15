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
/* renamed from: com.kuaishou.weapon.p0.ʽﹳ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0384 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kuaishou.weapon.p0.ʽﹳ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static final class C0385 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0385() {
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

        /* renamed from: ʼ  reason: contains not printable characters */
        public static void m469(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, classLoader, file) == null) {
                Object obj = C0391.m488(classLoader, "pathList").get(classLoader);
                Field m488 = C0391.m488(obj, "nativeLibraryDirectories");
                File[] fileArr = (File[]) m488.get(obj);
                ArrayList arrayList = new ArrayList();
                for (File file2 : fileArr) {
                    if (!file.equals(file2)) {
                        arrayList.add(file2);
                    }
                }
                arrayList.add(file);
                m488.set(obj, arrayList.toArray(new File[0]));
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.ʽﹳ$ʼ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static final class C0386 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0386() {
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

        /* renamed from: ʼ  reason: contains not printable characters */
        public static void m471(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, classLoader, file) == null) {
                Object obj = C0391.m488(classLoader, "pathList").get(classLoader);
                Field m488 = C0391.m488(obj, "nativeLibraryDirectories");
                Collection collection = (List) m488.get(obj);
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
                m488.set(obj, arrayList);
                if (m488.get(obj) != arrayList) {
                    C0391.m490(obj, "nativeLibraryDirectories").set(obj, arrayList);
                }
                List list = (List) C0391.m488(obj, "systemNativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size() + list.size() + 1);
                arrayList2.addAll(arrayList);
                arrayList2.addAll(list);
                Object[] objArr = (Object[]) C0391.m489(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList());
                Field m4882 = C0391.m488(obj, "nativeLibraryPathElements");
                m4882.set(obj, objArr);
                if (m4882.get(obj) != objArr) {
                    C0391.m490(obj, "nativeLibraryPathElements").set(obj, objArr);
                }
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.ʽﹳ$ʽ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static final class C0387 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0387() {
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

        /* renamed from: ʼ  reason: contains not printable characters */
        public static void m473(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, classLoader, file) == null) {
                Object obj = C0391.m488(classLoader, "pathList").get(classLoader);
                List<File> list = (List) C0391.m488(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                for (File file2 : list) {
                    if (file.equals(file2)) {
                        return;
                    }
                }
                list.add(file);
                List list2 = (List) C0391.m488(obj, "systemNativeLibraryDirectories").get(obj);
                if (list2 == null) {
                    list2 = new ArrayList(2);
                }
                ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
                arrayList.addAll(list);
                arrayList.addAll(list2);
                C0391.m488(obj, "nativeLibraryPathElements").set(obj, (Object[]) C0391.m489(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.ʽﹳ$ʾ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static final class C0388 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0388() {
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

        /* renamed from: ʼ  reason: contains not printable characters */
        public static void m475(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, classLoader, file) == null) {
                Object obj = C0391.m488(classLoader, "pathList").get(classLoader);
                List<File> list = (List) C0391.m488(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    list = new ArrayList(2);
                }
                for (File file2 : list) {
                    if (file.equals(file2)) {
                        return;
                    }
                }
                list.add(file);
                List list2 = (List) C0391.m488(obj, "systemNativeLibraryDirectories").get(obj);
                if (list2 == null) {
                    list2 = new ArrayList(2);
                }
                ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
                arrayList.addAll(list);
                arrayList.addAll(list2);
                C0391.m488(obj, "nativeLibraryPathElements").set(obj, (Object[]) C0391.m489(obj, "makePathElements", List.class).invoke(obj, arrayList));
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.ʽﹳ$ʿ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static final class C0389 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0389() {
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

        /* renamed from: ʼ  reason: contains not printable characters */
        public static void m477(ClassLoader classLoader, File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, classLoader, file) == null) {
                String path = file.getPath();
                Field m488 = C0391.m488(classLoader, "libPath");
                String valueOf = String.valueOf(m488.get(classLoader));
                m488.set(classLoader, TextUtils.isEmpty(valueOf) ? path : valueOf + ":" + path);
                Field m4882 = C0391.m488(classLoader, "libraryPathElements");
                List<String> list = (List) m4882.get(classLoader);
                for (String str : list) {
                    if (path.equals(str)) {
                        return;
                    }
                }
                list.add(path);
                m4882.set(classLoader, list);
            }
        }
    }

    public C0384() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static synchronized void m467(ClassLoader classLoader, File file) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, file) == null) {
            synchronized (C0384.class) {
                if (file != null) {
                    if (file.exists()) {
                        if ((Build.VERSION.SDK_INT == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || (i = Build.VERSION.SDK_INT) > 25) {
                            C0388.m475(classLoader, file);
                        } else if (i == 24) {
                            C0387.m473(classLoader, file);
                        } else if (i >= 23) {
                            C0386.m471(classLoader, file);
                        } else if (i >= 14) {
                            C0385.m469(classLoader, file);
                        } else {
                            C0389.m477(classLoader, file);
                        }
                    }
                }
            }
        }
    }
}
