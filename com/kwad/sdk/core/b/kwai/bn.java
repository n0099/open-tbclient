package com.kwad.sdk.core.b.kwai;

import com.baidu.ar.constants.HttpConstants;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class bn implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.VB = jSONObject.optString("imei");
        if (jSONObject.opt("imei") == JSONObject.NULL) {
            bVar.VB = "";
        }
        bVar.acn = jSONObject.optString("imei1");
        if (jSONObject.opt("imei1") == JSONObject.NULL) {
            bVar.acn = "";
        }
        bVar.aco = jSONObject.optString("imei2");
        if (jSONObject.opt("imei2") == JSONObject.NULL) {
            bVar.aco = "";
        }
        bVar.acp = jSONObject.optString("meid");
        if (jSONObject.opt("meid") == JSONObject.NULL) {
            bVar.acp = "";
        }
        bVar.VC = jSONObject.optString("oaid");
        if (jSONObject.opt("oaid") == JSONObject.NULL) {
            bVar.VC = "";
        }
        bVar.acq = jSONObject.optString("appMkt");
        if (jSONObject.opt("appMkt") == JSONObject.NULL) {
            bVar.acq = "";
        }
        bVar.acr = jSONObject.optString("appMktParam");
        if (jSONObject.opt("appMktParam") == JSONObject.NULL) {
            bVar.acr = "";
        }
        bVar.Ig = jSONObject.optString("romName");
        if (jSONObject.opt("romName") == JSONObject.NULL) {
            bVar.Ig = "";
        }
        bVar.LN = jSONObject.optInt(HttpConstants.HTTP_OS_TYPE_OLD);
        bVar.LP = jSONObject.optInt("osApi");
        bVar.acs = jSONObject.optString("osVersion");
        if (jSONObject.opt("osVersion") == JSONObject.NULL) {
            bVar.acs = "";
        }
        bVar.LQ = jSONObject.optString("language");
        if (jSONObject.opt("language") == JSONObject.NULL) {
            bVar.LQ = "";
        }
        bVar.LS = jSONObject.optInt("screenWidth");
        bVar.LT = jSONObject.optInt("screenHeight");
        bVar.act = jSONObject.optInt("deviceWidth");
        bVar.acu = jSONObject.optInt("deviceHeight");
        bVar.acv = jSONObject.optString("androidId");
        if (jSONObject.opt("androidId") == JSONObject.NULL) {
            bVar.acv = "";
        }
        bVar.acw = jSONObject.optString("deviceId");
        if (jSONObject.opt("deviceId") == JSONObject.NULL) {
            bVar.acw = "";
        }
        bVar.acx = jSONObject.optString("deviceVendor");
        if (jSONObject.opt("deviceVendor") == JSONObject.NULL) {
            bVar.acx = "";
        }
        bVar.acy = jSONObject.optInt(Constants.PARAM_PLATFORM);
        bVar.acz = jSONObject.optString("deviceModel");
        if (jSONObject.opt("deviceModel") == JSONObject.NULL) {
            bVar.acz = "";
        }
        bVar.LM = jSONObject.optString("deviceBrand");
        if (jSONObject.opt("deviceBrand") == JSONObject.NULL) {
            bVar.LM = "";
        }
        bVar.acA = jSONObject.optString("deviceSig");
        if (jSONObject.opt("deviceSig") == JSONObject.NULL) {
            bVar.acA = "";
        }
        bVar.acB = jSONObject.optString("eGid");
        if (jSONObject.opt("eGid") == JSONObject.NULL) {
            bVar.acB = "";
        }
        bVar.acC = jSONObject.optJSONArray("appPackageName");
        bVar.acD = jSONObject.optString("arch");
        if (jSONObject.opt("arch") == JSONObject.NULL) {
            bVar.acD = "";
        }
        bVar.acE = jSONObject.optInt("screenDirection");
        bVar.acF = jSONObject.optString("kwaiVersionName");
        if (jSONObject.opt("kwaiVersionName") == JSONObject.NULL) {
            bVar.acF = "";
        }
        bVar.acG = jSONObject.optString("kwaiNebulaVersionName");
        if (jSONObject.opt("kwaiNebulaVersionName") == JSONObject.NULL) {
            bVar.acG = "";
        }
        bVar.acH = jSONObject.optString("wechatVersionName");
        if (jSONObject.opt("wechatVersionName") == JSONObject.NULL) {
            bVar.acH = "";
        }
        bVar.acI = jSONObject.optLong("sourceFlag");
        bVar.acJ = jSONObject.optString("systemBootTime");
        if (jSONObject.opt("systemBootTime") == JSONObject.NULL) {
            bVar.acJ = "";
        }
        bVar.acK = jSONObject.optString("systemUpdateTime");
        if (jSONObject.opt("systemUpdateTime") == JSONObject.NULL) {
            bVar.acK = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.VB;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "imei", bVar.VB);
        }
        String str2 = bVar.acn;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "imei1", bVar.acn);
        }
        String str3 = bVar.aco;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "imei2", bVar.aco);
        }
        String str4 = bVar.acp;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "meid", bVar.acp);
        }
        String str5 = bVar.VC;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "oaid", bVar.VC);
        }
        String str6 = bVar.acq;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appMkt", bVar.acq);
        }
        String str7 = bVar.acr;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appMktParam", bVar.acr);
        }
        String str8 = bVar.Ig;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "romName", bVar.Ig);
        }
        int i = bVar.LN;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, i);
        }
        int i2 = bVar.LP;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "osApi", i2);
        }
        String str9 = bVar.acs;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "osVersion", bVar.acs);
        }
        String str10 = bVar.LQ;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "language", bVar.LQ);
        }
        int i3 = bVar.LS;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "screenWidth", i3);
        }
        int i4 = bVar.LT;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "screenHeight", i4);
        }
        int i5 = bVar.act;
        if (i5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "deviceWidth", i5);
        }
        int i6 = bVar.acu;
        if (i6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "deviceHeight", i6);
        }
        String str11 = bVar.acv;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "androidId", bVar.acv);
        }
        String str12 = bVar.acw;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "deviceId", bVar.acw);
        }
        String str13 = bVar.acx;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "deviceVendor", bVar.acx);
        }
        int i7 = bVar.acy;
        if (i7 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, Constants.PARAM_PLATFORM, i7);
        }
        String str14 = bVar.acz;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "deviceModel", bVar.acz);
        }
        String str15 = bVar.LM;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "deviceBrand", bVar.LM);
        }
        String str16 = bVar.acA;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "deviceSig", bVar.acA);
        }
        String str17 = bVar.acB;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "eGid", bVar.acB);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "appPackageName", bVar.acC);
        String str18 = bVar.acD;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "arch", bVar.acD);
        }
        int i8 = bVar.acE;
        if (i8 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "screenDirection", i8);
        }
        String str19 = bVar.acF;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "kwaiVersionName", bVar.acF);
        }
        String str20 = bVar.acG;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "kwaiNebulaVersionName", bVar.acG);
        }
        String str21 = bVar.acH;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "wechatVersionName", bVar.acH);
        }
        long j = bVar.acI;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "sourceFlag", j);
        }
        String str22 = bVar.acJ;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "systemBootTime", bVar.acJ);
        }
        String str23 = bVar.acK;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "systemUpdateTime", bVar.acK);
        }
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
