package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.live.mode.LiveInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ci implements com.kwad.sdk.core.d<LiveInfo.LiveStreamPlayCDNNode> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ci() {
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
    public void a(LiveInfo.LiveStreamPlayCDNNode liveStreamPlayCDNNode, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveStreamPlayCDNNode, jSONObject) == null) || jSONObject == null) {
            return;
        }
        liveStreamPlayCDNNode.cdn = jSONObject.optString("cdn");
        if (jSONObject.opt("cdn") == JSONObject.NULL) {
            liveStreamPlayCDNNode.cdn = "";
        }
        liveStreamPlayCDNNode.url = jSONObject.optString("url");
        if (jSONObject.opt("url") == JSONObject.NULL) {
            liveStreamPlayCDNNode.url = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(LiveInfo.LiveStreamPlayCDNNode liveStreamPlayCDNNode, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, liveStreamPlayCDNNode, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "cdn", liveStreamPlayCDNNode.cdn);
            com.kwad.sdk.utils.t.a(jSONObject, "url", liveStreamPlayCDNNode.url);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
