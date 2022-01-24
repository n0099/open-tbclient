package com.kwad.sdk.core.b.kwai;

import com.baidu.ar.constants.HttpConstants;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class az implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.d> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.a = jSONObject.optString("imei");
        if (jSONObject.opt("imei") == JSONObject.NULL) {
            dVar.a = "";
        }
        dVar.f56195b = jSONObject.optString("imei1");
        if (jSONObject.opt("imei1") == JSONObject.NULL) {
            dVar.f56195b = "";
        }
        dVar.f56196c = jSONObject.optString("imei2");
        if (jSONObject.opt("imei2") == JSONObject.NULL) {
            dVar.f56196c = "";
        }
        dVar.f56197d = jSONObject.optString("meid");
        if (jSONObject.opt("meid") == JSONObject.NULL) {
            dVar.f56197d = "";
        }
        dVar.f56198e = jSONObject.optString("oaid");
        if (jSONObject.opt("oaid") == JSONObject.NULL) {
            dVar.f56198e = "";
        }
        dVar.f56199f = jSONObject.optString("appMkt");
        if (jSONObject.opt("appMkt") == JSONObject.NULL) {
            dVar.f56199f = "";
        }
        dVar.f56200g = jSONObject.optString("appMktParam");
        if (jSONObject.opt("appMktParam") == JSONObject.NULL) {
            dVar.f56200g = "";
        }
        dVar.f56201h = jSONObject.optInt(HttpConstants.HTTP_OS_TYPE_OLD);
        dVar.f56202i = jSONObject.optInt("osApi");
        dVar.f56203j = jSONObject.optString("osVersion");
        if (jSONObject.opt("osVersion") == JSONObject.NULL) {
            dVar.f56203j = "";
        }
        dVar.k = jSONObject.optString("language");
        if (jSONObject.opt("language") == JSONObject.NULL) {
            dVar.k = "";
        }
        dVar.l = jSONObject.optInt("screenWidth");
        dVar.m = jSONObject.optInt("screenHeight");
        dVar.n = jSONObject.optInt("deviceWidth");
        dVar.o = jSONObject.optInt("deviceHeight");
        dVar.p = jSONObject.optString("androidId");
        if (jSONObject.opt("androidId") == JSONObject.NULL) {
            dVar.p = "";
        }
        dVar.q = jSONObject.optString("deviceId");
        if (jSONObject.opt("deviceId") == JSONObject.NULL) {
            dVar.q = "";
        }
        dVar.r = jSONObject.optString("deviceVendor");
        if (jSONObject.opt("deviceVendor") == JSONObject.NULL) {
            dVar.r = "";
        }
        dVar.s = jSONObject.optInt(Constants.PARAM_PLATFORM);
        dVar.t = jSONObject.optString("deviceModel");
        if (jSONObject.opt("deviceModel") == JSONObject.NULL) {
            dVar.t = "";
        }
        dVar.u = jSONObject.optString("deviceBrand");
        if (jSONObject.opt("deviceBrand") == JSONObject.NULL) {
            dVar.u = "";
        }
        dVar.v = jSONObject.optString("deviceSig");
        if (jSONObject.opt("deviceSig") == JSONObject.NULL) {
            dVar.v = "";
        }
        dVar.w = jSONObject.optString("eGid");
        if (jSONObject.opt("eGid") == JSONObject.NULL) {
            dVar.w = "";
        }
        dVar.x = jSONObject.optJSONArray("appPackageName");
        dVar.y = jSONObject.optString("arch");
        if (jSONObject.opt("arch") == JSONObject.NULL) {
            dVar.y = "";
        }
        dVar.z = jSONObject.optInt("screenDirection");
        dVar.A = jSONObject.optString("kwaiVersionName");
        if (jSONObject.opt("kwaiVersionName") == JSONObject.NULL) {
            dVar.A = "";
        }
        dVar.B = jSONObject.optString("kwaiNebulaVersionName");
        if (jSONObject.opt("kwaiNebulaVersionName") == JSONObject.NULL) {
            dVar.B = "";
        }
        dVar.C = jSONObject.optLong("sourceFlag");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "imei", dVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "imei1", dVar.f56195b);
        com.kwad.sdk.utils.t.a(jSONObject, "imei2", dVar.f56196c);
        com.kwad.sdk.utils.t.a(jSONObject, "meid", dVar.f56197d);
        com.kwad.sdk.utils.t.a(jSONObject, "oaid", dVar.f56198e);
        com.kwad.sdk.utils.t.a(jSONObject, "appMkt", dVar.f56199f);
        com.kwad.sdk.utils.t.a(jSONObject, "appMktParam", dVar.f56200g);
        com.kwad.sdk.utils.t.a(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, dVar.f56201h);
        com.kwad.sdk.utils.t.a(jSONObject, "osApi", dVar.f56202i);
        com.kwad.sdk.utils.t.a(jSONObject, "osVersion", dVar.f56203j);
        com.kwad.sdk.utils.t.a(jSONObject, "language", dVar.k);
        com.kwad.sdk.utils.t.a(jSONObject, "screenWidth", dVar.l);
        com.kwad.sdk.utils.t.a(jSONObject, "screenHeight", dVar.m);
        com.kwad.sdk.utils.t.a(jSONObject, "deviceWidth", dVar.n);
        com.kwad.sdk.utils.t.a(jSONObject, "deviceHeight", dVar.o);
        com.kwad.sdk.utils.t.a(jSONObject, "androidId", dVar.p);
        com.kwad.sdk.utils.t.a(jSONObject, "deviceId", dVar.q);
        com.kwad.sdk.utils.t.a(jSONObject, "deviceVendor", dVar.r);
        com.kwad.sdk.utils.t.a(jSONObject, Constants.PARAM_PLATFORM, dVar.s);
        com.kwad.sdk.utils.t.a(jSONObject, "deviceModel", dVar.t);
        com.kwad.sdk.utils.t.a(jSONObject, "deviceBrand", dVar.u);
        com.kwad.sdk.utils.t.a(jSONObject, "deviceSig", dVar.v);
        com.kwad.sdk.utils.t.a(jSONObject, "eGid", dVar.w);
        com.kwad.sdk.utils.t.a(jSONObject, "appPackageName", dVar.x);
        com.kwad.sdk.utils.t.a(jSONObject, "arch", dVar.y);
        com.kwad.sdk.utils.t.a(jSONObject, "screenDirection", dVar.z);
        com.kwad.sdk.utils.t.a(jSONObject, "kwaiVersionName", dVar.A);
        com.kwad.sdk.utils.t.a(jSONObject, "kwaiNebulaVersionName", dVar.B);
        com.kwad.sdk.utils.t.a(jSONObject, "sourceFlag", dVar.C);
        return jSONObject;
    }
}
