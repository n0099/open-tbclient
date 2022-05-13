package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.repackage.d63;
import com.repackage.z53;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cp1 extends zo1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u03 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ cp1 g;

        public a(cp1 cp1Var, u03 u03Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cp1Var, u03Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = cp1Var;
            this.a = u03Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (s53.h(x53Var)) {
                    if (cp1.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    cp1.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.M().e(this.b)) {
                    n73.S("check_fail", 1, RetrieveTaskManager.KEY);
                }
                int b = x53Var.b();
                String f = s53.f(b);
                cp1 cp1Var = this.g;
                cp1Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new us1(b, s53.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements nf3<x53<d63.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ u03 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, u03 u03Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, u03Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = z2;
            this.c = jSONObject;
            this.d = dVar;
            this.e = callbackHandler;
            this.f = str;
            this.g = u03Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<d63.d> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                ux1.k("LoginApi", "#handleLogin errCode=" + x53Var.b() + " error=" + x53Var.a());
                if (!x53Var.c()) {
                    if (!this.a && this.b) {
                        n73.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 1, this.c.optString("invokeFrom"));
                        ux1.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = x53Var.b();
                    ux1.o("LoginApi", b + " " + this.d.toString());
                    String f = s53.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    ck2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    cp1.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    ux1.k("LoginApi", str);
                    n73.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                if (!this.a && this.b) {
                    n73.S("success", 1, this.c.optString("invokeFrom"));
                    ux1.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (cp1.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    ux1.k("LoginApi", "Success: login success from component-invoking.");
                    n73.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                n73.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(x53Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    ck2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    cp1.J(this.g, 43, 1001, "empty code");
                    n73.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    cp1.E(optString, this.g, this.e, this.f, x53Var, this.h);
                } else {
                    cp1.F(this.g, this.e, this.f, x53Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements nf3<g63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ u03 e;
        public final /* synthetic */ x53 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, u03 u03Var, x53 x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, u03Var, x53Var};
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
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = u03Var;
            this.f = x53Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g63Var) == null) {
                if (g63Var != null && g63Var.D()) {
                    cp1.F(this.e, this.a, this.b, this.f, this.d);
                    return;
                }
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                ux1.k("LoginApi", str);
                n73.U(this.d, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;
        public final long b;

        public d(@NonNull JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject.has("timeout");
            long optLong = jSONObject.optLong("timeout", 0L);
            this.b = optLong;
            if (optLong < 0) {
                ux1.o("LoginApi", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "LoginTimeoutConfig{enableTimeout=" + this.a + ", timeoutMills=" + this.b + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755789619, "Lcom/repackage/cp1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755789619, "Lcom/repackage/cp1;");
                return;
            }
        }
        f = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp1(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(u03 u03Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{u03Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = u03Var.M().e(activity);
            if (!e) {
                n73.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            u03Var.d0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, u03Var, str2), str2);
        }
    }

    public static void E(String str, u03 u03Var, CallbackHandler callbackHandler, String str2, x53<d63.d> x53Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, u03Var, callbackHandler, str2, x53Var, str3}) == null) {
            SwanAppActivity x = u03Var.x();
            if (x == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                ux1.k("LoginApi", "Error: activity is null from plugin-invoking.");
                n73.U(str3, com.baidu.pass.biometrics.face.liveness.b.a.g0, "swan activity is null");
                return;
            }
            String f2 = sw2.f(str);
            g63.B(x, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, u03Var, x53Var));
        }
    }

    public static void F(u03 u03Var, CallbackHandler callbackHandler, String str, x53<d63.d> x53Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, u03Var, callbackHandler, str, x53Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", x53Var.a.a);
                ux1.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                az2.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, x53Var.b()).toString());
                n73.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                ck2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(u03Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                ux1.k("LoginApi", str3);
                n73.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, str3);
            }
        }
    }

    public static boolean G(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) ? NativeConstants.COMPONENT.equals(jSONObject.optString("invokeFrom")) : invokeL.booleanValue;
    }

    public static void J(u03 u03Var, int i, int i2, String str) {
        int l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{u03Var, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) && u03Var != null && (l = u03Var.l()) == 0) {
            nc3 nc3Var = new nc3();
            nc3Var.k(5L);
            nc3Var.i(i);
            v73 v73Var = new v73();
            v73Var.p(nc3Var);
            v73Var.r(u03Var.X());
            v73Var.q(n73.n(l));
            v73Var.m(u03.f0());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i2);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
            }
            v73Var.e(jSONObject);
            n73.R(v73Var);
        }
    }

    public us1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            n73.T("getLoginCode", "create");
            CallbackHandler i = a().i();
            u03 a0 = u03.a0();
            if (a0 == null) {
                ck2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new us1(1001, "swan app is null");
            } else if (!a0.M().e(getContext())) {
                n73.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                return new us1(10004, "user not logged in");
            } else {
                JSONObject r = xo1.r(str);
                if (r == null) {
                    ck2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(a0, 1, 201, "empty joParams");
                    n73.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new us1(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    ck2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(a0, 1, 201, "cb is empty");
                    n73.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new us1(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = a0.x()) == null) {
                    n73.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new us1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!t03.J().r().M().e(context)) {
                    n73.T("getLoginCode", "passLogin");
                }
                D(a0, activity, r, i, optString, false, "getLoginCode");
                return us1.f();
            }
        }
        return (us1) invokeL.objValue;
    }

    public us1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            u03 a0 = u03.a0();
            if (a0 == null) {
                ux1.c("LoginApi", "swan app is null");
                return new us1(202, "swan app is null");
            }
            JSONObject d2 = iu2.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", a0.M().e(getContext()));
                    iu2.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    ux1.c("LoginApi", "json put data fail");
                    return new us1(1001);
                }
            }
            return new us1(0, d2);
        }
        return (us1) invokeV.objValue;
    }

    public us1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            u03 a0 = u03.a0();
            CallbackHandler i = a().i();
            if (a0 == null) {
                ck2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                ux1.k("LoginApi", "Error: swan app is null");
                return new us1(1001, "swan app is null");
            }
            JSONObject r = xo1.r(str);
            if (r == null) {
                ck2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(a0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new us1(201, "empty joParams");
            }
            String str2 = r.optString("invokeFrom").equals(NativeConstants.COMPONENT) ? "loginButton" : "loginApi";
            n73.T(str2, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                ck2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(a0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new us1(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !a0.M().e(getContext())) {
                i.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                ck2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(a0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new us1(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = a0.x()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new us1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!t03.J().r().M().e(context)) {
                    n73.T(str2, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(a0, activity, r, i, optString, true, str2);
                    return new us1(0);
                }
                if (!s53.i(r)) {
                    D(a0, activity, r, i, optString, true, str2);
                } else {
                    t03.J().r().d0().g(getContext(), "scope_login_api", new a(this, a0, activity, r, i, optString, str2));
                }
                return us1.f();
            }
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }
}
