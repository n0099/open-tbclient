package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d02;
import com.repackage.j43;
import com.repackage.z53;
import com.repackage.z62;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class nq1 extends lq1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public j02 f;

    /* loaded from: classes6.dex */
    public class a implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hm2 b;
        public final /* synthetic */ d02 c;
        public final /* synthetic */ uq2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ nq1 g;

        public a(nq1 nq1Var, String str, hm2 hm2Var, d02 d02Var, uq2 uq2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nq1Var, str, hm2Var, d02Var, uq2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = nq1Var;
            this.a = str;
            this.b = hm2Var;
            this.c = d02Var;
            this.d = uq2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (s53.h(x53Var)) {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                } else {
                    this.g.d(this.a, new us1(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ uq2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ d02 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ nq1 g;

        /* loaded from: classes6.dex */
        public class a implements j43.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ u03 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, u03 u03Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, u03Var, activity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = u03Var;
                this.b = activity;
            }

            @Override // com.repackage.j43.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    au2.d(this.c.d);
                    ux1.i("NavigateToApi", "check pages success");
                    n73.F(true, this.a.X().T());
                    this.c.a.o();
                    z62.e f = z62.f(this.b, e72.c(this.c.c.a));
                    List<String> g = d43.g(this.c.e);
                    nq1 nq1Var = this.c.g;
                    u03 u03Var = this.a;
                    String c = f.a.c();
                    b bVar = this.c;
                    d43.m(nq1Var, u03Var, c, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.repackage.j43.e
            public void c(int i, nc3 nc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, nc3Var) == null) {
                    ux1.c("NavigateToApi", "check pages failed");
                    n73.F(false, this.a.X().T());
                    this.c.a.o();
                    b bVar = this.c;
                    d43.k(bVar.g, bVar.b);
                    i73.j(this.c.c, nc3Var);
                }
            }
        }

        public b(nq1 nq1Var, hm2 hm2Var, String str, uq2 uq2Var, String str2, d02 d02Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nq1Var, hm2Var, str, uq2Var, str2, d02Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = nq1Var;
            this.a = hm2Var;
            this.b = str;
            this.c = uq2Var;
            this.d = str2;
            this.e = d02Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    u03 L = u03.L();
                    if (L == null) {
                        this.g.d(this.b, new us1(1001, "swan app is null"));
                        i73.i(this.c);
                        return;
                    }
                    this.a.a();
                    j43.g(L, this.c, "", new a(this, L, activity), this.d);
                    return;
                }
                this.g.d(this.b, new us1(1001, "swan activity is null"));
                i73.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements z62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ uq2 c;
        public final /* synthetic */ d02 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ nq1 f;

        public c(nq1 nq1Var, z62.e eVar, String str, uq2 uq2Var, d02 d02Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nq1Var, eVar, str, uq2Var, d02Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = nq1Var;
            this.a = eVar;
            this.b = str;
            this.c = uq2Var;
            this.d = d02Var;
            this.e = str2;
        }

        @Override // com.repackage.z62.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                au2.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ an1 a;
        public final /* synthetic */ uq2 b;
        public final /* synthetic */ d02 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ nq1 f;

        public d(nq1 nq1Var, an1 an1Var, uq2 uq2Var, d02 d02Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nq1Var, an1Var, uq2Var, d02Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = nq1Var;
            this.a = an1Var;
            this.b = uq2Var;
            this.c = d02Var;
            this.d = str;
            this.e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.D(this.a, this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends j02 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c02 a;
        public final /* synthetic */ nq1 b;

        public e(nq1 nq1Var, c02 c02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nq1Var, c02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nq1Var;
            this.a = c02Var;
        }

        @Override // com.repackage.j02, com.repackage.k02
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.Q2(this.b.f);
                }
            }
        }

        @Override // com.repackage.j02, com.repackage.k02
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = qz2.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                qz2.h(this.a);
            }
        }

        @Override // com.repackage.j02, com.repackage.k02
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = qz2.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                qz2.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755460957, "Lcom/repackage/nq1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755460957, "Lcom/repackage/nq1;");
                return;
            }
        }
        g = bk2.g0().r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nq1(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(hm2 hm2Var, d02 d02Var, uq2 uq2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{hm2Var, d02Var, uq2Var, str, str2, str3}) == null) {
            oe3.a0(new b(this, hm2Var, str3, uq2Var, str, d02Var, str2));
        }
    }

    public final void D(an1 an1Var, uq2 uq2Var, d02 d02Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, an1Var, uq2Var, d02Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(an1Var, uq2Var, d02Var, str);
            } else {
                G(an1Var, uq2Var, d02Var, str);
            }
        }
    }

    public final void E(an1 an1Var, uq2 uq2Var, d02 d02Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, an1Var, uq2Var, d02Var, str, str2) == null) {
            if (oe3.O()) {
                D(an1Var, uq2Var, d02Var, str, str2);
            } else {
                oe3.a0(new d(this, an1Var, uq2Var, d02Var, str, str2));
            }
        }
    }

    public final void F(an1 an1Var, uq2 uq2Var, d02 d02Var, String str) {
        SwanAppActivity activity;
        c02 c02Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, an1Var, uq2Var, d02Var, str) == null) || (activity = hm2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        d43.e(an1Var, uq2Var, str);
        au2.c(9, str);
        c02.R3(oe3.n());
        d02.b k = d02Var.i("showModalPage").k("normal", uq2Var);
        if ((d02Var.m() instanceof c02) && (c02Var = (c02) d02Var.m()) != null) {
            c02Var.D0 = true;
            k.b();
            if (d02Var.k() > 1) {
                c02Var.w3().setBackgroundColor(0);
            } else {
                c02Var.D0 = false;
            }
            c02Var.y2(false);
            j02 j02Var = this.f;
            if (j02Var != null) {
                c02Var.Q2(j02Var);
            }
            e eVar = new e(this, c02Var);
            this.f = eVar;
            c02Var.m2(eVar);
            View c2 = qz2.c(c02Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            qz2.h(c02Var);
            PullToRefreshBaseWebView k0 = an1Var.k0();
            if (k0 != null) {
                k0.setIsPreventPullToRefresh(true);
            }
            zt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            au2.a(str, uq2Var);
        }
    }

    public final void G(an1 an1Var, uq2 uq2Var, d02 d02Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, an1Var, uq2Var, d02Var, str) == null) || (activity = hm2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        d43.e(an1Var, uq2Var, str);
        au2.c(0, str);
        if (d02Var.k() < g) {
            c02.R3(oe3.n());
            d02.b i = d02Var.i("navigateTo");
            i.n(d02.g, d02.i);
            i.k("normal", uq2Var).b();
            ed3.c(d02Var, getContext());
            zt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            au2.a(str, uq2Var);
            return;
        }
        oq1.A(d02Var, uq2Var, str, true);
    }

    public us1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (us1) invokeL.objValue;
    }

    public final us1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            u03 a0 = u03.a0();
            if (a0 == null) {
                return new us1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            au2.b(uuid);
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            if (us1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = d43.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    ux1.c("NavigateToApi", "url is null");
                    return new us1(202, "url is null");
                }
                hm2 U = hm2.U();
                d02 V = U.V();
                if (V == null) {
                    ux1.c("NavigateToApi", "manager is null");
                    return new us1(1001, "manager is null");
                }
                uq2 d2 = uq2.d(p, U.z());
                d2.e = str2;
                d2.f = uuid;
                i73.g(d2);
                if (!oe3.b(U.s(), d2, false)) {
                    String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                    ux1.c("NavigateToApi", str4);
                    i73.i(d2);
                    return new us1(202, str4);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && u03.L() != null) {
                    u03.L().K0(optString, d2.d);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = zt2.q("route", uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    ux1.c("NavigateToApi", "cb is empty");
                    i73.i(d2);
                    return new us1(202, "cb is empty");
                } else if (h33.b().a(d2)) {
                    h33.b().i(str3, d2);
                    ux1.c("NavigateToApi", "access to this page is prohibited");
                    return new us1(1003, "access to this page is prohibited");
                } else {
                    if (TextUtils.equals("7", str2)) {
                        a0.d0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                    } else {
                        C(U, V, d2, uuid, str2, optString3);
                    }
                    return us1.f();
                }
            }
            return us1Var;
        }
        return (us1) invokeLLL.objValue;
    }

    public us1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (us1) invokeL.objValue;
    }

    public final void K(z62.e eVar, uq2 uq2Var, d02 d02Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, uq2Var, d02Var, str, str2) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = zt2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            z62.q(eVar, new c(this, eVar, str, uq2Var, d02Var, str2));
        }
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }
}
