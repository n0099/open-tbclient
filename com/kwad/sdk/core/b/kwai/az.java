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
        dVar.f58352b = jSONObject.optString("imei1");
        if (jSONObject.opt("imei1") == JSONObject.NULL) {
            dVar.f58352b = "";
        }
        dVar.f58353c = jSONObject.optString("imei2");
        if (jSONObject.opt("imei2") == JSONObject.NULL) {
            dVar.f58353c = "";
        }
        dVar.f58354d = jSONObject.optString("meid");
        if (jSONObject.opt("meid") == JSONObject.NULL) {
            dVar.f58354d = "";
        }
        dVar.f58355e = jSONObject.optString("oaid");
        if (jSONObject.opt("oaid") == JSONObject.NULL) {
            dVar.f58355e = "";
        }
        dVar.f58356f = jSONObject.optString("appMkt");
        if (jSONObject.opt("appMkt") == JSONObject.NULL) {
            dVar.f58356f = "";
        }
        dVar.f58357g = jSONObject.optString("appMktParam");
        if (jSONObject.opt("appMktParam") == JSONObject.NULL) {
            dVar.f58357g = "";
        }
        dVar.f58358h = jSONObject.optInt(HttpConstants.HTTP_OS_TYPE_OLD);
        dVar.f58359i = jSONObject.optInt("osApi");
        dVar.f58360j = jSONObject.optString("osVersion");
        if (jSONObject.opt("osVersion") == JSONObject.NULL) {
            dVar.f58360j = "";
        }
        dVar.f58361k = jSONObject.optString("language");
        if (jSONObject.opt("language") == JSONObject.NULL) {
            dVar.f58361k = "";
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
        com.kwad.sdk.utils.t.a(jSONObject, "imei1", dVar.f58352b);
        com.kwad.sdk.utils.t.a(jSONObject, "imei2", dVar.f58353c);
        com.kwad.sdk.utils.t.a(jSONObject, "meid", dVar.f58354d);
        com.kwad.sdk.utils.t.a(jSONObject, "oaid", dVar.f58355e);
        com.kwad.sdk.utils.t.a(jSONObject, "appMkt", dVar.f58356f);
        com.kwad.sdk.utils.t.a(jSONObject, "appMktParam", dVar.f58357g);
        com.kwad.sdk.utils.t.a(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, dVar.f58358h);
        com.kwad.sdk.utils.t.a(jSONObject, "osApi", dVar.f58359i);
        com.kwad.sdk.utils.t.a(jSONObject, "osVersion", dVar.f58360j);
        com.kwad.sdk.utils.t.a(jSONObject, "language", dVar.f58361k);
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
