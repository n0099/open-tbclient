package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.u;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class as implements com.kwad.sdk.core.d<u.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(u.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optInt("photoPlaySecond");
        bVar.b = jSONObject.optInt("awardReceiveStage");
        bVar.c = jSONObject.optInt("itemClickType");
        bVar.d = jSONObject.optInt("itemCloseType");
        bVar.e = jSONObject.optInt("elementType");
        bVar.f = jSONObject.optInt("impFailReason");
        bVar.g = jSONObject.optInt("winEcpm");
        bVar.h = jSONObject.optInt("retainCodeType");
        bVar.j = jSONObject.optString("payload");
        if (jSONObject.opt("payload") == JSONObject.NULL) {
            bVar.j = "";
        }
        bVar.k = jSONObject.optInt("deeplinkType");
        bVar.l = jSONObject.optInt("downloadSource");
        bVar.m = jSONObject.optInt("isPackageChanged");
        bVar.n = jSONObject.optString("installedFrom");
        if (jSONObject.opt("installedFrom") == JSONObject.NULL) {
            bVar.n = "";
        }
        bVar.o = jSONObject.optString("downloadFailedReason");
        if (jSONObject.opt("downloadFailedReason") == JSONObject.NULL) {
            bVar.o = "";
        }
        bVar.p = jSONObject.optInt("isChangedEndcard");
        bVar.q = jSONObject.optInt("adAggPageSource");
        bVar.r = jSONObject.optString("serverPackageName");
        if (jSONObject.opt("serverPackageName") == JSONObject.NULL) {
            bVar.r = "";
        }
        bVar.s = jSONObject.optString("installedPackageName");
        if (jSONObject.opt("installedPackageName") == JSONObject.NULL) {
            bVar.s = "";
        }
        bVar.t = jSONObject.optInt("closeButtonImpressionTime");
        bVar.u = jSONObject.optInt("closeButtonClickTime");
        bVar.v = jSONObject.optLong("landingPageLoadedDuration");
        bVar.w = jSONObject.optLong("leaveTime");
        bVar.x = jSONObject.optInt("appStorePageType");
        bVar.y = jSONObject.optInt("installStatus");
        bVar.z = jSONObject.optInt("downloadStatus");
        bVar.A = jSONObject.optInt("downloadCardType");
        u.a aVar = new u.a();
        bVar.B = aVar;
        aVar.parseJson(jSONObject.optJSONObject("clientExtData"));
        bVar.C = jSONObject.optInt("landingPageType");
        bVar.D = jSONObject.optLong("playedDuration");
        bVar.E = jSONObject.optInt("playedRate");
        bVar.F = jSONObject.optInt("adOrder");
        bVar.G = jSONObject.optInt("adInterstitialSource");
        bVar.H = jSONObject.optDouble("splashShakeAcceleration");
        bVar.I = jSONObject.optInt("universeSecondAd");
        bVar.J = jSONObject.optString("splashInteractionRotateAngle");
        if (jSONObject.opt("splashInteractionRotateAngle") == JSONObject.NULL) {
            bVar.J = "";
        }
        bVar.K = jSONObject.optInt("downloadInstallType");
        bVar.L = jSONObject.optInt("businessSceneType");
        bVar.M = jSONObject.optInt("adxResult");
        bVar.N = jSONObject.optInt("fingerSwipeType");
        bVar.O = jSONObject.optInt("fingerSwipeDistance");
        bVar.P = jSONObject.optInt("triggerType");
        bVar.Q = jSONObject.optString("clientPkFailAdInfo");
        if (jSONObject.opt("clientPkFailAdInfo") == JSONObject.NULL) {
            bVar.Q = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(u.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "photoPlaySecond", bVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "awardReceiveStage", bVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "itemClickType", bVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, "itemCloseType", bVar.d);
        com.kwad.sdk.utils.r.a(jSONObject, "elementType", bVar.e);
        com.kwad.sdk.utils.r.a(jSONObject, "impFailReason", bVar.f);
        com.kwad.sdk.utils.r.a(jSONObject, "winEcpm", bVar.g);
        com.kwad.sdk.utils.r.a(jSONObject, "retainCodeType", bVar.h);
        com.kwad.sdk.utils.r.a(jSONObject, "payload", bVar.j);
        com.kwad.sdk.utils.r.a(jSONObject, "deeplinkType", bVar.k);
        com.kwad.sdk.utils.r.a(jSONObject, "downloadSource", bVar.l);
        com.kwad.sdk.utils.r.a(jSONObject, "isPackageChanged", bVar.m);
        com.kwad.sdk.utils.r.a(jSONObject, "installedFrom", bVar.n);
        com.kwad.sdk.utils.r.a(jSONObject, "downloadFailedReason", bVar.o);
        com.kwad.sdk.utils.r.a(jSONObject, "isChangedEndcard", bVar.p);
        com.kwad.sdk.utils.r.a(jSONObject, "adAggPageSource", bVar.q);
        com.kwad.sdk.utils.r.a(jSONObject, "serverPackageName", bVar.r);
        com.kwad.sdk.utils.r.a(jSONObject, "installedPackageName", bVar.s);
        com.kwad.sdk.utils.r.a(jSONObject, "closeButtonImpressionTime", bVar.t);
        com.kwad.sdk.utils.r.a(jSONObject, "closeButtonClickTime", bVar.u);
        com.kwad.sdk.utils.r.a(jSONObject, "landingPageLoadedDuration", bVar.v);
        com.kwad.sdk.utils.r.a(jSONObject, "leaveTime", bVar.w);
        com.kwad.sdk.utils.r.a(jSONObject, "appStorePageType", bVar.x);
        com.kwad.sdk.utils.r.a(jSONObject, "installStatus", bVar.y);
        com.kwad.sdk.utils.r.a(jSONObject, "downloadStatus", bVar.z);
        com.kwad.sdk.utils.r.a(jSONObject, "downloadCardType", bVar.A);
        com.kwad.sdk.utils.r.a(jSONObject, "clientExtData", bVar.B);
        com.kwad.sdk.utils.r.a(jSONObject, "landingPageType", bVar.C);
        com.kwad.sdk.utils.r.a(jSONObject, "playedDuration", bVar.D);
        com.kwad.sdk.utils.r.a(jSONObject, "playedRate", bVar.E);
        com.kwad.sdk.utils.r.a(jSONObject, "adOrder", bVar.F);
        com.kwad.sdk.utils.r.a(jSONObject, "adInterstitialSource", bVar.G);
        com.kwad.sdk.utils.r.a(jSONObject, "splashShakeAcceleration", bVar.H);
        com.kwad.sdk.utils.r.a(jSONObject, "universeSecondAd", bVar.I);
        com.kwad.sdk.utils.r.a(jSONObject, "splashInteractionRotateAngle", bVar.J);
        com.kwad.sdk.utils.r.a(jSONObject, "downloadInstallType", bVar.K);
        com.kwad.sdk.utils.r.a(jSONObject, "businessSceneType", bVar.L);
        com.kwad.sdk.utils.r.a(jSONObject, "adxResult", bVar.M);
        com.kwad.sdk.utils.r.a(jSONObject, "fingerSwipeType", bVar.N);
        com.kwad.sdk.utils.r.a(jSONObject, "fingerSwipeDistance", bVar.O);
        com.kwad.sdk.utils.r.a(jSONObject, "triggerType", bVar.P);
        com.kwad.sdk.utils.r.a(jSONObject, "clientPkFailAdInfo", bVar.Q);
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
