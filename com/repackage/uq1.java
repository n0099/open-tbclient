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
import com.repackage.e72;
import com.repackage.i02;
import com.repackage.o43;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class uq1 extends qq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mm2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ zq2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ i02 e;
        public final /* synthetic */ uq1 f;

        /* renamed from: com.repackage.uq1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0598a implements o43.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ z03 b;
            public final /* synthetic */ a c;

            public C0598a(a aVar, Activity activity, z03 z03Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, z03Var};
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
                this.b = z03Var;
            }

            @Override // com.repackage.o43.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    fu2.d(this.c.d);
                    zx1.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    e72.e f = e72.f(this.a, j72.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    i43.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    j73.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.repackage.o43.e
            public void b(int i, sc3 sc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, sc3Var) == null) {
                    zx1.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    i43.k(aVar.f, aVar.b);
                    n73.j(this.c.c, sc3Var);
                }
            }
        }

        public a(uq1 uq1Var, mm2 mm2Var, String str, zq2 zq2Var, String str2, i02 i02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uq1Var, mm2Var, str, zq2Var, str2, i02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = uq1Var;
            this.a = mm2Var;
            this.b = str;
            this.c = zq2Var;
            this.d = str2;
            this.e = i02Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    z03 M = z03.M();
                    if (M == null) {
                        this.f.d(this.b, new zs1(1001, "swan app is null"));
                        n73.i(this.c);
                        return;
                    }
                    this.a.a();
                    o43.g(M, this.c, "", new C0598a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new zs1(1001, "swan activity is null"));
                n73.i(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements e72.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ zq2 c;
        public final /* synthetic */ i02 d;

        public b(uq1 uq1Var, e72.e eVar, String str, zq2 zq2Var, i02 i02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uq1Var, eVar, str, zq2Var, i02Var};
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
            this.c = zq2Var;
            this.d = i02Var;
        }

        @Override // com.repackage.e72.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fu2.e(this.a, this.b);
                i43.e(this.a.a, this.c, this.b);
                uq1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements i02.a {
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

        @Override // com.repackage.i02.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

        @Override // com.repackage.i02.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof h02)) {
                ((h02) fragment).S0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uq1(@NonNull ap1 ap1Var) {
        super(ap1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ap1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ap1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(i02 i02Var, zq2 zq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, i02Var, zq2Var, str) == null) {
            if (zq2Var != null) {
                zx1.i("RelaunchApi", "doReLaunch page=" + zq2Var.a + " routePage=" + zq2Var.d);
            }
            SwanAppActivity w = y03.K().w();
            if (w == null || w.isFinishing() || w.isDestroyed()) {
                return;
            }
            c cVar = new c();
            fu2.c(3, str);
            h02.S3(te3.n());
            i02Var.g(cVar);
            i02.b i = i02Var.i("reLaunch");
            i.n(0, 0);
            i.f();
            i.k("normal", zq2Var).b();
            i02Var.p(cVar);
            eu2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            fu2.a(str, zq2Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public zs1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            fu2.b(uuid);
            Pair<zs1, JSONObject> s = s(str);
            zs1 zs1Var = (zs1) s.first;
            if (zs1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = i43.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    zx1.c("RelaunchApi", "url is null");
                    return new zs1(202, "url is null");
                }
                mm2 U = mm2.U();
                i02 V = U.V();
                if (V == null) {
                    zx1.c("RelaunchApi", "manager is null");
                    return new zs1(1001, "manager is null");
                }
                zq2 d = zq2.d(p, U.z());
                d.e = "3";
                d.f = uuid;
                n73.g(d);
                if (!te3.b(U.s(), d, true)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    zx1.c("RelaunchApi", str2);
                    n73.i(d);
                    return new zs1(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && z03.M() != null) {
                    z03.M().L0(optString, d.d);
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
                    zx1.c("RelaunchApi", "cb is null");
                    n73.i(d);
                    return new zs1(202, "cb is null");
                } else if (m33.b().a(d)) {
                    m33.b().i("reLaunch", d);
                    zx1.c("RelaunchApi", "access to this page is prohibited");
                    return new zs1(1003, "access to this page is prohibited");
                } else {
                    te3.a0(new a(this, U, optString3, d, uuid, V));
                    return zs1.f();
                }
            }
            return zs1Var;
        }
        return (zs1) invokeL.objValue;
    }

    @Override // com.repackage.cp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    public final void z(e72.e eVar, zq2 zq2Var, i02 i02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, zq2Var, i02Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = eu2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            e72.q(eVar, new b(this, eVar, str, zq2Var, i02Var));
        }
    }
}
