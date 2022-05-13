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
import com.repackage.d02;
import com.repackage.j43;
import com.repackage.z62;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class oq1 extends lq1 {
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
        public final /* synthetic */ oq1 f;

        /* renamed from: com.repackage.oq1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0485a implements j43.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ u03 a;
            public final /* synthetic */ a b;

            public C0485a(a aVar, u03 u03Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, u03Var};
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
                this.a = u03Var;
            }

            @Override // com.repackage.j43.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    au2.d(this.b.d);
                    ux1.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    z62.e f = z62.f(this.b.a.getActivity(), e72.c(this.b.c.a));
                    String c = f.a.c();
                    a aVar = this.b;
                    d43.m(aVar.f, this.a, c, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.repackage.j43.e
            public void c(int i, nc3 nc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, nc3Var) == null) {
                    ux1.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    d43.k(aVar.f, aVar.b);
                    i73.j(this.b.c, nc3Var);
                }
            }
        }

        public a(oq1 oq1Var, hm2 hm2Var, String str, uq2 uq2Var, String str2, d02 d02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq1Var, hm2Var, str, uq2Var, str2, d02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = oq1Var;
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
                    j43.g(L, this.c, "", new C0485a(this, L), this.d);
                    return;
                }
                this.f.d(this.b, new us1(1001, "swan activity is null"));
                i73.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z62.e a;
        public final /* synthetic */ uq2 b;
        public final /* synthetic */ d02 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ oq1 e;

        public b(oq1 oq1Var, z62.e eVar, uq2 uq2Var, d02 d02Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq1Var, eVar, uq2Var, d02Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = oq1Var;
            this.a = eVar;
            this.b = uq2Var;
            this.c = d02Var;
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

    /* loaded from: classes6.dex */
    public class c implements z62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ uq2 c;
        public final /* synthetic */ d02 d;

        public c(oq1 oq1Var, z62.e eVar, String str, uq2 uq2Var, d02 d02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq1Var, eVar, str, uq2Var, d02Var};
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
                oq1.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oq1(@NonNull vo1 vo1Var) {
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

    public static void A(d02 d02Var, uq2 uq2Var, String str, boolean z) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{d02Var, uq2Var, str, Boolean.valueOf(z)}) == null) || z() || (x = t03.J().x()) == null || x.isFinishing() || x.isDestroyed()) {
            return;
        }
        au2.c(z ? 8 : 2, str);
        c02.R3(oe3.n());
        d02.b i = d02Var.i("redirectTo");
        i.n(0, 0);
        d02.b k = i.k("normal", uq2Var);
        k.m(z ? 0 : d02Var.k() - 2);
        k.b();
        zt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
        au2.a(str, uq2Var);
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            u03 a0 = u03.a0();
            return a0 == null || (x = a0.x()) == null || x.isFinishing() || x.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public final void B(z62.e eVar, uq2 uq2Var, d02 d02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, uq2Var, d02Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = zt2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            z62.q(eVar, new c(this, eVar, str, uq2Var, d02Var));
        }
    }

    public final void C(z62.e eVar, uq2 uq2Var, d02 d02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, uq2Var, d02Var, str) == null) {
            if (oe3.O()) {
                B(eVar, uq2Var, d02Var, str);
            } else {
                oe3.a0(new b(this, eVar, uq2Var, d02Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public us1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            au2.b(uuid);
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            if (us1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = d43.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    ux1.c("RedirectToApi", "url is null");
                    return new us1(202, "url is null");
                }
                hm2 U = hm2.U();
                d02 V = U.V();
                if (V == null) {
                    ux1.c("RedirectToApi", "manager is null");
                    return new us1(1001, "manager is null");
                }
                uq2 d = uq2.d(p, U.z());
                d.e = "2";
                d.f = uuid;
                i73.g(d);
                if (!oe3.b(U.s(), d, false)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    ux1.c("RedirectToApi", str2);
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
                    ux1.c("RedirectToApi", "cb is empty");
                    i73.i(d);
                    return new us1(202, "cb is empty");
                } else if (h33.b().a(d)) {
                    h33.b().i("redirectTo", d);
                    ux1.c("RedirectToApi", "access to this page is prohibited");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }
}
