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
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m62;
import com.repackage.w33;
import java.util.UUID;
@Deprecated
/* loaded from: classes7.dex */
public class x33 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements w33.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ul2 b;
        public final /* synthetic */ hq2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ h03 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ qz1 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ x33 j;

        public a(x33 x33Var, String str, ul2 ul2Var, hq2 hq2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var, String str2, qz1 qz1Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x33Var, str, ul2Var, hq2Var, unitedSchemeEntity, callbackHandler, h03Var, str2, qz1Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = x33Var;
            this.a = str;
            this.b = ul2Var;
            this.c = hq2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = h03Var;
            this.g = str2;
            this.h = qz1Var;
            this.i = context;
        }

        @Override // com.repackage.w33.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                nt2.d(this.a);
                hx1.i("relaunch", "check pages success");
                this.b.o();
                m62.e f = m62.f(this.b.getActivity(), r62.c(this.c.a));
                q33.l(this.d, this.e, this.f, f.a.b(), this.c.a, null, this.g);
                this.j.p(f, this.c, this.h, this.a);
            }
        }

        @Override // com.repackage.w33.e
        public void b(int i, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ac3Var) == null) {
                hx1.c("relaunch", "check pages failed");
                this.b.o();
                if (e23.b) {
                    Context context = this.i;
                    zz2.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a3) + i).G();
                }
                q33.j(this.d, this.e, this.g);
                v63.j(this.c, ac3Var);
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

        public b(x33 x33Var, m62.e eVar, String str, hq2 hq2Var, qz1 qz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x33Var, eVar, str, hq2Var, qz1Var};
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
            this.c = hq2Var;
            this.d = qz1Var;
        }

        @Override // com.repackage.m62.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (e23.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                nt2.e(this.a, this.b);
                q33.e(this.a.a, this.c, this.b);
                x33.o(this.d, this.c, this.b);
                if (e23.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x33(e13 e13Var) {
        super(e13Var, "/swanAPI/reLaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e13Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void o(qz1 qz1Var, hq2 hq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, qz1Var, hq2Var, str) == null) {
            cq1.y(qz1Var, hq2Var, str);
        }
    }

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            if (e23.b) {
                Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            nt2.b(uuid);
            String o = q33.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                hx1.c("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            ul2 U = ul2.U();
            qz1 V = U.V();
            if (V == null) {
                hx1.c("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            hq2 d = hq2.d(o, U.z());
            d.e = "3";
            d.f = uuid;
            v63.g(d);
            if (!be3.b(U.s(), d, true)) {
                hx1.c("relaunch", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                v63.i(d);
                return false;
            }
            String n = q33.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d.d) && h03.M() != null) {
                h03.M().L0(n, d.d);
            }
            String n2 = q33.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = mt2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString = hd3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                hx1.c("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                v63.i(d);
                return false;
            } else if (u23.b().a(d)) {
                u23.b().i("reLaunch", d);
                hx1.c("ReLaunchAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                w33.g(h03Var, d, "", new a(this, uuid, U, d, unitedSchemeEntity, callbackHandler, h03Var, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(m62.e eVar, hq2 hq2Var, qz1 qz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, hq2Var, qz1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = mt2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (e23.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            m62.q(eVar, new b(this, eVar, str, hq2Var, qz1Var));
            if (e23.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
