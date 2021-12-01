package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.webview.jshandler.e;
import com.yy.hiidostatis.inner.BaseStatisContent;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bp implements com.kwad.sdk.core.d<e.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bp() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(e.a aVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, jSONObject) == null) || jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optString("SDKVersion");
        if (jSONObject.opt("SDKVersion") == JSONObject.NULL) {
            aVar.a = "";
        }
        aVar.f57995b = jSONObject.optInt("SDKVersionCode");
        aVar.f57996c = jSONObject.optString("sdkApiVersion");
        if (jSONObject.opt("sdkApiVersion") == JSONObject.NULL) {
            aVar.f57996c = "";
        }
        aVar.f57997d = jSONObject.optInt("sdkApiVersionCode");
        aVar.f57998e = jSONObject.optInt("sdkType");
        aVar.f57999f = jSONObject.optString("appVersion");
        if (jSONObject.opt("appVersion") == JSONObject.NULL) {
            aVar.f57999f = "";
        }
        aVar.f58000g = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            aVar.f58000g = "";
        }
        aVar.f58001h = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        if (jSONObject.opt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID) == JSONObject.NULL) {
            aVar.f58001h = "";
        }
        aVar.f58002i = jSONObject.optString("globalId");
        if (jSONObject.opt("globalId") == JSONObject.NULL) {
            aVar.f58002i = "";
        }
        aVar.f58003j = jSONObject.optString("eGid");
        if (jSONObject.opt("eGid") == JSONObject.NULL) {
            aVar.f58003j = "";
        }
        aVar.f58004k = jSONObject.optString("deviceSig");
        if (jSONObject.opt("deviceSig") == JSONObject.NULL) {
            aVar.f58004k = "";
        }
        aVar.l = jSONObject.optString("networkType");
        if (jSONObject.opt("networkType") == JSONObject.NULL) {
            aVar.l = "";
        }
        aVar.m = jSONObject.optString(HttpConstants.HTTP_MANUFACTURER);
        if (jSONObject.opt(HttpConstants.HTTP_MANUFACTURER) == JSONObject.NULL) {
            aVar.m = "";
        }
        aVar.n = jSONObject.optString("model");
        if (jSONObject.opt("model") == JSONObject.NULL) {
            aVar.n = "";
        }
        aVar.o = jSONObject.optString("deviceBrand");
        if (jSONObject.opt("deviceBrand") == JSONObject.NULL) {
            aVar.o = "";
        }
        aVar.p = jSONObject.optInt(HttpConstants.HTTP_OS_TYPE_OLD);
        aVar.q = jSONObject.optString("systemVersion");
        if (jSONObject.opt("systemVersion") == JSONObject.NULL) {
            aVar.q = "";
        }
        aVar.r = jSONObject.optInt("osApi");
        aVar.s = jSONObject.optString("language");
        if (jSONObject.opt("language") == JSONObject.NULL) {
            aVar.s = "";
        }
        aVar.t = jSONObject.optString("locale");
        if (jSONObject.opt("locale") == JSONObject.NULL) {
            aVar.t = "";
        }
        aVar.u = jSONObject.optString("uuid");
        if (jSONObject.opt("uuid") == JSONObject.NULL) {
            aVar.u = "";
        }
        aVar.v = jSONObject.optInt("screenWidth");
        aVar.w = jSONObject.optInt("screenHeight");
        aVar.x = jSONObject.optString("imei");
        if (jSONObject.opt("imei") == JSONObject.NULL) {
            aVar.x = "";
        }
        aVar.y = jSONObject.optString("oaid");
        if (jSONObject.opt("oaid") == JSONObject.NULL) {
            aVar.y = "";
        }
        aVar.z = jSONObject.optString("androidId");
        if (jSONObject.opt("androidId") == JSONObject.NULL) {
            aVar.z = "";
        }
        aVar.A = jSONObject.optString(BaseStatisContent.MAC);
        if (jSONObject.opt(BaseStatisContent.MAC) == JSONObject.NULL) {
            aVar.A = "";
        }
        aVar.B = jSONObject.optInt("statusBarHeight");
        aVar.C = jSONObject.optInt("titleBarHeight");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(e.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, aVar, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "SDKVersion", aVar.a);
            com.kwad.sdk.utils.t.a(jSONObject, "SDKVersionCode", aVar.f57995b);
            com.kwad.sdk.utils.t.a(jSONObject, "sdkApiVersion", aVar.f57996c);
            com.kwad.sdk.utils.t.a(jSONObject, "sdkApiVersionCode", aVar.f57997d);
            com.kwad.sdk.utils.t.a(jSONObject, "sdkType", aVar.f57998e);
            com.kwad.sdk.utils.t.a(jSONObject, "appVersion", aVar.f57999f);
            com.kwad.sdk.utils.t.a(jSONObject, "appName", aVar.f58000g);
            com.kwad.sdk.utils.t.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.f58001h);
            com.kwad.sdk.utils.t.a(jSONObject, "globalId", aVar.f58002i);
            com.kwad.sdk.utils.t.a(jSONObject, "eGid", aVar.f58003j);
            com.kwad.sdk.utils.t.a(jSONObject, "deviceSig", aVar.f58004k);
            com.kwad.sdk.utils.t.a(jSONObject, "networkType", aVar.l);
            com.kwad.sdk.utils.t.a(jSONObject, HttpConstants.HTTP_MANUFACTURER, aVar.m);
            com.kwad.sdk.utils.t.a(jSONObject, "model", aVar.n);
            com.kwad.sdk.utils.t.a(jSONObject, "deviceBrand", aVar.o);
            com.kwad.sdk.utils.t.a(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, aVar.p);
            com.kwad.sdk.utils.t.a(jSONObject, "systemVersion", aVar.q);
            com.kwad.sdk.utils.t.a(jSONObject, "osApi", aVar.r);
            com.kwad.sdk.utils.t.a(jSONObject, "language", aVar.s);
            com.kwad.sdk.utils.t.a(jSONObject, "locale", aVar.t);
            com.kwad.sdk.utils.t.a(jSONObject, "uuid", aVar.u);
            com.kwad.sdk.utils.t.a(jSONObject, "screenWidth", aVar.v);
            com.kwad.sdk.utils.t.a(jSONObject, "screenHeight", aVar.w);
            com.kwad.sdk.utils.t.a(jSONObject, "imei", aVar.x);
            com.kwad.sdk.utils.t.a(jSONObject, "oaid", aVar.y);
            com.kwad.sdk.utils.t.a(jSONObject, "androidId", aVar.z);
            com.kwad.sdk.utils.t.a(jSONObject, BaseStatisContent.MAC, aVar.A);
            com.kwad.sdk.utils.t.a(jSONObject, "statusBarHeight", aVar.B);
            com.kwad.sdk.utils.t.a(jSONObject, "titleBarHeight", aVar.C);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
