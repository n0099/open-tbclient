package com.repackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
/* loaded from: classes6.dex */
public final class j42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static final boolean e;
    public static final boolean f;
    public static final int g;
    public static final Set<String> h;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends ProviderDelegation {
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

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("result", j42.h());
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755638711, "Lcom/repackage/j42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755638711, "Lcom/repackage/j42;");
                return;
            }
        }
        a = tg1.a;
        b = ProcessUtils.isMainProcess() ? j("swan_prefetch_app_data", 1) : e();
        c = j("swan_prefetch_slave_data", 0);
        d = j("swan_prefetch_click", 0);
        e = j("swan_prefetch_event_on", 1);
        f = j("swan_prefetch_sub_pkg", 0);
        g = d("swan_prefetch_app_data_multi", 0);
        if (a) {
            Log.i("PrefetchABSwitcher", "prefetch switch - " + b);
            Log.i("PrefetchABSwitcher", "master prefetch switch -  " + e);
            Log.i("PrefetchABSwitcher", "sub pkg prefetch switch -  " + f);
            Log.i("PrefetchABSwitcher", "master multi preload switch -  " + g);
        }
        h = ne3.a("hZPrR8cXXYgGHX2eGYOASkdmRyPkKcyT", "3mHyKpYFH6SF5FTWTLVaVdgi3lDGrxYy");
    }

    public static boolean a(@Nullable PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pMSAppInfo)) == null) ? d && m(pMSAppInfo) : invokeL.booleanValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt(str, -1) : invokeL.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_prefetch_event", -1) : invokeV.intValue;
    }

    public static int d(String str, int i) {
        InterceptResult invokeLI;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i)) == null) {
            if (!a || (b2 = b(str)) == -1) {
                qj2.g0().getSwitch(str, i);
                if (a) {
                    Log.d("PrefetchABSwitcher", str + " value from AB : " + i);
                }
                return i;
            }
            return b2;
        }
        return invokeLI.intValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            yw2 c2 = ww2.c(a.class, null);
            boolean z = false;
            if (c2.a() && c2.a.getBoolean("result", false)) {
                z = true;
            }
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("PrefetchABSwitcher", "get prefetch switch cross precess cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"LogConditional"})
    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (a) {
                int c2 = c();
                Log.d("PrefetchABSwitcher", "prefetch switch in debug sp - " + c2);
                return c2 == 1;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? !TextUtils.isEmpty(str) && h.contains(str) : invokeL.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? b : invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            boolean z = !yd3.f("3.290.0");
            if (!a || b("swan_prefetch_app_data_multi") <= 0) {
                return z;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean j(String str, int i) {
        InterceptResult invokeLI;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, str, i)) == null) {
            if (a) {
                if (iw2.Y() || (b2 = b(str)) == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
            }
            return d(str, i) == 1;
        }
        return invokeLI.booleanValue;
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            jx1.k("PrefetchABSwitcher", "preload master is on = " + b);
            jx1.k("PrefetchABSwitcher", "preload slave is on = " + c);
            j03 a0 = j03.a0();
            boolean z = a0 != null && m(a0.V().f0());
            jx1.k("PrefetchABSwitcher", "prefetch master show is on = " + z);
            jx1.k("PrefetchABSwitcher", "prefetch master click is on = " + d);
            jx1.k("PrefetchABSwitcher", "sub pkg prefetch switch -  " + f);
            l22 a2 = s22.b().a();
            if (a2 != null) {
                jx1.k("PrefetchABSwitcher", "current running master id = " + a2.i().c());
            }
            jx1.k("PrefetchABSwitcher", "master multi preload switch -  " + g);
        }
    }

    public static int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? g : invokeV.intValue;
    }

    public static boolean m(@Nullable PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, pMSAppInfo)) == null) {
            if (h()) {
                if (a) {
                    int c2 = c();
                    if (c2 == 1) {
                        return true;
                    }
                    if (c2 == 0) {
                        return false;
                    }
                }
                if (pMSAppInfo != null && e) {
                    boolean z = ls1.b(pMSAppInfo.appId) != 0;
                    j03 a0 = j03.a0();
                    SwanAppConfigData P = a0 == null ? null : a0.P();
                    if (P != null && !P.u) {
                        SwanAppConfigData.h hVar = P.t;
                        boolean z2 = hVar != null && hVar.a;
                        if (z) {
                            return z2;
                        }
                        return (z2 || g(pMSAppInfo.appKey)) && oq2.g().i(pMSAppInfo);
                    } else if (a) {
                        Log.d("PrefetchABSwitcher", "NA View not support prefetch");
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean n(@Nullable PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        SwanAppConfigData.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, pMSAppInfo)) == null) {
            boolean z = false;
            if (pMSAppInfo == null) {
                return false;
            }
            boolean m = m(pMSAppInfo);
            if (a) {
                Log.d("PrefetchABSwitcher", "appId - " + pMSAppInfo.appKey + ", prefetch on - " + m);
            }
            if (m) {
                if (a) {
                    int c2 = c();
                    if (c2 == 1) {
                        return true;
                    }
                    if (c2 == 0) {
                        return false;
                    }
                }
                j03 a0 = j03.a0();
                SwanAppConfigData P = a0 == null ? null : a0.P();
                z = ((P != null && (hVar = P.t) != null && TextUtils.equals(hVar.b, "show")) || g(pMSAppInfo.appKey)) ? true : true;
                if (a) {
                    Log.d("PrefetchABSwitcher", "appId - " + pMSAppInfo.appKey + ", show prefetch - " + z);
                }
                return z;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? c : invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? f : invokeV.booleanValue;
    }
}
