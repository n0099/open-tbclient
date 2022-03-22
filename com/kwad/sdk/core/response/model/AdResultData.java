package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.f;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AdResultData extends BaseResultData implements com.kwad.sdk.core.b {
    public static final String TAG = "AdResultData";
    public static final long serialVersionUID = -818939163644825380L;
    public a entryInfo;
    public Map<Long, SceneImpl> mRequestAdSceneMap;
    public String pcursor;
    public PageInfo pageInfo = new PageInfo();
    public List<AdTemplate> adTemplateList = new ArrayList();

    public AdResultData() {
    }

    public AdResultData(KsScene ksScene) {
        if (ksScene != null) {
            HashMap hashMap = new HashMap(1);
            this.mRequestAdSceneMap = hashMap;
            hashMap.put(Long.valueOf(ksScene.getPosId()), (SceneImpl) ksScene);
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
        Map<Long, SceneImpl> map = this.mRequestAdSceneMap;
        SceneImpl sceneImpl = map != null ? map.get(Long.valueOf(j)) : null;
        return sceneImpl == null ? new SceneImpl(j) : sceneImpl;
    }

    public boolean isAdResultDataEmpty() {
        String str;
        if (this.adTemplateList.isEmpty()) {
            str = "adTemplateList is empty";
        } else {
            com.kwad.sdk.core.d.a.a(TAG, "adTemplateList size = " + this.adTemplateList.size());
            List<AdInfo> list = this.adTemplateList.get(0).adInfoList;
            if (list.isEmpty()) {
                str = "adInfoList is empty";
            } else if (list.get(0) != null) {
                return false;
            } else {
                str = "adInfo is null";
            }
        }
        com.kwad.sdk.core.d.a.e(TAG, str);
        return true;
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
            e.a(jSONObject.optString("egid"));
            try {
                String optString = jSONObject.optString("pageInfo");
                if (!at.a(optString)) {
                    this.pageInfo.parseJson(new JSONObject(d.b(optString)));
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a("json bug", e2.toString());
                com.kwad.sdk.core.d.a.a(e2);
            }
            String optString2 = jSONObject.optString("impAdInfo");
            if (!TextUtils.isEmpty(optString2)) {
                String b2 = d.b(optString2);
                if (!at.a(b2)) {
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
            }
            try {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("entryInfo");
                if (optJSONObject2 == null) {
                    String optString3 = jSONObject.optString("entryInfo");
                    if (!at.a(optString3)) {
                        DevelopMangerPlugin.DevelopValue a = ((DevelopMangerPlugin) f.a(DevelopMangerPlugin.class)).a("KEY_HOST_ENCRYPT_DISABLE");
                        if (a == null || !((Boolean) a.getValue()).booleanValue()) {
                            String replaceAll = d.b(optString3).replaceAll("\\\\", "");
                            optJSONObject2 = new JSONObject(replaceAll.substring(1, replaceAll.length() - 1));
                        } else {
                            optJSONObject2 = new JSONObject(optString3);
                        }
                    }
                }
                if (optJSONObject2 != null) {
                    a aVar = new a();
                    this.entryInfo = aVar;
                    aVar.parseJson(optJSONObject2);
                    this.entryInfo.k = this.adTemplateList;
                }
            } catch (Exception e3) {
                com.kwad.sdk.core.d.a.a(e3);
            }
            if (com.kwad.sdk.core.d.a.a) {
                com.kwad.sdk.core.d.a.a(TAG, toJson().toString());
            }
        } catch (Exception e4) {
            com.kwad.sdk.core.d.a.a(e4);
            com.kwad.sdk.core.d.a.a("json bug", e4.toString());
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.a(json, "pcursor", this.pcursor);
        t.a(json, "pageInfo", this.pageInfo);
        t.a(json, "impAdInfo", this.adTemplateList);
        t.a(json, "entryInfo", this.entryInfo);
        return json;
    }
}
