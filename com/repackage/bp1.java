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
import com.repackage.m52;
import com.repackage.qy1;
import com.repackage.w23;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bp1 extends yo1 {
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
        public final /* synthetic */ bp1 f;

        /* renamed from: com.repackage.bp1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0390a implements w23.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ hz2 a;
            public final /* synthetic */ a b;

            public C0390a(a aVar, hz2 hz2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, hz2Var};
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
                this.a = hz2Var;
            }

            @Override // com.repackage.w23.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    ns2.d(this.b.d);
                    hw1.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    m52.e f = m52.f(this.b.a.getActivity(), r52.c(this.b.c.a));
                    String c = f.a.c();
                    a aVar = this.b;
                    q23.m(aVar.f, this.a, c, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.repackage.w23.e
            public void c(int i, ab3 ab3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ab3Var) == null) {
                    hw1.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    q23.k(aVar.f, aVar.b);
                    v53.j(this.b.c, ab3Var);
                }
            }
        }

        public a(bp1 bp1Var, uk2 uk2Var, String str, hp2 hp2Var, String str2, qy1 qy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bp1Var, uk2Var, str, hp2Var, str2, qy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = bp1Var;
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
                    w23.g(L, this.c, "", new C0390a(this, L), this.d);
                    return;
                }
                this.f.d(this.b, new hr1(1001, "swan activity is null"));
                v53.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m52.e a;
        public final /* synthetic */ hp2 b;
        public final /* synthetic */ qy1 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ bp1 e;

        public b(bp1 bp1Var, m52.e eVar, hp2 hp2Var, qy1 qy1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bp1Var, eVar, hp2Var, qy1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = bp1Var;
            this.a = eVar;
            this.b = hp2Var;
            this.c = qy1Var;
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
    public class c implements m52.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m52.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hp2 c;
        public final /* synthetic */ qy1 d;

        public c(bp1 bp1Var, m52.e eVar, String str, hp2 hp2Var, qy1 qy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bp1Var, eVar, str, hp2Var, qy1Var};
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
                bp1.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp1(@NonNull in1 in1Var) {
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

    public static void A(qy1 qy1Var, hp2 hp2Var, String str, boolean z) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{qy1Var, hp2Var, str, Boolean.valueOf(z)}) == null) || z() || (x = gz2.J().x()) == null || x.isFinishing() || x.isDestroyed()) {
            return;
        }
        ns2.c(z ? 8 : 2, str);
        py1.R3(bd3.n());
        qy1.b i = qy1Var.i("redirectTo");
        i.n(0, 0);
        qy1.b k = i.k("normal", hp2Var);
        k.m(z ? 0 : qy1Var.k() - 2);
        k.b();
        ms2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
        ns2.a(str, hp2Var);
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            hz2 a0 = hz2.a0();
            return a0 == null || (x = a0.x()) == null || x.isFinishing() || x.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public final void B(m52.e eVar, hp2 hp2Var, qy1 qy1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, hp2Var, qy1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = ms2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            m52.q(eVar, new c(this, eVar, str, hp2Var, qy1Var));
        }
    }

    public final void C(m52.e eVar, hp2 hp2Var, qy1 qy1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, hp2Var, qy1Var, str) == null) {
            if (bd3.O()) {
                B(eVar, hp2Var, qy1Var, str);
            } else {
                bd3.a0(new b(this, eVar, hp2Var, qy1Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public hr1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            ns2.b(uuid);
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            if (hr1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = q23.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    hw1.c("RedirectToApi", "url is null");
                    return new hr1(202, "url is null");
                }
                uk2 U = uk2.U();
                qy1 V = U.V();
                if (V == null) {
                    hw1.c("RedirectToApi", "manager is null");
                    return new hr1(1001, "manager is null");
                }
                hp2 d = hp2.d(p, U.z());
                d.e = "2";
                d.f = uuid;
                v53.g(d);
                if (!bd3.b(U.s(), d, false)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    hw1.c("RedirectToApi", str2);
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
                    hw1.c("RedirectToApi", "cb is empty");
                    v53.i(d);
                    return new hr1(202, "cb is empty");
                } else if (u13.b().a(d)) {
                    u13.b().i("redirectTo", d);
                    hw1.c("RedirectToApi", "access to this page is prohibited");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }
}
