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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
import com.repackage.c73;
import com.repackage.rl2;
import com.repackage.tj2;
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
/* loaded from: classes6.dex */
public class qj2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static ExecutorService b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl2 a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ oj2 c;

        public a(rl2 rl2Var, JSONObject jSONObject, oj2 oj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl2Var, jSONObject, oj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl2Var;
            this.b = jSONObject;
            this.c = oj2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            g l;
            SwanAppConfigData swanAppConfigData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                af3 af3Var = new af3();
                if (tw2.B(this.a)) {
                    l = tw2.c(this.a, af3Var);
                } else {
                    l = e.l(this.a, af3Var, this.b);
                }
                if (l == null || (swanAppConfigData = l.b) == null || swanAppConfigData.b == null) {
                    nc3 nc3Var = af3Var.a;
                    if (nc3Var == null) {
                        nc3Var = new nc3();
                        nc3Var.k(5L);
                        nc3Var.i(20L);
                        nc3Var.f("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    v73 v73Var = new v73();
                    rl2 rl2Var = this.a;
                    v73Var.q(n73.n(rl2Var != null ? rl2Var.G() : 0));
                    v73Var.p(nc3Var);
                    v73Var.s("appjson_config_invalid");
                    v73Var.r(this.a);
                    n73.R(v73Var);
                }
                this.c.a(0, l);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static g a(rl2 rl2Var, af3 af3Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, rl2Var, af3Var)) == null) {
                File b = b(af3Var);
                if (b == null) {
                    return null;
                }
                u03 L = u03.L();
                if (L == null) {
                    if (!qj2.N(b, e(), rl2Var, af3Var)) {
                        m03.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").G();
                        nc3 nc3Var = new nc3();
                        nc3Var.k(5L);
                        nc3Var.i(7L);
                        nc3Var.f("小程序bundle解压失败! for debug");
                        rc3.a().f(nc3Var);
                        if (af3Var != null && af3Var.a == null) {
                            af3Var.a = nc3Var;
                        }
                        return null;
                    }
                } else {
                    String q = L.d0().q("installed_debug_bundle_md5", "");
                    String b2 = zg4.b(b, false);
                    if (!TextUtils.equals(q, b2)) {
                        if (!qj2.N(b, e(), rl2Var, af3Var)) {
                            m03.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").G();
                            nc3 nc3Var2 = new nc3();
                            nc3Var2.k(5L);
                            nc3Var2.i(7L);
                            nc3Var2.f("小程序bundle解压失败! for debug");
                            rc3.a().f(nc3Var2);
                            if (af3Var != null && af3Var.a == null) {
                                af3Var.a = nc3Var2;
                            }
                            return null;
                        }
                        L.d0().B("installed_debug_bundle_md5", b2);
                    }
                }
                g gVar = new g();
                File g = g();
                File file = new File(g, "app.json");
                SwanAppConfigData b3 = g13.b(g.getAbsolutePath());
                gVar.a = g.getPath() + File.separator;
                gVar.b = b3;
                bw2.m(b3, true);
                sw2.l(b3);
                zv2.a(b3);
                ux1.k("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.a);
                return gVar;
            }
            return (g) invokeLL.objValue;
        }

        public static File b(af3 af3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, af3Var)) == null) {
                File c = c();
                File[] listFiles = c.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    return h(listFiles);
                }
                Context appContext = AppRuntime.getAppContext();
                m03.g(appContext, c.getPath() + " 没有测试程序包!").G();
                nc3 nc3Var = new nc3();
                nc3Var.k(5L);
                nc3Var.i(4L);
                nc3Var.f("没有小程序包! for debug, bundle files are empty");
                rc3.a().f(nc3Var);
                if (af3Var != null) {
                    af3Var.a = nc3Var;
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
                File file = new File(ml2.d().get(0).a, "/aiapps_debug/");
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new File(ml2.d().get(0).a, "/aiapps_debug/").getAbsolutePath() : (String) invokeV.objValue;
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

    /* loaded from: classes6.dex */
    public interface c {
        void a(int i);

        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
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
                    ux1.k("SwanAppBundleHelper", "#deleteLowerVersionFolder del：" + file.getAbsolutePath());
                    p84.i().d(str, file.getName());
                    xg4.j(file);
                    yq2.b(str, file.getName());
                }
            }
        }

        public static void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, null) == null) {
                xg4.L(qj2.q());
            }
        }

        public static void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            File f = f(str, false);
            if (f != null) {
                xg4.L(f);
            }
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str);
            yq2.a(str);
            xg4.L(file);
            xg4.L(new File(qj2.o(str)));
            int indexOf = str.indexOf("_dev");
            if (indexOf != -1) {
                String substring = str.substring(0, indexOf);
                xg4.L(new File(qj2.o(substring + "_dev")));
            }
        }

        @Nullable
        public static File f(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, str, z)) == null) ? g(str, z, null) : (File) invokeLZ.objValue;
        }

        @Nullable
        public static File g(@Nullable String str, boolean z, @Nullable af3 af3Var) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, Boolean.valueOf(z), af3Var})) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File h = h();
                File file = new File(h, str + ".aiapps");
                if (file.exists() && file.isFile()) {
                    return file;
                }
                if (qj2.a && z) {
                    Context appContext = AppRuntime.getAppContext();
                    m03.g(appContext, h.getPath() + " 没有小程序包!").G();
                }
                if (af3Var != null) {
                    nc3 nc3Var = new nc3();
                    nc3Var.k(5L);
                    nc3Var.i(4L);
                    nc3Var.f("没有小程序包! for release, no such bundle file");
                    rc3.a().f(nc3Var);
                    af3Var.a = nc3Var;
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
                if (p73.e(str2)) {
                    p73.f(str, str2, jSONObject);
                }
                return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
            }
            return (File) invokeLLL.objValue;
        }

        public static boolean k(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
                if (qj2.a) {
                    Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
                }
                try {
                    return a(str, str2) > 0;
                } catch (IllegalArgumentException e) {
                    if (qj2.a) {
                        Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    }
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public static g l(rl2 rl2Var, af3 af3Var, @Nullable JSONObject jSONObject) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, rl2Var, af3Var, jSONObject)) == null) {
                if (rl2Var == null) {
                    return null;
                }
                File v = qj2.v(rl2Var.H(), rl2Var.v1(), rl2Var.o0(), rl2Var.h0(), jSONObject);
                if (!v.exists()) {
                    File g = g(rl2Var.H(), true, af3Var);
                    if (g == null) {
                        px2.P().Z(8, new SwanAppDeleteInfo(rl2Var.H(), 1).setPurgerScenes(5));
                        nc3 nc3Var = new nc3();
                        nc3Var.k(5L);
                        nc3Var.i(31L);
                        nc3Var.f("小程序zip和bundle不存在，兜底重置");
                        v73 v73Var = new v73();
                        v73Var.q(n73.n(rl2Var.G()));
                        v73Var.p(nc3Var);
                        v73Var.r(rl2Var);
                        n73.R(v73Var);
                        if (qj2.a) {
                            Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        }
                        return null;
                    }
                    b(v);
                    if (!qj2.N(g, v, rl2Var, af3Var)) {
                        m03.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").G();
                        nc3 nc3Var2 = new nc3();
                        nc3Var2.k(5L);
                        nc3Var2.i(7L);
                        nc3Var2.f("小程序bundle解压失败! for release");
                        rc3.a().f(nc3Var2);
                        if (af3Var != null && af3Var.a == null) {
                            af3Var.a = nc3Var2;
                        }
                        return null;
                    }
                }
                c(rl2Var.H(), rl2Var.v1());
                g gVar = new g();
                File file = new File(v, "app.json");
                SwanAppConfigData b = g13.b(v.getAbsolutePath());
                if (b == null) {
                    return null;
                }
                gVar.a = i(rl2Var.H(), rl2Var.v1()).getPath() + File.separator;
                gVar.b = b;
                bw2.m(b, true);
                sw2.l(b);
                zv2.a(b);
                ux1.k("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.a);
                return gVar;
            }
            return (g) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static g a(rl2 rl2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, rl2Var)) == null) {
                File e = e();
                ky1.g().h("unzipstart");
                qj2.M(b(), e, rl2Var);
                ky1.g().h("unzipend");
                g gVar = new g();
                File file = new File(e, "app.json");
                SwanAppConfigData b = g13.b(e.getAbsolutePath());
                gVar.a = e.getPath() + File.separator;
                gVar.b = b;
                bw2.m(b, true);
                sw2.l(b);
                zv2.a(b);
                ux1.k("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.a);
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

    /* loaded from: classes6.dex */
    public static class g extends nj2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755378280, "Lcom/repackage/qj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755378280, "Lcom/repackage/qj2;");
                return;
            }
        }
        a = eh1.a;
        b = Executors.newSingleThreadExecutor();
    }

    public static boolean A(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            boolean exists = new File(k(str, str2), "app.json").exists();
            if (!exists) {
                ux1.k("SwanAppBundleHelper", "#isAppJsonExist#1 [not exist] app.json");
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
            String g2 = me3.g(str2);
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
                ux1.l("SwanAppBundleHelper", "#parseBundleVersion ex=", e2);
                if (name.endsWith(".tmp")) {
                    ux1.k("SwanAppBundleHelper", "#parseBundleVersion deleteDir=" + file);
                    xg4.j(file);
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
            c73.b bVar = new c73.b(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER);
            bVar.j(str);
            bVar.l(str2);
            bVar.m();
        }
    }

    public static void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, null, z) == null) {
            i93.a().putBoolean("swanapps_has_done_fallback_strategy_key", z);
        }
    }

    public static void G(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, cVar) == null) {
            d dVar = new d();
            dVar.a = str;
            new b82().e(dVar, jb2.j().getPath(), cVar);
        }
    }

    public static void H(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, cVar) == null) {
            d dVar = new d();
            dVar.a = str;
            new b82().e(dVar, kb2.j().getPath(), cVar);
        }
    }

    public static void I(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, cVar) == null) {
            d dVar = new d();
            dVar.a = str;
            lb2.a();
            new b82().e(dVar, lb2.c().getPath(), cVar);
        }
    }

    public static void J(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, cVar) == null) {
            d dVar = new d();
            dVar.a = str;
            ba3.a();
            new b82().e(dVar, ba3.d().getPath(), cVar);
        }
    }

    public static void K(d dVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, dVar, cVar) == null) {
            File c2 = b.c();
            new b82().e(dVar, c2.getPath() + File.separator + System.currentTimeMillis() + ".aibundle", cVar);
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
            ux1.k("SwanAppBundleHelper", "#tryMkdirs del: " + file2.getAbsolutePath());
            xg4.L(file2);
            return mkdirs;
        }
        return invokeLL.booleanValue;
    }

    public static boolean M(File file, File file2, rl2 rl2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, file, file2, rl2Var)) == null) ? N(file, file2, rl2Var, null) : invokeLLL.booleanValue;
    }

    public static boolean N(File file, File file2, rl2 rl2Var, af3 af3Var) {
        InterceptResult invokeLLLL;
        boolean U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, null, file, file2, rl2Var, af3Var)) == null) {
            int i = 0;
            if (file != null && file2 != null) {
                if (file.exists() && file.length() != 0) {
                    zt2.o().F(new UbcFlowEvent("package_start_unzip"));
                    long currentTimeMillis = System.currentTimeMillis();
                    tj2.c j = tj2.j(file);
                    int i2 = j.b;
                    if (i2 != -1) {
                        U = tj2.d(j.a, file2, i2).a;
                        i = j.b;
                    } else {
                        U = xg4.U(file.getPath(), file2.getPath());
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (a) {
                        tj2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (!U) {
                        nc3 nc3Var = new nc3();
                        nc3Var.k(5L);
                        nc3Var.i(7L);
                        nc3Var.f("小程序bundle解压失败! PkgType=" + i);
                        if (af3Var != null) {
                            af3Var.a = nc3Var;
                        }
                    }
                    HybridUbcFlow o = zt2.o();
                    o.F(new UbcFlowEvent("package_end_unzip"));
                    o.D("app_package_version", String.valueOf(i));
                    return U;
                }
                nc3 nc3Var2 = new nc3();
                nc3Var2.k(5L);
                nc3Var2.i(4L);
                nc3Var2.f("小程序bundle文件不存在或者空文件! ");
                if (af3Var != null) {
                    af3Var.a = nc3Var2;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static synchronized boolean O(@NonNull u03 u03Var) {
        InterceptResult invokeL;
        boolean P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, u03Var)) == null) {
            synchronized (qj2.class) {
                P = P(u03Var, u(u03Var));
            }
            return P;
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean P(@NonNull u03 u03Var, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, u03Var, file)) == null) {
            synchronized (qj2.class) {
                if (file != null) {
                    if (file.exists()) {
                        SwanAppConfigData b2 = ml2.b(file);
                        if (b2 != null) {
                            u03Var.F0(b2);
                        }
                        bw2.m(b2, true);
                        sw2.l(b2);
                        zv2.a(b2);
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void c(rl2 rl2Var, oj2 oj2Var) {
        JSONObject jSONObject;
        String I1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, rl2Var, oj2Var) == null) {
            if (rl2Var == null || p73.e(rl2Var.v1())) {
                jSONObject = new JSONObject();
                String y = oe3.y();
                if (rl2Var == null) {
                    I1 = StringUtil.NULL_STRING;
                } else {
                    try {
                        I1 = rl2Var.I1();
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
            b.execute(new a(rl2Var, jSONObject, oj2Var));
        }
    }

    @WorkerThread
    public static synchronized void d(Set<String> set, Map<String, PMSAppInfo> map) {
        File[] C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, set, map) == null) {
            synchronized (qj2.class) {
                if (map != null) {
                    if (!map.isEmpty()) {
                        File o = c83.o();
                        try {
                            for (Map.Entry<String, PMSAppInfo> entry : map.entrySet()) {
                                String key = entry.getKey();
                                if (!TextUtils.isEmpty(key)) {
                                    if (set != null && set.contains(key)) {
                                        ux1.k("SwanAppBundleHelper", "删历史版本包，排除id: " + key);
                                    } else {
                                        long j = entry.getValue().versionCode;
                                        File file = new File(o, key);
                                        if (file.exists() && file.isDirectory()) {
                                            for (File file2 : xg4.C(file)) {
                                                if (file2 != null) {
                                                    Pair<Boolean, Long> D = D(file2);
                                                    if (((Boolean) D.first).booleanValue() && ((Long) D.second).longValue() < j) {
                                                        if (x(key)) {
                                                            break;
                                                        }
                                                        xg4.L(file2);
                                                        ux1.k("SwanAppBundleHelper", "删历史版本包，file=" + file2.getAbsolutePath());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            ux1.l("SwanAppBundleHelper", "#删历史版本包, ex=", e2);
                        }
                    }
                }
            }
        }
    }

    public static synchronized void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            synchronized (qj2.class) {
                if (w()) {
                    d84.b().y("SwanAppBundleHelper", "hasDoneFallbackStrategy true");
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
                b84 b2 = d84.b();
                b2.y("SwanAppBundleHelper", "tryMkdirs fail. Base folder: " + g2.getAbsolutePath() + " child file:" + str);
                if (g2.exists()) {
                    ux1.k("SwanAppBundleHelper", "#doSwanFolderFallback del: " + g2.getAbsolutePath());
                    xg4.L(g2);
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
            LinkedHashSet<tx2> q = vx2.k().q();
            HashSet hashSet = new HashSet();
            for (tx2 tx2Var : q) {
                if (tx2Var != null) {
                    String appId = tx2Var.getAppId();
                    Set<String> L = tx2Var.L();
                    if (!TextUtils.isEmpty(appId)) {
                        hashSet.add(appId);
                        if (a) {
                            Log.d("SwanAppBundleHelper", "appId in running - " + appId);
                        }
                    }
                    if (L.size() > 0) {
                        hashSet.addAll(L);
                        if (a) {
                            Log.d("SwanAppBundleHelper", "appId in prefetch - " + L);
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
            synchronized (qj2.class) {
                if (file == null) {
                    return "";
                }
                String path = file.getPath();
                if (a) {
                    Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
                }
                String str = (String) n72.b().a(path, "");
                if (TextUtils.isEmpty(str)) {
                    if (a) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                    }
                    String E = xg4.E(file);
                    n72.b().c(path, E);
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
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65568, null, str, str2, str3)) == null) ? new File(k(str, str2), me3.g(str3)) : (File) invokeLLL.objValue;
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

    public static File u(@NonNull u03 u03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, u03Var)) == null) {
            if (u03Var == null) {
                return null;
            }
            rl2.a V = u03Var.V();
            File v = v(u03Var.getAppId(), V.v1(), V.o0(), V.h0(), null);
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
            if (tw2.H()) {
                j = b.e();
            } else if (tw2.D()) {
                j = by1.d();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? i93.a().getBoolean("swanapps_has_done_fallback_strategy_key", false) : invokeV.booleanValue;
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
                    ux1.k("SwanAppBundleHelper", "#isAppJsValid [not exist] app.json");
                }
                long length = exists ? file2.length() : -1L;
                if (exists && length > 0) {
                    z = true;
                }
                if (!z) {
                    v73 v73Var = new v73();
                    nc3 nc3Var = new nc3();
                    nc3Var.k(5L);
                    nc3Var.i(51L);
                    v73Var.p(nc3Var);
                    v73Var.l("path", file2.getAbsolutePath());
                    v73Var.l("appJs", "isAppJsExist =" + exists + ", appJsSize =" + length);
                    v73Var.l("stack", oe3.z(30));
                    n73.R(v73Var);
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
                ux1.k("SwanAppBundleHelper", "#isAppJsonExist#2 [not exist] app.json");
            }
            return exists;
        }
        return invokeL.booleanValue;
    }
}
