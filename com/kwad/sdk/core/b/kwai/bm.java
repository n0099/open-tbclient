package com.kwad.sdk.core.b.kwai;

import com.baidu.ar.constants.HttpConstants;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bm implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optString("imei");
        if (jSONObject.opt("imei") == JSONObject.NULL) {
            bVar.a = "";
        }
        bVar.b = jSONObject.optString("imei1");
        if (jSONObject.opt("imei1") == JSONObject.NULL) {
            bVar.b = "";
        }
        bVar.c = jSONObject.optString("imei2");
        if (jSONObject.opt("imei2") == JSONObject.NULL) {
            bVar.c = "";
        }
        bVar.d = jSONObject.optString("meid");
        if (jSONObject.opt("meid") == JSONObject.NULL) {
            bVar.d = "";
        }
        bVar.e = jSONObject.optString("oaid");
        if (jSONObject.opt("oaid") == JSONObject.NULL) {
            bVar.e = "";
        }
        bVar.f = jSONObject.optString("appMkt");
        if (jSONObject.opt("appMkt") == JSONObject.NULL) {
            bVar.f = "";
        }
        bVar.g = jSONObject.optString("appMktParam");
        if (jSONObject.opt("appMktParam") == JSONObject.NULL) {
            bVar.g = "";
        }
        bVar.h = jSONObject.optString("romName");
        if (jSONObject.opt("romName") == JSONObject.NULL) {
            bVar.h = "";
        }
        bVar.i = jSONObject.optInt(HttpConstants.HTTP_OS_TYPE_OLD);
        bVar.j = jSONObject.optInt("osApi");
        bVar.k = jSONObject.optString("osVersion");
        if (jSONObject.opt("osVersion") == JSONObject.NULL) {
            bVar.k = "";
        }
        bVar.l = jSONObject.optString("language");
        if (jSONObject.opt("language") == JSONObject.NULL) {
            bVar.l = "";
        }
        bVar.m = jSONObject.optInt("screenWidth");
        bVar.n = jSONObject.optInt("screenHeight");
        bVar.o = jSONObject.optInt("deviceWidth");
        bVar.p = jSONObject.optInt("deviceHeight");
        bVar.q = jSONObject.optString("androidId");
        if (jSONObject.opt("androidId") == JSONObject.NULL) {
            bVar.q = "";
        }
        bVar.r = jSONObject.optString("deviceId");
        if (jSONObject.opt("deviceId") == JSONObject.NULL) {
            bVar.r = "";
        }
        bVar.s = jSONObject.optString("deviceVendor");
        if (jSONObject.opt("deviceVendor") == JSONObject.NULL) {
            bVar.s = "";
        }
        bVar.t = jSONObject.optInt(Constants.PARAM_PLATFORM);
        bVar.u = jSONObject.optString("deviceModel");
        if (jSONObject.opt("deviceModel") == JSONObject.NULL) {
            bVar.u = "";
        }
        bVar.v = jSONObject.optString("deviceBrand");
        if (jSONObject.opt("deviceBrand") == JSONObject.NULL) {
            bVar.v = "";
        }
        bVar.w = jSONObject.optString("deviceSig");
        if (jSONObject.opt("deviceSig") == JSONObject.NULL) {
            bVar.w = "";
        }
        bVar.x = jSONObject.optString("eGid");
        if (jSONObject.opt("eGid") == JSONObject.NULL) {
            bVar.x = "";
        }
        bVar.y = jSONObject.optJSONArray("appPackageName");
        bVar.z = jSONObject.optString("arch");
        if (jSONObject.opt("arch") == JSONObject.NULL) {
            bVar.z = "";
        }
        bVar.A = jSONObject.optInt("screenDirection");
        bVar.B = jSONObject.optString("kwaiVersionName");
        if (jSONObject.opt("kwaiVersionName") == JSONObject.NULL) {
            bVar.B = "";
        }
        bVar.C = jSONObject.optString("kwaiNebulaVersionName");
        if (jSONObject.opt("kwaiNebulaVersionName") == JSONObject.NULL) {
            bVar.C = "";
        }
        bVar.D = jSONObject.optString("wechatVersionName");
        if (jSONObject.opt("wechatVersionName") == JSONObject.NULL) {
            bVar.D = "";
        }
        bVar.E = jSONObject.optLong("sourceFlag");
        bVar.F = jSONObject.optString("systemBootTime");
        if (jSONObject.opt("systemBootTime") == JSONObject.NULL) {
            bVar.F = "";
        }
        bVar.G = jSONObject.optString("systemUpdateTime");
        if (jSONObject.opt("systemUpdateTime") == JSONObject.NULL) {
            bVar.G = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "imei", bVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "imei1", bVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "imei2", bVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, "meid", bVar.d);
        com.kwad.sdk.utils.r.a(jSONObject, "oaid", bVar.e);
        com.kwad.sdk.utils.r.a(jSONObject, "appMkt", bVar.f);
        com.kwad.sdk.utils.r.a(jSONObject, "appMktParam", bVar.g);
        com.kwad.sdk.utils.r.a(jSONObject, "romName", bVar.h);
        com.kwad.sdk.utils.r.a(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, bVar.i);
        com.kwad.sdk.utils.r.a(jSONObject, "osApi", bVar.j);
        com.kwad.sdk.utils.r.a(jSONObject, "osVersion", bVar.k);
        com.kwad.sdk.utils.r.a(jSONObject, "language", bVar.l);
        com.kwad.sdk.utils.r.a(jSONObject, "screenWidth", bVar.m);
        com.kwad.sdk.utils.r.a(jSONObject, "screenHeight", bVar.n);
        com.kwad.sdk.utils.r.a(jSONObject, "deviceWidth", bVar.o);
        com.kwad.sdk.utils.r.a(jSONObject, "deviceHeight", bVar.p);
        com.kwad.sdk.utils.r.a(jSONObject, "androidId", bVar.q);
        com.kwad.sdk.utils.r.a(jSONObject, "deviceId", bVar.r);
        com.kwad.sdk.utils.r.a(jSONObject, "deviceVendor", bVar.s);
        com.kwad.sdk.utils.r.a(jSONObject, Constants.PARAM_PLATFORM, bVar.t);
        com.kwad.sdk.utils.r.a(jSONObject, "deviceModel", bVar.u);
        com.kwad.sdk.utils.r.a(jSONObject, "deviceBrand", bVar.v);
        com.kwad.sdk.utils.r.a(jSONObject, "deviceSig", bVar.w);
        com.kwad.sdk.utils.r.a(jSONObject, "eGid", bVar.x);
        com.kwad.sdk.utils.r.a(jSONObject, "appPackageName", bVar.y);
        com.kwad.sdk.utils.r.a(jSONObject, "arch", bVar.z);
        com.kwad.sdk.utils.r.a(jSONObject, "screenDirection", bVar.A);
        com.kwad.sdk.utils.r.a(jSONObject, "kwaiVersionName", bVar.B);
        com.kwad.sdk.utils.r.a(jSONObject, "kwaiNebulaVersionName", bVar.C);
        com.kwad.sdk.utils.r.a(jSONObject, "wechatVersionName", bVar.D);
        com.kwad.sdk.utils.r.a(jSONObject, "sourceFlag", bVar.E);
        com.kwad.sdk.utils.r.a(jSONObject, "systemBootTime", bVar.F);
        com.kwad.sdk.utils.r.a(jSONObject, "systemUpdateTime", bVar.G);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
