package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.report.o;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class k implements com.kwad.sdk.core.c<o.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(o.a aVar) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "photoPlaySecond", aVar.f9728a);
        com.kwad.sdk.utils.o.a(jSONObject, "itemClickType", aVar.f9729b);
        com.kwad.sdk.utils.o.a(jSONObject, "itemCloseType", aVar.c);
        com.kwad.sdk.utils.o.a(jSONObject, "elementType", aVar.d);
        com.kwad.sdk.utils.o.a(jSONObject, "payload", aVar.f);
        com.kwad.sdk.utils.o.a(jSONObject, "deeplinkType", aVar.g);
        com.kwad.sdk.utils.o.a(jSONObject, "downloadSource", aVar.h);
        com.kwad.sdk.utils.o.a(jSONObject, "isPackageChanged", aVar.i);
        com.kwad.sdk.utils.o.a(jSONObject, "installedFrom", aVar.j);
        com.kwad.sdk.utils.o.a(jSONObject, "downloadFailedReason", aVar.k);
        com.kwad.sdk.utils.o.a(jSONObject, "isChangedEndcard", aVar.l);
        com.kwad.sdk.utils.o.a(jSONObject, "serverPackageName", aVar.m);
        com.kwad.sdk.utils.o.a(jSONObject, "installedPackageName", aVar.n);
        com.kwad.sdk.utils.o.a(jSONObject, "closeButtonImpressionTime", aVar.o);
        com.kwad.sdk.utils.o.a(jSONObject, "closeButtonClickTime", aVar.p);
        com.kwad.sdk.utils.o.a(jSONObject, "downloadStatus", aVar.q);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(o.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f9728a = jSONObject.optInt("photoPlaySecond");
        aVar.f9729b = jSONObject.optInt("itemClickType");
        aVar.c = jSONObject.optInt("itemCloseType");
        aVar.d = jSONObject.optInt("elementType");
        aVar.f = jSONObject.optString("payload");
        aVar.g = jSONObject.optInt("deeplinkType");
        aVar.h = jSONObject.optInt("downloadSource");
        aVar.i = jSONObject.optInt("isPackageChanged");
        aVar.j = jSONObject.optString("installedFrom");
        aVar.k = jSONObject.optString("downloadFailedReason");
        aVar.l = jSONObject.optInt("isChangedEndcard");
        aVar.m = jSONObject.optString("serverPackageName");
        aVar.n = jSONObject.optString("installedPackageName");
        aVar.o = jSONObject.optInt("closeButtonImpressionTime");
        aVar.p = jSONObject.optInt("closeButtonClickTime");
        aVar.q = jSONObject.optInt("downloadStatus");
    }
}
