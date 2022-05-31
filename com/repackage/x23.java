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
import com.repackage.m52;
import com.repackage.w23;
import java.util.UUID;
@Deprecated
/* loaded from: classes7.dex */
public class x23 extends e13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements w23.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ uk2 b;
        public final /* synthetic */ hp2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ hz2 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ qy1 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ x23 j;

        public a(x23 x23Var, String str, uk2 uk2Var, hp2 hp2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var, String str2, qy1 qy1Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x23Var, str, uk2Var, hp2Var, unitedSchemeEntity, callbackHandler, hz2Var, str2, qy1Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = x23Var;
            this.a = str;
            this.b = uk2Var;
            this.c = hp2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = hz2Var;
            this.g = str2;
            this.h = qy1Var;
            this.i = context;
        }

        @Override // com.repackage.w23.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ns2.d(this.a);
                hw1.i("relaunch", "check pages success");
                this.b.o();
                m52.e f = m52.f(this.b.getActivity(), r52.c(this.c.a));
                q23.l(this.d, this.e, this.f, f.a.c(), this.c.a, null, this.g);
                this.j.p(f, this.c, this.h, this.a);
            }
        }

        @Override // com.repackage.w23.e
        public void c(int i, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ab3Var) == null) {
                hw1.c("relaunch", "check pages failed");
                this.b.o();
                if (e13.b) {
                    Context context = this.i;
                    zy2.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a1) + i).G();
                }
                q23.j(this.d, this.e, this.g);
                v53.j(this.c, ab3Var);
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

        public b(x23 x23Var, m52.e eVar, String str, hp2 hp2Var, qy1 qy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x23Var, eVar, str, hp2Var, qy1Var};
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
            this.c = hp2Var;
            this.d = qy1Var;
        }

        @Override // com.repackage.m52.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (e13.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                ns2.e(this.a, this.b);
                q23.e(this.a.a, this.c, this.b);
                x23.o(this.d, this.c, this.b);
                if (e13.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x23(e03 e03Var) {
        super(e03Var, "/swanAPI/reLaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e03Var};
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

    public static void o(qy1 qy1Var, hp2 hp2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, qy1Var, hp2Var, str) == null) {
            cp1.y(qy1Var, hp2Var, str);
        }
    }

    @Override // com.repackage.e13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hz2Var)) == null) {
            if (e13.b) {
                Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            ns2.b(uuid);
            String o = q23.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                hw1.c("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            uk2 U = uk2.U();
            qy1 V = U.V();
            if (V == null) {
                hw1.c("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            hp2 d = hp2.d(o, U.z());
            d.e = "3";
            d.f = uuid;
            v53.g(d);
            if (!bd3.b(U.s(), d, true)) {
                hw1.c("relaunch", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                v53.i(d);
                return false;
            }
            String n = q23.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d.d) && hz2.L() != null) {
                hz2.L().K0(n, d.d);
            }
            String n2 = q23.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = ms2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString = hc3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                hw1.c("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                v53.i(d);
                return false;
            } else if (u13.b().a(d)) {
                u13.b().i("reLaunch", d);
                hw1.c("ReLaunchAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                w23.g(hz2Var, d, "", new a(this, uuid, U, d, unitedSchemeEntity, callbackHandler, hz2Var, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(m52.e eVar, hp2 hp2Var, qy1 qy1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, hp2Var, qy1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = ms2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (e13.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            m52.q(eVar, new b(this, eVar, str, hp2Var, qy1Var));
            if (e13.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
