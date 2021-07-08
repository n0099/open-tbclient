package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AggregatePageEntranceInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class r implements com.kwad.sdk.core.d<AggregatePageEntranceInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public r() {
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
    public void a(AggregatePageEntranceInfo aggregatePageEntranceInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aggregatePageEntranceInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        aggregatePageEntranceInfo.aggregatePageEntranceButton = jSONObject.optString("aggregatePageEntranceButton", new String("更多推荐"));
        aggregatePageEntranceInfo.aggregatePageDesc = jSONObject.optString("aggregatePageDesc", new String("点击查看更多相关推荐"));
        aggregatePageEntranceInfo.aggregatePageEntranceDynamicNs = jSONObject.optInt("aggregatePageEntranceDynamicNs", new Integer("3").intValue());
        aggregatePageEntranceInfo.aggregatePageH5Url = jSONObject.optString("aggregatePageH5Url");
        aggregatePageEntranceInfo.aggregatePageBottomImageUrl = jSONObject.optString("aggregatePageBottomImageUrl");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AggregatePageEntranceInfo aggregatePageEntranceInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, aggregatePageEntranceInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "aggregatePageEntranceButton", aggregatePageEntranceInfo.aggregatePageEntranceButton);
            com.kwad.sdk.utils.q.a(jSONObject, "aggregatePageDesc", aggregatePageEntranceInfo.aggregatePageDesc);
            com.kwad.sdk.utils.q.a(jSONObject, "aggregatePageEntranceDynamicNs", aggregatePageEntranceInfo.aggregatePageEntranceDynamicNs);
            com.kwad.sdk.utils.q.a(jSONObject, "aggregatePageH5Url", aggregatePageEntranceInfo.aggregatePageH5Url);
            com.kwad.sdk.utils.q.a(jSONObject, "aggregatePageBottomImageUrl", aggregatePageEntranceInfo.aggregatePageBottomImageUrl);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
