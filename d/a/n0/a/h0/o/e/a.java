package d.a.n0.a.h0.o.e;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.e;
import d.a.n0.a.h0.l.g.h;
import d.a.n0.a.k;
import d.a.n0.a.v1.b.d;
import d.a.n0.a.v1.b.f;
import d.a.n0.a.v2.l0;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45074a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45075b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45076c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45077d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45078e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f45079f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f45080g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.h0.o.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0755a extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0755a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                bundle2.putBoolean("result", a.f());
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1046916213, "Ld/a/n0/a/h0/o/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1046916213, "Ld/a/n0/a/h0/o/e/a;");
                return;
            }
        }
        f45074a = k.f45831a;
        f45075b = ProcessUtils.isMainProcess() ? h("swan_prefetch_app_data") : e();
        f45076c = h("swan_prefetch_slave_data");
        f45077d = h("swan_prefetch_click");
        f45078e = h("swan_prefetch_event_on");
        f45079f = h("swan_prefetch_sub_pkg");
        f45080g = d("swan_prefetch_app_data_multi", 0);
        if (f45074a) {
            Log.i("PrefetchABSwitcher", "prefetch switch - " + f45075b);
            Log.i("PrefetchABSwitcher", "master prefetch switch -  " + f45078e);
            Log.i("PrefetchABSwitcher", "sub pkg prefetch switch -  " + f45079f);
            Log.i("PrefetchABSwitcher", "master multi preload switch -  " + f45080g);
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f45077d : invokeV.booleanValue;
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

    public static int d(String str, int i2) {
        InterceptResult invokeLI;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2)) == null) {
            if (!f45074a || (b2 = b(str)) == -1) {
                d.a.n0.a.c1.a.Z().getSwitch(str, i2);
                Log.d("PrefetchABSwitcher", str + " value from AB : " + i2);
                return i2;
            }
            return b2;
        }
        return invokeLI.intValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            long currentTimeMillis = f45074a ? System.currentTimeMillis() : 0L;
            f b2 = d.b(C0755a.class, null);
            boolean z = false;
            if (b2.a() && b2.f47923a.getBoolean("result", false)) {
                z = true;
            }
            if (f45074a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("PrefetchABSwitcher", "get prefetch switch cross precess cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f45075b : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            boolean z = !l0.f("3.290.0");
            if (!f45074a || b("swan_prefetch_app_data_multi") <= 0) {
                return z;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean h(String str) {
        InterceptResult invokeL;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (f45074a) {
                if (d.a.n0.a.u1.a.a.W() || (b2 = b(str)) == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
            }
            return d(str, 0) == 1;
        }
        return invokeL.booleanValue;
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            d.a.n0.a.e0.d.h("PrefetchABSwitcher", "preload master is on = " + f45075b);
            d.a.n0.a.e0.d.h("PrefetchABSwitcher", "preload slave is on = " + f45076c);
            e Q = e.Q();
            boolean z = Q != null && k(Q.L().f0());
            d.a.n0.a.e0.d.h("PrefetchABSwitcher", "prefetch master show is on = " + z);
            d.a.n0.a.e0.d.h("PrefetchABSwitcher", "prefetch master click is on = " + f45077d);
            d.a.n0.a.e0.d.h("PrefetchABSwitcher", "sub pkg prefetch switch -  " + f45079f);
            d.a.n0.a.h0.l.g.a a2 = h.b().a();
            if (a2 != null) {
                d.a.n0.a.e0.d.h("PrefetchABSwitcher", "current running master id = " + a2.i().b());
            }
            d.a.n0.a.e0.d.h("PrefetchABSwitcher", "master multi preload switch -  " + f45080g);
        }
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f45080g : invokeV.intValue;
    }

    public static boolean k(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, pMSAppInfo)) == null) {
            if (f()) {
                if (k.f45831a) {
                    int c2 = c();
                    if (c2 == 1) {
                        return true;
                    }
                    if (c2 == 0) {
                        return false;
                    }
                }
                return f45078e && d.a.n0.a.l1.d.d.f().h(pMSAppInfo);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f45076c : invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? f45079f : invokeV.booleanValue;
    }
}
