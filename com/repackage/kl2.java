package com.repackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qj2;
import com.repackage.rl2;
import com.repackage.sl2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kl2 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements h84 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ u03 h;
        public final /* synthetic */ kl2 i;

        public a(kl2 kl2Var, String str, JSONObject jSONObject, String str2, String str3, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kl2Var, str, jSONObject, str2, str3, context, unitedSchemeEntity, callbackHandler, u03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = kl2Var;
            this.a = str;
            this.b = jSONObject;
            this.c = str2;
            this.d = str3;
            this.e = context;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = u03Var;
        }

        @Override // com.repackage.h84
        public void a(@Nullable Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, map) == null) || map == null) {
                return;
            }
            String str = map.get(this.a);
            if (TextUtils.isEmpty(str)) {
                str = this.a;
            }
            this.i.o(this.b, this.c, this.d, this.e, this.f, str, this.g, this.h);
        }

        @Override // com.repackage.h84
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (r23.b) {
                    Log.e("LaunchAction", "getOpenBundleId", exc);
                }
                this.f.result = UnitedSchemeUtility.wrapCallbackParams(201);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements qj2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl2.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ String f;

        public b(kl2 kl2Var, sl2.a aVar, String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kl2Var, aVar, str, str2, callbackHandler, unitedSchemeEntity, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = str;
            this.c = str2;
            this.d = callbackHandler;
            this.e = unitedSchemeEntity;
            this.f = str3;
        }

        @Override // com.repackage.qj2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.repackage.qj2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                nc3 nc3Var = new nc3();
                nc3Var.k(7L);
                nc3Var.i(9L);
                nc3Var.f("debug download pkg fail");
                rc3.a().f(nc3Var);
                ol2.e(bk2.c(), nc3Var, 0, this.c);
                v73 v73Var = new v73();
                v73Var.p(nc3Var);
                v73Var.r(this.a);
                n73.R(v73Var);
                this.e.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            }
        }

        @Override // com.repackage.qj2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ((sl2.a) this.a.A0(true)).a1("1.6.0");
                SwanLauncher.j().n(this.a, null);
                kl2.n(this.b, this.c, this.d, this.e, this.f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ String c;

        public c(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, unitedSchemeEntity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = str;
        }

        @Override // com.repackage.kl2.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kl2.m(this.a, this.b, this.c, 1001);
            }
        }

        @Override // com.repackage.kl2.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                kl2.m(this.a, this.b, this.c, 0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends ax2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e c;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ax2, com.repackage.bx2, com.repackage.zw2
        public void onEvent(@NonNull xw2 xw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xw2Var) == null) {
                if (xw2Var.a() != null && xw2Var.a().getInt("ok") == 0) {
                    e eVar = this.c;
                    if (eVar != null) {
                        eVar.b();
                        return;
                    }
                    return;
                }
                e eVar2 = this.c;
                if (eVar2 != null) {
                    eVar2.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kl2(r13 r13Var) {
        super(r13Var, "/swanAPI/launch");
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

    public static void m(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, unitedSchemeEntity, str, i) == null) {
            if (TextUtils.isEmpty(str)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i));
            } else {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i).toString(), str);
            }
        }
    }

    public static void n(String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65541, null, str, str2, callbackHandler, unitedSchemeEntity, str3) == null) {
            if (!TextUtils.isEmpty(str3)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str3)) {
                return;
            }
            c cVar = new c(callbackHandler, unitedSchemeEntity, str3);
            if (ProcessUtils.isMainProcess()) {
                ll2.j(str2, cVar);
            } else {
                p(str2, cVar);
            }
        }
    }

    public static void p(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, str, eVar) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("desAppId", str);
        t03.J().z().W(bundle, ll2.class, new d(eVar));
    }

    @Override // com.repackage.r23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            ux1.b("LaunchAction", "handle entity: ", unitedSchemeEntity);
            String uri = unitedSchemeEntity.getUri() != null ? unitedSchemeEntity.getUri().toString() : "";
            ux1.i("LaunchAction", "launch scheme = " + uri);
            HashMap<String, String> params = unitedSchemeEntity.getParams();
            String str = params.get("params");
            String str2 = params.get("from");
            if (TextUtils.isEmpty(str)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                nc3 nc3Var = new nc3();
                nc3Var.k(1L);
                nc3Var.i(1L);
                nc3Var.f("paramsValue is empty");
                rc3.a().f(nc3Var);
                ol2.e(context, nc3Var, 0, "");
                v73 v73Var = new v73();
                v73Var.p(nc3Var);
                v73Var.t(str2);
                v73Var.l("scheme", uri);
                n73.R(v73Var);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("appid");
                String optString2 = jSONObject.optString("navi");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    nc3 nc3Var2 = new nc3();
                    nc3Var2.k(1L);
                    nc3Var2.i(1L);
                    nc3Var2.f("appId is empty");
                    rc3.a().f(nc3Var2);
                    ol2.e(context, nc3Var2, 0, "");
                    v73 v73Var2 = new v73();
                    v73Var2.p(nc3Var2);
                    v73Var2.t(str2);
                    v73Var2.l("scheme", uri);
                    n73.R(v73Var2);
                    return false;
                } else if (hd4.e().g(!oe3.G()) && TextUtils.equals(optString2, "naviTo")) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(optString);
                    c84.e(arrayList, t03.J().r().N(), new a(this, optString, jSONObject, str2, uri, context, unitedSchemeEntity, callbackHandler, u03Var));
                    return true;
                } else {
                    return o(jSONObject, str2, uri, context, unitedSchemeEntity, optString, callbackHandler, u03Var);
                }
            } catch (JSONException e2) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                nc3 nc3Var3 = new nc3();
                nc3Var3.k(1L);
                nc3Var3.i(1L);
                nc3Var3.f("parse paramsValue with JSONException:" + e2.getMessage());
                rc3.a().f(nc3Var3);
                ol2.e(context, nc3Var3, 0, "");
                v73 v73Var3 = new v73();
                v73Var3.p(nc3Var3);
                v73Var3.t(str2);
                v73Var3.l("scheme", uri);
                n73.R(v73Var3);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean o(JSONObject jSONObject, String str, String str2, Context context, UnitedSchemeEntity unitedSchemeEntity, String str3, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONObject, str, str2, context, unitedSchemeEntity, str3, callbackHandler, u03Var})) == null) {
            String h = SwanLauncher.h();
            t03.J().r().V().J0(h);
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
            String optString3 = jSONObject.optString("downloadurl");
            String optString4 = jSONObject.optString("clkid");
            String optString5 = jSONObject.optString("notinhis");
            String optString6 = jSONObject.optString("cb");
            String optString7 = jSONObject.optString("navi");
            sl2.a aVar = (sl2.a) ((sl2.a) ((sl2.a) ((sl2.a) ((sl2.a) ((sl2.a) ((sl2.a) new sl2.a().v0(str3)).R0(optString)).I0(str)).K0(str2)).y0(optString4)).P0(optString5)).J0(h);
            if (u03Var != null && !TextUtils.isEmpty(optString7)) {
                aVar.r0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, optString2);
                aVar.r0("navi", optString7);
                rl2.a X = u03Var.X();
                if (X == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String H = X.H();
                if (ws1.e(X) && !ws1.f(str3)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.r0("srcAppId", H);
                aVar.r0("srcAppKey", X.I());
                aVar.q0("srcPkgType", X.getType());
                aVar.r0("srcAppPage", oe3.n().e());
            }
            if (r23.b && !TextUtils.isEmpty(optString3)) {
                qj2.d dVar = new qj2.d();
                dVar.a = optString3;
                qj2.K(dVar, new b(this, aVar, optString7, str3, callbackHandler, unitedSchemeEntity, optString6));
                return true;
            } else if (TextUtils.isEmpty(optString3)) {
                aVar.A0(false);
                SwanLauncher.j().n(aVar, null);
                n(optString7, str3, callbackHandler, unitedSchemeEntity, optString6);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                nc3 nc3Var = new nc3();
                nc3Var.k(1L);
                nc3Var.i(1L);
                nc3Var.f("release but downloadUrl is not empty");
                rc3.a().f(nc3Var);
                ol2.e(context, nc3Var, 0, str3);
                v73 v73Var = new v73();
                v73Var.t(str);
                v73Var.m(str3);
                v73Var.r(aVar);
                v73Var.l("scheme", str2);
                n73.R(v73Var);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
