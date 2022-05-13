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
import com.repackage.d02;
import com.repackage.j43;
import com.repackage.z62;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class pq1 extends lq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ uq2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ d02 e;
        public final /* synthetic */ pq1 f;

        /* renamed from: com.repackage.pq1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0494a implements j43.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ u03 b;
            public final /* synthetic */ a c;

            public C0494a(a aVar, Activity activity, u03 u03Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, u03Var};
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
                this.b = u03Var;
            }

            @Override // com.repackage.j43.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    au2.d(this.c.d);
                    ux1.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    z62.e f = z62.f(this.a, e72.c(this.c.c.a));
                    String c = f.a.c();
                    a aVar = this.c;
                    d43.m(aVar.f, this.b, c, aVar.c.a, null, aVar.b);
                    e73.t(c);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.repackage.j43.e
            public void c(int i, nc3 nc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, nc3Var) == null) {
                    ux1.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    d43.k(aVar.f, aVar.b);
                    i73.j(this.c.c, nc3Var);
                }
            }
        }

        public a(pq1 pq1Var, hm2 hm2Var, String str, uq2 uq2Var, String str2, d02 d02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pq1Var, hm2Var, str, uq2Var, str2, d02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = pq1Var;
            this.a = hm2Var;
            this.b = str;
            this.c = uq2Var;
            this.d = str2;
            this.e = d02Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    u03 L = u03.L();
                    if (L == null) {
                        this.f.d(this.b, new us1(1001, "swan app is null"));
                        i73.i(this.c);
                        return;
                    }
                    this.a.a();
                    j43.g(L, this.c, "", new C0494a(this, activity, L), this.d);
                    return;
                }
                this.f.d(this.b, new us1(1001, "swan activity is null"));
                i73.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements z62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ uq2 c;
        public final /* synthetic */ d02 d;

        public b(pq1 pq1Var, z62.e eVar, String str, uq2 uq2Var, d02 d02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pq1Var, eVar, str, uq2Var, d02Var};
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
            this.c = uq2Var;
            this.d = d02Var;
        }

        @Override // com.repackage.z62.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                au2.e(this.a, this.b);
                d43.e(this.a.a, this.c, this.b);
                pq1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements d02.a {
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

        @Override // com.repackage.d02.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

        @Override // com.repackage.d02.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof c02)) {
                ((c02) fragment).S0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pq1(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(d02 d02Var, uq2 uq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, d02Var, uq2Var, str) == null) {
            if (uq2Var != null) {
                ux1.i("RelaunchApi", "doReLaunch page=" + uq2Var.a + " routePage=" + uq2Var.d);
            }
            SwanAppActivity x = t03.J().x();
            if (x == null || x.isFinishing() || x.isDestroyed()) {
                return;
            }
            c cVar = new c();
            au2.c(3, str);
            c02.R3(oe3.n());
            d02Var.g(cVar);
            d02.b i = d02Var.i("reLaunch");
            i.n(0, 0);
            i.f();
            i.k("normal", uq2Var).b();
            d02Var.p(cVar);
            zt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            au2.a(str, uq2Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public us1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            au2.b(uuid);
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            if (us1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = d43.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    ux1.c("RelaunchApi", "url is null");
                    return new us1(202, "url is null");
                }
                hm2 U = hm2.U();
                d02 V = U.V();
                if (V == null) {
                    ux1.c("RelaunchApi", "manager is null");
                    return new us1(1001, "manager is null");
                }
                uq2 d = uq2.d(p, U.z());
                d.e = "3";
                d.f = uuid;
                i73.g(d);
                if (!oe3.b(U.s(), d, true)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    ux1.c("RelaunchApi", str2);
                    i73.i(d);
                    return new us1(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && u03.L() != null) {
                    u03.L().K0(optString, d.d);
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
                    ux1.c("RelaunchApi", "cb is null");
                    i73.i(d);
                    return new us1(202, "cb is null");
                } else if (h33.b().a(d)) {
                    h33.b().i("reLaunch", d);
                    ux1.c("RelaunchApi", "access to this page is prohibited");
                    return new us1(1003, "access to this page is prohibited");
                } else {
                    oe3.a0(new a(this, U, optString3, d, uuid, V));
                    return us1.f();
                }
            }
            return us1Var;
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    public final void z(z62.e eVar, uq2 uq2Var, d02 d02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, uq2Var, d02Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = zt2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            z62.q(eVar, new b(this, eVar, str, uq2Var, d02Var));
        }
    }
}
