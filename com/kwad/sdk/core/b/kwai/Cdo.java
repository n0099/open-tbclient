package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import org.json.JSONObject;
/* renamed from: com.kwad.sdk.core.b.kwai.do  reason: invalid class name */
/* loaded from: classes5.dex */
public class Cdo implements com.kwad.sdk.core.d<SceneImpl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(SceneImpl sceneImpl, JSONObject jSONObject) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "urlPackage", sceneImpl.urlPackage);
        com.kwad.sdk.utils.t.a(jSONObject, "posId", sceneImpl.posId);
        com.kwad.sdk.utils.t.a(jSONObject, "entryScene", sceneImpl.entryScene);
        com.kwad.sdk.utils.t.a(jSONObject, "adNum", sceneImpl.adNum);
        com.kwad.sdk.utils.t.a(jSONObject, "action", sceneImpl.action);
        com.kwad.sdk.utils.t.a(jSONObject, "width", sceneImpl.width);
        com.kwad.sdk.utils.t.a(jSONObject, "height", sceneImpl.height);
        com.kwad.sdk.utils.t.a(jSONObject, "adStyle", sceneImpl.adStyle);
        com.kwad.sdk.utils.t.a(jSONObject, "screenOrientation", sceneImpl.screenOrientation);
        com.kwad.sdk.utils.t.a(jSONObject, "needShowMiniWindow", sceneImpl.needShowMiniWindow);
        com.kwad.sdk.utils.t.a(jSONObject, "backUrl", sceneImpl.backUrl);
        return jSONObject;
    }
}
