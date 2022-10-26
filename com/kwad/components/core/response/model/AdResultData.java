package com.kwad.components.core.response.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AdResultData extends BaseResultData implements b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AdResultData";
    public static final long serialVersionUID = -818939163644825380L;
    public transient /* synthetic */ FieldHolder $fh;
    public List mAdTemplateList;
    public String mOriginalJson;
    public Map mRequestAdSceneMap;
    public PageInfo pageInfo;
    public String pcursor;

    public AdResultData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
    }

    public AdResultData(KsScene ksScene) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksScene};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
        if (ksScene != null) {
            HashMap hashMap = new HashMap(1);
            this.mRequestAdSceneMap = hashMap;
            hashMap.put(Long.valueOf(ksScene.getPosId()), (SceneImpl) ksScene);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdResultData(BaseResultData baseResultData, KsScene ksScene, List list) {
        this(ksScene);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseResultData, ksScene, list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((KsScene) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        super.parseJson(baseResultData.baseToJson());
        if (list != null) {
            getAdTemplateList().addAll(list);
        }
    }

    public AdResultData(List list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
        setRequestAdSceneList(list);
    }

    public static AdResultData createFromResponseJson(String str, SceneImpl sceneImpl) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, sceneImpl)) == null) {
            JSONObject jSONObject = new JSONObject(str);
            AdResultData adResultData = new AdResultData(sceneImpl);
            adResultData.parseJson(jSONObject);
            adResultData.mOriginalJson = str;
            return adResultData;
        }
        return (AdResultData) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public AdResultData m83clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AdResultData adResultData = new AdResultData();
            try {
                adResultData.parseJson(new JSONObject(toJson().toString()));
                return adResultData;
            } catch (JSONException e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                return adResultData;
            }
        }
        return (AdResultData) invokeV.objValue;
    }

    public SceneImpl getAdScene(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            Map map = this.mRequestAdSceneMap;
            SceneImpl sceneImpl = map != null ? (SceneImpl) map.get(Long.valueOf(j)) : null;
            return sceneImpl == null ? new SceneImpl(j) : sceneImpl;
        }
        return (SceneImpl) invokeJ.objValue;
    }

    public List getAdTemplateList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAdTemplateList : (List) invokeV.objValue;
    }

    public SceneImpl getDefaultAdScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getAdScene(getPosId()) : (SceneImpl) invokeV.objValue;
    }

    public AdTemplate getFirstAdTemplate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List adTemplateList = getAdTemplateList();
            if (adTemplateList == null || adTemplateList.size() == 0) {
                return null;
            }
            return (AdTemplate) adTemplateList.get(0);
        }
        return (AdTemplate) invokeV.objValue;
    }

    public long getPosId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List proceedTemplateList = getProceedTemplateList();
            if (proceedTemplateList.size() == 0) {
                return 0L;
            }
            return ((AdTemplate) proceedTemplateList.get(0)).posId;
        }
        return invokeV.longValue;
    }

    public List getProceedTemplateList() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List adTemplateList = getAdTemplateList();
            if (adTemplateList == null) {
                return arrayList;
            }
            int size = adTemplateList.size();
            int i2 = 0;
            while (i2 < size) {
                AdTemplate adTemplate = (AdTemplate) adTemplateList.get(i2);
                if (com.kwad.sdk.core.response.a.b.bx(adTemplate) && (i = i2 + 1) < size) {
                    AdTemplate adTemplate2 = (AdTemplate) adTemplateList.get(i);
                    adTemplate.mPlayAgain = adTemplate2;
                    adTemplate2.isPlayAgainData = true;
                    i2 = i;
                }
                arrayList.add(adTemplate);
                i2++;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public String getResponseJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public boolean isAdResultDataEmpty() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List adTemplateList = getAdTemplateList();
            if (adTemplateList.isEmpty()) {
                str = "adTemplateList is empty";
            } else {
                com.kwad.sdk.core.e.b.d(TAG, "adTemplateList size = " + adTemplateList.size());
                List list = ((AdTemplate) adTemplateList.get(0)).adInfoList;
                if (list.isEmpty()) {
                    str = "adInfoList is empty";
                } else if (((AdInfo) list.get(0)) != null) {
                    return false;
                } else {
                    str = "adInfo is null";
                }
            }
            com.kwad.sdk.core.e.b.e(TAG, str);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isBidding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            List proceedTemplateList = getProceedTemplateList();
            return proceedTemplateList.size() != 0 && com.kwad.sdk.core.response.a.d.cf((AdTemplate) proceedTemplateList.get(0)) > 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
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
    }

    public void setAdTemplateList(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            this.mAdTemplateList = list;
        }
    }

    public void setRequestAdSceneList(List list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, list) == null) || list == null) {
            return;
        }
        this.mRequestAdSceneMap = new HashMap(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            KsScene ksScene = (KsScene) it.next();
            if (ksScene != null) {
                this.mRequestAdSceneMap.put(Long.valueOf(ksScene.getPosId()), (SceneImpl) ksScene);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            JSONObject json = super.toJson();
            r.putValue(json, "pcursor", this.pcursor);
            r.a(json, "pageInfo", this.pageInfo);
            r.putValue(json, "impAdInfo", getAdTemplateList());
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
