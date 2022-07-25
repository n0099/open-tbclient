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
import com.repackage.n53;
import com.repackage.r53;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qo1 extends no1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements bf3<l53<n53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i03 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ qo1 g;

        public a(qo1 qo1Var, i03 i03Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qo1Var, i03Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = qo1Var;
            this.a = i03Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(l53<n53.e> l53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l53Var) == null) {
                if (g53.h(l53Var)) {
                    if (qo1.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    qo1.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    b73.S("check_fail", 1, "api");
                }
                int b = l53Var.b();
                String f = g53.f(b);
                qo1 qo1Var = this.g;
                qo1Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new is1(b, g53.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements bf3<l53<r53.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ i03 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, i03 i03Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, i03Var, str2};
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
            this.g = i03Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(l53<r53.d> l53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l53Var) == null) {
                ix1.k("LoginApi", "#handleLogin errCode=" + l53Var.b() + " error=" + l53Var.a());
                if (!l53Var.c()) {
                    if (!this.a && this.b) {
                        b73.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 1, this.c.optString("invokeFrom"));
                        ix1.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = l53Var.b();
                    ix1.o("LoginApi", b + " " + this.d.toString());
                    String f = g53.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    qj2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    qo1.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    ix1.k("LoginApi", str);
                    b73.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                if (!this.a && this.b) {
                    b73.S("success", 1, this.c.optString("invokeFrom"));
                    ix1.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (qo1.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    ix1.k("LoginApi", "Success: login success from component-invoking.");
                    b73.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                b73.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(l53Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    qj2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    qo1.J(this.g, 43, 1001, "empty code");
                    b73.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    qo1.E(optString, this.g, this.e, this.f, l53Var, this.h);
                } else {
                    qo1.F(this.g, this.e, this.f, l53Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements bf3<u53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ i03 e;
        public final /* synthetic */ l53 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, i03 i03Var, l53 l53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, i03Var, l53Var};
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
            this.e = i03Var;
            this.f = l53Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(u53 u53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u53Var) == null) {
                if (u53Var != null && u53Var.D()) {
                    qo1.F(this.e, this.a, this.b, this.f, this.d);
                    return;
                }
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                ix1.k("LoginApi", str);
                b73.U(this.d, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                ix1.o("LoginApi", "timeout is a minus：" + toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755373506, "Lcom/repackage/qo1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755373506, "Lcom/repackage/qo1;");
                return;
            }
        }
        f = sg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qo1(@NonNull jo1 jo1Var) {
        super(jo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jo1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((jo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(i03 i03Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{i03Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = i03Var.N().e(activity);
            if (!e) {
                b73.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            i03Var.e0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, i03Var, str2), str2);
        }
    }

    public static void E(String str, i03 i03Var, CallbackHandler callbackHandler, String str2, l53<r53.d> l53Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, i03Var, callbackHandler, str2, l53Var, str3}) == null) {
            SwanAppActivity w = i03Var.w();
            if (w == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                ix1.k("LoginApi", "Error: activity is null from plugin-invoking.");
                b73.U(str3, com.baidu.pass.biometrics.face.liveness.b.a.g0, "swan activity is null");
                return;
            }
            String f2 = gw2.f(str);
            u53.B(w, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, i03Var, l53Var));
        }
    }

    public static void F(i03 i03Var, CallbackHandler callbackHandler, String str, l53<r53.d> l53Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, i03Var, callbackHandler, str, l53Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", l53Var.a.a);
                ix1.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                oy2.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, l53Var.b()).toString());
                b73.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                qj2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(i03Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                ix1.k("LoginApi", str3);
                b73.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, str3);
            }
        }
    }

    public static boolean G(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) ? NativeConstants.COMPONENT.equals(jSONObject.optString("invokeFrom")) : invokeL.booleanValue;
    }

    public static void J(i03 i03Var, int i, int i2, String str) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{i03Var, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) && i03Var != null && (k = i03Var.k()) == 0) {
            bc3 bc3Var = new bc3();
            bc3Var.k(5L);
            bc3Var.i(i);
            j73 j73Var = new j73();
            j73Var.p(bc3Var);
            j73Var.r(i03Var.Y());
            j73Var.q(b73.n(k));
            j73Var.m(i03.g0());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i2);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
            }
            j73Var.e(jSONObject);
            b73.R(j73Var);
        }
    }

    public is1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            b73.T("getLoginCode", "create");
            CallbackHandler h = a().h();
            i03 b0 = i03.b0();
            if (b0 == null) {
                qj2.j().f(h, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new is1(1001, "swan app is null");
            } else if (!b0.N().e(getContext())) {
                b73.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                return new is1(10004, "user not logged in");
            } else {
                JSONObject r = lo1.r(str);
                if (r == null) {
                    qj2.j().f(h, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(b0, 1, 201, "empty joParams");
                    b73.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new is1(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    qj2.j().f(h, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(b0, 1, 201, "cb is empty");
                    b73.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new is1(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    b73.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new is1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!h03.K().q().N().e(context)) {
                    b73.T("getLoginCode", "passLogin");
                }
                D(b0, activity, r, h, optString, false, "getLoginCode");
                return is1.f();
            }
        }
        return (is1) invokeL.objValue;
    }

    public is1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            i03 b0 = i03.b0();
            if (b0 == null) {
                ix1.c("LoginApi", "swan app is null");
                return new is1(202, "swan app is null");
            }
            JSONObject d2 = wt2.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", b0.N().e(getContext()));
                    wt2.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    ix1.c("LoginApi", "json put data fail");
                    return new is1(1001);
                }
            }
            return new is1(0, d2);
        }
        return (is1) invokeV.objValue;
    }

    public is1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            i03 b0 = i03.b0();
            CallbackHandler h = a().h();
            if (b0 == null) {
                qj2.j().f(h, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                ix1.k("LoginApi", "Error: swan app is null");
                return new is1(1001, "swan app is null");
            }
            JSONObject r = lo1.r(str);
            if (r == null) {
                qj2.j().f(h, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(b0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new is1(201, "empty joParams");
            }
            String str2 = r.optString("invokeFrom").equals(NativeConstants.COMPONENT) ? "loginButton" : "loginApi";
            b73.T(str2, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                qj2.j().f(h, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(b0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new is1(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !b0.N().e(getContext())) {
                h.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                qj2.j().f(h, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(b0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new is1(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new is1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!h03.K().q().N().e(context)) {
                    b73.T(str2, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(b0, activity, r, h, optString, true, str2);
                    return new is1(0);
                }
                if (!g53.i(r)) {
                    D(b0, activity, r, h, optString, true, str2);
                } else {
                    h03.K().q().e0().g(getContext(), "scope_login_api", new a(this, b0, activity, r, h, optString, str2));
                }
                return is1.f();
            }
        }
        return (is1) invokeL.objValue;
    }

    @Override // com.repackage.lo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }
}
