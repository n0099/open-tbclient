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
import com.repackage.m43;
import com.repackage.q43;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class pn1 extends mn1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz2 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ pn1 g;

        public a(pn1 pn1Var, hz2 hz2Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pn1Var, hz2Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = pn1Var;
            this.a = hz2Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (f43.h(k43Var)) {
                    if (pn1.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    pn1.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.M().e(this.b)) {
                    a63.S("check_fail", 1, RetrieveTaskManager.KEY);
                }
                int b = k43Var.b();
                String f = f43.f(b);
                pn1 pn1Var = this.g;
                pn1Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new hr1(b, f43.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements ae3<k43<q43.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ hz2 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, hz2 hz2Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, hz2Var, str2};
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
            this.g = hz2Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<q43.d> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                hw1.k("LoginApi", "#handleLogin errCode=" + k43Var.b() + " error=" + k43Var.a());
                if (!k43Var.c()) {
                    if (!this.a && this.b) {
                        a63.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 1, this.c.optString("invokeFrom"));
                        hw1.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = k43Var.b();
                    hw1.o("LoginApi", b + " " + this.d.toString());
                    String f = f43.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    pi2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    pn1.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    hw1.k("LoginApi", str);
                    a63.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                if (!this.a && this.b) {
                    a63.S("success", 1, this.c.optString("invokeFrom"));
                    hw1.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (pn1.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    hw1.k("LoginApi", "Success: login success from component-invoking.");
                    a63.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                a63.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(k43Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    pi2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    pn1.J(this.g, 43, 1001, "empty code");
                    a63.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    pn1.E(optString, this.g, this.e, this.f, k43Var, this.h);
                } else {
                    pn1.F(this.g, this.e, this.f, k43Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements ae3<t43> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ hz2 e;
        public final /* synthetic */ k43 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, hz2 hz2Var, k43 k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, hz2Var, k43Var};
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
            this.e = hz2Var;
            this.f = k43Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(t43 t43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t43Var) == null) {
                if (t43Var != null && t43Var.D()) {
                    pn1.F(this.e, this.a, this.b, this.f, this.d);
                    return;
                }
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                hw1.k("LoginApi", str);
                a63.U(this.d, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                hw1.o("LoginApi", "timeout is a minus：" + toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755404258, "Lcom/repackage/pn1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755404258, "Lcom/repackage/pn1;");
                return;
            }
        }
        f = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pn1(@NonNull in1 in1Var) {
        super(in1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {in1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((in1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(hz2 hz2Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{hz2Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = hz2Var.M().e(activity);
            if (!e) {
                a63.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            hz2Var.d0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, hz2Var, str2), str2);
        }
    }

    public static void E(String str, hz2 hz2Var, CallbackHandler callbackHandler, String str2, k43<q43.d> k43Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, hz2Var, callbackHandler, str2, k43Var, str3}) == null) {
            SwanAppActivity x = hz2Var.x();
            if (x == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                hw1.k("LoginApi", "Error: activity is null from plugin-invoking.");
                a63.U(str3, com.baidu.pass.biometrics.face.liveness.b.a.g0, "swan activity is null");
                return;
            }
            String f2 = fv2.f(str);
            t43.B(x, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, hz2Var, k43Var));
        }
    }

    public static void F(hz2 hz2Var, CallbackHandler callbackHandler, String str, k43<q43.d> k43Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, hz2Var, callbackHandler, str, k43Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", k43Var.a.a);
                hw1.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                nx2.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, k43Var.b()).toString());
                a63.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                pi2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(hz2Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                hw1.k("LoginApi", str3);
                a63.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, str3);
            }
        }
    }

    public static boolean G(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) ? NativeConstants.COMPONENT.equals(jSONObject.optString("invokeFrom")) : invokeL.booleanValue;
    }

    public static void J(hz2 hz2Var, int i, int i2, String str) {
        int l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{hz2Var, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) && hz2Var != null && (l = hz2Var.l()) == 0) {
            ab3 ab3Var = new ab3();
            ab3Var.k(5L);
            ab3Var.i(i);
            i63 i63Var = new i63();
            i63Var.p(ab3Var);
            i63Var.r(hz2Var.X());
            i63Var.q(a63.n(l));
            i63Var.m(hz2.f0());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i2);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
            }
            i63Var.e(jSONObject);
            a63.R(i63Var);
        }
    }

    public hr1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            a63.T("getLoginCode", "create");
            CallbackHandler i = a().i();
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                pi2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new hr1(1001, "swan app is null");
            } else if (!a0.M().e(getContext())) {
                a63.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                return new hr1(10004, "user not logged in");
            } else {
                JSONObject r = kn1.r(str);
                if (r == null) {
                    pi2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(a0, 1, 201, "empty joParams");
                    a63.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new hr1(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    pi2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(a0, 1, 201, "cb is empty");
                    a63.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new hr1(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = a0.x()) == null) {
                    a63.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new hr1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!gz2.J().r().M().e(context)) {
                    a63.T("getLoginCode", "passLogin");
                }
                D(a0, activity, r, i, optString, false, "getLoginCode");
                return hr1.f();
            }
        }
        return (hr1) invokeL.objValue;
    }

    public hr1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                hw1.c("LoginApi", "swan app is null");
                return new hr1(202, "swan app is null");
            }
            JSONObject d2 = vs2.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", a0.M().e(getContext()));
                    vs2.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    hw1.c("LoginApi", "json put data fail");
                    return new hr1(1001);
                }
            }
            return new hr1(0, d2);
        }
        return (hr1) invokeV.objValue;
    }

    public hr1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            hz2 a0 = hz2.a0();
            CallbackHandler i = a().i();
            if (a0 == null) {
                pi2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                hw1.k("LoginApi", "Error: swan app is null");
                return new hr1(1001, "swan app is null");
            }
            JSONObject r = kn1.r(str);
            if (r == null) {
                pi2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(a0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new hr1(201, "empty joParams");
            }
            String str2 = r.optString("invokeFrom").equals(NativeConstants.COMPONENT) ? "loginButton" : "loginApi";
            a63.T(str2, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                pi2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(a0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new hr1(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !a0.M().e(getContext())) {
                i.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                pi2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(a0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new hr1(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = a0.x()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new hr1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!gz2.J().r().M().e(context)) {
                    a63.T(str2, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(a0, activity, r, i, optString, true, str2);
                    return new hr1(0);
                }
                if (!f43.i(r)) {
                    D(a0, activity, r, i, optString, true, str2);
                } else {
                    gz2.J().r().d0().g(getContext(), "scope_login_api", new a(this, a0, activity, r, i, optString, str2));
                }
                return hr1.f();
            }
        }
        return (hr1) invokeL.objValue;
    }

    @Override // com.repackage.kn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }
}
