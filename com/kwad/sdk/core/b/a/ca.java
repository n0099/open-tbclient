package com.kwad.sdk.core.b.a;

import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.kwad.components.ad.reward.h;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ca implements com.kwad.sdk.core.d<h.c> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.style = jSONObject.optInt("style");
        cVar.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(cVar.title)) {
            cVar.title = "";
        }
        cVar.pV = jSONObject.optString("closeBtnText");
        if (JSONObject.NULL.toString().equals(cVar.pV)) {
            cVar.pV = "";
        }
        cVar.pW = jSONObject.optString("continueBtnText");
        if (JSONObject.NULL.toString().equals(cVar.pW)) {
            cVar.pW = "";
        }
        cVar.pX = jSONObject.optString("viewDetailText");
        if (JSONObject.NULL.toString().equals(cVar.pX)) {
            cVar.pX = "";
        }
        cVar.pY = jSONObject.optString("unWatchedVideoTime");
        if (JSONObject.NULL.toString().equals(cVar.pY)) {
            cVar.pY = "";
        }
        cVar.pZ = jSONObject.optString(GameAssistConstKt.KEY_ICONURL);
        if (JSONObject.NULL.toString().equals(cVar.pZ)) {
            cVar.pZ = "";
        }
        cVar.qa = jSONObject.optString("desc");
        if (JSONObject.NULL.toString().equals(cVar.qa)) {
            cVar.qa = "";
        }
        cVar.qb = jSONObject.optString("descTxt");
        if (JSONObject.NULL.toString().equals(cVar.qb)) {
            cVar.qb = "";
        }
        cVar.qc = jSONObject.optString("currentPlayTime");
        if (JSONObject.NULL.toString().equals(cVar.qc)) {
            cVar.qc = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = cVar.style;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "style", i);
        }
        String str = cVar.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", cVar.title);
        }
        String str2 = cVar.pV;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeBtnText", cVar.pV);
        }
        String str3 = cVar.pW;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "continueBtnText", cVar.pW);
        }
        String str4 = cVar.pX;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "viewDetailText", cVar.pX);
        }
        String str5 = cVar.pY;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "unWatchedVideoTime", cVar.pY);
        }
        String str6 = cVar.pZ;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, GameAssistConstKt.KEY_ICONURL, cVar.pZ);
        }
        String str7 = cVar.qa;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "desc", cVar.qa);
        }
        String str8 = cVar.qb;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "descTxt", cVar.qb);
        }
        String str9 = cVar.qc;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentPlayTime", cVar.qc);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
