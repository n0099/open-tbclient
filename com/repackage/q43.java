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
import com.repackage.e72;
import com.repackage.o43;
import java.util.UUID;
@Deprecated
/* loaded from: classes7.dex */
public class q43 extends w23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements o43.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ mm2 b;
        public final /* synthetic */ zq2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ z03 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ i02 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ q43 j;

        public a(q43 q43Var, String str, mm2 mm2Var, zq2 zq2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, z03 z03Var, String str2, i02 i02Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q43Var, str, mm2Var, zq2Var, unitedSchemeEntity, callbackHandler, z03Var, str2, i02Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = q43Var;
            this.a = str;
            this.b = mm2Var;
            this.c = zq2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = z03Var;
            this.g = str2;
            this.h = i02Var;
            this.i = context;
        }

        @Override // com.repackage.o43.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                fu2.d(this.a);
                zx1.i("redirect", "check pages success");
                this.b.o();
                e72.e f = e72.f(this.b.getActivity(), j72.c(this.c.a));
                i43.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.n(f, this.c, this.h, this.a);
            }
        }

        @Override // com.repackage.o43.e
        public void b(int i, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, sc3Var) == null) {
                zx1.c("redirect", "check pages failed");
                this.b.o();
                if (w23.b) {
                    Context context = this.i;
                    r03.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a6) + i).G();
                }
                i43.j(this.d, this.e, this.g);
                n73.j(this.c, sc3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements e72.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ zq2 c;
        public final /* synthetic */ i02 d;

        public b(q43 q43Var, e72.e eVar, String str, zq2 zq2Var, i02 i02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q43Var, eVar, str, zq2Var, i02Var};
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
            this.c = zq2Var;
            this.d = i02Var;
        }

        @Override // com.repackage.e72.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (w23.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                fu2.e(this.a, this.b);
                i43.e(this.a.a, this.c, this.b);
                tq1.A(this.d, this.c, this.b, false);
                if (w23.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q43(w13 w13Var) {
        super(w13Var, "/swanAPI/redirectTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w13Var};
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

    @Override // com.repackage.w23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, z03Var)) == null) {
            if (w23.b) {
                Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            fu2.b(uuid);
            String o = i43.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                zx1.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            mm2 U = mm2.U();
            i02 V = U.V();
            if (V == null) {
                zx1.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            zq2 d = zq2.d(o, U.z());
            d.e = "2";
            d.f = uuid;
            n73.g(d);
            if (!te3.b(U.s(), d, false)) {
                zx1.c("redirect", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                n73.i(d);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d.d) && z03.M() != null) {
                z03.M().L0(str, d.d);
            }
            String n = i43.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = eu2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            if (w23.b) {
                Log.d("redirectTo", "PreloadSlaveManager start.");
            }
            String optString = zd3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                zx1.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                n73.i(d);
                return false;
            } else if (m33.b().a(d)) {
                m33.b().i("redirectTo", d);
                zx1.c("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                o43.g(z03Var, d, "", new a(this, uuid, U, d, unitedSchemeEntity, callbackHandler, z03Var, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(e72.e eVar, zq2 zq2Var, i02 i02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, zq2Var, i02Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = eu2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (w23.b) {
                Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            e72.q(eVar, new b(this, eVar, str, zq2Var, i02Var));
            if (w23.b) {
                Log.d("redirectTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
