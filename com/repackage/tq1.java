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
import com.repackage.e72;
import com.repackage.i02;
import com.repackage.o43;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class tq1 extends qq1 {
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
        public final /* synthetic */ tq1 f;

        /* renamed from: com.repackage.tq1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0592a implements o43.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ z03 a;
            public final /* synthetic */ a b;

            public C0592a(a aVar, z03 z03Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, z03Var};
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
                this.a = z03Var;
            }

            @Override // com.repackage.o43.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    fu2.d(this.b.d);
                    zx1.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    e72.e f = e72.f(this.b.a.getActivity(), j72.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    i43.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.repackage.o43.e
            public void b(int i, sc3 sc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, sc3Var) == null) {
                    zx1.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    i43.k(aVar.f, aVar.b);
                    n73.j(this.b.c, sc3Var);
                }
            }
        }

        public a(tq1 tq1Var, mm2 mm2Var, String str, zq2 zq2Var, String str2, i02 i02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq1Var, mm2Var, str, zq2Var, str2, i02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = tq1Var;
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
                    o43.g(M, this.c, "", new C0592a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new zs1(1001, "swan activity is null"));
                n73.i(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72.e a;
        public final /* synthetic */ zq2 b;
        public final /* synthetic */ i02 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ tq1 e;

        public b(tq1 tq1Var, e72.e eVar, zq2 zq2Var, i02 i02Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq1Var, eVar, zq2Var, i02Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = tq1Var;
            this.a = eVar;
            this.b = zq2Var;
            this.c = i02Var;
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

    /* loaded from: classes7.dex */
    public class c implements e72.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ zq2 c;
        public final /* synthetic */ i02 d;

        public c(tq1 tq1Var, e72.e eVar, String str, zq2 zq2Var, i02 i02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq1Var, eVar, str, zq2Var, i02Var};
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
                tq1.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tq1(@NonNull ap1 ap1Var) {
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

    public static void A(i02 i02Var, zq2 zq2Var, String str, boolean z) {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{i02Var, zq2Var, str, Boolean.valueOf(z)}) == null) || z() || (w = y03.K().w()) == null || w.isFinishing() || w.isDestroyed()) {
            return;
        }
        fu2.c(z ? 8 : 2, str);
        h02.S3(te3.n());
        i02.b i = i02Var.i("redirectTo");
        i.n(0, 0);
        i02.b k = i.k("normal", zq2Var);
        k.m(z ? 0 : i02Var.k() - 2);
        k.b();
        eu2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
        fu2.a(str, zq2Var);
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            z03 b0 = z03.b0();
            return b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public final void B(e72.e eVar, zq2 zq2Var, i02 i02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, zq2Var, i02Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = eu2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            e72.q(eVar, new c(this, eVar, str, zq2Var, i02Var));
        }
    }

    public final void C(e72.e eVar, zq2 zq2Var, i02 i02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, zq2Var, i02Var, str) == null) {
            if (te3.O()) {
                B(eVar, zq2Var, i02Var, str);
            } else {
                te3.a0(new b(this, eVar, zq2Var, i02Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public zs1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            fu2.b(uuid);
            Pair<zs1, JSONObject> s = s(str);
            zs1 zs1Var = (zs1) s.first;
            if (zs1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = i43.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    zx1.c("RedirectToApi", "url is null");
                    return new zs1(202, "url is null");
                }
                mm2 U = mm2.U();
                i02 V = U.V();
                if (V == null) {
                    zx1.c("RedirectToApi", "manager is null");
                    return new zs1(1001, "manager is null");
                }
                zq2 d = zq2.d(p, U.z());
                d.e = "2";
                d.f = uuid;
                n73.g(d);
                if (!te3.b(U.s(), d, false)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    zx1.c("RedirectToApi", str2);
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
                    zx1.c("RedirectToApi", "cb is empty");
                    n73.i(d);
                    return new zs1(202, "cb is empty");
                } else if (m33.b().a(d)) {
                    m33.b().i("redirectTo", d);
                    zx1.c("RedirectToApi", "access to this page is prohibited");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }
}
