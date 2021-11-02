package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.HotspotInfo;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class av implements com.kwad.sdk.core.d<HotspotInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public av() {
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
    public void a(HotspotInfo hotspotInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hotspotInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        hotspotInfo.trendId = jSONObject.optLong(URLPackage.KEY_TREND_ID);
        hotspotInfo.name = jSONObject.optString("name");
        hotspotInfo.viewCount = jSONObject.optLong("viewCount");
        hotspotInfo.offlineTime = jSONObject.optLong("offlineTime");
        hotspotInfo.photoCount = jSONObject.optInt("photoCount");
        hotspotInfo.coverUrl = jSONObject.optString("coverUrl");
        hotspotInfo.iconUrl = jSONObject.optString("iconUrl");
        hotspotInfo.rank = jSONObject.optInt("rank");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(HotspotInfo hotspotInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, hotspotInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, URLPackage.KEY_TREND_ID, hotspotInfo.trendId);
            com.kwad.sdk.utils.q.a(jSONObject, "name", hotspotInfo.name);
            com.kwad.sdk.utils.q.a(jSONObject, "viewCount", hotspotInfo.viewCount);
            com.kwad.sdk.utils.q.a(jSONObject, "offlineTime", hotspotInfo.offlineTime);
            com.kwad.sdk.utils.q.a(jSONObject, "photoCount", hotspotInfo.photoCount);
            com.kwad.sdk.utils.q.a(jSONObject, "coverUrl", hotspotInfo.coverUrl);
            com.kwad.sdk.utils.q.a(jSONObject, "iconUrl", hotspotInfo.iconUrl);
            com.kwad.sdk.utils.q.a(jSONObject, "rank", hotspotInfo.rank);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
