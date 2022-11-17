package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.u;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class at implements com.kwad.sdk.core.d<u.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(u.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.abB = jSONObject.optInt("photoPlaySecond");
        bVar.abC = jSONObject.optInt("awardReceiveStage");
        bVar.gJ = jSONObject.optInt("itemClickType");
        bVar.abD = jSONObject.optInt("itemCloseType");
        bVar.abE = jSONObject.optInt("elementType");
        bVar.abF = jSONObject.optInt("impFailReason");
        bVar.winEcpm = jSONObject.optInt("winEcpm");
        bVar.abG = jSONObject.optInt("retainCodeType");
        bVar.abH = jSONObject.optInt("photoSizeStyle");
        bVar.Mn = jSONObject.optString("payload");
        if (jSONObject.opt("payload") == JSONObject.NULL) {
            bVar.Mn = "";
        }
        bVar.abI = jSONObject.optInt("deeplinkType");
        bVar.downloadSource = jSONObject.optInt("downloadSource");
        bVar.abJ = jSONObject.optInt("isPackageChanged");
        bVar.abK = jSONObject.optString("installedFrom");
        if (jSONObject.opt("installedFrom") == JSONObject.NULL) {
            bVar.abK = "";
        }
        bVar.abL = jSONObject.optString("downloadFailedReason");
        if (jSONObject.opt("downloadFailedReason") == JSONObject.NULL) {
            bVar.abL = "";
        }
        bVar.abM = jSONObject.optInt("isChangedEndcard");
        bVar.aat = jSONObject.optInt("adAggPageSource");
        bVar.abN = jSONObject.optString("serverPackageName");
        if (jSONObject.opt("serverPackageName") == JSONObject.NULL) {
            bVar.abN = "";
        }
        bVar.abO = jSONObject.optString("installedPackageName");
        if (jSONObject.opt("installedPackageName") == JSONObject.NULL) {
            bVar.abO = "";
        }
        bVar.abP = jSONObject.optInt("closeButtonImpressionTime");
        bVar.abQ = jSONObject.optInt("closeButtonClickTime");
        bVar.abR = jSONObject.optLong("landingPageLoadedDuration");
        bVar.Es = jSONObject.optLong("leaveTime");
        bVar.abS = jSONObject.optLong("adItemClickBackDuration");
        bVar.abT = jSONObject.optInt("appStorePageType");
        bVar.abU = jSONObject.optInt("installStatus");
        bVar.lf = jSONObject.optInt("downloadStatus");
        bVar.abV = jSONObject.optInt("downloadCardType");
        u.a aVar = new u.a();
        bVar.abW = aVar;
        aVar.parseJson(jSONObject.optJSONObject("clientExtData"));
        bVar.FH = jSONObject.optInt("landingPageType");
        bVar.ss = jSONObject.optLong("playedDuration");
        bVar.abX = jSONObject.optInt("playedRate");
        bVar.abY = jSONObject.optInt("adOrder");
        bVar.abZ = jSONObject.optInt("adInterstitialSource");
        bVar.gM = jSONObject.optDouble("splashShakeAcceleration");
        bVar.aca = jSONObject.optInt("universeSecondAd");
        bVar.acb = jSONObject.optString("splashInteractionRotateAngle");
        if (jSONObject.opt("splashInteractionRotateAngle") == JSONObject.NULL) {
            bVar.acb = "";
        }
        bVar.acc = jSONObject.optInt("downloadInstallType");
        bVar.acd = jSONObject.optInt("businessSceneType");
        bVar.adxResult = jSONObject.optInt("adxResult");
        bVar.ace = jSONObject.optInt("fingerSwipeType");
        bVar.acf = jSONObject.optInt("fingerSwipeDistance");
        bVar.acg = jSONObject.optInt("triggerType");
        bVar.ach = jSONObject.optInt("cardCloseType");
        bVar.aci = jSONObject.optString("clientPkFailAdInfo");
        if (jSONObject.opt("clientPkFailAdInfo") == JSONObject.NULL) {
            bVar.aci = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(u.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.abB;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "photoPlaySecond", i);
        }
        int i2 = bVar.abC;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "awardReceiveStage", i2);
        }
        int i3 = bVar.gJ;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "itemClickType", i3);
        }
        int i4 = bVar.abD;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "itemCloseType", i4);
        }
        int i5 = bVar.abE;
        if (i5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "elementType", i5);
        }
        int i6 = bVar.abF;
        if (i6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "impFailReason", i6);
        }
        int i7 = bVar.winEcpm;
        if (i7 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "winEcpm", i7);
        }
        int i8 = bVar.abG;
        if (i8 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "retainCodeType", i8);
        }
        int i9 = bVar.abH;
        if (i9 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "photoSizeStyle", i9);
        }
        String str = bVar.Mn;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "payload", bVar.Mn);
        }
        int i10 = bVar.abI;
        if (i10 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "deeplinkType", i10);
        }
        int i11 = bVar.downloadSource;
        if (i11 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "downloadSource", i11);
        }
        int i12 = bVar.abJ;
        if (i12 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "isPackageChanged", i12);
        }
        String str2 = bVar.abK;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "installedFrom", bVar.abK);
        }
        String str3 = bVar.abL;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "downloadFailedReason", bVar.abL);
        }
        int i13 = bVar.abM;
        if (i13 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "isChangedEndcard", i13);
        }
        int i14 = bVar.aat;
        if (i14 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adAggPageSource", i14);
        }
        String str4 = bVar.abN;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "serverPackageName", bVar.abN);
        }
        String str5 = bVar.abO;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "installedPackageName", bVar.abO);
        }
        int i15 = bVar.abP;
        if (i15 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "closeButtonImpressionTime", i15);
        }
        int i16 = bVar.abQ;
        if (i16 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "closeButtonClickTime", i16);
        }
        long j = bVar.abR;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "landingPageLoadedDuration", j);
        }
        long j2 = bVar.Es;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "leaveTime", j2);
        }
        long j3 = bVar.abS;
        if (j3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adItemClickBackDuration", j3);
        }
        int i17 = bVar.abT;
        if (i17 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "appStorePageType", i17);
        }
        int i18 = bVar.abU;
        if (i18 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "installStatus", i18);
        }
        int i19 = bVar.lf;
        if (i19 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "downloadStatus", i19);
        }
        int i20 = bVar.abV;
        if (i20 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "downloadCardType", i20);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "clientExtData", bVar.abW);
        int i21 = bVar.FH;
        if (i21 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "landingPageType", i21);
        }
        long j4 = bVar.ss;
        if (j4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "playedDuration", j4);
        }
        int i22 = bVar.abX;
        if (i22 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "playedRate", i22);
        }
        int i23 = bVar.abY;
        if (i23 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adOrder", i23);
        }
        int i24 = bVar.abZ;
        if (i24 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adInterstitialSource", i24);
        }
        double d = bVar.gM;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "splashShakeAcceleration", d);
        }
        int i25 = bVar.aca;
        if (i25 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "universeSecondAd", i25);
        }
        String str6 = bVar.acb;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "splashInteractionRotateAngle", bVar.acb);
        }
        int i26 = bVar.acc;
        if (i26 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "downloadInstallType", i26);
        }
        int i27 = bVar.acd;
        if (i27 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "businessSceneType", i27);
        }
        int i28 = bVar.adxResult;
        if (i28 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adxResult", i28);
        }
        int i29 = bVar.ace;
        if (i29 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "fingerSwipeType", i29);
        }
        int i30 = bVar.acf;
        if (i30 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "fingerSwipeDistance", i30);
        }
        int i31 = bVar.acg;
        if (i31 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "triggerType", i31);
        }
        int i32 = bVar.ach;
        if (i32 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "cardCloseType", i32);
        }
        String str7 = bVar.aci;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "clientPkFailAdInfo", bVar.aci);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(u.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(u.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
