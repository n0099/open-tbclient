package com.repackage;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
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
public class cq1 extends zp1 {
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
        public final /* synthetic */ cq1 f;

        /* renamed from: com.repackage.cq1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0454a implements x33.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i03 a;
            public final /* synthetic */ a b;

            public C0454a(a aVar, i03 i03Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, i03Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = i03Var;
            }

            @Override // com.repackage.x33.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    ot2.d(this.b.d);
                    ix1.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    n62.e f = n62.f(this.b.a.getActivity(), s62.c(this.b.c.a));
                    String b = f.a.b();
                    a aVar = this.b;
                    r33.m(aVar.f, this.a, b, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.repackage.x33.e
            public void b(int i, bc3 bc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bc3Var) == null) {
                    ix1.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    r33.k(aVar.f, aVar.b);
                    w63.j(this.b.c, bc3Var);
                }
            }
        }

        public a(cq1 cq1Var, vl2 vl2Var, String str, iq2 iq2Var, String str2, rz1 rz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq1Var, vl2Var, str, iq2Var, str2, rz1Var};
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
                    x33.g(M, this.c, "", new C0454a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new is1(1001, "swan activity is null"));
                w63.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n62.e a;
        public final /* synthetic */ iq2 b;
        public final /* synthetic */ rz1 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ cq1 e;

        public b(cq1 cq1Var, n62.e eVar, iq2 iq2Var, rz1 rz1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq1Var, eVar, iq2Var, rz1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = cq1Var;
            this.a = eVar;
            this.b = iq2Var;
            this.c = rz1Var;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.B(this.a, this.b, this.c, this.d);
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

        public c(cq1 cq1Var, n62.e eVar, String str, iq2 iq2Var, rz1 rz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq1Var, eVar, str, iq2Var, rz1Var};
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
                cq1.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cq1(@NonNull jo1 jo1Var) {
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

    public static void A(rz1 rz1Var, iq2 iq2Var, String str, boolean z) {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{rz1Var, iq2Var, str, Boolean.valueOf(z)}) == null) || z() || (w = h03.K().w()) == null || w.isFinishing() || w.isDestroyed()) {
            return;
        }
        ot2.c(z ? 8 : 2, str);
        qz1.S3(ce3.n());
        rz1.b i = rz1Var.i("redirectTo");
        i.n(0, 0);
        rz1.b k = i.k("normal", iq2Var);
        k.m(z ? 0 : rz1Var.k() - 2);
        k.b();
        nt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
        ot2.a(str, iq2Var);
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            i03 b0 = i03.b0();
            return b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public final void B(n62.e eVar, iq2 iq2Var, rz1 rz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, iq2Var, rz1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = nt2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            n62.q(eVar, new c(this, eVar, str, iq2Var, rz1Var));
        }
    }

    public final void C(n62.e eVar, iq2 iq2Var, rz1 rz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, iq2Var, rz1Var, str) == null) {
            if (ce3.O()) {
                B(eVar, iq2Var, rz1Var, str);
            } else {
                ce3.a0(new b(this, eVar, iq2Var, rz1Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public is1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            ot2.b(uuid);
            Pair<is1, JSONObject> s = s(str);
            is1 is1Var = (is1) s.first;
            if (is1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = r33.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    ix1.c("RedirectToApi", "url is null");
                    return new is1(202, "url is null");
                }
                vl2 U = vl2.U();
                rz1 V = U.V();
                if (V == null) {
                    ix1.c("RedirectToApi", "manager is null");
                    return new is1(1001, "manager is null");
                }
                iq2 d = iq2.d(p, U.z());
                d.e = "2";
                d.f = uuid;
                w63.g(d);
                if (!ce3.b(U.s(), d, false)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    ix1.c("RedirectToApi", str2);
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
                    ix1.c("RedirectToApi", "cb is empty");
                    w63.i(d);
                    return new is1(202, "cb is empty");
                } else if (v23.b().a(d)) {
                    v23.b().i("redirectTo", d);
                    ix1.c("RedirectToApi", "access to this page is prohibited");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }
}
