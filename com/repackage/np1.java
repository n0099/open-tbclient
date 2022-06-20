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
import com.repackage.bz1;
import com.repackage.h33;
import com.repackage.x52;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class np1 extends jp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fl2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sp2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ bz1 e;
        public final /* synthetic */ np1 f;

        /* renamed from: com.repackage.np1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0486a implements h33.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ sz2 b;
            public final /* synthetic */ a c;

            public C0486a(a aVar, Activity activity, sz2 sz2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, sz2Var};
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
                this.b = sz2Var;
            }

            @Override // com.repackage.h33.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    ys2.d(this.c.d);
                    sw1.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    x52.e f = x52.f(this.a, c62.c(this.c.c.a));
                    String c = f.a.c();
                    a aVar = this.c;
                    b33.m(aVar.f, this.b, c, aVar.c.a, null, aVar.b);
                    c63.t(c);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.repackage.h33.e
            public void b(int i, lb3 lb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, lb3Var) == null) {
                    sw1.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    b33.k(aVar.f, aVar.b);
                    g63.j(this.c.c, lb3Var);
                }
            }
        }

        public a(np1 np1Var, fl2 fl2Var, String str, sp2 sp2Var, String str2, bz1 bz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {np1Var, fl2Var, str, sp2Var, str2, bz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = np1Var;
            this.a = fl2Var;
            this.b = str;
            this.c = sp2Var;
            this.d = str2;
            this.e = bz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    sz2 M = sz2.M();
                    if (M == null) {
                        this.f.d(this.b, new sr1(1001, "swan app is null"));
                        g63.i(this.c);
                        return;
                    }
                    this.a.a();
                    h33.g(M, this.c, "", new C0486a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new sr1(1001, "swan activity is null"));
                g63.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements x52.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x52.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sp2 c;
        public final /* synthetic */ bz1 d;

        public b(np1 np1Var, x52.e eVar, String str, sp2 sp2Var, bz1 bz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {np1Var, eVar, str, sp2Var, bz1Var};
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
            this.c = sp2Var;
            this.d = bz1Var;
        }

        @Override // com.repackage.x52.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ys2.e(this.a, this.b);
                b33.e(this.a.a, this.c, this.b);
                np1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements bz1.a {
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

        @Override // com.repackage.bz1.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

        @Override // com.repackage.bz1.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof az1)) {
                ((az1) fragment).S0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public np1(@NonNull tn1 tn1Var) {
        super(tn1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tn1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((tn1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(bz1 bz1Var, sp2 sp2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, bz1Var, sp2Var, str) == null) {
            if (sp2Var != null) {
                sw1.i("RelaunchApi", "doReLaunch page=" + sp2Var.a + " routePage=" + sp2Var.d);
            }
            SwanAppActivity x = rz2.K().x();
            if (x == null || x.isFinishing() || x.isDestroyed()) {
                return;
            }
            c cVar = new c();
            ys2.c(3, str);
            az1.S3(md3.n());
            bz1Var.g(cVar);
            bz1.b i = bz1Var.i("reLaunch");
            i.n(0, 0);
            i.f();
            i.k("normal", sp2Var).b();
            bz1Var.p(cVar);
            xs2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            ys2.a(str, sp2Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public sr1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            ys2.b(uuid);
            Pair<sr1, JSONObject> s = s(str);
            sr1 sr1Var = (sr1) s.first;
            if (sr1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = b33.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    sw1.c("RelaunchApi", "url is null");
                    return new sr1(202, "url is null");
                }
                fl2 U = fl2.U();
                bz1 V = U.V();
                if (V == null) {
                    sw1.c("RelaunchApi", "manager is null");
                    return new sr1(1001, "manager is null");
                }
                sp2 d = sp2.d(p, U.z());
                d.e = "3";
                d.f = uuid;
                g63.g(d);
                if (!md3.b(U.s(), d, true)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    sw1.c("RelaunchApi", str2);
                    g63.i(d);
                    return new sr1(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && sz2.M() != null) {
                    sz2.M().L0(optString, d.d);
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
                    sw1.c("RelaunchApi", "cb is null");
                    g63.i(d);
                    return new sr1(202, "cb is null");
                } else if (f23.b().a(d)) {
                    f23.b().i("reLaunch", d);
                    sw1.c("RelaunchApi", "access to this page is prohibited");
                    return new sr1(1003, "access to this page is prohibited");
                } else {
                    md3.a0(new a(this, U, optString3, d, uuid, V));
                    return sr1.f();
                }
            }
            return sr1Var;
        }
        return (sr1) invokeL.objValue;
    }

    @Override // com.repackage.vn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    public final void z(x52.e eVar, sp2 sp2Var, bz1 bz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, sp2Var, bz1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = xs2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            x52.q(eVar, new b(this, eVar, str, sp2Var, bz1Var));
        }
    }
}
