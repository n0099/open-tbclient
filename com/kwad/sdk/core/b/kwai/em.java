package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class em implements com.kwad.sdk.core.d<SceneImpl> {
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
        com.kwad.sdk.utils.r.a(jSONObject, "posId", sceneImpl.posId);
        com.kwad.sdk.utils.r.a(jSONObject, "entryScene", sceneImpl.entryScene);
        com.kwad.sdk.utils.r.a(jSONObject, "adNum", sceneImpl.adNum);
        com.kwad.sdk.utils.r.a(jSONObject, "action", sceneImpl.action);
        com.kwad.sdk.utils.r.a(jSONObject, "width", sceneImpl.width);
        com.kwad.sdk.utils.r.a(jSONObject, "height", sceneImpl.height);
        com.kwad.sdk.utils.r.a(jSONObject, "adStyle", sceneImpl.adStyle);
        com.kwad.sdk.utils.r.a(jSONObject, "screenOrientation", sceneImpl.screenOrientation);
        com.kwad.sdk.utils.r.a(jSONObject, "needShowMiniWindow", sceneImpl.needShowMiniWindow);
        com.kwad.sdk.utils.r.a(jSONObject, "backUrl", sceneImpl.backUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "bidResponse", sceneImpl.bidResponse);
        com.kwad.sdk.utils.r.a(jSONObject, "bidResponseV2", sceneImpl.bidResponseV2);
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
