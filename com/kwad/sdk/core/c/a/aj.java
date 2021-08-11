package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class aj implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailWebCardInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public aj() {
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
    public void a(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, detailWebCardInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        detailWebCardInfo.style = jSONObject.optInt("style");
        detailWebCardInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
        detailWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        detailWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        detailWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        detailWebCardInfo.cardData = jSONObject.optString("cardData");
        detailWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, detailWebCardInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "style", detailWebCardInfo.style);
            com.kwad.sdk.utils.q.a(jSONObject, "maxTimeOut", detailWebCardInfo.maxTimeOut);
            com.kwad.sdk.utils.q.a(jSONObject, "typeLandscape", detailWebCardInfo.typeLandscape);
            com.kwad.sdk.utils.q.a(jSONObject, "typePortrait", detailWebCardInfo.typePortrait);
            com.kwad.sdk.utils.q.a(jSONObject, "cardUrl", detailWebCardInfo.cardUrl);
            com.kwad.sdk.utils.q.a(jSONObject, "cardData", detailWebCardInfo.cardData);
            com.kwad.sdk.utils.q.a(jSONObject, "cardShowTime", detailWebCardInfo.cardShowTime);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
