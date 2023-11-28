package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.report.y;
import com.qq.e.comm.pi.IBidding;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class bx implements com.kwad.sdk.core.d<y.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(y.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.axk = jSONObject.optInt("photoPlaySecond");
        bVar.axl = jSONObject.optInt("awardReceiveStage");
        bVar.kk = jSONObject.optInt("itemClickType");
        bVar.axm = jSONObject.optInt("itemCloseType");
        bVar.axn = jSONObject.optInt("elementType");
        bVar.axo = jSONObject.optString("adRenderArea");
        if (JSONObject.NULL.toString().equals(bVar.axo)) {
            bVar.axo = "";
        }
        bVar.axp = jSONObject.optLong(IBidding.HIGHEST_LOSS_PRICE);
        bVar.axq = jSONObject.optInt("impFailReason");
        bVar.axr = jSONObject.optLong("winEcpm");
        bVar.adnType = jSONObject.optInt("adnType");
        bVar.adnName = jSONObject.optString("adnName");
        if (JSONObject.NULL.toString().equals(bVar.adnName)) {
            bVar.adnName = "";
        }
        bVar.axs = jSONObject.optInt("retainCodeType");
        bVar.axt = jSONObject.optInt("photoSizeStyle");
        bVar.Xd = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(bVar.Xd)) {
            bVar.Xd = "";
        }
        bVar.axu = jSONObject.optInt("deeplinkType");
        bVar.axv = jSONObject.optString("deeplinkAppName");
        if (JSONObject.NULL.toString().equals(bVar.axv)) {
            bVar.axv = "";
        }
        bVar.axw = jSONObject.optInt("deeplinkFailedReason");
        bVar.downloadSource = jSONObject.optInt("downloadSource");
        bVar.axx = jSONObject.optInt("isPackageChanged");
        bVar.axy = jSONObject.optString("installedFrom");
        if (JSONObject.NULL.toString().equals(bVar.axy)) {
            bVar.axy = "";
        }
        bVar.axz = jSONObject.optString("downloadFailedReason");
        if (JSONObject.NULL.toString().equals(bVar.axz)) {
            bVar.axz = "";
        }
        bVar.axA = jSONObject.optInt("isChangedEndcard");
        bVar.avQ = jSONObject.optInt("adAggPageSource");
        bVar.axB = jSONObject.optString("serverPackageName");
        if (JSONObject.NULL.toString().equals(bVar.axB)) {
            bVar.axB = "";
        }
        bVar.axC = jSONObject.optString("installedPackageName");
        if (JSONObject.NULL.toString().equals(bVar.axC)) {
            bVar.axC = "";
        }
        bVar.axD = jSONObject.optInt("closeButtonImpressionTime");
        bVar.axE = jSONObject.optInt("closeButtonClickTime");
        bVar.axF = jSONObject.optLong("landingPageLoadedDuration");
        bVar.Lc = jSONObject.optLong("leaveTime");
        bVar.axG = jSONObject.optLong("adItemClickBackDuration");
        bVar.axH = jSONObject.optInt("appStorePageType");
        bVar.axI = jSONObject.optInt("installStatus");
        bVar.downloadStatus = jSONObject.optInt("downloadStatus");
        bVar.axJ = jSONObject.optInt("downloadCardType");
        y.a aVar = new y.a();
        bVar.axK = aVar;
        aVar.parseJson(jSONObject.optJSONObject("clientExtData"));
        bVar.Od = jSONObject.optInt("landingPageType");
        bVar.vy = jSONObject.optLong("playedDuration");
        bVar.axL = jSONObject.optInt("playedRate");
        bVar.axM = jSONObject.optInt("adOrder");
        bVar.axN = jSONObject.optInt("adInterstitialSource");
        bVar.kn = jSONObject.optDouble("splashShakeAcceleration");
        bVar.axO = jSONObject.optString("splashInteractionRotateAngle");
        if (JSONObject.NULL.toString().equals(bVar.axO)) {
            bVar.axO = "";
        }
        bVar.axP = jSONObject.optInt("downloadInstallType");
        bVar.axQ = jSONObject.optInt("businessSceneType");
        bVar.adxResult = jSONObject.optInt("adxResult");
        bVar.axR = jSONObject.optInt("fingerSwipeType");
        bVar.axS = jSONObject.optInt("fingerSwipeDistance");
        bVar.axT = jSONObject.optInt("triggerType");
        bVar.axU = jSONObject.optInt("cardCloseType");
        bVar.axV = jSONObject.optString("clientPkFailAdInfo");
        if (JSONObject.NULL.toString().equals(bVar.axV)) {
            bVar.axV = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(y.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.axk;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoPlaySecond", i);
        }
        int i2 = bVar.axl;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "awardReceiveStage", i2);
        }
        int i3 = bVar.kk;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemClickType", i3);
        }
        int i4 = bVar.axm;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemCloseType", i4);
        }
        int i5 = bVar.axn;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "elementType", i5);
        }
        String str = bVar.axo;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adRenderArea", bVar.axo);
        }
        long j = bVar.axp;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, IBidding.HIGHEST_LOSS_PRICE, j);
        }
        int i6 = bVar.axq;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "impFailReason", i6);
        }
        long j2 = bVar.axr;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "winEcpm", j2);
        }
        int i7 = bVar.adnType;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adnType", i7);
        }
        String str2 = bVar.adnName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adnName", bVar.adnName);
        }
        int i8 = bVar.axs;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainCodeType", i8);
        }
        int i9 = bVar.axt;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoSizeStyle", i9);
        }
        String str3 = bVar.Xd;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", bVar.Xd);
        }
        int i10 = bVar.axu;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkType", i10);
        }
        String str4 = bVar.axv;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkAppName", bVar.axv);
        }
        int i11 = bVar.axw;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkFailedReason", i11);
        }
        int i12 = bVar.downloadSource;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadSource", i12);
        }
        int i13 = bVar.axx;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isPackageChanged", i13);
        }
        String str5 = bVar.axy;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installedFrom", bVar.axy);
        }
        String str6 = bVar.axz;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadFailedReason", bVar.axz);
        }
        int i14 = bVar.axA;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isChangedEndcard", i14);
        }
        int i15 = bVar.avQ;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adAggPageSource", i15);
        }
        String str7 = bVar.axB;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "serverPackageName", bVar.axB);
        }
        String str8 = bVar.axC;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installedPackageName", bVar.axC);
        }
        int i16 = bVar.axD;
        if (i16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeButtonImpressionTime", i16);
        }
        int i17 = bVar.axE;
        if (i17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeButtonClickTime", i17);
        }
        long j3 = bVar.axF;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "landingPageLoadedDuration", j3);
        }
        long j4 = bVar.Lc;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "leaveTime", j4);
        }
        long j5 = bVar.axG;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adItemClickBackDuration", j5);
        }
        int i18 = bVar.axH;
        if (i18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appStorePageType", i18);
        }
        int i19 = bVar.axI;
        if (i19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installStatus", i19);
        }
        int i20 = bVar.downloadStatus;
        if (i20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadStatus", i20);
        }
        int i21 = bVar.axJ;
        if (i21 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadCardType", i21);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "clientExtData", bVar.axK);
        int i22 = bVar.Od;
        if (i22 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "landingPageType", i22);
        }
        long j6 = bVar.vy;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playedDuration", j6);
        }
        int i23 = bVar.axL;
        if (i23 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playedRate", i23);
        }
        int i24 = bVar.axM;
        if (i24 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adOrder", i24);
        }
        int i25 = bVar.axN;
        if (i25 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adInterstitialSource", i25);
        }
        double d = bVar.kn;
        if (d != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "splashShakeAcceleration", d);
        }
        String str9 = bVar.axO;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "splashInteractionRotateAngle", bVar.axO);
        }
        int i26 = bVar.axP;
        if (i26 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadInstallType", i26);
        }
        int i27 = bVar.axQ;
        if (i27 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "businessSceneType", i27);
        }
        int i28 = bVar.adxResult;
        if (i28 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adxResult", i28);
        }
        int i29 = bVar.axR;
        if (i29 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fingerSwipeType", i29);
        }
        int i30 = bVar.axS;
        if (i30 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fingerSwipeDistance", i30);
        }
        int i31 = bVar.axT;
        if (i31 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "triggerType", i31);
        }
        int i32 = bVar.axU;
        if (i32 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardCloseType", i32);
        }
        String str10 = bVar.axV;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clientPkFailAdInfo", bVar.axV);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(y.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(y.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
