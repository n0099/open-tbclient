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
import com.repackage.bz1;
import com.repackage.h33;
import com.repackage.x52;
import java.util.UUID;
@Deprecated
/* loaded from: classes5.dex */
public class f33 extends p13 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes5.dex */
    public class a implements h33.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ sz2 b;
        public final /* synthetic */ fl2 c;
        public final /* synthetic */ sp2 d;
        public final /* synthetic */ bz1 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ f33 j;

        public a(f33 f33Var, String str, sz2 sz2Var, fl2 fl2Var, sp2 sp2Var, bz1 bz1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f33Var, str, sz2Var, fl2Var, sp2Var, bz1Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = f33Var;
            this.a = str;
            this.b = sz2Var;
            this.c = fl2Var;
            this.d = sp2Var;
            this.e = bz1Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.repackage.h33.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ys2.d(this.a);
                sw1.i("navigateTo", "check pages success");
                l63.F(true, this.b.Y().T());
                this.c.o();
                x52.e f = x52.f(this.c.getActivity(), c62.c(this.d.a));
                b33.l(this.f, this.g, this.b, f.a.c(), this.d.a, b33.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.repackage.h33.e
        public void b(int i, lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, lb3Var) == null) {
                sw1.c("navigateTo", "check pages failed");
                l63.F(false, this.b.Y().T());
                this.c.o();
                if (p13.b) {
                    Context context = this.i;
                    kz2.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a1) + i).G();
                }
                b33.j(this.f, this.g, this.h);
                g63.j(this.d, lb3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements x52.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x52.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sp2 c;
        public final /* synthetic */ bz1 d;
        public final /* synthetic */ f33 e;

        public b(f33 f33Var, x52.e eVar, String str, sp2 sp2Var, bz1 bz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f33Var, eVar, str, sp2Var, bz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = f33Var;
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
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                ys2.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (p13.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755758805, "Lcom/repackage/f33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755758805, "Lcom/repackage/f33;");
                return;
            }
        }
        d = zi2.g0().r();
        if (p13.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f33(p03 p03Var) {
        super(p03Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p03Var};
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

    @Override // com.repackage.p13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, sz2 sz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, sz2Var)) == null) {
            if (p13.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            ys2.b(uuid);
            String o = b33.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                sw1.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            fl2 U = fl2.U();
            bz1 V = U.V();
            if (V == null) {
                sw1.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            sp2 d2 = sp2.d(o, U.z());
            d2.e = "0";
            d2.f = uuid;
            g63.g(d2);
            if (!md3.b(U.s(), d2, false)) {
                sw1.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                g63.i(d2);
                return false;
            }
            String n = b33.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && sz2.M() != null) {
                sz2.M().L0(n, d2.d);
            }
            String n2 = b33.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = xs2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (p13.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = sc3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                sw1.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                g63.i(d2);
                return false;
            } else if (f23.b().a(d2)) {
                f23.b().i("navigateTo", d2);
                sw1.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                h33.g(sz2Var, d2, "", new a(this, uuid, sz2Var, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(yl1 yl1Var, sp2 sp2Var, bz1 bz1Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yl1Var, sp2Var, bz1Var, str) == null) || (activity = fl2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        b33.e(yl1Var, sp2Var, str);
        ys2.c(0, str);
        if (bz1Var.k() < d) {
            az1.S3(md3.n());
            bz1.b i = bz1Var.i("navigateTo");
            i.n(bz1.g, bz1.i);
            i.k("normal", sp2Var).b();
            cc3.c(bz1Var, this.c);
            xs2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            ys2.a(str, sp2Var);
            return;
        }
        mp1.A(bz1Var, sp2Var, str, true);
    }

    public final void p(x52.e eVar, sp2 sp2Var, bz1 bz1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, sp2Var, bz1Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = xs2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (p13.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            x52.q(eVar, new b(this, eVar, str, sp2Var, bz1Var));
            if (p13.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
