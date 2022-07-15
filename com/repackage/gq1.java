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
import com.repackage.el2;
import com.repackage.jo1;
import com.repackage.ko1;
import com.repackage.m53;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gq1 extends eq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends jo1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ gq1 e;

        /* renamed from: com.repackage.gq1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0645a implements af3<k53<JSONObject>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jo1.b a;

            public C0645a(a aVar, jo1.b bVar) {
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
            @Override // com.repackage.af3
            /* renamed from: b */
            public void a(k53<JSONObject> k53Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                    if (k53Var.c() && k53Var.a != null) {
                        this.a.a(new hs1(0, k53Var.a));
                        h03 q = g03.K().q();
                        q.e0().B(h.a(q), k53Var.a.toString());
                        hx1.i("SettingApi", "getSwanId success");
                        return;
                    }
                    this.a.a(new hs1(10001, "getSwanId failed: internal_error"));
                    hx1.c("SettingApi", "getSwanId failed: internal_error");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(gq1 gq1Var, String str, JSONObject jSONObject) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq1Var, str, jSONObject};
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
            this.e = gq1Var;
            this.d = jSONObject;
        }

        @Override // com.repackage.jo1
        @NonNull
        public hs1 d(@NonNull JSONObject jSONObject, @NonNull jo1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                if (fu2.e() && this.e.C(this.d)) {
                    bVar.a(new hs1(0, this.d));
                    return new hs1(0);
                }
                hx1.i("SettingApi", "getSwanId start");
                if (SwanAppNetworkUtils.i(this.e.getContext())) {
                    p53 e = g03.K().x().a().b().e(this.e.getContext());
                    e.o(new C0645a(this, bVar));
                    e.call();
                    return new hs1(0);
                }
                hx1.c("SettingApi", "network_error");
                return new hs1(10002, "network_error");
            }
            return (hs1) invokeLL.objValue;
        }

        @Override // com.repackage.jo1
        @NonNull
        public hs1 e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? new hs1(0, this.d) : (hs1) invokeL.objValue;
        }

        @Override // com.repackage.jo1
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (fu2.e()) {
                    return this.e.C(this.d);
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ko1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gq1 a;

        public b(gq1 gq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gq1Var;
        }

        @Override // com.repackage.ko1.a
        public hs1 a(h03 h03Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, h03Var, jSONObject, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                gq1.L(this.a.a().h(), str);
                return hs1.f();
            }
            return (hs1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements af3<Map<String, h53>> {
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
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(Map<String, h53> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
                if (map == null) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, h53> entry : map.entrySet()) {
                        String d = h53.d(entry.getKey());
                        h53 value = entry.getValue();
                        if (!TextUtils.isEmpty(d) && value != null && value.b() && !value.d && TextUtils.equals("2", value.e)) {
                            if (wd3.f("3.320.0")) {
                                jSONObject.put(d, value.a() ? "1" : "0");
                            } else {
                                jSONObject.put(d, value.a());
                            }
                        }
                    }
                    if (wd3.f("3.320.0")) {
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

    /* loaded from: classes6.dex */
    public class d implements af3<t53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ gq1 c;

        public d(gq1 gq1Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq1Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gq1Var;
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(t53 t53Var) {
            hs1 hs1Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t53Var) == null) {
                hx1.b("OpenData", "onOpenDataCallback:: ", t53Var);
                if (t53Var.E()) {
                    hs1Var = new hs1(0, t53Var.g);
                    a73.T(this.a, "success");
                } else {
                    int a = (int) t53Var.j.a();
                    String f = f53.f(a);
                    hs1 hs1Var2 = new hs1(a, f);
                    pj2.j().c(this.c.a().h(), hs1Var2.a());
                    a73.U(this.a, com.baidu.pass.biometrics.face.liveness.b.a.g0, f);
                    hs1Var = hs1Var2;
                }
                this.c.d(this.b, hs1Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ gq1 e;

        public e(gq1 gq1Var, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq1Var, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = gq1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (f53.h(k53Var)) {
                    this.e.E(this.a, this.b, this.c, this.d);
                    return;
                }
                hx1.k("SettingApi", "onCallback: no permission scope_userinfo_api");
                this.e.d(this.b, new hs1(402));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements tg1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ gq1 f;

        public f(gq1 gq1Var, String str, String str2, String str3, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq1Var, str, str2, str3, activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = gq1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = activity;
            this.e = str4;
        }

        @Override // com.repackage.tg1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    a73.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.a);
                    a73.U(this.b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "login failed");
                    this.f.d(this.c, new hs1(10004, "user not logged in"));
                    return;
                }
                a73.S("success", 3, this.a);
                this.f.K(false, this.c, this.d, this.e, "snsapi_userinfo", this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements tg1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ String f;
        public final /* synthetic */ gq1 g;

        public g(gq1 gq1Var, String str, String str2, String str3, boolean z, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq1Var, str, str2, str3, Boolean.valueOf(z), activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = gq1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = activity;
            this.f = str4;
        }

        @Override // com.repackage.tg1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    a73.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.a);
                    a73.U(this.b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "result code = " + i);
                    this.g.d(this.c, new hs1(10004, "user not logged in"));
                    return;
                }
                a73.S("success", 3, this.a);
                this.g.K(this.d, this.c, this.e, this.f, "snsapi_userinfo", this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(h03 h03Var) {
            InterceptResult invokeL;
            String O;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, h03Var)) == null) {
                if (h03Var == null) {
                    O = g03.K().q().O();
                } else {
                    O = h03Var.O();
                }
                return "aiapp_" + O + "getSwanId";
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gq1(@NonNull io1 io1Var) {
        super(io1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((io1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static JSONObject D(h03 h03Var, Context context) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, h03Var, context)) == null) {
            el2.a W = h03Var.W();
            String T = W.T();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", W.H());
            jSONObject.put("appname", W.K());
            if (!TextUtils.isEmpty(W.Q())) {
                jSONObject.put("iconUrl", W.Q());
            }
            if (!TextUtils.isEmpty(W.W())) {
                jSONObject.put("appLaunchScheme", W.W());
            } else {
                jSONObject.put("appLaunchScheme", "");
            }
            PMSAppInfo f0 = W.f0();
            if (f0 != null) {
                String str = f0.description;
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("appDesc", str);
                }
                String str2 = f0.paNumber;
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("pa", str2);
                }
                jSONObject.put("isOpenCustomerService", be3.Q());
            }
            String i = oj2.h0().i(context);
            jSONObject.put("cuid", i);
            jSONObject.put("mtjCuid", i);
            jSONObject.put("clkid", W.L());
            jSONObject.put("scene", T);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, W.H());
            jSONObject.put("appKey", W.I());
            jSONObject.put("pkgType", W.getType());
            jSONObject.put("bundleId", W.H());
            Bundle P = W.P();
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
                    jSONObject.put("rootSource", ig4.a(new JSONObject(string5), "pre_source", T));
                }
                SwanAppActivity activity = ul2.U().getActivity();
                String V = activity != null ? activity.V() : "sys";
                jSONObject.put("showBy", TextUtils.isEmpty(V) ? "sys" : V);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void L(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) == null) {
            fs2.h(new c(callbackHandler, str));
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
            h03 q = g03.K().q();
            SwanAppActivity w = q.w();
            ug1 N = q.N();
            if (N.e(w)) {
                K(false, str2, w, str, "snsapi_userinfo", str4);
                return;
            }
            a73.T(str4, "getUserInfoLogin");
            N.f(w, null, new f(this, str3, str4, str2, w, str));
        }
    }

    public hs1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#getAppInfoSync", false);
            h03 b0 = h03.b0();
            if (b0 == null) {
                hx1.b("SettingApi", "illegal swanApp");
                return new hs1(1001, "illegal swanApp");
            }
            JSONObject d2 = vt2.c().d("getAppInfoSync");
            if (d2 == null) {
                try {
                    d2 = D(b0, getContext());
                    vt2.c().h("getAppInfoSync", d2);
                } catch (JSONException e2) {
                    hx1.c("SettingApi", Log.getStackTraceString(e2));
                    return new hs1(1001);
                }
            }
            return new hs1(0, d2);
        }
        return (hs1) invokeV.objValue;
    }

    public hs1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#getSetting", false);
            return l(str, true, new b(this));
        }
        return (hs1) invokeL.objValue;
    }

    public hs1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q("#getSlaveIdSync", false);
            String containerId = a().g().getContainerId();
            if (TextUtils.isEmpty(containerId)) {
                return new hs1(1001);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("slaveId", containerId);
                return new hs1(0, jSONObject);
            } catch (JSONException unused) {
                return new hs1(1001);
            }
        }
        return (hs1) invokeV.objValue;
    }

    public hs1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#getSwanId", false);
            h03 q = g03.K().q();
            return m(str, new a(this, "getSwanId", hd3.d(q.e0().q(h.a(q), null))));
        }
        return (hs1) invokeL.objValue;
    }

    public hs1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#getUserInfo", false);
            sh1 j = pj2.j();
            h03 q = g03.K().q();
            CallbackHandler h2 = a().h();
            if (q == null) {
                j.c(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return new hs1(1001, "empty swanApp");
            } else if (TextUtils.isEmpty(q.O())) {
                j.c(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
                return new hs1(1001, "empty clientId");
            } else {
                JSONObject r = ko1.r(str);
                if (r == null) {
                    j.c(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    return new hs1(201, "empty joParams");
                }
                String f2 = fw2.f(r.optString("__plugin__", null));
                boolean z = !TextUtils.isEmpty(f2);
                boolean j2 = f53.j(r);
                String str2 = (j2 || z) ? "getUserInfoButton" : "getUserInfoApi";
                a73.T(str2, "create");
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    j.c(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    a73.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                    return new hs1(201, "empty cb");
                }
                SwanAppActivity w = q.w();
                if (w == null) {
                    j.c(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                    a73.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, "the context is not an activity");
                    return new hs1(1001, "the context is not an activity");
                }
                String optString2 = r.optString("invokeFrom");
                if (!q.N().e(w)) {
                    a73.S("show", 3, optString2);
                }
                if (!j2 && !z) {
                    M(f2, optString, optString2, str2);
                } else {
                    N(f2, j2, optString, optString2, str2);
                }
                return new hs1(0);
            }
        }
        return (hs1) invokeL.objValue;
    }

    public final void K(boolean z, String str, Activity activity, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), str, activity, str2, str3, str4}) == null) {
            a73.T(str4, "requestOpenData");
            a73.T(str4, "checkScope");
            t53.B(activity, str3, str2, z, str4, new d(this, str4, str));
        }
    }

    public final void M(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, str4) == null) {
            a73.T(str4, "checkScope");
            g03.K().q().e0().g(getContext(), "scope_userinfo_api", new e(this, str, str2, str3, str4));
        }
    }

    public final void N(String str, boolean z, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
            h03 q = g03.K().q();
            SwanAppActivity w = q.w();
            ug1 N = q.N();
            if (N.e(w)) {
                K(z, str2, w, str, "snsapi_userinfo", str4);
                return;
            }
            a73.T(str4, "getUserInfoLogin");
            N.f(w, null, new g(this, str3, str4, str2, z, w, str));
        }
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "SettingApi" : (String) invokeV.objValue;
    }
}
