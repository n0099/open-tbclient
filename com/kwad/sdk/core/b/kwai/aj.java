package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.p;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class aj implements com.kwad.sdk.core.d<p.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(p.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("photoPlaySecond");
        aVar.b = jSONObject.optInt("itemClickType");
        aVar.c = jSONObject.optInt("itemCloseType");
        aVar.d = jSONObject.optInt("elementType");
        aVar.e = jSONObject.optInt("impFailReason");
        aVar.f = jSONObject.optInt("winEcpm");
        aVar.h = jSONObject.optString("payload");
        if (jSONObject.opt("payload") == JSONObject.NULL) {
            aVar.h = "";
        }
        aVar.i = jSONObject.optInt("deeplinkType");
        aVar.j = jSONObject.optInt("downloadSource");
        aVar.k = jSONObject.optInt("isPackageChanged");
        aVar.l = jSONObject.optString("installedFrom");
        if (jSONObject.opt("installedFrom") == JSONObject.NULL) {
            aVar.l = "";
        }
        aVar.m = jSONObject.optString("downloadFailedReason");
        if (jSONObject.opt("downloadFailedReason") == JSONObject.NULL) {
            aVar.m = "";
        }
        aVar.n = jSONObject.optInt("isChangedEndcard");
        aVar.o = jSONObject.optInt("adAggPageSource");
        aVar.p = jSONObject.optString("serverPackageName");
        if (jSONObject.opt("serverPackageName") == JSONObject.NULL) {
            aVar.p = "";
        }
        aVar.q = jSONObject.optString("installedPackageName");
        if (jSONObject.opt("installedPackageName") == JSONObject.NULL) {
            aVar.q = "";
        }
        aVar.r = jSONObject.optInt("closeButtonImpressionTime");
        aVar.s = jSONObject.optInt("closeButtonClickTime");
        aVar.t = jSONObject.optLong("landingPageLoadedDuration");
        aVar.u = jSONObject.optInt("downloadStatus");
        aVar.v = jSONObject.optInt("downloadCardType");
        aVar.w = jSONObject.optInt("landingPageType");
        aVar.x = jSONObject.optLong("playedDuration");
        aVar.y = jSONObject.optInt("playedRate");
        aVar.z = jSONObject.optInt("adOrder");
        aVar.A = jSONObject.optInt("adInterstitialSource");
        aVar.B = jSONObject.optDouble("splashShakeAcceleration");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(p.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "photoPlaySecond", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "itemClickType", aVar.b);
        com.kwad.sdk.utils.t.a(jSONObject, "itemCloseType", aVar.c);
        com.kwad.sdk.utils.t.a(jSONObject, "elementType", aVar.d);
        com.kwad.sdk.utils.t.a(jSONObject, "impFailReason", aVar.e);
        com.kwad.sdk.utils.t.a(jSONObject, "winEcpm", aVar.f);
        com.kwad.sdk.utils.t.a(jSONObject, "payload", aVar.h);
        com.kwad.sdk.utils.t.a(jSONObject, "deeplinkType", aVar.i);
        com.kwad.sdk.utils.t.a(jSONObject, "downloadSource", aVar.j);
        com.kwad.sdk.utils.t.a(jSONObject, "isPackageChanged", aVar.k);
        com.kwad.sdk.utils.t.a(jSONObject, "installedFrom", aVar.l);
        com.kwad.sdk.utils.t.a(jSONObject, "downloadFailedReason", aVar.m);
        com.kwad.sdk.utils.t.a(jSONObject, "isChangedEndcard", aVar.n);
        com.kwad.sdk.utils.t.a(jSONObject, "adAggPageSource", aVar.o);
        com.kwad.sdk.utils.t.a(jSONObject, "serverPackageName", aVar.p);
        com.kwad.sdk.utils.t.a(jSONObject, "installedPackageName", aVar.q);
        com.kwad.sdk.utils.t.a(jSONObject, "closeButtonImpressionTime", aVar.r);
        com.kwad.sdk.utils.t.a(jSONObject, "closeButtonClickTime", aVar.s);
        com.kwad.sdk.utils.t.a(jSONObject, "landingPageLoadedDuration", aVar.t);
        com.kwad.sdk.utils.t.a(jSONObject, "downloadStatus", aVar.u);
        com.kwad.sdk.utils.t.a(jSONObject, "downloadCardType", aVar.v);
        com.kwad.sdk.utils.t.a(jSONObject, "landingPageType", aVar.w);
        com.kwad.sdk.utils.t.a(jSONObject, "playedDuration", aVar.x);
        com.kwad.sdk.utils.t.a(jSONObject, "playedRate", aVar.y);
        com.kwad.sdk.utils.t.a(jSONObject, "adOrder", aVar.z);
        com.kwad.sdk.utils.t.a(jSONObject, "adInterstitialSource", aVar.A);
        com.kwad.sdk.utils.t.a(jSONObject, "splashShakeAcceleration", aVar.B);
        return jSONObject;
    }
}
