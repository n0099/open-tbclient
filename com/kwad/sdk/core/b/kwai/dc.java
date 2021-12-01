package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class dc implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dc() {
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
    public void a(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, playEndInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        playEndInfo.type = jSONObject.optInt("type");
        playEndInfo.showLandingPage3 = jSONObject.optInt("showLandingPage3");
        AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo = new AdStyleInfo.PlayEndInfo.AdWebCardInfo();
        playEndInfo.adWebCardInfo = adWebCardInfo;
        adWebCardInfo.parseJson(jSONObject.optJSONObject("adWebCardInfo"));
        AdStyleInfo.PlayEndInfo.EndTopToolBarInfo endTopToolBarInfo = new AdStyleInfo.PlayEndInfo.EndTopToolBarInfo();
        playEndInfo.endTopToolBarInfo = endTopToolBarInfo;
        endTopToolBarInfo.parseJson(jSONObject.optJSONObject("endTopToolBarInfo"));
        AdStyleInfo.PlayEndInfo.HorizontalPatchAdInfo horizontalPatchAdInfo = new AdStyleInfo.PlayEndInfo.HorizontalPatchAdInfo();
        playEndInfo.horizontalPatchAdInfo = horizontalPatchAdInfo;
        horizontalPatchAdInfo.parseJson(jSONObject.optJSONObject("horizontalPatchAdInfo"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, playEndInfo, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "type", playEndInfo.type);
            com.kwad.sdk.utils.t.a(jSONObject, "showLandingPage3", playEndInfo.showLandingPage3);
            com.kwad.sdk.utils.t.a(jSONObject, "adWebCardInfo", playEndInfo.adWebCardInfo);
            com.kwad.sdk.utils.t.a(jSONObject, "endTopToolBarInfo", playEndInfo.endTopToolBarInfo);
            com.kwad.sdk.utils.t.a(jSONObject, "horizontalPatchAdInfo", playEndInfo.horizontalPatchAdInfo);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
