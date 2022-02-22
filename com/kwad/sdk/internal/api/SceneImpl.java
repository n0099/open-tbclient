package com.kwad.sdk.internal.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SceneImpl extends com.kwad.sdk.core.response.kwai.a implements KsScene, Serializable, Cloneable {
    public static final long serialVersionUID = 93865491903408451L;
    public int action;
    public int adNum;
    public int adStyle;
    public String backUrl;
    public long entryScene;
    public int height;
    public final EcAttribute mEcAttribute;
    public transient a mKsAdLabel;
    public boolean needShowMiniWindow;
    public long posId;
    public Map<String, String> rewardCallbackExtraData;
    public int screenOrientation;
    public URLPackage urlPackage;
    public int width;

    public SceneImpl() {
        this.adNum = 1;
        this.screenOrientation = 0;
        this.needShowMiniWindow = false;
        this.mEcAttribute = new EcAttribute();
    }

    public SceneImpl(long j2) {
        this.adNum = 1;
        this.screenOrientation = 0;
        this.needShowMiniWindow = false;
        this.mEcAttribute = new EcAttribute();
        this.posId = j2;
        this.entryScene = j2;
    }

    public SceneImpl(KsScene ksScene) {
        this.adNum = 1;
        this.screenOrientation = 0;
        this.needShowMiniWindow = false;
        this.mEcAttribute = new EcAttribute();
        this.posId = ksScene.getPosId();
        this.entryScene = ksScene.getPosId();
        this.adNum = ksScene.getAdNum();
        this.action = ksScene.getAction();
        this.width = ksScene.getWidth();
        this.height = ksScene.getHeight();
        this.adStyle = ksScene.getAdStyle();
        this.mEcAttribute.setPromoteId(getPromoteId(ksScene));
        this.mEcAttribute.setComment(getComment(ksScene));
        this.backUrl = getBackUrl(ksScene);
        this.mEcAttribute.setUserCommRateBuying(getUserCommRateBuying(ksScene));
        this.mEcAttribute.setUserCommRateSharing(getUserCommRateSharing(ksScene));
    }

    private String getComment(KsScene ksScene) {
        if (ksScene == null) {
            return "";
        }
        try {
            return ksScene.getComment();
        } catch (Throwable unused) {
            return "";
        }
    }

    private String getPromoteId(KsScene ksScene) {
        if (ksScene == null) {
            return "";
        }
        try {
            return ksScene.getPromoteId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.rewardCallbackExtraData = t.b(jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA));
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        t.a(jSONObject, PrefetchEvent.EVENT_DATA_EXTRA_DATA, t.a(this.rewardCallbackExtraData));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @NonNull
    /* renamed from: clone */
    public SceneImpl m121clone() {
        String jSONObject = toJson().toString();
        try {
            SceneImpl sceneImpl = new SceneImpl();
            sceneImpl.parseJson(new JSONObject(jSONObject));
            return sceneImpl;
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.b(e2);
            return null;
        }
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
    public String getBackUrl() {
        return this.backUrl;
    }

    public String getBackUrl(KsScene ksScene) {
        if (ksScene == null) {
            return "";
        }
        try {
            return ksScene.getBackUrl();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getComment() {
        return this.mEcAttribute.getComment();
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
    public String getPromoteId() {
        return this.mEcAttribute.getPromoteId();
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
    public long getUserCommRateBuying() {
        return this.mEcAttribute.getUserCommRateBuying();
    }

    public long getUserCommRateBuying(KsScene ksScene) {
        if (ksScene == null) {
            return 0L;
        }
        try {
            return ksScene.getUserCommRateBuying();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public long getUserCommRateSharing() {
        return this.mEcAttribute.getUserCommRateSharing();
    }

    public long getUserCommRateSharing(KsScene ksScene) {
        if (ksScene == null) {
            return 0L;
        }
        try {
            return ksScene.getUserCommRateSharing();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getWidth() {
        return this.width;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void needShowMiniWindow(boolean z) {
        this.needShowMiniWindow = z;
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
    public void setBackUrl(String str) {
        this.backUrl = str;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setComment(String str) {
        this.mEcAttribute.setComment(str);
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setHeight(int i2) {
        this.height = i2;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setKsAdLabel(com.kwad.sdk.api.model.a aVar) {
        if (aVar == null) {
            return;
        }
        a aVar2 = new a();
        this.mKsAdLabel = aVar2;
        aVar2.a = aVar.a();
        this.mKsAdLabel.f57205b = aVar.b();
        this.mKsAdLabel.f57206c = aVar.c();
        this.mKsAdLabel.f57207d = aVar.d();
        this.mKsAdLabel.f57208e = aVar.e();
        this.mKsAdLabel.f57209f = aVar.f();
        this.mKsAdLabel.f57210g = aVar.g();
        this.mKsAdLabel.f57211h = aVar.h();
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setPosId(long j2) {
        this.posId = j2;
        this.entryScene = j2;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setPromoteId(String str) {
        this.mEcAttribute.setPromoteId(str);
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
    public void setUserCommRateBuying(int i2) {
        this.mEcAttribute.setUserCommRateBuying(i2);
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setUserCommRateSharing(int i2) {
        this.mEcAttribute.setUserCommRateSharing(i2);
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setWidth(int i2) {
        this.width = i2;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "posId", this.posId);
        t.a(jSONObject, "entryScene", this.entryScene);
        t.a(jSONObject, "adNum", this.adNum);
        t.a(jSONObject, "action", this.action);
        t.a(jSONObject, "width", this.width);
        t.a(jSONObject, "height", this.height);
        a aVar = this.mKsAdLabel;
        if (aVar != null) {
            long j2 = aVar.f57211h;
            if (j2 != 0) {
                t.a(jSONObject, "cpmBidFloor", j2);
            }
        }
        t.a(jSONObject, "adStyle", this.adStyle);
        t.a(jSONObject, "urlPackage", this.urlPackage);
        t.a(jSONObject, "promoteId", this.mEcAttribute.getPromoteId());
        t.a(jSONObject, "comment", this.mEcAttribute.getComment());
        t.a(jSONObject, "backUrl", this.backUrl);
        t.a(jSONObject, "userCommRateBuying", this.mEcAttribute.getUserCommRateBuying());
        t.a(jSONObject, "userCommRateSharing", this.mEcAttribute.getUserCommRateSharing());
        t.a(jSONObject, "screenOrientation", this.screenOrientation);
        return jSONObject;
    }
}
