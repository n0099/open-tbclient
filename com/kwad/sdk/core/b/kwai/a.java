package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.ABParams;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements com.kwad.sdk.core.d<ABParams> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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
    public void a(ABParams aBParams, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aBParams, jSONObject) == null) || jSONObject == null) {
            return;
        }
        aBParams.videoBlackAreaClick = jSONObject.optInt("videoBlackAreaClick");
        aBParams.videoBlackAreaNewStyle = jSONObject.optInt("videoBlackAreaNewStyle");
        aBParams.drawActionBarTimes = jSONObject.optString("drawActionBarTimes");
        if (jSONObject.opt("drawActionBarTimes") == JSONObject.NULL) {
            aBParams.drawActionBarTimes = "";
        }
        aBParams.showVideoAtH5 = jSONObject.optInt("showVideoAtH5");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(ABParams aBParams, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, aBParams, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "videoBlackAreaClick", aBParams.videoBlackAreaClick);
            com.kwad.sdk.utils.t.a(jSONObject, "videoBlackAreaNewStyle", aBParams.videoBlackAreaNewStyle);
            com.kwad.sdk.utils.t.a(jSONObject, "drawActionBarTimes", aBParams.drawActionBarTimes);
            com.kwad.sdk.utils.t.a(jSONObject, "showVideoAtH5", aBParams.showVideoAtH5);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
