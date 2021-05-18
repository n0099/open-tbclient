package com.kwad.sdk.internal.api;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class SceneImpl extends com.kwad.sdk.core.response.a.a implements KsScene, Serializable {
    public static final long serialVersionUID = 93865491903408451L;
    public int action;
    public int adNum;
    public int adStyle;
    public long entryScene;
    public int height;
    public long posId;
    public Map<String, String> rewardCallbackExtraData;
    public int screenOrientation;
    public URLPackage urlPackage;
    public int width;

    public SceneImpl() {
        this.adNum = 1;
        this.screenOrientation = 0;
    }

    public SceneImpl(long j) {
        this.adNum = 1;
        this.screenOrientation = 0;
        this.posId = j;
        this.entryScene = j;
    }

    public SceneImpl(KsScene ksScene) {
        this.adNum = 1;
        this.screenOrientation = 0;
        this.posId = ksScene.getPosId();
        this.entryScene = ksScene.getPosId();
        this.adNum = ksScene.getAdNum();
        this.action = ksScene.getAction();
        this.width = ksScene.getWidth();
        this.height = ksScene.getHeight();
        this.adStyle = ksScene.getAdStyle();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.rewardCallbackExtraData = o.b(jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA));
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        o.a(jSONObject, PrefetchEvent.EVENT_DATA_EXTRA_DATA, o.a(this.rewardCallbackExtraData));
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAction() {
        return this.action;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAdNum() {
        return this.adNum;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAdStyle() {
        return this.adStyle;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getHeight() {
        return this.height;
    }

    public int getPageScene() {
        URLPackage uRLPackage = this.urlPackage;
        if (uRLPackage == null) {
            return 0;
        }
        return uRLPackage.page;
    }

    @Override // com.kwad.sdk.api.KsScene
    public long getPosId() {
        return this.posId;
    }

    @Override // com.kwad.sdk.api.KsScene
    public Map<String, String> getRewardCallbackExtraData() {
        return this.rewardCallbackExtraData;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getScreenOrientation() {
        return this.screenOrientation;
    }

    public URLPackage getUrlPackage() {
        return this.urlPackage;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getWidth() {
        return this.width;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAction(int i2) {
        this.action = i2;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdNum(int i2) {
        this.adNum = i2;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdStyle(int i2) {
        this.adStyle = i2;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setHeight(int i2) {
        this.height = i2;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setPosId(long j) {
        this.posId = j;
        this.entryScene = j;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setRewardCallbackExtraData(Map<String, String> map) {
        this.rewardCallbackExtraData = map;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setScreenOrientation(int i2) {
        this.screenOrientation = i2;
    }

    public void setUrlPackage(URLPackage uRLPackage) {
        this.urlPackage = uRLPackage;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setWidth(int i2) {
        this.width = i2;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "posId", this.posId);
        o.a(jSONObject, "entryScene", this.entryScene);
        o.a(jSONObject, "adNum", this.adNum);
        o.a(jSONObject, "action", this.action);
        o.a(jSONObject, "width", this.width);
        o.a(jSONObject, "height", this.height);
        o.a(jSONObject, "adStyle", this.adStyle);
        o.a(jSONObject, "urlPackage", this.urlPackage);
        o.a(jSONObject, "screenOrientation", this.screenOrientation);
        return jSONObject;
    }
}
