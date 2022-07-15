package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.el2;
import com.repackage.gj2;
import com.repackage.p63;
import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dj2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static ExecutorService b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el2 a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ bj2 c;

        public a(el2 el2Var, JSONObject jSONObject, bj2 bj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {el2Var, jSONObject, bj2Var};
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
            this.b = jSONObject;
            this.c = bj2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            g l;
            SwanAppConfigData swanAppConfigData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ne3 ne3Var = new ne3();
                if (gw2.B(this.a)) {
                    l = gw2.c(this.a, ne3Var);
                } else {
                    l = e.l(this.a, ne3Var, this.b);
                }
                if (l == null || (swanAppConfigData = l.b) == null || swanAppConfigData.b == null) {
                    ac3 ac3Var = ne3Var.a;
                    if (ac3Var == null) {
                        ac3Var = new ac3();
                        ac3Var.k(5L);
                        ac3Var.i(20L);
                        ac3Var.f("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    i73 i73Var = new i73();
                    el2 el2Var = this.a;
                    i73Var.q(a73.n(el2Var != null ? el2Var.G() : 0));
                    i73Var.p(ac3Var);
                    i73Var.s("appjson_config_invalid");
                    i73Var.r(this.a);
                    a73.R(i73Var);
                }
                this.c.a(0, l);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static g a(el2 el2Var, ne3 ne3Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, el2Var, ne3Var)) == null) {
                File b = b(ne3Var);
                if (b == null) {
                    return null;
                }
                h03 M = h03.M();
                if (M == null) {
                    if (!dj2.N(b, e(), el2Var, ne3Var)) {
                        zz2.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").G();
                        ac3 ac3Var = new ac3();
                        ac3Var.k(5L);
                        ac3Var.i(7L);
                        ac3Var.f("小程序bundle解压失败! for debug");
                        ec3.a().f(ac3Var);
                        if (ne3Var != null && ne3Var.a == null) {
                            ne3Var.a = ac3Var;
                        }
                        return null;
                    }
                } else {
                    String q = M.e0().q("installed_debug_bundle_md5", "");
                    String b2 = lg4.b(b, false);
                    if (!TextUtils.equals(q, b2)) {
                        if (!dj2.N(b, e(), el2Var, ne3Var)) {
                            zz2.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").G();
                            ac3 ac3Var2 = new ac3();
                            ac3Var2.k(5L);
                            ac3Var2.i(7L);
                            ac3Var2.f("小程序bundle解压失败! for debug");
                            ec3.a().f(ac3Var2);
                            if (ne3Var != null && ne3Var.a == null) {
                                ne3Var.a = ac3Var2;
                            }
                            return null;
                        }
                        M.e0().B("installed_debug_bundle_md5", b2);
                    }
                }
                g gVar = new g();
                File g = g();
                File file = new File(g, "app.json");
                SwanAppConfigData b3 = t03.b(g.getAbsolutePath());
                gVar.a = g.getPath() + File.separator;
                gVar.b = b3;
                ov2.m(b3, true);
                fw2.l(b3);
                mv2.a(b3);
                hx1.k("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.a);
                return gVar;
            }
            return (g) invokeLL.objValue;
        }

        public static File b(ne3 ne3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ne3Var)) == null) {
                File c = c();
                File[] listFiles = c.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    return h(listFiles);
                }
                Context appContext = AppRuntime.getAppContext();
                zz2.g(appContext, c.getPath() + " 没有测试程序包!").G();
                ac3 ac3Var = new ac3();
                ac3Var.k(5L);
                ac3Var.i(4L);
                ac3Var.f("没有小程序包! for debug, bundle files are empty");
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
                File file = new File(zk2.d().get(0).a, "/aiapps_debug/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new File(zk2.d().get(0).a, "/aiapps_debug/").getAbsolutePath() : (String) invokeV.objValue;
        }

        public static File e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
                file.mkdirs();
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                return AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aiapps_bundle";
            }
            return (String) invokeV.objValue;
        }

        public static File g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? e() : (File) invokeV.objValue;
        }

        public static File h(File[] fileArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fileArr)) == null) {
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

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i);

        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

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
    }

    /* loaded from: classes5.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
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
            File[] listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new a());
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                if (k(str2, file.getName())) {
                    hx1.k("SwanAppBundleHelper", "#deleteLowerVersionFolder del：" + file.getAbsolutePath());
                    c84.i().d(str, file.getName());
                    jg4.j(file);
                    lq2.b(str, file.getName());
                }
            }
        }

        public static void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, null) == null) {
                jg4.L(dj2.q());
            }
        }

        public static void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            File f = f(str, false);
            if (f != null) {
                jg4.L(f);
            }
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str);
            lq2.a(str);
            jg4.L(file);
            jg4.L(new File(dj2.o(str)));
            int indexOf = str.indexOf("_dev");
            if (indexOf != -1) {
                String substring = str.substring(0, indexOf);
                jg4.L(new File(dj2.o(substring + "_dev")));
            }
        }

        @Nullable
        public static File f(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, str, z)) == null) ? g(str, z, null) : (File) invokeLZ.objValue;
        }

        @Nullable
        public static File g(@Nullable String str, boolean z, @Nullable ne3 ne3Var) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, Boolean.valueOf(z), ne3Var})) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File h = h();
                File file = new File(h, str + ".aiapps");
                if (file.exists() && file.isFile()) {
                    return file;
                }
                if (dj2.a && z) {
                    Context appContext = AppRuntime.getAppContext();
                    zz2.g(appContext, h.getPath() + " 没有小程序包!").G();
                }
                if (ne3Var != null) {
                    ac3 ac3Var = new ac3();
                    ac3Var.k(5L);
                    ac3Var.i(4L);
                    ac3Var.f("没有小程序包! for release, no such bundle file");
                    ec3.a().f(ac3Var);
                    ne3Var.a = ac3Var;
                }
                return null;
            }
            return (File) invokeCommon.objValue;
        }

        public static File h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static File i(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) ? j(str, str2, null) : (File) invokeLL.objValue;
        }

        public static File j(String str, String str2, @Nullable JSONObject jSONObject) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, str, str2, jSONObject)) == null) {
                if (c73.e(str2)) {
                    c73.f(str, str2, jSONObject);
                }
                return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
            }
            return (File) invokeLLL.objValue;
        }

        public static boolean k(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
                if (dj2.a) {
                    Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
                }
                try {
                    return a(str, str2) > 0;
                } catch (IllegalArgumentException e) {
                    if (dj2.a) {
                        Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    }
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public static g l(el2 el2Var, ne3 ne3Var, @Nullable JSONObject jSONObject) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, el2Var, ne3Var, jSONObject)) == null) {
                if (el2Var == null) {
                    return null;
                }
                File v = dj2.v(el2Var.H(), el2Var.v1(), el2Var.o0(), el2Var.h0(), jSONObject);
                if (!v.exists()) {
                    File g = g(el2Var.H(), true, ne3Var);
                    if (g == null) {
                        cx2.Q().a0(8, new SwanAppDeleteInfo(el2Var.H(), 1).setPurgerScenes(5));
                        ac3 ac3Var = new ac3();
                        ac3Var.k(5L);
                        ac3Var.i(31L);
                        ac3Var.f("小程序zip和bundle不存在，兜底重置");
                        i73 i73Var = new i73();
                        i73Var.q(a73.n(el2Var.G()));
                        i73Var.p(ac3Var);
                        i73Var.r(el2Var);
                        a73.R(i73Var);
                        if (dj2.a) {
                            Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        }
                        return null;
                    }
                    b(v);
                    if (!dj2.N(g, v, el2Var, ne3Var)) {
                        zz2.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").G();
                        ac3 ac3Var2 = new ac3();
                        ac3Var2.k(5L);
                        ac3Var2.i(7L);
                        ac3Var2.f("小程序bundle解压失败! for release");
                        ec3.a().f(ac3Var2);
                        if (ne3Var != null && ne3Var.a == null) {
                            ne3Var.a = ac3Var2;
                        }
                        return null;
                    }
                }
                c(el2Var.H(), el2Var.v1());
                g gVar = new g();
                File file = new File(v, "app.json");
                SwanAppConfigData b = t03.b(v.getAbsolutePath());
                if (b == null) {
                    return null;
                }
                gVar.a = i(el2Var.H(), el2Var.v1()).getPath() + File.separator;
                gVar.b = b;
                ov2.m(b, true);
                fw2.l(b);
                mv2.a(b);
                hx1.k("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.a);
                return gVar;
            }
            return (g) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static g a(el2 el2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, el2Var)) == null) {
                File e = e();
                xx1.g().h("unzipstart");
                dj2.M(b(), e, el2Var);
                xx1.g().h("unzipend");
                g gVar = new g();
                File file = new File(e, "app.json");
                SwanAppConfigData b = t03.b(e.getAbsolutePath());
                gVar.a = e.getPath() + File.separator;
                gVar.b = b;
                ov2.m(b, true);
                fw2.l(b);
                mv2.a(b);
                hx1.k("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.a);
                return gVar;
            }
            return (g) invokeL.objValue;
        }

        public static File b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new File(c(), "remote_debug.aiapps") : (File) invokeV.objValue;
        }

        public static File c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_remote_debug_zip";
            }
            return (String) invokeV.objValue;
        }

        public static File e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
            return (File) invokeV.objValue;
        }

        public static String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_remote_debug_folder";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class g extends aj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public SwanAppConfigData b;

        public g() {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755765563, "Lcom/repackage/dj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755765563, "Lcom/repackage/dj2;");
                return;
            }
        }
        a = rg1.a;
        b = Executors.newSingleThreadExecutor();
    }

    public static boolean A(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            boolean exists = new File(k(str, str2), "app.json").exists();
            if (!exists) {
                hx1.k("SwanAppBundleHelper", "#isAppJsonExist#1 [not exist] app.json");
            }
            return exists;
        }
        return invokeLL.booleanValue;
    }

    public static boolean B(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) ? z(p(str, str2, str3)) : invokeLLL.booleanValue;
    }

    public static boolean C(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            String g2 = zd3.g(str2);
            int lastIndexOf = g2.lastIndexOf(File.separator);
            if (lastIndexOf > 0) {
                g2 = g2.substring(0, lastIndexOf);
            }
            boolean exists = new File(str, g2).exists();
            if (a) {
                Log.d("SwanAppBundleHelper", "pagePath - " + g2 + ", isExist - " + exists);
            }
            return exists;
        }
        return invokeLL.booleanValue;
    }

    public static Pair<Boolean, Long> D(@NonNull File file) {
        InterceptResult invokeL;
        long j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            String name = file.getName();
            try {
                j = Long.parseLong(name);
                z = true;
            } catch (NumberFormatException e2) {
                hx1.l("SwanAppBundleHelper", "#parseBundleVersion ex=", e2);
                if (name.endsWith(".tmp")) {
                    hx1.k("SwanAppBundleHelper", "#parseBundleVersion deleteDir=" + file);
                    jg4.j(file);
                }
                j = Long.MAX_VALUE;
                z = false;
            }
            return Pair.create(Boolean.valueOf(z), Long.valueOf(j));
        }
        return (Pair) invokeL.objValue;
    }

    public static void E(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) {
            p63.b bVar = new p63.b(10015);
            bVar.j(str);
            bVar.l(str2);
            bVar.m();
        }
    }

    public static void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, null, z) == null) {
            v83.a().putBoolean("swanapps_has_done_fallback_strategy_key", z);
        }
    }

    public static void G(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, cVar) == null) {
            d dVar = new d();
            dVar.a = str;
            new o72().e(dVar, wa2.j().getPath(), cVar);
        }
    }

    public static void H(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, cVar) == null) {
            d dVar = new d();
            dVar.a = str;
            new o72().e(dVar, xa2.j().getPath(), cVar);
        }
    }

    public static void I(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, cVar) == null) {
            d dVar = new d();
            dVar.a = str;
            ya2.a();
            new o72().e(dVar, ya2.c().getPath(), cVar);
        }
    }

    public static void J(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, cVar) == null) {
            d dVar = new d();
            dVar.a = str;
            o93.a();
            new o72().e(dVar, o93.d().getPath(), cVar);
        }
    }

    public static void K(d dVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, dVar, cVar) == null) {
            File c2 = b.c();
            new o72().e(dVar, c2.getPath() + File.separator + System.currentTimeMillis() + ".aibundle", cVar);
        }
    }

    public static boolean L(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, file, str)) == null) {
            File file2 = new File(file, str);
            if (file2.exists()) {
                return true;
            }
            boolean mkdirs = file2.mkdirs();
            hx1.k("SwanAppBundleHelper", "#tryMkdirs del: " + file2.getAbsolutePath());
            jg4.L(file2);
            return mkdirs;
        }
        return invokeLL.booleanValue;
    }

    public static boolean M(File file, File file2, el2 el2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, file, file2, el2Var)) == null) ? N(file, file2, el2Var, null) : invokeLLL.booleanValue;
    }

    public static boolean N(File file, File file2, el2 el2Var, ne3 ne3Var) {
        InterceptResult invokeLLLL;
        boolean U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, null, file, file2, el2Var, ne3Var)) == null) {
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
                        ac3Var.f("小程序bundle解压失败! PkgType=" + i);
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
                ac3Var2.f("小程序bundle文件不存在或者空文件! ");
                if (ne3Var != null) {
                    ne3Var.a = ac3Var2;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static synchronized boolean O(@NonNull h03 h03Var) {
        InterceptResult invokeL;
        boolean P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, h03Var)) == null) {
            synchronized (dj2.class) {
                P = P(h03Var, u(h03Var));
            }
            return P;
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean P(@NonNull h03 h03Var, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, h03Var, file)) == null) {
            synchronized (dj2.class) {
                if (file != null) {
                    if (file.exists()) {
                        SwanAppConfigData b2 = zk2.b(file);
                        if (b2 != null) {
                            h03Var.G0(b2);
                        }
                        ov2.m(b2, true);
                        fw2.l(b2);
                        mv2.a(b2);
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void c(el2 el2Var, bj2 bj2Var) {
        JSONObject jSONObject;
        String I1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, el2Var, bj2Var) == null) {
            if (el2Var == null || c73.e(el2Var.v1())) {
                jSONObject = new JSONObject();
                String y = be3.y();
                if (el2Var == null) {
                    I1 = StringUtil.NULL_STRING;
                } else {
                    try {
                        I1 = el2Var.I1();
                    } catch (JSONException e2) {
                        if (a) {
                            e2.printStackTrace();
                        }
                    }
                }
                jSONObject.put("originLaunchInfo", I1);
                jSONObject.put("stackTraceBefore", y);
            } else {
                jSONObject = null;
            }
            b.execute(new a(el2Var, jSONObject, bj2Var));
        }
    }

    @WorkerThread
    public static synchronized void d(Set<String> set, Map<String, PMSAppInfo> map) {
        File[] C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, set, map) == null) {
            synchronized (dj2.class) {
                if (map != null) {
                    if (!map.isEmpty()) {
                        File o = p73.o();
                        try {
                            for (Map.Entry<String, PMSAppInfo> entry : map.entrySet()) {
                                String key = entry.getKey();
                                if (!TextUtils.isEmpty(key)) {
                                    if (set != null && set.contains(key)) {
                                        hx1.k("SwanAppBundleHelper", "删历史版本包，排除id: " + key);
                                    } else {
                                        long j = entry.getValue().versionCode;
                                        File file = new File(o, key);
                                        if (file.exists() && file.isDirectory()) {
                                            for (File file2 : jg4.C(file)) {
                                                if (file2 != null) {
                                                    Pair<Boolean, Long> D = D(file2);
                                                    if (((Boolean) D.first).booleanValue() && ((Long) D.second).longValue() < j) {
                                                        if (x(key)) {
                                                            break;
                                                        }
                                                        jg4.L(file2);
                                                        hx1.k("SwanAppBundleHelper", "删历史版本包，file=" + file2.getAbsolutePath());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            hx1.l("SwanAppBundleHelper", "#删历史版本包, ex=", e2);
                        }
                    }
                }
            }
        }
    }

    public static synchronized void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            synchronized (dj2.class) {
                if (w()) {
                    q74.b().y("SwanAppBundleHelper", "hasDoneFallbackStrategy true");
                    E(str, "repeat");
                    return;
                }
                boolean z = true;
                F(true);
                E(str, "start");
                File g2 = g();
                if (L(g2, str)) {
                    E(str, "canwrite");
                    return;
                }
                o74 b2 = q74.b();
                b2.y("SwanAppBundleHelper", "tryMkdirs fail. Base folder: " + g2.getAbsolutePath() + " child file:" + str);
                if (g2.exists()) {
                    hx1.k("SwanAppBundleHelper", "#doSwanFolderFallback del: " + g2.getAbsolutePath());
                    jg4.L(g2);
                }
                if (!g2.exists() && g2.mkdirs() && L(g2, str)) {
                    E(str, "delete");
                    return;
                }
                File h = h();
                if (h.exists() || !h.mkdirs() || !L(h, str)) {
                    z = false;
                }
                E(str, "fail:" + z);
            }
        }
    }

    @NonNull
    public static Set<String> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            LinkedHashSet<gx2> q = ix2.k().q();
            HashSet hashSet = new HashSet();
            for (gx2 gx2Var : q) {
                if (gx2Var != null) {
                    String appId = gx2Var.getAppId();
                    Set<String> M = gx2Var.M();
                    if (!TextUtils.isEmpty(appId)) {
                        hashSet.add(appId);
                        if (a) {
                            Log.d("SwanAppBundleHelper", "appId in running - " + appId);
                        }
                    }
                    if (M.size() > 0) {
                        hashSet.addAll(M);
                        if (a) {
                            Log.d("SwanAppBundleHelper", "appId in prefetch - " + M);
                        }
                    }
                }
            }
            if (a) {
                Log.d("SwanAppBundleHelper", "active apps - " + hashSet);
            }
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    public static File g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
        }
        return (File) invokeV.objValue;
    }

    public static File h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_folder_fallback");
        }
        return (File) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder";
        }
        return (String) invokeV.objValue;
    }

    public static File j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) ? new File(g(), str) : (File) invokeL.objValue;
    }

    public static File k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, str, str2)) == null) ? new File(j(str), str2) : (File) invokeLL.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_zip";
        }
        return (String) invokeV.objValue;
    }

    public static synchronized String m(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, file)) == null) {
            synchronized (dj2.class) {
                if (file == null) {
                    return "";
                }
                String path = file.getPath();
                if (a) {
                    Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
                }
                String str = (String) a72.b().a(path, "");
                if (TextUtils.isEmpty(str)) {
                    if (a) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                    }
                    String E = jg4.E(file);
                    a72.b().c(path, E);
                    if (a) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read end: " + path);
                    }
                    return E;
                }
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            return i() + File.separator + "database";
        }
        return (String) invokeV.objValue;
    }

    public static String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) {
            return n() + File.separator + str;
        }
        return (String) invokeL.objValue;
    }

    public static File p(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65568, null, str, str2, str3)) == null) ? new File(k(str, str2), zd3.g(str3)) : (File) invokeLLL.objValue;
    }

    public static File q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) ? new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace") : (File) invokeV.objValue;
    }

    public static String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_plugin_workspace";
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static File s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (a) {
                    throw new IllegalArgumentException("plugin name can't be empty");
                }
                return null;
            }
            return new File(q(), str);
        }
        return (File) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static File t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return new File(s(str), str2);
            }
            if (a) {
                throw new IllegalArgumentException("plugin name or version can't be empty");
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public static File u(@NonNull h03 h03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, h03Var)) == null) {
            if (h03Var == null) {
                return null;
            }
            el2.a W = h03Var.W();
            File v = v(h03Var.getAppId(), W.v1(), W.o0(), W.h0(), null);
            if (a) {
                Log.d("SwanAppBundleHelper", "sendLaunchEvent folderFile: " + v.getPath());
                Log.d("SwanAppBundleHelper", "sendLaunchEvent file exists: " + v.exists());
            }
            return v;
        }
        return (File) invokeL.objValue;
    }

    public static File v(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        InterceptResult invokeCommon;
        File j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65574, null, new Object[]{str, str2, Boolean.valueOf(z), str3, jSONObject})) == null) {
            if (gw2.H()) {
                j = b.e();
            } else if (gw2.D()) {
                j = ox1.d();
            } else {
                j = e.j(str, str2, jSONObject);
            }
            return (!z || TextUtils.isEmpty(str3)) ? j : new File(j, str3);
        }
        return (File) invokeCommon.objValue;
    }

    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? v83.a().getBoolean("swanapps_has_done_fallback_strategy_key", false) : invokeV.booleanValue;
    }

    public static boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65576, null, str)) == null) ? f().contains(str) : invokeL.booleanValue;
    }

    public static boolean y(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, file)) == null) {
            boolean z = false;
            if (file != null && file.exists()) {
                File file2 = new File(file, "app.js");
                boolean exists = file2.exists();
                if (!exists) {
                    hx1.k("SwanAppBundleHelper", "#isAppJsValid [not exist] app.json");
                }
                long length = exists ? file2.length() : -1L;
                if (exists && length > 0) {
                    z = true;
                }
                if (!z) {
                    i73 i73Var = new i73();
                    ac3 ac3Var = new ac3();
                    ac3Var.k(5L);
                    ac3Var.i(51L);
                    i73Var.p(ac3Var);
                    i73Var.l("path", file2.getAbsolutePath());
                    i73Var.l("appJs", "isAppJsExist =" + exists + ", appJsSize =" + length);
                    i73Var.l("stack", be3.z(30));
                    a73.R(i73Var);
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean z(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, file)) == null) {
            if (file == null || !file.exists()) {
                return false;
            }
            boolean exists = new File(file, "app.json").exists();
            if (!exists) {
                hx1.k("SwanAppBundleHelper", "#isAppJsonExist#2 [not exist] app.json");
            }
            return exists;
        }
        return invokeL.booleanValue;
    }
}
