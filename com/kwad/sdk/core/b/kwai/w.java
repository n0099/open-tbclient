package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class w implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo.AdWebCardInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public w() {
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
        if (jSONObject.opt("cardUrl") == JSONObject.NULL) {
            adWebCardInfo.cardUrl = "";
        }
        adWebCardInfo.cardData = jSONObject.optString("cardData");
        if (jSONObject.opt("cardData") == JSONObject.NULL) {
            adWebCardInfo.cardData = "";
        }
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
            com.kwad.sdk.utils.t.a(jSONObject, "typeLandscape", adWebCardInfo.typeLandscape);
            com.kwad.sdk.utils.t.a(jSONObject, "typePortrait", adWebCardInfo.typePortrait);
            com.kwad.sdk.utils.t.a(jSONObject, "cardUrl", adWebCardInfo.cardUrl);
            com.kwad.sdk.utils.t.a(jSONObject, "cardData", adWebCardInfo.cardData);
            com.kwad.sdk.utils.t.a(jSONObject, "cardShowPlayCount", adWebCardInfo.cardShowPlayCount);
            com.kwad.sdk.utils.t.a(jSONObject, "cardShowTime", adWebCardInfo.cardShowTime);
            com.kwad.sdk.utils.t.a(jSONObject, "cardDelayTime", adWebCardInfo.cardDelayTime);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
