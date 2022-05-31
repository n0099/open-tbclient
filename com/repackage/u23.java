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
import com.repackage.m52;
import com.repackage.qy1;
import com.repackage.w23;
import java.util.UUID;
@Deprecated
/* loaded from: classes7.dex */
public class u23 extends e13 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes7.dex */
    public class a implements w23.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hz2 b;
        public final /* synthetic */ uk2 c;
        public final /* synthetic */ hp2 d;
        public final /* synthetic */ qy1 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ u23 j;

        public a(u23 u23Var, String str, hz2 hz2Var, uk2 uk2Var, hp2 hp2Var, qy1 qy1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u23Var, str, hz2Var, uk2Var, hp2Var, qy1Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = u23Var;
            this.a = str;
            this.b = hz2Var;
            this.c = uk2Var;
            this.d = hp2Var;
            this.e = qy1Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.repackage.w23.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ns2.d(this.a);
                hw1.i("navigateTo", "check pages success");
                a63.F(true, this.b.X().T());
                this.c.o();
                m52.e f = m52.f(this.c.getActivity(), r52.c(this.d.a));
                q23.l(this.f, this.g, this.b, f.a.c(), this.d.a, q23.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.repackage.w23.e
        public void c(int i, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ab3Var) == null) {
                hw1.c("navigateTo", "check pages failed");
                a63.F(false, this.b.X().T());
                this.c.o();
                if (e13.b) {
                    Context context = this.i;
                    zy2.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a1) + i).G();
                }
                q23.j(this.f, this.g, this.h);
                v53.j(this.d, ab3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements m52.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m52.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hp2 c;
        public final /* synthetic */ qy1 d;
        public final /* synthetic */ u23 e;

        public b(u23 u23Var, m52.e eVar, String str, hp2 hp2Var, qy1 qy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u23Var, eVar, str, hp2Var, qy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = u23Var;
            this.a = eVar;
            this.b = str;
            this.c = hp2Var;
            this.d = qy1Var;
        }

        @Override // com.repackage.m52.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (e13.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                ns2.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (e13.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755312901, "Lcom/repackage/u23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755312901, "Lcom/repackage/u23;");
                return;
            }
        }
        d = oi2.g0().r();
        if (e13.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u23(e03 e03Var) {
        super(e03Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e03Var};
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

    @Override // com.repackage.e13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hz2Var)) == null) {
            if (e13.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            ns2.b(uuid);
            String o = q23.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                hw1.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            uk2 U = uk2.U();
            qy1 V = U.V();
            if (V == null) {
                hw1.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            hp2 d2 = hp2.d(o, U.z());
            d2.e = "0";
            d2.f = uuid;
            v53.g(d2);
            if (!bd3.b(U.s(), d2, false)) {
                hw1.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                v53.i(d2);
                return false;
            }
            String n = q23.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && hz2.L() != null) {
                hz2.L().K0(n, d2.d);
            }
            String n2 = q23.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = ms2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (e13.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = hc3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                hw1.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                v53.i(d2);
                return false;
            } else if (u13.b().a(d2)) {
                u13.b().i("navigateTo", d2);
                hw1.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                w23.g(hz2Var, d2, "", new a(this, uuid, hz2Var, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(nl1 nl1Var, hp2 hp2Var, qy1 qy1Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nl1Var, hp2Var, qy1Var, str) == null) || (activity = uk2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        q23.e(nl1Var, hp2Var, str);
        ns2.c(0, str);
        if (qy1Var.k() < d) {
            py1.R3(bd3.n());
            qy1.b i = qy1Var.i("navigateTo");
            i.n(qy1.g, qy1.i);
            i.k("normal", hp2Var).b();
            rb3.c(qy1Var, this.c);
            ms2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            ns2.a(str, hp2Var);
            return;
        }
        bp1.A(qy1Var, hp2Var, str, true);
    }

    public final void p(m52.e eVar, hp2 hp2Var, qy1 qy1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, hp2Var, qy1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = ms2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (e13.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            m52.q(eVar, new b(this, eVar, str, hp2Var, qy1Var));
            if (e13.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
