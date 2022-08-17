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
import com.repackage.bp1;
import com.repackage.cp1;
import com.repackage.e63;
import com.repackage.wl2;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yq1 extends wq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends bp1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ yq1 e;

        /* renamed from: com.repackage.yq1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0636a implements sf3<c63<JSONObject>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ bp1.b a;

            public C0636a(a aVar, bp1.b bVar) {
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
            @Override // com.repackage.sf3
            /* renamed from: b */
            public void a(c63<JSONObject> c63Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c63Var) == null) {
                    if (c63Var.c() && c63Var.a != null) {
                        this.a.a(new zs1(0, c63Var.a));
                        z03 q = y03.K().q();
                        q.e0().B(h.a(q), c63Var.a.toString());
                        zx1.i("SettingApi", "getSwanId success");
                        return;
                    }
                    this.a.a(new zs1(10001, "getSwanId failed: internal_error"));
                    zx1.c("SettingApi", "getSwanId failed: internal_error");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(yq1 yq1Var, String str, JSONObject jSONObject) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq1Var, str, jSONObject};
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
            this.e = yq1Var;
            this.d = jSONObject;
        }

        @Override // com.repackage.bp1
        @NonNull
        public zs1 d(@NonNull JSONObject jSONObject, @NonNull bp1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                if (xu2.e() && this.e.C(this.d)) {
                    bVar.a(new zs1(0, this.d));
                    return new zs1(0);
                }
                zx1.i("SettingApi", "getSwanId start");
                if (SwanAppNetworkUtils.i(this.e.getContext())) {
                    h63 e = y03.K().x().a().b().e(this.e.getContext());
                    e.o(new C0636a(this, bVar));
                    e.call();
                    return new zs1(0);
                }
                zx1.c("SettingApi", "network_error");
                return new zs1(10002, "network_error");
            }
            return (zs1) invokeLL.objValue;
        }

        @Override // com.repackage.bp1
        @NonNull
        public zs1 e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? new zs1(0, this.d) : (zs1) invokeL.objValue;
        }

        @Override // com.repackage.bp1
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (xu2.e()) {
                    return this.e.C(this.d);
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements cp1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yq1 a;

        public b(yq1 yq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yq1Var;
        }

        @Override // com.repackage.cp1.a
        public zs1 a(z03 z03Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, z03Var, jSONObject, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                yq1.L(this.a.a().f(), str);
                return zs1.f();
            }
            return (zs1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements sf3<Map<String, z53>> {
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
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(Map<String, z53> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
                if (map == null) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, z53> entry : map.entrySet()) {
                        String d = z53.d(entry.getKey());
                        z53 value = entry.getValue();
                        if (!TextUtils.isEmpty(d) && value != null && value.b() && !value.d && TextUtils.equals("2", value.e)) {
                            if (oe3.f("3.320.0")) {
                                jSONObject.put(d, value.a() ? "1" : "0");
                            } else {
                                jSONObject.put(d, value.a());
                            }
                        }
                    }
                    if (oe3.f("3.320.0")) {
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
    public class d implements sf3<l63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ yq1 c;

        public d(yq1 yq1Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq1Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yq1Var;
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(l63 l63Var) {
            zs1 zs1Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l63Var) == null) {
                zx1.b("OpenData", "onOpenDataCallback:: ", l63Var);
                if (l63Var.E()) {
                    zs1Var = new zs1(0, l63Var.g);
                    s73.T(this.a, "success");
                } else {
                    int a = (int) l63Var.j.a();
                    String f = x53.f(a);
                    zs1 zs1Var2 = new zs1(a, f);
                    hk2.j().c(this.c.a().f(), zs1Var2.a());
                    s73.U(this.a, com.baidu.pass.biometrics.face.liveness.b.a.g0, f);
                    zs1Var = zs1Var2;
                }
                this.c.d(this.b, zs1Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements sf3<c63<e63.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ yq1 e;

        public e(yq1 yq1Var, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq1Var, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yq1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(c63<e63.e> c63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c63Var) == null) {
                if (x53.h(c63Var)) {
                    this.e.E(this.a, this.b, this.c, this.d);
                    return;
                }
                zx1.k("SettingApi", "onCallback: no permission scope_userinfo_api");
                this.e.d(this.b, new zs1(402));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements lh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ yq1 f;

        public f(yq1 yq1Var, String str, String str2, String str3, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq1Var, str, str2, str3, activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = yq1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = activity;
            this.e = str4;
        }

        @Override // com.repackage.lh1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    s73.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.a);
                    s73.U(this.b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "login failed");
                    this.f.d(this.c, new zs1(10004, "user not logged in"));
                    return;
                }
                s73.S("success", 3, this.a);
                this.f.K(false, this.c, this.d, this.e, "snsapi_userinfo", this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements lh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ String f;
        public final /* synthetic */ yq1 g;

        public g(yq1 yq1Var, String str, String str2, String str3, boolean z, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq1Var, str, str2, str3, Boolean.valueOf(z), activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = yq1Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = activity;
            this.f = str4;
        }

        @Override // com.repackage.lh1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    s73.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.a);
                    s73.U(this.b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "result code = " + i);
                    this.g.d(this.c, new zs1(10004, "user not logged in"));
                    return;
                }
                s73.S("success", 3, this.a);
                this.g.K(this.d, this.c, this.e, this.f, "snsapi_userinfo", this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(z03 z03Var) {
            InterceptResult invokeL;
            String O;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, z03Var)) == null) {
                if (z03Var == null) {
                    O = y03.K().q().O();
                } else {
                    O = z03Var.O();
                }
                return "aiapp_" + O + "getSwanId";
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yq1(@NonNull ap1 ap1Var) {
        super(ap1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ap1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ap1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static JSONObject D(z03 z03Var, Context context) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, z03Var, context)) == null) {
            wl2.a W = z03Var.W();
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
                jSONObject.put("isOpenCustomerService", te3.Q());
            }
            String i = gk2.h0().i(context);
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
                    jSONObject.put("rootSource", ah4.a(new JSONObject(string5), "pre_source", T));
                }
                SwanAppActivity activity = mm2.U().getActivity();
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
            xs2.h(new c(callbackHandler, str));
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
            z03 q = y03.K().q();
            SwanAppActivity w = q.w();
            mh1 N = q.N();
            if (N.e(w)) {
                K(false, str2, w, str, "snsapi_userinfo", str4);
                return;
            }
            s73.T(str4, "getUserInfoLogin");
            N.f(w, null, new f(this, str3, str4, str2, w, str));
        }
    }

    public zs1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#getAppInfoSync", false);
            z03 b0 = z03.b0();
            if (b0 == null) {
                zx1.b("SettingApi", "illegal swanApp");
                return new zs1(1001, "illegal swanApp");
            }
            JSONObject d2 = nu2.c().d("getAppInfoSync");
            if (d2 == null) {
                try {
                    d2 = D(b0, getContext());
                    nu2.c().h("getAppInfoSync", d2);
                } catch (JSONException e2) {
                    zx1.c("SettingApi", Log.getStackTraceString(e2));
                    return new zs1(1001);
                }
            }
            return new zs1(0, d2);
        }
        return (zs1) invokeV.objValue;
    }

    public zs1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#getSetting", false);
            return l(str, true, new b(this));
        }
        return (zs1) invokeL.objValue;
    }

    public zs1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q("#getSlaveIdSync", false);
            String containerId = a().e().getContainerId();
            if (TextUtils.isEmpty(containerId)) {
                return new zs1(1001);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("slaveId", containerId);
                return new zs1(0, jSONObject);
            } catch (JSONException unused) {
                return new zs1(1001);
            }
        }
        return (zs1) invokeV.objValue;
    }

    public zs1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#getSwanId", false);
            z03 q = y03.K().q();
            return m(str, new a(this, "getSwanId", zd3.d(q.e0().q(h.a(q), null))));
        }
        return (zs1) invokeL.objValue;
    }

    public zs1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#getUserInfo", false);
            ki1 j = hk2.j();
            z03 q = y03.K().q();
            CallbackHandler f2 = a().f();
            if (q == null) {
                j.c(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return new zs1(1001, "empty swanApp");
            } else if (TextUtils.isEmpty(q.O())) {
                j.c(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
                return new zs1(1001, "empty clientId");
            } else {
                JSONObject r = cp1.r(str);
                if (r == null) {
                    j.c(f2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    return new zs1(201, "empty joParams");
                }
                String f3 = xw2.f(r.optString("__plugin__", null));
                boolean z = !TextUtils.isEmpty(f3);
                boolean j2 = x53.j(r);
                String str2 = (j2 || z) ? "getUserInfoButton" : "getUserInfoApi";
                s73.T(str2, "create");
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    j.c(f2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    s73.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                    return new zs1(201, "empty cb");
                }
                SwanAppActivity w = q.w();
                if (w == null) {
                    j.c(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                    s73.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, "the context is not an activity");
                    return new zs1(1001, "the context is not an activity");
                }
                String optString2 = r.optString("invokeFrom");
                if (!q.N().e(w)) {
                    s73.S("show", 3, optString2);
                }
                if (!j2 && !z) {
                    M(f3, optString, optString2, str2);
                } else {
                    N(f3, j2, optString, optString2, str2);
                }
                return new zs1(0);
            }
        }
        return (zs1) invokeL.objValue;
    }

    public final void K(boolean z, String str, Activity activity, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), str, activity, str2, str3, str4}) == null) {
            s73.T(str4, "requestOpenData");
            s73.T(str4, "checkScope");
            l63.B(activity, str3, str2, z, str4, new d(this, str4, str));
        }
    }

    public final void M(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, str4) == null) {
            s73.T(str4, "checkScope");
            y03.K().q().e0().g(getContext(), "scope_userinfo_api", new e(this, str, str2, str3, str4));
        }
    }

    public final void N(String str, boolean z, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
            z03 q = y03.K().q();
            SwanAppActivity w = q.w();
            mh1 N = q.N();
            if (N.e(w)) {
                K(z, str2, w, str, "snsapi_userinfo", str4);
                return;
            }
            s73.T(str4, "getUserInfoLogin");
            N.f(w, null, new g(this, str3, str4, str2, z, w, str));
        }
    }

    @Override // com.repackage.cp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "SettingApi" : (String) invokeV.objValue;
    }
}
