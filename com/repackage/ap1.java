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
import com.repackage.m43;
import com.repackage.m52;
import com.repackage.qy1;
import com.repackage.w23;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ap1 extends yo1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public wy1 f;

    /* loaded from: classes5.dex */
    public class a implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ uk2 b;
        public final /* synthetic */ qy1 c;
        public final /* synthetic */ hp2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ap1 g;

        public a(ap1 ap1Var, String str, uk2 uk2Var, qy1 qy1Var, hp2 hp2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap1Var, str, uk2Var, qy1Var, hp2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ap1Var;
            this.a = str;
            this.b = uk2Var;
            this.c = qy1Var;
            this.d = hp2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (f43.h(k43Var)) {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                } else {
                    this.g.d(this.a, new hr1(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uk2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hp2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ qy1 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ap1 g;

        /* loaded from: classes5.dex */
        public class a implements w23.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ hz2 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, hz2 hz2Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, hz2Var, activity};
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
                this.a = hz2Var;
                this.b = activity;
            }

            @Override // com.repackage.w23.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    ns2.d(this.c.d);
                    hw1.i("NavigateToApi", "check pages success");
                    a63.F(true, this.a.X().T());
                    this.c.a.o();
                    m52.e f = m52.f(this.b, r52.c(this.c.c.a));
                    List<String> g = q23.g(this.c.e);
                    ap1 ap1Var = this.c.g;
                    hz2 hz2Var = this.a;
                    String c = f.a.c();
                    b bVar = this.c;
                    q23.m(ap1Var, hz2Var, c, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.repackage.w23.e
            public void c(int i, ab3 ab3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ab3Var) == null) {
                    hw1.c("NavigateToApi", "check pages failed");
                    a63.F(false, this.a.X().T());
                    this.c.a.o();
                    b bVar = this.c;
                    q23.k(bVar.g, bVar.b);
                    v53.j(this.c.c, ab3Var);
                }
            }
        }

        public b(ap1 ap1Var, uk2 uk2Var, String str, hp2 hp2Var, String str2, qy1 qy1Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap1Var, uk2Var, str, hp2Var, str2, qy1Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ap1Var;
            this.a = uk2Var;
            this.b = str;
            this.c = hp2Var;
            this.d = str2;
            this.e = qy1Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    hz2 L = hz2.L();
                    if (L == null) {
                        this.g.d(this.b, new hr1(1001, "swan app is null"));
                        v53.i(this.c);
                        return;
                    }
                    this.a.a();
                    w23.g(L, this.c, "", new a(this, L, activity), this.d);
                    return;
                }
                this.g.d(this.b, new hr1(1001, "swan activity is null"));
                v53.i(this.c);
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
        public final /* synthetic */ String e;
        public final /* synthetic */ ap1 f;

        public c(ap1 ap1Var, m52.e eVar, String str, hp2 hp2Var, qy1 qy1Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap1Var, eVar, str, hp2Var, qy1Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ap1Var;
            this.a = eVar;
            this.b = str;
            this.c = hp2Var;
            this.d = qy1Var;
            this.e = str2;
        }

        @Override // com.repackage.m52.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ns2.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl1 a;
        public final /* synthetic */ hp2 b;
        public final /* synthetic */ qy1 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ap1 f;

        public d(ap1 ap1Var, nl1 nl1Var, hp2 hp2Var, qy1 qy1Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap1Var, nl1Var, hp2Var, qy1Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ap1Var;
            this.a = nl1Var;
            this.b = hp2Var;
            this.c = qy1Var;
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
    public class e extends wy1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ py1 a;
        public final /* synthetic */ ap1 b;

        public e(ap1 ap1Var, py1 py1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap1Var, py1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ap1Var;
            this.a = py1Var;
        }

        @Override // com.repackage.wy1, com.repackage.xy1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.Q2(this.b.f);
                }
            }
        }

        @Override // com.repackage.wy1, com.repackage.xy1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = dy2.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                dy2.h(this.a);
            }
        }

        @Override // com.repackage.wy1, com.repackage.xy1
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = dy2.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                dy2.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755849201, "Lcom/repackage/ap1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755849201, "Lcom/repackage/ap1;");
                return;
            }
        }
        g = oi2.g0().r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap1(@NonNull in1 in1Var) {
        super(in1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {in1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((in1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(uk2 uk2Var, qy1 qy1Var, hp2 hp2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{uk2Var, qy1Var, hp2Var, str, str2, str3}) == null) {
            bd3.a0(new b(this, uk2Var, str3, hp2Var, str, qy1Var, str2));
        }
    }

    public final void D(nl1 nl1Var, hp2 hp2Var, qy1 qy1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nl1Var, hp2Var, qy1Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(nl1Var, hp2Var, qy1Var, str);
            } else {
                G(nl1Var, hp2Var, qy1Var, str);
            }
        }
    }

    public final void E(nl1 nl1Var, hp2 hp2Var, qy1 qy1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, nl1Var, hp2Var, qy1Var, str, str2) == null) {
            if (bd3.O()) {
                D(nl1Var, hp2Var, qy1Var, str, str2);
            } else {
                bd3.a0(new d(this, nl1Var, hp2Var, qy1Var, str, str2));
            }
        }
    }

    public final void F(nl1 nl1Var, hp2 hp2Var, qy1 qy1Var, String str) {
        SwanAppActivity activity;
        py1 py1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, nl1Var, hp2Var, qy1Var, str) == null) || (activity = uk2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        q23.e(nl1Var, hp2Var, str);
        ns2.c(9, str);
        py1.R3(bd3.n());
        qy1.b k = qy1Var.i("showModalPage").k("normal", hp2Var);
        if ((qy1Var.m() instanceof py1) && (py1Var = (py1) qy1Var.m()) != null) {
            py1Var.D0 = true;
            k.b();
            if (qy1Var.k() > 1) {
                py1Var.w3().setBackgroundColor(0);
            } else {
                py1Var.D0 = false;
            }
            py1Var.y2(false);
            wy1 wy1Var = this.f;
            if (wy1Var != null) {
                py1Var.Q2(wy1Var);
            }
            e eVar = new e(this, py1Var);
            this.f = eVar;
            py1Var.m2(eVar);
            View c2 = dy2.c(py1Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            dy2.h(py1Var);
            PullToRefreshBaseWebView k0 = nl1Var.k0();
            if (k0 != null) {
                k0.setIsPreventPullToRefresh(true);
            }
            ms2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            ns2.a(str, hp2Var);
        }
    }

    public final void G(nl1 nl1Var, hp2 hp2Var, qy1 qy1Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, nl1Var, hp2Var, qy1Var, str) == null) || (activity = uk2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        q23.e(nl1Var, hp2Var, str);
        ns2.c(0, str);
        if (qy1Var.k() < g) {
            py1.R3(bd3.n());
            qy1.b i = qy1Var.i("navigateTo");
            i.n(qy1.g, qy1.i);
            i.k("normal", hp2Var).b();
            rb3.c(qy1Var, getContext());
            ms2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            ns2.a(str, hp2Var);
            return;
        }
        bp1.A(qy1Var, hp2Var, str, true);
    }

    public hr1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (hr1) invokeL.objValue;
    }

    public final hr1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                return new hr1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            ns2.b(uuid);
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            if (hr1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = q23.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    hw1.c("NavigateToApi", "url is null");
                    return new hr1(202, "url is null");
                }
                uk2 U = uk2.U();
                qy1 V = U.V();
                if (V == null) {
                    hw1.c("NavigateToApi", "manager is null");
                    return new hr1(1001, "manager is null");
                }
                hp2 d2 = hp2.d(p, U.z());
                d2.e = str2;
                d2.f = uuid;
                v53.g(d2);
                if (!bd3.b(U.s(), d2, false)) {
                    String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                    hw1.c("NavigateToApi", str4);
                    v53.i(d2);
                    return new hr1(202, str4);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && hz2.L() != null) {
                    hz2.L().K0(optString, d2.d);
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
                    hw1.c("NavigateToApi", "cb is empty");
                    v53.i(d2);
                    return new hr1(202, "cb is empty");
                } else if (u13.b().a(d2)) {
                    u13.b().i(str3, d2);
                    hw1.c("NavigateToApi", "access to this page is prohibited");
                    return new hr1(1003, "access to this page is prohibited");
                } else {
                    if (TextUtils.equals("7", str2)) {
                        a0.d0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                    } else {
                        C(U, V, d2, uuid, str2, optString3);
                    }
                    return hr1.f();
                }
            }
            return hr1Var;
        }
        return (hr1) invokeLLL.objValue;
    }

    public hr1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (hr1) invokeL.objValue;
    }

    public final void K(m52.e eVar, hp2 hp2Var, qy1 qy1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, hp2Var, qy1Var, str, str2) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = ms2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            m52.q(eVar, new c(this, eVar, str, hp2Var, qy1Var, str2));
        }
    }

    @Override // com.repackage.kn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }
}
