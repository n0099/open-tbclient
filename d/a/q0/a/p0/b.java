package d.a.q0.a.p0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49938a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(124323055, "Ld/a/q0/a/p0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(124323055, "Ld/a/q0/a/p0/b;");
                return;
            }
        }
        f49938a = k.f49133a;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            f(0).f().c();
            f(0).e().f();
            if (f(1) != null) {
                f(1).f().c();
                f(1).e().f();
            }
        }
    }

    public static <T extends d.a.q0.a.p0.g.a> Exception b(int i2, T t) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, t)) == null) {
            d.a.q0.a.p0.d.b f2 = f(i2);
            if (f2 == null) {
                return new Exception("SwanExtCore-Manager doRemoteUpdate: null extensionCoreManager");
            }
            return f2.a(t);
        }
        return (Exception) invokeIL.objValue;
    }

    public static ExtensionCore c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            d.a.q0.a.p0.d.b f2 = f(i2);
            if (f2 == null) {
                return null;
            }
            return f2.c();
        }
        return (ExtensionCore) invokeI.objValue;
    }

    public static long d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65540, null, i2)) == null) {
            ExtensionCore c2 = c(i2);
            if (c2 != null) {
                return c2.extensionCoreVersionCode;
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    public static String e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            ExtensionCore c2 = c(i2);
            return (c2 == null || TextUtils.isEmpty(c2.extensionCoreVersionName)) ? "0" : c2.extensionCoreVersionName;
        }
        return (String) invokeI.objValue;
    }

    public static d.a.q0.a.p0.d.b f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) {
            if (i2 == 1) {
                d.a.q0.a.p0.d.b u = d.a.q0.a.c1.b.i().u();
                if (u == null && k.f49133a) {
                    Log.e("SwanGameRuntime", "非手百环境依赖注入接口getSwanGameExtensionCoreManager未实现，直接返回");
                }
                return u;
            }
            return a.l();
        }
        return (d.a.q0.a.p0.d.b) invokeI.objValue;
    }

    public static void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65543, null, i2, i3) == null) {
            if (f49938a) {
                Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i2 + " ,newVersion: " + i3);
            }
            if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i2 != i3) {
                a();
                d.a.q0.a.p0.j.a.i(0, true);
                d.a.q0.a.p0.j.a.i(1, true);
            }
        }
    }

    public static void h(int i2, @Nullable d.a.q0.a.v2.e1.b<Exception> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i2, bVar) == null) {
            d.a.q0.a.p0.d.b f2 = f(i2);
            if (f2 != null) {
                f2.g(bVar);
            } else if (bVar != null) {
                bVar.onCallback(null);
            }
        }
    }
}
