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
import com.repackage.h33;
import com.repackage.x52;
import java.util.UUID;
@Deprecated
/* loaded from: classes6.dex */
public class j33 extends p13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements h33.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ fl2 b;
        public final /* synthetic */ sp2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ sz2 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ bz1 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ j33 j;

        public a(j33 j33Var, String str, fl2 fl2Var, sp2 sp2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, sz2 sz2Var, String str2, bz1 bz1Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j33Var, str, fl2Var, sp2Var, unitedSchemeEntity, callbackHandler, sz2Var, str2, bz1Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = j33Var;
            this.a = str;
            this.b = fl2Var;
            this.c = sp2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = sz2Var;
            this.g = str2;
            this.h = bz1Var;
            this.i = context;
        }

        @Override // com.repackage.h33.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ys2.d(this.a);
                sw1.i("redirect", "check pages success");
                this.b.o();
                x52.e f = x52.f(this.b.getActivity(), c62.c(this.c.a));
                b33.l(this.d, this.e, this.f, f.a.c(), this.c.a, null, this.g);
                this.j.n(f, this.c, this.h, this.a);
            }
        }

        @Override // com.repackage.h33.e
        public void b(int i, lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, lb3Var) == null) {
                sw1.c("redirect", "check pages failed");
                this.b.o();
                if (p13.b) {
                    Context context = this.i;
                    kz2.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a1) + i).G();
                }
                b33.j(this.d, this.e, this.g);
                g63.j(this.c, lb3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements x52.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x52.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sp2 c;
        public final /* synthetic */ bz1 d;

        public b(j33 j33Var, x52.e eVar, String str, sp2 sp2Var, bz1 bz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j33Var, eVar, str, sp2Var, bz1Var};
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
            this.c = sp2Var;
            this.d = bz1Var;
        }

        @Override // com.repackage.x52.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (p13.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                ys2.e(this.a, this.b);
                b33.e(this.a.a, this.c, this.b);
                mp1.A(this.d, this.c, this.b, false);
                if (p13.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j33(p03 p03Var) {
        super(p03Var, "/swanAPI/redirectTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p03Var};
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

    @Override // com.repackage.p13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, sz2Var)) == null) {
            if (p13.b) {
                Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            ys2.b(uuid);
            String o = b33.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                sw1.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            fl2 U = fl2.U();
            bz1 V = U.V();
            if (V == null) {
                sw1.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            sp2 d = sp2.d(o, U.z());
            d.e = "2";
            d.f = uuid;
            g63.g(d);
            if (!md3.b(U.s(), d, false)) {
                sw1.c("redirect", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                g63.i(d);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d.d) && sz2.M() != null) {
                sz2.M().L0(str, d.d);
            }
            String n = b33.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = xs2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            if (p13.b) {
                Log.d("redirectTo", "PreloadSlaveManager start.");
            }
            String optString = sc3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                sw1.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                g63.i(d);
                return false;
            } else if (f23.b().a(d)) {
                f23.b().i("redirectTo", d);
                sw1.c("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                h33.g(sz2Var, d, "", new a(this, uuid, U, d, unitedSchemeEntity, callbackHandler, sz2Var, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(x52.e eVar, sp2 sp2Var, bz1 bz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, sp2Var, bz1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = xs2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (p13.b) {
                Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            x52.q(eVar, new b(this, eVar, str, sp2Var, bz1Var));
            if (p13.b) {
                Log.d("redirectTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
