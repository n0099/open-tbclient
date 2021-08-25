package com.bytedance.sdk.openadsdk.preload.geckox.a;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.d;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.f;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.j;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            j.a().execute(new Runnable(str) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.a.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f68495a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68495a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            c.d(this.f68495a);
                        } catch (Throwable th) {
                            com.bytedance.sdk.openadsdk.preload.geckox.utils.c.a(new RuntimeException("delete old channel version failed，path：" + this.f68495a, th));
                        }
                    }
                }
            });
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                com.bytedance.sdk.openadsdk.preload.geckox.g.a a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.a.a(str + File.separator + "update.lock");
                if (a2 == null) {
                    return true;
                }
                com.bytedance.sdk.openadsdk.preload.geckox.g.b a3 = com.bytedance.sdk.openadsdk.preload.geckox.g.b.a(str + File.separator + "select.lock");
                try {
                    d.c(new File(str));
                } catch (Throwable unused) {
                }
                a3.a();
                a2.a();
                return true;
            } catch (Throwable unused2) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void d(String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            com.bytedance.sdk.openadsdk.preload.geckox.g.a a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.a.a(str + File.separator + "update.lock");
            if (a2 == null) {
                return;
            }
            try {
                com.bytedance.sdk.openadsdk.preload.geckox.g.b a3 = com.bytedance.sdk.openadsdk.preload.geckox.g.b.a(str + File.separator + "select.lock");
                List<File> e2 = e(str);
                if (e2 != null && !e2.isEmpty()) {
                    Iterator<File> it = e2.iterator();
                    while (it.hasNext()) {
                        com.bytedance.sdk.openadsdk.preload.geckox.g.c.c(it.next().getAbsolutePath() + File.separator + "using.lock");
                    }
                    a3.a();
                    return;
                }
                a3.a();
            } finally {
                a2.a();
            }
        }
    }

    public static List<File> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            File[] listFiles = new File(str).listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.a.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, file)) == null) ? file.isDirectory() : invokeL2.booleanValue;
                }
            });
            if (listFiles == null || listFiles.length == 0 || listFiles.length == 1) {
                return null;
            }
            return a(listFiles);
        }
        return (List) invokeL.objValue;
    }

    public static List<File> a(File[] fileArr) {
        InterceptResult invokeL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fileArr)) == null) {
            ArrayList<File> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            File file = null;
            long j3 = -1;
            for (File file2 : fileArr) {
                String name = file2.getName();
                if (name.endsWith("--updating")) {
                    arrayList.add(file2);
                } else if (name.endsWith("--pending-delete")) {
                    a(file2);
                } else {
                    try {
                        long parseLong = Long.parseLong(name);
                        if (parseLong > j3) {
                            if (file != null) {
                                try {
                                    arrayList2.add(file);
                                } catch (Exception unused) {
                                    j3 = parseLong;
                                    a(file2);
                                }
                            }
                            file = file2;
                            j3 = parseLong;
                        } else {
                            arrayList2.add(file2);
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
            for (File file3 : arrayList) {
                String name2 = file3.getName();
                int indexOf = name2.indexOf("--updating");
                if (indexOf == -1) {
                    a(file3);
                } else {
                    try {
                        j2 = Long.parseLong(name2.substring(0, indexOf));
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                        j2 = -1;
                    }
                    if (j2 <= j3) {
                        a(file3);
                    }
                }
            }
            return arrayList2;
        }
        return (List) invokeL.objValue;
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, file) == null) {
            f.a().execute(new Runnable(file) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.a.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ File f68496a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {file};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68496a = file;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        d.a(this.f68496a);
                    }
                }
            });
        }
    }
}
