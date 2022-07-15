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
import com.repackage.dj2;
import com.repackage.eb4;
import com.repackage.w32;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class w33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends f32 {
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

        @Override // com.repackage.f32
        public void Q(@NonNull ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ac3Var) == null) {
                if (w33.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-fail:" + ac3Var);
                }
                this.h.b(2113, ac3Var);
            }
        }

        @Override // com.repackage.f32
        public void R() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (w33.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-success.");
                }
                this.h.a(this.i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements w32.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ h03 b;
        public final /* synthetic */ e c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public b(boolean z, h03 h03Var, e eVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), h03Var, eVar, str, str2, str3};
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
            this.b = h03Var;
            this.c = eVar;
            this.d = str;
            this.e = str2;
            this.f = str3;
        }

        @Override // com.repackage.w32.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                w33.h(this.a, this.b.b, "pkg_retry_fail", String.valueOf(2113));
                this.c.b(2113, null);
            }
        }

        @Override // com.repackage.w32.b
        public void b(ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ac3Var) == null) {
                boolean o = w33.o(this.b.b, ac3Var);
                if (w33.a) {
                    Log.d("PagesRoute", "getAppPackage-isNeedGetPkgRetry:" + o + ",isRetry:" + this.a + ",pmsErrorCode:" + ac3Var);
                }
                if (o) {
                    w33.i(this.b.b, ac3Var);
                    cl2.b().a(this.b.b);
                    w33.k(this.b, this.e, this.d, this.c, this.f, true);
                    return;
                }
                zz2.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f131e).G();
                w33.h(this.a, this.b.b, "pkg_retry_fail", String.valueOf(ac3Var == null ? 0L : ac3Var.a()));
                this.c.b(2113, ac3Var);
            }
        }

        @Override // com.repackage.w32.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                w33.h(this.a, this.b.b, "pkg_retry_success", "");
                this.c.a(this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements c32 {
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

        @Override // com.repackage.c32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h03 M = h03.M();
                if (M != null) {
                    M.O0(this.a, true);
                }
                this.b.a(this.c);
            }
        }

        @Override // com.repackage.c32
        public void b(int i, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ac3Var) == null) {
                this.b.b(i, ac3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements c32 {
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

        @Override // com.repackage.c32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g03.K().q().O0(this.a, true);
                w33.h(this.b, this.c, "sub_pkg_retry_success", "");
                this.d.a(this.e);
            }
        }

        @Override // com.repackage.c32
        public void b(int i, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ac3Var) == null) {
                boolean o = w33.o(this.c, ac3Var);
                if (w33.a) {
                    Log.d("PagesRoute", "isNeedGetPkgRetry:" + o + ",isRetry:" + this.b + ",pmsErrorCode:" + ac3Var);
                }
                if (o) {
                    w33.i(this.f, ac3Var);
                    cl2.b().a(this.c);
                    w33.n(this.f, this.g, this.h, this.a, this.i, this.e, this.d, true);
                    return;
                }
                w33.h(this.b, this.c, "sub_pkg_retry_fail", String.valueOf(ac3Var == null ? 0L : ac3Var.a()));
                this.d.b(i, ac3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(String str);

        void b(int i, ac3 ac3Var);
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
            public final /* synthetic */ ac3 b;
            public final /* synthetic */ f c;

            public b(f fVar, int i, ac3 ac3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Integer.valueOf(i), ac3Var};
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
                this.b = ac3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.c.b) {
                        zz2.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f131e).G();
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

        @Override // com.repackage.w33.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                be3.e0(new a(this, str));
            }
        }

        @Override // com.repackage.w33.e
        public void b(int i, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ac3Var) == null) {
                be3.e0(new b(this, i, ac3Var));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755252358, "Lcom/repackage/w33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755252358, "Lcom/repackage/w33;");
                return;
            }
        }
        a = rg1.a;
    }

    public static void g(h03 h03Var, hq2 hq2Var, String str, e eVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, h03Var, hq2Var, str, eVar, str2) == null) {
            if (h03Var != null) {
                h03Var.B().I(h03Var.getAppId());
            }
            if (eVar == null) {
                return;
            }
            if (h03Var != null && hq2Var != null && !TextUtils.isEmpty(hq2Var.a) && !TextUtils.isEmpty(hq2Var.d)) {
                String str3 = hq2Var.d;
                String c0 = h03Var.c0(hq2Var.a);
                boolean r0 = h03Var.r0(str3);
                if (!yx1.d() && !gw2.H() && !gw2.D()) {
                    if (ov2.k(hq2Var.a)) {
                        eVar.a(str);
                        return;
                    }
                    boolean z = true;
                    if (r0) {
                        boolean A = dj2.A(h03Var.b, h03Var.k0());
                        boolean o0 = h03Var.o0();
                        if (A) {
                            if (!o0) {
                                eVar.a(str);
                                return;
                            }
                            Set<eb4.a> i = ov2.i(h03Var.W().f0());
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
                            k(h03Var, str3, str, eVar, str2, false);
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(c0)) {
                        eVar.b(2111, null);
                        return;
                    } else if (h03Var.t0(c0)) {
                        eVar.a(str);
                        return;
                    } else if (h03Var.v0(c0) && h03Var.u0(c0)) {
                        eVar.a(str);
                        h03Var.O0(c0, true);
                        return;
                    } else {
                        String R = h03Var.R(c0);
                        if (TextUtils.isEmpty(R)) {
                            eVar.b(2112, null);
                            return;
                        }
                        boolean q0 = h03Var.q0(str3);
                        if (!dj2.A(h03Var.b, h03Var.k0()) && !q0) {
                            k(h03Var, str3, str, eVar, str2, false);
                            return;
                        }
                        HybridUbcFlow q = mt2.q("route", str2);
                        q.F(new UbcFlowEvent("na_start_sub_package_download"));
                        q.D("sub_state", "1");
                        m(h03Var.b, h03Var.k0(), "3", c0, R, str, new f(eVar, true));
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
            cl2.b().g(str);
            a73.L(str2, str3);
        }
    }

    public static void i(String str, ac3 ac3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, ac3Var) == null) {
            if ((ac3Var == null ? 0L : ac3Var.h()) == 2205) {
                t82.c().d().u(le3.a(str), true, 12);
            }
        }
    }

    public static void j(Set<eb4.a> set, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, set, eVar, str) == null) {
            eb4 eb4Var = new eb4(set);
            eb4Var.d("3");
            a aVar = new a(eVar, str);
            aVar.L(1);
            p74.d(eb4Var, aVar);
        }
    }

    public static void k(h03 h03Var, String str, String str2, e eVar, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{h03Var, str, str2, eVar, str3, Boolean.valueOf(z)}) == null) || eVar == null) {
            return;
        }
        if (h03Var == null) {
            eVar.b(2111, null);
            return;
        }
        HybridUbcFlow q = mt2.q("route", str3);
        q.F(new UbcFlowEvent("na_start_sub_package_download"));
        q.D("sub_state", "1");
        hb4 hb4Var = new hb4(h03Var.b, g03.K().k());
        hb4Var.q(be3.o(h03Var.k0()));
        hb4Var.t(str);
        p74.c(hb4Var, new w32(h03Var.b, new b(z, h03Var, eVar, str2, str, str3)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) == null) || eVar == null) {
            return;
        }
        kb4 kb4Var = new kb4(str, str2, str5, 0);
        kb4Var.d(str3);
        p74.h(kb4Var, new y32(str, str2, new c(str4, eVar, str6)));
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
        String e2 = cl2.b().e(str, str4);
        kb4 kb4Var = new kb4(str, str2, str5, 0);
        kb4Var.d(str3);
        p74.h(kb4Var, new y32(str, str2, new d(str4, z, e2, eVar, str6, str, str2, str3, str5)));
    }

    public static boolean o(String str, ac3 ac3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, ac3Var)) == null) {
            long h = ac3Var == null ? 0L : ac3Var.h();
            return SwanAppNetworkUtils.i(oj2.c()) && cl2.b().f(str) && (h == 2101 || h == 2205);
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(el2 el2Var, dj2.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, el2Var, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return q(el2Var, gVar.b);
        }
        return invokeLL.booleanValue;
    }

    public static boolean q(el2 el2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, el2Var, swanAppConfigData)) == null) {
            if (el2Var != null && !TextUtils.isEmpty(el2Var.e0()) && !yx1.d() && !gw2.D()) {
                String f2 = zd3.f(el2Var.e0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.b != null) {
                    String c2 = z33.c(f2, swanAppConfigData);
                    if (swanAppConfigData.b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.c.c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (c84.i().n(el2Var.H(), el2Var.v1(), str)) {
                            return !new File(dj2.e.i(el2Var.H(), el2Var.v1()), str).exists();
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
