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
import com.repackage.m62;
import com.repackage.qz1;
import com.repackage.w33;
import java.util.UUID;
@Deprecated
/* loaded from: classes7.dex */
public class u33 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes7.dex */
    public class a implements w33.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ h03 b;
        public final /* synthetic */ ul2 c;
        public final /* synthetic */ hq2 d;
        public final /* synthetic */ qz1 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ u33 j;

        public a(u33 u33Var, String str, h03 h03Var, ul2 ul2Var, hq2 hq2Var, qz1 qz1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u33Var, str, h03Var, ul2Var, hq2Var, qz1Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = u33Var;
            this.a = str;
            this.b = h03Var;
            this.c = ul2Var;
            this.d = hq2Var;
            this.e = qz1Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.repackage.w33.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                nt2.d(this.a);
                hx1.i("navigateTo", "check pages success");
                a73.F(true, this.b.Y().T());
                this.c.o();
                m62.e f = m62.f(this.c.getActivity(), r62.c(this.d.a));
                q33.l(this.f, this.g, this.b, f.a.b(), this.d.a, q33.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.repackage.w33.e
        public void b(int i, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ac3Var) == null) {
                hx1.c("navigateTo", "check pages failed");
                a73.F(false, this.b.Y().T());
                this.c.o();
                if (e23.b) {
                    Context context = this.i;
                    zz2.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a3) + i).G();
                }
                q33.j(this.f, this.g, this.h);
                v63.j(this.d, ac3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements m62.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m62.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hq2 c;
        public final /* synthetic */ qz1 d;
        public final /* synthetic */ u33 e;

        public b(u33 u33Var, m62.e eVar, String str, hq2 hq2Var, qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u33Var, eVar, str, hq2Var, qz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = u33Var;
            this.a = eVar;
            this.b = str;
            this.c = hq2Var;
            this.d = qz1Var;
        }

        @Override // com.repackage.m62.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (e23.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                nt2.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (e23.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755311940, "Lcom/repackage/u33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755311940, "Lcom/repackage/u33;");
                return;
            }
        }
        d = oj2.g0().r();
        if (e23.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u33(e13 e13Var) {
        super(e13Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e13Var};
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

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            if (e23.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            nt2.b(uuid);
            String o = q33.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                hx1.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            ul2 U = ul2.U();
            qz1 V = U.V();
            if (V == null) {
                hx1.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            hq2 d2 = hq2.d(o, U.z());
            d2.e = "0";
            d2.f = uuid;
            v63.g(d2);
            if (!be3.b(U.s(), d2, false)) {
                hx1.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                v63.i(d2);
                return false;
            }
            String n = q33.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && h03.M() != null) {
                h03.M().L0(n, d2.d);
            }
            String n2 = q33.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = mt2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (e23.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = hd3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                hx1.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                v63.i(d2);
                return false;
            } else if (u23.b().a(d2)) {
                u23.b().i("navigateTo", d2);
                hx1.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                w33.g(h03Var, d2, "", new a(this, uuid, h03Var, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(nm1 nm1Var, hq2 hq2Var, qz1 qz1Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nm1Var, hq2Var, qz1Var, str) == null) || (activity = ul2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        q33.e(nm1Var, hq2Var, str);
        nt2.c(0, str);
        if (qz1Var.k() < d) {
            pz1.S3(be3.n());
            qz1.b i = qz1Var.i("navigateTo");
            i.n(qz1.g, qz1.i);
            i.k("normal", hq2Var).b();
            rc3.c(qz1Var, this.c);
            mt2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            nt2.a(str, hq2Var);
            return;
        }
        bq1.A(qz1Var, hq2Var, str, true);
    }

    public final void p(m62.e eVar, hq2 hq2Var, qz1 qz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, hq2Var, qz1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = mt2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (e23.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            m62.q(eVar, new b(this, eVar, str, hq2Var, qz1Var));
            if (e23.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
