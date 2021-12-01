package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.HotspotInfo;
import com.kwad.sdk.core.response.model.HotspotListData;
import com.kwad.sdk.core.response.model.TabInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bw implements com.kwad.sdk.core.d<HotspotListData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bw() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(HotspotListData hotspotListData, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hotspotListData, jSONObject) == null) || jSONObject == null) {
            return;
        }
        hotspotListData.trends = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("trends");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                HotspotInfo hotspotInfo = new HotspotInfo();
                hotspotInfo.parseJson(optJSONArray.optJSONObject(i2));
                hotspotListData.trends.add(hotspotInfo);
            }
        }
        hotspotListData.tabList = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("tabList");
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                TabInfo tabInfo = new TabInfo();
                tabInfo.parseJson(optJSONArray2.optJSONObject(i3));
                hotspotListData.tabList.add(tabInfo);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(HotspotListData hotspotListData, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, hotspotListData, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "trends", hotspotListData.trends);
            com.kwad.sdk.utils.t.a(jSONObject, "tabList", hotspotListData.tabList);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
