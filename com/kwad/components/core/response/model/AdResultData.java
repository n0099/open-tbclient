package com.kwad.components.core.response.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AdResultData extends BaseResultData implements b {
    public static final String TAG = "AdResultData";
    public static final long serialVersionUID = -818939163644825380L;
    public List<AdTemplate> mAdTemplateList;
    @Nullable
    public String mOriginalJson;
    public Map<Long, SceneImpl> mRequestAdSceneMap;
    public PageInfo pageInfo;
    public String pcursor;

    public AdResultData() {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
    }

    public AdResultData(KsScene ksScene) {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
        if (ksScene != null) {
            HashMap hashMap = new HashMap(1);
            this.mRequestAdSceneMap = hashMap;
            hashMap.put(Long.valueOf(ksScene.getPosId()), (SceneImpl) ksScene);
        }
    }

    public AdResultData(BaseResultData baseResultData, KsScene ksScene, List<AdTemplate> list) {
        this(ksScene);
        super.parseJson(baseResultData.baseToJson());
        if (list != null) {
            getAdTemplateList().addAll(list);
        }
    }

    public AdResultData(List<KsScene> list) {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
        setRequestAdSceneList(list);
    }

    public static AdResultData createFromResponseJson(String str, SceneImpl sceneImpl) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(sceneImpl);
        adResultData.parseJson(jSONObject);
        adResultData.mOriginalJson = str;
        return adResultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @NonNull
    /* renamed from: clone */
    public AdResultData m174clone() {
        AdResultData adResultData = new AdResultData();
        try {
            adResultData.parseJson(new JSONObject(toJson().toString()));
            return adResultData;
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return adResultData;
        }
    }

    public SceneImpl getAdScene(long j) {
        Map<Long, SceneImpl> map = this.mRequestAdSceneMap;
        SceneImpl sceneImpl = map != null ? map.get(Long.valueOf(j)) : null;
        return sceneImpl == null ? new SceneImpl(j) : sceneImpl;
    }

    public List<AdTemplate> getAdTemplateList() {
        return this.mAdTemplateList;
    }

    public SceneImpl getDefaultAdScene() {
        return getAdScene(getPosId());
    }

    public AdTemplate getFirstAdTemplate() {
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList == null || adTemplateList.size() == 0) {
            return null;
        }
        return adTemplateList.get(0);
    }

    public long getPosId() {
        List<AdTemplate> proceedTemplateList = getProceedTemplateList();
        if (proceedTemplateList.size() == 0) {
            return 0L;
        }
        return proceedTemplateList.get(0).posId;
    }

    @NonNull
    public List<AdTemplate> getProceedTemplateList() {
        int i;
        ArrayList arrayList = new ArrayList();
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList == null) {
            return arrayList;
        }
        int size = adTemplateList.size();
        int i2 = 0;
        while (i2 < size) {
            AdTemplate adTemplate = adTemplateList.get(i2);
            if (com.kwad.sdk.core.response.a.b.bx(adTemplate) && (i = i2 + 1) < size) {
                AdTemplate adTemplate2 = adTemplateList.get(i);
                adTemplate.mPlayAgain = adTemplate2;
                adTemplate2.isPlayAgainData = true;
                i2 = i;
            }
            arrayList.add(adTemplate);
            i2++;
        }
        return arrayList;
    }

    public String getResponseJson() {
        String str = this.mOriginalJson;
        if (str != null) {
            return str;
        }
        JSONObject json = super.toJson();
        r.putValue(json, "pcursor", this.pcursor);
        r.a(json, "pageInfo", this.pageInfo);
        r.putValue(json, "impAdInfo", d.bM(r.B(getAdTemplateList()).toString()));
        return json.toString();
    }

    public boolean isAdResultDataEmpty() {
        String str;
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList.isEmpty()) {
            str = "adTemplateList is empty";
        } else {
            com.kwad.sdk.core.e.b.d(TAG, "adTemplateList size = " + adTemplateList.size());
            List<AdInfo> list = adTemplateList.get(0).adInfoList;
            if (list.isEmpty()) {
                str = "adInfoList is empty";
            } else if (list.get(0) != null) {
                return false;
            } else {
                str = "adInfo is null";
            }
        }
        com.kwad.sdk.core.e.b.e(TAG, str);
        return true;
    }

    public boolean isBidding() {
        List<AdTemplate> proceedTemplateList = getProceedTemplateList();
        return proceedTemplateList.size() != 0 && com.kwad.sdk.core.response.a.d.cf(proceedTemplateList.get(0)) > 0;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        return false;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.pcursor = jSONObject.optString("pcursor");
            try {
                String optString = jSONObject.optString("pageInfo");
                if (!ax.dT(optString)) {
                    this.pageInfo.parseJson(new JSONObject(d.getResponseData(optString)));
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.d("json bug", e.toString());
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
            String optString2 = jSONObject.optString("impAdInfo");
            if (!TextUtils.isEmpty(optString2)) {
                String responseData = d.getResponseData(optString2);
                if (!ax.dT(responseData)) {
                    try {
                        JSONArray jSONArray = new JSONArray(responseData);
                        if (jSONArray.length() > 0) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                                if (optJSONObject != null) {
                                    AdTemplate adTemplate = new AdTemplate();
                                    adTemplate.parseJson(optJSONObject);
                                    adTemplate.llsid = this.llsid;
                                    adTemplate.extra = this.extra;
                                    adTemplate.mAdScene = getAdScene(adTemplate.posId);
                                    adTemplate.mPageInfo = this.pageInfo;
                                    this.mAdTemplateList.add(adTemplate);
                                }
                            }
                        }
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.e.b.printStackTraceOnly(e2);
                    }
                }
            }
            if (com.kwad.sdk.core.e.b.XL) {
                com.kwad.sdk.core.e.b.d(TAG, toJson().toString());
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.e.b.printStackTrace(e3);
            com.kwad.sdk.core.e.b.d("json bug", e3.toString());
        }
    }

    public void setAdTemplateList(List<AdTemplate> list) {
        this.mAdTemplateList = list;
    }

    public void setRequestAdSceneList(List<KsScene> list) {
        if (list != null) {
            this.mRequestAdSceneMap = new HashMap(list.size());
            for (KsScene ksScene : list) {
                if (ksScene != null) {
                    this.mRequestAdSceneMap.put(Long.valueOf(ksScene.getPosId()), (SceneImpl) ksScene);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        r.putValue(json, "pcursor", this.pcursor);
        r.a(json, "pageInfo", this.pageInfo);
        r.putValue(json, "impAdInfo", getAdTemplateList());
        return json;
    }
}
