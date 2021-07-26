package d.a.o0.a.e0.f.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.a1.e;
import java.io.File;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f44509a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f44510b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f44511c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1411061562, "Ld/a/o0/a/e0/f/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1411061562, "Ld/a/o0/a/e0/f/d/b;");
                return;
            }
        }
        f44509a = "__localDebug__" + File.separator + "master.js";
        f44510b = "__localDebug__" + File.separator + "main.js";
        f44511c = "__localDebug__" + File.separator + "slave.js";
    }

    public static e.g a(d.a.o0.a.f1.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            File d2 = d();
            d.e().f("unzipstart");
            d.a.o0.a.a1.e.K(b(), d2, bVar);
            d.e().f("unzipend");
            e.g gVar = new e.g();
            File file = new File(d2, "app.json");
            SwanAppConfigData b2 = d.a.o0.a.a2.n.d.b(d2.getAbsolutePath());
            gVar.f43827a = d2.getPath() + File.separator;
            gVar.f43828b = b2;
            d.a.o0.a.e0.d.h("LocalDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + gVar.f43827a);
            return gVar;
        }
        return (e.g) invokeL.objValue;
    }

    public static File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new File(c(), "local_debug.swan") : (File) invokeV.objValue;
    }

    public static File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_local_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_local_debug");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            return d() + File.separator + f44509a;
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            return d() + File.separator + f44511c;
        }
        return (String) invokeV.objValue;
    }
}
