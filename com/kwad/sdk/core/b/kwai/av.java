package com.kwad.sdk.core.b.kwai;

import com.kwad.components.ad.reward.m;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class av implements com.kwad.sdk.core.d<m.c> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(m.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.a = jSONObject.optInt("style");
        cVar.b = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            cVar.b = "";
        }
        cVar.c = jSONObject.optString("closeBtnText");
        if (jSONObject.opt("closeBtnText") == JSONObject.NULL) {
            cVar.c = "";
        }
        cVar.d = jSONObject.optString("continueBtnText");
        if (jSONObject.opt("continueBtnText") == JSONObject.NULL) {
            cVar.d = "";
        }
        cVar.e = jSONObject.optString("unWatchedVideoTime");
        if (jSONObject.opt("unWatchedVideoTime") == JSONObject.NULL) {
            cVar.e = "";
        }
        cVar.h = jSONObject.optString("iconUrl");
        if (jSONObject.opt("iconUrl") == JSONObject.NULL) {
            cVar.h = "";
        }
        cVar.i = jSONObject.optString("desc");
        if (jSONObject.opt("desc") == JSONObject.NULL) {
            cVar.i = "";
        }
        cVar.j = jSONObject.optString("currentPlayTime");
        if (jSONObject.opt("currentPlayTime") == JSONObject.NULL) {
            cVar.j = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(m.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "style", cVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "title", cVar.b);
        com.kwad.sdk.utils.r.a(jSONObject, "closeBtnText", cVar.c);
        com.kwad.sdk.utils.r.a(jSONObject, "continueBtnText", cVar.d);
        com.kwad.sdk.utils.r.a(jSONObject, "unWatchedVideoTime", cVar.e);
        com.kwad.sdk.utils.r.a(jSONObject, "iconUrl", cVar.h);
        com.kwad.sdk.utils.r.a(jSONObject, "desc", cVar.i);
        com.kwad.sdk.utils.r.a(jSONObject, "currentPlayTime", cVar.j);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(m.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(m.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
