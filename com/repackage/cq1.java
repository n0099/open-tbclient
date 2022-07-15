package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m62;
import com.repackage.qz1;
import com.repackage.w33;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cq1 extends yp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ul2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hq2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ qz1 e;
        public final /* synthetic */ cq1 f;

        /* renamed from: com.repackage.cq1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0609a implements w33.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ h03 b;
            public final /* synthetic */ a c;

            public C0609a(a aVar, Activity activity, h03 h03Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, h03Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = activity;
                this.b = h03Var;
            }

            @Override // com.repackage.w33.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    nt2.d(this.c.d);
                    hx1.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    m62.e f = m62.f(this.a, r62.c(this.c.c.a));
                    String b = f.a.b();
                    a aVar = this.c;
                    q33.m(aVar.f, this.b, b, aVar.c.a, null, aVar.b);
                    r63.t(b);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.repackage.w33.e
            public void b(int i, ac3 ac3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ac3Var) == null) {
                    hx1.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    q33.k(aVar.f, aVar.b);
                    v63.j(this.c.c, ac3Var);
                }
            }
        }

        public a(cq1 cq1Var, ul2 ul2Var, String str, hq2 hq2Var, String str2, qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq1Var, ul2Var, str, hq2Var, str2, qz1Var};
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
            this.a = ul2Var;
            this.b = str;
            this.c = hq2Var;
            this.d = str2;
            this.e = qz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    h03 M = h03.M();
                    if (M == null) {
                        this.f.d(this.b, new hs1(1001, "swan app is null"));
                        v63.i(this.c);
                        return;
                    }
                    this.a.a();
                    w33.g(M, this.c, "", new C0609a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new hs1(1001, "swan activity is null"));
                v63.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements m62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hq2 c;
        public final /* synthetic */ qz1 d;

        public b(cq1 cq1Var, m62.e eVar, String str, hq2 hq2Var, qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq1Var, eVar, str, hq2Var, qz1Var};
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
            this.b = str;
            this.c = hq2Var;
            this.d = qz1Var;
        }

        @Override // com.repackage.m62.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nt2.e(this.a, this.b);
                q33.e(this.a.a, this.c, this.b);
                cq1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements qz1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.qz1.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

        @Override // com.repackage.qz1.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof pz1)) {
                ((pz1) fragment).S0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cq1(@NonNull io1 io1Var) {
        super(io1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((io1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(qz1 qz1Var, hq2 hq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, qz1Var, hq2Var, str) == null) {
            if (hq2Var != null) {
                hx1.i("RelaunchApi", "doReLaunch page=" + hq2Var.a + " routePage=" + hq2Var.d);
            }
            SwanAppActivity w = g03.K().w();
            if (w == null || w.isFinishing() || w.isDestroyed()) {
                return;
            }
            c cVar = new c();
            nt2.c(3, str);
            pz1.S3(be3.n());
            qz1Var.g(cVar);
            qz1.b i = qz1Var.i("reLaunch");
            i.n(0, 0);
            i.f();
            i.k("normal", hq2Var).b();
            qz1Var.p(cVar);
            mt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            nt2.a(str, hq2Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public hs1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            nt2.b(uuid);
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = q33.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    hx1.c("RelaunchApi", "url is null");
                    return new hs1(202, "url is null");
                }
                ul2 U = ul2.U();
                qz1 V = U.V();
                if (V == null) {
                    hx1.c("RelaunchApi", "manager is null");
                    return new hs1(1001, "manager is null");
                }
                hq2 d = hq2.d(p, U.z());
                d.e = "3";
                d.f = uuid;
                v63.g(d);
                if (!be3.b(U.s(), d, true)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    hx1.c("RelaunchApi", str2);
                    v63.i(d);
                    return new hs1(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && h03.M() != null) {
                    h03.M().L0(optString, d.d);
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
                    hx1.c("RelaunchApi", "cb is null");
                    v63.i(d);
                    return new hs1(202, "cb is null");
                } else if (u23.b().a(d)) {
                    u23.b().i("reLaunch", d);
                    hx1.c("RelaunchApi", "access to this page is prohibited");
                    return new hs1(1003, "access to this page is prohibited");
                } else {
                    be3.a0(new a(this, U, optString3, d, uuid, V));
                    return hs1.f();
                }
            }
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    public final void z(m62.e eVar, hq2 hq2Var, qz1 qz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, hq2Var, qz1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = mt2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            m62.q(eVar, new b(this, eVar, str, hq2Var, qz1Var));
        }
    }
}
