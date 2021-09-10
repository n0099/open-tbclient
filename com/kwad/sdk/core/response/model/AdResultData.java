package com.kwad.sdk.core.response.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.b.e;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.f;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AdResultData extends BaseResultData implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AdResultData";
    public static final long serialVersionUID = -818939163644825380L;
    public transient /* synthetic */ FieldHolder $fh;
    public List<AdTemplate> adTemplateList;
    public a entryInfo;
    public Map<Long, SceneImpl> mRequestAdSceneMap;
    public PageInfo pageInfo;
    public String pcursor;

    public AdResultData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pageInfo = new PageInfo();
        this.adTemplateList = new ArrayList();
    }

    public AdResultData(KsScene ksScene) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksScene};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.pageInfo = new PageInfo();
        this.adTemplateList = new ArrayList();
        if (ksScene != null) {
            HashMap hashMap = new HashMap(1);
            this.mRequestAdSceneMap = hashMap;
            hashMap.put(Long.valueOf(ksScene.getPosId()), (SceneImpl) ksScene);
        }
    }

    public AdResultData(List<KsScene> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.pageInfo = new PageInfo();
        this.adTemplateList = new ArrayList();
        if (list != null) {
            this.mRequestAdSceneMap = new HashMap(list.size());
            for (KsScene ksScene : list) {
                if (ksScene != null) {
                    this.mRequestAdSceneMap.put(Long.valueOf(ksScene.getPosId()), (SceneImpl) ksScene);
                }
            }
        }
    }

    private SceneImpl getAdScene(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j2)) == null) {
            Map<Long, SceneImpl> map = this.mRequestAdSceneMap;
            SceneImpl sceneImpl = map != null ? map.get(Long.valueOf(j2)) : null;
            return sceneImpl == null ? new SceneImpl(j2) : sceneImpl;
        }
        return (SceneImpl) invokeJ.objValue;
    }

    public boolean isAdResultDataEmpty() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.adTemplateList.isEmpty()) {
                com.kwad.sdk.core.d.a.e(TAG, "adTemplateList is empty");
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            super.parseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            try {
                this.pcursor = jSONObject.optString("pcursor");
                e.a(jSONObject.optString("egid"));
                try {
                    String optString = jSONObject.optString("pageInfo");
                    if (!an.a(optString)) {
                        this.pageInfo.parseJson(new JSONObject(d.b(optString)));
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
                String b2 = d.b(jSONObject.optString("impAdInfo"));
                if (!an.a(b2)) {
                    JSONArray jSONArray = new JSONArray(b2);
                    if (jSONArray.length() > 0) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
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
                        if (!an.a(optString2)) {
                            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) f.a(DevelopMangerPlugin.class)).a("KEY_HOST_ENCRYPT_DISABLE");
                            if (a2 == null || !((Boolean) a2.getValue()).booleanValue()) {
                                String replaceAll = d.b(optString2).replaceAll("\\\\", "");
                                optJSONObject2 = new JSONObject(replaceAll.substring(1, replaceAll.length() - 1));
                            } else {
                                optJSONObject2 = new JSONObject(optString2);
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
                if (com.kwad.sdk.core.d.a.f71521a) {
                    com.kwad.sdk.core.d.a.a(TAG, toJson().toString());
                }
            } catch (Exception e4) {
                com.kwad.sdk.core.d.a.a(e4);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject json = super.toJson();
            q.a(json, "pcursor", this.pcursor);
            q.a(json, "pageInfo", this.pageInfo);
            q.a(json, "impAdInfo", this.adTemplateList);
            q.a(json, "entryInfo", this.entryInfo);
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
