package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.repackage.m53;
import com.repackage.q53;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class po1 extends mo1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h03 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ po1 g;

        public a(po1 po1Var, h03 h03Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po1Var, h03Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = po1Var;
            this.a = h03Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (f53.h(k53Var)) {
                    if (po1.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    po1.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    a73.S("check_fail", 1, "api");
                }
                int b = k53Var.b();
                String f = f53.f(b);
                po1 po1Var = this.g;
                po1Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new hs1(b, f53.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements af3<k53<q53.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ h03 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, h03 h03Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, h03Var, str2};
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
            this.g = h03Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<q53.d> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                hx1.k("LoginApi", "#handleLogin errCode=" + k53Var.b() + " error=" + k53Var.a());
                if (!k53Var.c()) {
                    if (!this.a && this.b) {
                        a73.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 1, this.c.optString("invokeFrom"));
                        hx1.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = k53Var.b();
                    hx1.o("LoginApi", b + " " + this.d.toString());
                    String f = f53.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    pj2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    po1.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    hx1.k("LoginApi", str);
                    a73.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                if (!this.a && this.b) {
                    a73.S("success", 1, this.c.optString("invokeFrom"));
                    hx1.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (po1.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    hx1.k("LoginApi", "Success: login success from component-invoking.");
                    a73.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                a73.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(k53Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    pj2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    po1.J(this.g, 43, 1001, "empty code");
                    a73.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    po1.E(optString, this.g, this.e, this.f, k53Var, this.h);
                } else {
                    po1.F(this.g, this.e, this.f, k53Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements af3<t53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ h03 e;
        public final /* synthetic */ k53 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, h03 h03Var, k53 k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, h03Var, k53Var};
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
            this.e = h03Var;
            this.f = k53Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(t53 t53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t53Var) == null) {
                if (t53Var != null && t53Var.D()) {
                    po1.F(this.e, this.a, this.b, this.f, this.d);
                    return;
                }
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                hx1.k("LoginApi", str);
                a73.U(this.d, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
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
                hx1.o("LoginApi", "timeout is a minus：" + toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755403297, "Lcom/repackage/po1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755403297, "Lcom/repackage/po1;");
                return;
            }
        }
        f = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public po1(@NonNull io1 io1Var) {
        super(io1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((io1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(h03 h03Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{h03Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = h03Var.N().e(activity);
            if (!e) {
                a73.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            h03Var.e0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, h03Var, str2), str2);
        }
    }

    public static void E(String str, h03 h03Var, CallbackHandler callbackHandler, String str2, k53<q53.d> k53Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, h03Var, callbackHandler, str2, k53Var, str3}) == null) {
            SwanAppActivity w = h03Var.w();
            if (w == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                hx1.k("LoginApi", "Error: activity is null from plugin-invoking.");
                a73.U(str3, com.baidu.pass.biometrics.face.liveness.b.a.g0, "swan activity is null");
                return;
            }
            String f2 = fw2.f(str);
            t53.B(w, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, h03Var, k53Var));
        }
    }

    public static void F(h03 h03Var, CallbackHandler callbackHandler, String str, k53<q53.d> k53Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, h03Var, callbackHandler, str, k53Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", k53Var.a.a);
                hx1.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                ny2.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, k53Var.b()).toString());
                a73.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                pj2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(h03Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                hx1.k("LoginApi", str3);
                a73.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, str3);
            }
        }
    }

    public static boolean G(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) ? NativeConstants.COMPONENT.equals(jSONObject.optString("invokeFrom")) : invokeL.booleanValue;
    }

    public static void J(h03 h03Var, int i, int i2, String str) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{h03Var, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) && h03Var != null && (k = h03Var.k()) == 0) {
            ac3 ac3Var = new ac3();
            ac3Var.k(5L);
            ac3Var.i(i);
            i73 i73Var = new i73();
            i73Var.p(ac3Var);
            i73Var.r(h03Var.Y());
            i73Var.q(a73.n(k));
            i73Var.m(h03.g0());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i2);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
            }
            i73Var.e(jSONObject);
            a73.R(i73Var);
        }
    }

    public hs1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            a73.T("getLoginCode", "create");
            CallbackHandler h = a().h();
            h03 b0 = h03.b0();
            if (b0 == null) {
                pj2.j().f(h, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new hs1(1001, "swan app is null");
            } else if (!b0.N().e(getContext())) {
                a73.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                return new hs1(10004, "user not logged in");
            } else {
                JSONObject r = ko1.r(str);
                if (r == null) {
                    pj2.j().f(h, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(b0, 1, 201, "empty joParams");
                    a73.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new hs1(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    pj2.j().f(h, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(b0, 1, 201, "cb is empty");
                    a73.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new hs1(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    a73.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new hs1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!g03.K().q().N().e(context)) {
                    a73.T("getLoginCode", "passLogin");
                }
                D(b0, activity, r, h, optString, false, "getLoginCode");
                return hs1.f();
            }
        }
        return (hs1) invokeL.objValue;
    }

    public hs1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            h03 b0 = h03.b0();
            if (b0 == null) {
                hx1.c("LoginApi", "swan app is null");
                return new hs1(202, "swan app is null");
            }
            JSONObject d2 = vt2.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", b0.N().e(getContext()));
                    vt2.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    hx1.c("LoginApi", "json put data fail");
                    return new hs1(1001);
                }
            }
            return new hs1(0, d2);
        }
        return (hs1) invokeV.objValue;
    }

    public hs1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            h03 b0 = h03.b0();
            CallbackHandler h = a().h();
            if (b0 == null) {
                pj2.j().f(h, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                hx1.k("LoginApi", "Error: swan app is null");
                return new hs1(1001, "swan app is null");
            }
            JSONObject r = ko1.r(str);
            if (r == null) {
                pj2.j().f(h, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(b0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new hs1(201, "empty joParams");
            }
            String str2 = r.optString("invokeFrom").equals(NativeConstants.COMPONENT) ? "loginButton" : "loginApi";
            a73.T(str2, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                pj2.j().f(h, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(b0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new hs1(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !b0.N().e(getContext())) {
                h.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                pj2.j().f(h, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(b0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new hs1(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new hs1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!g03.K().q().N().e(context)) {
                    a73.T(str2, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(b0, activity, r, h, optString, true, str2);
                    return new hs1(0);
                }
                if (!f53.i(r)) {
                    D(b0, activity, r, h, optString, true, str2);
                } else {
                    g03.K().q().e0().g(getContext(), "scope_login_api", new a(this, b0, activity, r, h, optString, str2));
                }
                return hs1.f();
            }
        }
        return (hs1) invokeL.objValue;
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }
}
