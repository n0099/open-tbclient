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
import com.repackage.fj2;
import com.repackage.hb4;
import com.repackage.y32;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class y33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends h32 {
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

        @Override // com.repackage.h32
        public void R(@NonNull cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cc3Var) == null) {
                if (y33.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-fail:" + cc3Var);
                }
                this.h.c(2113, cc3Var);
            }
        }

        @Override // com.repackage.h32
        public void S() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (y33.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-success.");
                }
                this.h.b(this.i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements y32.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ j03 b;
        public final /* synthetic */ e c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public b(boolean z, j03 j03Var, e eVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), j03Var, eVar, str, str2, str3};
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
            this.b = j03Var;
            this.c = eVar;
            this.d = str;
            this.e = str2;
            this.f = str3;
        }

        @Override // com.repackage.y32.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y33.h(this.a, this.b.b, "pkg_retry_fail", String.valueOf(2113));
                this.c.c(2113, null);
            }
        }

        @Override // com.repackage.y32.b
        public void b(cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cc3Var) == null) {
                boolean o = y33.o(this.b.b, cc3Var);
                if (y33.a) {
                    Log.d("PagesRoute", "getAppPackage-isNeedGetPkgRetry:" + o + ",isRetry:" + this.a + ",pmsErrorCode:" + cc3Var);
                }
                if (o) {
                    y33.i(this.b.b, cc3Var);
                    el2.b().a(this.b.b);
                    y33.k(this.b, this.e, this.d, this.c, this.f, true);
                    return;
                }
                b03.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f12e6).G();
                y33.h(this.a, this.b.b, "pkg_retry_fail", String.valueOf(cc3Var == null ? 0L : cc3Var.a()));
                this.c.c(2113, cc3Var);
            }
        }

        @Override // com.repackage.y32.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                y33.h(this.a, this.b.b, "pkg_retry_success", "");
                this.c.b(this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements e32 {
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

        @Override // com.repackage.e32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j03 L = j03.L();
                if (L != null) {
                    L.N0(this.a, true);
                }
                this.b.b(this.c);
            }
        }

        @Override // com.repackage.e32
        public void b(int i, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cc3Var) == null) {
                this.b.c(i, cc3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements e32 {
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

        @Override // com.repackage.e32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i03.J().r().N0(this.a, true);
                y33.h(this.b, this.c, "sub_pkg_retry_success", "");
                this.d.b(this.e);
            }
        }

        @Override // com.repackage.e32
        public void b(int i, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cc3Var) == null) {
                boolean o = y33.o(this.c, cc3Var);
                if (y33.a) {
                    Log.d("PagesRoute", "isNeedGetPkgRetry:" + o + ",isRetry:" + this.b + ",pmsErrorCode:" + cc3Var);
                }
                if (o) {
                    y33.i(this.f, cc3Var);
                    el2.b().a(this.c);
                    y33.n(this.f, this.g, this.h, this.a, this.i, this.e, this.d, true);
                    return;
                }
                y33.h(this.b, this.c, "sub_pkg_retry_fail", String.valueOf(cc3Var == null ? 0L : cc3Var.a()));
                this.d.c(i, cc3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void b(String str);

        void c(int i, cc3 cc3Var);
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
            public final /* synthetic */ cc3 b;
            public final /* synthetic */ f c;

            public b(f fVar, int i, cc3 cc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Integer.valueOf(i), cc3Var};
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
                this.b = cc3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.c.b) {
                        b03.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f12e6).G();
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

        @Override // com.repackage.y33.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                de3.e0(new a(this, str));
            }
        }

        @Override // com.repackage.y33.e
        public void c(int i, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cc3Var) == null) {
                de3.e0(new b(this, i, cc3Var));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755192776, "Lcom/repackage/y33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755192776, "Lcom/repackage/y33;");
                return;
            }
        }
        a = tg1.a;
    }

    public static void g(j03 j03Var, jq2 jq2Var, String str, e eVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, j03Var, jq2Var, str, eVar, str2) == null) {
            if (j03Var != null) {
                j03Var.B().H(j03Var.getAppId());
            }
            if (eVar == null) {
                return;
            }
            if (j03Var != null && jq2Var != null && !TextUtils.isEmpty(jq2Var.a) && !TextUtils.isEmpty(jq2Var.d)) {
                String str3 = jq2Var.d;
                String b0 = j03Var.b0(jq2Var.a);
                boolean q0 = j03Var.q0(str3);
                if (!ay1.d() && !iw2.H() && !iw2.D()) {
                    if (qv2.k(jq2Var.a)) {
                        eVar.b(str);
                        return;
                    }
                    boolean z = true;
                    if (q0) {
                        boolean A = fj2.A(j03Var.b, j03Var.j0());
                        boolean n0 = j03Var.n0();
                        if (A) {
                            if (!n0) {
                                eVar.b(str);
                                return;
                            }
                            Set<hb4.a> i = qv2.i(j03Var.V().f0());
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
                            k(j03Var, str3, str, eVar, str2, false);
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(b0)) {
                        eVar.c(2111, null);
                        return;
                    } else if (j03Var.s0(b0)) {
                        eVar.b(str);
                        return;
                    } else if (j03Var.u0(b0) && j03Var.t0(b0)) {
                        eVar.b(str);
                        j03Var.N0(b0, true);
                        return;
                    } else {
                        String Q = j03Var.Q(b0);
                        if (TextUtils.isEmpty(Q)) {
                            eVar.c(2112, null);
                            return;
                        }
                        boolean p0 = j03Var.p0(str3);
                        if (!fj2.A(j03Var.b, j03Var.j0()) && !p0) {
                            k(j03Var, str3, str, eVar, str2, false);
                            return;
                        }
                        HybridUbcFlow q = ot2.q("route", str2);
                        q.F(new UbcFlowEvent("na_start_sub_package_download"));
                        q.D("sub_state", "1");
                        m(j03Var.b, j03Var.j0(), "3", b0, Q, str, new f(eVar, true));
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
            el2.b().g(str);
            c73.L(str2, str3);
        }
    }

    public static void i(String str, cc3 cc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, cc3Var) == null) {
            if ((cc3Var == null ? 0L : cc3Var.h()) == 2205) {
                v82.c().d().u(ne3.a(str), true, 12);
            }
        }
    }

    public static void j(Set<hb4.a> set, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, set, eVar, str) == null) {
            hb4 hb4Var = new hb4(set);
            hb4Var.d("3");
            a aVar = new a(eVar, str);
            aVar.M(1);
            s74.d(hb4Var, aVar);
        }
    }

    public static void k(j03 j03Var, String str, String str2, e eVar, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{j03Var, str, str2, eVar, str3, Boolean.valueOf(z)}) == null) || eVar == null) {
            return;
        }
        if (j03Var == null) {
            eVar.c(2111, null);
            return;
        }
        HybridUbcFlow q = ot2.q("route", str3);
        q.F(new UbcFlowEvent("na_start_sub_package_download"));
        q.D("sub_state", "1");
        kb4 kb4Var = new kb4(j03Var.b, i03.J().l());
        kb4Var.q(de3.o(j03Var.j0()));
        kb4Var.t(str);
        s74.c(kb4Var, new y32(j03Var.b, new b(z, j03Var, eVar, str2, str, str3)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) == null) || eVar == null) {
            return;
        }
        nb4 nb4Var = new nb4(str, str2, str5, 0);
        nb4Var.d(str3);
        s74.h(nb4Var, new a42(str, str2, new c(str4, eVar, str6)));
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
        String e2 = el2.b().e(str, str4);
        nb4 nb4Var = new nb4(str, str2, str5, 0);
        nb4Var.d(str3);
        s74.h(nb4Var, new a42(str, str2, new d(str4, z, e2, eVar, str6, str, str2, str3, str5)));
    }

    public static boolean o(String str, cc3 cc3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, cc3Var)) == null) {
            long h = cc3Var == null ? 0L : cc3Var.h();
            return SwanAppNetworkUtils.i(qj2.c()) && el2.b().f(str) && (h == 2101 || h == 2205);
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(gl2 gl2Var, fj2.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, gl2Var, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return q(gl2Var, gVar.b);
        }
        return invokeLL.booleanValue;
    }

    public static boolean q(gl2 gl2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, gl2Var, swanAppConfigData)) == null) {
            if (gl2Var != null && !TextUtils.isEmpty(gl2Var.e0()) && !ay1.d() && !iw2.D()) {
                String f2 = be3.f(gl2Var.e0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.b != null) {
                    String c2 = b43.c(f2, swanAppConfigData);
                    if (swanAppConfigData.b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.c.c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (f84.i().n(gl2Var.H(), gl2Var.v1(), str)) {
                            return !new File(fj2.e.i(gl2Var.H(), gl2Var.v1()), str).exists();
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
