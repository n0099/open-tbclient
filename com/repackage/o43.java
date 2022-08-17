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
import com.repackage.o42;
import com.repackage.vj2;
import com.repackage.wb4;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class o43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends x32 {
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

        @Override // com.repackage.x32
        public void Q(@NonNull sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sc3Var) == null) {
                if (o43.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-fail:" + sc3Var);
                }
                this.h.b(2113, sc3Var);
            }
        }

        @Override // com.repackage.x32
        public void R() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (o43.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-success.");
                }
                this.h.a(this.i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements o42.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ z03 b;
        public final /* synthetic */ e c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public b(boolean z, z03 z03Var, e eVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), z03Var, eVar, str, str2, str3};
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
            this.b = z03Var;
            this.c = eVar;
            this.d = str;
            this.e = str2;
            this.f = str3;
        }

        @Override // com.repackage.o42.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o43.h(this.a, this.b.b, "pkg_retry_fail", String.valueOf(2113));
                this.c.b(2113, null);
            }
        }

        @Override // com.repackage.o42.b
        public void b(sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sc3Var) == null) {
                boolean o = o43.o(this.b.b, sc3Var);
                if (o43.a) {
                    Log.d("PagesRoute", "getAppPackage-isNeedGetPkgRetry:" + o + ",isRetry:" + this.a + ",pmsErrorCode:" + sc3Var);
                }
                if (o) {
                    o43.i(this.b.b, sc3Var);
                    ul2.b().a(this.b.b);
                    o43.k(this.b, this.e, this.d, this.c, this.f, true);
                    return;
                }
                r03.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f130b).G();
                o43.h(this.a, this.b.b, "pkg_retry_fail", String.valueOf(sc3Var == null ? 0L : sc3Var.a()));
                this.c.b(2113, sc3Var);
            }
        }

        @Override // com.repackage.o42.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                o43.h(this.a, this.b.b, "pkg_retry_success", "");
                this.c.a(this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements u32 {
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

        @Override // com.repackage.u32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z03 M = z03.M();
                if (M != null) {
                    M.O0(this.a, true);
                }
                this.b.a(this.c);
            }
        }

        @Override // com.repackage.u32
        public void b(int i, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, sc3Var) == null) {
                this.b.b(i, sc3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements u32 {
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

        @Override // com.repackage.u32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y03.K().q().O0(this.a, true);
                o43.h(this.b, this.c, "sub_pkg_retry_success", "");
                this.d.a(this.e);
            }
        }

        @Override // com.repackage.u32
        public void b(int i, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, sc3Var) == null) {
                boolean o = o43.o(this.c, sc3Var);
                if (o43.a) {
                    Log.d("PagesRoute", "isNeedGetPkgRetry:" + o + ",isRetry:" + this.b + ",pmsErrorCode:" + sc3Var);
                }
                if (o) {
                    o43.i(this.f, sc3Var);
                    ul2.b().a(this.c);
                    o43.n(this.f, this.g, this.h, this.a, this.i, this.e, this.d, true);
                    return;
                }
                o43.h(this.b, this.c, "sub_pkg_retry_fail", String.valueOf(sc3Var == null ? 0L : sc3Var.a()));
                this.d.b(i, sc3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(String str);

        void b(int i, sc3 sc3Var);
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
                    this.b.a.a(this.a);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ sc3 b;
            public final /* synthetic */ f c;

            public b(f fVar, int i, sc3 sc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Integer.valueOf(i), sc3Var};
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
                this.b = sc3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.c.b) {
                        r03.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f130b).G();
                    }
                    this.c.a.b(this.a, this.b);
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

        @Override // com.repackage.o43.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                te3.e0(new a(this, str));
            }
        }

        @Override // com.repackage.o43.e
        public void b(int i, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, sc3Var) == null) {
                te3.e0(new b(this, i, sc3Var));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755489725, "Lcom/repackage/o43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755489725, "Lcom/repackage/o43;");
                return;
            }
        }
        a = jh1.a;
    }

    public static void g(z03 z03Var, zq2 zq2Var, String str, e eVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, z03Var, zq2Var, str, eVar, str2) == null) {
            if (z03Var != null) {
                z03Var.B().I(z03Var.getAppId());
            }
            if (eVar == null) {
                return;
            }
            if (z03Var != null && zq2Var != null && !TextUtils.isEmpty(zq2Var.a) && !TextUtils.isEmpty(zq2Var.d)) {
                String str3 = zq2Var.d;
                String c0 = z03Var.c0(zq2Var.a);
                boolean r0 = z03Var.r0(str3);
                if (!qy1.d() && !yw2.H() && !yw2.D()) {
                    if (gw2.k(zq2Var.a)) {
                        eVar.a(str);
                        return;
                    }
                    boolean z = true;
                    if (r0) {
                        boolean A = vj2.A(z03Var.b, z03Var.k0());
                        boolean o0 = z03Var.o0();
                        if (A) {
                            if (!o0) {
                                eVar.a(str);
                                return;
                            }
                            Set<wb4.a> i = gw2.i(z03Var.W().f0());
                            if (i != null && !i.isEmpty()) {
                                z = false;
                            }
                            if (z) {
                                eVar.a(str);
                                return;
                            } else {
                                j(i, eVar, str);
                                return;
                            }
                        } else if (o0) {
                            k(z03Var, str3, str, eVar, str2, false);
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(c0)) {
                        eVar.b(2111, null);
                        return;
                    } else if (z03Var.t0(c0)) {
                        eVar.a(str);
                        return;
                    } else if (z03Var.v0(c0) && z03Var.u0(c0)) {
                        eVar.a(str);
                        z03Var.O0(c0, true);
                        return;
                    } else {
                        String R = z03Var.R(c0);
                        if (TextUtils.isEmpty(R)) {
                            eVar.b(2112, null);
                            return;
                        }
                        boolean q0 = z03Var.q0(str3);
                        if (!vj2.A(z03Var.b, z03Var.k0()) && !q0) {
                            k(z03Var, str3, str, eVar, str2, false);
                            return;
                        }
                        HybridUbcFlow q = eu2.q("route", str2);
                        q.F(new UbcFlowEvent("na_start_sub_package_download"));
                        q.D("sub_state", "1");
                        m(z03Var.b, z03Var.k0(), "3", c0, R, str, new f(eVar, true));
                        return;
                    }
                } else if (!r0 && TextUtils.isEmpty(c0)) {
                    eVar.b(2111, null);
                    return;
                } else {
                    eVar.a(str);
                    return;
                }
            }
            eVar.b(2110, null);
        }
    }

    public static void h(boolean z, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) && z) {
            ul2.b().g(str);
            s73.L(str2, str3);
        }
    }

    public static void i(String str, sc3 sc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, sc3Var) == null) {
            if ((sc3Var == null ? 0L : sc3Var.h()) == 2205) {
                l92.c().d().u(df3.a(str), true, 12);
            }
        }
    }

    public static void j(Set<wb4.a> set, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, set, eVar, str) == null) {
            wb4 wb4Var = new wb4(set);
            wb4Var.d("3");
            a aVar = new a(eVar, str);
            aVar.L(1);
            h84.d(wb4Var, aVar);
        }
    }

    public static void k(z03 z03Var, String str, String str2, e eVar, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{z03Var, str, str2, eVar, str3, Boolean.valueOf(z)}) == null) || eVar == null) {
            return;
        }
        if (z03Var == null) {
            eVar.b(2111, null);
            return;
        }
        HybridUbcFlow q = eu2.q("route", str3);
        q.F(new UbcFlowEvent("na_start_sub_package_download"));
        q.D("sub_state", "1");
        zb4 zb4Var = new zb4(z03Var.b, y03.K().k());
        zb4Var.q(te3.o(z03Var.k0()));
        zb4Var.t(str);
        h84.c(zb4Var, new o42(z03Var.b, new b(z, z03Var, eVar, str2, str, str3)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) == null) || eVar == null) {
            return;
        }
        cc4 cc4Var = new cc4(str, str2, str5, 0);
        cc4Var.d(str3);
        h84.h(cc4Var, new q42(str, str2, new c(str4, eVar, str6)));
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
        String e2 = ul2.b().e(str, str4);
        cc4 cc4Var = new cc4(str, str2, str5, 0);
        cc4Var.d(str3);
        h84.h(cc4Var, new q42(str, str2, new d(str4, z, e2, eVar, str6, str, str2, str3, str5)));
    }

    public static boolean o(String str, sc3 sc3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, sc3Var)) == null) {
            long h = sc3Var == null ? 0L : sc3Var.h();
            return SwanAppNetworkUtils.i(gk2.c()) && ul2.b().f(str) && (h == 2101 || h == 2205);
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(wl2 wl2Var, vj2.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, wl2Var, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return q(wl2Var, gVar.b);
        }
        return invokeLL.booleanValue;
    }

    public static boolean q(wl2 wl2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, wl2Var, swanAppConfigData)) == null) {
            if (wl2Var != null && !TextUtils.isEmpty(wl2Var.e0()) && !qy1.d() && !yw2.D()) {
                String f2 = re3.f(wl2Var.e0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.b != null) {
                    String c2 = r43.c(f2, swanAppConfigData);
                    if (swanAppConfigData.b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.c.c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (u84.i().n(wl2Var.H(), wl2Var.v1(), str)) {
                            return !new File(vj2.e.i(wl2Var.H(), wl2Var.v1()), str).exists();
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
