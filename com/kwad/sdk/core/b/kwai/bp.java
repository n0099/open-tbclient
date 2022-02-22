package com.kwad.sdk.core.b.kwai;

import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.core.webview.jshandler.e;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bp implements com.kwad.sdk.core.d<e.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optString("SDKVersion");
        if (jSONObject.opt("SDKVersion") == JSONObject.NULL) {
            aVar.a = "";
        }
        aVar.f56579b = jSONObject.optInt("SDKVersionCode");
        aVar.f56580c = jSONObject.optString("sdkApiVersion");
        if (jSONObject.opt("sdkApiVersion") == JSONObject.NULL) {
            aVar.f56580c = "";
        }
        aVar.f56581d = jSONObject.optInt("sdkApiVersionCode");
        aVar.f56582e = jSONObject.optInt("sdkType");
        aVar.f56583f = jSONObject.optString("appVersion");
        if (jSONObject.opt("appVersion") == JSONObject.NULL) {
            aVar.f56583f = "";
        }
        aVar.f56584g = jSONObject.optString("appName");
        if (jSONObject.opt("appName") == JSONObject.NULL) {
            aVar.f56584g = "";
        }
        aVar.f56585h = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        if (jSONObject.opt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID) == JSONObject.NULL) {
            aVar.f56585h = "";
        }
        aVar.f56586i = jSONObject.optString("globalId");
        if (jSONObject.opt("globalId") == JSONObject.NULL) {
            aVar.f56586i = "";
        }
        aVar.f56587j = jSONObject.optString("eGid");
        if (jSONObject.opt("eGid") == JSONObject.NULL) {
            aVar.f56587j = "";
        }
        aVar.k = jSONObject.optString("deviceSig");
        if (jSONObject.opt("deviceSig") == JSONObject.NULL) {
            aVar.k = "";
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
        aVar.A = jSONObject.optString("mac");
        if (jSONObject.opt("mac") == JSONObject.NULL) {
            aVar.A = "";
        }
        aVar.B = jSONObject.optInt("statusBarHeight");
        aVar.C = jSONObject.optInt("titleBarHeight");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "SDKVersion", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "SDKVersionCode", aVar.f56579b);
        com.kwad.sdk.utils.t.a(jSONObject, "sdkApiVersion", aVar.f56580c);
        com.kwad.sdk.utils.t.a(jSONObject, "sdkApiVersionCode", aVar.f56581d);
        com.kwad.sdk.utils.t.a(jSONObject, "sdkType", aVar.f56582e);
        com.kwad.sdk.utils.t.a(jSONObject, "appVersion", aVar.f56583f);
        com.kwad.sdk.utils.t.a(jSONObject, "appName", aVar.f56584g);
        com.kwad.sdk.utils.t.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, aVar.f56585h);
        com.kwad.sdk.utils.t.a(jSONObject, "globalId", aVar.f56586i);
        com.kwad.sdk.utils.t.a(jSONObject, "eGid", aVar.f56587j);
        com.kwad.sdk.utils.t.a(jSONObject, "deviceSig", aVar.k);
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
        com.kwad.sdk.utils.t.a(jSONObject, "mac", aVar.A);
        com.kwad.sdk.utils.t.a(jSONObject, "statusBarHeight", aVar.B);
        com.kwad.sdk.utils.t.a(jSONObject, "titleBarHeight", aVar.C);
        return jSONObject;
    }
}
