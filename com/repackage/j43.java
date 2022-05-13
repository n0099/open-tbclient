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
import com.repackage.j42;
import com.repackage.qj2;
import com.repackage.rb4;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public class j43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends s32 {
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

        @Override // com.repackage.s32
        public void R(@NonNull nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nc3Var) == null) {
                if (j43.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-fail:" + nc3Var);
                }
                this.h.c(2113, nc3Var);
            }
        }

        @Override // com.repackage.s32
        public void S() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (j43.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-success.");
                }
                this.h.b(this.i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements j42.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ u03 b;
        public final /* synthetic */ e c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public b(boolean z, u03 u03Var, e eVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), u03Var, eVar, str, str2, str3};
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
            this.b = u03Var;
            this.c = eVar;
            this.d = str;
            this.e = str2;
            this.f = str3;
        }

        @Override // com.repackage.j42.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j43.h(this.a, this.b.b, "pkg_retry_fail", String.valueOf(2113));
                this.c.c(2113, null);
            }
        }

        @Override // com.repackage.j42.b
        public void b(nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nc3Var) == null) {
                boolean o = j43.o(this.b.b, nc3Var);
                if (j43.a) {
                    Log.d("PagesRoute", "getAppPackage-isNeedGetPkgRetry:" + o + ",isRetry:" + this.a + ",pmsErrorCode:" + nc3Var);
                }
                if (o) {
                    j43.i(this.b.b, nc3Var);
                    pl2.b().a(this.b.b);
                    j43.k(this.b, this.e, this.d, this.c, this.f, true);
                    return;
                }
                m03.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1306).G();
                j43.h(this.a, this.b.b, "pkg_retry_fail", String.valueOf(nc3Var == null ? 0L : nc3Var.a()));
                this.c.c(2113, nc3Var);
            }
        }

        @Override // com.repackage.j42.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                j43.h(this.a, this.b.b, "pkg_retry_success", "");
                this.c.b(this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements p32 {
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

        @Override // com.repackage.p32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                u03 L = u03.L();
                if (L != null) {
                    L.N0(this.a, true);
                }
                this.b.b(this.c);
            }
        }

        @Override // com.repackage.p32
        public void b(int i, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, nc3Var) == null) {
                this.b.c(i, nc3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements p32 {
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

        @Override // com.repackage.p32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                t03.J().r().N0(this.a, true);
                j43.h(this.b, this.c, "sub_pkg_retry_success", "");
                this.d.b(this.e);
            }
        }

        @Override // com.repackage.p32
        public void b(int i, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, nc3Var) == null) {
                boolean o = j43.o(this.c, nc3Var);
                if (j43.a) {
                    Log.d("PagesRoute", "isNeedGetPkgRetry:" + o + ",isRetry:" + this.b + ",pmsErrorCode:" + nc3Var);
                }
                if (o) {
                    j43.i(this.f, nc3Var);
                    pl2.b().a(this.c);
                    j43.n(this.f, this.g, this.h, this.a, this.i, this.e, this.d, true);
                    return;
                }
                j43.h(this.b, this.c, "sub_pkg_retry_fail", String.valueOf(nc3Var == null ? 0L : nc3Var.a()));
                this.d.c(i, nc3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void b(String str);

        void c(int i, nc3 nc3Var);
    }

    /* loaded from: classes6.dex */
    public static class f implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final e a;
        public final boolean b;

        /* loaded from: classes6.dex */
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

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ nc3 b;
            public final /* synthetic */ f c;

            public b(f fVar, int i, nc3 nc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Integer.valueOf(i), nc3Var};
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
                this.b = nc3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.c.b) {
                        m03.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1306).G();
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

        @Override // com.repackage.j43.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                oe3.e0(new a(this, str));
            }
        }

        @Override // com.repackage.j43.e
        public void c(int i, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, nc3Var) == null) {
                oe3.e0(new b(this, i, nc3Var));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755638680, "Lcom/repackage/j43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755638680, "Lcom/repackage/j43;");
                return;
            }
        }
        a = eh1.a;
    }

    public static void g(u03 u03Var, uq2 uq2Var, String str, e eVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, u03Var, uq2Var, str, eVar, str2) == null) {
            if (u03Var != null) {
                u03Var.B().H(u03Var.getAppId());
            }
            if (eVar == null) {
                return;
            }
            if (u03Var != null && uq2Var != null && !TextUtils.isEmpty(uq2Var.a) && !TextUtils.isEmpty(uq2Var.d)) {
                String str3 = uq2Var.d;
                String b0 = u03Var.b0(uq2Var.a);
                boolean q0 = u03Var.q0(str3);
                if (!ly1.d() && !tw2.H() && !tw2.D()) {
                    if (bw2.k(uq2Var.a)) {
                        eVar.b(str);
                        return;
                    }
                    boolean z = true;
                    if (q0) {
                        boolean A = qj2.A(u03Var.b, u03Var.j0());
                        boolean n0 = u03Var.n0();
                        if (A) {
                            if (!n0) {
                                eVar.b(str);
                                return;
                            }
                            Set<rb4.a> i = bw2.i(u03Var.V().f0());
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
                            k(u03Var, str3, str, eVar, str2, false);
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(b0)) {
                        eVar.c(2111, null);
                        return;
                    } else if (u03Var.s0(b0)) {
                        eVar.b(str);
                        return;
                    } else if (u03Var.u0(b0) && u03Var.t0(b0)) {
                        eVar.b(str);
                        u03Var.N0(b0, true);
                        return;
                    } else {
                        String Q = u03Var.Q(b0);
                        if (TextUtils.isEmpty(Q)) {
                            eVar.c(2112, null);
                            return;
                        }
                        boolean p0 = u03Var.p0(str3);
                        if (!qj2.A(u03Var.b, u03Var.j0()) && !p0) {
                            k(u03Var, str3, str, eVar, str2, false);
                            return;
                        }
                        HybridUbcFlow q = zt2.q("route", str2);
                        q.F(new UbcFlowEvent("na_start_sub_package_download"));
                        q.D("sub_state", "1");
                        m(u03Var.b, u03Var.j0(), "3", b0, Q, str, new f(eVar, true));
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
            pl2.b().g(str);
            n73.L(str2, str3);
        }
    }

    public static void i(String str, nc3 nc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, nc3Var) == null) {
            if ((nc3Var == null ? 0L : nc3Var.h()) == 2205) {
                g92.c().d().u(ye3.a(str), true, 12);
            }
        }
    }

    public static void j(Set<rb4.a> set, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, set, eVar, str) == null) {
            rb4 rb4Var = new rb4(set);
            rb4Var.d("3");
            a aVar = new a(eVar, str);
            aVar.M(1);
            c84.d(rb4Var, aVar);
        }
    }

    public static void k(u03 u03Var, String str, String str2, e eVar, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{u03Var, str, str2, eVar, str3, Boolean.valueOf(z)}) == null) || eVar == null) {
            return;
        }
        if (u03Var == null) {
            eVar.c(2111, null);
            return;
        }
        HybridUbcFlow q = zt2.q("route", str3);
        q.F(new UbcFlowEvent("na_start_sub_package_download"));
        q.D("sub_state", "1");
        ub4 ub4Var = new ub4(u03Var.b, t03.J().l());
        ub4Var.q(oe3.o(u03Var.j0()));
        ub4Var.t(str);
        c84.c(ub4Var, new j42(u03Var.b, new b(z, u03Var, eVar, str2, str, str3)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) == null) || eVar == null) {
            return;
        }
        xb4 xb4Var = new xb4(str, str2, str5, 0);
        xb4Var.d(str3);
        c84.h(xb4Var, new l42(str, str2, new c(str4, eVar, str6)));
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
        String e2 = pl2.b().e(str, str4);
        xb4 xb4Var = new xb4(str, str2, str5, 0);
        xb4Var.d(str3);
        c84.h(xb4Var, new l42(str, str2, new d(str4, z, e2, eVar, str6, str, str2, str3, str5)));
    }

    public static boolean o(String str, nc3 nc3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, nc3Var)) == null) {
            long h = nc3Var == null ? 0L : nc3Var.h();
            return SwanAppNetworkUtils.i(bk2.c()) && pl2.b().f(str) && (h == 2101 || h == 2205);
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(rl2 rl2Var, qj2.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, rl2Var, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return q(rl2Var, gVar.b);
        }
        return invokeLL.booleanValue;
    }

    public static boolean q(rl2 rl2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, rl2Var, swanAppConfigData)) == null) {
            if (rl2Var != null && !TextUtils.isEmpty(rl2Var.e0()) && !ly1.d() && !tw2.D()) {
                String f2 = me3.f(rl2Var.e0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.b != null) {
                    String c2 = m43.c(f2, swanAppConfigData);
                    if (swanAppConfigData.b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.c.c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (p84.i().n(rl2Var.H(), rl2Var.v1(), str)) {
                            return !new File(qj2.e.i(rl2Var.H(), rl2Var.v1()), str).exists();
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
