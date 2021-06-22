package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.report.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k implements com.kwad.sdk.core.c<o.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(o.a aVar) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "photoPlaySecond", aVar.f34790a);
        com.kwad.sdk.utils.o.a(jSONObject, "itemClickType", aVar.f34791b);
        com.kwad.sdk.utils.o.a(jSONObject, "itemCloseType", aVar.f34792c);
        com.kwad.sdk.utils.o.a(jSONObject, "elementType", aVar.f34793d);
        com.kwad.sdk.utils.o.a(jSONObject, "payload", aVar.f34795f);
        com.kwad.sdk.utils.o.a(jSONObject, "deeplinkType", aVar.f34796g);
        com.kwad.sdk.utils.o.a(jSONObject, "downloadSource", aVar.f34797h);
        com.kwad.sdk.utils.o.a(jSONObject, "isPackageChanged", aVar.f34798i);
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
        aVar.f34790a = jSONObject.optInt("photoPlaySecond");
        aVar.f34791b = jSONObject.optInt("itemClickType");
        aVar.f34792c = jSONObject.optInt("itemCloseType");
        aVar.f34793d = jSONObject.optInt("elementType");
        aVar.f34795f = jSONObject.optString("payload");
        aVar.f34796g = jSONObject.optInt("deeplinkType");
        aVar.f34797h = jSONObject.optInt("downloadSource");
        aVar.f34798i = jSONObject.optInt("isPackageChanged");
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
