package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class eq implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public eq() {
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
    public void a(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoPosition, jSONObject) == null) || jSONObject == null) {
            return;
        }
        videoPosition.leftMarginRation = jSONObject.optDouble("leftMarginRation");
        videoPosition.topMarginRation = jSONObject.optDouble("topMarginRation");
        videoPosition.widthRation = jSONObject.optDouble("widthRation");
        videoPosition.heightWidthRation = jSONObject.optDouble("heightWidthRation");
        videoPosition.leftMargin = jSONObject.optInt("leftMargin");
        videoPosition.topMargin = jSONObject.optInt("topMargin");
        videoPosition.width = jSONObject.optInt("width");
        videoPosition.height = jSONObject.optInt("height");
        videoPosition.borderRadius = jSONObject.optInt("borderRadius");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, videoPosition, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "leftMarginRation", videoPosition.leftMarginRation);
            com.kwad.sdk.utils.t.a(jSONObject, "topMarginRation", videoPosition.topMarginRation);
            com.kwad.sdk.utils.t.a(jSONObject, "widthRation", videoPosition.widthRation);
            com.kwad.sdk.utils.t.a(jSONObject, "heightWidthRation", videoPosition.heightWidthRation);
            com.kwad.sdk.utils.t.a(jSONObject, "leftMargin", videoPosition.leftMargin);
            com.kwad.sdk.utils.t.a(jSONObject, "topMargin", videoPosition.topMargin);
            com.kwad.sdk.utils.t.a(jSONObject, "width", videoPosition.width);
            com.kwad.sdk.utils.t.a(jSONObject, "height", videoPosition.height);
            com.kwad.sdk.utils.t.a(jSONObject, "borderRadius", videoPosition.borderRadius);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
