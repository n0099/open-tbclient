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
import com.repackage.m52;
import com.repackage.qy1;
import com.repackage.w23;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cp1 extends yo1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uk2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hp2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ qy1 e;
        public final /* synthetic */ cp1 f;

        /* renamed from: com.repackage.cp1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0403a implements w23.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ hz2 b;
            public final /* synthetic */ a c;

            public C0403a(a aVar, Activity activity, hz2 hz2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, hz2Var};
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
                this.b = hz2Var;
            }

            @Override // com.repackage.w23.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    ns2.d(this.c.d);
                    hw1.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    m52.e f = m52.f(this.a, r52.c(this.c.c.a));
                    String c = f.a.c();
                    a aVar = this.c;
                    q23.m(aVar.f, this.b, c, aVar.c.a, null, aVar.b);
                    r53.t(c);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.repackage.w23.e
            public void c(int i, ab3 ab3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ab3Var) == null) {
                    hw1.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    q23.k(aVar.f, aVar.b);
                    v53.j(this.c.c, ab3Var);
                }
            }
        }

        public a(cp1 cp1Var, uk2 uk2Var, String str, hp2 hp2Var, String str2, qy1 qy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cp1Var, uk2Var, str, hp2Var, str2, qy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = cp1Var;
            this.a = uk2Var;
            this.b = str;
            this.c = hp2Var;
            this.d = str2;
            this.e = qy1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    hz2 L = hz2.L();
                    if (L == null) {
                        this.f.d(this.b, new hr1(1001, "swan app is null"));
                        v53.i(this.c);
                        return;
                    }
                    this.a.a();
                    w23.g(L, this.c, "", new C0403a(this, activity, L), this.d);
                    return;
                }
                this.f.d(this.b, new hr1(1001, "swan activity is null"));
                v53.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements m52.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m52.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hp2 c;
        public final /* synthetic */ qy1 d;

        public b(cp1 cp1Var, m52.e eVar, String str, hp2 hp2Var, qy1 qy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cp1Var, eVar, str, hp2Var, qy1Var};
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
            this.c = hp2Var;
            this.d = qy1Var;
        }

        @Override // com.repackage.m52.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ns2.e(this.a, this.b);
                q23.e(this.a.a, this.c, this.b);
                cp1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements qy1.a {
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

        @Override // com.repackage.qy1.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

        @Override // com.repackage.qy1.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof py1)) {
                ((py1) fragment).S0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp1(@NonNull in1 in1Var) {
        super(in1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {in1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((in1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(qy1 qy1Var, hp2 hp2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, qy1Var, hp2Var, str) == null) {
            if (hp2Var != null) {
                hw1.i("RelaunchApi", "doReLaunch page=" + hp2Var.a + " routePage=" + hp2Var.d);
            }
            SwanAppActivity x = gz2.J().x();
            if (x == null || x.isFinishing() || x.isDestroyed()) {
                return;
            }
            c cVar = new c();
            ns2.c(3, str);
            py1.R3(bd3.n());
            qy1Var.g(cVar);
            qy1.b i = qy1Var.i("reLaunch");
            i.n(0, 0);
            i.f();
            i.k("normal", hp2Var).b();
            qy1Var.p(cVar);
            ms2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            ns2.a(str, hp2Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public hr1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            ns2.b(uuid);
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            if (hr1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = q23.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    hw1.c("RelaunchApi", "url is null");
                    return new hr1(202, "url is null");
                }
                uk2 U = uk2.U();
                qy1 V = U.V();
                if (V == null) {
                    hw1.c("RelaunchApi", "manager is null");
                    return new hr1(1001, "manager is null");
                }
                hp2 d = hp2.d(p, U.z());
                d.e = "3";
                d.f = uuid;
                v53.g(d);
                if (!bd3.b(U.s(), d, true)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    hw1.c("RelaunchApi", str2);
                    v53.i(d);
                    return new hr1(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && hz2.L() != null) {
                    hz2.L().K0(optString, d.d);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = ms2.q("route", uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    hw1.c("RelaunchApi", "cb is null");
                    v53.i(d);
                    return new hr1(202, "cb is null");
                } else if (u13.b().a(d)) {
                    u13.b().i("reLaunch", d);
                    hw1.c("RelaunchApi", "access to this page is prohibited");
                    return new hr1(1003, "access to this page is prohibited");
                } else {
                    bd3.a0(new a(this, U, optString3, d, uuid, V));
                    return hr1.f();
                }
            }
            return hr1Var;
        }
        return (hr1) invokeL.objValue;
    }

    @Override // com.repackage.kn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    public final void z(m52.e eVar, hp2 hp2Var, qy1 qy1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, hp2Var, qy1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = ms2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            m52.q(eVar, new b(this, eVar, str, hp2Var, qy1Var));
        }
    }
}
