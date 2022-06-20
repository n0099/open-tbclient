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
import com.repackage.bz1;
import com.repackage.h33;
import com.repackage.x43;
import com.repackage.x52;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class lp1 extends jp1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public hz1 f;

    /* loaded from: classes6.dex */
    public class a implements le3<v43<x43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ fl2 b;
        public final /* synthetic */ bz1 c;
        public final /* synthetic */ sp2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ lp1 g;

        public a(lp1 lp1Var, String str, fl2 fl2Var, bz1 bz1Var, sp2 sp2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lp1Var, str, fl2Var, bz1Var, sp2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = lp1Var;
            this.a = str;
            this.b = fl2Var;
            this.c = bz1Var;
            this.d = sp2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.le3
        /* renamed from: b */
        public void a(v43<x43.e> v43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v43Var) == null) {
                if (q43.h(v43Var)) {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                } else {
                    this.g.d(this.a, new sr1(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fl2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sp2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ bz1 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ lp1 g;

        /* loaded from: classes6.dex */
        public class a implements h33.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ sz2 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, sz2 sz2Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, sz2Var, activity};
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
                this.a = sz2Var;
                this.b = activity;
            }

            @Override // com.repackage.h33.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    ys2.d(this.c.d);
                    sw1.i("NavigateToApi", "check pages success");
                    l63.F(true, this.a.Y().T());
                    this.c.a.o();
                    x52.e f = x52.f(this.b, c62.c(this.c.c.a));
                    List<String> g = b33.g(this.c.e);
                    lp1 lp1Var = this.c.g;
                    sz2 sz2Var = this.a;
                    String c = f.a.c();
                    b bVar = this.c;
                    b33.m(lp1Var, sz2Var, c, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.repackage.h33.e
            public void b(int i, lb3 lb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, lb3Var) == null) {
                    sw1.c("NavigateToApi", "check pages failed");
                    l63.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    b33.k(bVar.g, bVar.b);
                    g63.j(this.c.c, lb3Var);
                }
            }
        }

        public b(lp1 lp1Var, fl2 fl2Var, String str, sp2 sp2Var, String str2, bz1 bz1Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lp1Var, fl2Var, str, sp2Var, str2, bz1Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = lp1Var;
            this.a = fl2Var;
            this.b = str;
            this.c = sp2Var;
            this.d = str2;
            this.e = bz1Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    sz2 M = sz2.M();
                    if (M == null) {
                        this.g.d(this.b, new sr1(1001, "swan app is null"));
                        g63.i(this.c);
                        return;
                    }
                    this.a.a();
                    h33.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new sr1(1001, "swan activity is null"));
                g63.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements x52.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x52.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sp2 c;
        public final /* synthetic */ bz1 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ lp1 f;

        public c(lp1 lp1Var, x52.e eVar, String str, sp2 sp2Var, bz1 bz1Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lp1Var, eVar, str, sp2Var, bz1Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = lp1Var;
            this.a = eVar;
            this.b = str;
            this.c = sp2Var;
            this.d = bz1Var;
            this.e = str2;
        }

        @Override // com.repackage.x52.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ys2.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yl1 a;
        public final /* synthetic */ sp2 b;
        public final /* synthetic */ bz1 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ lp1 f;

        public d(lp1 lp1Var, yl1 yl1Var, sp2 sp2Var, bz1 bz1Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lp1Var, yl1Var, sp2Var, bz1Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = lp1Var;
            this.a = yl1Var;
            this.b = sp2Var;
            this.c = bz1Var;
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

    /* loaded from: classes6.dex */
    public class e extends hz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az1 a;
        public final /* synthetic */ lp1 b;

        public e(lp1 lp1Var, az1 az1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lp1Var, az1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lp1Var;
            this.a = az1Var;
        }

        @Override // com.repackage.hz1, com.repackage.iz1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.R2(this.b.f);
                }
            }
        }

        @Override // com.repackage.hz1, com.repackage.iz1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = oy2.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                oy2.h(this.a);
            }
        }

        @Override // com.repackage.hz1, com.repackage.iz1
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = oy2.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                oy2.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755521500, "Lcom/repackage/lp1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755521500, "Lcom/repackage/lp1;");
                return;
            }
        }
        g = zi2.g0().r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lp1(@NonNull tn1 tn1Var) {
        super(tn1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tn1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((tn1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(fl2 fl2Var, bz1 bz1Var, sp2 sp2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{fl2Var, bz1Var, sp2Var, str, str2, str3}) == null) {
            md3.a0(new b(this, fl2Var, str3, sp2Var, str, bz1Var, str2));
        }
    }

    public final void D(yl1 yl1Var, sp2 sp2Var, bz1 bz1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yl1Var, sp2Var, bz1Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(yl1Var, sp2Var, bz1Var, str);
            } else {
                G(yl1Var, sp2Var, bz1Var, str);
            }
        }
    }

    public final void E(yl1 yl1Var, sp2 sp2Var, bz1 bz1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, yl1Var, sp2Var, bz1Var, str, str2) == null) {
            if (md3.O()) {
                D(yl1Var, sp2Var, bz1Var, str, str2);
            } else {
                md3.a0(new d(this, yl1Var, sp2Var, bz1Var, str, str2));
            }
        }
    }

    public final void F(yl1 yl1Var, sp2 sp2Var, bz1 bz1Var, String str) {
        SwanAppActivity activity;
        az1 az1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, yl1Var, sp2Var, bz1Var, str) == null) || (activity = fl2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        b33.e(yl1Var, sp2Var, str);
        ys2.c(9, str);
        az1.S3(md3.n());
        bz1.b k = bz1Var.i("showModalPage").k("normal", sp2Var);
        if ((bz1Var.m() instanceof az1) && (az1Var = (az1) bz1Var.m()) != null) {
            az1Var.D0 = true;
            k.b();
            if (bz1Var.k() > 1) {
                az1Var.x3().setBackgroundColor(0);
            } else {
                az1Var.D0 = false;
            }
            az1Var.z2(false);
            hz1 hz1Var = this.f;
            if (hz1Var != null) {
                az1Var.R2(hz1Var);
            }
            e eVar = new e(this, az1Var);
            this.f = eVar;
            az1Var.n2(eVar);
            View c2 = oy2.c(az1Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            oy2.h(az1Var);
            PullToRefreshBaseWebView k0 = yl1Var.k0();
            if (k0 != null) {
                k0.setIsPreventPullToRefresh(true);
            }
            xs2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            ys2.a(str, sp2Var);
        }
    }

    public final void G(yl1 yl1Var, sp2 sp2Var, bz1 bz1Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, yl1Var, sp2Var, bz1Var, str) == null) || (activity = fl2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        b33.e(yl1Var, sp2Var, str);
        ys2.c(0, str);
        if (bz1Var.k() < g) {
            az1.S3(md3.n());
            bz1.b i = bz1Var.i("navigateTo");
            i.n(bz1.g, bz1.i);
            i.k("normal", sp2Var).b();
            cc3.c(bz1Var, getContext());
            xs2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            ys2.a(str, sp2Var);
            return;
        }
        mp1.A(bz1Var, sp2Var, str, true);
    }

    public sr1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (sr1) invokeL.objValue;
    }

    public final sr1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            sz2 b0 = sz2.b0();
            if (b0 == null) {
                return new sr1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            ys2.b(uuid);
            Pair<sr1, JSONObject> s = s(str);
            sr1 sr1Var = (sr1) s.first;
            if (sr1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = b33.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    sw1.c("NavigateToApi", "url is null");
                    return new sr1(202, "url is null");
                }
                fl2 U = fl2.U();
                bz1 V = U.V();
                if (V == null) {
                    sw1.c("NavigateToApi", "manager is null");
                    return new sr1(1001, "manager is null");
                }
                sp2 d2 = sp2.d(p, U.z());
                d2.e = str2;
                d2.f = uuid;
                g63.g(d2);
                if (!md3.b(U.s(), d2, false)) {
                    String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                    sw1.c("NavigateToApi", str4);
                    g63.i(d2);
                    return new sr1(202, str4);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && sz2.M() != null) {
                    sz2.M().L0(optString, d2.d);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = xs2.q("route", uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    sw1.c("NavigateToApi", "cb is empty");
                    g63.i(d2);
                    return new sr1(202, "cb is empty");
                } else if (f23.b().a(d2)) {
                    f23.b().i(str3, d2);
                    sw1.c("NavigateToApi", "access to this page is prohibited");
                    return new sr1(1003, "access to this page is prohibited");
                } else {
                    if (TextUtils.equals("7", str2)) {
                        b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                    } else {
                        C(U, V, d2, uuid, str2, optString3);
                    }
                    return sr1.f();
                }
            }
            return sr1Var;
        }
        return (sr1) invokeLLL.objValue;
    }

    public sr1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (sr1) invokeL.objValue;
    }

    public final void K(x52.e eVar, sp2 sp2Var, bz1 bz1Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, sp2Var, bz1Var, str, str2) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = xs2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            x52.q(eVar, new c(this, eVar, str, sp2Var, bz1Var, str2));
        }
    }

    @Override // com.repackage.vn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }
}
