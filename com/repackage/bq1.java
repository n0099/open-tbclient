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
import com.repackage.n53;
import com.repackage.n62;
import com.repackage.rz1;
import com.repackage.x33;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bq1 extends zp1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public xz1 f;

    /* loaded from: classes5.dex */
    public class a implements bf3<l53<n53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ vl2 b;
        public final /* synthetic */ rz1 c;
        public final /* synthetic */ iq2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ bq1 g;

        public a(bq1 bq1Var, String str, vl2 vl2Var, rz1 rz1Var, iq2 iq2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq1Var, str, vl2Var, rz1Var, iq2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = bq1Var;
            this.a = str;
            this.b = vl2Var;
            this.c = rz1Var;
            this.d = iq2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(l53<n53.e> l53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l53Var) == null) {
                if (g53.h(l53Var)) {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                } else {
                    this.g.d(this.a, new is1(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vl2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ iq2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ rz1 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ bq1 g;

        /* loaded from: classes5.dex */
        public class a implements x33.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i03 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, i03 i03Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, i03Var, activity};
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
                this.a = i03Var;
                this.b = activity;
            }

            @Override // com.repackage.x33.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    ot2.d(this.c.d);
                    ix1.i("NavigateToApi", "check pages success");
                    b73.F(true, this.a.Y().T());
                    this.c.a.o();
                    n62.e f = n62.f(this.b, s62.c(this.c.c.a));
                    List<String> g = r33.g(this.c.e);
                    bq1 bq1Var = this.c.g;
                    i03 i03Var = this.a;
                    String b = f.a.b();
                    b bVar = this.c;
                    r33.m(bq1Var, i03Var, b, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.repackage.x33.e
            public void b(int i, bc3 bc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bc3Var) == null) {
                    ix1.c("NavigateToApi", "check pages failed");
                    b73.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    r33.k(bVar.g, bVar.b);
                    w63.j(this.c.c, bc3Var);
                }
            }
        }

        public b(bq1 bq1Var, vl2 vl2Var, String str, iq2 iq2Var, String str2, rz1 rz1Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq1Var, vl2Var, str, iq2Var, str2, rz1Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = bq1Var;
            this.a = vl2Var;
            this.b = str;
            this.c = iq2Var;
            this.d = str2;
            this.e = rz1Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    i03 M = i03.M();
                    if (M == null) {
                        this.g.d(this.b, new is1(1001, "swan app is null"));
                        w63.i(this.c);
                        return;
                    }
                    this.a.a();
                    x33.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new is1(1001, "swan activity is null"));
                w63.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements n62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ iq2 c;
        public final /* synthetic */ rz1 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ bq1 f;

        public c(bq1 bq1Var, n62.e eVar, String str, iq2 iq2Var, rz1 rz1Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq1Var, eVar, str, iq2Var, rz1Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = bq1Var;
            this.a = eVar;
            this.b = str;
            this.c = iq2Var;
            this.d = rz1Var;
            this.e = str2;
        }

        @Override // com.repackage.n62.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ot2.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om1 a;
        public final /* synthetic */ iq2 b;
        public final /* synthetic */ rz1 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ bq1 f;

        public d(bq1 bq1Var, om1 om1Var, iq2 iq2Var, rz1 rz1Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq1Var, om1Var, iq2Var, rz1Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = bq1Var;
            this.a = om1Var;
            this.b = iq2Var;
            this.c = rz1Var;
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
    public class e extends xz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz1 a;
        public final /* synthetic */ bq1 b;

        public e(bq1 bq1Var, qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq1Var, qz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bq1Var;
            this.a = qz1Var;
        }

        @Override // com.repackage.xz1, com.repackage.yz1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.R2(this.b.f);
                }
            }
        }

        @Override // com.repackage.xz1, com.repackage.yz1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = ez2.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                ez2.h(this.a);
            }
        }

        @Override // com.repackage.xz1, com.repackage.yz1
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = ez2.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                ez2.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755818449, "Lcom/repackage/bq1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755818449, "Lcom/repackage/bq1;");
                return;
            }
        }
        g = pj2.g0().r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bq1(@NonNull jo1 jo1Var) {
        super(jo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jo1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((jo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(vl2 vl2Var, rz1 rz1Var, iq2 iq2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{vl2Var, rz1Var, iq2Var, str, str2, str3}) == null) {
            ce3.a0(new b(this, vl2Var, str3, iq2Var, str, rz1Var, str2));
        }
    }

    public final void D(om1 om1Var, iq2 iq2Var, rz1 rz1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, om1Var, iq2Var, rz1Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(om1Var, iq2Var, rz1Var, str);
            } else {
                G(om1Var, iq2Var, rz1Var, str);
            }
        }
    }

    public final void E(om1 om1Var, iq2 iq2Var, rz1 rz1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, om1Var, iq2Var, rz1Var, str, str2) == null) {
            if (ce3.O()) {
                D(om1Var, iq2Var, rz1Var, str, str2);
            } else {
                ce3.a0(new d(this, om1Var, iq2Var, rz1Var, str, str2));
            }
        }
    }

    public final void F(om1 om1Var, iq2 iq2Var, rz1 rz1Var, String str) {
        SwanAppActivity activity;
        qz1 qz1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, om1Var, iq2Var, rz1Var, str) == null) || (activity = vl2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        r33.e(om1Var, iq2Var, str);
        ot2.c(9, str);
        qz1.S3(ce3.n());
        rz1.b k = rz1Var.i("showModalPage").k("normal", iq2Var);
        if ((rz1Var.m() instanceof qz1) && (qz1Var = (qz1) rz1Var.m()) != null) {
            qz1Var.D0 = true;
            k.b();
            if (rz1Var.k() > 1) {
                qz1Var.x3().setBackgroundColor(0);
            } else {
                qz1Var.D0 = false;
            }
            qz1Var.z2(false);
            xz1 xz1Var = this.f;
            if (xz1Var != null) {
                qz1Var.R2(xz1Var);
            }
            e eVar = new e(this, qz1Var);
            this.f = eVar;
            qz1Var.n2(eVar);
            View c2 = ez2.c(qz1Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            ez2.h(qz1Var);
            PullToRefreshBaseWebView j0 = om1Var.j0();
            if (j0 != null) {
                j0.setIsPreventPullToRefresh(true);
            }
            nt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            ot2.a(str, iq2Var);
        }
    }

    public final void G(om1 om1Var, iq2 iq2Var, rz1 rz1Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, om1Var, iq2Var, rz1Var, str) == null) || (activity = vl2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        r33.e(om1Var, iq2Var, str);
        ot2.c(0, str);
        if (rz1Var.k() < g) {
            qz1.S3(ce3.n());
            rz1.b i = rz1Var.i("navigateTo");
            i.n(rz1.g, rz1.i);
            i.k("normal", iq2Var).b();
            sc3.c(rz1Var, getContext());
            nt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            ot2.a(str, iq2Var);
            return;
        }
        cq1.A(rz1Var, iq2Var, str, true);
    }

    public is1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (is1) invokeL.objValue;
    }

    public final is1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            i03 b0 = i03.b0();
            if (b0 == null) {
                return new is1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            ot2.b(uuid);
            Pair<is1, JSONObject> s = s(str);
            is1 is1Var = (is1) s.first;
            if (is1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = r33.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    ix1.c("NavigateToApi", "url is null");
                    return new is1(202, "url is null");
                }
                vl2 U = vl2.U();
                rz1 V = U.V();
                if (V == null) {
                    ix1.c("NavigateToApi", "manager is null");
                    return new is1(1001, "manager is null");
                }
                iq2 d2 = iq2.d(p, U.z());
                d2.e = str2;
                d2.f = uuid;
                w63.g(d2);
                if (!ce3.b(U.s(), d2, false)) {
                    String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                    ix1.c("NavigateToApi", str4);
                    w63.i(d2);
                    return new is1(202, str4);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && i03.M() != null) {
                    i03.M().L0(optString, d2.d);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = nt2.q("route", uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    ix1.c("NavigateToApi", "cb is empty");
                    w63.i(d2);
                    return new is1(202, "cb is empty");
                } else if (v23.b().a(d2)) {
                    v23.b().i(str3, d2);
                    ix1.c("NavigateToApi", "access to this page is prohibited");
                    return new is1(1003, "access to this page is prohibited");
                } else {
                    if (TextUtils.equals("7", str2)) {
                        b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                    } else {
                        C(U, V, d2, uuid, str2, optString3);
                    }
                    return is1.f();
                }
            }
            return is1Var;
        }
        return (is1) invokeLLL.objValue;
    }

    public is1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (is1) invokeL.objValue;
    }

    public final void K(n62.e eVar, iq2 iq2Var, rz1 rz1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, iq2Var, rz1Var, str, str2) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = nt2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            n62.q(eVar, new c(this, eVar, str, iq2Var, rz1Var, str2));
        }
    }

    @Override // com.repackage.lo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }
}
