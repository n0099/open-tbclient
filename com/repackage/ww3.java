package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dj2;
import com.repackage.gj2;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class ww3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static ExecutorService b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el2 a;
        public final /* synthetic */ bj2 b;

        public a(el2 el2Var, bj2 bj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {el2Var, bj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = el2Var;
            this.b = bj2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            c j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ne3 ne3Var = new ne3();
                if (this.a.n0() && (gw2.x() || ww3.a)) {
                    j = b.a(this.a, ne3Var);
                } else {
                    j = d.j(this.a, ne3Var);
                }
                this.b.a(0, j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static c a(el2 el2Var, ne3 ne3Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, el2Var, ne3Var)) == null) {
                File b = b(ne3Var);
                if (b == null) {
                    return null;
                }
                h03 M = h03.M();
                String b2 = lg4.b(b, false);
                File d = d(b2);
                if (M == null) {
                    if (!ww3.i(b, d, el2Var, ne3Var)) {
                        zz2.g(AppRuntime.getAppContext(), "小游戏bundle解压失败!").G();
                        ac3 ac3Var = new ac3();
                        ac3Var.k(5L);
                        ac3Var.i(7L);
                        ac3Var.f("小游戏bundle解压失败! for debug");
                        ec3.a().f(ac3Var);
                        if (ne3Var != null && ne3Var.a == null) {
                            ne3Var.a = ac3Var;
                        }
                        return null;
                    }
                } else if (!TextUtils.equals(M.e0().q("installed_debug_game_bundle_md5", ""), b2)) {
                    if (!ww3.i(b, d, el2Var, ne3Var)) {
                        zz2.g(AppRuntime.getAppContext(), "小游戏bundle解压失败!").G();
                        ac3 ac3Var2 = new ac3();
                        ac3Var2.k(5L);
                        ac3Var2.i(7L);
                        ac3Var2.f("小游戏bundle解压失败! for debug");
                        ec3.a().f(ac3Var2);
                        if (ne3Var != null && ne3Var.a == null) {
                            ne3Var.a = ac3Var2;
                        }
                        return null;
                    }
                    M.e0().B("installed_debug_game_bundle_md5", b2);
                }
                c cVar = new c();
                File file = new File(d, "game.json");
                a04 a = a04.a(jg4.E(file));
                if (a == null) {
                    return null;
                }
                cVar.a = d.getPath() + File.separator;
                cVar.c = a;
                if (!TextUtils.isEmpty(a.e)) {
                    cVar.b = cVar.a + a.e + File.separator;
                    rz3.a().d(true);
                    rz3.a().e(cVar.b);
                    rz3.a().f(a.e);
                } else {
                    rz3.a().d(false);
                }
                if (ww3.a) {
                    Log.d("SwanGameBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanGameBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanGameBundleHelper", "info.appBundlePath path: " + cVar.a);
                    Log.d("SwanGameBundleHelper", "info.mAppOpenDataBundle path: " + cVar.b);
                }
                return cVar;
            }
            return (c) invokeLL.objValue;
        }

        public static File b(ne3 ne3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ne3Var)) == null) {
                File c = c();
                File[] listFiles = c.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    return e(listFiles);
                }
                Context appContext = AppRuntime.getAppContext();
                zz2.g(appContext, c.getPath() + " 没有测试程序包!").G();
                ac3 ac3Var = new ac3();
                ac3Var.k(5L);
                ac3Var.i(4L);
                ac3Var.f("没有小游戏包! for debug, bundle files are empty");
                ec3.a().f(ac3Var);
                if (ne3Var != null) {
                    ne3Var.a = ac3Var;
                    return null;
                }
                return null;
            }
            return (File) invokeL.objValue;
        }

        public static File c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                File e = ww3.e("aigames_debug");
                if (!e.exists()) {
                    e.mkdirs();
                }
                return e;
            }
            return (File) invokeV.objValue;
        }

        public static File d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
                file.mkdirs();
                return file;
            }
            return (File) invokeL.objValue;
        }

        public static File e(File[] fileArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fileArr)) == null) {
                File file = null;
                for (File file2 : fileArr) {
                    if (file == null || file2.lastModified() > file.lastModified()) {
                        file = file2;
                    }
                }
                return file;
            }
            return (File) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends aj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public a04 c;

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

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public static class a implements FileFilter {
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

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? file.isDirectory() && TextUtils.isDigitsOnly(file.getName()) : invokeL.booleanValue;
            }
        }

        @SuppressLint({"BDThrowableCheck"})
        public static long a(String str, String str2) throws IllegalArgumentException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (TextUtils.isDigitsOnly(str) && TextUtils.isDigitsOnly(str2)) {
                        return Long.parseLong(str) - Long.parseLong(str2);
                    }
                    throw new IllegalArgumentException("version is not digits only");
                }
                throw new IllegalArgumentException("version null");
            }
            return invokeLL.longValue;
        }

        public static File b(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeL.objValue;
        }

        public static void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            File[] listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new a());
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                if (i(str2, file.getName())) {
                    if (ww3.a) {
                        Log.i("SwanGameBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                    }
                    c84.i().d(str, file.getName());
                    jg4.j(file);
                }
            }
        }

        public static void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            File e = e(str, false);
            if (e != null) {
                jg4.L(e);
            }
            jg4.L(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
        }

        @Nullable
        public static File e(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, z)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return f(str, z, null);
            }
            return (File) invokeLZ.objValue;
        }

        public static File f(String str, boolean z, ne3 ne3Var) {
            InterceptResult invokeCommon;
            File g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{str, Boolean.valueOf(z), ne3Var})) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File[] listFiles = g().listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    if (ww3.a && z) {
                        zz2.g(AppRuntime.getAppContext(), g.getPath() + " 没有小游戏包!").G();
                    }
                    ac3 ac3Var = new ac3();
                    ac3Var.k(5L);
                    ac3Var.i(4L);
                    ac3Var.f("没有小游戏包! for release, bundle files are empty");
                    ec3.a().f(ac3Var);
                    if (ne3Var != null) {
                        ne3Var.a = ac3Var;
                    }
                    return null;
                }
                for (File file : listFiles) {
                    if (TextUtils.equals(file.getName(), str + ".aigames")) {
                        return file;
                    }
                }
                if (ww3.a && z) {
                    zz2.g(AppRuntime.getAppContext(), g.getPath() + " 没有小游戏包!").G();
                }
                ac3 ac3Var2 = new ac3();
                ac3Var2.k(5L);
                ac3Var2.i(4L);
                ac3Var2.f("没有小游戏包! for release, no such bundle file");
                ec3.a().f(ac3Var2);
                if (ne3Var != null) {
                    ne3Var.a = ac3Var2;
                }
                return null;
            }
            return (File) invokeCommon.objValue;
        }

        public static File g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static File h(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
                return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
            }
            return (File) invokeLL.objValue;
        }

        public static boolean i(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
                if (ww3.a) {
                    Log.i("SwanGameBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
                }
                try {
                    return a(str, str2) > 0;
                } catch (IllegalArgumentException e) {
                    if (ww3.a) {
                        Log.e("SwanGameBundleHelper", "比较版本号Exception：" + e.getMessage());
                    }
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public static c j(el2 el2Var, ne3 ne3Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, el2Var, ne3Var)) == null) {
                if (el2Var == null) {
                    return null;
                }
                File h = h(el2Var.H(), el2Var.v1());
                if (!h.exists()) {
                    File f = f(el2Var.H(), true, ne3Var);
                    if (f == null) {
                        cx2.Q().a0(8, new SwanAppDeleteInfo(el2Var.H(), 1).setPurgerScenes(5));
                        return null;
                    }
                    b(h);
                    if (!ww3.i(f, h, el2Var, ne3Var)) {
                        zz2.g(AppRuntime.getAppContext(), "小游戏bundle解压失败!").G();
                        ac3 ac3Var = new ac3();
                        ac3Var.k(5L);
                        ac3Var.i(7L);
                        ac3Var.f("小游戏bundle解压失败! for release");
                        ec3.a().f(ac3Var);
                        if (ne3Var != null && ne3Var.a == null) {
                            ne3Var.a = ac3Var;
                        }
                        return null;
                    }
                }
                c(el2Var.H(), el2Var.v1());
                c cVar = new c();
                File file = new File(h, "game.json");
                a04 a2 = a04.a(jg4.E(file));
                if (a2 == null) {
                    return null;
                }
                cVar.a = h.getPath() + File.separator;
                cVar.c = a2;
                if (!TextUtils.isEmpty(a2.e)) {
                    cVar.b = cVar.a + File.separator + a2.e + File.separator;
                    rz3.a().d(true);
                    rz3.a().e(cVar.b);
                    rz3.a().f(a2.e);
                } else {
                    rz3.a().d(false);
                }
                if (ww3.a) {
                    Log.d("SwanGameBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanGameBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanGameBundleHelper", "info.appBundlePath path: " + cVar.a);
                    Log.d("SwanGameBundleHelper", "info.mAppOpenDataBundle path: " + cVar.b);
                }
                return cVar;
            }
            return (c) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755187010, "Lcom/repackage/ww3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755187010, "Lcom/repackage/ww3;");
                return;
            }
        }
        a = rg1.a;
        b = Executors.newSingleThreadExecutor();
    }

    public static void c(el2 el2Var, bj2 bj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, el2Var, bj2Var) == null) {
            b.execute(new a(el2Var, bj2Var));
        }
    }

    public static File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
        }
        return (File) invokeV.objValue;
    }

    public static File e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
            return TextUtils.isEmpty(str) ? file : new File(file, str);
        }
        return (File) invokeL.objValue;
    }

    public static void f(String str, dj2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, cVar) == null) {
            dj2.d dVar = new dj2.d();
            dVar.a = str;
            vv3.a();
            new o72().e(dVar, vv3.c().getPath(), cVar);
        }
    }

    public static void g(String str, dj2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, cVar) == null) {
            dj2.d dVar = new dj2.d();
            dVar.a = str;
            kw3.a();
            new o72().e(dVar, kw3.c().getPath(), cVar);
        }
    }

    public static void h(dj2.d dVar, dj2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, dVar, cVar) == null) {
            File c2 = b.c();
            new o72().e(dVar, c2.getPath() + File.separator + System.currentTimeMillis() + ".aibundle", cVar);
        }
    }

    public static boolean i(File file, File file2, el2 el2Var, ne3 ne3Var) {
        InterceptResult invokeLLLL;
        boolean U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, file, file2, el2Var, ne3Var)) == null) {
            int i = 0;
            if (file != null && file2 != null) {
                if (file.exists() && file.length() != 0) {
                    mt2.o().F(new UbcFlowEvent("package_start_unzip"));
                    long currentTimeMillis = System.currentTimeMillis();
                    gj2.c j = gj2.j(file);
                    int i2 = j.b;
                    if (i2 != -1) {
                        U = gj2.d(j.a, file2, i2).a;
                        i = j.b;
                    } else {
                        U = jg4.U(file.getPath(), file2.getPath());
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (a) {
                        gj2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (!U) {
                        ac3 ac3Var = new ac3();
                        ac3Var.k(5L);
                        ac3Var.i(7L);
                        ac3Var.f("小游戏bundle解压失败! PkgType=" + i);
                        if (ne3Var != null) {
                            ne3Var.a = ac3Var;
                        }
                    }
                    HybridUbcFlow o = mt2.o();
                    o.F(new UbcFlowEvent("package_end_unzip"));
                    o.D("app_package_version", String.valueOf(i));
                    return U;
                }
                ac3 ac3Var2 = new ac3();
                ac3Var2.k(5L);
                ac3Var2.i(4L);
                ac3Var2.f("小游戏bundle文件不存在或者空文件! ");
                if (ne3Var != null) {
                    ne3Var.a = ac3Var2;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
