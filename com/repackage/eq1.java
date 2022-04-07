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
import com.repackage.o62;
import com.repackage.sz1;
import com.repackage.y33;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class eq1 extends aq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ jq2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ sz1 e;
        public final /* synthetic */ eq1 f;

        /* renamed from: com.repackage.eq1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0413a implements y33.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ j03 b;
            public final /* synthetic */ a c;

            public C0413a(a aVar, Activity activity, j03 j03Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, j03Var};
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
                this.b = j03Var;
            }

            @Override // com.repackage.y33.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    pt2.d(this.c.d);
                    jx1.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    o62.e f = o62.f(this.a, t62.c(this.c.c.a));
                    String c = f.a.c();
                    a aVar = this.c;
                    s33.m(aVar.f, this.b, c, aVar.c.a, null, aVar.b);
                    t63.t(c);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.repackage.y33.e
            public void c(int i, cc3 cc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cc3Var) == null) {
                    jx1.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    s33.k(aVar.f, aVar.b);
                    x63.j(this.c.c, cc3Var);
                }
            }
        }

        public a(eq1 eq1Var, wl2 wl2Var, String str, jq2 jq2Var, String str2, sz1 sz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eq1Var, wl2Var, str, jq2Var, str2, sz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = eq1Var;
            this.a = wl2Var;
            this.b = str;
            this.c = jq2Var;
            this.d = str2;
            this.e = sz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    j03 L = j03.L();
                    if (L == null) {
                        this.f.d(this.b, new js1(1001, "swan app is null"));
                        x63.i(this.c);
                        return;
                    }
                    this.a.a();
                    y33.g(L, this.c, "", new C0413a(this, activity, L), this.d);
                    return;
                }
                this.f.d(this.b, new js1(1001, "swan activity is null"));
                x63.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements o62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ jq2 c;
        public final /* synthetic */ sz1 d;

        public b(eq1 eq1Var, o62.e eVar, String str, jq2 jq2Var, sz1 sz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eq1Var, eVar, str, jq2Var, sz1Var};
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
            this.c = jq2Var;
            this.d = sz1Var;
        }

        @Override // com.repackage.o62.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pt2.e(this.a, this.b);
                s33.e(this.a.a, this.c, this.b);
                eq1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements sz1.a {
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

        @Override // com.repackage.sz1.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

        @Override // com.repackage.sz1.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof rz1)) {
                ((rz1) fragment).S0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eq1(@NonNull ko1 ko1Var) {
        super(ko1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ko1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ko1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(sz1 sz1Var, jq2 jq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, sz1Var, jq2Var, str) == null) {
            if (jq2Var != null) {
                jx1.i("RelaunchApi", "doReLaunch page=" + jq2Var.a + " routePage=" + jq2Var.d);
            }
            SwanAppActivity x = i03.J().x();
            if (x == null || x.isFinishing() || x.isDestroyed()) {
                return;
            }
            c cVar = new c();
            pt2.c(3, str);
            rz1.R3(de3.n());
            sz1Var.g(cVar);
            sz1.b i = sz1Var.i("reLaunch");
            i.n(0, 0);
            i.f();
            i.k("normal", jq2Var).b();
            sz1Var.p(cVar);
            ot2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            pt2.a(str, jq2Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public js1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            pt2.b(uuid);
            Pair<js1, JSONObject> s = s(str);
            js1 js1Var = (js1) s.first;
            if (js1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = s33.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    jx1.c("RelaunchApi", "url is null");
                    return new js1(202, "url is null");
                }
                wl2 U = wl2.U();
                sz1 V = U.V();
                if (V == null) {
                    jx1.c("RelaunchApi", "manager is null");
                    return new js1(1001, "manager is null");
                }
                jq2 d = jq2.d(p, U.z());
                d.e = "3";
                d.f = uuid;
                x63.g(d);
                if (!de3.b(U.s(), d, true)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    jx1.c("RelaunchApi", str2);
                    x63.i(d);
                    return new js1(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && j03.L() != null) {
                    j03.L().K0(optString, d.d);
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
                    jx1.c("RelaunchApi", "cb is null");
                    x63.i(d);
                    return new js1(202, "cb is null");
                } else if (w23.b().a(d)) {
                    w23.b().i("reLaunch", d);
                    jx1.c("RelaunchApi", "access to this page is prohibited");
                    return new js1(1003, "access to this page is prohibited");
                } else {
                    de3.a0(new a(this, U, optString3, d, uuid, V));
                    return js1.f();
                }
            }
            return js1Var;
        }
        return (js1) invokeL.objValue;
    }

    @Override // com.repackage.mo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    public final void z(o62.e eVar, jq2 jq2Var, sz1 sz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, jq2Var, sz1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = ot2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            o62.q(eVar, new b(this, eVar, str, jq2Var, sz1Var));
        }
    }
}
