package com.kwad.sdk.core.response.model;

import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.b.e;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.g;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AdResultData extends BaseResultData implements com.kwad.sdk.core.b {
    private static final String TAG = "AdResultData";
    private static final long serialVersionUID = -818939163644825380L;
    public a entryInfo;
    private Map<Long, SceneImpl> mRequestAdSceneMap;
    public String pcursor;
    public PageInfo pageInfo = new PageInfo();
    public List<AdTemplate> adTemplateList = new ArrayList();

    public AdResultData() {
    }

    public AdResultData(KsScene ksScene) {
        if (ksScene != null) {
            this.mRequestAdSceneMap = new HashMap(1);
            this.mRequestAdSceneMap.put(Long.valueOf(ksScene.getPosId()), (SceneImpl) ksScene);
        }
    }

    public AdResultData(List<KsScene> list) {
        if (list != null) {
            this.mRequestAdSceneMap = new HashMap(list.size());
            for (KsScene ksScene : list) {
                if (ksScene != null) {
                    this.mRequestAdSceneMap.put(Long.valueOf(ksScene.getPosId()), (SceneImpl) ksScene);
                }
            }
        }
    }

    private SceneImpl getAdScene(long j) {
        SceneImpl sceneImpl = this.mRequestAdSceneMap != null ? this.mRequestAdSceneMap.get(Long.valueOf(j)) : null;
        return sceneImpl == null ? new SceneImpl(j) : sceneImpl;
    }

    public boolean isAdResultDataEmpty() {
        if (this.adTemplateList.isEmpty()) {
            com.kwad.sdk.core.d.a.d(TAG, "adTemplateList is empty");
            return true;
        }
        com.kwad.sdk.core.d.a.a(TAG, "adTemplateList size = " + this.adTemplateList.size());
        List<AdInfo> list = this.adTemplateList.get(0).adInfoList;
        if (list.isEmpty()) {
            com.kwad.sdk.core.d.a.d(TAG, "adInfoList is empty");
            return true;
        } else if (list.get(0) == null) {
            com.kwad.sdk.core.d.a.d(TAG, "adInfo is null");
            return true;
        } else {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        if (this.adTemplateList.isEmpty()) {
            com.kwad.sdk.core.d.a.d(TAG, "adTemplateList is empty");
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.pcursor = jSONObject.optString("pcursor");
            e.a(jSONObject.optString("egid"));
            try {
                String optString = jSONObject.optString("pageInfo");
                if (!ag.a(optString)) {
                    this.pageInfo.parseJson(new JSONObject(d.b(optString)));
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
            String b2 = d.b(jSONObject.optString("impAdInfo"));
            if (!ag.a(b2)) {
                JSONArray jSONArray = new JSONArray(b2);
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
                            this.adTemplateList.add(adTemplate);
                        }
                    }
                }
            }
            try {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("entryInfo");
                if (optJSONObject2 == null) {
                    String optString2 = jSONObject.optString("entryInfo");
                    if (!ag.a(optString2)) {
                        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) g.a(DevelopMangerPlugin.class)).a("KEY_HOST_ENCRYPT_DISABLE");
                        if (a2 == null || !((Boolean) a2.getValue()).booleanValue()) {
                            String replaceAll = d.b(optString2).replaceAll("\\\\", "");
                            optJSONObject2 = new JSONObject(replaceAll.substring(1, replaceAll.length() - 1));
                        } else {
                            optJSONObject2 = new JSONObject(optString2);
                        }
                    }
                }
                if (optJSONObject2 != null) {
                    this.entryInfo = new a();
                    this.entryInfo.a(optJSONObject2);
                    this.entryInfo.k = this.adTemplateList;
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            if (com.kwad.sdk.core.d.a.f9353a) {
                com.kwad.sdk.core.d.a.a(TAG, toJson().toString());
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.a(e3);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "pcursor", this.pcursor);
        o.a(json, "pageInfo", this.pageInfo);
        o.a(json, "impAdInfo", this.adTemplateList);
        o.a(json, "entryInfo", this.entryInfo);
        return json;
    }
}
