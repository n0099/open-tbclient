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
import com.repackage.e63;
import com.repackage.e72;
import com.repackage.i02;
import com.repackage.o43;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sq1 extends qq1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public o02 f;

    /* loaded from: classes7.dex */
    public class a implements sf3<c63<e63.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ mm2 b;
        public final /* synthetic */ i02 c;
        public final /* synthetic */ zq2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ sq1 g;

        public a(sq1 sq1Var, String str, mm2 mm2Var, i02 i02Var, zq2 zq2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq1Var, str, mm2Var, i02Var, zq2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = sq1Var;
            this.a = str;
            this.b = mm2Var;
            this.c = i02Var;
            this.d = zq2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(c63<e63.e> c63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c63Var) == null) {
                if (x53.h(c63Var)) {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                } else {
                    this.g.d(this.a, new zs1(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mm2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ zq2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ i02 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ sq1 g;

        /* loaded from: classes7.dex */
        public class a implements o43.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ z03 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, z03 z03Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, z03Var, activity};
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
                this.a = z03Var;
                this.b = activity;
            }

            @Override // com.repackage.o43.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    fu2.d(this.c.d);
                    zx1.i("NavigateToApi", "check pages success");
                    s73.F(true, this.a.Y().T());
                    this.c.a.o();
                    e72.e f = e72.f(this.b, j72.c(this.c.c.a));
                    List<String> g = i43.g(this.c.e);
                    sq1 sq1Var = this.c.g;
                    z03 z03Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    i43.m(sq1Var, z03Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.repackage.o43.e
            public void b(int i, sc3 sc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, sc3Var) == null) {
                    zx1.c("NavigateToApi", "check pages failed");
                    s73.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    i43.k(bVar.g, bVar.b);
                    n73.j(this.c.c, sc3Var);
                }
            }
        }

        public b(sq1 sq1Var, mm2 mm2Var, String str, zq2 zq2Var, String str2, i02 i02Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq1Var, mm2Var, str, zq2Var, str2, i02Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = sq1Var;
            this.a = mm2Var;
            this.b = str;
            this.c = zq2Var;
            this.d = str2;
            this.e = i02Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    z03 M = z03.M();
                    if (M == null) {
                        this.g.d(this.b, new zs1(1001, "swan app is null"));
                        n73.i(this.c);
                        return;
                    }
                    this.a.a();
                    o43.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new zs1(1001, "swan activity is null"));
                n73.i(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements e72.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ zq2 c;
        public final /* synthetic */ i02 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ sq1 f;

        public c(sq1 sq1Var, e72.e eVar, String str, zq2 zq2Var, i02 i02Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq1Var, eVar, str, zq2Var, i02Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = sq1Var;
            this.a = eVar;
            this.b = str;
            this.c = zq2Var;
            this.d = i02Var;
            this.e = str2;
        }

        @Override // com.repackage.e72.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fu2.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fn1 a;
        public final /* synthetic */ zq2 b;
        public final /* synthetic */ i02 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ sq1 f;

        public d(sq1 sq1Var, fn1 fn1Var, zq2 zq2Var, i02 i02Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq1Var, fn1Var, zq2Var, i02Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = sq1Var;
            this.a = fn1Var;
            this.b = zq2Var;
            this.c = i02Var;
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

    /* loaded from: classes7.dex */
    public class e extends o02 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h02 a;
        public final /* synthetic */ sq1 b;

        public e(sq1 sq1Var, h02 h02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq1Var, h02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sq1Var;
            this.a = h02Var;
        }

        @Override // com.repackage.o02, com.repackage.p02
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.R2(this.b.f);
                }
            }
        }

        @Override // com.repackage.o02, com.repackage.p02
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = vz2.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                vz2.h(this.a);
            }
        }

        @Override // com.repackage.o02, com.repackage.p02
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = vz2.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                vz2.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755312002, "Lcom/repackage/sq1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755312002, "Lcom/repackage/sq1;");
                return;
            }
        }
        g = gk2.g0().r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sq1(@NonNull ap1 ap1Var) {
        super(ap1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ap1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ap1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(mm2 mm2Var, i02 i02Var, zq2 zq2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{mm2Var, i02Var, zq2Var, str, str2, str3}) == null) {
            te3.a0(new b(this, mm2Var, str3, zq2Var, str, i02Var, str2));
        }
    }

    public final void D(fn1 fn1Var, zq2 zq2Var, i02 i02Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fn1Var, zq2Var, i02Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(fn1Var, zq2Var, i02Var, str);
            } else {
                G(fn1Var, zq2Var, i02Var, str);
            }
        }
    }

    public final void E(fn1 fn1Var, zq2 zq2Var, i02 i02Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, fn1Var, zq2Var, i02Var, str, str2) == null) {
            if (te3.O()) {
                D(fn1Var, zq2Var, i02Var, str, str2);
            } else {
                te3.a0(new d(this, fn1Var, zq2Var, i02Var, str, str2));
            }
        }
    }

    public final void F(fn1 fn1Var, zq2 zq2Var, i02 i02Var, String str) {
        SwanAppActivity activity;
        h02 h02Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, fn1Var, zq2Var, i02Var, str) == null) || (activity = mm2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        i43.e(fn1Var, zq2Var, str);
        fu2.c(9, str);
        h02.S3(te3.n());
        i02.b k = i02Var.i("showModalPage").k("normal", zq2Var);
        if ((i02Var.m() instanceof h02) && (h02Var = (h02) i02Var.m()) != null) {
            h02Var.D0 = true;
            k.b();
            if (i02Var.k() > 1) {
                h02Var.x3().setBackgroundColor(0);
            } else {
                h02Var.D0 = false;
            }
            h02Var.z2(false);
            o02 o02Var = this.f;
            if (o02Var != null) {
                h02Var.R2(o02Var);
            }
            e eVar = new e(this, h02Var);
            this.f = eVar;
            h02Var.n2(eVar);
            View c2 = vz2.c(h02Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            vz2.h(h02Var);
            PullToRefreshBaseWebView h0 = fn1Var.h0();
            if (h0 != null) {
                h0.setIsPreventPullToRefresh(true);
            }
            eu2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            fu2.a(str, zq2Var);
        }
    }

    public final void G(fn1 fn1Var, zq2 zq2Var, i02 i02Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, fn1Var, zq2Var, i02Var, str) == null) || (activity = mm2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        i43.e(fn1Var, zq2Var, str);
        fu2.c(0, str);
        if (i02Var.k() < g) {
            h02.S3(te3.n());
            i02.b i = i02Var.i("navigateTo");
            i.n(i02.g, i02.i);
            i.k("normal", zq2Var).b();
            jd3.c(i02Var, getContext());
            eu2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            fu2.a(str, zq2Var);
            return;
        }
        tq1.A(i02Var, zq2Var, str, true);
    }

    public zs1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (zs1) invokeL.objValue;
    }

    public final zs1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            z03 b0 = z03.b0();
            if (b0 == null) {
                return new zs1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            fu2.b(uuid);
            Pair<zs1, JSONObject> s = s(str);
            zs1 zs1Var = (zs1) s.first;
            if (zs1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = i43.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    zx1.c("NavigateToApi", "url is null");
                    return new zs1(202, "url is null");
                }
                mm2 U = mm2.U();
                i02 V = U.V();
                if (V == null) {
                    zx1.c("NavigateToApi", "manager is null");
                    return new zs1(1001, "manager is null");
                }
                zq2 d2 = zq2.d(p, U.z());
                d2.e = str2;
                d2.f = uuid;
                n73.g(d2);
                if (!te3.b(U.s(), d2, false)) {
                    String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                    zx1.c("NavigateToApi", str4);
                    n73.i(d2);
                    return new zs1(202, str4);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && z03.M() != null) {
                    z03.M().L0(optString, d2.d);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = eu2.q("route", uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    zx1.c("NavigateToApi", "cb is empty");
                    n73.i(d2);
                    return new zs1(202, "cb is empty");
                } else if (m33.b().a(d2)) {
                    m33.b().i(str3, d2);
                    zx1.c("NavigateToApi", "access to this page is prohibited");
                    return new zs1(1003, "access to this page is prohibited");
                } else {
                    if (TextUtils.equals("7", str2)) {
                        b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                    } else {
                        C(U, V, d2, uuid, str2, optString3);
                    }
                    return zs1.f();
                }
            }
            return zs1Var;
        }
        return (zs1) invokeLLL.objValue;
    }

    public zs1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (zs1) invokeL.objValue;
    }

    public final void K(e72.e eVar, zq2 zq2Var, i02 i02Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, zq2Var, i02Var, str, str2) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = eu2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            e72.q(eVar, new c(this, eVar, str, zq2Var, i02Var, str2));
        }
    }

    @Override // com.repackage.cp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }
}
