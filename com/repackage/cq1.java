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
import com.repackage.o53;
import com.repackage.o62;
import com.repackage.sz1;
import com.repackage.y33;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cq1 extends aq1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public yz1 f;

    /* loaded from: classes5.dex */
    public class a implements cf3<m53<o53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wl2 b;
        public final /* synthetic */ sz1 c;
        public final /* synthetic */ jq2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ cq1 g;

        public a(cq1 cq1Var, String str, wl2 wl2Var, sz1 sz1Var, jq2 jq2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq1Var, str, wl2Var, sz1Var, jq2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = cq1Var;
            this.a = str;
            this.b = wl2Var;
            this.c = sz1Var;
            this.d = jq2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(m53<o53.e> m53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m53Var) == null) {
                if (h53.h(m53Var)) {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                } else {
                    this.g.d(this.a, new js1(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ jq2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ sz1 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ cq1 g;

        /* loaded from: classes5.dex */
        public class a implements y33.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j03 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, j03 j03Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, j03Var, activity};
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
                this.a = j03Var;
                this.b = activity;
            }

            @Override // com.repackage.y33.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    pt2.d(this.c.d);
                    jx1.i("NavigateToApi", "check pages success");
                    c73.F(true, this.a.X().T());
                    this.c.a.o();
                    o62.e f = o62.f(this.b, t62.c(this.c.c.a));
                    List<String> g = s33.g(this.c.e);
                    cq1 cq1Var = this.c.g;
                    j03 j03Var = this.a;
                    String c = f.a.c();
                    b bVar = this.c;
                    s33.m(cq1Var, j03Var, c, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.repackage.y33.e
            public void c(int i, cc3 cc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cc3Var) == null) {
                    jx1.c("NavigateToApi", "check pages failed");
                    c73.F(false, this.a.X().T());
                    this.c.a.o();
                    b bVar = this.c;
                    s33.k(bVar.g, bVar.b);
                    x63.j(this.c.c, cc3Var);
                }
            }
        }

        public b(cq1 cq1Var, wl2 wl2Var, String str, jq2 jq2Var, String str2, sz1 sz1Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq1Var, wl2Var, str, jq2Var, str2, sz1Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = cq1Var;
            this.a = wl2Var;
            this.b = str;
            this.c = jq2Var;
            this.d = str2;
            this.e = sz1Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    j03 L = j03.L();
                    if (L == null) {
                        this.g.d(this.b, new js1(1001, "swan app is null"));
                        x63.i(this.c);
                        return;
                    }
                    this.a.a();
                    y33.g(L, this.c, "", new a(this, L, activity), this.d);
                    return;
                }
                this.g.d(this.b, new js1(1001, "swan activity is null"));
                x63.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements o62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ jq2 c;
        public final /* synthetic */ sz1 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ cq1 f;

        public c(cq1 cq1Var, o62.e eVar, String str, jq2 jq2Var, sz1 sz1Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq1Var, eVar, str, jq2Var, sz1Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = cq1Var;
            this.a = eVar;
            this.b = str;
            this.c = jq2Var;
            this.d = sz1Var;
            this.e = str2;
        }

        @Override // com.repackage.o62.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pt2.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pm1 a;
        public final /* synthetic */ jq2 b;
        public final /* synthetic */ sz1 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ cq1 f;

        public d(cq1 cq1Var, pm1 pm1Var, jq2 jq2Var, sz1 sz1Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq1Var, pm1Var, jq2Var, sz1Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = cq1Var;
            this.a = pm1Var;
            this.b = jq2Var;
            this.c = sz1Var;
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

    /* loaded from: classes5.dex */
    public class e extends yz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz1 a;
        public final /* synthetic */ cq1 b;

        public e(cq1 cq1Var, rz1 rz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq1Var, rz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cq1Var;
            this.a = rz1Var;
        }

        @Override // com.repackage.yz1, com.repackage.zz1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.Q2(this.b.f);
                }
            }
        }

        @Override // com.repackage.yz1, com.repackage.zz1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = fz2.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                fz2.h(this.a);
            }
        }

        @Override // com.repackage.yz1, com.repackage.zz1
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = fz2.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                fz2.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755788658, "Lcom/repackage/cq1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755788658, "Lcom/repackage/cq1;");
                return;
            }
        }
        g = qj2.g0().r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cq1(@NonNull ko1 ko1Var) {
        super(ko1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ko1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ko1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(wl2 wl2Var, sz1 sz1Var, jq2 jq2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{wl2Var, sz1Var, jq2Var, str, str2, str3}) == null) {
            de3.a0(new b(this, wl2Var, str3, jq2Var, str, sz1Var, str2));
        }
    }

    public final void D(pm1 pm1Var, jq2 jq2Var, sz1 sz1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pm1Var, jq2Var, sz1Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(pm1Var, jq2Var, sz1Var, str);
            } else {
                G(pm1Var, jq2Var, sz1Var, str);
            }
        }
    }

    public final void E(pm1 pm1Var, jq2 jq2Var, sz1 sz1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, pm1Var, jq2Var, sz1Var, str, str2) == null) {
            if (de3.O()) {
                D(pm1Var, jq2Var, sz1Var, str, str2);
            } else {
                de3.a0(new d(this, pm1Var, jq2Var, sz1Var, str, str2));
            }
        }
    }

    public final void F(pm1 pm1Var, jq2 jq2Var, sz1 sz1Var, String str) {
        SwanAppActivity activity;
        rz1 rz1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, pm1Var, jq2Var, sz1Var, str) == null) || (activity = wl2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        s33.e(pm1Var, jq2Var, str);
        pt2.c(9, str);
        rz1.R3(de3.n());
        sz1.b k = sz1Var.i("showModalPage").k("normal", jq2Var);
        if ((sz1Var.m() instanceof rz1) && (rz1Var = (rz1) sz1Var.m()) != null) {
            rz1Var.D0 = true;
            k.b();
            if (sz1Var.k() > 1) {
                rz1Var.w3().setBackgroundColor(0);
            } else {
                rz1Var.D0 = false;
            }
            rz1Var.y2(false);
            yz1 yz1Var = this.f;
            if (yz1Var != null) {
                rz1Var.Q2(yz1Var);
            }
            e eVar = new e(this, rz1Var);
            this.f = eVar;
            rz1Var.m2(eVar);
            View c2 = fz2.c(rz1Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            fz2.h(rz1Var);
            PullToRefreshBaseWebView k0 = pm1Var.k0();
            if (k0 != null) {
                k0.setIsPreventPullToRefresh(true);
            }
            ot2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            pt2.a(str, jq2Var);
        }
    }

    public final void G(pm1 pm1Var, jq2 jq2Var, sz1 sz1Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, pm1Var, jq2Var, sz1Var, str) == null) || (activity = wl2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        s33.e(pm1Var, jq2Var, str);
        pt2.c(0, str);
        if (sz1Var.k() < g) {
            rz1.R3(de3.n());
            sz1.b i = sz1Var.i("navigateTo");
            i.n(sz1.g, sz1.i);
            i.k("normal", jq2Var).b();
            tc3.c(sz1Var, getContext());
            ot2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            pt2.a(str, jq2Var);
            return;
        }
        dq1.A(sz1Var, jq2Var, str, true);
    }

    public js1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (js1) invokeL.objValue;
    }

    public final js1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            j03 a0 = j03.a0();
            if (a0 == null) {
                return new js1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            pt2.b(uuid);
            Pair<js1, JSONObject> s = s(str);
            js1 js1Var = (js1) s.first;
            if (js1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = s33.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    jx1.c("NavigateToApi", "url is null");
                    return new js1(202, "url is null");
                }
                wl2 U = wl2.U();
                sz1 V = U.V();
                if (V == null) {
                    jx1.c("NavigateToApi", "manager is null");
                    return new js1(1001, "manager is null");
                }
                jq2 d2 = jq2.d(p, U.z());
                d2.e = str2;
                d2.f = uuid;
                x63.g(d2);
                if (!de3.b(U.s(), d2, false)) {
                    String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                    jx1.c("NavigateToApi", str4);
                    x63.i(d2);
                    return new js1(202, str4);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && j03.L() != null) {
                    j03.L().K0(optString, d2.d);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = ot2.q("route", uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    jx1.c("NavigateToApi", "cb is empty");
                    x63.i(d2);
                    return new js1(202, "cb is empty");
                } else if (w23.b().a(d2)) {
                    w23.b().i(str3, d2);
                    jx1.c("NavigateToApi", "access to this page is prohibited");
                    return new js1(1003, "access to this page is prohibited");
                } else {
                    if (TextUtils.equals("7", str2)) {
                        a0.d0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                    } else {
                        C(U, V, d2, uuid, str2, optString3);
                    }
                    return js1.f();
                }
            }
            return js1Var;
        }
        return (js1) invokeLLL.objValue;
    }

    public js1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (js1) invokeL.objValue;
    }

    public final void K(o62.e eVar, jq2 jq2Var, sz1 sz1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, jq2Var, sz1Var, str, str2) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = ot2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            o62.q(eVar, new c(this, eVar, str, jq2Var, sz1Var, str2));
        }
    }

    @Override // com.repackage.mo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }
}
