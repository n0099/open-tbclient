package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class af implements com.kwad.sdk.core.c<WebCardVideoPositionHandler.VideoPosition> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public af() {
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
    @Override // com.kwad.sdk.core.c
    public JSONObject a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoPosition)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "leftMarginRation", videoPosition.leftMarginRation);
            com.kwad.sdk.utils.o.a(jSONObject, "topMarginRation", videoPosition.topMarginRation);
            com.kwad.sdk.utils.o.a(jSONObject, "widthRation", videoPosition.widthRation);
            com.kwad.sdk.utils.o.a(jSONObject, "heightWidthRation", videoPosition.heightWidthRation);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(WebCardVideoPositionHandler.VideoPosition videoPosition, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, videoPosition, jSONObject) == null) || jSONObject == null) {
            return;
        }
        videoPosition.leftMarginRation = jSONObject.optDouble("leftMarginRation");
        videoPosition.topMarginRation = jSONObject.optDouble("topMarginRation");
        videoPosition.widthRation = jSONObject.optDouble("widthRation");
        videoPosition.heightWidthRation = jSONObject.optDouble("heightWidthRation");
    }
}
