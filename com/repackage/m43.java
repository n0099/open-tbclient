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
import com.repackage.e72;
import com.repackage.i02;
import com.repackage.o43;
import java.util.UUID;
@Deprecated
/* loaded from: classes6.dex */
public class m43 extends w23 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes6.dex */
    public class a implements o43.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ z03 b;
        public final /* synthetic */ mm2 c;
        public final /* synthetic */ zq2 d;
        public final /* synthetic */ i02 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ m43 j;

        public a(m43 m43Var, String str, z03 z03Var, mm2 mm2Var, zq2 zq2Var, i02 i02Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m43Var, str, z03Var, mm2Var, zq2Var, i02Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = m43Var;
            this.a = str;
            this.b = z03Var;
            this.c = mm2Var;
            this.d = zq2Var;
            this.e = i02Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.repackage.o43.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                fu2.d(this.a);
                zx1.i("navigateTo", "check pages success");
                s73.F(true, this.b.Y().T());
                this.c.o();
                e72.e f = e72.f(this.c.getActivity(), j72.c(this.d.a));
                i43.l(this.f, this.g, this.b, f.a.a(), this.d.a, i43.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.repackage.o43.e
        public void b(int i, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, sc3Var) == null) {
                zx1.c("navigateTo", "check pages failed");
                s73.F(false, this.b.Y().T());
                this.c.o();
                if (w23.b) {
                    Context context = this.i;
                    r03.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a6) + i).G();
                }
                i43.j(this.f, this.g, this.h);
                n73.j(this.d, sc3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements e72.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e72.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ zq2 c;
        public final /* synthetic */ i02 d;
        public final /* synthetic */ m43 e;

        public b(m43 m43Var, e72.e eVar, String str, zq2 zq2Var, i02 i02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m43Var, eVar, str, zq2Var, i02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = m43Var;
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
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                fu2.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (w23.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755549307, "Lcom/repackage/m43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755549307, "Lcom/repackage/m43;");
                return;
            }
        }
        d = gk2.g0().r();
        if (w23.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m43(w13 w13Var) {
        super(w13Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w13Var};
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

    @Override // com.repackage.w23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, z03 z03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, z03Var)) == null) {
            if (w23.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            fu2.b(uuid);
            String o = i43.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                zx1.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            mm2 U = mm2.U();
            i02 V = U.V();
            if (V == null) {
                zx1.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            zq2 d2 = zq2.d(o, U.z());
            d2.e = "0";
            d2.f = uuid;
            n73.g(d2);
            if (!te3.b(U.s(), d2, false)) {
                zx1.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                n73.i(d2);
                return false;
            }
            String n = i43.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && z03.M() != null) {
                z03.M().L0(n, d2.d);
            }
            String n2 = i43.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = eu2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (w23.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = zd3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                zx1.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                n73.i(d2);
                return false;
            } else if (m33.b().a(d2)) {
                m33.b().i("navigateTo", d2);
                zx1.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                o43.g(z03Var, d2, "", new a(this, uuid, z03Var, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(fn1 fn1Var, zq2 zq2Var, i02 i02Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fn1Var, zq2Var, i02Var, str) == null) || (activity = mm2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        i43.e(fn1Var, zq2Var, str);
        fu2.c(0, str);
        if (i02Var.k() < d) {
            h02.S3(te3.n());
            i02.b i = i02Var.i("navigateTo");
            i.n(i02.g, i02.i);
            i.k("normal", zq2Var).b();
            jd3.c(i02Var, this.c);
            eu2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            fu2.a(str, zq2Var);
            return;
        }
        tq1.A(i02Var, zq2Var, str, true);
    }

    public final void p(e72.e eVar, zq2 zq2Var, i02 i02Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, zq2Var, i02Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = eu2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            if (w23.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            e72.q(eVar, new b(this, eVar, str, zq2Var, i02Var));
            if (w23.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
