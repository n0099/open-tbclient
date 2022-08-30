package com.kwad.sdk.internal.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.IKsAdLabel;
import com.kwad.sdk.api.model.SplashAdExtraData;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.r;
import com.kwad.sdk.utils.s;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@KsJson
/* loaded from: classes7.dex */
public class SceneImpl extends com.kwad.sdk.core.response.kwai.a implements KsScene, Serializable, Cloneable {
    public static final long serialVersionUID = 93865491903408451L;
    public int action;
    public int adNum;
    public int adStyle;
    public String backUrl;
    public String bidResponse;
    public String bidResponseV2;
    public long entryScene;
    public int height;
    public final EcAttribute mEcAttribute;
    public transient a mKsAdLabel;
    public boolean needShowMiniWindow;
    public long posId;
    public Map<String, String> rewardCallbackExtraData;
    public int screenOrientation;
    public b splashExtraData;
    public URLPackage urlPackage;
    public int width;

    public SceneImpl() {
        this.adNum = 1;
        this.screenOrientation = 0;
        this.needShowMiniWindow = false;
        this.mEcAttribute = new EcAttribute();
    }

    public SceneImpl(long j) {
        this.adNum = 1;
        this.screenOrientation = 0;
        this.needShowMiniWindow = false;
        this.mEcAttribute = new EcAttribute();
        this.posId = j;
        this.entryScene = j;
        if (ba.getPosId() != 0) {
            this.posId = ba.getPosId();
        }
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
        if (ba.getPosId() != 0) {
            this.posId = ba.getPosId();
        }
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
        this.rewardCallbackExtraData = s.parseJSON2MapString(jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA));
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        s.putValue(jSONObject, PrefetchEvent.EVENT_DATA_EXTRA_DATA, s.parseMap2JSON(this.rewardCallbackExtraData));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @NonNull
    /* renamed from: clone */
    public SceneImpl m84clone() {
        String jSONObject = toJson().toString();
        try {
            SceneImpl sceneImpl = new SceneImpl();
            sceneImpl.parseJson(new JSONObject(jSONObject));
            return sceneImpl;
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return new SceneImpl();
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
    public String getBidResponse() {
        return this.bidResponse;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getBidResponseV2() {
        return this.bidResponseV2;
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
    public void setAction(int i) {
        this.action = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdNum(int i) {
        this.adNum = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdStyle(int i) {
        this.adStyle = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setBackUrl(String str) {
        this.backUrl = str;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setBidResponse(String str) {
        this.bidResponse = str;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setBidResponseV2(String str) {
        this.bidResponseV2 = str;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setComment(String str) {
        this.mEcAttribute.setComment(str);
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setHeight(int i) {
        this.height = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setKsAdLabel(IKsAdLabel iKsAdLabel) {
        if (iKsAdLabel == null) {
            return;
        }
        a aVar = new a();
        this.mKsAdLabel = aVar;
        aVar.acZ = iKsAdLabel.getThirdAge();
        this.mKsAdLabel.ada = iKsAdLabel.getThirdGender();
        this.mKsAdLabel.adb = iKsAdLabel.getThirdInterest();
        this.mKsAdLabel.aiz = iKsAdLabel.getPrevTitle();
        this.mKsAdLabel.aiA = iKsAdLabel.getPostTitle();
        this.mKsAdLabel.aiB = iKsAdLabel.getHistoryTitle();
        this.mKsAdLabel.agM = iKsAdLabel.getChannel();
        this.mKsAdLabel.aiC = iKsAdLabel.getCpmBidFloor();
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setPosId(long j) {
        this.posId = j;
        this.entryScene = j;
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
    public void setScreenOrientation(int i) {
        this.screenOrientation = i;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setSplashExtraData(SplashAdExtraData splashAdExtraData) {
        if (splashAdExtraData == null) {
            return;
        }
        b bVar = new b();
        this.splashExtraData = bVar;
        bVar.disableShake = splashAdExtraData.getDisableShakeStatus();
        this.splashExtraData.disableSlide = splashAdExtraData.getDisableSlideStatus();
        this.splashExtraData.disableRotate = splashAdExtraData.getDisableRotateStatus();
    }

    public void setUrlPackage(URLPackage uRLPackage) {
        this.urlPackage = uRLPackage;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setUserCommRateBuying(int i) {
        this.mEcAttribute.setUserCommRateBuying(i);
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setUserCommRateSharing(int i) {
        this.mEcAttribute.setUserCommRateSharing(i);
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setWidth(int i) {
        this.width = i;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.putValue(jSONObject, "posId", this.posId);
        s.putValue(jSONObject, "entryScene", this.entryScene);
        s.putValue(jSONObject, "adNum", this.adNum);
        s.putValue(jSONObject, "action", this.action);
        s.putValue(jSONObject, "width", this.width);
        s.putValue(jSONObject, "height", this.height);
        a aVar = this.mKsAdLabel;
        if (aVar != null) {
            long j = aVar.aiC;
            if (j != 0) {
                r.putValue(jSONObject, "cpmBidFloor", j);
            }
        }
        s.putValue(jSONObject, "adStyle", this.adStyle);
        URLPackage uRLPackage = this.urlPackage;
        if (uRLPackage != null) {
            s.putValue(jSONObject, "urlPackage", uRLPackage.toJson());
        }
        s.putValue(jSONObject, "promoteId", this.mEcAttribute.getPromoteId());
        s.putValue(jSONObject, "comment", this.mEcAttribute.getComment());
        s.putValue(jSONObject, "backUrl", this.backUrl);
        s.putValue(jSONObject, "userCommRateBuying", this.mEcAttribute.getUserCommRateBuying());
        s.putValue(jSONObject, "userCommRateSharing", this.mEcAttribute.getUserCommRateSharing());
        s.putValue(jSONObject, "screenOrientation", this.screenOrientation);
        return jSONObject;
    }
}
