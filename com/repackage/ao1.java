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
import com.repackage.b53;
import com.repackage.x43;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ao1 extends xn1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements le3<v43<x43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz2 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ao1 g;

        public a(ao1 ao1Var, sz2 sz2Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ao1Var, sz2Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ao1Var;
            this.a = sz2Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.le3
        /* renamed from: b */
        public void a(v43<x43.e> v43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v43Var) == null) {
                if (q43.h(v43Var)) {
                    if (ao1.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    ao1.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    l63.S("check_fail", 1, RetrieveTaskManager.KEY);
                }
                int b = v43Var.b();
                String f = q43.f(b);
                ao1 ao1Var = this.g;
                ao1Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new sr1(b, q43.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements le3<v43<b53.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ sz2 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, sz2 sz2Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, sz2Var, str2};
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
            this.g = sz2Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.le3
        /* renamed from: b */
        public void a(v43<b53.d> v43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v43Var) == null) {
                sw1.k("LoginApi", "#handleLogin errCode=" + v43Var.b() + " error=" + v43Var.a());
                if (!v43Var.c()) {
                    if (!this.a && this.b) {
                        l63.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 1, this.c.optString("invokeFrom"));
                        sw1.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = v43Var.b();
                    sw1.o("LoginApi", b + " " + this.d.toString());
                    String f = q43.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    aj2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    ao1.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    sw1.k("LoginApi", str);
                    l63.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                if (!this.a && this.b) {
                    l63.S("success", 1, this.c.optString("invokeFrom"));
                    sw1.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (ao1.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    sw1.k("LoginApi", "Success: login success from component-invoking.");
                    l63.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                l63.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(v43Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    aj2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    ao1.J(this.g, 43, 1001, "empty code");
                    l63.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    ao1.E(optString, this.g, this.e, this.f, v43Var, this.h);
                } else {
                    ao1.F(this.g, this.e, this.f, v43Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements le3<e53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ sz2 e;
        public final /* synthetic */ v43 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, sz2 sz2Var, v43 v43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, sz2Var, v43Var};
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
            this.e = sz2Var;
            this.f = v43Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.le3
        /* renamed from: b */
        public void a(e53 e53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e53Var) == null) {
                if (e53Var != null && e53Var.D()) {
                    ao1.F(this.e, this.a, this.b, this.f, this.d);
                    return;
                }
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                sw1.k("LoginApi", str);
                l63.U(this.d, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
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
                sw1.o("LoginApi", "timeout is a minus：" + toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755850162, "Lcom/repackage/ao1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755850162, "Lcom/repackage/ao1;");
                return;
            }
        }
        f = cg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao1(@NonNull tn1 tn1Var) {
        super(tn1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tn1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((tn1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(sz2 sz2Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{sz2Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = sz2Var.N().e(activity);
            if (!e) {
                l63.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            sz2Var.e0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, sz2Var, str2), str2);
        }
    }

    public static void E(String str, sz2 sz2Var, CallbackHandler callbackHandler, String str2, v43<b53.d> v43Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, sz2Var, callbackHandler, str2, v43Var, str3}) == null) {
            SwanAppActivity x = sz2Var.x();
            if (x == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                sw1.k("LoginApi", "Error: activity is null from plugin-invoking.");
                l63.U(str3, com.baidu.pass.biometrics.face.liveness.b.a.g0, "swan activity is null");
                return;
            }
            String f2 = qv2.f(str);
            e53.B(x, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, sz2Var, v43Var));
        }
    }

    public static void F(sz2 sz2Var, CallbackHandler callbackHandler, String str, v43<b53.d> v43Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, sz2Var, callbackHandler, str, v43Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", v43Var.a.a);
                sw1.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                yx2.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, v43Var.b()).toString());
                l63.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                aj2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(sz2Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                sw1.k("LoginApi", str3);
                l63.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, str3);
            }
        }
    }

    public static boolean G(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) ? NativeConstants.COMPONENT.equals(jSONObject.optString("invokeFrom")) : invokeL.booleanValue;
    }

    public static void J(sz2 sz2Var, int i, int i2, String str) {
        int l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{sz2Var, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) && sz2Var != null && (l = sz2Var.l()) == 0) {
            lb3 lb3Var = new lb3();
            lb3Var.k(5L);
            lb3Var.i(i);
            t63 t63Var = new t63();
            t63Var.p(lb3Var);
            t63Var.r(sz2Var.Y());
            t63Var.q(l63.n(l));
            t63Var.m(sz2.g0());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i2);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
            }
            t63Var.e(jSONObject);
            l63.R(t63Var);
        }
    }

    public sr1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            l63.T("getLoginCode", "create");
            CallbackHandler i = a().i();
            sz2 b0 = sz2.b0();
            if (b0 == null) {
                aj2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new sr1(1001, "swan app is null");
            } else if (!b0.N().e(getContext())) {
                l63.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                return new sr1(10004, "user not logged in");
            } else {
                JSONObject r = vn1.r(str);
                if (r == null) {
                    aj2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(b0, 1, 201, "empty joParams");
                    l63.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new sr1(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    aj2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(b0, 1, 201, "cb is empty");
                    l63.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new sr1(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.x()) == null) {
                    l63.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new sr1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!rz2.K().r().N().e(context)) {
                    l63.T("getLoginCode", "passLogin");
                }
                D(b0, activity, r, i, optString, false, "getLoginCode");
                return sr1.f();
            }
        }
        return (sr1) invokeL.objValue;
    }

    public sr1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            sz2 b0 = sz2.b0();
            if (b0 == null) {
                sw1.c("LoginApi", "swan app is null");
                return new sr1(202, "swan app is null");
            }
            JSONObject d2 = gt2.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", b0.N().e(getContext()));
                    gt2.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    sw1.c("LoginApi", "json put data fail");
                    return new sr1(1001);
                }
            }
            return new sr1(0, d2);
        }
        return (sr1) invokeV.objValue;
    }

    public sr1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            sz2 b0 = sz2.b0();
            CallbackHandler i = a().i();
            if (b0 == null) {
                aj2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                sw1.k("LoginApi", "Error: swan app is null");
                return new sr1(1001, "swan app is null");
            }
            JSONObject r = vn1.r(str);
            if (r == null) {
                aj2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(b0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new sr1(201, "empty joParams");
            }
            String str2 = r.optString("invokeFrom").equals(NativeConstants.COMPONENT) ? "loginButton" : "loginApi";
            l63.T(str2, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                aj2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(b0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new sr1(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !b0.N().e(getContext())) {
                i.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                aj2.j().f(i, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(b0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new sr1(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.x()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new sr1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!rz2.K().r().N().e(context)) {
                    l63.T(str2, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(b0, activity, r, i, optString, true, str2);
                    return new sr1(0);
                }
                if (!q43.i(r)) {
                    D(b0, activity, r, i, optString, true, str2);
                } else {
                    rz2.K().r().e0().g(getContext(), "scope_login_api", new a(this, b0, activity, r, i, optString, str2));
                }
                return sr1.f();
            }
        }
        return (sr1) invokeL.objValue;
    }

    @Override // com.repackage.vn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }
}
