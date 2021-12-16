package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class HotspotFeedResultData extends BaseResultData implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TrendsResultData";
    public static final long serialVersionUID = -1619392774105464372L;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public List<AdTemplate> adTemplateList;
    public final HotspotInfo mHotspotInfo;
    public final SceneImpl mScene;

    public HotspotFeedResultData(@NonNull SceneImpl sceneImpl, @NonNull HotspotInfo hotspotInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sceneImpl, hotspotInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.adTemplateList = new ArrayList();
        this.mScene = sceneImpl;
        this.mHotspotInfo = hotspotInfo;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.parseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            e.a(jSONObject.optString("egid"));
            try {
                JSONObject jSONObject2 = new JSONObject(d.b(jSONObject.optString("data")));
                long optLong = jSONObject2.optLong("llsid");
                String optString = jSONObject2.optString("extra");
                JSONArray optJSONArray = jSONObject2.optJSONArray("feeds");
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    return;
                }
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        AdTemplate adTemplate = new AdTemplate();
                        adTemplate.parseJson(optJSONObject);
                        adTemplate.llsid = optLong;
                        adTemplate.extra = optString;
                        adTemplate.photoInfo.mHotspotInfo = this.mHotspotInfo;
                        adTemplate.mAdScene = this.mScene;
                        this.adTemplateList.add(adTemplate);
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject json = super.toJson();
            t.a(json, "impAdInfo", this.adTemplateList);
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
