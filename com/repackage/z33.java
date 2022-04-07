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
import com.repackage.o62;
import com.repackage.y33;
import java.util.UUID;
@Deprecated
/* loaded from: classes7.dex */
public class z33 extends g23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements y33.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wl2 b;
        public final /* synthetic */ jq2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ j03 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ sz1 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ z33 j;

        public a(z33 z33Var, String str, wl2 wl2Var, jq2 jq2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, j03 j03Var, String str2, sz1 sz1Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z33Var, str, wl2Var, jq2Var, unitedSchemeEntity, callbackHandler, j03Var, str2, sz1Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = z33Var;
            this.a = str;
            this.b = wl2Var;
            this.c = jq2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = j03Var;
            this.g = str2;
            this.h = sz1Var;
            this.i = context;
        }

        @Override // com.repackage.y33.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                pt2.d(this.a);
                jx1.i("relaunch", "check pages success");
                this.b.o();
                o62.e f = o62.f(this.b.getActivity(), t62.c(this.c.a));
                s33.l(this.d, this.e, this.f, f.a.c(), this.c.a, null, this.g);
                this.j.p(f, this.c, this.h, this.a);
            }
        }

        @Override // com.repackage.y33.e
        public void c(int i, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cc3Var) == null) {
                jx1.c("relaunch", "check pages failed");
                this.b.o();
                if (g23.b) {
                    Context context = this.i;
                    b03.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f019e) + i).G();
                }
                s33.j(this.d, this.e, this.g);
                x63.j(this.c, cc3Var);
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

        public b(z33 z33Var, o62.e eVar, String str, jq2 jq2Var, sz1 sz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z33Var, eVar, str, jq2Var, sz1Var};
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
            this.c = jq2Var;
            this.d = sz1Var;
        }

        @Override // com.repackage.o62.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (g23.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                pt2.e(this.a, this.b);
                s33.e(this.a.a, this.c, this.b);
                z33.o(this.d, this.c, this.b);
                if (g23.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z33(g13 g13Var) {
        super(g13Var, "/swanAPI/reLaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g13Var};
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

    public static void o(sz1 sz1Var, jq2 jq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, sz1Var, jq2Var, str) == null) {
            eq1.y(sz1Var, jq2Var, str);
        }
    }

    @Override // com.repackage.g23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, j03Var)) == null) {
            if (g23.b) {
                Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            pt2.b(uuid);
            String o = s33.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                jx1.c("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            wl2 U = wl2.U();
            sz1 V = U.V();
            if (V == null) {
                jx1.c("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            jq2 d = jq2.d(o, U.z());
            d.e = "3";
            d.f = uuid;
            x63.g(d);
            if (!de3.b(U.s(), d, true)) {
                jx1.c("relaunch", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                x63.i(d);
                return false;
            }
            String n = s33.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d.d) && j03.L() != null) {
                j03.L().K0(n, d.d);
            }
            String n2 = s33.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = ot2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString = jd3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                jx1.c("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                x63.i(d);
                return false;
            } else if (w23.b().a(d)) {
                w23.b().i("reLaunch", d);
                jx1.c("ReLaunchAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                y33.g(j03Var, d, "", new a(this, uuid, U, d, unitedSchemeEntity, callbackHandler, j03Var, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(o62.e eVar, jq2 jq2Var, sz1 sz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, jq2Var, sz1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = ot2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (g23.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            o62.q(eVar, new b(this, eVar, str, jq2Var, sz1Var));
            if (g23.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
