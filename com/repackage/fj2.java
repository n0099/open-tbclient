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
import com.repackage.gl2;
import com.repackage.ij2;
import com.repackage.r63;
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
public class fj2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static ExecutorService b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gl2 a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ dj2 c;

        public a(gl2 gl2Var, JSONObject jSONObject, dj2 dj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl2Var, jSONObject, dj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gl2Var;
            this.b = jSONObject;
            this.c = dj2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            g l;
            SwanAppConfigData swanAppConfigData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pe3 pe3Var = new pe3();
                if (iw2.B(this.a)) {
                    l = iw2.c(this.a, pe3Var);
                } else {
                    l = e.l(this.a, pe3Var, this.b);
                }
                if (l == null || (swanAppConfigData = l.b) == null || swanAppConfigData.b == null) {
                    cc3 cc3Var = pe3Var.a;
                    if (cc3Var == null) {
                        cc3Var = new cc3();
                        cc3Var.k(5L);
                        cc3Var.i(20L);
                        cc3Var.f("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    k73 k73Var = new k73();
                    gl2 gl2Var = this.a;
                    k73Var.q(c73.n(gl2Var != null ? gl2Var.G() : 0));
                    k73Var.p(cc3Var);
                    k73Var.s("appjson_config_invalid");
                    k73Var.r(this.a);
                    c73.R(k73Var);
                }
                this.c.a(0, l);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static g a(gl2 gl2Var, pe3 pe3Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, gl2Var, pe3Var)) == null) {
                File b = b(pe3Var);
                if (b == null) {
                    return null;
                }
                j03 L = j03.L();
                if (L == null) {
                    if (!fj2.N(b, e(), gl2Var, pe3Var)) {
                        b03.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").G();
                        cc3 cc3Var = new cc3();
                        cc3Var.k(5L);
                        cc3Var.i(7L);
                        cc3Var.f("小程序bundle解压失败! for debug");
                        gc3.a().f(cc3Var);
                        if (pe3Var != null && pe3Var.a == null) {
                            pe3Var.a = cc3Var;
                        }
                        return null;
                    }
                } else {
                    String q = L.d0().q("installed_debug_bundle_md5", "");
                    String b2 = og4.b(b, false);
                    if (!TextUtils.equals(q, b2)) {
                        if (!fj2.N(b, e(), gl2Var, pe3Var)) {
                            b03.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").G();
                            cc3 cc3Var2 = new cc3();
                            cc3Var2.k(5L);
                            cc3Var2.i(7L);
                            cc3Var2.f("小程序bundle解压失败! for debug");
                            gc3.a().f(cc3Var2);
                            if (pe3Var != null && pe3Var.a == null) {
                                pe3Var.a = cc3Var2;
                            }
                            return null;
                        }
                        L.d0().B("installed_debug_bundle_md5", b2);
                    }
                }
                g gVar = new g();
                File g = g();
                File file = new File(g, "app.json");
                SwanAppConfigData b3 = v03.b(g.getAbsolutePath());
                gVar.a = g.getPath() + File.separator;
                gVar.b = b3;
                qv2.m(b3, true);
                hw2.l(b3);
                ov2.a(b3);
                jx1.k("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.a);
                return gVar;
            }
            return (g) invokeLL.objValue;
        }

        public static File b(pe3 pe3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pe3Var)) == null) {
                File c = c();
                File[] listFiles = c.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    return h(listFiles);
                }
                Context appContext = AppRuntime.getAppContext();
                b03.g(appContext, c.getPath() + " 没有测试程序包!").G();
                cc3 cc3Var = new cc3();
                cc3Var.k(5L);
                cc3Var.i(4L);
                cc3Var.f("没有小程序包! for debug, bundle files are empty");
                gc3.a().f(cc3Var);
                if (pe3Var != null) {
                    pe3Var.a = cc3Var;
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
                File file = new File(bl2.d().get(0).a, "/aiapps_debug/");
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new File(bl2.d().get(0).a, "/aiapps_debug/").getAbsolutePath() : (String) invokeV.objValue;
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
                    jx1.k("SwanAppBundleHelper", "#deleteLowerVersionFolder del：" + file.getAbsolutePath());
                    e84.i().d(str, file.getName());
                    mg4.j(file);
                    nq2.b(str, file.getName());
                }
            }
        }

        public static void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, null) == null) {
                mg4.L(fj2.q());
            }
        }

        public static void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            File f = f(str, false);
            if (f != null) {
                mg4.L(f);
            }
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str);
            nq2.a(str);
            mg4.L(file);
            mg4.L(new File(fj2.o(str)));
            int indexOf = str.indexOf("_dev");
            if (indexOf != -1) {
                String substring = str.substring(0, indexOf);
                mg4.L(new File(fj2.o(substring + "_dev")));
            }
        }

        @Nullable
        public static File f(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, str, z)) == null) ? g(str, z, null) : (File) invokeLZ.objValue;
        }

        @Nullable
        public static File g(@Nullable String str, boolean z, @Nullable pe3 pe3Var) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, Boolean.valueOf(z), pe3Var})) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File h = h();
                File file = new File(h, str + ".aiapps");
                if (file.exists() && file.isFile()) {
                    return file;
                }
                if (fj2.a && z) {
                    Context appContext = AppRuntime.getAppContext();
                    b03.g(appContext, h.getPath() + " 没有小程序包!").G();
                }
                if (pe3Var != null) {
                    cc3 cc3Var = new cc3();
                    cc3Var.k(5L);
                    cc3Var.i(4L);
                    cc3Var.f("没有小程序包! for release, no such bundle file");
                    gc3.a().f(cc3Var);
                    pe3Var.a = cc3Var;
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
                if (e73.e(str2)) {
                    e73.f(str, str2, jSONObject);
                }
                return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
            }
            return (File) invokeLLL.objValue;
        }

        public static boolean k(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
                if (fj2.a) {
                    Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
                }
                try {
                    return a(str, str2) > 0;
                } catch (IllegalArgumentException e) {
                    if (fj2.a) {
                        Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    }
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public static g l(gl2 gl2Var, pe3 pe3Var, @Nullable JSONObject jSONObject) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, gl2Var, pe3Var, jSONObject)) == null) {
                if (gl2Var == null) {
                    return null;
                }
                File v = fj2.v(gl2Var.H(), gl2Var.v1(), gl2Var.o0(), gl2Var.h0(), jSONObject);
                if (!v.exists()) {
                    File g = g(gl2Var.H(), true, pe3Var);
                    if (g == null) {
                        ex2.P().Z(8, new SwanAppDeleteInfo(gl2Var.H(), 1).setPurgerScenes(5));
                        cc3 cc3Var = new cc3();
                        cc3Var.k(5L);
                        cc3Var.i(31L);
                        cc3Var.f("小程序zip和bundle不存在，兜底重置");
                        k73 k73Var = new k73();
                        k73Var.q(c73.n(gl2Var.G()));
                        k73Var.p(cc3Var);
                        k73Var.r(gl2Var);
                        c73.R(k73Var);
                        if (fj2.a) {
                            Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        }
                        return null;
                    }
                    b(v);
                    if (!fj2.N(g, v, gl2Var, pe3Var)) {
                        b03.g(AppRuntime.getAppContext(), "小程序bundle解压失败!").G();
                        cc3 cc3Var2 = new cc3();
                        cc3Var2.k(5L);
                        cc3Var2.i(7L);
                        cc3Var2.f("小程序bundle解压失败! for release");
                        gc3.a().f(cc3Var2);
                        if (pe3Var != null && pe3Var.a == null) {
                            pe3Var.a = cc3Var2;
                        }
                        return null;
                    }
                }
                c(gl2Var.H(), gl2Var.v1());
                g gVar = new g();
                File file = new File(v, "app.json");
                SwanAppConfigData b = v03.b(v.getAbsolutePath());
                if (b == null) {
                    return null;
                }
                gVar.a = i(gl2Var.H(), gl2Var.v1()).getPath() + File.separator;
                gVar.b = b;
                qv2.m(b, true);
                hw2.l(b);
                ov2.a(b);
                jx1.k("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.a);
                return gVar;
            }
            return (g) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static g a(gl2 gl2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gl2Var)) == null) {
                File e = e();
                zx1.g().h("unzipstart");
                fj2.M(b(), e, gl2Var);
                zx1.g().h("unzipend");
                g gVar = new g();
                File file = new File(e, "app.json");
                SwanAppConfigData b = v03.b(e.getAbsolutePath());
                gVar.a = e.getPath() + File.separator;
                gVar.b = b;
                qv2.m(b, true);
                hw2.l(b);
                ov2.a(b);
                jx1.k("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + gVar.a);
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
    public static class g extends cj2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755705981, "Lcom/repackage/fj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755705981, "Lcom/repackage/fj2;");
                return;
            }
        }
        a = tg1.a;
        b = Executors.newSingleThreadExecutor();
    }

    public static boolean A(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            boolean exists = new File(k(str, str2), "app.json").exists();
            if (!exists) {
                jx1.k("SwanAppBundleHelper", "#isAppJsonExist#1 [not exist] app.json");
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
            String g2 = be3.g(str2);
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
                jx1.l("SwanAppBundleHelper", "#parseBundleVersion ex=", e2);
                if (name.endsWith(".tmp")) {
                    jx1.k("SwanAppBundleHelper", "#parseBundleVersion deleteDir=" + file);
                    mg4.j(file);
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
            r63.b bVar = new r63.b(CyberPlayerManager.MEDIA_INFO_CONNECTED_SERVER);
            bVar.j(str);
            bVar.l(str2);
            bVar.m();
        }
    }

    public static void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, null, z) == null) {
            x83.a().putBoolean("swanapps_has_done_fallback_strategy_key", z);
        }
    }

    public static void G(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, cVar) == null) {
            d dVar = new d();
            dVar.a = str;
            new q72().e(dVar, ya2.j().getPath(), cVar);
        }
    }

    public static void H(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, cVar) == null) {
            d dVar = new d();
            dVar.a = str;
            new q72().e(dVar, za2.j().getPath(), cVar);
        }
    }

    public static void I(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, cVar) == null) {
            d dVar = new d();
            dVar.a = str;
            ab2.a();
            new q72().e(dVar, ab2.c().getPath(), cVar);
        }
    }

    public static void J(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, cVar) == null) {
            d dVar = new d();
            dVar.a = str;
            q93.a();
            new q72().e(dVar, q93.d().getPath(), cVar);
        }
    }

    public static void K(d dVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, dVar, cVar) == null) {
            File c2 = b.c();
            new q72().e(dVar, c2.getPath() + File.separator + System.currentTimeMillis() + ".aibundle", cVar);
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
            jx1.k("SwanAppBundleHelper", "#tryMkdirs del: " + file2.getAbsolutePath());
            mg4.L(file2);
            return mkdirs;
        }
        return invokeLL.booleanValue;
    }

    public static boolean M(File file, File file2, gl2 gl2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, file, file2, gl2Var)) == null) ? N(file, file2, gl2Var, null) : invokeLLL.booleanValue;
    }

    public static boolean N(File file, File file2, gl2 gl2Var, pe3 pe3Var) {
        InterceptResult invokeLLLL;
        boolean U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, null, file, file2, gl2Var, pe3Var)) == null) {
            int i = 0;
            if (file != null && file2 != null) {
                if (file.exists() && file.length() != 0) {
                    ot2.o().F(new UbcFlowEvent("package_start_unzip"));
                    long currentTimeMillis = System.currentTimeMillis();
                    ij2.c j = ij2.j(file);
                    int i2 = j.b;
                    if (i2 != -1) {
                        U = ij2.d(j.a, file2, i2).a;
                        i = j.b;
                    } else {
                        U = mg4.U(file.getPath(), file2.getPath());
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (a) {
                        ij2.h((int) (currentTimeMillis2 - currentTimeMillis));
                    }
                    if (!U) {
                        cc3 cc3Var = new cc3();
                        cc3Var.k(5L);
                        cc3Var.i(7L);
                        cc3Var.f("小程序bundle解压失败! PkgType=" + i);
                        if (pe3Var != null) {
                            pe3Var.a = cc3Var;
                        }
                    }
                    HybridUbcFlow o = ot2.o();
                    o.F(new UbcFlowEvent("package_end_unzip"));
                    o.D("app_package_version", String.valueOf(i));
                    return U;
                }
                cc3 cc3Var2 = new cc3();
                cc3Var2.k(5L);
                cc3Var2.i(4L);
                cc3Var2.f("小程序bundle文件不存在或者空文件! ");
                if (pe3Var != null) {
                    pe3Var.a = cc3Var2;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static synchronized boolean O(@NonNull j03 j03Var) {
        InterceptResult invokeL;
        boolean P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, j03Var)) == null) {
            synchronized (fj2.class) {
                P = P(j03Var, u(j03Var));
            }
            return P;
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean P(@NonNull j03 j03Var, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, j03Var, file)) == null) {
            synchronized (fj2.class) {
                if (file != null) {
                    if (file.exists()) {
                        SwanAppConfigData b2 = bl2.b(file);
                        if (b2 != null) {
                            j03Var.F0(b2);
                        }
                        qv2.m(b2, true);
                        hw2.l(b2);
                        ov2.a(b2);
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void c(gl2 gl2Var, dj2 dj2Var) {
        JSONObject jSONObject;
        String I1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, gl2Var, dj2Var) == null) {
            if (gl2Var == null || e73.e(gl2Var.v1())) {
                jSONObject = new JSONObject();
                String y = de3.y();
                if (gl2Var == null) {
                    I1 = StringUtil.NULL_STRING;
                } else {
                    try {
                        I1 = gl2Var.I1();
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
            b.execute(new a(gl2Var, jSONObject, dj2Var));
        }
    }

    @WorkerThread
    public static synchronized void d(Set<String> set, Map<String, PMSAppInfo> map) {
        File[] C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, set, map) == null) {
            synchronized (fj2.class) {
                if (map != null) {
                    if (!map.isEmpty()) {
                        File o = r73.o();
                        try {
                            for (Map.Entry<String, PMSAppInfo> entry : map.entrySet()) {
                                String key = entry.getKey();
                                if (!TextUtils.isEmpty(key)) {
                                    if (set != null && set.contains(key)) {
                                        jx1.k("SwanAppBundleHelper", "删历史版本包，排除id: " + key);
                                    } else {
                                        long j = entry.getValue().versionCode;
                                        File file = new File(o, key);
                                        if (file.exists() && file.isDirectory()) {
                                            for (File file2 : mg4.C(file)) {
                                                if (file2 != null) {
                                                    Pair<Boolean, Long> D = D(file2);
                                                    if (((Boolean) D.first).booleanValue() && ((Long) D.second).longValue() < j) {
                                                        if (x(key)) {
                                                            break;
                                                        }
                                                        mg4.L(file2);
                                                        jx1.k("SwanAppBundleHelper", "删历史版本包，file=" + file2.getAbsolutePath());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            jx1.l("SwanAppBundleHelper", "#删历史版本包, ex=", e2);
                        }
                    }
                }
            }
        }
    }

    public static synchronized void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            synchronized (fj2.class) {
                if (w()) {
                    s74.b().y("SwanAppBundleHelper", "hasDoneFallbackStrategy true");
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
                q74 b2 = s74.b();
                b2.y("SwanAppBundleHelper", "tryMkdirs fail. Base folder: " + g2.getAbsolutePath() + " child file:" + str);
                if (g2.exists()) {
                    jx1.k("SwanAppBundleHelper", "#doSwanFolderFallback del: " + g2.getAbsolutePath());
                    mg4.L(g2);
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
            LinkedHashSet<ix2> q = kx2.k().q();
            HashSet hashSet = new HashSet();
            for (ix2 ix2Var : q) {
                if (ix2Var != null) {
                    String appId = ix2Var.getAppId();
                    Set<String> L = ix2Var.L();
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
            synchronized (fj2.class) {
                if (file == null) {
                    return "";
                }
                String path = file.getPath();
                if (a) {
                    Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
                }
                String str = (String) c72.b().a(path, "");
                if (TextUtils.isEmpty(str)) {
                    if (a) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                    }
                    String E = mg4.E(file);
                    c72.b().c(path, E);
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
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65568, null, str, str2, str3)) == null) ? new File(k(str, str2), be3.g(str3)) : (File) invokeLLL.objValue;
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

    public static File u(@NonNull j03 j03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, j03Var)) == null) {
            if (j03Var == null) {
                return null;
            }
            gl2.a V = j03Var.V();
            File v = v(j03Var.getAppId(), V.v1(), V.o0(), V.h0(), null);
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
            if (iw2.H()) {
                j = b.e();
            } else if (iw2.D()) {
                j = qx1.d();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? x83.a().getBoolean("swanapps_has_done_fallback_strategy_key", false) : invokeV.booleanValue;
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
                    jx1.k("SwanAppBundleHelper", "#isAppJsValid [not exist] app.json");
                }
                long length = exists ? file2.length() : -1L;
                if (exists && length > 0) {
                    z = true;
                }
                if (!z) {
                    k73 k73Var = new k73();
                    cc3 cc3Var = new cc3();
                    cc3Var.k(5L);
                    cc3Var.i(51L);
                    k73Var.p(cc3Var);
                    k73Var.l("path", file2.getAbsolutePath());
                    k73Var.l("appJs", "isAppJsExist =" + exists + ", appJsSize =" + length);
                    k73Var.l("stack", de3.z(30));
                    c73.R(k73Var);
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
                jx1.k("SwanAppBundleHelper", "#isAppJsonExist#2 [not exist] app.json");
            }
            return exists;
        }
        return invokeL.booleanValue;
    }
}
