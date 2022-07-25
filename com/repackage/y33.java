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
import com.repackage.n62;
import com.repackage.x33;
import java.util.UUID;
@Deprecated
/* loaded from: classes7.dex */
public class y33 extends f23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements x33.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ vl2 b;
        public final /* synthetic */ iq2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ i03 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ rz1 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ y33 j;

        public a(y33 y33Var, String str, vl2 vl2Var, iq2 iq2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, i03 i03Var, String str2, rz1 rz1Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y33Var, str, vl2Var, iq2Var, unitedSchemeEntity, callbackHandler, i03Var, str2, rz1Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = y33Var;
            this.a = str;
            this.b = vl2Var;
            this.c = iq2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = i03Var;
            this.g = str2;
            this.h = rz1Var;
            this.i = context;
        }

        @Override // com.repackage.x33.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ot2.d(this.a);
                ix1.i("relaunch", "check pages success");
                this.b.o();
                n62.e f = n62.f(this.b.getActivity(), s62.c(this.c.a));
                r33.l(this.d, this.e, this.f, f.a.b(), this.c.a, null, this.g);
                this.j.p(f, this.c, this.h, this.a);
            }
        }

        @Override // com.repackage.x33.e
        public void b(int i, bc3 bc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bc3Var) == null) {
                ix1.c("relaunch", "check pages failed");
                this.b.o();
                if (f23.b) {
                    Context context = this.i;
                    a03.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a3) + i).G();
                }
                r33.j(this.d, this.e, this.g);
                w63.j(this.c, bc3Var);
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

        public b(y33 y33Var, n62.e eVar, String str, iq2 iq2Var, rz1 rz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y33Var, eVar, str, iq2Var, rz1Var};
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
            this.c = iq2Var;
            this.d = rz1Var;
        }

        @Override // com.repackage.n62.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (f23.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                ot2.e(this.a, this.b);
                r33.e(this.a.a, this.c, this.b);
                y33.o(this.d, this.c, this.b);
                if (f23.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y33(f13 f13Var) {
        super(f13Var, "/swanAPI/reLaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f13Var};
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

    public static void o(rz1 rz1Var, iq2 iq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, rz1Var, iq2Var, str) == null) {
            dq1.y(rz1Var, iq2Var, str);
        }
    }

    @Override // com.repackage.f23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, i03 i03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, i03Var)) == null) {
            if (f23.b) {
                Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            ot2.b(uuid);
            String o = r33.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                ix1.c("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            vl2 U = vl2.U();
            rz1 V = U.V();
            if (V == null) {
                ix1.c("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            iq2 d = iq2.d(o, U.z());
            d.e = "3";
            d.f = uuid;
            w63.g(d);
            if (!ce3.b(U.s(), d, true)) {
                ix1.c("relaunch", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                w63.i(d);
                return false;
            }
            String n = r33.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d.d) && i03.M() != null) {
                i03.M().L0(n, d.d);
            }
            String n2 = r33.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = nt2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString = id3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                ix1.c("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                w63.i(d);
                return false;
            } else if (v23.b().a(d)) {
                v23.b().i("reLaunch", d);
                ix1.c("ReLaunchAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                x33.g(i03Var, d, "", new a(this, uuid, U, d, unitedSchemeEntity, callbackHandler, i03Var, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(n62.e eVar, iq2 iq2Var, rz1 rz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, iq2Var, rz1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = nt2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (f23.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            n62.q(eVar, new b(this, eVar, str, iq2Var, rz1Var));
            if (f23.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
