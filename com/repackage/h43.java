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
import com.repackage.d02;
import com.repackage.j43;
import com.repackage.z62;
import java.util.UUID;
@Deprecated
/* loaded from: classes6.dex */
public class h43 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes6.dex */
    public class a implements j43.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ u03 b;
        public final /* synthetic */ hm2 c;
        public final /* synthetic */ uq2 d;
        public final /* synthetic */ d02 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ h43 j;

        public a(h43 h43Var, String str, u03 u03Var, hm2 hm2Var, uq2 uq2Var, d02 d02Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h43Var, str, u03Var, hm2Var, uq2Var, d02Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = h43Var;
            this.a = str;
            this.b = u03Var;
            this.c = hm2Var;
            this.d = uq2Var;
            this.e = d02Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.repackage.j43.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                au2.d(this.a);
                ux1.i("navigateTo", "check pages success");
                n73.F(true, this.b.X().T());
                this.c.o();
                z62.e f = z62.f(this.c.getActivity(), e72.c(this.d.a));
                d43.l(this.f, this.g, this.b, f.a.c(), this.d.a, d43.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.repackage.j43.e
        public void c(int i, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, nc3Var) == null) {
                ux1.c("navigateTo", "check pages failed");
                n73.F(false, this.b.X().T());
                this.c.o();
                if (r23.b) {
                    Context context = this.i;
                    m03.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a0) + i).G();
                }
                d43.j(this.f, this.g, this.h);
                i73.j(this.d, nc3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements z62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ uq2 c;
        public final /* synthetic */ d02 d;
        public final /* synthetic */ h43 e;

        public b(h43 h43Var, z62.e eVar, String str, uq2 uq2Var, d02 d02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h43Var, eVar, str, uq2Var, d02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = h43Var;
            this.a = eVar;
            this.b = str;
            this.c = uq2Var;
            this.d = d02Var;
        }

        @Override // com.repackage.z62.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (r23.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                au2.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (r23.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755698262, "Lcom/repackage/h43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755698262, "Lcom/repackage/h43;");
                return;
            }
        }
        d = bk2.g0().r();
        if (r23.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h43(r13 r13Var) {
        super(r13Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r13Var};
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

    @Override // com.repackage.r23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            if (r23.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            au2.b(uuid);
            String o = d43.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                ux1.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            hm2 U = hm2.U();
            d02 V = U.V();
            if (V == null) {
                ux1.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            uq2 d2 = uq2.d(o, U.z());
            d2.e = "0";
            d2.f = uuid;
            i73.g(d2);
            if (!oe3.b(U.s(), d2, false)) {
                ux1.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                i73.i(d2);
                return false;
            }
            String n = d43.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && u03.L() != null) {
                u03.L().K0(n, d2.d);
            }
            String n2 = d43.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = zt2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (r23.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = ud3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                ux1.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                i73.i(d2);
                return false;
            } else if (h33.b().a(d2)) {
                h33.b().i("navigateTo", d2);
                ux1.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                j43.g(u03Var, d2, "", new a(this, uuid, u03Var, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(an1 an1Var, uq2 uq2Var, d02 d02Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, an1Var, uq2Var, d02Var, str) == null) || (activity = hm2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        d43.e(an1Var, uq2Var, str);
        au2.c(0, str);
        if (d02Var.k() < d) {
            c02.R3(oe3.n());
            d02.b i = d02Var.i("navigateTo");
            i.n(d02.g, d02.i);
            i.k("normal", uq2Var).b();
            ed3.c(d02Var, this.c);
            zt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            au2.a(str, uq2Var);
            return;
        }
        oq1.A(d02Var, uq2Var, str, true);
    }

    public final void p(z62.e eVar, uq2 uq2Var, d02 d02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, uq2Var, d02Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = zt2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (r23.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            z62.q(eVar, new b(this, eVar, str, uq2Var, d02Var));
            if (r23.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
