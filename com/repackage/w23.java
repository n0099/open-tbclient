package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.di2;
import com.repackage.ea4;
import com.repackage.w22;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class w23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends f22 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e h;
        public final /* synthetic */ String i;

        public a(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = eVar;
            this.i = str;
        }

        @Override // com.repackage.f22
        public void R(@NonNull ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ab3Var) == null) {
                if (w23.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-fail:" + ab3Var);
                }
                this.h.c(2113, ab3Var);
            }
        }

        @Override // com.repackage.f22
        public void S() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (w23.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-success.");
                }
                this.h.b(this.i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements w22.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ hz2 b;
        public final /* synthetic */ e c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public b(boolean z, hz2 hz2Var, e eVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), hz2Var, eVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = hz2Var;
            this.c = eVar;
            this.d = str;
            this.e = str2;
            this.f = str3;
        }

        @Override // com.repackage.w22.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                w23.h(this.a, this.b.b, "pkg_retry_fail", String.valueOf(2113));
                this.c.c(2113, null);
            }
        }

        @Override // com.repackage.w22.b
        public void b(ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ab3Var) == null) {
                boolean o = w23.o(this.b.b, ab3Var);
                if (w23.a) {
                    Log.d("PagesRoute", "getAppPackage-isNeedGetPkgRetry:" + o + ",isRetry:" + this.a + ",pmsErrorCode:" + ab3Var);
                }
                if (o) {
                    w23.i(this.b.b, ab3Var);
                    ck2.b().a(this.b.b);
                    w23.k(this.b, this.e, this.d, this.c, this.f, true);
                    return;
                }
                zy2.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1318).G();
                w23.h(this.a, this.b.b, "pkg_retry_fail", String.valueOf(ab3Var == null ? 0L : ab3Var.a()));
                this.c.c(2113, ab3Var);
            }
        }

        @Override // com.repackage.w22.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                w23.h(this.a, this.b.b, "pkg_retry_success", "");
                this.c.b(this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements c22 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ e b;
        public final /* synthetic */ String c;

        public c(String str, e eVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, eVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = eVar;
            this.c = str2;
        }

        @Override // com.repackage.c22
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hz2 L = hz2.L();
                if (L != null) {
                    L.N0(this.a, true);
                }
                this.b.b(this.c);
            }
        }

        @Override // com.repackage.c22
        public void b(int i, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ab3Var) == null) {
                this.b.c(i, ab3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements c22 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ e d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;

        public d(String str, boolean z, String str2, e eVar, String str3, String str4, String str5, String str6, String str7) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), str2, eVar, str3, str4, str5, str6, str7};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = z;
            this.c = str2;
            this.d = eVar;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = str6;
            this.i = str7;
        }

        @Override // com.repackage.c22
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gz2.J().r().N0(this.a, true);
                w23.h(this.b, this.c, "sub_pkg_retry_success", "");
                this.d.b(this.e);
            }
        }

        @Override // com.repackage.c22
        public void b(int i, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ab3Var) == null) {
                boolean o = w23.o(this.c, ab3Var);
                if (w23.a) {
                    Log.d("PagesRoute", "isNeedGetPkgRetry:" + o + ",isRetry:" + this.b + ",pmsErrorCode:" + ab3Var);
                }
                if (o) {
                    w23.i(this.f, ab3Var);
                    ck2.b().a(this.c);
                    w23.n(this.f, this.g, this.h, this.a, this.i, this.e, this.d, true);
                    return;
                }
                w23.h(this.b, this.c, "sub_pkg_retry_fail", String.valueOf(ab3Var == null ? 0L : ab3Var.a()));
                this.d.c(i, ab3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void b(String str);

        void c(int i, ab3 ab3Var);
    }

    /* loaded from: classes7.dex */
    public static class f implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final e a;
        public final boolean b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ f b;

            public a(f fVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = fVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.b(this.a);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ ab3 b;
            public final /* synthetic */ f c;

            public b(f fVar, int i, ab3 ab3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Integer.valueOf(i), ab3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = fVar;
                this.a = i;
                this.b = ab3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.c.b) {
                        zy2.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1318).G();
                    }
                    this.c.a.c(this.a, this.b);
                }
            }
        }

        public f(@NonNull e eVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = z;
        }

        @Override // com.repackage.w23.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                bd3.e0(new a(this, str));
            }
        }

        @Override // com.repackage.w23.e
        public void c(int i, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ab3Var) == null) {
                bd3.e0(new b(this, i, ab3Var));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755253319, "Lcom/repackage/w23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755253319, "Lcom/repackage/w23;");
                return;
            }
        }
        a = rf1.a;
    }

    public static void g(hz2 hz2Var, hp2 hp2Var, String str, e eVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, hz2Var, hp2Var, str, eVar, str2) == null) {
            if (hz2Var != null) {
                hz2Var.B().H(hz2Var.getAppId());
            }
            if (eVar == null) {
                return;
            }
            if (hz2Var != null && hp2Var != null && !TextUtils.isEmpty(hp2Var.a) && !TextUtils.isEmpty(hp2Var.d)) {
                String str3 = hp2Var.d;
                String b0 = hz2Var.b0(hp2Var.a);
                boolean q0 = hz2Var.q0(str3);
                if (!yw1.d() && !gv2.H() && !gv2.D()) {
                    if (ou2.k(hp2Var.a)) {
                        eVar.b(str);
                        return;
                    }
                    boolean z = true;
                    if (q0) {
                        boolean A = di2.A(hz2Var.b, hz2Var.j0());
                        boolean n0 = hz2Var.n0();
                        if (A) {
                            if (!n0) {
                                eVar.b(str);
                                return;
                            }
                            Set<ea4.a> i = ou2.i(hz2Var.V().f0());
                            if (i != null && !i.isEmpty()) {
                                z = false;
                            }
                            if (z) {
                                eVar.b(str);
                                return;
                            } else {
                                j(i, eVar, str);
                                return;
                            }
                        } else if (n0) {
                            k(hz2Var, str3, str, eVar, str2, false);
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(b0)) {
                        eVar.c(2111, null);
                        return;
                    } else if (hz2Var.s0(b0)) {
                        eVar.b(str);
                        return;
                    } else if (hz2Var.u0(b0) && hz2Var.t0(b0)) {
                        eVar.b(str);
                        hz2Var.N0(b0, true);
                        return;
                    } else {
                        String Q = hz2Var.Q(b0);
                        if (TextUtils.isEmpty(Q)) {
                            eVar.c(2112, null);
                            return;
                        }
                        boolean p0 = hz2Var.p0(str3);
                        if (!di2.A(hz2Var.b, hz2Var.j0()) && !p0) {
                            k(hz2Var, str3, str, eVar, str2, false);
                            return;
                        }
                        HybridUbcFlow q = ms2.q("route", str2);
                        q.F(new UbcFlowEvent("na_start_sub_package_download"));
                        q.D("sub_state", "1");
                        m(hz2Var.b, hz2Var.j0(), "3", b0, Q, str, new f(eVar, true));
                        return;
                    }
                } else if (!q0 && TextUtils.isEmpty(b0)) {
                    eVar.c(2111, null);
                    return;
                } else {
                    eVar.b(str);
                    return;
                }
            }
            eVar.c(2110, null);
        }
    }

    public static void h(boolean z, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) && z) {
            ck2.b().g(str);
            a63.L(str2, str3);
        }
    }

    public static void i(String str, ab3 ab3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, ab3Var) == null) {
            if ((ab3Var == null ? 0L : ab3Var.h()) == 2205) {
                t72.c().d().u(ld3.a(str), true, 12);
            }
        }
    }

    public static void j(Set<ea4.a> set, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, set, eVar, str) == null) {
            ea4 ea4Var = new ea4(set);
            ea4Var.d("3");
            a aVar = new a(eVar, str);
            aVar.M(1);
            p64.d(ea4Var, aVar);
        }
    }

    public static void k(hz2 hz2Var, String str, String str2, e eVar, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{hz2Var, str, str2, eVar, str3, Boolean.valueOf(z)}) == null) || eVar == null) {
            return;
        }
        if (hz2Var == null) {
            eVar.c(2111, null);
            return;
        }
        HybridUbcFlow q = ms2.q("route", str3);
        q.F(new UbcFlowEvent("na_start_sub_package_download"));
        q.D("sub_state", "1");
        ha4 ha4Var = new ha4(hz2Var.b, gz2.J().l());
        ha4Var.q(bd3.o(hz2Var.j0()));
        ha4Var.t(str);
        p64.c(ha4Var, new w22(hz2Var.b, new b(z, hz2Var, eVar, str2, str, str3)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) == null) || eVar == null) {
            return;
        }
        ka4 ka4Var = new ka4(str, str2, str5, 0);
        ka4Var.d(str3);
        p64.h(ka4Var, new y22(str, str2, new c(str4, eVar, str6)));
    }

    public static void m(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) == null) {
            n(str, str2, str3, str4, str5, str6, eVar, false);
        }
    }

    public static void n(String str, String str2, String str3, String str4, String str5, String str6, e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{str, str2, str3, str4, str5, str6, eVar, Boolean.valueOf(z)}) == null) || eVar == null) {
            return;
        }
        String e2 = ck2.b().e(str, str4);
        ka4 ka4Var = new ka4(str, str2, str5, 0);
        ka4Var.d(str3);
        p64.h(ka4Var, new y22(str, str2, new d(str4, z, e2, eVar, str6, str, str2, str3, str5)));
    }

    public static boolean o(String str, ab3 ab3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, ab3Var)) == null) {
            long h = ab3Var == null ? 0L : ab3Var.h();
            return SwanAppNetworkUtils.i(oi2.c()) && ck2.b().f(str) && (h == 2101 || h == 2205);
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(ek2 ek2Var, di2.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, ek2Var, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return q(ek2Var, gVar.b);
        }
        return invokeLL.booleanValue;
    }

    public static boolean q(ek2 ek2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, ek2Var, swanAppConfigData)) == null) {
            if (ek2Var != null && !TextUtils.isEmpty(ek2Var.e0()) && !yw1.d() && !gv2.D()) {
                String f2 = zc3.f(ek2Var.e0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.b != null) {
                    String c2 = z23.c(f2, swanAppConfigData);
                    if (swanAppConfigData.b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.c.c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (c74.i().n(ek2Var.H(), ek2Var.v1(), str)) {
                            return !new File(di2.e.i(ek2Var.H(), ek2Var.v1()), str).exists();
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
