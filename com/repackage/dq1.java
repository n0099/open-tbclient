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
import com.repackage.n62;
import com.repackage.rz1;
import com.repackage.x33;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dq1 extends zp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vl2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ iq2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ rz1 e;
        public final /* synthetic */ dq1 f;

        /* renamed from: com.repackage.dq1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0464a implements x33.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ i03 b;
            public final /* synthetic */ a c;

            public C0464a(a aVar, Activity activity, i03 i03Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, i03Var};
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
                this.b = i03Var;
            }

            @Override // com.repackage.x33.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    ot2.d(this.c.d);
                    ix1.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    n62.e f = n62.f(this.a, s62.c(this.c.c.a));
                    String b = f.a.b();
                    a aVar = this.c;
                    r33.m(aVar.f, this.b, b, aVar.c.a, null, aVar.b);
                    s63.t(b);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.repackage.x33.e
            public void b(int i, bc3 bc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bc3Var) == null) {
                    ix1.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    r33.k(aVar.f, aVar.b);
                    w63.j(this.c.c, bc3Var);
                }
            }
        }

        public a(dq1 dq1Var, vl2 vl2Var, String str, iq2 iq2Var, String str2, rz1 rz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq1Var, vl2Var, str, iq2Var, str2, rz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = dq1Var;
            this.a = vl2Var;
            this.b = str;
            this.c = iq2Var;
            this.d = str2;
            this.e = rz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    i03 M = i03.M();
                    if (M == null) {
                        this.f.d(this.b, new is1(1001, "swan app is null"));
                        w63.i(this.c);
                        return;
                    }
                    this.a.a();
                    x33.g(M, this.c, "", new C0464a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new is1(1001, "swan activity is null"));
                w63.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements n62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ iq2 c;
        public final /* synthetic */ rz1 d;

        public b(dq1 dq1Var, n62.e eVar, String str, iq2 iq2Var, rz1 rz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq1Var, eVar, str, iq2Var, rz1Var};
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
            this.c = iq2Var;
            this.d = rz1Var;
        }

        @Override // com.repackage.n62.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ot2.e(this.a, this.b);
                r33.e(this.a.a, this.c, this.b);
                dq1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements rz1.a {
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

        @Override // com.repackage.rz1.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

        @Override // com.repackage.rz1.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof qz1)) {
                ((qz1) fragment).S0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dq1(@NonNull jo1 jo1Var) {
        super(jo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jo1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((jo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(rz1 rz1Var, iq2 iq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, rz1Var, iq2Var, str) == null) {
            if (iq2Var != null) {
                ix1.i("RelaunchApi", "doReLaunch page=" + iq2Var.a + " routePage=" + iq2Var.d);
            }
            SwanAppActivity w = h03.K().w();
            if (w == null || w.isFinishing() || w.isDestroyed()) {
                return;
            }
            c cVar = new c();
            ot2.c(3, str);
            qz1.S3(ce3.n());
            rz1Var.g(cVar);
            rz1.b i = rz1Var.i("reLaunch");
            i.n(0, 0);
            i.f();
            i.k("normal", iq2Var).b();
            rz1Var.p(cVar);
            nt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            ot2.a(str, iq2Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public is1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            ot2.b(uuid);
            Pair<is1, JSONObject> s = s(str);
            is1 is1Var = (is1) s.first;
            if (is1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = r33.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    ix1.c("RelaunchApi", "url is null");
                    return new is1(202, "url is null");
                }
                vl2 U = vl2.U();
                rz1 V = U.V();
                if (V == null) {
                    ix1.c("RelaunchApi", "manager is null");
                    return new is1(1001, "manager is null");
                }
                iq2 d = iq2.d(p, U.z());
                d.e = "3";
                d.f = uuid;
                w63.g(d);
                if (!ce3.b(U.s(), d, true)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    ix1.c("RelaunchApi", str2);
                    w63.i(d);
                    return new is1(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && i03.M() != null) {
                    i03.M().L0(optString, d.d);
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
                    ix1.c("RelaunchApi", "cb is null");
                    w63.i(d);
                    return new is1(202, "cb is null");
                } else if (v23.b().a(d)) {
                    v23.b().i("reLaunch", d);
                    ix1.c("RelaunchApi", "access to this page is prohibited");
                    return new is1(1003, "access to this page is prohibited");
                } else {
                    ce3.a0(new a(this, U, optString3, d, uuid, V));
                    return is1.f();
                }
            }
            return is1Var;
        }
        return (is1) invokeL.objValue;
    }

    @Override // com.repackage.lo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    public final void z(n62.e eVar, iq2 iq2Var, rz1 rz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, iq2Var, rz1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = nt2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            n62.q(eVar, new b(this, eVar, str, iq2Var, rz1Var));
        }
    }
}
