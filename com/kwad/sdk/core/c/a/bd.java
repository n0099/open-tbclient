package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class bd implements com.kwad.sdk.core.c<SceneImpl> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(SceneImpl sceneImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "urlPackage", sceneImpl.urlPackage);
        com.kwad.sdk.utils.o.a(jSONObject, "posId", sceneImpl.posId);
        com.kwad.sdk.utils.o.a(jSONObject, "entryScene", sceneImpl.entryScene);
        com.kwad.sdk.utils.o.a(jSONObject, "adNum", sceneImpl.adNum);
        com.kwad.sdk.utils.o.a(jSONObject, "action", sceneImpl.action);
        com.kwad.sdk.utils.o.a(jSONObject, "width", sceneImpl.width);
        com.kwad.sdk.utils.o.a(jSONObject, "height", sceneImpl.height);
        com.kwad.sdk.utils.o.a(jSONObject, "adStyle", sceneImpl.adStyle);
        com.kwad.sdk.utils.o.a(jSONObject, "screenOrientation", sceneImpl.screenOrientation);
        return jSONObject;
    }
}
