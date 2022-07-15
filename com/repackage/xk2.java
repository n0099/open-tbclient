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
import com.repackage.dj2;
import com.repackage.el2;
import com.repackage.fl2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xk2 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements u74 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ h03 h;
        public final /* synthetic */ xk2 i;

        public a(xk2 xk2Var, String str, JSONObject jSONObject, String str2, String str3, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk2Var, str, jSONObject, str2, str3, context, unitedSchemeEntity, callbackHandler, h03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = xk2Var;
            this.a = str;
            this.b = jSONObject;
            this.c = str2;
            this.d = str3;
            this.e = context;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = h03Var;
        }

        @Override // com.repackage.u74
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

        @Override // com.repackage.u74
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (e23.b) {
                    Log.e("LaunchAction", "getOpenBundleId", exc);
                }
                this.f.result = UnitedSchemeUtility.wrapCallbackParams(201);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements dj2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fl2.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ String f;

        public b(xk2 xk2Var, fl2.a aVar, String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk2Var, aVar, str, str2, callbackHandler, unitedSchemeEntity, str3};
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

        @Override // com.repackage.dj2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.repackage.dj2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ac3 ac3Var = new ac3();
                ac3Var.k(7L);
                ac3Var.i(9L);
                ac3Var.f("debug download pkg fail");
                ec3.a().f(ac3Var);
                bl2.e(oj2.c(), ac3Var, 0, this.c);
                i73 i73Var = new i73();
                i73Var.p(ac3Var);
                i73Var.r(this.a);
                a73.R(i73Var);
                this.e.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            }
        }

        @Override // com.repackage.dj2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ((fl2.a) this.a.A0(true)).a1("1.6.0");
                SwanLauncher.j().n(this.a, null);
                xk2.n(this.b, this.c, this.d, this.e, this.f);
            }
        }
    }

    /* loaded from: classes7.dex */
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

        @Override // com.repackage.xk2.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xk2.m(this.a, this.b, this.c, 1001);
            }
        }

        @Override // com.repackage.xk2.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                xk2.m(this.a, this.b, this.c, 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends nw2 {
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
        @Override // com.repackage.nw2, com.repackage.ow2, com.repackage.mw2
        public void onEvent(@NonNull kw2 kw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kw2Var) == null) {
                if (kw2Var.a() != null && kw2Var.a().getInt("ok") == 0) {
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

    /* loaded from: classes7.dex */
    public interface e {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xk2(e13 e13Var) {
        super(e13Var, "/swanAPI/launch");
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
                yk2.j(str2, cVar);
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
        g03.K().y().X(bundle, yk2.class, new d(eVar));
    }

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            hx1.b("LaunchAction", "handle entity: ", unitedSchemeEntity);
            String uri = unitedSchemeEntity.getUri() != null ? unitedSchemeEntity.getUri().toString() : "";
            hx1.i("LaunchAction", "launch scheme = " + uri);
            HashMap<String, String> params = unitedSchemeEntity.getParams();
            String str = params.get("params");
            String str2 = params.get("from");
            if (TextUtils.isEmpty(str)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                ac3 ac3Var = new ac3();
                ac3Var.k(1L);
                ac3Var.i(1L);
                ac3Var.f("paramsValue is empty");
                ec3.a().f(ac3Var);
                bl2.e(context, ac3Var, 0, "");
                i73 i73Var = new i73();
                i73Var.p(ac3Var);
                i73Var.t(str2);
                i73Var.l("scheme", uri);
                a73.R(i73Var);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("appid");
                String optString2 = jSONObject.optString("navi");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    ac3 ac3Var2 = new ac3();
                    ac3Var2.k(1L);
                    ac3Var2.i(1L);
                    ac3Var2.f("appId is empty");
                    ec3.a().f(ac3Var2);
                    bl2.e(context, ac3Var2, 0, "");
                    i73 i73Var2 = new i73();
                    i73Var2.p(ac3Var2);
                    i73Var2.t(str2);
                    i73Var2.l("scheme", uri);
                    a73.R(i73Var2);
                    return false;
                } else if (uc4.e().g(!be3.G()) && TextUtils.equals(optString2, "naviTo")) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(optString);
                    p74.e(arrayList, g03.K().q().O(), new a(this, optString, jSONObject, str2, uri, context, unitedSchemeEntity, callbackHandler, h03Var));
                    return true;
                } else {
                    return o(jSONObject, str2, uri, context, unitedSchemeEntity, optString, callbackHandler, h03Var);
                }
            } catch (JSONException e2) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                ac3 ac3Var3 = new ac3();
                ac3Var3.k(1L);
                ac3Var3.i(1L);
                ac3Var3.f("parse paramsValue with JSONException:" + e2.getMessage());
                ec3.a().f(ac3Var3);
                bl2.e(context, ac3Var3, 0, "");
                i73 i73Var3 = new i73();
                i73Var3.p(ac3Var3);
                i73Var3.t(str2);
                i73Var3.l("scheme", uri);
                a73.R(i73Var3);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean o(JSONObject jSONObject, String str, String str2, Context context, UnitedSchemeEntity unitedSchemeEntity, String str3, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONObject, str, str2, context, unitedSchemeEntity, str3, callbackHandler, h03Var})) == null) {
            String h = SwanLauncher.h();
            g03.K().q().W().J0(h);
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
            String optString3 = jSONObject.optString("downloadurl");
            String optString4 = jSONObject.optString("clkid");
            String optString5 = jSONObject.optString("notinhis");
            String optString6 = jSONObject.optString("cb");
            String optString7 = jSONObject.optString("navi");
            fl2.a aVar = (fl2.a) ((fl2.a) ((fl2.a) ((fl2.a) ((fl2.a) ((fl2.a) ((fl2.a) new fl2.a().v0(str3)).R0(optString)).I0(str)).K0(str2)).y0(optString4)).P0(optString5)).J0(h);
            if (h03Var != null && !TextUtils.isEmpty(optString7)) {
                aVar.r0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, optString2);
                aVar.r0("navi", optString7);
                el2.a Y = h03Var.Y();
                if (Y == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String H = Y.H();
                if (js1.e(Y) && !js1.f(str3)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.r0("srcAppId", H);
                aVar.r0("srcAppKey", Y.I());
                aVar.q0("srcPkgType", Y.getType());
                aVar.r0("srcAppPage", be3.n().e());
            }
            if (e23.b && !TextUtils.isEmpty(optString3)) {
                dj2.d dVar = new dj2.d();
                dVar.a = optString3;
                dj2.K(dVar, new b(this, aVar, optString7, str3, callbackHandler, unitedSchemeEntity, optString6));
                return true;
            } else if (TextUtils.isEmpty(optString3)) {
                aVar.A0(false);
                SwanLauncher.j().n(aVar, null);
                n(optString7, str3, callbackHandler, unitedSchemeEntity, optString6);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                ac3 ac3Var = new ac3();
                ac3Var.k(1L);
                ac3Var.i(1L);
                ac3Var.f("release but downloadUrl is not empty");
                ec3.a().f(ac3Var);
                bl2.e(context, ac3Var, 0, str3);
                i73 i73Var = new i73();
                i73Var.t(str);
                i73Var.m(str3);
                i73Var.r(aVar);
                i73Var.l("scheme", str2);
                a73.R(i73Var);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
