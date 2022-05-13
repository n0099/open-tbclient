package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rl2;
import com.repackage.wo1;
import com.repackage.xo1;
import com.repackage.z53;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class tq1 extends rq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends wo1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ tq1 e;

        /* renamed from: com.repackage.tq1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0526a implements nf3<x53<JSONObject>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ wo1.b a;

            public C0526a(a aVar, wo1.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.nf3
            /* renamed from: a */
            public void onCallback(x53<JSONObject> x53Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                    if (x53Var.c() && x53Var.a != null) {
                        this.a.a(new us1(0, x53Var.a));
                        u03 r = t03.J().r();
                        r.d0().B(h.a(r), x53Var.a.toString());
                        ux1.i("SettingApi", "getSwanId success");
                        return;
                    }
                    this.a.a(new us1(10001, "getSwanId failed: internal_error"));
                    ux1.c("SettingApi", "getSwanId failed: internal_error");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(tq1 tq1Var, String str, JSONObject jSONObject) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq1Var, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = tq1Var;
            this.d = jSONObject;
        }

        @Override // com.repackage.wo1
        @NonNull
        public us1 d(@NonNull JSONObject jSONObject, @NonNull wo1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                if (su2.e() && this.e.C(this.d)) {
                    bVar.a(new us1(0, this.d));
                    return new us1(0);
                }
                ux1.i("SettingApi", "getSwanId start");
                if (SwanAppNetworkUtils.i(this.e.getContext())) {
                    c63 e = t03.J().y().a().b().e(this.e.getContext());
                    e.o(new C0526a(this, bVar));
                    e.call();
                    return new us1(0);
                }
                ux1.c("SettingApi", "network_error");
                return new us1(10002, "network_error");
            }
            return (us1) invokeLL.objValue;
        }

        @Override // com.repackage.wo1
        @NonNull
        public us1 e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? new us1(0, this.d) : (us1) invokeL.objValue;
        }

        @Override // com.repackage.wo1
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (su2.e()) {
                    return this.e.C(this.d);
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements xo1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tq1 a;

        public b(tq1 tq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tq1Var;
        }

        @Override // com.repackage.xo1.a
        public us1 a(u03 u03Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, u03Var, jSONObject, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                tq1.L(this.a.a().i(), str);
                return us1.f();
            }
            return (us1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements nf3<Map<String, u53>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public c(CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(Map<String, u53> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
                if (map == null) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, u53> entry : map.entrySet()) {
                        String d = u53.d(entry.getKey());
                        u53 value = entry.getValue();
                        if (!TextUtils.isEmpty(d) && value != null && value.b() && !value.d && TextUtils.equals("2", value.e)) {
                            if (je3.f("3.320.0")) {
                                jSONObject.put(d, value.a() ? "1" : "0");
                            } else {
                                jSONObject.put(d, value.a());
                            }
                        }
                    }
                    if (je3.f("3.320.0")) {
                        this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("authSetting", jSONObject);
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
                } catch (JSONException unused) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements nf3<g63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ tq1 c;

        public d(tq1 tq1Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq1Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tq1Var;
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(g63 g63Var) {
            us1 us1Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g63Var) == null) {
                ux1.b("OpenData", "onOpenDataCallback:: ", g63Var);
                if (g63Var.E()) {
                    us1Var = new us1(0, g63Var.g);
                    n73.T(this.a, "success");
                } else {
                    int a = (int) g63Var.j.a();
                    String f = s53.f(a);
                    us1 us1Var2 = new us1(a, f);
                    ck2.j().c(this.c.a().i(), us1Var2.a());
                    n73.U(this.a, com.baidu.pass.biometrics.face.liveness.b.a.g0, f);
                    us1Var = us1Var2;
                }
                this.c.d(this.b, us1Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ tq1 e;

        public e(tq1 tq1Var, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq1Var, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = tq1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (s53.h(x53Var)) {
                    this.e.E(this.a, this.b, this.c, this.d);
                    return;
                }
                ux1.k("SettingApi", "onCallback: no permission scope_userinfo_api");
                this.e.d(this.b, new us1(402));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements gh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ tq1 f;

        public f(tq1 tq1Var, String str, String str2, String str3, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq1Var, str, str2, str3, activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = tq1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = activity;
            this.e = str4;
        }

        @Override // com.repackage.gh1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    n73.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.a);
                    n73.U(this.b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "login failed");
                    this.f.d(this.c, new us1(10004, "user not logged in"));
                    return;
                }
                n73.S("success", 3, this.a);
                this.f.K(false, this.c, this.d, this.e, "snsapi_userinfo", this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements gh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ String f;
        public final /* synthetic */ tq1 g;

        public g(tq1 tq1Var, String str, String str2, String str3, boolean z, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tq1Var, str, str2, str3, Boolean.valueOf(z), activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = tq1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = activity;
            this.f = str4;
        }

        @Override // com.repackage.gh1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    n73.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.a);
                    n73.U(this.b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "result code = " + i);
                    this.g.d(this.c, new us1(10004, "user not logged in"));
                    return;
                }
                n73.S("success", 3, this.a);
                this.g.K(this.d, this.c, this.e, this.f, "snsapi_userinfo", this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(u03 u03Var) {
            InterceptResult invokeL;
            String N;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, u03Var)) == null) {
                if (u03Var == null) {
                    N = t03.J().r().N();
                } else {
                    N = u03Var.N();
                }
                return "aiapp_" + N + "getSwanId";
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tq1(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static JSONObject D(u03 u03Var, Context context) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, u03Var, context)) == null) {
            rl2.a V = u03Var.V();
            String T = V.T();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", V.H());
            jSONObject.put("appname", V.K());
            if (!TextUtils.isEmpty(V.Q())) {
                jSONObject.put("iconUrl", V.Q());
            }
            if (!TextUtils.isEmpty(V.W())) {
                jSONObject.put("appLaunchScheme", V.W());
            } else {
                jSONObject.put("appLaunchScheme", "");
            }
            PMSAppInfo f0 = V.f0();
            if (f0 != null) {
                String str = f0.description;
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("appDesc", str);
                }
                String str2 = f0.paNumber;
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("pa", str2);
                }
                jSONObject.put("isOpenCustomerService", oe3.Q());
            }
            String i = bk2.h0().i(context);
            jSONObject.put("cuid", i);
            jSONObject.put("mtjCuid", i);
            jSONObject.put("clkid", V.L());
            jSONObject.put("scene", T);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, V.H());
            jSONObject.put("appKey", V.I());
            jSONObject.put("pkgType", V.getType());
            jSONObject.put("bundleId", V.H());
            Bundle P = V.P();
            if (P != null) {
                String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, new JSONObject(string));
                }
                String string2 = P.getString("srcAppId");
                if (!TextUtils.isEmpty(string2)) {
                    jSONObject.put("srcAppId", string2);
                }
                String string3 = P.getString("srcAppPage");
                if (!TextUtils.isEmpty(string3)) {
                    jSONObject.put("srcAppPage", string3);
                }
                String string4 = P.getString("srcAppKey");
                if (!TextUtils.isEmpty(string4)) {
                    jSONObject.put("srcAppKey", string4);
                }
                jSONObject.put("srcPkgType", P.getInt("srcPkgType"));
                if (TextUtils.isEmpty(T)) {
                    T = "NA";
                }
                String string5 = P.getString(UBCCloudControlProcessor.UBC_KEY);
                if (!TextUtils.isEmpty(string5)) {
                    jSONObject.put("rootSource", wg4.a(new JSONObject(string5), "pre_source", T));
                }
                SwanAppActivity activity = hm2.U().getActivity();
                String showBy = activity != null ? activity.getShowBy() : "sys";
                jSONObject.put("showBy", TextUtils.isEmpty(showBy) ? "sys" : showBy);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void L(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) == null) {
            ss2.h(new c(callbackHandler, str));
        }
    }

    public final boolean C(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return false;
            }
            String optString = optJSONObject.optString("swanid");
            return (TextUtils.isEmpty(optString) || TextUtils.equals(StringUtil.NULL_STRING, optString)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public final void E(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            u03 r = t03.J().r();
            SwanAppActivity x = r.x();
            hh1 M = r.M();
            if (M.e(x)) {
                K(false, str2, x, str, "snsapi_userinfo", str4);
                return;
            }
            n73.T(str4, "getUserInfoLogin");
            M.f(x, null, new f(this, str3, str4, str2, x, str));
        }
    }

    public us1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#getAppInfoSync", false);
            u03 a0 = u03.a0();
            if (a0 == null) {
                ux1.b("SettingApi", "illegal swanApp");
                return new us1(1001, "illegal swanApp");
            }
            JSONObject d2 = iu2.c().d("getAppInfoSync");
            if (d2 == null) {
                try {
                    d2 = D(a0, getContext());
                    iu2.c().h("getAppInfoSync", d2);
                } catch (JSONException e2) {
                    ux1.c("SettingApi", Log.getStackTraceString(e2));
                    return new us1(1001);
                }
            }
            return new us1(0, d2);
        }
        return (us1) invokeV.objValue;
    }

    public us1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#getSetting", false);
            return l(str, true, new b(this));
        }
        return (us1) invokeL.objValue;
    }

    public us1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q("#getSlaveIdSync", false);
            String containerId = a().h().getContainerId();
            if (TextUtils.isEmpty(containerId)) {
                return new us1(1001);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("slaveId", containerId);
                return new us1(0, jSONObject);
            } catch (JSONException unused) {
                return new us1(1001);
            }
        }
        return (us1) invokeV.objValue;
    }

    public us1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#getSwanId", false);
            u03 r = t03.J().r();
            return m(str, new a(this, "getSwanId", ud3.d(r.d0().q(h.a(r), null))));
        }
        return (us1) invokeL.objValue;
    }

    public us1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#getUserInfo", false);
            fi1 j = ck2.j();
            u03 r = t03.J().r();
            CallbackHandler i = a().i();
            if (r == null) {
                j.c(i, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return new us1(1001, "empty swanApp");
            } else if (TextUtils.isEmpty(r.N())) {
                j.c(i, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
                return new us1(1001, "empty clientId");
            } else {
                JSONObject r2 = xo1.r(str);
                if (r2 == null) {
                    j.c(i, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    return new us1(201, "empty joParams");
                }
                String f2 = sw2.f(r2.optString("__plugin__", null));
                boolean z = !TextUtils.isEmpty(f2);
                boolean j2 = s53.j(r2);
                String str2 = (j2 || z) ? "getUserInfoButton" : "getUserInfoApi";
                n73.T(str2, "create");
                String optString = r2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    j.c(i, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    n73.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                    return new us1(201, "empty cb");
                }
                SwanAppActivity x = r.x();
                if (x == null) {
                    j.c(i, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                    n73.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, "the context is not an activity");
                    return new us1(1001, "the context is not an activity");
                }
                String optString2 = r2.optString("invokeFrom");
                if (!r.M().e(x)) {
                    n73.S("show", 3, optString2);
                }
                if (!j2 && !z) {
                    M(f2, optString, optString2, str2);
                } else {
                    N(f2, j2, optString, optString2, str2);
                }
                return new us1(0);
            }
        }
        return (us1) invokeL.objValue;
    }

    public final void K(boolean z, String str, Activity activity, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), str, activity, str2, str3, str4}) == null) {
            n73.T(str4, "requestOpenData");
            n73.T(str4, "checkScope");
            g63.B(activity, str3, str2, z, str4, new d(this, str4, str));
        }
    }

    public final void M(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, str4) == null) {
            n73.T(str4, "checkScope");
            t03.J().r().d0().g(getContext(), "scope_userinfo_api", new e(this, str, str2, str3, str4));
        }
    }

    public final void N(String str, boolean z, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
            u03 r = t03.J().r();
            SwanAppActivity x = r.x();
            hh1 M = r.M();
            if (M.e(x)) {
                K(z, str2, x, str, "snsapi_userinfo", str4);
                return;
            }
            n73.T(str4, "getUserInfoLogin");
            M.f(x, null, new g(this, str3, str4, str2, z, x, str));
        }
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "SettingApi" : (String) invokeV.objValue;
    }
}
