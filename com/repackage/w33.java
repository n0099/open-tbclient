package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.o62;
import com.repackage.sz1;
import com.repackage.y33;
import java.util.UUID;
@Deprecated
/* loaded from: classes7.dex */
public class w33 extends g23 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes7.dex */
    public class a implements y33.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ j03 b;
        public final /* synthetic */ wl2 c;
        public final /* synthetic */ jq2 d;
        public final /* synthetic */ sz1 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ w33 j;

        public a(w33 w33Var, String str, j03 j03Var, wl2 wl2Var, jq2 jq2Var, sz1 sz1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w33Var, str, j03Var, wl2Var, jq2Var, sz1Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = w33Var;
            this.a = str;
            this.b = j03Var;
            this.c = wl2Var;
            this.d = jq2Var;
            this.e = sz1Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.repackage.y33.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                pt2.d(this.a);
                jx1.i("navigateTo", "check pages success");
                c73.F(true, this.b.X().T());
                this.c.o();
                o62.e f = o62.f(this.c.getActivity(), t62.c(this.d.a));
                s33.l(this.f, this.g, this.b, f.a.c(), this.d.a, s33.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.repackage.y33.e
        public void c(int i, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cc3Var) == null) {
                jx1.c("navigateTo", "check pages failed");
                c73.F(false, this.b.X().T());
                this.c.o();
                if (g23.b) {
                    Context context = this.i;
                    b03.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f019e) + i).G();
                }
                s33.j(this.f, this.g, this.h);
                x63.j(this.d, cc3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements o62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ jq2 c;
        public final /* synthetic */ sz1 d;
        public final /* synthetic */ w33 e;

        public b(w33 w33Var, o62.e eVar, String str, jq2 jq2Var, sz1 sz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w33Var, eVar, str, jq2Var, sz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = w33Var;
            this.a = eVar;
            this.b = str;
            this.c = jq2Var;
            this.d = sz1Var;
        }

        @Override // com.repackage.o62.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (g23.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                pt2.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (g23.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755252358, "Lcom/repackage/w33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755252358, "Lcom/repackage/w33;");
                return;
            }
        }
        d = qj2.g0().r();
        if (g23.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w33(g13 g13Var) {
        super(g13Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g13Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.g23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, j03Var)) == null) {
            if (g23.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            pt2.b(uuid);
            String o = s33.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                jx1.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            wl2 U = wl2.U();
            sz1 V = U.V();
            if (V == null) {
                jx1.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            jq2 d2 = jq2.d(o, U.z());
            d2.e = "0";
            d2.f = uuid;
            x63.g(d2);
            if (!de3.b(U.s(), d2, false)) {
                jx1.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                x63.i(d2);
                return false;
            }
            String n = s33.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && j03.L() != null) {
                j03.L().K0(n, d2.d);
            }
            String n2 = s33.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = ot2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (g23.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = jd3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                jx1.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                x63.i(d2);
                return false;
            } else if (w23.b().a(d2)) {
                w23.b().i("navigateTo", d2);
                jx1.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                y33.g(j03Var, d2, "", new a(this, uuid, j03Var, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(pm1 pm1Var, jq2 jq2Var, sz1 sz1Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pm1Var, jq2Var, sz1Var, str) == null) || (activity = wl2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        s33.e(pm1Var, jq2Var, str);
        pt2.c(0, str);
        if (sz1Var.k() < d) {
            rz1.R3(de3.n());
            sz1.b i = sz1Var.i("navigateTo");
            i.n(sz1.g, sz1.i);
            i.k("normal", jq2Var).b();
            tc3.c(sz1Var, this.c);
            ot2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            pt2.a(str, jq2Var);
            return;
        }
        dq1.A(sz1Var, jq2Var, str, true);
    }

    public final void p(o62.e eVar, jq2 jq2Var, sz1 sz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, jq2Var, sz1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = ot2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (g23.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            o62.q(eVar, new b(this, eVar, str, jq2Var, sz1Var));
            if (g23.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
