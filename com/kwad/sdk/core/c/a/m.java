package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class m implements com.kwad.sdk.core.c<AdInfo.DownloadSafeInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m() {
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
    public JSONObject a(AdInfo.DownloadSafeInfo downloadSafeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadSafeInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "permissionInfo", downloadSafeInfo.permissionInfo);
            com.kwad.sdk.utils.o.a(jSONObject, "appPrivacyUrl", downloadSafeInfo.appPrivacyUrl);
            com.kwad.sdk.utils.o.a(jSONObject, "windowPopType", downloadSafeInfo.windowPopType);
            com.kwad.sdk.utils.o.a(jSONObject, "downloadPauseEnable", downloadSafeInfo.downloadPauseEnable);
            com.kwad.sdk.utils.o.a(jSONObject, "windowPopUrl", downloadSafeInfo.windowPopUrl);
            com.kwad.sdk.utils.o.a(jSONObject, "webPageTipbarSwitch", downloadSafeInfo.webPageTipbarSwitch);
            com.kwad.sdk.utils.o.a(jSONObject, "webPageTipbarText", downloadSafeInfo.webPageTipbarText);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, downloadSafeInfo, jSONObject) == null) || jSONObject == null) {
            return;
        }
        downloadSafeInfo.permissionInfo = jSONObject.optString("permissionInfo");
        downloadSafeInfo.appPrivacyUrl = jSONObject.optString("appPrivacyUrl");
        downloadSafeInfo.windowPopType = jSONObject.optInt("windowPopType", new Integer("0").intValue());
        downloadSafeInfo.downloadPauseEnable = jSONObject.optBoolean("downloadPauseEnable", new Boolean("false").booleanValue());
        downloadSafeInfo.windowPopUrl = jSONObject.optString("windowPopUrl");
        downloadSafeInfo.webPageTipbarSwitch = jSONObject.optBoolean("webPageTipbarSwitch", new Boolean("false").booleanValue());
        downloadSafeInfo.webPageTipbarText = jSONObject.optString("webPageTipbarText");
    }
}
