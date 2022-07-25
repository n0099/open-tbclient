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
import com.repackage.n62;
import com.repackage.rz1;
import com.repackage.x33;
import java.util.UUID;
@Deprecated
/* loaded from: classes7.dex */
public class v33 extends f23 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes7.dex */
    public class a implements x33.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ i03 b;
        public final /* synthetic */ vl2 c;
        public final /* synthetic */ iq2 d;
        public final /* synthetic */ rz1 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ v33 j;

        public a(v33 v33Var, String str, i03 i03Var, vl2 vl2Var, iq2 iq2Var, rz1 rz1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v33Var, str, i03Var, vl2Var, iq2Var, rz1Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = v33Var;
            this.a = str;
            this.b = i03Var;
            this.c = vl2Var;
            this.d = iq2Var;
            this.e = rz1Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.repackage.x33.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ot2.d(this.a);
                ix1.i("navigateTo", "check pages success");
                b73.F(true, this.b.Y().T());
                this.c.o();
                n62.e f = n62.f(this.c.getActivity(), s62.c(this.d.a));
                r33.l(this.f, this.g, this.b, f.a.b(), this.d.a, r33.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.repackage.x33.e
        public void b(int i, bc3 bc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bc3Var) == null) {
                ix1.c("navigateTo", "check pages failed");
                b73.F(false, this.b.Y().T());
                this.c.o();
                if (f23.b) {
                    Context context = this.i;
                    a03.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a3) + i).G();
                }
                r33.j(this.f, this.g, this.h);
                w63.j(this.d, bc3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements n62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ iq2 c;
        public final /* synthetic */ rz1 d;
        public final /* synthetic */ v33 e;

        public b(v33 v33Var, n62.e eVar, String str, iq2 iq2Var, rz1 rz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v33Var, eVar, str, iq2Var, rz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = v33Var;
            this.a = eVar;
            this.b = str;
            this.c = iq2Var;
            this.d = rz1Var;
        }

        @Override // com.repackage.n62.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (f23.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                ot2.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (f23.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755282149, "Lcom/repackage/v33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755282149, "Lcom/repackage/v33;");
                return;
            }
        }
        d = pj2.g0().r();
        if (f23.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v33(f13 f13Var) {
        super(f13Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f13Var};
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

    @Override // com.repackage.f23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, i03Var)) == null) {
            if (f23.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            ot2.b(uuid);
            String o = r33.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                ix1.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            vl2 U = vl2.U();
            rz1 V = U.V();
            if (V == null) {
                ix1.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            iq2 d2 = iq2.d(o, U.z());
            d2.e = "0";
            d2.f = uuid;
            w63.g(d2);
            if (!ce3.b(U.s(), d2, false)) {
                ix1.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                w63.i(d2);
                return false;
            }
            String n = r33.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && i03.M() != null) {
                i03.M().L0(n, d2.d);
            }
            String n2 = r33.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = nt2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (f23.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = id3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                ix1.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                w63.i(d2);
                return false;
            } else if (v23.b().a(d2)) {
                v23.b().i("navigateTo", d2);
                ix1.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                x33.g(i03Var, d2, "", new a(this, uuid, i03Var, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(om1 om1Var, iq2 iq2Var, rz1 rz1Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, om1Var, iq2Var, rz1Var, str) == null) || (activity = vl2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        r33.e(om1Var, iq2Var, str);
        ot2.c(0, str);
        if (rz1Var.k() < d) {
            qz1.S3(ce3.n());
            rz1.b i = rz1Var.i("navigateTo");
            i.n(rz1.g, rz1.i);
            i.k("normal", iq2Var).b();
            sc3.c(rz1Var, this.c);
            nt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            ot2.a(str, iq2Var);
            return;
        }
        cq1.A(rz1Var, iq2Var, str, true);
    }

    public final void p(n62.e eVar, iq2 iq2Var, rz1 rz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, iq2Var, rz1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = nt2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (f23.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            n62.q(eVar, new b(this, eVar, str, iq2Var, rz1Var));
            if (f23.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
