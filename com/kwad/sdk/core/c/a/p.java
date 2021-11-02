package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class p implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo.AdWebCardInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public p() {
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
    public void a(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adWebCardInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        adWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        adWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        adWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        adWebCardInfo.cardData = jSONObject.optString("cardData");
        adWebCardInfo.cardShowPlayCount = jSONObject.optInt("cardShowPlayCount");
        adWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
        adWebCardInfo.cardDelayTime = jSONObject.optLong("cardDelayTime");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, adWebCardInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "typeLandscape", adWebCardInfo.typeLandscape);
            com.kwad.sdk.utils.q.a(jSONObject, "typePortrait", adWebCardInfo.typePortrait);
            com.kwad.sdk.utils.q.a(jSONObject, "cardUrl", adWebCardInfo.cardUrl);
            com.kwad.sdk.utils.q.a(jSONObject, "cardData", adWebCardInfo.cardData);
            com.kwad.sdk.utils.q.a(jSONObject, "cardShowPlayCount", adWebCardInfo.cardShowPlayCount);
            com.kwad.sdk.utils.q.a(jSONObject, "cardShowTime", adWebCardInfo.cardShowTime);
            com.kwad.sdk.utils.q.a(jSONObject, "cardDelayTime", adWebCardInfo.cardDelayTime);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
