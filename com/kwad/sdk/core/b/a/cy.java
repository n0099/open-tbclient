package com.kwad.sdk.core.b.a;

import com.baidu.ar.constants.HttpConstants;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class cy implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.arh = jSONObject.optString("imei");
        if (JSONObject.NULL.toString().equals(bVar.arh)) {
            bVar.arh = "";
        }
        bVar.ayd = jSONObject.optString("imei1");
        if (JSONObject.NULL.toString().equals(bVar.ayd)) {
            bVar.ayd = "";
        }
        bVar.aye = jSONObject.optString("imei2");
        if (JSONObject.NULL.toString().equals(bVar.aye)) {
            bVar.aye = "";
        }
        bVar.ayf = jSONObject.optString("meid");
        if (JSONObject.NULL.toString().equals(bVar.ayf)) {
            bVar.ayf = "";
        }
        bVar.ari = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(bVar.ari)) {
            bVar.ari = "";
        }
        bVar.ayg = jSONObject.optString("appMkt");
        if (JSONObject.NULL.toString().equals(bVar.ayg)) {
            bVar.ayg = "";
        }
        bVar.ayh = jSONObject.optString("appMktParam");
        if (JSONObject.NULL.toString().equals(bVar.ayh)) {
            bVar.ayh = "";
        }
        bVar.RD = jSONObject.optString("romName");
        if (JSONObject.NULL.toString().equals(bVar.RD)) {
            bVar.RD = "";
        }
        bVar.WF = jSONObject.optInt(HttpConstants.HTTP_OS_TYPE_OLD);
        bVar.WH = jSONObject.optInt("osApi");
        bVar.ayi = jSONObject.optString("osVersion");
        if (JSONObject.NULL.toString().equals(bVar.ayi)) {
            bVar.ayi = "";
        }
        bVar.WI = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(bVar.WI)) {
            bVar.WI = "";
        }
        bVar.WK = jSONObject.optInt("screenWidth");
        bVar.WL = jSONObject.optInt("screenHeight");
        bVar.ayj = jSONObject.optInt("deviceWidth");
        bVar.ayk = jSONObject.optInt("deviceHeight");
        bVar.ayl = jSONObject.optString("androidId");
        if (JSONObject.NULL.toString().equals(bVar.ayl)) {
            bVar.ayl = "";
        }
        bVar.aym = jSONObject.optString("deviceId");
        if (JSONObject.NULL.toString().equals(bVar.aym)) {
            bVar.aym = "";
        }
        bVar.ayn = jSONObject.optString("deviceVendor");
        if (JSONObject.NULL.toString().equals(bVar.ayn)) {
            bVar.ayn = "";
        }
        bVar.ayo = jSONObject.optInt(Constants.PARAM_PLATFORM);
        bVar.ayp = jSONObject.optString("deviceModel");
        if (JSONObject.NULL.toString().equals(bVar.ayp)) {
            bVar.ayp = "";
        }
        bVar.WE = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(bVar.WE)) {
            bVar.WE = "";
        }
        bVar.ayq = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(bVar.ayq)) {
            bVar.ayq = "";
        }
        bVar.ayr = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(bVar.ayr)) {
            bVar.ayr = "";
        }
        bVar.ays = jSONObject.optJSONArray("appPackageName");
        bVar.ayt = jSONObject.optString("arch");
        if (JSONObject.NULL.toString().equals(bVar.ayt)) {
            bVar.ayt = "";
        }
        bVar.ayu = jSONObject.optInt("screenDirection");
        bVar.ayv = jSONObject.optString("kwaiVersionName");
        if (JSONObject.NULL.toString().equals(bVar.ayv)) {
            bVar.ayv = "";
        }
        bVar.ayw = jSONObject.optString("kwaiNebulaVersionName");
        if (JSONObject.NULL.toString().equals(bVar.ayw)) {
            bVar.ayw = "";
        }
        bVar.ayx = jSONObject.optString("wechatVersionName");
        if (JSONObject.NULL.toString().equals(bVar.ayx)) {
            bVar.ayx = "";
        }
        bVar.ayy = jSONObject.optLong("sourceFlag");
        bVar.ayz = jSONObject.optString("systemBootTime");
        if (JSONObject.NULL.toString().equals(bVar.ayz)) {
            bVar.ayz = "";
        }
        bVar.ayA = jSONObject.optString("systemUpdateTime");
        if (JSONObject.NULL.toString().equals(bVar.ayA)) {
            bVar.ayA = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.arh;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imei", bVar.arh);
        }
        String str2 = bVar.ayd;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imei1", bVar.ayd);
        }
        String str3 = bVar.aye;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imei2", bVar.aye);
        }
        String str4 = bVar.ayf;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "meid", bVar.ayf);
        }
        String str5 = bVar.ari;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "oaid", bVar.ari);
        }
        String str6 = bVar.ayg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appMkt", bVar.ayg);
        }
        String str7 = bVar.ayh;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appMktParam", bVar.ayh);
        }
        String str8 = bVar.RD;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "romName", bVar.RD);
        }
        int i = bVar.WF;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, i);
        }
        int i2 = bVar.WH;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osApi", i2);
        }
        String str9 = bVar.ayi;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osVersion", bVar.ayi);
        }
        String str10 = bVar.WI;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "language", bVar.WI);
        }
        int i3 = bVar.WK;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenWidth", i3);
        }
        int i4 = bVar.WL;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenHeight", i4);
        }
        int i5 = bVar.ayj;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceWidth", i5);
        }
        int i6 = bVar.ayk;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceHeight", i6);
        }
        String str11 = bVar.ayl;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "androidId", bVar.ayl);
        }
        String str12 = bVar.aym;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceId", bVar.aym);
        }
        String str13 = bVar.ayn;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceVendor", bVar.ayn);
        }
        int i7 = bVar.ayo;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, Constants.PARAM_PLATFORM, i7);
        }
        String str14 = bVar.ayp;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceModel", bVar.ayp);
        }
        String str15 = bVar.WE;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceBrand", bVar.WE);
        }
        String str16 = bVar.ayq;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceSig", bVar.ayq);
        }
        String str17 = bVar.ayr;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "eGid", bVar.ayr);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appPackageName", bVar.ays);
        String str18 = bVar.ayt;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "arch", bVar.ayt);
        }
        int i8 = bVar.ayu;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenDirection", i8);
        }
        String str19 = bVar.ayv;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "kwaiVersionName", bVar.ayv);
        }
        String str20 = bVar.ayw;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "kwaiNebulaVersionName", bVar.ayw);
        }
        String str21 = bVar.ayx;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "wechatVersionName", bVar.ayx);
        }
        long j = bVar.ayy;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sourceFlag", j);
        }
        String str22 = bVar.ayz;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "systemBootTime", bVar.ayz);
        }
        String str23 = bVar.ayA;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "systemUpdateTime", bVar.ayA);
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
