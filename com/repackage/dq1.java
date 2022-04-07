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
import com.repackage.o62;
import com.repackage.sz1;
import com.repackage.y33;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dq1 extends aq1 {
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
        public final /* synthetic */ dq1 f;

        /* renamed from: com.repackage.dq1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0405a implements y33.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j03 a;
            public final /* synthetic */ a b;

            public C0405a(a aVar, j03 j03Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, j03Var};
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
                this.a = j03Var;
            }

            @Override // com.repackage.y33.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    pt2.d(this.b.d);
                    jx1.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    o62.e f = o62.f(this.b.a.getActivity(), t62.c(this.b.c.a));
                    String c = f.a.c();
                    a aVar = this.b;
                    s33.m(aVar.f, this.a, c, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.repackage.y33.e
            public void c(int i, cc3 cc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cc3Var) == null) {
                    jx1.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    s33.k(aVar.f, aVar.b);
                    x63.j(this.b.c, cc3Var);
                }
            }
        }

        public a(dq1 dq1Var, wl2 wl2Var, String str, jq2 jq2Var, String str2, sz1 sz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq1Var, wl2Var, str, jq2Var, str2, sz1Var};
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
                    y33.g(L, this.c, "", new C0405a(this, L), this.d);
                    return;
                }
                this.f.d(this.b, new js1(1001, "swan activity is null"));
                x63.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o62.e a;
        public final /* synthetic */ jq2 b;
        public final /* synthetic */ sz1 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ dq1 e;

        public b(dq1 dq1Var, o62.e eVar, jq2 jq2Var, sz1 sz1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq1Var, eVar, jq2Var, sz1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = dq1Var;
            this.a = eVar;
            this.b = jq2Var;
            this.c = sz1Var;
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
    public class c implements o62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ jq2 c;
        public final /* synthetic */ sz1 d;

        public c(dq1 dq1Var, o62.e eVar, String str, jq2 jq2Var, sz1 sz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq1Var, eVar, str, jq2Var, sz1Var};
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
                dq1.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dq1(@NonNull ko1 ko1Var) {
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

    public static void A(sz1 sz1Var, jq2 jq2Var, String str, boolean z) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{sz1Var, jq2Var, str, Boolean.valueOf(z)}) == null) || z() || (x = i03.J().x()) == null || x.isFinishing() || x.isDestroyed()) {
            return;
        }
        pt2.c(z ? 8 : 2, str);
        rz1.R3(de3.n());
        sz1.b i = sz1Var.i("redirectTo");
        i.n(0, 0);
        sz1.b k = i.k("normal", jq2Var);
        k.m(z ? 0 : sz1Var.k() - 2);
        k.b();
        ot2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
        pt2.a(str, jq2Var);
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            j03 a0 = j03.a0();
            return a0 == null || (x = a0.x()) == null || x.isFinishing() || x.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public final void B(o62.e eVar, jq2 jq2Var, sz1 sz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, jq2Var, sz1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = ot2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            o62.q(eVar, new c(this, eVar, str, jq2Var, sz1Var));
        }
    }

    public final void C(o62.e eVar, jq2 jq2Var, sz1 sz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, jq2Var, sz1Var, str) == null) {
            if (de3.O()) {
                B(eVar, jq2Var, sz1Var, str);
            } else {
                de3.a0(new b(this, eVar, jq2Var, sz1Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public js1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            pt2.b(uuid);
            Pair<js1, JSONObject> s = s(str);
            js1 js1Var = (js1) s.first;
            if (js1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = s33.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    jx1.c("RedirectToApi", "url is null");
                    return new js1(202, "url is null");
                }
                wl2 U = wl2.U();
                sz1 V = U.V();
                if (V == null) {
                    jx1.c("RedirectToApi", "manager is null");
                    return new js1(1001, "manager is null");
                }
                jq2 d = jq2.d(p, U.z());
                d.e = "2";
                d.f = uuid;
                x63.g(d);
                if (!de3.b(U.s(), d, false)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    jx1.c("RedirectToApi", str2);
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
                    jx1.c("RedirectToApi", "cb is empty");
                    x63.i(d);
                    return new js1(202, "cb is empty");
                } else if (w23.b().a(d)) {
                    w23.b().i("redirectTo", d);
                    jx1.c("RedirectToApi", "access to this page is prohibited");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }
}
