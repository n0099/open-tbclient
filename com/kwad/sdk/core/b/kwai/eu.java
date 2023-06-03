package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class eu implements com.kwad.sdk.core.d<SceneImpl> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        URLPackage uRLPackage = new URLPackage();
        sceneImpl.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        sceneImpl.posId = jSONObject.optLong("posId");
        sceneImpl.entryScene = jSONObject.optLong("entryScene");
        sceneImpl.adNum = jSONObject.optInt("adNum");
        sceneImpl.action = jSONObject.optInt("action");
        sceneImpl.width = jSONObject.optInt("width");
        sceneImpl.height = jSONObject.optInt("height");
        sceneImpl.adStyle = jSONObject.optInt("adStyle");
        sceneImpl.screenOrientation = jSONObject.optInt("screenOrientation");
        sceneImpl.needShowMiniWindow = jSONObject.optBoolean("needShowMiniWindow");
        sceneImpl.backUrl = jSONObject.optString("backUrl");
        if (jSONObject.opt("backUrl") == JSONObject.NULL) {
            sceneImpl.backUrl = "";
        }
        sceneImpl.bidResponse = jSONObject.optString("bidResponse");
        if (jSONObject.opt("bidResponse") == JSONObject.NULL) {
            sceneImpl.bidResponse = "";
        }
        sceneImpl.bidResponseV2 = jSONObject.optString("bidResponseV2");
        if (jSONObject.opt("bidResponseV2") == JSONObject.NULL) {
            sceneImpl.bidResponseV2 = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "urlPackage", sceneImpl.urlPackage);
        long j = sceneImpl.posId;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "posId", j);
        }
        long j2 = sceneImpl.entryScene;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "entryScene", j2);
        }
        int i = sceneImpl.adNum;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adNum", i);
        }
        int i2 = sceneImpl.action;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "action", i2);
        }
        int i3 = sceneImpl.width;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "width", i3);
        }
        int i4 = sceneImpl.height;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "height", i4);
        }
        int i5 = sceneImpl.adStyle;
        if (i5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adStyle", i5);
        }
        int i6 = sceneImpl.screenOrientation;
        if (i6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "screenOrientation", i6);
        }
        boolean z = sceneImpl.needShowMiniWindow;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "needShowMiniWindow", z);
        }
        String str = sceneImpl.backUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "backUrl", sceneImpl.backUrl);
        }
        String str2 = sceneImpl.bidResponse;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "bidResponse", sceneImpl.bidResponse);
        }
        String str3 = sceneImpl.bidResponseV2;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "bidResponseV2", sceneImpl.bidResponseV2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SceneImpl sceneImpl, JSONObject jSONObject) {
        a2(sceneImpl, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SceneImpl sceneImpl, JSONObject jSONObject) {
        return b2(sceneImpl, jSONObject);
    }
}
