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
import com.repackage.m53;
import com.repackage.m62;
import com.repackage.qz1;
import com.repackage.w33;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class aq1 extends yp1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public wz1 f;

    /* loaded from: classes5.dex */
    public class a implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ul2 b;
        public final /* synthetic */ qz1 c;
        public final /* synthetic */ hq2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ aq1 g;

        public a(aq1 aq1Var, String str, ul2 ul2Var, qz1 qz1Var, hq2 hq2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq1Var, str, ul2Var, qz1Var, hq2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = aq1Var;
            this.a = str;
            this.b = ul2Var;
            this.c = qz1Var;
            this.d = hq2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (f53.h(k53Var)) {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                } else {
                    this.g.d(this.a, new hs1(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ul2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hq2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ qz1 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ aq1 g;

        /* loaded from: classes5.dex */
        public class a implements w33.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h03 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, h03 h03Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, h03Var, activity};
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
                this.a = h03Var;
                this.b = activity;
            }

            @Override // com.repackage.w33.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    nt2.d(this.c.d);
                    hx1.i("NavigateToApi", "check pages success");
                    a73.F(true, this.a.Y().T());
                    this.c.a.o();
                    m62.e f = m62.f(this.b, r62.c(this.c.c.a));
                    List<String> g = q33.g(this.c.e);
                    aq1 aq1Var = this.c.g;
                    h03 h03Var = this.a;
                    String b = f.a.b();
                    b bVar = this.c;
                    q33.m(aq1Var, h03Var, b, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.repackage.w33.e
            public void b(int i, ac3 ac3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ac3Var) == null) {
                    hx1.c("NavigateToApi", "check pages failed");
                    a73.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    q33.k(bVar.g, bVar.b);
                    v63.j(this.c.c, ac3Var);
                }
            }
        }

        public b(aq1 aq1Var, ul2 ul2Var, String str, hq2 hq2Var, String str2, qz1 qz1Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq1Var, ul2Var, str, hq2Var, str2, qz1Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = aq1Var;
            this.a = ul2Var;
            this.b = str;
            this.c = hq2Var;
            this.d = str2;
            this.e = qz1Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    h03 M = h03.M();
                    if (M == null) {
                        this.g.d(this.b, new hs1(1001, "swan app is null"));
                        v63.i(this.c);
                        return;
                    }
                    this.a.a();
                    w33.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new hs1(1001, "swan activity is null"));
                v63.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements m62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hq2 c;
        public final /* synthetic */ qz1 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ aq1 f;

        public c(aq1 aq1Var, m62.e eVar, String str, hq2 hq2Var, qz1 qz1Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq1Var, eVar, str, hq2Var, qz1Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = aq1Var;
            this.a = eVar;
            this.b = str;
            this.c = hq2Var;
            this.d = qz1Var;
            this.e = str2;
        }

        @Override // com.repackage.m62.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nt2.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm1 a;
        public final /* synthetic */ hq2 b;
        public final /* synthetic */ qz1 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ aq1 f;

        public d(aq1 aq1Var, nm1 nm1Var, hq2 hq2Var, qz1 qz1Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq1Var, nm1Var, hq2Var, qz1Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = aq1Var;
            this.a = nm1Var;
            this.b = hq2Var;
            this.c = qz1Var;
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
    public class e extends wz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz1 a;
        public final /* synthetic */ aq1 b;

        public e(aq1 aq1Var, pz1 pz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq1Var, pz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aq1Var;
            this.a = pz1Var;
        }

        @Override // com.repackage.wz1, com.repackage.xz1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.R2(this.b.f);
                }
            }
        }

        @Override // com.repackage.wz1, com.repackage.xz1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = dz2.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                dz2.h(this.a);
            }
        }

        @Override // com.repackage.wz1, com.repackage.xz1
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = dz2.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                dz2.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755848240, "Lcom/repackage/aq1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755848240, "Lcom/repackage/aq1;");
                return;
            }
        }
        g = oj2.g0().r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq1(@NonNull io1 io1Var) {
        super(io1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((io1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(ul2 ul2Var, qz1 qz1Var, hq2 hq2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{ul2Var, qz1Var, hq2Var, str, str2, str3}) == null) {
            be3.a0(new b(this, ul2Var, str3, hq2Var, str, qz1Var, str2));
        }
    }

    public final void D(nm1 nm1Var, hq2 hq2Var, qz1 qz1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nm1Var, hq2Var, qz1Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(nm1Var, hq2Var, qz1Var, str);
            } else {
                G(nm1Var, hq2Var, qz1Var, str);
            }
        }
    }

    public final void E(nm1 nm1Var, hq2 hq2Var, qz1 qz1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, nm1Var, hq2Var, qz1Var, str, str2) == null) {
            if (be3.O()) {
                D(nm1Var, hq2Var, qz1Var, str, str2);
            } else {
                be3.a0(new d(this, nm1Var, hq2Var, qz1Var, str, str2));
            }
        }
    }

    public final void F(nm1 nm1Var, hq2 hq2Var, qz1 qz1Var, String str) {
        SwanAppActivity activity;
        pz1 pz1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, nm1Var, hq2Var, qz1Var, str) == null) || (activity = ul2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        q33.e(nm1Var, hq2Var, str);
        nt2.c(9, str);
        pz1.S3(be3.n());
        qz1.b k = qz1Var.i("showModalPage").k("normal", hq2Var);
        if ((qz1Var.m() instanceof pz1) && (pz1Var = (pz1) qz1Var.m()) != null) {
            pz1Var.D0 = true;
            k.b();
            if (qz1Var.k() > 1) {
                pz1Var.x3().setBackgroundColor(0);
            } else {
                pz1Var.D0 = false;
            }
            pz1Var.z2(false);
            wz1 wz1Var = this.f;
            if (wz1Var != null) {
                pz1Var.R2(wz1Var);
            }
            e eVar = new e(this, pz1Var);
            this.f = eVar;
            pz1Var.n2(eVar);
            View c2 = dz2.c(pz1Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            dz2.h(pz1Var);
            PullToRefreshBaseWebView j0 = nm1Var.j0();
            if (j0 != null) {
                j0.setIsPreventPullToRefresh(true);
            }
            mt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            nt2.a(str, hq2Var);
        }
    }

    public final void G(nm1 nm1Var, hq2 hq2Var, qz1 qz1Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, nm1Var, hq2Var, qz1Var, str) == null) || (activity = ul2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        q33.e(nm1Var, hq2Var, str);
        nt2.c(0, str);
        if (qz1Var.k() < g) {
            pz1.S3(be3.n());
            qz1.b i = qz1Var.i("navigateTo");
            i.n(qz1.g, qz1.i);
            i.k("normal", hq2Var).b();
            rc3.c(qz1Var, getContext());
            mt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            nt2.a(str, hq2Var);
            return;
        }
        bq1.A(qz1Var, hq2Var, str, true);
    }

    public hs1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (hs1) invokeL.objValue;
    }

    public final hs1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            h03 b0 = h03.b0();
            if (b0 == null) {
                return new hs1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            nt2.b(uuid);
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = q33.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    hx1.c("NavigateToApi", "url is null");
                    return new hs1(202, "url is null");
                }
                ul2 U = ul2.U();
                qz1 V = U.V();
                if (V == null) {
                    hx1.c("NavigateToApi", "manager is null");
                    return new hs1(1001, "manager is null");
                }
                hq2 d2 = hq2.d(p, U.z());
                d2.e = str2;
                d2.f = uuid;
                v63.g(d2);
                if (!be3.b(U.s(), d2, false)) {
                    String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                    hx1.c("NavigateToApi", str4);
                    v63.i(d2);
                    return new hs1(202, str4);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && h03.M() != null) {
                    h03.M().L0(optString, d2.d);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = mt2.q("route", uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    hx1.c("NavigateToApi", "cb is empty");
                    v63.i(d2);
                    return new hs1(202, "cb is empty");
                } else if (u23.b().a(d2)) {
                    u23.b().i(str3, d2);
                    hx1.c("NavigateToApi", "access to this page is prohibited");
                    return new hs1(1003, "access to this page is prohibited");
                } else {
                    if (TextUtils.equals("7", str2)) {
                        b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                    } else {
                        C(U, V, d2, uuid, str2, optString3);
                    }
                    return hs1.f();
                }
            }
            return hs1Var;
        }
        return (hs1) invokeLLL.objValue;
    }

    public hs1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (hs1) invokeL.objValue;
    }

    public final void K(m62.e eVar, hq2 hq2Var, qz1 qz1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, hq2Var, qz1Var, str, str2) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = mt2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            m62.q(eVar, new c(this, eVar, str, hq2Var, qz1Var, str2));
        }
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }
}
