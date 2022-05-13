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
import com.repackage.j43;
import com.repackage.z62;
import java.util.UUID;
@Deprecated
/* loaded from: classes6.dex */
public class k43 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements j43.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hm2 b;
        public final /* synthetic */ uq2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ u03 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ d02 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ k43 j;

        public a(k43 k43Var, String str, hm2 hm2Var, uq2 uq2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var, String str2, d02 d02Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k43Var, str, hm2Var, uq2Var, unitedSchemeEntity, callbackHandler, u03Var, str2, d02Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = k43Var;
            this.a = str;
            this.b = hm2Var;
            this.c = uq2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = u03Var;
            this.g = str2;
            this.h = d02Var;
            this.i = context;
        }

        @Override // com.repackage.j43.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                au2.d(this.a);
                ux1.i("relaunch", "check pages success");
                this.b.o();
                z62.e f = z62.f(this.b.getActivity(), e72.c(this.c.a));
                d43.l(this.d, this.e, this.f, f.a.c(), this.c.a, null, this.g);
                this.j.p(f, this.c, this.h, this.a);
            }
        }

        @Override // com.repackage.j43.e
        public void c(int i, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, nc3Var) == null) {
                ux1.c("relaunch", "check pages failed");
                this.b.o();
                if (r23.b) {
                    Context context = this.i;
                    m03.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a0) + i).G();
                }
                d43.j(this.d, this.e, this.g);
                i73.j(this.c, nc3Var);
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

        public b(k43 k43Var, z62.e eVar, String str, uq2 uq2Var, d02 d02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k43Var, eVar, str, uq2Var, d02Var};
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
            this.c = uq2Var;
            this.d = d02Var;
        }

        @Override // com.repackage.z62.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (r23.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                au2.e(this.a, this.b);
                d43.e(this.a.a, this.c, this.b);
                k43.o(this.d, this.c, this.b);
                if (r23.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k43(r13 r13Var) {
        super(r13Var, "/swanAPI/reLaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r13Var};
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

    public static void o(d02 d02Var, uq2 uq2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, d02Var, uq2Var, str) == null) {
            pq1.y(d02Var, uq2Var, str);
        }
    }

    @Override // com.repackage.r23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            if (r23.b) {
                Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            au2.b(uuid);
            String o = d43.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                ux1.c("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            hm2 U = hm2.U();
            d02 V = U.V();
            if (V == null) {
                ux1.c("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            uq2 d = uq2.d(o, U.z());
            d.e = "3";
            d.f = uuid;
            i73.g(d);
            if (!oe3.b(U.s(), d, true)) {
                ux1.c("relaunch", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                i73.i(d);
                return false;
            }
            String n = d43.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d.d) && u03.L() != null) {
                u03.L().K0(n, d.d);
            }
            String n2 = d43.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = zt2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString = ud3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                ux1.c("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                i73.i(d);
                return false;
            } else if (h33.b().a(d)) {
                h33.b().i("reLaunch", d);
                ux1.c("ReLaunchAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                j43.g(u03Var, d, "", new a(this, uuid, U, d, unitedSchemeEntity, callbackHandler, u03Var, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(z62.e eVar, uq2 uq2Var, d02 d02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, uq2Var, d02Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = zt2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (r23.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            z62.q(eVar, new b(this, eVar, str, uq2Var, d02Var));
            if (r23.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
