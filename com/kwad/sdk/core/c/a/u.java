package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.report.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class u implements com.kwad.sdk.core.c<o.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(o.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f32672a = jSONObject.optInt("photoPlaySecond");
        aVar.f32673b = jSONObject.optInt("itemClickType");
        aVar.f32674c = jSONObject.optInt("itemCloseType");
        aVar.f32675d = jSONObject.optInt("elementType");
        aVar.f32677f = jSONObject.optString("payload");
        aVar.f32678g = jSONObject.optInt("deeplinkType");
        aVar.f32679h = jSONObject.optInt("downloadSource");
        aVar.f32680i = jSONObject.optInt("isPackageChanged");
        aVar.j = jSONObject.optString("installedFrom");
        aVar.k = jSONObject.optString("downloadFailedReason");
        aVar.l = jSONObject.optInt("isChangedEndcard");
        aVar.m = jSONObject.optString("serverPackageName");
        aVar.n = jSONObject.optString("installedPackageName");
        aVar.o = jSONObject.optInt("closeButtonImpressionTime");
        aVar.p = jSONObject.optInt("closeButtonClickTime");
        aVar.q = jSONObject.optLong("landingPageLoadedDuration");
        aVar.r = jSONObject.optInt("downloadStatus");
        aVar.s = jSONObject.optInt("downloadCardType");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(o.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "photoPlaySecond", aVar.f32672a);
        com.kwad.sdk.utils.o.a(jSONObject, "itemClickType", aVar.f32673b);
        com.kwad.sdk.utils.o.a(jSONObject, "itemCloseType", aVar.f32674c);
        com.kwad.sdk.utils.o.a(jSONObject, "elementType", aVar.f32675d);
        com.kwad.sdk.utils.o.a(jSONObject, "payload", aVar.f32677f);
        com.kwad.sdk.utils.o.a(jSONObject, "deeplinkType", aVar.f32678g);
        com.kwad.sdk.utils.o.a(jSONObject, "downloadSource", aVar.f32679h);
        com.kwad.sdk.utils.o.a(jSONObject, "isPackageChanged", aVar.f32680i);
        com.kwad.sdk.utils.o.a(jSONObject, "installedFrom", aVar.j);
        com.kwad.sdk.utils.o.a(jSONObject, "downloadFailedReason", aVar.k);
        com.kwad.sdk.utils.o.a(jSONObject, "isChangedEndcard", aVar.l);
        com.kwad.sdk.utils.o.a(jSONObject, "serverPackageName", aVar.m);
        com.kwad.sdk.utils.o.a(jSONObject, "installedPackageName", aVar.n);
        com.kwad.sdk.utils.o.a(jSONObject, "closeButtonImpressionTime", aVar.o);
        com.kwad.sdk.utils.o.a(jSONObject, "closeButtonClickTime", aVar.p);
        com.kwad.sdk.utils.o.a(jSONObject, "landingPageLoadedDuration", aVar.q);
        com.kwad.sdk.utils.o.a(jSONObject, "downloadStatus", aVar.r);
        com.kwad.sdk.utils.o.a(jSONObject, "downloadCardType", aVar.s);
        return jSONObject;
    }
}
