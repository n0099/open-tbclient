package com.kwad.sdk.core.b.kwai;

import com.kwad.components.ad.reward.l;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class aw implements com.kwad.sdk.core.d {
    public static void a(l.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.style = jSONObject.optInt("style");
        cVar.title = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            cVar.title = "";
        }
        cVar.nm = jSONObject.optString("closeBtnText");
        if (jSONObject.opt("closeBtnText") == JSONObject.NULL) {
            cVar.nm = "";
        }
        cVar.nn = jSONObject.optString("continueBtnText");
        if (jSONObject.opt("continueBtnText") == JSONObject.NULL) {
            cVar.nn = "";
        }
        cVar.no = jSONObject.optString("unWatchedVideoTime");
        if (jSONObject.opt("unWatchedVideoTime") == JSONObject.NULL) {
            cVar.no = "";
        }
        cVar.kY = jSONObject.optString("iconUrl");
        if (jSONObject.opt("iconUrl") == JSONObject.NULL) {
            cVar.kY = "";
        }
        cVar.np = jSONObject.optString("desc");
        if (jSONObject.opt("desc") == JSONObject.NULL) {
            cVar.np = "";
        }
        cVar.nq = jSONObject.optString("currentPlayTime");
        if (jSONObject.opt("currentPlayTime") == JSONObject.NULL) {
            cVar.nq = "";
        }
    }

    public static JSONObject b(l.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = cVar.style;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "style", i);
        }
        String str = cVar.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "title", cVar.title);
        }
        String str2 = cVar.nm;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "closeBtnText", cVar.nm);
        }
        String str3 = cVar.nn;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "continueBtnText", cVar.nn);
        }
        String str4 = cVar.no;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "unWatchedVideoTime", cVar.no);
        }
        String str5 = cVar.kY;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "iconUrl", cVar.kY);
        }
        String str6 = cVar.np;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "desc", cVar.np);
        }
        String str7 = cVar.nq;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "currentPlayTime", cVar.nq);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((l.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((l.c) bVar, jSONObject);
    }
}
